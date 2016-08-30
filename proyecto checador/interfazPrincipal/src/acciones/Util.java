/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;



import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mainInterfaz.Pantallaprincipal;
import com.griaule.grfingerjava.*;
import java.io.File;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yo
 */
public class Util implements IStatusEventListener, IImageEventListener, IFingerEventListener{
    Pantallaprincipal objpantprincipal;
    PreparedStatement guardararea;
    PreparedStatement guardartipoempleado;
    PreparedStatement guardardatosemple;
    PreparedStatement guardarhue;
    PreparedStatement guardarhuStmt;
    PreparedStatement guardardatosemplem;
    PreparedStatement guardardatosemplesf;
    PreparedStatement guardarareamod;
    PreparedStatement guardartipoempleadom;
    PreparedStatement guardarhorario;
    PreparedStatement guardardtsmodhor;
    PreparedStatement actclvadmin;
    PreparedStatement insclvadmin;
    PreparedStatement guardarchecada;
    PreparedStatement modificarhue;
    PreparedStatement modificarche;
    PreparedStatement identificarhue;
    PreparedStatement actpagohrext;
    PreparedStatement inspagohrextra;
    PreparedStatement guardarjustifi;
    PreparedStatement guardarjustimod;
    PreparedStatement guardardeduccion;
    Connection dbConnection;
    
    //////Objetos del lector de huellas\\\\\\
     /**Contexto utilizado para la captura, extracción y coincidencia de huellas digitales */
   private MatchingContext fingerprintSDK;
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
   
   boolean conectado = true;
   
    /////Constructor\\\\\
    public Util (Pantallaprincipal obj){
       this.objpantprincipal = obj;
       //Inicializa la conexión a la BD.
       initDB();  
    }
    
    public void onSensorPlug(String idSensor) // evento que se genera al conectar el lector de huella
   {
        //Logs the sensor has been pluged.
       objpantprincipal.writeLog("Lector "+idSensor+": Conectado.");
       try {
           //Start capturing from plugged sensor.
           GrFingerJava.startCapture(idSensor, this, this);
       } catch (GrFingerJavaException e) {
           //write error to log
           objpantprincipal.writeLog(e.getMessage());
       }
   }

public void onSensorUnplug(String idSensor) // evento que se genera al desconectar el lector de huella
{
    //Logs the sensor has been unpluged.
       objpantprincipal.writeLog("Lector "+idSensor+": Desconectado.");
       try {
           GrFingerJava.stopCapture(idSensor);
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
           objpantprincipal.writeLog(e.getMessage());
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
       objpantprincipal.showImage(huellaDigital);       
       
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
    objpantprincipal.repintarp();
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
           objpantprincipal.writeLog("**SDK de huella dactilar inicializado con éxito**");
       } catch (Exception e) {
           //Si ocurre un error se cierra la aplicación.
          //If any error ocurred while initializing GrFinger,
           //writes the error to log
           Toolkit.getDefaultToolkit().beep();
           objpantprincipal.writeLog(e.getMessage());
           //System.exit(1);
       }
   }
   
   /**
    * Extrae la plantilla de la imagen de la huella actual. 
    */  
   public void extract() {
       
       try {
           //Extrae la plantilla de la imagen. 
           template = fingerprintSDK.extract(fingerprint);
           
           //Notifies it has been extracted and the quality of the extraction
           //write template quality to log
           switch (template.getQuality()){
               case Template.HIGH_QUALITY: 
               objpantprincipal.pintaraltacalidad();
               break;
               case Template.MEDIUM_QUALITY: 
              objpantprincipal.pintarmedianacalidad();
               break;
               case Template.LOW_QUALITY: 
               objpantprincipal.pintarbajacalidad();
               break;
           }
           //Muestra la plantilla en la imagen
           objpantprincipal.showImage(GrFingerJava.getBiometricImage(template,fingerprint));
           objpantprincipal.writeLog("Minucias extraidas con éxito");
       } catch (GrFingerJavaException e) {
          //write error to log
           Toolkit.getDefaultToolkit().beep();
           objpantprincipal.writeLog("Error, no se pudieron extraer las minucias, vuelva a intentarlo");
       }
       
   }
   
      /**
    * verifica la huella digital actual contra otra en la base de datos
    */
   public void identificarPersona() {
       try {
           //Obtiene todas las huellas de la bd
           ResultSet rsIdentificar = identificarhue.executeQuery();
            
           //Si se encuentra la huella en la base de datos
           while(rsIdentificar.next()){
               //Lee la plantilla de la base de datos
               byte templateBuffer[] = rsIdentificar.getBytes("huellap");
               //Crea una nueva plantilla
               Template referenceTemplate = new Template(templateBuffer);
                
               //compara las plantilas (actual vs bd)
               boolean coinciden = fingerprintSDK.verify(template,referenceTemplate);
 
               //Si encuentra coincidencia entonces envia true y si no entonces envia false
               if (coinciden){                   
               objpantprincipal.coincidehuella(true);
               return;
               }
               else{
               objpantprincipal.coincidehuella(false);
               }
           } 
                
       } catch (SQLException e) {  
           initDB();
           identificarPersona();
       } catch (GrFingerJavaException e) {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
   }
   
    private void initDB() {
       try {
           //Carga el driver ODBC
           Class.forName("com.mysql.jdbc.Driver");
            //Se conecta a la bd
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checador","isaac", "perez");
            
           //JOptionPane.showMessageDialog(null,"Conexión a la base de datos realizada con éxito");
            //Prepara las consultas/sentencias que se utilizarán
            guardararea = dbConnection.prepareStatement("INSERT INTO area(clave_area, nombre_area) values(?, ?)");
            guardarjustifi = dbConnection.prepareStatement("INSERT INTO justificantes(clave_justificante, nombre_justificante) values(?, ?)");
            guardardeduccion = dbConnection.prepareStatement("INSERT INTO deduccionesgrales(clave_deduccion, nombre_deduccion, descuento) values(?, ?, ?)");
            guardartipoempleado = dbConnection.prepareStatement("INSERT INTO tipoempleados(clave_tipo, nombre_tipo, tipo_sueldo, sueldo_tipo) values(?, ?, ?, ?)");
            guardardatosemple = dbConnection.prepareStatement("INSERT INTO empleados(clave, nombre, direccion, email, telefono, foto, area_emp, tipo_emp, horario, estado) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            guardarhue     = dbConnection.prepareStatement("INSERT INTO huellas(id_emp, huellap) values(?, ?)");
            guardarhuStmt     = dbConnection.prepareStatement("INSERT INTO huellas(id_emp, huellap, dedo_capturado) values(?, ?, ?)");
            guardardatosemplem = dbConnection.prepareStatement("UPDATE empleados SET nombre = ?, direccion = ?, email = ?, telefono = ?, foto = ?, area_emp = ?, tipo_emp = ?, horario = ?, estado = ? " + " WHERE clave = ?");
            guardardatosemplesf = dbConnection.prepareStatement("UPDATE empleados SET nombre = ?, direccion = ?, email = ?, telefono = ?, area_emp = ?, tipo_emp = ?, horario = ?, estado = ? " + " WHERE clave = ?");
            guardarareamod = dbConnection.prepareStatement("UPDATE area SET nombre_area = ? " + " WHERE clave_area = ?");
            guardarjustimod = dbConnection.prepareStatement("UPDATE justificantes SET nombre_justificante = ? " + " WHERE clave_justificante = ?");
            guardartipoempleadom = dbConnection.prepareStatement("UPDATE tipoempleados SET nombre_tipo = ?, tipo_sueldo = ?, sueldo_tipo = ? " + " WHERE clave_tipo = ?");
            guardarhorario = dbConnection.prepareStatement("INSERT INTO horarios(clave_horario, nombre_horario, horaentdom, horasaldom, horaentlun, horasallun, horaentmar, horasalmar, horaentmie, horasalmie, horaentjue, horasaljue, horaentvie, horasalvie, horaentsab, horasalsab, thrsdehrio, toleraantentdia, toleradesentdia, toleraantsaldia, toleradessaldia) "
                                                           + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            guardardtsmodhor = dbConnection.prepareStatement("UPDATE horarios SET nombre_horario = ?, horaentdom = ?, horasaldom = ?, horaentlun = ?, horasallun = ?, "
                    + "horaentmar = ?, horasalmar = ?, horaentmie = ?, horasalmie = ?, horaentjue = ?, horasaljue = ?, horaentvie = ?, horasalvie = ?, horaentsab = ?, "
                    + "horasalsab = ?,  thrsdehrio = ?, toleraantentdia = ?, toleradesentdia = ?, toleraantsaldia = ?, toleradessaldia = ?" + " WHERE clave_horario = ? ");
            actclvadmin = dbConnection.prepareStatement("UPDATE administrador SET claveadmin = ?, indicio = ?");
            actpagohrext = dbConnection.prepareStatement("UPDATE horaextra SET pagohrextra = ?");
            insclvadmin = dbConnection.prepareStatement("INSERT INTO administrador (claveadmin, indicio) VALUES(?, ?)");
            inspagohrextra = dbConnection.prepareStatement("INSERT INTO horaextra (pagohrextra) VALUES(?)");
            guardarchecada = dbConnection.prepareStatement("INSERT INTO checadas (id_empleado, fecha_checada, hora_checada) VALUES(?, ?, ?)");
            modificarhue = dbConnection.prepareStatement("UPDATE huellas SET huellap = ?, dedo_capturado = ? WHERE id_emp = ? AND dedo_capturado = ?");
            modificarche = dbConnection.prepareStatement("UPDATE checadas SET fecha_checada = ?, hora_checada = ? WHERE numerochecada = ?");
            identificarhue   = dbConnection.prepareStatement("SELECT * FROM huellas");
       } catch (Exception e) {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"No se puede conectar a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
           conectado = false;
           System.exit(0);
       }
       
   }
    public void guardararea(int clvare, String nombrea){
           boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardararea.setInt(1,clvare);
            guardararea.setString(2,nombrea);
            //Ejecuta la sentencia
            guardararea.execute();
        } 
        catch (SQLException e) {
           error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"El área de trabajo se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardarea();
    }
     public void guardarjusti(int clvjust, String nombrej){
           boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardarjustifi.setInt(1,clvjust);
            guardarjustifi.setString(2,nombrej);
            //Ejecuta la sentencia
            guardarjustifi.execute();
        } 
        catch (SQLException e) {
           error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"El justificante se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsaltjus();
    }
     public void guardardeduccion(int clvdedu, String nombrededu, int descuentod){
           boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardardeduccion.setInt(1,clvdedu);
            guardardeduccion.setString(2,nombrededu);
            guardardeduccion.setInt(3,descuentod);
            //Ejecuta la sentencia
            guardardeduccion.execute();
        } 
        catch (SQLException e) {
           error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"La deducción general se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsaldedu();
    }
    public void guardardtsareamodi(String clvare, String nombrea){
           boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardarareamod.setString(1,nombrea);
            guardarareamod.setString(2,clvare);
            //Ejecuta la sentencia
            guardarareamod.execute();
        } 
        catch (SQLException e) {
           error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"El área de trabajo se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            //objpantprincipal.limpiardareamod();
    }
    public void guardardtsjustimodi(String clvjust, String nombrejust){
           boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardarjustimod.setString(1,nombrejust);
            guardarjustimod.setString(2,clvjust);
            //Ejecuta la sentencia
            guardarjustimod.execute();
        } 
        catch (SQLException e) {
           error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"El justificante se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            //objpantprincipal.limpiardareamod();
    }
    public void guardartipoempe(int clvtipo, String nombretip, String tiposu, int sueldotip){
        boolean error = false;
        try{
        guardartipoempleado.setInt(1, clvtipo);
        guardartipoempleado.setString(2, nombretip);
        guardartipoempleado.setString(3, tiposu);
        guardartipoempleado.setInt(4, sueldotip);
        guardartipoempleado.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"El tipo de empleado se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiartipoem();
    }
    public void actualizarclv(String contraadmin, String indicio){
        boolean error = false;
        try{
        actclvadmin.setString(1, contraadmin);
        actclvadmin.setString(2, indicio);
        actclvadmin.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"La clave del administrador se actualizo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsclv();
    }
     public void actualizarpahrex(int paghrextra){
        boolean error = false;
        try{
        actpagohrext.setInt(1, paghrextra);
        actpagohrext.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"El pago de la hora extra se actualizo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiartxtpagohrex();
    }
    
    public void modificarhuella(String fingerse, String clvemp, String fingeran){
        boolean error = false;
        //Obtiene los datos del template de la huella actual
           fingerprintData = new ByteArrayInputStream(template.getData());
           fingerprintDataLength = template.getData().length;
        try{
            modificarhue.setBinaryStream(1, fingerprintData, fingerprintDataLength);
            modificarhue.setString(2, fingerse);
            modificarhue.setString(3, clvemp);
            modificarhue.setString(4, fingeran);
            modificarhue.execute();
            }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, La huella no se pudo modificar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"La huella se modificó con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsclv();
        }
    
    public void insertarclv(String contraadmin, String indicio){
        boolean error = false;
        try{
        insclvadmin.setString(1, contraadmin);
        insclvadmin.setString(2, indicio);
        insclvadmin.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"La clave del administrador se actualizo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsclv();
    }
    public void insertarpahrex(int paghrext){
        boolean error = false;
        try{
        inspagohrextra.setInt(1, paghrext);
        inspagohrextra.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"El pago de la hora extra se actualizo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiartxtpagohrex();
    }
    public void guardarchec(String clvemp, String fechecada, String hrchecada){
        boolean error = false;
        try{
        guardarchecada.setString(1, clvemp);
        guardarchecada.setString(2, fechecada);
        guardarchecada.setString(3, hrchecada);
        guardarchecada.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, La checada no se pudo guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"La checada se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsche();
    }
     public void modificarchec(String fechecada, String hrchecada, String numerochec){
        boolean error = false;
        try{
        modificarche.setString(1, fechecada);
        modificarche.setString(2, hrchecada);
        modificarche.setString(3, numerochec);
        modificarche.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, La checada no se pudo modificar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"La checada se modifico con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            objpantprincipal.limpiardtsche();
    }
    public void guardarchecactivos(String clvemp, String fechecada, String hrchecada){
        try{
        guardarchecada.setString(1, clvemp);
        guardarchecada.setString(2, fechecada);
        guardarchecada.setString(3, hrchecada);
        guardarchecada.execute();
        }
        catch (SQLException e) {
           objpantprincipal.versiseguardaron(true);
        }
    }
        public void guardartipoempemod(String clvtipomod, String nombretipmod, String tiposumod, int sueldotipmod){
        boolean error = false;
        try{
        guardartipoempleadom.setString(1, nombretipmod);
        guardartipoempleadom.setString(2, tiposumod);
        guardartipoempleadom.setInt(3, sueldotipmod);
        guardartipoempleadom.setString(4, clvtipomod);
        guardartipoempleadom.execute();
        }
        catch (SQLException e) {
            error = true;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        } 
        if (error == false)
            JOptionPane.showMessageDialog(null,"El tipo de empleado se guardo con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            //objpantprincipal.limpiartipoemmod();
    }
    
    public void guardardtsempesinfoto(int clvempe, String nombreempe, String direccionempe, String emailempe, String telefonoempe, String claveareaempe, String clavetipoempe,String foto, String clvhorario, String vlrestado){
        boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardardatosemple.setInt(1, clvempe);
            guardardatosemple.setString(2,nombreempe);
            guardardatosemple.setString(3,direccionempe);
            guardardatosemple.setString(4,emailempe);
            guardardatosemple.setString(5,telefonoempe);
            guardardatosemple.setString(6,foto);
            guardardatosemple.setString(7,claveareaempe);
            guardardatosemple.setString(8,clavetipoempe);
            guardardatosemple.setString(9,clvhorario);
            guardardatosemple.setString(10,vlrestado);
            //Ejecuta la sentencia
            guardardatosemple.execute();
        } 
        catch (SQLException e) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del empleado se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        objpantprincipal.limpiardtsemple(); 
    }
        public void guardardtsempesinfotom(String cla,String nombreempe, String direccionempe, String emailempe, String telefonoempe, String claveareaempe, String clavetipoempe, String clavehora, String estad){
        boolean error = false;
            try {
            //Establece los valores para la sentencia SQL
            guardardatosemplesf.setString(1,nombreempe);
            guardardatosemplesf.setString(2,direccionempe);
            guardardatosemplesf.setString(3,emailempe);
            guardardatosemplesf.setString(4,telefonoempe);
            guardardatosemplesf.setString(5,claveareaempe);
            guardardatosemplesf.setString(6,clavetipoempe);
            guardardatosemplesf.setString(7,clavehora);
            guardardatosemplesf.setString(8,estad);
            guardardatosemplesf.setString(9, cla);
            //Ejecuta la sentencia
            guardardatosemplesf.execute();

        } catch (SQLException ex) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + ex.getMessage());
        }
            if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del empleado se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public void guardardtsempeconfoto(int clv, String nombree, String direccione, String emaile, String telefonoe, String claveareae, String clavetipoe, FileInputStream fileFoto, String clvhorario, String vlrestado)
    {
        boolean error = false;
        try {
                //Establece los valores para la sentencia SQL
            guardardatosemple.setInt(1,clv);
            guardardatosemple.setString(2,nombree);
            guardardatosemple.setString(3,direccione);
            guardardatosemple.setString(4,emaile);
            guardardatosemple.setString(5,telefonoe);
            guardardatosemple.setBinaryStream(6, fileFoto, fileFoto.available());
            guardardatosemple.setString(7,claveareae);
            guardardatosemple.setString(8,clavetipoe);
            guardardatosemple.setString(9,clvhorario);
            guardardatosemple.setString(10,vlrestado);
            //Ejecuta la sentencia
            guardardatosemple.execute();


        } catch (IOException ex) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + ex.getMessage());
        }
        catch (SQLException e) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del empleado se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
           objpantprincipal.limpiardtsemple(); 
    }
      public void guardardtsempeconfotom(String clv, String nombree, String direccione, String emaile, String telefonoe, String claveareae, String clavetipoe, FileInputStream fileFoto, String clavehor, String estad)
    {
        boolean error = false;
        try { 
            //Establece los valores para la sentencia SQL
            guardardatosemplem.setString(1,nombree);
            guardardatosemplem.setString(2,direccione);
            guardardatosemplem.setString(3,emaile);
            guardardatosemplem.setString(4,telefonoe);
            guardardatosemplem.setBinaryStream(5, fileFoto, fileFoto.available());
            guardardatosemplem.setString(6,claveareae);
            guardardatosemplem.setString(7,clavetipoe);
            guardardatosemplem.setString(8,clavehor);
            guardardatosemplem.setString(9,estad);
            guardardatosemplem.setString(10, clv);
            //Ejecuta la sentencia
            guardardatosemplem.execute();
        } catch (IOException ex) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + ex.getMessage());
        }
        catch (SQLException e) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del empleado se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
           //objpantprincipal.limpiardtsemplemod(); 
    }
    public void guardarhuella(String clave_emp, String dedo){
        boolean error = false;
         //Obtiene los datos del template de la huella actual
           fingerprintData = new ByteArrayInputStream(template.getData());
           fingerprintDataLength = template.getData().length;
           
        try {
                //Establece los valores para la sentencia SQL
            guardarhuStmt.setString(1,clave_emp);
            guardarhuStmt.setBinaryStream(2, fingerprintData, fingerprintDataLength);
            guardarhuStmt.setString(3,dedo);
            guardarhuStmt.execute();
        } 
        catch (SQLException e) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
                //write error to log
           objpantprincipal.writeLog("ERROR, Los datos no se pudieron guardar.\n " + e.getMessage());
        }
        if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos de la huella se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        objpantprincipal.limpiardhuella();
        objpantprincipal.limpdtssalida();
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
   public void guardardtshorario(int clavehor, String nombrehor, String hentdom, String hsaldom, String hentlun, String hsallun, 
        String hentmar, String hsalmar, String hentmie, String hsalmie, String hentjue, String hsaljue, 
        String hentvie, String hsalvie, String hentsab, String hsalsab, 
        String hrstotales, int toleantentdia, int toledesentdia, int toleantsaldia, int toledessaldia)
   {
       boolean error = false;
       try {
            //Establece los valores para la sentencia SQL
               guardarhorario.setInt(1,clavehor);
            guardarhorario.setString(2,nombrehor);
            guardarhorario.setString(3,hentdom);
            guardarhorario.setString(4,hsaldom);
            guardarhorario.setString(5,hentlun);
            guardarhorario.setString(6,hsallun);
            guardarhorario.setString(7,hentmar);
            guardarhorario.setString(8,hsalmar);
            guardarhorario.setString(9,hentmie);
            guardarhorario.setString(10,hsalmie);
            guardarhorario.setString(11,hentjue);
            guardarhorario.setString(12,hsaljue);
            guardarhorario.setString(13,hentvie);
            guardarhorario.setString(14,hsalvie);
            guardarhorario.setString(15,hentsab);
            guardarhorario.setString(16,hsalsab);
            guardarhorario.setString(17,hrstotales);
            guardarhorario.setInt(18,toleantentdia);
            guardarhorario.setInt(19,toledesentdia);
            guardarhorario.setInt(20,toleantsaldia);
            guardarhorario.setInt(21,toledessaldia);
            //Ejecuta la sentencia
            guardarhorario.execute();

        } catch (SQLException ex) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + ex.getMessage());
        }
            if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del horario se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        objpantprincipal.Limpiardtshor(); 
   }
   public void guardardtshorariomod(String nombrehor, String hentdom, String hsaldom, 
           String hentlun, String hsallun, String hentmar, String hsalmar, String hentmie, String hsalmie, 
           String hentjue, String hsaljue, String hentvie, String hsalvie, String hentsab, String hsalsab, String hrstotalesmo, String clvhorario,
           int toleantentdiamod, int toledesentdiamod, int toleantsaldiamod, int toledessaldiamod)
   {
       boolean error = false;
       try {
            //Establece los valores para la sentencia SQL
            guardardtsmodhor.setString(1,nombrehor);
            guardardtsmodhor.setString(2,hentdom);
            guardardtsmodhor.setString(3,hsaldom);
            guardardtsmodhor.setString(4,hentlun);
            guardardtsmodhor.setString(5,hsallun);
            guardardtsmodhor.setString(6,hentmar);
            guardardtsmodhor.setString(7,hsalmar);
            guardardtsmodhor.setString(8,hentmie);
            guardardtsmodhor.setString(9,hsalmie);
            guardardtsmodhor.setString(10,hentjue);
            guardardtsmodhor.setString(11,hsaljue);
            guardardtsmodhor.setString(12,hentvie);
            guardardtsmodhor.setString(13,hsalvie);
            guardardtsmodhor.setString(14,hentsab);
            guardardtsmodhor.setString(15,hsalsab);
            guardardtsmodhor.setString(16,hrstotalesmo);
            guardardtsmodhor.setInt(17,toleantentdiamod);
            guardardtsmodhor.setInt(18,toledesentdiamod);
            guardardtsmodhor.setInt(19,toleantsaldiamod);
            guardardtsmodhor.setInt(20,toledessaldiamod);
            guardardtsmodhor.setString(21,clvhorario);
            //Ejecuta la sentencia
            guardardtsmodhor.execute();

        } catch (SQLException ex) {
            error = true;
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"ERROR, Los datos no se pudieron guardar.\n " + ex.getMessage());
        }
            if (error == false)
            JOptionPane.showMessageDialog(null,"Los datos del horario se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        //objpantprincipal.Limpiardtshormod(); 
   }
}
