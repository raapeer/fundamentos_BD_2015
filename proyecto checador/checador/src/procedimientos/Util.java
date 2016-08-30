/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;
import com.griaule.grfingerjava.*;
import java.io.File;
import interfaz.PantallaPrincipal;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author EQUIPO 1
 */
public class Util implements IStatusEventListener, IImageEventListener, IFingerEventListener{
    /**Contexto utilizado para la captura, extracción y coincidencia de huellas digitales */
   private MatchingContext fingerprintSDK;

   /**Interfaz de usuario donde se muestra la imagen de la huella*/
   private PantallaPrincipal ui;
   //objeto de la clase donde se obtienen los formatos de la fecha y la hora respectivamente
   formatosfechahora formatos;

   /** Indica si la plantilla o template debe ser extraída automáticamente*/
   private boolean autoExtract = true;

   /** Contiene localmente los datos de la huella capturada */
   private ByteArrayInputStream fingerprintData;
   
   /**Contiene la longitud del dato de la huella*/
   private int fingerprintDataLength;
   
   /** La imagen de la última huella digital capturada. */
   private FingerprintImage fingerprint;
   
   /** La plantilla de la última imagen de huella capturada */
   public Template template;
   /**Conexión a la base de datos*/
   private Connection dbConnection;
   private Image data;
   boolean conectado = true;
   
   /**Consultas preparadas**/
   public PreparedStatement guardarStmt;
    private PreparedStatement identificarStmt;
    private PreparedStatement buscarfoto;
    private PreparedStatement mostrardatos;
    String clav = "";
    String clavep = "";
    String nombrep = "";
    Blob fotop = null;
   
   //////////CONSTRUCTOR\\\\\\\\\\\
   public Util(PantallaPrincipal ui) {
       this.ui = ui;
       formatos = new formatosfechahora();
       //Inicializa la conexión a la BD.
       initDB();      
}


   public void onSensorPlug(String idSensor) // evento que se genera al conectar el lector de huella
   {
        //Logs the sensor has been pluged.
       ui.writeLog("Lector "+idSensor+": Conectado.");
       try {
           //Start capturing from plugged sensor.
           GrFingerJava.startCapture(idSensor, this, this);
       } catch (GrFingerJavaException e) {
           //write error to log
           ui.writeLog(e.getMessage());
       }

   }

public void onSensorUnplug(String idSensor) // evento que se genera al desconectar el lector de huella
{
    //Logs the sensor has been unpluged.
       ui.writeLog("Lector "+idSensor+": Desconectado.");
       try {
           GrFingerJava.stopCapture(idSensor);
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
           ui.writeLog(e.getMessage());
       }
}
/**
    * Este método es llamado cada vez que la imagen de una huella ha sido capturada.    
    */
   public void onImageAcquired(String idSensor, FingerprintImage huellaDigital) {
       //Logs that an Image Event occurred.
       //ui.writeLog("Lector "+idSensor+": Imagen Capturada.");
       //Almacena la imagen de la huella
       this.fingerprint=huellaDigital;

       //Muestra la imagen obtenida
       ui.showImage(huellaDigital);       
       
       //Muestra la plantilla en la imagen actual
       extract();
}

public void onFingerDown(String idSensor) // evento que se genera al colocar un dedo en el lector
{
    // Just signals that a finger event ocurred.
       //ui.writeLog("Lector "+idSensor+": Dedo colocado.");
}
public void onFingerUp(String idSensor)   // evento que se genera al levantar el dedo del lector
{
    // Just signals that a finger event ocurred.
       //ui.writeLog("Lector "+idSensor+": Dedo removido.");
    //Cuando se levanta el dedo, identifico a quien pertenece esa huella digital
    ui.repintarp();
    if (conectado == true)
            identificarPersona();
}
/**
    * Establece el directorio donde se ubican las librerías nativas del SDK
    */
   public static void setFingerprintSDKNativeDirectory(String directorio) {
       File directory = new File(directorio);
       
       try {
           GrFingerJava.setNativeLibrariesDirectory(directory);
           GrFingerJava.setLicenseDirectory(directory);
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
           e.printStackTrace(); 
       }
   }
/**
    * Inicializa el Fingerprint SDK y habilita la captura de huellas.
    */
   public void inicializarCaptura() {
       try {
           fingerprintSDK = new MatchingContext();          
           //Inicializa la captura de huella digital.
           GrFingerJava.initializeCapture(this); 
           ui.writeLog("SDK de huella dactilar inicializado con éxito");
       } catch (Exception e) {
           Toolkit.getDefaultToolkit().beep();
           //Si ocurre un error se cierra la aplicación.
          //If any error ocurred while initializing GrFinger,
           //writes the error to log
           ui.writeLog(e.getMessage());
           //System.exit(1);
       }
   }
   
   /**
    * Inicializa la conexión a la base de datos y prepara las operaciones para insertar, 
    * eliminar y modificar los datos
    */
   private void initDB() {
       try {
           //Carga el driver ODBC
           Class.forName("com.mysql.jdbc.Driver");


           //Se conecta a la bd
           dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checador","isaac", "perez");
           ui.writeLog("Conexión a la base de datos realizada con éxito.");
           //Prepara las consultas/sentencias que se utilizarán
           guardarStmt     = dbConnection.prepareStatement("INSERT INTO checadas(id_empleado, fecha_checada, hora_checada) values(?,?,?)");
           identificarStmt   = dbConnection.prepareStatement("SELECT * FROM huellas");
           mostrardatos   = dbConnection.prepareStatement("SELECT " + " clave, " + " nombre, " + " foto " + "FROM empleados " + " where clave = ? ");
           buscarfoto   = dbConnection.prepareStatement("SELECT " + " foto " + " FROM empleados " + " where clave = ? ");        
       } catch (Exception e) {
           Toolkit.getDefaultToolkit().beep();
           ui.mostrarimgnoconectabd();
           ui.writeLog("Error, no se puede conectar a la base de datos.");
           ui.nosepuedeconectarbd();
           conectado = false;
       }
       
   }
   
   /**
    * Cierra la conexión a la base de datos y libera los recursos empleados.
    */
   private void destroyDB() {
       try {
           //Se cierran todas las sentencias
           identificarStmt.close();           
           //Cierra la conexión a la  base
           dbConnection.close();
           
       } catch (Exception e) {
           Toolkit.getDefaultToolkit().beep();
           //write error to log
           ui.writeLog(e.getMessage());
       }        
   }
/**
    * Extrae la plantilla de la imagen de la huella actual.
    */  
   public void extract() {
       
       try {
           //Extrae la plantilla de la imagen. 
           template = fingerprintSDK.extract(fingerprint);
           
           //Muestra la plantilla en la imagen
           ui.showImage(GrFingerJava.getBiometricImage(template,fingerprint));            
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
          //write error to log
           ui.writeLog("Error, no se pudo extraer la minucia, vuelva a intentarlo");
       }
       
   }
   
   /**
    * verifica la huella digital actual contra otra en la base de datos
    */
   public void identificarPersona() {
       try {
           //Obtiene todas las huellas de la bd
           ResultSet rsIdentificar = identificarStmt.executeQuery();
            
           //Si se encuentra la huella en la base de datos
           while(rsIdentificar.next()){
               //Lee la plantilla de la base de datos
               byte templateBuffer[] = rsIdentificar.getBytes("huellap");
               //Crea una nueva plantilla
               Template referenceTemplate = new Template(templateBuffer);
                
               //compara las plantilas (actual vs bd)
               boolean coinciden = fingerprintSDK.verify(template,referenceTemplate);
                
               //Si encuentra correspondencia dibuja el mapa 
               //e indica el nombre de la persona que coincidió.
               if (coinciden){                   
                   ui.showImage(GrFingerJava.getBiometricImage(template, fingerprint, fingerprintSDK));                                  
                   //Obtiene la clave de la persona propietaria de la huella que coincidio.
                   clavep = rsIdentificar.getString("id_emp");
                   //Mandamos a comparar la clave de la tabla huellas con la clave de los empleados dados de alta 
                  datoscoincidenconclave(clavep); 
                  return;
               }      
           } 
            
           //Si no encuentra alguna huella que coincida lo indica con un mensaje
           //JOptionPane.showMessageDialog(ui, "No existe ningún registro que coincida con la huella.");
            ui.mostrarnocoincidencia();
                
       } catch (SQLException e) {  
           initDB();
           identificarPersona();
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
          //write error to log
           ui.writeLog(e.getMessage());     
       }
   }
   public void datoscoincidenconclave(String id){
       try{
            mostrardatos.setString(1, id);
            ResultSet res = null;
            res = mostrardatos.executeQuery();
            while(res.next()){
               clav = res.getString("clave");
               nombrep = res.getString("nombre");
               fotop = res.getBlob("foto");
               
               if (fotop != null){
                   //Mandamos a traer la foto del empleado que checo, hacemos la correspondencia de acuerdo a su clave
                   Image dtCat = getfoto(id);
                   //dtCat = dtCat.getScaledInstance(144, 176, 1);
                   Icon icon = new ImageIcon(dtCat);
                   ui.mostrardatosenpantalla(clav, nombrep, icon);}
               else ui.mostdsinfoto(clavep, nombrep);
                   //Si los datos se mostraron sin problemas, entonces invocamos el metodo que obtiene la hora y la fecha en que se se llevo a cabo dicho evento
            obtenerfechayhorayguardarlas(clav);
            }    
        }catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
         //write error to log
           ui.writeLog(e.getMessage());  
    }
   }
   //metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado
// una imagen
 public Image getfoto(String id){  
           try{     
            buscarfoto.setString(1, id);
            ResultSet res = null;
            res = buscarfoto.executeQuery();
            //int i = 0;
            while(res.next()){
               //se lee la cadena de bytes de la base de datos
               byte[] b = res.getBytes("foto");
                    // esta cadena de bytes sera convertida en una imagen
                    data = ConvertirImagen(b);
               //i++;
            }
            res.close(); 
            } catch (IOException e) {
                Toolkit.getDefaultToolkit().beep();
            //write error to log
           ui.writeLog(e.getMessage());  
        }catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
         //write error to log
           ui.writeLog(e.getMessage());  
    }       
       return data;
 }
 
 //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
 private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis; // File or InputStream
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 } 
 public void obtenerfechayhorayguardarlas(String clv){
     String fecha =formatos.obtenerfecha();
      String hora =formatos.obtenerhora();
      try {
      guardarStmt.setString(1,clv);
      guardarStmt.setString(2,fecha);
      guardarStmt.setString(3,hora);
      guardarStmt.execute();
      } 
        catch (SQLException e) {
            Toolkit.getDefaultToolkit().beep();
                //write error to log
           ui.writeLog(e.getMessage());
        }
 }
  /**
    * Stops fingerprint capture and closes the database connection.
    */
   public void destroy() {
       destroyFingerprintSDK();
       //destroyDB();
   }
   /**
    * Stops fingerprint capture.
    */
   private void destroyFingerprintSDK() {
       try {
           GrFingerJava.finalizeCapture();
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
   }    
}