/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainInterfaz;

import static javax.swing.JFileChooser.*;
import acciones.Util;
import acciones.hlabsfromhorario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.JPanel;
//import javax.swing.UIManager;
//import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.StyleContext;


/**
 *
 * @author Usuariop
 */
public class Pantallaprincipal extends javax.swing.JFrame {
    DefaultComboBoxModel modeloCombotipo = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloComboare = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombonem = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloComboaremod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombotipomod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombotiposuel = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombotipemod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombohorario = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombohorariomod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloComboestadomod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombonemnom = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombonemche = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloComboestado = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombohuemod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombochemod = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloComboasis = new DefaultComboBoxModel();//esto es el modelo
    DefaultComboBoxModel modeloCombonemcch = new DefaultComboBoxModel();//esto es el modelo
    Util objetoutil;
    FilePreviewer previewer;
    PreparedStatement sttipo;
    PreparedStatement starea;
    PreparedStatement stclavetipo;
    PreparedStatement stclavearea;
    PreparedStatement stnombreem;
    PreparedStatement stclaveempleado;
    PreparedStatement stconclaexis;
    PreparedStatement stconcdatmod;
    PreparedStatement buscarfoto;
    PreparedStatement stareamod;
    PreparedStatement sttipomod;
    PreparedStatement stemplelike;
    PreparedStatement stdelhue;
    PreparedStatement stdelemple;
    PreparedStatement stcondtsareamod;
    PreparedStatement stdelarea;
    PreparedStatement sttipoelike;
    PreparedStatement stcondtstipoemod;
    PreparedStatement sttipoemmod;
    PreparedStatement stdeltipoempe;
    PreparedStatement sthuellalike;
    PreparedStatement stdelchecadas;
    PreparedStatement stnomhorario;
    PreparedStatement stclavehorario;
    PreparedStatement stconhorario;
    PreparedStatement stconsultahuellas;
    PreparedStatement sthorarioslike;
    PreparedStatement stdelhorario;
    PreparedStatement stcondtshorariomod;
    PreparedStatement stcondlaborados;
    PreparedStatement stconmaxhrchec;
    PreparedStatement stconminhrchec;
    PreparedStatement stconhrsdehor;
    PreparedStatement stcontipoemp;
    PreparedStatement stconsueldotipo;
    PreparedStatement stconhordeemp;
    PreparedStatement stconhrsdehorario;
    PreparedStatement stcontiposueldo;
    PreparedStatement stconsueldoemp;
    PreparedStatement stconhorclvcero;
    PreparedStatement stcontipsuel;
    PreparedStatement stconclvhorario;
    PreparedStatement stconclvadmin;
    PreparedStatement stconindicio;
    PreparedStatement stconestado;
    PreparedStatement stconclvsempleac;
    PreparedStatement stchecadas;
    PreparedStatement stdelche;
    PreparedStatement stdeltodasche;
    PreparedStatement stcondtshuemod;
    PreparedStatement stnombreempleado;
    PreparedStatement stconexisdedo;
    PreparedStatement stconchecmod;
    PreparedStatement starealike;
    PreparedStatement stemplemodificado;
    PreparedStatement stareamodificada;
    PreparedStatement sttipomodificado;
    PreparedStatement sthorariomodifi;
    PreparedStatement sthuellamodifi;
    PreparedStatement stchecadasmodifi;
    PreparedStatement stdelhueemp;
    PreparedStatement stasistencia;
    PreparedStatement stnombredia;
    PreparedStatement stconhrentlun;
    PreparedStatement stconhrentmar;
    PreparedStatement stconhrentmie;
    PreparedStatement stconhrentjue;
    PreparedStatement stconhrentvie;
    PreparedStatement stconhrentsab;
    PreparedStatement stconhrentdom;
    PreparedStatement stcontolantent;
    PreparedStatement stcontoldessal;
    PreparedStatement stjustifilike;
    PreparedStatement stjustimodificado;
    
    PreparedStatement stconhrsallun;
    PreparedStatement stconhrsalmar;
    PreparedStatement stconhrsalmie;
    PreparedStatement stconhrsaljue;
    PreparedStatement stconhrsalvie;
    PreparedStatement stconhrsalsab;
    PreparedStatement stconhrsaldom;
    PreparedStatement stconmtstoldesent;
    PreparedStatement stconminhrchasis;
    PreparedStatement stconmtstolantsal;
    PreparedStatement stconmaxhrchasis;
    PreparedStatement stconpagohrext;
    PreparedStatement stcondtsjustifimod;
    PreparedStatement stdeljustificante;
    
    hlabsfromhorario horaslabs;
    boolean error = false;
    //Valores para cada JRadioButton
    String meñiquei = "Menique izquierdo";
    String anulari = "Anular izquierdo";
    String medioi = "Medio izquierdo";
    String indicei = "Indice izquierdo";
    String pulgari = "Pulgar izquierdo";
    String meñiqued = "Menique derecho";
    String anulard = "Anular derecho";
    String mediod = "Medio derecho";
    String indiced = "Indice derecho";
    String pulgard = "Pulgar derecho";
    String finger = null;
    String fingerant = null;
    String funcionifazhu;
    boolean coincidehuella = false;
    
    int hrstotales = 0;
    int tiempoextraante = 0;
    int tiempoextradess = 0;
    boolean diaextraae = false;
    boolean diaextrads = false;
    String cempmodificar;
    private Image data;
    Connection conexion;
   //Panel para mostrar la huella digital
   private JPanel fingerprintViewPanel = null;
        //Cabeceras para la consulta del empleado
        String[] cabecerasem = new String[]{"Clave", "Nombre", "Dirección", "Email", "Telefono", "Foto", "Área de trabajo", "Tipo de empleado", "Horario", "Estado"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] dataemp = new Object[cabecerasem.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmem= new DefaultTableModel();
        
        //Cabeceras para la consulta del area de trabajo
        String[] cabecerasar = new String[]{"Clave", "Nombre"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] dataarea = new Object[cabecerasar.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmarea= new DefaultTableModel();
        
        //Cabeceras para la consulta de justificantes
        String[] cabecerasjust = new String[]{"Clave", "Nombre"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] datajust = new Object[cabecerasjust.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmjustificante = new DefaultTableModel();
        
        //Cabeceras para la consulta del tipo de empleado
        String[] cabecerastipe = new String[]{"Clave", "Nombre", "Tipo de sueldo", "Sueldo $"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] datatipoe = new Object[cabecerastipe.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmtipoe = new DefaultTableModel();
        
        //Cabeceras para la consulta de las huellas
        String[] cabeceraschue = new String[]{"Clave", "Propietario de la huella", "Huella", "Dedo capturado"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] datahuellas = new Object[cabeceraschue.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmchue = new DefaultTableModel();
        
        //Cabeceras para la consulta de los horarios
        String[] cabecerashor = new String[]{"Clave", "Nombre", "Ent. Lunes", "Sal. Lunes", "Ent. Martes", "Sal. Martes", "Ent. Miercoles", "Sal. Miercoles", 
                                             "Ent. Jueves", "Sal. Jueves", "Ent. Viernes", "Sal. Viernes", "Ent. Sabado", "Sal. Sabado", "Ent. Domingo", 
                                             "Sal. Domingo", "Tiempo meta", "M. Tolerancia ant. Ent.", "M. Tolerancia des. Ent.", "M. Tolerancia ant. Sal.", "M. Tolerancia des. Sal."};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] datahorario = new Object[cabecerashor.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmchor = new DefaultTableModel();
        
        //Cabeceras para la consulta de las checadas
        String[] cabeceraschec = new String[]{"Clave", "Nombre", "Fecha", "Hora", "Numero de checada"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] datachecadas = new Object[cabeceraschec.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmcchec = new DefaultTableModel();
        
        //Cabeceras para la consulta de las asistencias
        String[] cabecerasasis = new String[]{"Clave", "Nombre", "Fecha", "Entrada", "Salida", "Retardo (HH:mm)", "Tiempo laborado", "Tiempo descontado", "Tiempo meta"};
        //creamos el arreglo de objetos que contendra el contenido de las columnas
	Object[] dataasistencia = new Object[cabecerasasis.length];
        // creamos el modelo de Tabla
        DefaultTableModel dtmcasis = new DefaultTableModel();
        
   //Imagen de la huella actual
   private BufferedImage fingerprintImage = null;
    /**
     * Creates new form NewJFrame
     */
   Object claveemplex;
   Object claveareax;
   Object clavejustificantex;
   Object clavetipoemx;
   Object clavehuellax;
   Object dedohuellax;
   Object clavehorariox;
   Object clavechecadax;
   Object numerochecadax;
   private JMenuItem elementos[];
   private JPopupMenu menuContextual;
   private JMenuItem elementosarea[];
   private JPopupMenu menuContextualare;
   private JMenuItem elementostipoe[];
   private JPopupMenu menuContextualtipe;
   private JMenuItem elementoshuella[];
   private JPopupMenu menuContextualhue;
   private JMenuItem elementoshorario[];
   private JPopupMenu menuContextualhor;
   private JMenuItem elementoschecadas[];
   private JPopupMenu menuContextualche;
   private JMenuItem elementosjustifi[];
   private JPopupMenu menuContextualjustifi;
   //////////// Constructor ////////////
    public Pantallaprincipal() {
        initComponents();
        IniciarBD();
        llenar_combotipo();
        llenar_comboarea();
        llenar_comboemple();
        llenar_combotiposuel();
        llenar_combohorario();
        llenar_comboempnom();
        llenar_comboempchec();
        llenar_comboestado();
        llenar_comboasis();
        llenar_cempconche();
        setExtendedState(MAXIMIZED_BOTH);
        /*centra la ventana en la pantalla*/
        setLocationRelativeTo(null);
        inicializar();
        ManejadorEventos manejador = new ManejadorEventos();
        String acciones[] = {"Modificar", "Eliminar"};
        ManejadorEventosare manejadorarea = new ManejadorEventosare();
        String accionesare[] = {"Modificar", "Eliminar"};
        ManejadorEventostipoe manejadortipoe = new ManejadorEventostipoe();
        String accionestipoe[] = {"Modificar", "Eliminar"};
        ManejadorEventoshue manejadorhue = new ManejadorEventoshue();
        String accioneshue[] = {"Modificar", "Eliminar"};
        ManejadorEventoshor manejadorhorario = new ManejadorEventoshor();
        String accioneshor[] = {"Modificar", "Eliminar"};
        ManejadorEventosche manejadorche = new ManejadorEventosche();
        String accionesche[] = {"Modificar", "Eliminar"};
        ManejadorEventosjust manejadorjust = new ManejadorEventosjust();
        String accionesjust[] = {"Modificar", "Eliminar"};
        
        menuContextual = new JPopupMenu();
        elementos = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementos.length; cuenta ++){
            elementos [cuenta] = new JMenuItem(acciones[cuenta]);
            menuContextual.add(elementos[cuenta]);
            elementos[cuenta].addActionListener(manejador);
        }
        
        menuContextualare = new JPopupMenu();
        elementosarea = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementosarea.length; cuenta ++){
            elementosarea [cuenta] = new JMenuItem(accionesare[cuenta]);
            menuContextualare.add(elementosarea[cuenta]);
            elementosarea[cuenta].addActionListener(manejadorarea);
        }
        
        menuContextualjustifi = new JPopupMenu();
        elementosjustifi = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementosjustifi.length; cuenta ++){
            elementosjustifi [cuenta] = new JMenuItem(accionesjust[cuenta]);
            menuContextualjustifi.add(elementosjustifi[cuenta]);
            elementosjustifi[cuenta].addActionListener(manejadorjust);
        }
        
        menuContextualtipe = new JPopupMenu();
        elementostipoe = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementostipoe.length; cuenta ++){
            elementostipoe [cuenta] = new JMenuItem(accionestipoe[cuenta]);
            menuContextualtipe.add(elementostipoe[cuenta]);
            elementostipoe[cuenta].addActionListener(manejadortipoe);
        }
        
        menuContextualhue = new JPopupMenu();
        elementoshuella = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementoshuella.length; cuenta ++){
            elementoshuella [cuenta] = new JMenuItem(accioneshue[cuenta]);
            menuContextualhue.add(elementoshuella[cuenta]);
            elementoshuella[cuenta].addActionListener(manejadorhue);
        }
        
        menuContextualhor = new JPopupMenu();
        elementoshorario = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementoshorario.length; cuenta ++){
            elementoshorario [cuenta] = new JMenuItem(accioneshor[cuenta]);
            menuContextualhor.add(elementoshorario[cuenta]);
            elementoshorario[cuenta].addActionListener(manejadorhorario);
        }
        
        menuContextualche = new JPopupMenu();
        elementoschecadas = new JMenuItem[2];
        for(int cuenta = 0; cuenta < elementoschecadas.length; cuenta ++){
            elementoschecadas [cuenta] = new JMenuItem(accionesche[cuenta]);
            menuContextualche.add(elementoschecadas[cuenta]);
            elementoschecadas[cuenta].addActionListener(manejadorche);
        }
        
        //eventos para objetos jRadiobutton
	jRBmeñiquei.addActionListener(new ManejadorBotonOpcion(meñiquei));
	jRBanulari.addActionListener(new ManejadorBotonOpcion(anulari));
        jRBmedioi.addActionListener(new ManejadorBotonOpcion(medioi));
        jRBindicei.addActionListener(new ManejadorBotonOpcion(indicei));
        jRBpulgari.addActionListener(new ManejadorBotonOpcion(pulgari));
        jRBmeñiqued.addActionListener(new ManejadorBotonOpcion(meñiqued));
	jRBanulard.addActionListener(new ManejadorBotonOpcion(anulard));
        jRBmediod.addActionListener(new ManejadorBotonOpcion(mediod));
        jRBindiced.addActionListener(new ManejadorBotonOpcion(indiced));
        jRBpulgard.addActionListener(new ManejadorBotonOpcion(pulgard));
        
        /*Inicializa la captura de huellas*/
        //objetoutil.inicializarCaptura();
        this.panelContenedor.add(crearPanelHuella());
        
        lblimgdedos.setIcon(new ImageIcon(getClass().getResource("/imagenes/manospngn.png")));
        
      horaslabs = new hlabsfromhorario();
      jDpedirclave.setLocationRelativeTo(null);
      jDpedirclave.setVisible(true);
      jppassword.grabFocus();
    
    }
    //Eventos de boton de opcion
    private class ManejadorBotonOpcion implements ActionListener{
      String dedo;
      public ManejadorBotonOpcion(String d){
          dedo = d;
      }
      //Manejar eventos de boton de opcion
      public void actionPerformed(ActionEvent evento){
          finger = dedo;
          writeLog("Dedo seleccionado: " + finger);
      }
    }
    
    private class ManejadorEventos implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementos.length; i ++)
                if(evento.getSource() == elementos[i]){
                    nombreaccion = elementos[i].getText();
                    
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamod(claveemplex.toString());}
                    
                    else if( "Eliminar".equals(nombreaccion)){
                    preguntardelete(claveemplex.toString());}
                   return;
                } 

        }
    }
    private class ManejadorEventosare implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementosarea.length; i ++)
                if(evento.getSource() == elementosarea[i]){
                    nombreaccion = elementosarea[i].getText();
                    
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodar(claveareax.toString());}
                    
                    else if( "Eliminar".equals(nombreaccion)){
                    preguntareliare(claveareax.toString());}
                   return;
                } 

        }
    }
    
    private class ManejadorEventosjust implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementosjustifi.length; i ++)
                if(evento.getSource() == elementosjustifi[i]){
                    nombreaccion = elementosjustifi[i].getText();
                    
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodjust(clavejustificantex.toString());}
                    
                    else if( "Eliminar".equals(nombreaccion)){
                    preguntarelijusti(clavejustificantex.toString());}
                   return;
                } 

        }
    }
    
    private class ManejadorEventostipoe implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementostipoe.length; i ++)
                if(evento.getSource() == elementostipoe[i]){
                    nombreaccion = elementostipoe[i].getText();
                    
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodtipe(clavetipoemx.toString());
                    }
                    
                    else if( "Eliminar".equals(nombreaccion)){
                    preguntarelitipe(clavetipoemx.toString());
                    }
                   return;
                } 

        }
    }
    private class ManejadorEventoshue implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementoshuella.length; i ++)
                if(evento.getSource() == elementoshuella[i]){
                    nombreaccion = elementoshuella[i].getText();
                    
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodhue(clavehuellax.toString(), dedohuellax.toString());
                    }
                    
                    else if( "Eliminar".equals(nombreaccion))
                    preguntarelihue(clavehuellax.toString(), dedohuellax.toString());
                        return;
                } 

        }
    }
    private class ManejadorEventoshor implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementoshorario.length; i ++)
                if(evento.getSource() == elementoshorario[i]){
                    nombreaccion = elementoshorario[i].getText();
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodhor(clavehorariox.toString());
                    }
                    else if( "Eliminar".equals(nombreaccion)){
                    preguntarelihor(clavehorariox.toString());}
                        return;
                } 

        }
    }
    private class ManejadorEventosche implements ActionListener{
        public void actionPerformed (ActionEvent evento){
               String nombreaccion;
            //Determinar cual elemento de menu fue seleccionado
            for(int i = 0; i < elementoschecadas.length; i ++)
                if(evento.getSource() == elementoschecadas[i]){
                    nombreaccion = elementoschecadas[i].getText();
                    if( "Modificar".equals(nombreaccion)){
                    mostrardamodche(clavechecadax.toString(), numerochecadax.toString());
                    }
                    else if( "Eliminar".equals(nombreaccion))
                    preguntareliche(numerochecadax.toString());
                        return;
                } 

        }
    }
    public void mostrardamodar(String clavemodi){
    try{
    stcondtsareamod.setString(1, clavemodi);
            ResultSet res = null;
            res = stcondtsareamod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1)
        jtxtnombreareamod.setText(res.getString(i));
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodificarare.setLocationRelativeTo(null);
    jDmodificarare.setVisible(true);
}
    
    public void mostrardamodjust(String clavemodi){
    try{
    stcondtsjustifimod.setString(1, clavemodi);
            ResultSet res = null;
            res = stcondtsjustifimod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1)
        txtnombremodjusti.setText(res.getString(i));
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodjustificante.setLocationRelativeTo(null);
    jDmodjustificante.setVisible(true);
}
    
    public void mostrardamodhor(String clavemodi){
    try{
    stcondtshorariomod.setString(1, clavemodi);
            ResultSet res = null;
            res = stcondtshorariomod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1){
        txtnombrehormod.setText(res.getString(i));}
    else if (i == 2){
        txthoraentdommod.setText(res.getString(i));}
    else if (i == 3){
        txthorasaldommod.setText(res.getString(i));}
    else if (i == 4){
        txthoraentlunmod.setText(res.getString(i));}
    else if (i == 5){
        txthorasallunmod.setText(res.getString(i));}
    else if (i == 6){
        txthoraentmarmod.setText(res.getString(i));}
    else if (i == 7){
        txthorasalmarmod.setText(res.getString(i));}
    else if (i == 8){
        txthoraentmiemod.setText(res.getString(i));}
    else if (i == 9){
        txthorasalmiemod.setText(res.getString(i));}
    else if (i == 10){
        txthoraentjuemod.setText(res.getString(i));}
    else if (i == 11){
        txthorasaljuemod.setText(res.getString(i));}
    else if (i == 12){
        txthoraentviemod.setText(res.getString(i));}
    else if (i == 13){
        txthorasalviemod.setText(res.getString(i));}
    else if (i == 14){
        txthoraentsabmod.setText(res.getString(i));}
    else if (i == 15){
        txthorasalsabmod.setText(res.getString(i));}
    else if (i == 16){
        txttoleantentdiamod.setText(res.getString(i));}
    else if (i == 17){
        txttoledesentdiamod.setText(res.getString(i));}
    else if (i == 18){
        txttoleantsaldiamod.setText(res.getString(i));}
    else if (i == 19){
        txttoledessaldiamod.setText(res.getString(i));}
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodhorario.setLocationRelativeTo(null);
    jDmodhorario.setVisible(true);
}
        public void mostrardamodtipe(String clavemodi){
    try{
    stcondtstipoemod.setString(1, clavemodi);
            ResultSet res = null;
            res = stcondtstipoemod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1){
        txtnombretipomod.setText(res.getString(i));
    }
    else if (i == 2){
        llenar_combotipemod(clavemodi);
    }
    else if (i == 3){
        txtsueldoemmod.setText(res.getString(i));
    }
        
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodificartipoe.setLocationRelativeTo(null);
    jDmodificartipoe.setVisible(true);
}
    public void mostrardamodche(String claveempche, String numeroche){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date dfechachecada;
    try{
    stconchecmod.setString(1, claveempche);
    stconchecmod.setString(2, numeroche);
            ResultSet res = null;
            res = stconchecmod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1){
       llenar_combonomchemod(claveempche); 
    }
    else if (i == 2){
        dfechachecada = sdf.parse(res.getString(i));
        cal.setTime(dfechachecada);
       dCCfechchecmod.setSelectedDate(cal);
    }
    else if (i == 3){
        txthrchecmod.setText(res.getString(i));
    }
        
      }
               }
            } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodchecada.setLocationRelativeTo(null);
    jDmodchecada.setVisible(true);
}
        
       public void mostrardamodhue(String clavemodi, String dedohue){
           funcionifazhu = "Modificar huellas";
           jBlimpiarhu.setEnabled(false);
           jDaltahue.setTitle("Modificar huellas");
             fingerprintImage = null;
             crearPanelHuella();
             panelContenedor.repaint();
             jp1.setBackground(null);
             jp2.setBackground(null);
             jp3.setBackground(null);
             jp4.setBackground(null);
             jp5.setBackground(null);
             jp6.setBackground(null);
           salida.setText("");
        objetoutil.inicializarCaptura();
    try{
        String dedo;
    stcondtshuemod.setString(1, clavemodi);
    stcondtshuemod.setString(2, dedohue);
            ResultSet res = null;
            res = stcondtshuemod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
    if (i == 1){
        llenar_combonomhuemod(clavemodi);
    }
    else if (i == 2){
        dedo = res.getString(i);
        if("Menique izquierdo".equals(dedo)){
            jRBmeñiquei.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Anular izquierdo".equals(dedo)){
            jRBanulari.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Medio izquierdo".equals(dedo)){
            jRBmedioi.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Indice izquierdo".equals(dedo)){
            jRBindicei.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Pulgar izquierdo".equals(dedo)){
            jRBpulgari.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Menique derecho".equals(dedo)){
            jRBmeñiqued.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Anular derecho".equals(dedo)){
            jRBanulard.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Medio derecho".equals(dedo)){
            jRBmediod.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Indice derecho".equals(dedo)){
            jRBindiced.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
        else if("Pulgar derecho".equals(dedo)){
            jRBpulgard.setSelected(true);
            finger = dedo;
            fingerant = dedo;
            writeLog("Dedo seleccionado: " + dedo);
        }
    }
        
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        
        jDaltahue.setLocationRelativeTo(null);
        jDaltahue.setVisible(true);
}
        
    /**
      * Se establece el estilo visual de la aplicación y se realiza la inicialización de la clase 
      * que contiene los procedimientos principales.
      **/   
    public void  inicializar() {
       //Crea una instancia de Util
       this.objetoutil = new Util(this);       
   }
    
    /**
    * Crea el panel que contendrá la imagen de la huella digital
    */
   private JComponent crearPanelHuella() {
       //Crea un panel nuevo para mostrar la huella
       fingerprintViewPanel = new JPanel(){
           
           //Se sobreescribe el método paintComponent 
           //para habilitar la muestra de la imagen de la huella
           public void paintComponent(Graphics g) {
               super.paintComponent(g);

               //Si hay una imagen para ser mostrada
               if (fingerprintImage!=null) {
                   //Calcula el tamaño y posición de la imagen para ser pintada
                   //el tamaño es ajustado para que ocupe todo el tamaño del panel
                   Insets insets = getInsets();
                   int transX = insets.left;
                   int transY = insets.top;
                   int width  = getWidth()  - getInsets().right  - getInsets().left;
                   int height = getHeight() - getInsets().bottom - getInsets().top;

                   //Se dibuja la imagen
                   g.drawImage(fingerprintImage, transX, transY, width, height, null);
               }

           }

       };

       //Se agrega un borde alrededor del panel
       fingerprintViewPanel.setBorder(new CompoundBorder (
               new EmptyBorder (2,2,2,2),
               new BevelBorder(BevelBorder.LOWERED)));           
       
       //si no hay existe el panel de la huella no devuelve nada...
       if(fingerprintViewPanel==null)
       {        
            return null;
       }else{ // de lo contrario devuelve el panel mismo
       
            return fingerprintViewPanel;
       }
       
   }

   /**
     * Método utilizado para mostrar la imagen de la huella
     * en el panel correspondiente.
     */
   public void showImage(BufferedImage image) {
       //Utiliza el imageProducer para crear una imagen de la huella digital
       fingerprintImage = image;
       //Se dibuja la nueva imagen
       repaint();        
   }
   /**
    * Area que muestra el estado del lectoy y los respectivos mensajes
    */
   public void writeLog(String text) {
      //Appends the text
      salida.append(text + "\n");
      //Auto-scrolls to the last message.
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               //picks the vertical scrollBar, and sets it to the maximum.
               JScrollBar vbar = jScrollPane1.getVerticalScrollBar();
               vbar.setValue(vbar.getMaximum());
           }
       });
 }
   //Pintar la calidad de la imagen de la huella
   public void pintarbajacalidad(){
       jp1.setBackground(Color.GREEN);
       jp2.setBackground(null);
       jp3.setBackground(null);
       jp4.setBackground(null);
       jp5.setBackground(null);
       jp6.setBackground(null);
   }
   public void pintarmedianacalidad(){
       jp1.setBackground(Color.GREEN);
       jp2.setBackground(Color.GREEN);
       jp3.setBackground(Color.GREEN);
       jp4.setBackground(null);
       jp5.setBackground(null);
       jp6.setBackground(null);
   }
   public void pintaraltacalidad(){
       jp1.setBackground(Color.GREEN);
       jp2.setBackground(Color.GREEN);
       jp3.setBackground(Color.GREEN);
       jp4.setBackground(Color.GREEN);
       jp5.setBackground(Color.GREEN);
       jp6.setBackground(Color.GREEN);
   }

   public void repintarp(){
       panelContenedor.repaint();
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDaltaarea = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtclavearea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtnombrearea = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        btnGuardararea = new javax.swing.JButton();
        btnLimpiararea = new javax.swing.JButton();
        jDaltaempleado = new javax.swing.JDialog();
        jpaneldatos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtclaveem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombre_emp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdireccion_emp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemail_emp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttelefono_emp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCBarea = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jCBtipoempleado = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jCBhorario = new javax.swing.JComboBox();
        jLabel73 = new javax.swing.JLabel();
        jCBestado = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtfoto = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        btnguardardatosemp = new javax.swing.JButton();
        btnlimpiardatosemp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btncargarfoto = new javax.swing.JButton();
        jDaltatipoempleado = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtclavetipo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtnombretipo = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jCBtiposueldo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtsueldoem = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        btnguardartipo = new javax.swing.JButton();
        btnlimpiartipo = new javax.swing.JButton();
        jDaltahue = new javax.swing.JDialog();
        jPcongrl = new javax.swing.JPanel();
        panelEstado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jPbtnlimedohu = new javax.swing.JPanel();
        jBlimpiarsalida = new javax.swing.JButton();
        jPcalidad = new javax.swing.JPanel();
        jp6 = new javax.swing.JPanel();
        jp5 = new javax.swing.JPanel();
        jp4 = new javax.swing.JPanel();
        jp3 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        jPacciones = new javax.swing.JPanel();
        jBguardarhu = new javax.swing.JButton();
        jBlimpiarhu = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();
        jPboxn = new javax.swing.JPanel();
        jCBemplebd = new javax.swing.JComboBox();
        jPanel46 = new javax.swing.JPanel();
        lblimgdedos = new javax.swing.JLabel();
        botonesopcion = new javax.swing.JPanel();
        jRBmeñiquei = new javax.swing.JRadioButton();
        jRBanulari = new javax.swing.JRadioButton();
        jRBmedioi = new javax.swing.JRadioButton();
        jRBindicei = new javax.swing.JRadioButton();
        jLabel65 = new javax.swing.JLabel();
        jRBpulgari = new javax.swing.JRadioButton();
        lblseparadorradb = new javax.swing.JLabel();
        jRBpulgard = new javax.swing.JRadioButton();
        jLabel64 = new javax.swing.JLabel();
        jRBindiced = new javax.swing.JRadioButton();
        jRBmediod = new javax.swing.JRadioButton();
        jRBanulard = new javax.swing.JRadioButton();
        jRBmeñiqued = new javax.swing.JRadioButton();
        jDconsultaem = new javax.swing.JDialog();
        jPresultadoc = new javax.swing.JPanel();
        btnlimpiarareac = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaconsultaemp = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPcontcon = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        btnconsultalne = new javax.swing.JButton();
        txtcnomem = new javax.swing.JTextField();
        jDmodificarem = new javax.swing.JDialog();
        jpaneldatos1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtnombre_empmod = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtdireccion_empmod = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtemail_empmod = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txttelefono_empmod = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jCBareamod = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jCBtipoempleadomod = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jCBhorariomod = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        jCBestadomod = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        txtfotomod = new javax.swing.JTextField();
        btnguardardatosempmod = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblfotomod = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btncargarfotomod = new javax.swing.JButton();
        jDconsultaar = new javax.swing.JDialog();
        jPresultadoc1 = new javax.swing.JPanel();
        btnlimpiartablaar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaconsultaarea = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jPcontcon1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txtcnomar = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        btnconsultalimar = new javax.swing.JButton();
        jDmodificarare = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jtxtnombreareamod = new javax.swing.JTextField();
        btnGuardarareamod = new javax.swing.JButton();
        jDconsultatipe = new javax.swing.JDialog();
        jPresultadoc2 = new javax.swing.JPanel();
        btnlimpiarareacte = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaconsultatipe = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jPcontcon2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtcnomtipe = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        btnlimpiarnomtipe = new javax.swing.JButton();
        jDmodificartipoe = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtnombretipomod = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jCBtiposueldomod = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        txtsueldoemmod = new javax.swing.JTextField();
        btnguardartipomod = new javax.swing.JButton();
        jDconsultahue = new javax.swing.JDialog();
        jPresultadoc3 = new javax.swing.JPanel();
        btnlimptabprohue = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaconsultahue = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jPcontcon3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtcnomprohue = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        btnlimpiarnprohue = new javax.swing.JButton();
        jDaltahorario = new javax.swing.JDialog();
        jpcontdias = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txthoraentdom = new javax.swing.JTextField();
        txthorasaldom = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txthoraentlun = new javax.swing.JTextField();
        txthorasallun = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txthoraentmar = new javax.swing.JTextField();
        txthorasalmar = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txthoraentmie = new javax.swing.JTextField();
        txthorasalmie = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txthoraentjue = new javax.swing.JTextField();
        txthorasaljue = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txthoraentvie = new javax.swing.JTextField();
        txthorasalvie = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txthoraentsab = new javax.swing.JTextField();
        txthorasalsab = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        txttoleantentdia = new javax.swing.JTextField();
        txttoledesentdia = new javax.swing.JTextField();
        txttoleantsaldia = new javax.swing.JTextField();
        txttoledessaldia = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        btnrestaurarminstol = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtclavehor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtnombrehor = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        btnguardarhor = new javax.swing.JButton();
        btnlimpiarhor = new javax.swing.JButton();
        jDconsultahor = new javax.swing.JDialog();
        jPresultadoc4 = new javax.swing.JPanel();
        btnlimpiarareachor = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaconsultahor = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jPcontcon4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtcnomhor = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        btnconsultalhor = new javax.swing.JButton();
        jDmodhorario = new javax.swing.JDialog();
        jpcontdias1 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txthoraentdommod = new javax.swing.JTextField();
        txthorasaldommod = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txthoraentlunmod = new javax.swing.JTextField();
        txthorasallunmod = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txthoraentmarmod = new javax.swing.JTextField();
        txthorasalmarmod = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txthoraentmiemod = new javax.swing.JTextField();
        txthorasalmiemod = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txthoraentjuemod = new javax.swing.JTextField();
        txthorasaljuemod = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txthoraentviemod = new javax.swing.JTextField();
        txthorasalviemod = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txthoraentsabmod = new javax.swing.JTextField();
        txthorasalsabmod = new javax.swing.JTextField();
        jPanel55 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txttoleantentdiamod = new javax.swing.JTextField();
        txttoledesentdiamod = new javax.swing.JTextField();
        txttoleantsaldiamod = new javax.swing.JTextField();
        txttoledessaldiamod = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        btnrestaurarminstolmod = new javax.swing.JButton();
        jLabel103 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        txtnombrehormod = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        btnguardarhormod = new javax.swing.JButton();
        jDcalculonomina = new javax.swing.JDialog();
        jPfechainifinnom = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        dCfechainicio = new datechooser.beans.DateChooserCombo();
        jLabel66 = new javax.swing.JLabel();
        dCfechafin = new datechooser.beans.DateChooserCombo();
        jPcontnomnom = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jCBempleadosnom = new javax.swing.JComboBox();
        jPanel15 = new javax.swing.JPanel();
        btncalcularnom = new javax.swing.JButton();
        jBlimpiarconnom = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jPresultnom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultconnom = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        btnimprimirnom = new javax.swing.JButton();
        jBlimpiarresulnom = new javax.swing.JButton();
        jDactcontraseña = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jpnuevacontra = new javax.swing.JPasswordField();
        jLabel68 = new javax.swing.JLabel();
        jpcnuevacontra = new javax.swing.JPasswordField();
        jLabel69 = new javax.swing.JLabel();
        txtindiciocontra = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        btnguarcontra = new javax.swing.JButton();
        btnlimpdtscontra = new javax.swing.JButton();
        jDpedirclave = new javax.swing.JDialog();
        jPclave = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jppassword = new javax.swing.JPasswordField();
        jPanel45 = new javax.swing.JPanel();
        btnaceptarclv = new javax.swing.JButton();
        btncancelarclv = new javax.swing.JButton();
        jPindicio = new javax.swing.JPanel();
        lblindicio = new javax.swing.JLabel();
        jDaltachecada = new javax.swing.JDialog();
        jPanel27 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jCBempchec = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        dCCfechchec = new datechooser.beans.DateChooserCombo();
        jLabel72 = new javax.swing.JLabel();
        txthrchec = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        btnguardarche = new javax.swing.JButton();
        btnlimpiarche = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jDconsultachec = new javax.swing.JDialog();
        jPresultadoc5 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaconsultachec = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        btnlimptabcche = new javax.swing.JButton();
        jPcontcon5 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        dCfechainicioche = new datechooser.beans.DateChooserCombo();
        jLabel78 = new javax.swing.JLabel();
        dCfechafinche = new datechooser.beans.DateChooserCombo();
        jPanel30 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnlimpiarpnomche = new javax.swing.JButton();
        jCBnomempchec = new javax.swing.JComboBox();
        jDpclvdelche = new javax.swing.JDialog();
        jPclave1 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jppassworddelche = new javax.swing.JPasswordField();
        jPanel34 = new javax.swing.JPanel();
        btnaceptarclvdelc = new javax.swing.JButton();
        btncancelarclvdelc = new javax.swing.JButton();
        jPindicio1 = new javax.swing.JPanel();
        lblindiciodelche = new javax.swing.JLabel();
        jDmodchecada = new javax.swing.JDialog();
        jPanel47 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jCBempchecmod = new javax.swing.JComboBox();
        jLabel81 = new javax.swing.JLabel();
        dCCfechchecmod = new datechooser.beans.DateChooserCombo();
        jLabel82 = new javax.swing.JLabel();
        txthrchecmod = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        btnguardarchemod = new javax.swing.JButton();
        jDasistencia = new javax.swing.JDialog();
        jPfechainifinnom1 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        dCfechainiasis = new datechooser.beans.DateChooserCombo();
        jLabel84 = new javax.swing.JLabel();
        dCfechafinasis = new datechooser.beans.DateChooserCombo();
        jPcontnomnom1 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jCBempleadosasis = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        btnconsultarasis = new javax.swing.JButton();
        btnlimpiarcona = new javax.swing.JButton();
        jPresultasis = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnlimpiarresas = new javax.swing.JButton();
        btnlimpiarresulasis = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaasistencia = new javax.swing.JTable();
        jDhoraextra = new javax.swing.JDialog();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        txtpagohrex = new javax.swing.JTextField();
        jDaltajustificante = new javax.swing.JDialog();
        jPanel57 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        txtclvaltajusti = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtnombrealtajusti = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        jBtguardarjusti = new javax.swing.JButton();
        jBlimpiardtsaltajus = new javax.swing.JButton();
        jDconsultajust = new javax.swing.JDialog();
        jPresultadoc6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaconsultajusti = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        btnlimpiartablajus = new javax.swing.JButton();
        jPcontcon6 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        txtcnomjust = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        btnconsultalimjus = new javax.swing.JButton();
        jDmodjustificante = new javax.swing.JDialog();
        jPanel62 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        txtnombremodjusti = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        jBtmodificarjusti = new javax.swing.JButton();
        jDcapactdedugral = new javax.swing.JDialog();
        jPanel64 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        txtdescuentofalta = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        txtdescuentopermiso = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        txtdescuentocomedor = new javax.swing.JTextField();
        jPanel65 = new javax.swing.JPanel();
        btnguardardedu = new javax.swing.JButton();
        btnlimpiardtsdedu = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        txtdescuentotrans = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        txtdescuentoimss = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txtdescuentoinfona = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        txtdescuentootro = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        grupobotonesop = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMAdministrador = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMarea = new javax.swing.JMenu();
        jMIaltaarea = new javax.swing.JMenuItem();
        jMIconsultaare = new javax.swing.JMenuItem();
        jMtipoempleado = new javax.swing.JMenu();
        jMIaltatipoempleado = new javax.swing.JMenuItem();
        jMIconsultatipe = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMaltahorario = new javax.swing.JMenuItem();
        jMIconsultarhor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMempleado = new javax.swing.JMenu();
        jMIaltaem = new javax.swing.JMenuItem();
        jMIconsultaem = new javax.swing.JMenuItem();
        jMhuella = new javax.swing.JMenu();
        jMIaltahue = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMchecadas = new javax.swing.JMenu();
        jMIaltache = new javax.swing.JMenuItem();
        jMIconelimche = new javax.swing.JMenuItem();
        jMIelitodasche = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMInomina = new javax.swing.JMenuItem();

        jDaltaarea.setTitle("Alta de área de trabajo");
        jDaltaarea.setIconImage(null);
        jDaltaarea.setLocationByPlatform(true);
        jDaltaarea.setMinimumSize(new java.awt.Dimension(399, 150));
        jDaltaarea.setModal(true);
        jDaltaarea.setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("*Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 147;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel1.add(txtclavearea, gridBagConstraints);

        jLabel2.setText("*Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 2);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 225;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 4);
        jPanel1.add(jtxtnombrearea, gridBagConstraints);

        jPanel35.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        btnGuardararea.setMnemonic('G');
        btnGuardararea.setText("Guardar");
        btnGuardararea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarareaActionPerformed(evt);
            }
        });
        jPanel35.add(btnGuardararea);

        btnLimpiararea.setMnemonic('L');
        btnLimpiararea.setText("Limpiar");
        btnLimpiararea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarareaActionPerformed(evt);
            }
        });
        jPanel35.add(btnLimpiararea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 8, 0);
        jPanel1.add(jPanel35, gridBagConstraints);

        jDaltaarea.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jDaltaempleado.setTitle("Alta empleado");
        jDaltaempleado.setIconImage(null);
        jDaltaempleado.setMinimumSize(new java.awt.Dimension(876, 431));
        jDaltaempleado.setModal(true);
        jDaltaempleado.setResizable(false);
        jDaltaempleado.getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jpaneldatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        java.awt.GridBagLayout jpaneldatosLayout = new java.awt.GridBagLayout();
        jpaneldatosLayout.columnWidths = new int[] {0, 10, 0};
        jpaneldatosLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jpaneldatos.setLayout(jpaneldatosLayout);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("*Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel21, gridBagConstraints);

        txtclaveem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclaveemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 147;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpaneldatos.add(txtclaveem, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("*Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(txtnombre_emp, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("*Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 340;
        jpaneldatos.add(txtdireccion_emp, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("  E-mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 230;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(txtemail_emp, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("  Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(txttelefono_emp, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("*Área");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jCBarea, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("*Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpaneldatos.add(jCBtipoempleado, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("*Horario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel26, gridBagConstraints);

        jCBhorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpaneldatos.add(jCBhorario, gridBagConstraints);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("*Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel73, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jpaneldatos.add(jCBestado, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("  Foto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpaneldatos.add(jLabel9, gridBagConstraints);

        txtfoto.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 340;
        jpaneldatos.add(txtfoto, gridBagConstraints);

        jPanel36.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

        btnguardardatosemp.setMnemonic('G');
        btnguardardatosemp.setText("Guardar");
        btnguardardatosemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardardatosempActionPerformed(evt);
            }
        });
        jPanel36.add(btnguardardatosemp);

        btnlimpiardatosemp.setMnemonic('L');
        btnlimpiardatosemp.setText("Limpiar");
        btnlimpiardatosemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiardatosempActionPerformed(evt);
            }
        });
        jPanel36.add(btnlimpiardatosemp);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 3;
        jpaneldatos.add(jPanel36, gridBagConstraints);

        jDaltaempleado.getContentPane().add(jpaneldatos);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 5, 2));

        lblfoto.setBackground(new java.awt.Color(102, 102, 102));
        lblfoto.setForeground(new java.awt.Color(51, 51, 255));
        lblfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lblfoto);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

        btncargarfoto.setMnemonic('C');
        btncargarfoto.setText("Cargar");
        btncargarfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarfotoActionPerformed(evt);
            }
        });
        jPanel3.add(btncargarfoto);

        jPanel4.add(jPanel3);

        jDaltaempleado.getContentPane().add(jPanel4);

        jDaltatipoempleado.setTitle("Alta de tipo de empleado");
        jDaltatipoempleado.setIconImage(null);
        jDaltatipoempleado.setMinimumSize(new java.awt.Dimension(438, 180));
        jDaltatipoempleado.setModal(true);
        jDaltatipoempleado.setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 10, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel3.setText("*Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 130;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(txtclavetipo, gridBagConstraints);

        jLabel11.setText("*Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 240;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(txtnombretipo, gridBagConstraints);

        jLabel37.setText("*Tipo de sueldo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel37, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jCBtiposueldo, gridBagConstraints);

        jLabel12.setText("*Sueldo $");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(txtsueldoem, gridBagConstraints);

        jPanel37.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

        btnguardartipo.setMnemonic('G');
        btnguardartipo.setText("Guardar");
        btnguardartipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardartipoActionPerformed(evt);
            }
        });
        jPanel37.add(btnguardartipo);

        btnlimpiartipo.setMnemonic('L');
        btnlimpiartipo.setText("Limpiar");
        btnlimpiartipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiartipoActionPerformed(evt);
            }
        });
        jPanel37.add(btnlimpiartipo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        jPanel2.add(jPanel37, gridBagConstraints);

        jDaltatipoempleado.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jDaltahue.setTitle("Alta de huellas");
        jDaltahue.setIconImage(null);
        jDaltahue.setMinimumSize(new java.awt.Dimension(485, 620));
        jDaltahue.setModal(true);
        jDaltahue.setResizable(false);
        jDaltahue.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDaltahueWindowClosing(evt);
            }
        });

        jPcongrl.setLayout(new java.awt.BorderLayout(10, 10));

        panelEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Estado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelEstado.setPreferredSize(new java.awt.Dimension(180, 170));
        panelEstado.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(new CompoundBorder (
            new EmptyBorder (2,2,2,2),
            new BevelBorder(BevelBorder.LOWERED)));
    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setHorizontalScrollBar(null);

    salida.setColumns(20);
    salida.setEditable(false);
    salida.setLineWrap(true);
    salida.setRows(5);
    jScrollPane1.setViewportView(salida);

    panelEstado.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    jPbtnlimedohu.setPreferredSize(new java.awt.Dimension(218, 35));

    jBlimpiarsalida.setMnemonic('i');
    jBlimpiarsalida.setText("Limpiar");
    jBlimpiarsalida.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBlimpiarsalidaActionPerformed(evt);
        }
    });
    jPbtnlimedohu.add(jBlimpiarsalida);

    panelEstado.add(jPbtnlimedohu, java.awt.BorderLayout.SOUTH);

    jPcongrl.add(panelEstado, java.awt.BorderLayout.SOUTH);

    jPcalidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Calidad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPcalidad.setPreferredSize(new java.awt.Dimension(100, 100));
    jPcalidad.setLayout(new java.awt.GridLayout(6, 1, 2, 2));

    javax.swing.GroupLayout jp6Layout = new javax.swing.GroupLayout(jp6);
    jp6.setLayout(jp6Layout);
    jp6Layout.setHorizontalGroup(
        jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp6Layout.setVerticalGroup(
        jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp6);

    javax.swing.GroupLayout jp5Layout = new javax.swing.GroupLayout(jp5);
    jp5.setLayout(jp5Layout);
    jp5Layout.setHorizontalGroup(
        jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp5Layout.setVerticalGroup(
        jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp5);

    javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
    jp4.setLayout(jp4Layout);
    jp4Layout.setHorizontalGroup(
        jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp4Layout.setVerticalGroup(
        jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp4);

    javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
    jp3.setLayout(jp3Layout);
    jp3Layout.setHorizontalGroup(
        jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp3Layout.setVerticalGroup(
        jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp3);

    javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
    jp2.setLayout(jp2Layout);
    jp2Layout.setHorizontalGroup(
        jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp2Layout.setVerticalGroup(
        jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp2);

    javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
    jp1.setLayout(jp1Layout);
    jp1Layout.setHorizontalGroup(
        jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 88, Short.MAX_VALUE)
    );
    jp1Layout.setVerticalGroup(
        jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 11, Short.MAX_VALUE)
    );

    jPcalidad.add(jp1);

    jPcongrl.add(jPcalidad, java.awt.BorderLayout.WEST);

    jPacciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPacciones.setPreferredSize(new java.awt.Dimension(100, 100));
    java.awt.GridBagLayout jPaccionesLayout = new java.awt.GridBagLayout();
    jPaccionesLayout.columnWidths = new int[] {0};
    jPaccionesLayout.rowHeights = new int[] {0, 5, 0};
    jPacciones.setLayout(jPaccionesLayout);

    jBguardarhu.setMnemonic('G');
    jBguardarhu.setText("Guardar");
    jBguardarhu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBguardarhuActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPacciones.add(jBguardarhu, gridBagConstraints);

    jBlimpiarhu.setMnemonic('L');
    jBlimpiarhu.setText("Limpiar");
    jBlimpiarhu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBlimpiarhuActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPacciones.add(jBlimpiarhu, gridBagConstraints);

    jPcongrl.add(jPacciones, java.awt.BorderLayout.EAST);

    panelContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Digital", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    panelContenedor.setLayout(new java.awt.BorderLayout());
    jPcongrl.add(panelContenedor, java.awt.BorderLayout.CENTER);

    jPboxn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione el nombre y el dedo del empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPboxn.setMinimumSize(new java.awt.Dimension(35, 80));
    jPboxn.setLayout(new java.awt.BorderLayout());

    jCBemplebd.setMaximumRowCount(12);
    jCBemplebd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
    jPboxn.add(jCBemplebd, java.awt.BorderLayout.CENTER);

    jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dedo que desea capturar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel46.setPreferredSize(new java.awt.Dimension(443, 190));
    jPanel46.setLayout(new java.awt.BorderLayout());

    lblimgdedos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jPanel46.add(lblimgdedos, java.awt.BorderLayout.CENTER);

    botonesopcion.setPreferredSize(new java.awt.Dimension(431, 25));
    botonesopcion.add(jRBmeñiquei);
    botonesopcion.add(jRBanulari);
    botonesopcion.add(jRBmedioi);
    botonesopcion.add(jRBindicei);

    jLabel65.setPreferredSize(new java.awt.Dimension(14, 0));
    botonesopcion.add(jLabel65);
    botonesopcion.add(jRBpulgari);

    lblseparadorradb.setMinimumSize(new java.awt.Dimension(10, 0));
    lblseparadorradb.setPreferredSize(new java.awt.Dimension(25, 0));
    botonesopcion.add(lblseparadorradb);
    botonesopcion.add(jRBpulgard);

    jLabel64.setPreferredSize(new java.awt.Dimension(14, 0));
    botonesopcion.add(jLabel64);
    botonesopcion.add(jRBindiced);
    botonesopcion.add(jRBmediod);
    botonesopcion.add(jRBanulard);
    botonesopcion.add(jRBmeñiqued);

    jPanel46.add(botonesopcion, java.awt.BorderLayout.PAGE_START);

    jPboxn.add(jPanel46, java.awt.BorderLayout.PAGE_END);

    jPcongrl.add(jPboxn, java.awt.BorderLayout.NORTH);

    jDaltahue.getContentPane().add(jPcongrl, java.awt.BorderLayout.CENTER);

    jDconsultaem.setTitle("Consultar, modificar o eliminar un empleado");
    jDconsultaem.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng1.png")).getImage());
    jDconsultaem.setMinimumSize(new java.awt.Dimension(950, 550));
    jDconsultaem.setModal(true);

    jPresultadoc.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado de la consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    btnlimpiarareac.setMnemonic(73);
    btnlimpiarareac.setText("Limpiar");
    btnlimpiarareac.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarareacActionPerformed(evt);
        }
    });

    tablaconsultaemp.setModel(dtmem);
    tablaconsultaemp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerasem.length; column++){
        dtmem.addColumn(cabecerasem[column]);
    }
    tablaconsultaemp.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultaempMouseClicked(evt);
        }
    });
    jScrollPane5.setViewportView(tablaconsultaemp);
    javax.swing.table.TableColumn columnx = null;
    for(int i = 0; i < tablaconsultaemp.getColumnCount(); i++)
    {
        columnx = tablaconsultaemp.getColumnModel().getColumn(i);
        if (i == 0){columnx.setPreferredWidth(100);}
        else if (i == 1){columnx.setPreferredWidth(300);}
        else if (i == 2){columnx.setPreferredWidth(300);}
        else if (i == 3){columnx.setPreferredWidth(200);}
        else if (i == 4){columnx.setPreferredWidth(120);}
        else if (i == 5){columnx.setPreferredWidth(50);}
        else if (i == 6){columnx.setPreferredWidth(200);}
        else if (i == 7){columnx.setPreferredWidth(200);}
        else if (i == 8){columnx.setPreferredWidth(200);}
        else if (i == 9){columnx.setPreferredWidth(100);}
    }

    jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel22.setText("Clic derecho sobre el registro que desee modificar o eliminar.");

    javax.swing.GroupLayout jPresultadocLayout = new javax.swing.GroupLayout(jPresultadoc);
    jPresultadoc.setLayout(jPresultadocLayout);
    jPresultadocLayout.setHorizontalGroup(
        jPresultadocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadocLayout.createSequentialGroup()
            .addGroup(jPresultadocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPresultadocLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addGap(15, 15, 15)
                    .addComponent(btnlimpiarareac, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPresultadocLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPresultadocLayout.setVerticalGroup(
        jPresultadocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadocLayout.createSequentialGroup()
            .addComponent(jLabel22)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        .addGroup(jPresultadocLayout.createSequentialGroup()
            .addGap(135, 135, 135)
            .addComponent(btnlimpiarareac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jDconsultaem.getContentPane().add(jPresultadoc, java.awt.BorderLayout.CENTER);

    jPcontcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel5.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
    jPanel5Layout.columnWidths = new int[] {0, 10, 0};
    jPanel5Layout.rowHeights = new int[] {0, 5, 0};
    jPanel5.setLayout(jPanel5Layout);

    jLabel13.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
    jPanel5.add(jLabel13, gridBagConstraints);

    jPanel38.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnconsultalne.setMnemonic('L');
    btnconsultalne.setText("Limpiar");
    btnconsultalne.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnconsultalneActionPerformed(evt);
        }
    });
    jPanel38.add(btnconsultalne);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel5.add(jPanel38, gridBagConstraints);

    txtcnomem.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomemKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel5.add(txtcnomem, gridBagConstraints);

    jPcontcon.add(jPanel5);

    jDconsultaem.getContentPane().add(jPcontcon, java.awt.BorderLayout.PAGE_START);

    jDmodificarem.setTitle("Modificar empleado");
    jDmodificarem.setIconImage(null);
    jDmodificarem.setMinimumSize(new java.awt.Dimension(876, 431));
    jDmodificarem.setModal(true);
    jDmodificarem.setResizable(false);
    jDmodificarem.getContentPane().setLayout(new java.awt.GridLayout(1, 2, 1, 0));

    jpaneldatos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jpaneldatos1Layout = new java.awt.GridBagLayout();
    jpaneldatos1Layout.columnWidths = new int[] {0, 10, 0};
    jpaneldatos1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
    jpaneldatos1.setLayout(jpaneldatos1Layout);

    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel14.setText("*Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel14, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 280;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(txtnombre_empmod, gridBagConstraints);

    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel15.setText("*Dirección");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel15, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 340;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(txtdireccion_empmod, gridBagConstraints);

    jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel16.setText("  E-mail");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel16, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 230;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(txtemail_empmod, gridBagConstraints);

    jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel17.setText("  Telefono");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel17, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 145;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(txttelefono_empmod, gridBagConstraints);

    jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel18.setText("*Área");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel18, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jCBareamod, gridBagConstraints);

    jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel19.setText("*Tipo");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel19, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jCBtipoempleadomod, gridBagConstraints);

    jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel48.setText("*Horario");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel48, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jCBhorariomod, gridBagConstraints);

    jLabel74.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel74.setText("*Estado");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel74, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jCBestadomod, gridBagConstraints);

    jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel20.setText("  Foto");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(jLabel20, gridBagConstraints);

    txtfotomod.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 340;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jpaneldatos1.add(txtfotomod, gridBagConstraints);

    btnguardardatosempmod.setMnemonic('G');
    btnguardardatosempmod.setText("Guardar");
    btnguardardatosempmod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardardatosempmodActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 20;
    gridBagConstraints.gridwidth = 3;
    jpaneldatos1.add(btnguardardatosempmod, gridBagConstraints);

    jDmodificarem.getContentPane().add(jpaneldatos1);

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel6.setLayout(new java.awt.GridLayout(2, 1, 5, 0));

    lblfotomod.setBackground(new java.awt.Color(102, 102, 102));
    lblfotomod.setForeground(new java.awt.Color(51, 51, 255));
    lblfotomod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jPanel6.add(lblfotomod);

    jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

    btncargarfotomod.setMnemonic('C');
    btncargarfotomod.setText("Cargar");
    btncargarfotomod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncargarfotomodActionPerformed(evt);
        }
    });
    jPanel7.add(btncargarfotomod);

    jPanel6.add(jPanel7);

    jDmodificarem.getContentPane().add(jPanel6);

    jDconsultaar.setTitle("Consultar, modificar o eliminar un área de trabajo");
    jDconsultaar.setMinimumSize(new java.awt.Dimension(540, 400));
    jDconsultaar.setModal(true);
    jDconsultaar.setResizable(false);

    jPresultadoc1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado de la consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    btnlimpiartablaar.setMnemonic('i');
    btnlimpiartablaar.setText("Limpiar");
    btnlimpiartablaar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiartablaarActionPerformed(evt);
        }
    });

    tablaconsultaarea.setModel(dtmarea);
    tablaconsultaarea.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerasar.length; column++){
        dtmarea.addColumn(cabecerasar[column]);
    }
    tablaconsultaarea.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultaareaMouseClicked(evt);
        }
    });
    jScrollPane6.setViewportView(tablaconsultaarea);
    javax.swing.table.TableColumn columny = null;
    for(int i = 0; i < tablaconsultaarea.getColumnCount(); i++)
    {
        columny = tablaconsultaarea.getColumnModel().getColumn(i);
        if (i == 0){columny.setPreferredWidth(100);}
        else if (i == 1){columny.setPreferredWidth(300);}
    }

    jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel38.setText("Clic derecho sobre el registro que desee modificar o eliminar.");

    javax.swing.GroupLayout jPresultadoc1Layout = new javax.swing.GroupLayout(jPresultadoc1);
    jPresultadoc1.setLayout(jPresultadoc1Layout);
    jPresultadoc1Layout.setHorizontalGroup(
        jPresultadoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc1Layout.createSequentialGroup()
            .addGroup(jPresultadoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPresultadoc1Layout.createSequentialGroup()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGap(15, 15, 15)
                    .addComponent(btnlimpiartablaar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPresultadoc1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPresultadoc1Layout.setVerticalGroup(
        jPresultadoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc1Layout.createSequentialGroup()
            .addComponent(jLabel38)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        .addGroup(jPresultadoc1Layout.createSequentialGroup()
            .addGap(90, 90, 90)
            .addComponent(btnlimpiartablaar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jDconsultaar.getContentPane().add(jPresultadoc1, java.awt.BorderLayout.CENTER);

    jPcontcon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel10.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel10Layout = new java.awt.GridBagLayout();
    jPanel10Layout.columnWidths = new int[] {0, 10, 0};
    jPanel10Layout.rowHeights = new int[] {0, 5, 0};
    jPanel10.setLayout(jPanel10Layout);

    jLabel39.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 1);
    jPanel10.add(jLabel39, gridBagConstraints);

    txtcnomar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomarKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    jPanel10.add(txtcnomar, gridBagConstraints);

    jPanel39.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnconsultalimar.setMnemonic('L');
    btnconsultalimar.setText("Limpiar");
    btnconsultalimar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnconsultalimarActionPerformed(evt);
        }
    });
    jPanel39.add(btnconsultalimar);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel10.add(jPanel39, gridBagConstraints);

    jPcontcon1.add(jPanel10);

    jDconsultaar.getContentPane().add(jPcontcon1, java.awt.BorderLayout.PAGE_START);

    jDmodificarare.setTitle("Modificar área de trabajo");
    jDmodificarare.setIconImage(null);
    jDmodificarare.setLocationByPlatform(true);
    jDmodificarare.setMinimumSize(new java.awt.Dimension(399, 122));
    jDmodificarare.setModal(true);
    jDmodificarare.setResizable(false);

    jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jPanel11Layout = new java.awt.GridBagLayout();
    jPanel11Layout.columnWidths = new int[] {0, 10, 0};
    jPanel11Layout.rowHeights = new int[] {0, 5, 0};
    jPanel11.setLayout(jPanel11Layout);

    jLabel41.setText("*Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel11.add(jLabel41, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel11.add(jtxtnombreareamod, gridBagConstraints);

    btnGuardarareamod.setMnemonic('G');
    btnGuardarareamod.setText("Guardar");
    btnGuardarareamod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGuardarareamodActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel11.add(btnGuardarareamod, gridBagConstraints);

    jDmodificarare.getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

    jDconsultatipe.setTitle("Consultar, modificar o eliminar un tipo de empleado");
    jDconsultatipe.setMinimumSize(new java.awt.Dimension(730, 459));
    jDconsultatipe.setModal(true);
    jDconsultatipe.setResizable(false);

    jPresultadoc2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado de la consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    btnlimpiarareacte.setMnemonic('i');
    btnlimpiarareacte.setText("Limpiar");
    btnlimpiarareacte.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarareacteActionPerformed(evt);
        }
    });

    tablaconsultatipe.setModel(dtmtipoe);
    tablaconsultatipe.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerastipe.length; column++){
        dtmtipoe.addColumn(cabecerastipe[column]);
    }
    tablaconsultatipe.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultatipeMouseClicked(evt);
        }
    });
    jScrollPane7.setViewportView(tablaconsultatipe);
    javax.swing.table.TableColumn columnz = null;
    for(int i = 0; i < tablaconsultatipe.getColumnCount(); i++)
    {
        columnz = tablaconsultatipe.getColumnModel().getColumn(i);
        if (i == 0){columnz.setPreferredWidth(100);}
        else if (i == 1){columnz.setPreferredWidth(200);}
        else if (i == 2){columnz.setPreferredWidth(200);}
        else if (i == 3){columnz.setPreferredWidth(100);}
    }

    jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel40.setText("Clic derecho sobre el registro que desee modificar o eliminar.");

    javax.swing.GroupLayout jPresultadoc2Layout = new javax.swing.GroupLayout(jPresultadoc2);
    jPresultadoc2.setLayout(jPresultadoc2Layout);
    jPresultadoc2Layout.setHorizontalGroup(
        jPresultadoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc2Layout.createSequentialGroup()
            .addGroup(jPresultadoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPresultadoc2Layout.createSequentialGroup()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGap(15, 15, 15)
                    .addComponent(btnlimpiarareacte, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPresultadoc2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPresultadoc2Layout.setVerticalGroup(
        jPresultadoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc2Layout.createSequentialGroup()
            .addComponent(jLabel40)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        .addGroup(jPresultadoc2Layout.createSequentialGroup()
            .addGap(126, 126, 126)
            .addComponent(btnlimpiarareacte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jDconsultatipe.getContentPane().add(jPresultadoc2, java.awt.BorderLayout.CENTER);

    jPcontcon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel12.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel12Layout = new java.awt.GridBagLayout();
    jPanel12Layout.columnWidths = new int[] {0, 10, 0};
    jPanel12Layout.rowHeights = new int[] {0, 5, 0};
    jPanel12.setLayout(jPanel12Layout);

    jLabel42.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    jPanel12.add(jLabel42, gridBagConstraints);

    txtcnomtipe.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomtipeKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    jPanel12.add(txtcnomtipe, gridBagConstraints);

    jPanel40.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnlimpiarnomtipe.setMnemonic('L');
    btnlimpiarnomtipe.setText("Limpiar");
    btnlimpiarnomtipe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarnomtipeActionPerformed(evt);
        }
    });
    jPanel40.add(btnlimpiarnomtipe);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel12.add(jPanel40, gridBagConstraints);

    jPcontcon2.add(jPanel12);

    jDconsultatipe.getContentPane().add(jPcontcon2, java.awt.BorderLayout.PAGE_START);

    jDmodificartipoe.setTitle("Modificar tipo de empleado");
    jDmodificartipoe.setIconImage(null);
    jDmodificartipoe.setMinimumSize(new java.awt.Dimension(438, 180));
    jDmodificartipoe.setModal(true);
    jDmodificartipoe.setResizable(false);

    jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jPanel13Layout = new java.awt.GridBagLayout();
    jPanel13Layout.columnWidths = new int[] {0, 10, 0};
    jPanel13Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
    jPanel13.setLayout(jPanel13Layout);

    jLabel44.setText("*Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel13.add(jLabel44, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 240;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel13.add(txtnombretipomod, gridBagConstraints);

    jLabel45.setText("*Tipo de sueldo");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel13.add(jLabel45, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPanel13.add(jCBtiposueldomod, gridBagConstraints);

    jLabel46.setText("*Sueldo $");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel13.add(jLabel46, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 80;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel13.add(txtsueldoemmod, gridBagConstraints);

    btnguardartipomod.setMnemonic('G');
    btnguardartipomod.setText("Guardar");
    btnguardartipomod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardartipomodActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 3;
    jPanel13.add(btnguardartipomod, gridBagConstraints);

    jDmodificartipoe.getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

    jDconsultahue.setTitle("Consultar, modificar o eliminar la huella del empleado");
    jDconsultahue.setMinimumSize(new java.awt.Dimension(780, 459));
    jDconsultahue.setModal(true);
    jDconsultahue.setResizable(false);

    jPresultadoc3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado de la consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    btnlimptabprohue.setMnemonic('i');
    btnlimptabprohue.setText("Limpiar");
    btnlimptabprohue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimptabprohueActionPerformed(evt);
        }
    });

    tablaconsultahue.setModel(dtmchue);
    tablaconsultahue.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabeceraschue.length; column++){
        dtmchue.addColumn(cabeceraschue[column]);
    }
    tablaconsultahue.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultahueMouseClicked(evt);
        }
    });
    jScrollPane8.setViewportView(tablaconsultahue);
    javax.swing.table.TableColumn columna = null;
    for(int i = 0; i < tablaconsultahue.getColumnCount(); i++)
    {
        columna = tablaconsultahue.getColumnModel().getColumn(i);
        if (i == 0){columna.setPreferredWidth(100);}
        else if (i == 1){columna.setPreferredWidth(300);}
        else if (i == 2){columna.setPreferredWidth(50);}
        else if (i == 3){columna.setPreferredWidth(200);}
    }

    jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel43.setText("Clic derecho sobre el registro que desee modificar o eliminar.");

    javax.swing.GroupLayout jPresultadoc3Layout = new javax.swing.GroupLayout(jPresultadoc3);
    jPresultadoc3.setLayout(jPresultadoc3Layout);
    jPresultadoc3Layout.setHorizontalGroup(
        jPresultadoc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc3Layout.createSequentialGroup()
            .addGroup(jPresultadoc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPresultadoc3Layout.createSequentialGroup()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGap(15, 15, 15)
                    .addComponent(btnlimptabprohue, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPresultadoc3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPresultadoc3Layout.setVerticalGroup(
        jPresultadoc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc3Layout.createSequentialGroup()
            .addComponent(jLabel43)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        .addGroup(jPresultadoc3Layout.createSequentialGroup()
            .addGap(126, 126, 126)
            .addComponent(btnlimptabprohue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jDconsultahue.getContentPane().add(jPresultadoc3, java.awt.BorderLayout.CENTER);

    jPcontcon3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel14.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel14Layout = new java.awt.GridBagLayout();
    jPanel14Layout.columnWidths = new int[] {0, 10, 0};
    jPanel14Layout.rowHeights = new int[] {0, 5, 0, 5, 0};
    jPanel14.setLayout(jPanel14Layout);

    jLabel47.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    jPanel14.add(jLabel47, gridBagConstraints);

    txtcnomprohue.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomprohueKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    jPanel14.add(txtcnomprohue, gridBagConstraints);

    jPanel41.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnlimpiarnprohue.setMnemonic('L');
    btnlimpiarnprohue.setText("Limpiar");
    btnlimpiarnprohue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarnprohueActionPerformed(evt);
        }
    });
    jPanel41.add(btnlimpiarnprohue);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel14.add(jPanel41, gridBagConstraints);

    jPcontcon3.add(jPanel14);

    jDconsultahue.getContentPane().add(jPcontcon3, java.awt.BorderLayout.PAGE_START);

    jDaltahorario.setTitle("Alta de horario de trabajo");
    jDaltahorario.setIconImage(null);
    jDaltahorario.setMinimumSize(new java.awt.Dimension(550, 560));
    jDaltahorario.setModal(true);
    jDaltahorario.setResizable(false);
    jDaltahorario.getContentPane().setLayout(new java.awt.BorderLayout(0, 1));

    jpcontdias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture la hora en tiempo de 24 horas (HH:mm).\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jpcontdiasLayout = new java.awt.GridBagLayout();
    jpcontdiasLayout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jpcontdiasLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
    jpcontdias.setLayout(jpcontdiasLayout);

    jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel28.setText("Día de la semana");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    jpcontdias.add(jLabel28, gridBagConstraints);

    jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel27.setText("Hora de entrada");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    jpcontdias.add(jLabel27, gridBagConstraints);

    jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel29.setText("Hora de salida");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    jpcontdias.add(jLabel29, gridBagConstraints);

    jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel30.setText("Domingo");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 18;
    jpcontdias.add(jLabel30, gridBagConstraints);

    txthoraentdom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentdom.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentdom, gridBagConstraints);

    txthorasaldom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasaldom.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasaldom, gridBagConstraints);

    jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel33.setText("Lunes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    jpcontdias.add(jLabel33, gridBagConstraints);

    txthoraentlun.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentlun.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentlun, gridBagConstraints);

    txthorasallun.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasallun.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasallun, gridBagConstraints);

    jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel31.setText("Martes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    jpcontdias.add(jLabel31, gridBagConstraints);

    txthoraentmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentmar.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentmar, gridBagConstraints);

    txthorasalmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalmar.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasalmar, gridBagConstraints);

    jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel32.setText("Miercoles");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    jpcontdias.add(jLabel32, gridBagConstraints);

    txthoraentmie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentmie.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentmie, gridBagConstraints);

    txthorasalmie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalmie.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasalmie, gridBagConstraints);

    jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel34.setText("Jueves");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    jpcontdias.add(jLabel34, gridBagConstraints);

    txthoraentjue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentjue.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentjue, gridBagConstraints);

    txthorasaljue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasaljue.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasaljue, gridBagConstraints);

    jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel35.setText("Viernes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 14;
    jpcontdias.add(jLabel35, gridBagConstraints);

    txthoraentvie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentvie.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentvie, gridBagConstraints);

    txthorasalvie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalvie.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasalvie, gridBagConstraints);

    jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel36.setText("Sabado");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 16;
    jpcontdias.add(jLabel36, gridBagConstraints);

    txthoraentsab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentsab.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthoraentsab, gridBagConstraints);

    txthorasalsab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalsab.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 50;
    jpcontdias.add(txthorasalsab, gridBagConstraints);

    jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minutos de tolerancia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPanel21Layout = new java.awt.GridBagLayout();
    jPanel21Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jPanel21Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
    jPanel21.setLayout(jPanel21Layout);

    jLabel86.setText("Antes de entrada del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    jPanel21.add(jLabel86, gridBagConstraints);

    jLabel75.setText("Despues de entrada del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    jPanel21.add(jLabel75, gridBagConstraints);

    jLabel90.setText("Antes de salida del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    jPanel21.add(jLabel90, gridBagConstraints);

    jLabel91.setText("Despues de salida del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    jPanel21.add(jLabel91, gridBagConstraints);

    txttoleantentdia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoleantentdia.setText("45");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 26;
    jPanel21.add(txttoleantentdia, gridBagConstraints);

    txttoledesentdia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoledesentdia.setText("10");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 26;
    jPanel21.add(txttoledesentdia, gridBagConstraints);

    txttoleantsaldia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoleantsaldia.setText("10");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 26;
    jPanel21.add(txttoleantsaldia, gridBagConstraints);

    txttoledessaldia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoledessaldia.setText("45");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 26;
    jPanel21.add(txttoledessaldia, gridBagConstraints);

    jLabel93.setText("¿Qué significa?");
    jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel93MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    jPanel21.add(jLabel93, gridBagConstraints);

    jLabel94.setText("¿Qué significa?");
    jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel94MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    jPanel21.add(jLabel94, gridBagConstraints);

    jLabel97.setText("¿Qué significa?");
    jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel97MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    jPanel21.add(jLabel97, gridBagConstraints);

    jLabel98.setText("¿Qué significa?");
    jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel98MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    jPanel21.add(jLabel98, gridBagConstraints);

    btnrestaurarminstol.setMnemonic('R');
    btnrestaurarminstol.setText("Restaurar");
    btnrestaurarminstol.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnrestaurarminstolActionPerformed(evt);
        }
    });
    jPanel50.add(btnrestaurarminstol);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 5;
    jPanel21.add(jPanel50, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 22;
    gridBagConstraints.gridwidth = 5;
    jpcontdias.add(jPanel21, gridBagConstraints);

    jLabel87.setText("MUY IMPORTANTE: El día o días no laborables dejar en hora de entrada y salida: 00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 5;
    jpcontdias.add(jLabel87, gridBagConstraints);

    jDaltahorario.getContentPane().add(jpcontdias, java.awt.BorderLayout.CENTER);

    jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel8.setMinimumSize(new java.awt.Dimension(100, 50));
    jPanel8.setPreferredSize(new java.awt.Dimension(538, 50));
    java.awt.GridBagLayout jPanel8Layout = new java.awt.GridBagLayout();
    jPanel8Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
    jPanel8Layout.rowHeights = new int[] {0, 5, 0};
    jPanel8.setLayout(jPanel8Layout);

    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel23.setText("Clave");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel8.add(jLabel23, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 100;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel8.add(txtclavehor, gridBagConstraints);

    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel25.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel8.add(jLabel25, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 200;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
    jPanel8.add(txtnombrehor, gridBagConstraints);

    jDaltahorario.getContentPane().add(jPanel8, java.awt.BorderLayout.NORTH);

    jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel9.setPreferredSize(new java.awt.Dimension(423, 40));
    java.awt.GridBagLayout jPanel9Layout = new java.awt.GridBagLayout();
    jPanel9Layout.columnWidths = new int[] {0};
    jPanel9Layout.rowHeights = new int[] {0};
    jPanel9.setLayout(jPanel9Layout);

    jPanel42.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnguardarhor.setMnemonic('G');
    btnguardarhor.setText("Guardar");
    btnguardarhor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardarhorActionPerformed(evt);
        }
    });
    jPanel42.add(btnguardarhor);

    btnlimpiarhor.setMnemonic('L');
    btnlimpiarhor.setText("Limpiar");
    btnlimpiarhor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarhorActionPerformed(evt);
        }
    });
    jPanel42.add(btnlimpiarhor);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    jPanel9.add(jPanel42, gridBagConstraints);

    jDaltahorario.getContentPane().add(jPanel9, java.awt.BorderLayout.SOUTH);

    jDconsultahor.setTitle("Consultar, modificar o eliminar un horario de trabajo");
    jDconsultahor.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng2.png")).getImage());
    jDconsultahor.setMinimumSize(new java.awt.Dimension(950, 550));
    jDconsultahor.setModal(true);

    jPresultadoc4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado de la consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    btnlimpiarareachor.setMnemonic('i');
    btnlimpiarareachor.setText("Limpiar");
    btnlimpiarareachor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarareachorActionPerformed(evt);
        }
    });

    tablaconsultahor.setModel(dtmchor);
    tablaconsultahor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerashor.length; column++){
        dtmchor.addColumn(cabecerashor[column]);
    }
    tablaconsultahor.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultahorMouseClicked(evt);
        }
    });
    jScrollPane9.setViewportView(tablaconsultahor);
    javax.swing.table.TableColumn columnb = null;
    for(int i = 0; i < tablaconsultahor.getColumnCount(); i++)
    {
        columnb = tablaconsultahor.getColumnModel().getColumn(i);
        if (i == 0){columnb.setPreferredWidth(100);}
        else if (i == 1){columnb.setPreferredWidth(200);}
        else if (i == 2){columnb.setPreferredWidth(100);}
        else if (i == 3){columnb.setPreferredWidth(100);}
        else if (i == 4){columnb.setPreferredWidth(100);}
        else if (i == 5){columnb.setPreferredWidth(100);}
        else if (i == 6){columnb.setPreferredWidth(100);}
        else if (i == 7){columnb.setPreferredWidth(100);}
        else if (i == 8){columnb.setPreferredWidth(100);}
        else if (i == 9){columnb.setPreferredWidth(100);}
        else if (i == 10){columnb.setPreferredWidth(100);}
        else if (i == 11){columnb.setPreferredWidth(100);}
        else if (i == 12){columnb.setPreferredWidth(100);}
        else if (i == 13){columnb.setPreferredWidth(100);}
        else if (i == 14){columnb.setPreferredWidth(100);}
        else if (i == 15){columnb.setPreferredWidth(100);}
        else if (i == 16){columnb.setPreferredWidth(100);}
        else if (i == 17){columnb.setPreferredWidth(125);}
        else if (i == 18){columnb.setPreferredWidth(125);}
        else if (i == 19){columnb.setPreferredWidth(125);}
        else if (i == 20){columnb.setPreferredWidth(125);}
    }

    jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel49.setText("Clic derecho sobre el registro que desee modificar o eliminar.");

    javax.swing.GroupLayout jPresultadoc4Layout = new javax.swing.GroupLayout(jPresultadoc4);
    jPresultadoc4.setLayout(jPresultadoc4Layout);
    jPresultadoc4Layout.setHorizontalGroup(
        jPresultadoc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc4Layout.createSequentialGroup()
            .addGroup(jPresultadoc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPresultadoc4Layout.createSequentialGroup()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addGap(15, 15, 15)
                    .addComponent(btnlimpiarareachor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPresultadoc4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPresultadoc4Layout.setVerticalGroup(
        jPresultadoc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPresultadoc4Layout.createSequentialGroup()
            .addComponent(jLabel49)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        .addGroup(jPresultadoc4Layout.createSequentialGroup()
            .addGap(135, 135, 135)
            .addComponent(btnlimpiarareachor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jDconsultahor.getContentPane().add(jPresultadoc4, java.awt.BorderLayout.CENTER);

    jPcontcon4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPanel16.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel16Layout = new java.awt.GridBagLayout();
    jPanel16Layout.columnWidths = new int[] {0, 10, 0};
    jPanel16Layout.rowHeights = new int[] {0, 5, 0};
    jPanel16.setLayout(jPanel16Layout);

    jLabel50.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
    jPanel16.add(jLabel50, gridBagConstraints);

    txtcnomhor.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomhorKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
    jPanel16.add(txtcnomhor, gridBagConstraints);

    jPanel43.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnconsultalhor.setMnemonic('L');
    btnconsultalhor.setText("Limpiar");
    btnconsultalhor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnconsultalhorActionPerformed(evt);
        }
    });
    jPanel43.add(btnconsultalhor);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel16.add(jPanel43, gridBagConstraints);

    jPcontcon4.add(jPanel16);

    jDconsultahor.getContentPane().add(jPcontcon4, java.awt.BorderLayout.PAGE_START);

    jDmodhorario.setTitle("Modificar horario de trabajo");
    jDmodhorario.setIconImage(null);
    jDmodhorario.setMinimumSize(new java.awt.Dimension(550, 560));
    jDmodhorario.setModal(true);
    jDmodhorario.setResizable(false);
    jDmodhorario.getContentPane().setLayout(new java.awt.BorderLayout(0, 1));

    jpcontdias1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture la hora en tiempo de 24 horas (HH:mm).\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jpcontdias1Layout = new java.awt.GridBagLayout();
    jpcontdias1Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jpcontdias1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
    jpcontdias1.setLayout(jpcontdias1Layout);

    jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel51.setText("Día de la semana");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    jpcontdias1.add(jLabel51, gridBagConstraints);

    jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel52.setText("Hora de entrada");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    jpcontdias1.add(jLabel52, gridBagConstraints);

    jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel53.setText("Hora de salida");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    jpcontdias1.add(jLabel53, gridBagConstraints);

    jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel54.setText("Domingo");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 18;
    jpcontdias1.add(jLabel54, gridBagConstraints);

    txthoraentdommod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentdommod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentdommod, gridBagConstraints);

    txthorasaldommod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasaldommod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasaldommod, gridBagConstraints);

    jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel55.setText("Lunes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    jpcontdias1.add(jLabel55, gridBagConstraints);

    txthoraentlunmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentlunmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentlunmod, gridBagConstraints);

    txthorasallunmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasallunmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasallunmod, gridBagConstraints);

    jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel56.setText("Martes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    jpcontdias1.add(jLabel56, gridBagConstraints);

    txthoraentmarmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentmarmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentmarmod, gridBagConstraints);

    txthorasalmarmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalmarmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasalmarmod, gridBagConstraints);

    jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel57.setText("Miercoles");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    jpcontdias1.add(jLabel57, gridBagConstraints);

    txthoraentmiemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentmiemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentmiemod, gridBagConstraints);

    txthorasalmiemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalmiemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasalmiemod, gridBagConstraints);

    jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel58.setText("Jueves");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    jpcontdias1.add(jLabel58, gridBagConstraints);

    txthoraentjuemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentjuemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentjuemod, gridBagConstraints);

    txthorasaljuemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasaljuemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasaljuemod, gridBagConstraints);

    jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel59.setText("Viernes");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 14;
    jpcontdias1.add(jLabel59, gridBagConstraints);

    txthoraentviemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentviemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentviemod, gridBagConstraints);

    txthorasalviemod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalviemod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasalviemod, gridBagConstraints);

    jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel60.setText("Sabado");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 16;
    jpcontdias1.add(jLabel60, gridBagConstraints);

    txthoraentsabmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthoraentsabmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthoraentsabmod, gridBagConstraints);

    txthorasalsabmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txthorasalsabmod.setText("00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 50;
    jpcontdias1.add(txthorasalsabmod, gridBagConstraints);

    jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minutos de tolerancia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPanel55Layout = new java.awt.GridBagLayout();
    jPanel55Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jPanel55Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
    jPanel55.setLayout(jPanel55Layout);

    jLabel89.setText("Antes de entrada del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    jPanel55.add(jLabel89, gridBagConstraints);

    jLabel92.setText("Despues de entrada del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    jPanel55.add(jLabel92, gridBagConstraints);

    jLabel95.setText("Antes de salida del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    jPanel55.add(jLabel95, gridBagConstraints);

    jLabel96.setText("Despues de salida del día");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    jPanel55.add(jLabel96, gridBagConstraints);

    txttoleantentdiamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoleantentdiamod.setText("45");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 26;
    jPanel55.add(txttoleantentdiamod, gridBagConstraints);

    txttoledesentdiamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoledesentdiamod.setText("10");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 26;
    jPanel55.add(txttoledesentdiamod, gridBagConstraints);

    txttoleantsaldiamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoleantsaldiamod.setText("10");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 26;
    jPanel55.add(txttoleantsaldiamod, gridBagConstraints);

    txttoledessaldiamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txttoledessaldiamod.setText("45");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 26;
    jPanel55.add(txttoledessaldiamod, gridBagConstraints);

    jLabel99.setText("¿Qué significa?");
    jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel99MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    jPanel55.add(jLabel99, gridBagConstraints);

    jLabel100.setText("¿Qué significa?");
    jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel100MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    jPanel55.add(jLabel100, gridBagConstraints);

    jLabel101.setText("¿Qué significa?");
    jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel101MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    jPanel55.add(jLabel101, gridBagConstraints);

    jLabel102.setText("¿Qué significa?");
    jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel102MouseClicked(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    jPanel55.add(jLabel102, gridBagConstraints);

    btnrestaurarminstolmod.setMnemonic('R');
    btnrestaurarminstolmod.setText("Restaurar");
    btnrestaurarminstolmod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnrestaurarminstolmodActionPerformed(evt);
        }
    });
    jPanel56.add(btnrestaurarminstolmod);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 5;
    jPanel55.add(jPanel56, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 22;
    gridBagConstraints.gridwidth = 5;
    jpcontdias1.add(jPanel55, gridBagConstraints);

    jLabel103.setText("MUY IMPORTANTE: El día o días no laborables dejar en hora de entrada y salida: 00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 5;
    jpcontdias1.add(jLabel103, gridBagConstraints);

    jDmodhorario.getContentPane().add(jpcontdias1, java.awt.BorderLayout.CENTER);

    jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel23.setMinimumSize(new java.awt.Dimension(100, 50));
    jPanel23.setPreferredSize(new java.awt.Dimension(538, 50));
    java.awt.GridBagLayout jPanel23Layout = new java.awt.GridBagLayout();
    jPanel23Layout.columnWidths = new int[] {0, 10, 0};
    jPanel23Layout.rowHeights = new int[] {0};
    jPanel23.setLayout(jPanel23Layout);

    jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel63.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel23.add(jLabel63, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 200;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel23.add(txtnombrehormod, gridBagConstraints);

    jDmodhorario.getContentPane().add(jPanel23, java.awt.BorderLayout.NORTH);

    jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel24.setPreferredSize(new java.awt.Dimension(423, 40));
    jPanel24.setLayout(new java.awt.GridBagLayout());

    btnguardarhormod.setMnemonic('G');
    btnguardarhormod.setText("Guardar");
    btnguardarhormod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardarhormodActionPerformed(evt);
        }
    });
    jPanel24.add(btnguardarhormod, new java.awt.GridBagConstraints());

    jDmodhorario.getContentPane().add(jPanel24, java.awt.BorderLayout.SOUTH);

    jDcalculonomina.setTitle("Calculo de nomina");
    jDcalculonomina.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng3.png")).getImage());
    jDcalculonomina.setMinimumSize(new java.awt.Dimension(900, 600));
    jDcalculonomina.setModal(true);

    jPfechainifinnom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPfechainifinnom.setMinimumSize(new java.awt.Dimension(582, 150));
    jPfechainifinnom.setPreferredSize(new java.awt.Dimension(678, 100));

    java.awt.GridBagLayout jPanel25Layout = new java.awt.GridBagLayout();
    jPanel25Layout.columnWidths = new int[] {0, 10, 0};
    jPanel25Layout.rowHeights = new int[] {0, 5, 0};
    jPanel25.setLayout(jPanel25Layout);

    jLabel62.setText("Fecha inicio:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel25.add(jLabel62, gridBagConstraints);

    dCfechainicio.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 45;
    jPanel25.add(dCfechainicio, gridBagConstraints);

    jLabel66.setText("Fecha fin:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel25.add(jLabel66, gridBagConstraints);

    dCfechafin.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 45;
    jPanel25.add(dCfechafin, gridBagConstraints);

    jPfechainifinnom.add(jPanel25);

    jPcontnomnom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Seleccione el nombre del empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPcontnomnomLayout = new java.awt.GridBagLayout();
    jPcontnomnomLayout.columnWidths = new int[] {0, 10, 0};
    jPcontnomnomLayout.rowHeights = new int[] {0, 5, 0};
    jPcontnomnom.setLayout(jPcontnomnomLayout);

    jLabel67.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPcontnomnom.add(jLabel67, gridBagConstraints);

    jCBempleadosnom.setMaximumRowCount(15);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPcontnomnom.add(jCBempleadosnom, gridBagConstraints);

    jPanel15.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btncalcularnom.setMnemonic('C');
    btncalcularnom.setText("Calcular");
    btncalcularnom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncalcularnomActionPerformed(evt);
        }
    });
    jPanel15.add(btncalcularnom);

    jBlimpiarconnom.setMnemonic('L');
    jBlimpiarconnom.setText("Limpiar");
    jBlimpiarconnom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBlimpiarconnomActionPerformed(evt);
        }
    });
    jPanel15.add(jBlimpiarconnom);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPcontnomnom.add(jPanel15, gridBagConstraints);

    jPfechainifinnom.add(jPcontnomnom);
    jPfechainifinnom.add(jPanel51);

    jDcalculonomina.getContentPane().add(jPfechainifinnom, java.awt.BorderLayout.NORTH);

    jPresultnom.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPresultnom.setPreferredSize(new java.awt.Dimension(800, 400));
    jPresultnom.setLayout(new java.awt.BorderLayout());

    resultconnom.setColumns(20);
    resultconnom.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
    resultconnom.setRows(5);
    jScrollPane2.setViewportView(resultconnom);

    jPresultnom.add(jScrollPane2, java.awt.BorderLayout.CENTER);

    jPanel26.setLayout(new java.awt.GridLayout(1, 2, 3, 3));

    btnimprimirnom.setMnemonic('I');
    btnimprimirnom.setText("Imprimir");
    btnimprimirnom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnimprimirnomActionPerformed(evt);
        }
    });
    jPanel26.add(btnimprimirnom);

    jBlimpiarresulnom.setMnemonic('L');
    jBlimpiarresulnom.setText("Limpiar");
    jBlimpiarresulnom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBlimpiarresulnomActionPerformed(evt);
        }
    });
    jPanel26.add(jBlimpiarresulnom);

    jPanel18.add(jPanel26);

    jPresultnom.add(jPanel18, java.awt.BorderLayout.SOUTH);

    jDcalculonomina.getContentPane().add(jPresultnom, java.awt.BorderLayout.CENTER);

    jDactcontraseña.setTitle("Capturar o actualizar contraseña");
    jDactcontraseña.setMinimumSize(new java.awt.Dimension(450, 175));
    jDactcontraseña.setModal(true);
    jDactcontraseña.setResizable(false);

    jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jPanel22Layout = new java.awt.GridBagLayout();
    jPanel22Layout.columnWidths = new int[] {0, 10, 0};
    jPanel22Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
    jPanel22.setLayout(jPanel22Layout);

    jLabel61.setText("*Nueva contraseña");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 46;
    gridBagConstraints.ipady = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(jLabel61, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 170;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(jpnuevacontra, gridBagConstraints);

    jLabel68.setText("*Confirmar contraseña");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 30;
    gridBagConstraints.ipady = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(jLabel68, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 170;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(jpcnuevacontra, gridBagConstraints);

    jLabel69.setText("*Indicio de contraseña");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 31;
    gridBagConstraints.ipady = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(jLabel69, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 250;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel22.add(txtindiciocontra, gridBagConstraints);

    jPanel44.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnguarcontra.setMnemonic('G');
    btnguarcontra.setText("Guardar");
    btnguarcontra.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguarcontraActionPerformed(evt);
        }
    });
    jPanel44.add(btnguarcontra);

    btnlimpdtscontra.setMnemonic('L');
    btnlimpdtscontra.setText("Limpiar");
    btnlimpdtscontra.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpdtscontraActionPerformed(evt);
        }
    });
    jPanel44.add(btnlimpdtscontra);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.insets = new java.awt.Insets(11, 3, 14, 0);
    jPanel22.add(jPanel44, gridBagConstraints);

    jDactcontraseña.getContentPane().add(jPanel22, java.awt.BorderLayout.CENTER);

    jDpedirclave.setTitle("Capture la clave del administrador");
    jDpedirclave.setAlwaysOnTop(true);
    jDpedirclave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jDpedirclave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jDpedirclave.setMinimumSize(new java.awt.Dimension(346, 175));
    jDpedirclave.setModal(true);
    jDpedirclave.setResizable(false);
    jDpedirclave.setUndecorated(true);
    jDpedirclave.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            jDpedirclaveWindowClosing(evt);
        }
    });

    jPclave.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "¿Primera vez?, presione Aceptar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPclaveLayout = new java.awt.GridBagLayout();
    jPclaveLayout.columnWidths = new int[] {0, 10, 0};
    jPclaveLayout.rowHeights = new int[] {0, 10, 0};
    jPclave.setLayout(jPclaveLayout);

    jLabel70.setText("Clave:");
    jLabel70.setPreferredSize(new java.awt.Dimension(50, 14));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    jPclave.add(jLabel70, gridBagConstraints);

    jppassword.setColumns(15);
    jppassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jppassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    jPclave.add(jppassword, gridBagConstraints);

    jPanel45.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnaceptarclv.setMnemonic('A');
    btnaceptarclv.setText("Aceptar");
    btnaceptarclv.setPreferredSize(new java.awt.Dimension(100, 23));
    btnaceptarclv.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnaceptarclvActionPerformed(evt);
        }
    });
    jPanel45.add(btnaceptarclv);

    btncancelarclv.setMnemonic('C');
    btncancelarclv.setText("Cancelar");
    btncancelarclv.setPreferredSize(new java.awt.Dimension(100, 23));
    btncancelarclv.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncancelarclvActionPerformed(evt);
        }
    });
    jPanel45.add(btncancelarclv);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPclave.add(jPanel45, gridBagConstraints);

    jDpedirclave.getContentPane().add(jPclave, java.awt.BorderLayout.CENTER);

    jPindicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    lblindicio.setText("Indicio");
    lblindicio.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblindicioMouseClicked(evt);
        }
    });
    jPindicio.add(lblindicio);

    jDpedirclave.getContentPane().add(jPindicio, java.awt.BorderLayout.SOUTH);

    jDpedirclave.getAccessibleContext().setAccessibleParent(null);

    jDaltachecada.setTitle("Alta de checadas");
    jDaltachecada.setMinimumSize(new java.awt.Dimension(490, 210));
    jDaltachecada.setModal(true);
    jDaltachecada.setResizable(false);

    jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture la hora en tiempo de 24 horas (HH:mm:ss). ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPanel27Layout = new java.awt.GridBagLayout();
    jPanel27Layout.columnWidths = new int[] {0, 23, 0};
    jPanel27Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0};
    jPanel27.setLayout(jPanel27Layout);

    jLabel24.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel27.add(jLabel24, gridBagConstraints);

    jCBempchec.setMaximumRowCount(12);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 0.8;
    gridBagConstraints.weighty = 0.1;
    jPanel27.add(jCBempchec, gridBagConstraints);

    jLabel71.setText("Fecha");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel27.add(jLabel71, gridBagConstraints);

    dCCfechchec.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel27.add(dCCfechchec, gridBagConstraints);

    jLabel72.setText("Hora");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel27.add(jLabel72, gridBagConstraints);

    txthrchec.setColumns(8);
    txthrchec.setText("00:00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipady = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel27.add(txthrchec, gridBagConstraints);

    jPanel29.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    btnguardarche.setMnemonic('G');
    btnguardarche.setText("Guardar");
    btnguardarche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardarcheActionPerformed(evt);
        }
    });
    jPanel29.add(btnguardarche);

    btnlimpiarche.setMnemonic('L');
    btnlimpiarche.setText("Limpiar");
    btnlimpiarche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarcheActionPerformed(evt);
        }
    });
    jPanel29.add(btnlimpiarche);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 3;
    jPanel27.add(jPanel29, gridBagConstraints);

    javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
    jPanel28.setLayout(jPanel28Layout);
    jPanel28Layout.setHorizontalGroup(
        jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel28Layout.setVerticalGroup(
        jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    jPanel27.add(jPanel28, gridBagConstraints);

    jDaltachecada.getContentPane().add(jPanel27, java.awt.BorderLayout.CENTER);

    jDconsultachec.setTitle("Consultar, modificar o eliminar las checadas del empleado");
    jDconsultachec.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng5.png")).getImage());
    jDconsultachec.setMinimumSize(new java.awt.Dimension(780, 459));
    jDconsultachec.setModal(true);

    jPresultadoc5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Clic derecho sobre el registro que desee modificar o eliminar.", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPresultadoc5.setLayout(new java.awt.BorderLayout());

    tablaconsultachec.setModel(dtmcchec);
    tablaconsultachec.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabeceraschec.length; column++){
        dtmcchec.addColumn(cabeceraschec[column]);
    }
    tablaconsultachec.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultachecMouseClicked(evt);
        }
    });
    jScrollPane10.setViewportView(tablaconsultachec);
    javax.swing.table.TableColumn columnc = null;
    for(int i = 0; i < tablaconsultachec.getColumnCount(); i++)
    {
        columnc = tablaconsultachec.getColumnModel().getColumn(i);
        if (i == 0){columnc.setPreferredWidth(100);}
        else if (i == 1){columnc.setPreferredWidth(300);}
        else if (i == 2){columnc.setPreferredWidth(100);}
        else if (i == 3){columnc.setPreferredWidth(100);}
        else if (i == 4){columnc.setPreferredWidth(150);}
    }

    jPresultadoc5.add(jScrollPane10, java.awt.BorderLayout.CENTER);

    btnlimptabcche.setMnemonic('i');
    btnlimptabcche.setText("Limpiar");
    btnlimptabcche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimptabccheActionPerformed(evt);
        }
    });
    jPanel20.add(btnlimptabcche);

    jPresultadoc5.add(jPanel20, java.awt.BorderLayout.SOUTH);

    jDconsultachec.getContentPane().add(jPresultadoc5, java.awt.BorderLayout.CENTER);

    jPcontcon5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    java.awt.GridBagLayout jPanel32Layout = new java.awt.GridBagLayout();
    jPanel32Layout.columnWidths = new int[] {0, 23, 0};
    jPanel32Layout.rowHeights = new int[] {0, 9, 0};
    jPanel32.setLayout(jPanel32Layout);

    jLabel77.setText("Fecha inicio:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel32.add(jLabel77, gridBagConstraints);

    dCfechainicioche.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    jPanel32.add(dCfechainicioche, gridBagConstraints);

    jLabel78.setText("Fecha fin:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel32.add(jLabel78, gridBagConstraints);

    dCfechafinche.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    jPanel32.add(dCfechafinche, gridBagConstraints);

    jPcontcon5.add(jPanel32);

    jPanel30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel30.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel30Layout = new java.awt.GridBagLayout();
    jPanel30Layout.columnWidths = new int[] {0, 10, 0};
    jPanel30Layout.rowHeights = new int[] {0, 9, 0};
    jPanel30.setLayout(jPanel30Layout);

    jLabel76.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
    jPanel30.add(jLabel76, gridBagConstraints);

    jPanel33.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    jButton1.setMnemonic('C');
    jButton1.setText("Consultar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel33.add(jButton1);

    btnlimpiarpnomche.setMnemonic('L');
    btnlimpiarpnomche.setText("Limpiar");
    btnlimpiarpnomche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarpnomcheActionPerformed(evt);
        }
    });
    jPanel33.add(btnlimpiarpnomche);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
    jPanel30.add(jPanel33, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 2);
    jPanel30.add(jCBnomempchec, gridBagConstraints);

    jPcontcon5.add(jPanel30);

    jDconsultachec.getContentPane().add(jPcontcon5, java.awt.BorderLayout.PAGE_START);

    jDpclvdelche.setTitle("¿Realmente desea eliminar todas las checadas?");
    jDpclvdelche.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jDpclvdelche.setMinimumSize(new java.awt.Dimension(410, 175));
    jDpclvdelche.setModal(true);
    jDpclvdelche.setResizable(false);
    jDpclvdelche.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent evt) {
            jDpclvdelcheWindowClosing(evt);
        }
    });

    jPclave1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Capture la contraseña del administrador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPclave1Layout = new java.awt.GridBagLayout();
    jPclave1Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jPclave1Layout.rowHeights = new int[] {0, 9, 0};
    jPclave1.setLayout(jPclave1Layout);

    jLabel79.setText("Clave:");
    jLabel79.setPreferredSize(new java.awt.Dimension(50, 14));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    jPclave1.add(jLabel79, gridBagConstraints);

    jppassworddelche.setColumns(15);
    jppassworddelche.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jppassworddelche.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    jPclave1.add(jppassworddelche, gridBagConstraints);

    jPanel34.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnaceptarclvdelc.setMnemonic('A');
    btnaceptarclvdelc.setText("Aceptar");
    btnaceptarclvdelc.setPreferredSize(new java.awt.Dimension(100, 23));
    btnaceptarclvdelc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnaceptarclvdelcActionPerformed(evt);
        }
    });
    jPanel34.add(btnaceptarclvdelc);

    btncancelarclvdelc.setMnemonic('C');
    btncancelarclvdelc.setText("Cancelar");
    btncancelarclvdelc.setPreferredSize(new java.awt.Dimension(100, 23));
    btncancelarclvdelc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncancelarclvdelcActionPerformed(evt);
        }
    });
    jPanel34.add(btncancelarclvdelc);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 5;
    jPclave1.add(jPanel34, gridBagConstraints);

    jDpclvdelche.getContentPane().add(jPclave1, java.awt.BorderLayout.CENTER);
    jPclave1.getAccessibleContext().setAccessibleName("");

    jPindicio1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    lblindiciodelche.setText("Indicio");
    lblindiciodelche.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblindiciodelcheMouseClicked(evt);
        }
    });
    jPindicio1.add(lblindiciodelche);

    jDpclvdelche.getContentPane().add(jPindicio1, java.awt.BorderLayout.SOUTH);

    jDpedirclave.getAccessibleContext().setAccessibleParent(null);

    jDmodchecada.setTitle("Modificar checadas");
    jDmodchecada.setMinimumSize(new java.awt.Dimension(490, 210));
    jDmodchecada.setModal(true);
    jDmodchecada.setResizable(false);

    jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Capture la hora en tiempo de 24 horas (HH:mm:ss). ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPanel47Layout = new java.awt.GridBagLayout();
    jPanel47Layout.columnWidths = new int[] {0, 23, 0};
    jPanel47Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0};
    jPanel47.setLayout(jPanel47Layout);

    jLabel80.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel47.add(jLabel80, gridBagConstraints);

    jCBempchecmod.setMaximumRowCount(12);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 0.8;
    gridBagConstraints.weighty = 0.1;
    jPanel47.add(jCBempchecmod, gridBagConstraints);

    jLabel81.setText("Fecha");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel47.add(jLabel81, gridBagConstraints);

    dCCfechchecmod.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel47.add(dCCfechchecmod, gridBagConstraints);

    jLabel82.setText("Hora");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel47.add(jLabel82, gridBagConstraints);

    txthrchecmod.setColumns(8);
    txthrchecmod.setText("00:00:00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipady = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel47.add(txthrchecmod, gridBagConstraints);

    jPanel48.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    btnguardarchemod.setMnemonic('G');
    btnguardarchemod.setText("Guardar");
    btnguardarchemod.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardarchemodActionPerformed(evt);
        }
    });
    jPanel48.add(btnguardarchemod);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 3;
    jPanel47.add(jPanel48, gridBagConstraints);

    jDmodchecada.getContentPane().add(jPanel47, java.awt.BorderLayout.CENTER);

    jDasistencia.setTitle("Consultar asistencia");
    jDasistencia.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng4.png")).getImage());
    jDasistencia.setMinimumSize(new java.awt.Dimension(900, 600));
    jDasistencia.setModal(true);

    jPfechainifinnom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPfechainifinnom1.setMinimumSize(new java.awt.Dimension(582, 150));
    jPfechainifinnom1.setPreferredSize(new java.awt.Dimension(678, 100));

    java.awt.GridBagLayout jPanel31Layout = new java.awt.GridBagLayout();
    jPanel31Layout.columnWidths = new int[] {0, 10, 0};
    jPanel31Layout.rowHeights = new int[] {0, 5, 0};
    jPanel31.setLayout(jPanel31Layout);

    jLabel83.setText("Fecha inicio:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel31.add(jLabel83, gridBagConstraints);

    dCfechainiasis.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 45;
    jPanel31.add(dCfechainiasis, gridBagConstraints);

    jLabel84.setText("Fecha fin:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    jPanel31.add(jLabel84, gridBagConstraints);

    dCfechafinasis.setLocale(new java.util.Locale("en", "ZA", ""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 45;
    jPanel31.add(dCfechafinasis, gridBagConstraints);

    jPfechainifinnom1.add(jPanel31);

    jPcontnomnom1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Seleccione el nombre del empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPcontnomnom1Layout = new java.awt.GridBagLayout();
    jPcontnomnom1Layout.columnWidths = new int[] {0, 10, 0};
    jPcontnomnom1Layout.rowHeights = new int[] {0, 5, 0};
    jPcontnomnom1.setLayout(jPcontnomnom1Layout);

    jLabel85.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPcontnomnom1.add(jLabel85, gridBagConstraints);

    jCBempleadosasis.setMaximumRowCount(15);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPcontnomnom1.add(jCBempleadosasis, gridBagConstraints);

    jPanel17.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnconsultarasis.setMnemonic('C');
    btnconsultarasis.setText("Consultar");
    btnconsultarasis.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnconsultarasisActionPerformed(evt);
        }
    });
    jPanel17.add(btnconsultarasis);

    btnlimpiarcona.setMnemonic('L');
    btnlimpiarcona.setText("Limpiar");
    btnlimpiarcona.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarconaActionPerformed(evt);
        }
    });
    jPanel17.add(btnlimpiarcona);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPcontnomnom1.add(jPanel17, gridBagConstraints);

    jPfechainifinnom1.add(jPcontnomnom1);

    jDasistencia.getContentPane().add(jPfechainifinnom1, java.awt.BorderLayout.NORTH);

    jPresultasis.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Resultado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPresultasis.setPreferredSize(new java.awt.Dimension(800, 400));
    jPresultasis.setLayout(new java.awt.BorderLayout());

    jPanel19.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnlimpiarresas.setMnemonic('I');
    btnlimpiarresas.setText("Imprimir");
    jPanel19.add(btnlimpiarresas);

    btnlimpiarresulasis.setMnemonic('L');
    btnlimpiarresulasis.setText("Limpiar");
    btnlimpiarresulasis.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiarresulasisActionPerformed(evt);
        }
    });
    jPanel19.add(btnlimpiarresulasis);

    jPanel49.add(jPanel19);

    jPresultasis.add(jPanel49, java.awt.BorderLayout.SOUTH);

    tablaasistencia.setModel(dtmcasis);
    tablaasistencia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerasasis.length; column++){
        dtmcasis.addColumn(cabecerasasis[column]);
    }
    jScrollPane4.setViewportView(tablaasistencia);
    javax.swing.table.TableColumn columnd = null;
    for(int i = 0; i < tablaasistencia.getColumnCount(); i++)
    {
        columnd = tablaasistencia.getColumnModel().getColumn(i);
        if (i == 0){columnd.setPreferredWidth(100);}
        else if (i == 1){columnd.setPreferredWidth(300);}
        else if (i == 2){columnd.setPreferredWidth(120);}
        else if (i == 3){columnd.setPreferredWidth(120);}
        else if (i == 4){columnd.setPreferredWidth(120);}
        else if (i == 5){columnd.setPreferredWidth(120);}
        else if (i == 6){columnd.setPreferredWidth(120);}
        else if (i == 7){columnd.setPreferredWidth(120);}
        else if (i == 8){columnd.setPreferredWidth(120);}
    }

    jPresultasis.add(jScrollPane4, java.awt.BorderLayout.CENTER);

    jDasistencia.getContentPane().add(jPresultasis, java.awt.BorderLayout.CENTER);

    jDhoraextra.setTitle("Capturar o actualizar pago de hora extra");
    jDhoraextra.setMinimumSize(new java.awt.Dimension(350, 115));
    jDhoraextra.setModal(true);
    jDhoraextra.setResizable(false);
    jDhoraextra.getContentPane().setLayout(new java.awt.BorderLayout(0, 5));

    jPanel53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jPanel54.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    jButton2.setMnemonic('G');
    jButton2.setText("Guardar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel54.add(jButton2);

    jButton3.setMnemonic('L');
    jButton3.setText("Limpiar");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel54.add(jButton3);

    jPanel53.add(jPanel54);

    jDhoraextra.getContentPane().add(jPanel53, java.awt.BorderLayout.SOUTH);

    jPanel52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel88.setText("Pago por hora $");
    jPanel52.add(jLabel88);

    txtpagohrex.setColumns(5);
    jPanel52.add(txtpagohrex);

    jDhoraextra.getContentPane().add(jPanel52, java.awt.BorderLayout.CENTER);

    jDaltajustificante.setTitle("Alta de justificante");
    jDaltajustificante.setMinimumSize(new java.awt.Dimension(271, 122));
    jDaltajustificante.setModal(true);
    jDaltajustificante.setResizable(false);

    jPanel57.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jPanel57Layout = new java.awt.GridBagLayout();
    jPanel57Layout.columnWidths = new int[] {0, 10, 0};
    jPanel57Layout.rowHeights = new int[] {0, 5, 0, 5, 0};
    jPanel57.setLayout(jPanel57Layout);

    jLabel104.setText("Clave");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel57.add(jLabel104, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 60;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel57.add(txtclvaltajusti, gridBagConstraints);

    jLabel105.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel57.add(jLabel105, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 140;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel57.add(txtnombrealtajusti, gridBagConstraints);

    jPanel58.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    jBtguardarjusti.setMnemonic('G');
    jBtguardarjusti.setText("Guardar");
    jBtguardarjusti.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBtguardarjustiActionPerformed(evt);
        }
    });
    jPanel58.add(jBtguardarjusti);

    jBlimpiardtsaltajus.setMnemonic('L');
    jBlimpiardtsaltajus.setText("Limpiar");
    jBlimpiardtsaltajus.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBlimpiardtsaltajusActionPerformed(evt);
        }
    });
    jPanel58.add(jBlimpiardtsaltajus);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 3;
    jPanel57.add(jPanel58, gridBagConstraints);

    jDaltajustificante.getContentPane().add(jPanel57, java.awt.BorderLayout.CENTER);

    jDconsultajust.setTitle("Consultar, modificar o eliminar un justificante");
    jDconsultajust.setMinimumSize(new java.awt.Dimension(420, 400));
    jDconsultajust.setModal(true);
    jDconsultajust.setResizable(false);

    jPresultadoc6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Clic derecho sobre el registro que desee modificar o eliminar.", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    jPresultadoc6.setLayout(new java.awt.BorderLayout());

    tablaconsultajusti.setModel(dtmjustificante);
    tablaconsultajusti.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    // insertamos las cabeceras
    for(int column = 0; column < cabecerasjust.length; column++){
        dtmjustificante.addColumn(cabecerasjust[column]);
    }
    tablaconsultajusti.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaconsultajustiMouseClicked(evt);
        }
    });
    jScrollPane11.setViewportView(tablaconsultajusti);
    javax.swing.table.TableColumn columnm = null;
    for(int i = 0; i < tablaconsultajusti.getColumnCount(); i++)
    {
        columnm = tablaconsultajusti.getColumnModel().getColumn(i);
        if (i == 0){columnm.setPreferredWidth(100);}
        else if (i == 1){columnm.setPreferredWidth(300);}
    }

    jPresultadoc6.add(jScrollPane11, java.awt.BorderLayout.CENTER);

    btnlimpiartablajus.setMnemonic('i');
    btnlimpiartablajus.setText("Limpiar");
    btnlimpiartablajus.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiartablajusActionPerformed(evt);
        }
    });
    jPanel61.add(btnlimpiartablajus);

    jPresultadoc6.add(jPanel61, java.awt.BorderLayout.SOUTH);

    jDconsultajust.getContentPane().add(jPresultadoc6, java.awt.BorderLayout.CENTER);

    jPcontcon6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Capture el nombre o presione enter", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

    jPanel59.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel59.setMinimumSize(new java.awt.Dimension(150, 54));
    java.awt.GridBagLayout jPanel59Layout = new java.awt.GridBagLayout();
    jPanel59Layout.columnWidths = new int[] {0, 10, 0};
    jPanel59Layout.rowHeights = new int[] {0, 5, 0};
    jPanel59.setLayout(jPanel59Layout);

    jLabel107.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 1);
    jPanel59.add(jLabel107, gridBagConstraints);

    txtcnomjust.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtcnomjustKeyTyped(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 5);
    jPanel59.add(txtcnomjust, gridBagConstraints);

    jPanel60.setLayout(new java.awt.GridLayout(1, 2, 2, 0));

    btnconsultalimjus.setMnemonic('L');
    btnconsultalimjus.setText("Limpiar");
    btnconsultalimjus.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnconsultalimjusActionPerformed(evt);
        }
    });
    jPanel60.add(btnconsultalimjus);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
    jPanel59.add(jPanel60, gridBagConstraints);

    jPcontcon6.add(jPanel59);

    jDconsultajust.getContentPane().add(jPcontcon6, java.awt.BorderLayout.PAGE_START);

    jDmodjustificante.setTitle("Modificar justificante");
    jDmodjustificante.setMinimumSize(new java.awt.Dimension(271, 122));
    jDmodjustificante.setModal(true);
    jDmodjustificante.setResizable(false);

    jPanel62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    java.awt.GridBagLayout jPanel62Layout = new java.awt.GridBagLayout();
    jPanel62Layout.columnWidths = new int[] {0, 10, 0};
    jPanel62Layout.rowHeights = new int[] {0, 5, 0};
    jPanel62.setLayout(jPanel62Layout);

    jLabel108.setText("Nombre");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel62.add(jLabel108, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 140;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel62.add(txtnombremodjusti, gridBagConstraints);

    jPanel63.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    jBtmodificarjusti.setMnemonic('G');
    jBtmodificarjusti.setText("Guardar");
    jBtmodificarjusti.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBtmodificarjustiActionPerformed(evt);
        }
    });
    jPanel63.add(jBtmodificarjusti);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 3;
    jPanel62.add(jPanel63, gridBagConstraints);

    jDmodjustificante.getContentPane().add(jPanel62, java.awt.BorderLayout.CENTER);

    jDcapactdedugral.setTitle("Captura/actualización de deducciones generales");
    jDcapactdedugral.setMinimumSize(new java.awt.Dimension(395, 300));
    jDcapactdedugral.setModal(true);
    jDcapactdedugral.setResizable(false);

    jPanel64.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOTA: Estas deducciones se aplican a todos los empleados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    java.awt.GridBagLayout jPanel64Layout = new java.awt.GridBagLayout();
    jPanel64Layout.columnWidths = new int[] {0, 10, 0};
    jPanel64Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
    jPanel64.setLayout(jPanel64Layout);

    jLabel106.setText("Falta");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel106, gridBagConstraints);

    txtdescuentofalta.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentofalta, gridBagConstraints);

    jLabel109.setText("Permiso");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel109, gridBagConstraints);

    txtdescuentopermiso.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentopermiso, gridBagConstraints);

    jLabel110.setText("Comedor");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel110, gridBagConstraints);

    txtdescuentocomedor.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentocomedor, gridBagConstraints);

    jPanel65.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    btnguardardedu.setMnemonic('G');
    btnguardardedu.setText("Guardar");
    btnguardardedu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardardeduActionPerformed(evt);
        }
    });
    jPanel65.add(btnguardardedu);

    btnlimpiardtsdedu.setMnemonic('L');
    btnlimpiardtsdedu.setText("Limpiar");
    btnlimpiardtsdedu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnlimpiardtsdeduActionPerformed(evt);
        }
    });
    jPanel65.add(btnlimpiardtsdedu);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.gridwidth = 3;
    jPanel64.add(jPanel65, gridBagConstraints);

    jLabel111.setText("Transporte");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel111, gridBagConstraints);

    txtdescuentotrans.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentotrans, gridBagConstraints);

    jLabel112.setText("IMSS");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel112, gridBagConstraints);

    txtdescuentoimss.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentoimss, gridBagConstraints);

    jLabel113.setText("INFONAVIT");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel113, gridBagConstraints);

    txtdescuentoinfona.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentoinfona, gridBagConstraints);

    jLabel114.setText("Otro");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel114, gridBagConstraints);

    txtdescuentootro.setText("0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(txtdescuentootro, gridBagConstraints);

    jLabel115.setText("Deducción");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel115, gridBagConstraints);

    jLabel116.setText("Descuento $");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel64.add(jLabel116, gridBagConstraints);

    jLabel117.setText("En las deducciones que no aplica dejar 0");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    jPanel64.add(jLabel117, gridBagConstraints);

    jDcapactdedugral.getContentPane().add(jPanel64, java.awt.BorderLayout.CENTER);

    grupobotonesop.add(jRBmeñiquei);
    grupobotonesop.add(jRBanulari);
    grupobotonesop.add(jRBmedioi);
    grupobotonesop.add(jRBindicei);
    grupobotonesop.add(jRBpulgari);
    grupobotonesop.add(jRBmeñiqued);
    grupobotonesop.add(jRBanulard);
    grupobotonesop.add(jRBmediod);
    grupobotonesop.add(jRBindiced);
    grupobotonesop.add(jRBpulgard);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("TECHNO-CYBER, ACTIPAN");
    setIconImage(new ImageIcon(getClass().getResource("/imagenes/logoadminpng.png")).getImage());

    jMAdministrador.setMnemonic('A');
    jMAdministrador.setText("Administrador");

    jMenuItem3.setText("Contraseña");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
        }
    });
    jMAdministrador.add(jMenuItem3);

    jMenuBar1.add(jMAdministrador);

    jMarea.setMnemonic('r');
    jMarea.setText("Área");

    jMIaltaarea.setText("Alta");
    jMIaltaarea.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIaltaareaActionPerformed(evt);
        }
    });
    jMarea.add(jMIaltaarea);

    jMIconsultaare.setText("Cons/Modi/Elim");
    jMIconsultaare.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIconsultaareActionPerformed(evt);
        }
    });
    jMarea.add(jMIconsultaare);

    jMenuBar1.add(jMarea);

    jMtipoempleado.setMnemonic('T');
    jMtipoempleado.setText("Tipo de empleado");

    jMIaltatipoempleado.setText("Alta");
    jMIaltatipoempleado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIaltatipoempleadoActionPerformed(evt);
        }
    });
    jMtipoempleado.add(jMIaltatipoempleado);

    jMIconsultatipe.setText("Cons/Modi/Elim");
    jMIconsultatipe.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIconsultatipeActionPerformed(evt);
        }
    });
    jMtipoempleado.add(jMIconsultatipe);

    jMenuBar1.add(jMtipoempleado);

    jMenu1.setMnemonic('o');
    jMenu1.setText("Horario");

    jMaltahorario.setText("Alta");
    jMaltahorario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMaltahorarioActionPerformed(evt);
        }
    });
    jMenu1.add(jMaltahorario);

    jMIconsultarhor.setText("Cons/Modi/Elim");
    jMIconsultarhor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIconsultarhorActionPerformed(evt);
        }
    });
    jMenu1.add(jMIconsultarhor);

    jMenuBar1.add(jMenu1);

    jMenu4.setMnemonic('x');
    jMenu4.setText("Hora extra");

    jMenuItem4.setText("Capturar/Actualizar");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem4ActionPerformed(evt);
        }
    });
    jMenu4.add(jMenuItem4);

    jMenuItem5.setText("Consultar");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem5ActionPerformed(evt);
        }
    });
    jMenu4.add(jMenuItem5);

    jMenuBar1.add(jMenu4);

    jMempleado.setMnemonic('E');
    jMempleado.setText("Empleado");

    jMIaltaem.setText("Alta");
    jMIaltaem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIaltaemActionPerformed(evt);
        }
    });
    jMempleado.add(jMIaltaem);

    jMIconsultaem.setText("Cons/Modi/Elim");
    jMIconsultaem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIconsultaemActionPerformed(evt);
        }
    });
    jMempleado.add(jMIconsultaem);

    jMenuBar1.add(jMempleado);

    jMhuella.setMnemonic('H');
    jMhuella.setText("Huella");

    jMIaltahue.setText("Alta");
    jMIaltahue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIaltahueActionPerformed(evt);
        }
    });
    jMhuella.add(jMIaltahue);

    jMenuItem1.setText("Cons/Modi/Elim");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
        }
    });
    jMhuella.add(jMenuItem1);

    jMenuBar1.add(jMhuella);

    jMchecadas.setMnemonic('C');
    jMchecadas.setText("Checadas");

    jMIaltache.setText("Alta");
    jMIaltache.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIaltacheActionPerformed(evt);
        }
    });
    jMchecadas.add(jMIaltache);

    jMIconelimche.setText("Cons/Modi/Elim");
    jMIconelimche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIconelimcheActionPerformed(evt);
        }
    });
    jMchecadas.add(jMIconelimche);

    jMIelitodasche.setText("Eliminar todas");
    jMIelitodasche.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMIelitodascheActionPerformed(evt);
        }
    });
    jMchecadas.add(jMIelitodasche);

    jMenuBar1.add(jMchecadas);

    jMenu3.setMnemonic('s');
    jMenu3.setText("Asistencia");

    jMenu5.setText("Justificantes");

    jMenuItem6.setText("Alta");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem6ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem6);

    jMenuItem7.setText("Cons/Modi/Elim");
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem7ActionPerformed(evt);
        }
    });
    jMenu5.add(jMenuItem7);

    jMenu3.add(jMenu5);

    jMenuItem2.setText("Consultar");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem2ActionPerformed(evt);
        }
    });
    jMenu3.add(jMenuItem2);

    jMenuBar1.add(jMenu3);

    jMenu2.setMnemonic('N');
    jMenu2.setText("Nomina");

    jMenu6.setText("Deducciones generales");

    jMenuItem8.setText("Capturar/Actualizar");
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem8ActionPerformed(evt);
        }
    });
    jMenu6.add(jMenuItem8);

    jMenu2.add(jMenu6);

    jMInomina.setText("Calcular");
    jMInomina.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMInominaActionPerformed(evt);
        }
    });
    jMenu2.add(jMInomina);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 689, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 504, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIaltaareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIaltaareaActionPerformed
       jDaltaarea.setLocationRelativeTo(null);
        jDaltaarea.setVisible(true);
        txtclavearea.grabFocus();
    }//GEN-LAST:event_jMIaltaareaActionPerformed

    private void btnguardardatosempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardardatosempActionPerformed
       Validardatosemp();    
    }//GEN-LAST:event_btnguardardatosempActionPerformed

    private void btnlimpiardatosempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiardatosempActionPerformed
        limpiardtsemple();
    }//GEN-LAST:event_btnlimpiardatosempActionPerformed
public void limpiardtsemple(){
        txtclaveem.setText("");
        txtnombre_emp.setText("");
        txtdireccion_emp.setText("");
        txtemail_emp.setText("");
        txttelefono_emp.setText("");
        jCBarea.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_comboarea(); //y vuelves a llamar tu metodo donde llenas el combo
        jCBtipoempleado.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combotipo(); //y vuelves a llamar tu metodo donde llenas el combo
        txtfoto.setText("");
        lblfoto.setIcon(null);
        jCBhorario.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combohorario(); //y vuelves a llamar tu metodo donde llenas el combo
        jCBestado.removeAllItems();
        llenar_comboestado();
}
    private void jMIaltaemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIaltaemActionPerformed
        jDaltaempleado.setLocationRelativeTo(null);
        jDaltaempleado.setVisible(true);
        txtclaveem.grabFocus();
    }//GEN-LAST:event_jMIaltaemActionPerformed

    private void jMIaltatipoempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIaltatipoempleadoActionPerformed
        jDaltatipoempleado.setLocationRelativeTo(null);
        jDaltatipoempleado.setVisible(true);
        txtclavetipo.grabFocus();
    }//GEN-LAST:event_jMIaltatipoempleadoActionPerformed

    private void btnlimpiartipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiartipoActionPerformed
        limpiartipoem();
    }//GEN-LAST:event_btnlimpiartipoActionPerformed
public void limpiartipoem(){
    txtclavetipo.setText("");
    txtnombretipo.setText("");
    txtsueldoem.setText("");
    jCBtiposueldo.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
    llenar_combotiposuel(); //y vuelves a llamar tu metodo donde llenas el combo
}
    private void btnguardartipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardartipoActionPerformed
       Validardatostipoemp();
    }//GEN-LAST:event_btnguardartipoActionPerformed

    private void btncargarfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarfotoActionPerformed
        File archivo;
        JFileChooser flcAbrirArchivo = new JFileChooser();
        previewer = new FilePreviewer(flcAbrirArchivo);
        flcAbrirArchivo.setAccessory(previewer);
        flcAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen","jpg","jpeg"));
        int respuesta = flcAbrirArchivo.showOpenDialog(null);
        if(respuesta==JFileChooser.APPROVE_OPTION)
        {
          archivo = flcAbrirArchivo.getSelectedFile();
         txtfoto.setText(archivo.getAbsolutePath());
        Image foto = getToolkit().getImage(txtfoto.getText());
        //foto = foto.getScaledInstance(176, 144, 5);
        lblfoto.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_btncargarfotoActionPerformed

    private void btnGuardarareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarareaActionPerformed
        Validardatosarea();
    }//GEN-LAST:event_btnGuardarareaActionPerformed

    private void btnLimpiarareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarareaActionPerformed
        limpiardarea();
    }//GEN-LAST:event_btnLimpiarareaActionPerformed
public void limpiardarea(){
    txtclavearea.setText("");
    jtxtnombrearea.setText("");
}
    private void jMIaltahueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIaltahueActionPerformed
        funcionifazhu = "Alta huellas";
        jBlimpiarhu.setEnabled(true);
        jDaltahue.setTitle("Alta de huellas");
        limpiardhuella();
        salida.setText("");
        objetoutil.inicializarCaptura();
        jDaltahue.setLocationRelativeTo(null);
        jDaltahue.setVisible(true);
        jCBemplebd.grabFocus();
    }//GEN-LAST:event_jMIaltahueActionPerformed

    private void jBguardarhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarhuActionPerformed
    //Verificar función de la interfaz si es alta de huellas o modificar huellas
        if("Alta huellas".equals(funcionifazhu)){
        Validardtshu();
        }
        else if("Modificar huellas".equals(funcionifazhu)){
            String claveemp = obtenerclem();
        try{
        stconexisdedo.setString(1,claveemp);
        stconexisdedo.setString(2,finger);
        ResultSet res = null;
        res = stconexisdedo.executeQuery();
        if (res.next()){
               Toolkit.getDefaultToolkit().beep();
               JOptionPane.showMessageDialog(null,"El dedo seleccionado ya ha sido registrado, por favor seleccione otro","Error",JOptionPane.ERROR_MESSAGE);
                       }
            //Verificar que haya una huella capturada
        else if(fingerprintImage == null){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,"No hay ninguna huella capturada, por favor capture una","Error",JOptionPane.ERROR_MESSAGE);}
        
        else if(coincidehuella == true){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Esta huella ya ha sido registrada, \nsolo puede ser capturada una huella por cada dedo, \npor favor intente con otra.", "Error", JOptionPane.ERROR_MESSAGE);    
        }
        
            else{
                obtenerdtsmodhue(claveemp);
            }
        }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        jCBemplebd.grabFocus();
       }
    }//GEN-LAST:event_jBguardarhuActionPerformed
    public void obtenerdtsmodhue(String clvemp){
       if(jRBmeñiquei.isSelected()){
                finger = meñiquei;
                }
                else if(jRBanulari.isSelected()){
                finger = anulari;
                }
                else if(jRBmedioi.isSelected()){
                finger = medioi;
                }
                else if(jRBindicei.isSelected()){
                finger = indicei;
                }
                else if(jRBpulgari.isSelected()){
                finger = pulgari;
                }
                else if(jRBmeñiqued.isSelected()){
                finger = meñiqued;
                }
                else if(jRBanulard.isSelected()){
                finger = anulard;
                }
                else if(jRBmediod.isSelected()){
                finger = mediod;
                }
                else if(jRBindiced.isSelected()){
                finger = indiced;
                }
                else if(jRBpulgard.isSelected()){
                finger = pulgard;
                }
               objetoutil.modificarhuella(finger, clvemp, fingerant);
               jDaltahue.setVisible(false);
               mostrardtshuemod();
               txtcnomprohue.grabFocus();
               destroy();
    }
    public void mostrardtshuemod(){
               try {
            limpiartablahue();
            String nombrecol;
            String huellac;
            try {   
                    sthuellamodifi.setString(1,clavehuellax.toString());
                    sthuellamodifi.setString(2,finger);
                    ResultSet res = sthuellamodifi.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
    for (int i = 1; i <= nColumnas; i++){
        nombrecol = res.getMetaData().getColumnName(i);
        if ("huellap".equals(nombrecol)){
            huellac = res.getString(i);
            if (huellac != null)
             datahuellas[i-1] = "SI";
            else
                datahuellas[i-1] = "NO";
        }
        else
    datahuellas[i-1] = (res.getString(i));
      }
    dtmchue.addRow(datahuellas);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    private void jBlimpiarhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarhuActionPerformed
             limpiardhuella();
    }//GEN-LAST:event_jBlimpiarhuActionPerformed

public void obtenerdcem(){
        try {
            limpiartabla();
            String nombrecol;
            String fotoc;
            String nombaconsul = txtcnomem.getText();
            try {   
                    stemplelike.setString(1,nombaconsul+"%");
                    stemplelike.setString(2,"%"+nombaconsul+"%");
                    stemplelike.setString(3,"%"+nombaconsul);
                    ResultSet res = stemplelike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            nombrecol = res.getMetaData().getColumnName(i);
                if ("foto".equals(nombrecol)){
                    fotoc = res.getString(i);
                    if (fotoc != null)
                     dataemp[i-1] = "SI";
                    else
                        dataemp[i-1] = "NO";
                }
                else
            dataemp[i-1] = (res.getString(i));
              }
            dtmem.addRow(dataemp);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}
public void obtenerdcemmodificado(){
        try {
            limpiartabla();
            String nombrecol;
            String fotoc;
            try {   
                    stemplemodificado.setString(1,claveemplex.toString());
                    ResultSet res = stemplemodificado.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            nombrecol = res.getMetaData().getColumnName(i);
                if ("foto".equals(nombrecol)){
                    fotoc = res.getString(i);
                    if (fotoc != null)
                     dataemp[i-1] = "SI";
                    else
                        dataemp[i-1] = "NO";
                }
                else
            dataemp[i-1] = (res.getString(i));
              }
            dtmem.addRow(dataemp);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}
public void obtenerdcarea(){
        try {
            limpiartablaarea();
            String nombaconsul = txtcnomar.getText();
            try {   
                    starealike.setString(1,nombaconsul+"%");
                    starealike.setString(2,"%"+nombaconsul+"%");
                    starealike.setString(3,"%"+nombaconsul);
                    ResultSet res = starealike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            dataarea[i-1] = (res.getString(i));
              }
            dtmarea.addRow(dataarea);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}

public void obtenerdcjusti(){
        try {
            limpiartbljust();
            String nombjconsul = txtcnomjust.getText();
            try {   
                    stjustifilike.setString(1,nombjconsul+"%");
                    stjustifilike.setString(2,"%"+nombjconsul+"%");
                    stjustifilike.setString(3,"%"+nombjconsul);
                    ResultSet res = stjustifilike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datajust[i-1] = (res.getString(i));
              }
            dtmjustificante.addRow(datajust);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
}

    private void btnconsultalneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultalneActionPerformed
        // TODO add your handling code here:
        txtcnomem.setText("");
        txtcnomem.grabFocus();
    }//GEN-LAST:event_btnconsultalneActionPerformed

    private void btnlimpiarareacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarareacActionPerformed
limpiartabla(); 
txtcnomem.grabFocus();
  }//GEN-LAST:event_btnlimpiarareacActionPerformed
public void limpiartabla(){    
    int numfilas = dtmem.getRowCount();
       while(numfilas !=0){
          dtmem.removeRow(0);
          numfilas --;
      }
    }
    private void jMIconsultaemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIconsultaemActionPerformed
       limpiartabla();
       jDconsultaem.setLocationRelativeTo(null);
       jDconsultaem.setVisible(true);
       txtcnomem.grabFocus();
    }//GEN-LAST:event_jMIconsultaemActionPerformed

public void mostrardamod(String clavemodi){
    txtfotomod.setText("");
    String valorfoto;
    try{
    stconcdatmod.setString(1, clavemodi);
            ResultSet res = null;
            res = stconcdatmod.executeQuery();
            while(res.next()){
               int nColumnas = res.getMetaData().getColumnCount();
    for (int i = 1; i <= nColumnas; i++){
        //for(int column = 1; column < 9; column++) {
    if (i == 1)
        txtnombre_empmod.setText(res.getString(i));
    else if (i == 2)
        txtdireccion_empmod.setText(res.getString(i));
    else if (i == 3)
        txtemail_empmod.setText(res.getString(i));
    else if (i == 4)
        txttelefono_empmod.setText(res.getString(i));
    else if (i == 5){try{
                    valorfoto = res.getString(i);
                    if (valorfoto != null){
                        //Mandamos a traer la foto del empleado que deseamos modificar
                   Image dtCat = getfoto(clavemodi);
                   
                   //dtCat = dtCat.getScaledInstance(144, 176, 1);
                   
                   Icon icon = new ImageIcon(dtCat);
                   lblfotomod.setIcon(icon);
                    }
                    else{
                        lblfotomod.setIcon(null);
                    }
                    }catch(NullPointerException e){
                       Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage());
                   }
    }
    else if (i == 6){
        llenar_comboareamod(clavemodi);}
    else if (i == 7){
        llenar_combotipomod(clavemodi);}
    else if (i == 8){
        llenar_combohorariomod(clavemodi);}
    else if (i == 9){
        llenar_comboestadomod(clavemodi);}
      }
               }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    jDmodificarem.setLocationRelativeTo(null);
    jDmodificarem.setVisible(true);
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
           JOptionPane.showMessageDialog(null, e.getMessage());  
        }catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(null, e.getMessage());  
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
    private void btnguardardatosempmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardardatosempmodActionPerformed
        Validardatosempmod();
    }//GEN-LAST:event_btnguardardatosempmodActionPerformed
   public void Validardatosempmod(){
       String tiposueldo = null;
       String clavehorario = null;
    String tipodesueldo = jCBtipoempleadomod.getSelectedItem().toString();
    String nombredehrio = jCBhorariomod.getSelectedItem().toString();
    try{
    stcontipsuel.setString(1, tipodesueldo);
            ResultSet res = null;
            res = stcontipsuel.executeQuery();
            while(res.next()){
               tiposueldo = res.getString("tipo_sueldo");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
       try{
    stconclvhorario.setString(1, nombredehrio);
            ResultSet rs = null;
            rs = stconclvhorario.executeQuery();
            while(rs.next()){
               clavehorario = rs.getString("clave_horario");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         } 
    
    if(txtnombre_empmod.getText().equals("") ||
           txtdireccion_empmod.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);}                           
        else if("Por hora".equals(tiposueldo) && !"0".equals(clavehorario)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El tipo de empleado seleccionado tiene un sueldo por hora, \npor favor seleccione el horario correspondiente para empleados que laboran por hora, \nsi el horario no se muestra entonces debe registrarlo.","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if("0".equals(clavehorario) && !"Por hora".equals(tiposueldo)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El horario seleccionado es exclusivo para empleados que laboran por hora, \npor favor seleccione el tipo de empleado que labora de esta forma, \nsi este tipo de empleado no se muestra entonces debe registrarlo.","Error",JOptionPane.ERROR_MESSAGE);
        }
        else obtenerdatosEmpleadosmod();
   }
       public void obtenerdatosEmpleadosmod()
    {   

        try {     
                 String nombreempem = txtnombre_empmod.getText();
                 String direccionempem = txtdireccion_empmod.getText();
                 String emailempem = txtemail_empmod.getText();
                 String telefonoempem = txttelefono_empmod.getText();
                 String claveareaempem = obtenerareaempleadomod();
                 String clavetipoempem = obtenertipoempleadomod();
                 String clavehorario = obtenerhorariomod();
                 String estado = jCBestadomod.getSelectedItem().toString();
                 
                 if (txtfotomod.getText().equals("")){
                 objetoutil.guardardtsempesinfotom(claveemplex.toString(), nombreempem, direccionempem, emailempem, telefonoempem, claveareaempem, clavetipoempem, clavehorario, estado);
                 jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboemple(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosnom.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboempnom(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosasis.removeAllItems();
                llenar_comboasis();
                obtenerdcemmodificado();
                txtcnomem.grabFocus();
                 }
                 else{
                     FileInputStream archivoFotoc;
                     File nombreFotoc;
                     nombreFotoc= new File(txtfotomod.getText());
                     archivoFotoc=new FileInputStream(nombreFotoc);
                     objetoutil.guardardtsempeconfotom(claveemplex.toString(), nombreempem, direccionempem, emailempem, telefonoempem, claveareaempem, clavetipoempem, archivoFotoc, clavehorario, estado);
                jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboemple(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosnom.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboempnom(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosasis.removeAllItems();
                llenar_comboasis();
                obtenerdcemmodificado();
                txtcnomem.grabFocus();
                 }
                 
        } catch (FileNotFoundException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        jDmodificarem.setVisible(false);
    }
     public String obtenerareaempleadomod(){
    String clav = null;
    String areadeemp = jCBareamod.getSelectedItem().toString();
    try{
    stclavearea.setString(1, areadeemp);
            ResultSet res = null;
            res = stclavearea.executeQuery();
            while(res.next()){
               clav = res.getString("clave_area");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
}
     public String obtenertipoempleadomod(){
         String tip = null;
    String tipodeempm = jCBtipoempleadomod.getSelectedItem().toString();
    try{
    stclavetipo.setString(1, tipodeempm);
            ResultSet res = null;
            res = stclavetipo.executeQuery();
            while(res.next()){
               tip = res.getString("clave_tipo");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return tip;
     }
     public String obtenerhorariomod(){
         String clavehor = null;
    String horarioselec = jCBhorariomod.getSelectedItem().toString();
    try{
    stclavehorario.setString(1, horarioselec);
            ResultSet res = null;
            res = stclavehorario.executeQuery();
            while(res.next()){
               clavehor = res.getString("clave_horario");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clavehor;
     }
    
    private void btncargarfotomodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarfotomodActionPerformed
    File archivo;
        JFileChooser flcAbrirArchivo = new JFileChooser();
        flcAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen","jpg","jpeg"));
        int respuesta = flcAbrirArchivo.showOpenDialog(null);
        if(respuesta==JFileChooser.APPROVE_OPTION)
        {
          archivo = flcAbrirArchivo.getSelectedFile();
         txtfotomod.setText(archivo.getAbsolutePath());
        Image foto = getToolkit().getImage(txtfotomod.getText());
        //foto = foto.getScaledInstance(144, 176, 1);
        lblfotomod.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_btncargarfotomodActionPerformed

    private void tablaconsultaempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultaempMouseClicked
    try{
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
     claveemplex = tablaconsultaemp.getValueAt(tablaconsultaemp.getSelectedRow(),0);
     menuContextual.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }catch(ArrayIndexOutOfBoundsException evento){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro","Error",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_tablaconsultaempMouseClicked

    private void btnlimpiartablaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiartablaarActionPerformed
        limpiartablaarea();
        txtcnomar.grabFocus();
    }//GEN-LAST:event_btnlimpiartablaarActionPerformed
    public void limpiartablaarea(){
        int numfilas = dtmarea.getRowCount();
       while(numfilas !=0){
          dtmarea.removeRow(0);
          numfilas --;
      }
    }
    private void tablaconsultaareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultaareaMouseClicked
      try{
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
     claveareax = tablaconsultaarea.getValueAt(tablaconsultaarea.getSelectedRow(),0);
     menuContextualare.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }catch(ArrayIndexOutOfBoundsException evento){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro","Error",JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_tablaconsultaareaMouseClicked

    private void btnconsultalimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultalimarActionPerformed
        txtcnomar.setText("");
        txtcnomar.grabFocus();
    }//GEN-LAST:event_btnconsultalimarActionPerformed

    private void jMIconsultaareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIconsultaareActionPerformed
       limpiartablaarea();
        jDconsultaar.setLocationRelativeTo(null);
        jDconsultaar.setVisible(true);
        txtcnomar.grabFocus();
    }//GEN-LAST:event_jMIconsultaareActionPerformed

    private void btnGuardarareamodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarareamodActionPerformed
        Validardatosaremod();
    }//GEN-LAST:event_btnGuardarareamodActionPerformed
    public void Validardatosaremod(){
        if(jtxtnombreareamod.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);}                           
   else obtenerdatosareamod();
   }
        public void obtenerdatosareamod()
    {   
                 String nombreareamod = jtxtnombreareamod.getText();
                 objetoutil.guardardtsareamodi(claveareax.toString(), nombreareamod);         
                 jCBarea.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                 llenar_comboarea(); //y vuelves a llamar tu metodo donde llenas el combo
                
        jDmodificarare.setVisible(false);
        mostrardtsmodarea();
        txtcnomar.grabFocus();
    }
        public void mostrardtsmodarea(){
                    try {
            limpiartablaarea();
            try {   
                    stareamodificada.setString(1,claveareax.toString());
                    ResultSet res = stareamodificada.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            dataarea[i-1] = (res.getString(i));
              }
            dtmarea.addRow(dataarea);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
        public void mostrardtsmodjusti(){
                    try {
            limpiartbljust();
            try {   
                    stjustimodificado.setString(1,clavejustificantex.toString());
                    ResultSet res = stjustimodificado.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datajust[i-1] = (res.getString(i));
              }
            dtmjustificante.addRow(datajust);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            //txtcnomem.setText("");
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
    private void btnlimpiarareacteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarareacteActionPerformed
        limpiartablatipoem();
        txtcnomtipe.grabFocus();
    }//GEN-LAST:event_btnlimpiarareacteActionPerformed
    public void limpiartablatipoem(){
        int numfilas = dtmtipoe.getRowCount();
       while(numfilas !=0){
          dtmtipoe.removeRow(0);
          numfilas --;
      }
    }
       public void obtenerdcontipe(){
       try {
            limpiartablatipoem();
            String nombaconsul = txtcnomtipe.getText();
            try {   
                    sttipoelike.setString(1,nombaconsul+"%");
                    sttipoelike.setString(2,"%"+nombaconsul+"%");
                    sttipoelike.setString(3,"%"+nombaconsul);
                    ResultSet res = sttipoelike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datatipoe[i-1] = (res.getString(i));
              }
            dtmtipoe.addRow(datatipoe);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } 
    }
    private void btnlimpiarnomtipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarnomtipeActionPerformed
        txtcnomtipe.setText("");
        txtcnomtipe.grabFocus();
    }//GEN-LAST:event_btnlimpiarnomtipeActionPerformed

    private void jMIconsultatipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIconsultatipeActionPerformed
        limpiartablatipoem();
        jDconsultatipe.setLocationRelativeTo(null);
        jDconsultatipe.setVisible(true);
        txtcnomtipe.grabFocus();
    }//GEN-LAST:event_jMIconsultatipeActionPerformed

    private void btnguardartipomodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardartipomodActionPerformed
        Validardatostipoemod();
    }//GEN-LAST:event_btnguardartipomodActionPerformed
        public void Validardatostipoemod(){
        if(txtnombretipomod.getText().equals("")||
           txtsueldoemmod.getText().equals("") ||
           txtsueldoemmod.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);                  
        }
        else if(!txtsueldoemmod.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"El sueldo del empleado debe ser de tipo numérico y no decimal","Error", JOptionPane.ERROR_MESSAGE);
        }
else obtenerdatostipoem();
    }
        public void obtenerdatostipoem(){
        String nombretemmod = txtnombretipomod.getText();
        String tiposueldmod = jCBtiposueldomod.getSelectedItem().toString();
        int sueldotemmod = Integer.parseInt(txtsueldoemmod.getText());
        objetoutil.guardartipoempemod(clavetipoemx.toString(),nombretemmod, tiposueldmod, sueldotemmod);
        jCBtipoempleado.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combotipo(); //y vuelves a llamar tu metodo donde llenas el combo
        jDmodificartipoe.setVisible(false);
        mostrardtsmodtipoe();
        txtcnomtipe.grabFocus();
    }
        public void mostrardtsmodtipoe(){
                   try {
            limpiartablatipoem();
            try {   
                    sttipomodificado.setString(1,clavetipoemx.toString());
                    ResultSet res = sttipomodificado.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datatipoe[i-1] = (res.getString(i));
              }
            dtmtipoe.addRow(datatipoe);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
    private void btnlimptabprohueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimptabprohueActionPerformed
        limpiartablahue();
        txtcnomprohue.grabFocus();
    }//GEN-LAST:event_btnlimptabprohueActionPerformed
    public void limpiartablahue(){
        int numfilas = dtmchue.getRowCount();
       while(numfilas !=0){
          dtmchue.removeRow(0);
          numfilas --;
      }
    }
    private void tablaconsultahueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultahueMouseClicked
                try{
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
     clavehuellax = tablaconsultahue.getValueAt(tablaconsultahue.getSelectedRow(),0);
     dedohuellax = tablaconsultahue.getValueAt(tablaconsultahue.getSelectedRow(),3);
     menuContextualhue.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }catch(ArrayIndexOutOfBoundsException evento){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro","Error",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_tablaconsultahueMouseClicked

          public void obtenerdconhue(){
       try {
            limpiartablahue();
            String nombrecol;
            String huellac;
            String nombaconsul = txtcnomprohue.getText();
            try {   
                    sthuellalike.setString(1,nombaconsul+"%");
                    sthuellalike.setString(2,"%"+nombaconsul+"%");
                    sthuellalike.setString(3,"%"+nombaconsul);
                    ResultSet res = sthuellalike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
    for (int i = 1; i <= nColumnas; i++){
        nombrecol = res.getMetaData().getColumnName(i);
        if ("huellap".equals(nombrecol)){
            huellac = res.getString(i);
            if (huellac != null)
             datahuellas[i-1] = "SI";
            else
                datahuellas[i-1] = "NO";
        }
        else
    datahuellas[i-1] = (res.getString(i));
      }
    dtmchue.addRow(datahuellas);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } 
    }
    private void btnlimpiarnprohueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarnprohueActionPerformed
        txtcnomprohue.setText("");
        txtcnomprohue.grabFocus();
    }//GEN-LAST:event_btnlimpiarnprohueActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        limpiartablahue();
        jDconsultahue.setLocationRelativeTo(null);
        jDconsultahue.setVisible(true);
        txtcnomprohue.grabFocus();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tablaconsultatipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultatipeMouseClicked
        try {
            if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                clavetipoemx = tablaconsultatipe.getValueAt(tablaconsultatipe.getSelectedRow(), 0);
                menuContextualtipe.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        } catch (ArrayIndexOutOfBoundsException evento) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Por favor seleccione un registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablaconsultatipeMouseClicked

    private void btnguardarhorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarhorActionPerformed
         if("".equals(txtclavehor.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture la clave del horario", "Error", JOptionPane.ERROR_MESSAGE);
        }
         else if("".equals(txtnombrehor.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture el nombre del horario", "Error", JOptionPane.ERROR_MESSAGE);
        }
         else if("".equals(txthoraentdom.getText())||
                "".equals(txthorasaldom.getText())||
                "".equals(txthoraentlun.getText())||
                "".equals(txthorasallun.getText())||
                "".equals(txthoraentmar.getText())||
                "".equals(txthorasalmar.getText())||
                "".equals(txthoraentmie.getText())||
                "".equals(txthorasalmie.getText())||
                "".equals(txthoraentjue.getText())||
                "".equals(txthorasaljue.getText())||
                "".equals(txthoraentvie.getText())||
                "".equals(txthorasalvie.getText())||
                "".equals(txthoraentsab.getText())||
                "".equals(txthorasalsab.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Por favor capture las horas en este horario", "Error", JOptionPane.ERROR_MESSAGE);
             }
         else if("".equals(txttoleantentdia.getText()) ||
                    "".equals(txttoledesentdia.getText()) ||
                    "".equals(txttoleantsaldia.getText()) ||
                    "".equals(txttoledessaldia.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture los minutos de tolerancia", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!txthoraentdom.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasaldom.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentlun.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasallun.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentmar.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalmar.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentmie.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalmie.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentjue.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasaljue.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentvie.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalvie.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentsab.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalsab.getText().matches("\\d[0-20-9]:\\d[0-50-9]")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Por favor capture la hora en tiempo de 24 horas y con dos dígitos,"
                    + "\nejemplo 08:56, 17:15, 14:00", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!txttoleantentdia.getText().matches("\\d+") ||
                    !txttoledesentdia.getText().matches("\\d+") ||
                    !txttoleantsaldia.getText().matches("\\d+") ||
                    !txttoledessaldia.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Los minutos de tolerancia deben ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
          else if(Integer.parseInt(txttoleantentdia.getText()) > 59 ||
                  Integer.parseInt(txttoledesentdia.getText()) > 59 ||
                  Integer.parseInt(txttoleantsaldia.getText()) > 59 ||
                  Integer.parseInt(txttoledessaldia.getText()) > 59 ){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Los minutos de tolerancia no pueden ser mayor que 59 ","Error",JOptionPane.ERROR_MESSAGE);    
          }
        else if(!txtclavehor.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave del horario debe ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        Validahrsaltahor();
        }
    }//GEN-LAST:event_btnguardarhorActionPerformed
    public void Validahrsaltahor(){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date dhoramaxima = null;
    
    Date dhoraentdom = null;
    Date dhorasaldom = null;
    Date dhoraentlun = null;
    Date dhorasallun = null;
    Date dhoraentmar = null;
    Date dhorasalmar = null;
    Date dhoraentmie = null;
    Date dhorasalmie = null;
    Date dhoraentjue = null;
    Date dhorasaljue = null;
    Date dhoraentvie = null;
    Date dhorasalvie = null;
    Date dhoraentsab = null;
    Date dhorasalsab = null;
    
    try {
    dhoraentdom = sdf.parse(txthoraentdom.getText());
    dhorasaldom = sdf.parse(txthorasaldom.getText());
    dhoraentlun = sdf.parse(txthoraentlun.getText());
    dhorasallun = sdf.parse(txthorasallun.getText());
    dhoraentmar = sdf.parse(txthoraentmar.getText());
    dhorasalmar = sdf.parse(txthorasalmar.getText());
    dhoraentmie = sdf.parse(txthoraentmie.getText());
    dhorasalmie = sdf.parse(txthorasalmie.getText());
    dhoraentjue = sdf.parse(txthoraentjue.getText());
    dhorasaljue = sdf.parse(txthorasaljue.getText());
    dhoraentvie = sdf.parse(txthoraentvie.getText());
    dhorasalvie = sdf.parse(txthorasalvie.getText());
    dhoraentsab = sdf.parse(txthoraentsab.getText());
    dhorasalsab = sdf.parse(txthorasalsab.getText());
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    try {
            dhoramaxima = sdf.parse("23:59");
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    
    if(dhoraentdom.after(dhoramaxima) ||
       dhorasaldom.after(dhoramaxima) ||
       dhoraentlun.after(dhoramaxima) ||
       dhorasallun.after(dhoramaxima) ||
       dhoraentmar.after(dhoramaxima) ||
       dhorasalmar.after(dhoramaxima) ||
       dhoraentmie.after(dhoramaxima) ||
       dhorasalmie.after(dhoramaxima) ||
       dhoraentjue.after(dhoramaxima) ||
       dhorasaljue.after(dhoramaxima) ||
       dhoraentvie.after(dhoramaxima) ||
       dhorasalvie.after(dhoramaxima) ||
       dhoraentsab.after(dhoramaxima) ||
       dhorasalsab.after(dhoramaxima)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "La hora no puede ser mayor que 23:59", "Error", JOptionPane.ERROR_MESSAGE);
        }
    else if(dhoraentdom.after(dhorasaldom) ||
            dhoraentlun.after(dhorasallun) ||
            dhoraentmar.after(dhorasalmar) ||
            dhoraentmie.after(dhorasalmie) ||
            dhoraentjue.after(dhorasaljue) ||
            dhoraentvie.after(dhorasalvie) ||
            dhoraentsab.after(dhorasalsab)){
            Toolkit.getDefaultToolkit().beep();
             JOptionPane.showMessageDialog(null, "La hora de entrada no puede ser mayor que la hora de salida", "Error", JOptionPane.ERROR_MESSAGE);
         }
    else{
        Obtenerdtshorario();
    }
    
            }
    public void Obtenerdtshorario(){
        int clavehor = Integer.parseInt(txtclavehor.getText());
        String nombrehor = txtnombrehor.getText();
        
        String hentdom = txthoraentdom.getText();
        String hsaldom = txthorasaldom.getText();
        String hentlun = txthoraentlun.getText();
        String hsallun = txthorasallun.getText();
        String hentmar = txthoraentmar.getText();
        String hsalmar = txthorasalmar.getText();
        String hentmie = txthoraentmie.getText();
        String hsalmie = txthorasalmie.getText();
        String hentjue = txthoraentjue.getText();
        String hsaljue = txthorasaljue.getText();
        String hentvie = txthoraentvie.getText();
        String hsalvie = txthorasalvie.getText();
        String hentsab = txthoraentsab.getText();
        String hsalsab = txthorasalsab.getText();
        
        int toleantentdia = Integer.parseInt(txttoleantentdia.getText());
        int toledesentdia = Integer.parseInt(txttoledesentdia.getText());
        int toleantsaldia = Integer.parseInt(txttoleantsaldia.getText());
        int toledessaldia = Integer.parseInt(txttoledessaldia.getText());
        
        String hrstotales = horaslabs.calcularhtotales(hentdom, hsaldom, hentlun, hsallun, 
        hentmar, hsalmar, hentmie, hsalmie, hentjue, hsaljue, 
        hentvie, hsalvie, hentsab, hsalsab);
        
        objetoutil.guardardtshorario(clavehor, nombrehor, hentdom, hsaldom, hentlun, hsallun, 
        hentmar, hsalmar, hentmie, hsalmie, hentjue, hsaljue, 
        hentvie, hsalvie, hentsab, hsalsab, hrstotales,toleantentdia, toledesentdia,
        toleantsaldia, toledessaldia);
        jCBhorario.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combohorario(); //y vuelves a llamar tu metodo donde llenas el combo
        txtclavehor.grabFocus();
    }
    
    private void btnlimpiarhorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarhorActionPerformed
         Limpiardtshor();
    }//GEN-LAST:event_btnlimpiarhorActionPerformed
    public void Limpiardtshor(){ 
        txtclavehor.setText("");
        txtnombrehor.setText("");
        txthoraentdom.setText("00:00");
        txthorasaldom.setText("00:00");
        txthoraentlun.setText("00:00");
        txthorasallun.setText("00:00");
        txthoraentmar.setText("00:00");
        txthorasalmar.setText("00:00");
        txthoraentmie.setText("00:00");
        txthorasalmie.setText("00:00");
        txthoraentjue.setText("00:00");
        txthorasaljue.setText("00:00");
        txthoraentvie.setText("00:00");
        txthorasalvie.setText("00:00");
        txthoraentsab.setText("00:00");
        txthorasalsab.setText("00:00");
        
        
        txttoleantentdia.setText("45");
        txttoledesentdia.setText("10");
        txttoleantsaldia.setText("10");
        txttoledessaldia.setText("45");
    }
    private void jMaltahorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaltahorarioActionPerformed
        jDaltahorario.setLocationRelativeTo(null);
        jDaltahorario.setVisible(true);
        txtclavehor.grabFocus();
    }//GEN-LAST:event_jMaltahorarioActionPerformed

    private void btnlimpiarareachorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarareachorActionPerformed
        limpiartablahor();
        txtcnomhor.grabFocus();
    }//GEN-LAST:event_btnlimpiarareachorActionPerformed
    public void limpiartablahor(){
             int numfilas = dtmchor.getRowCount();
       while(numfilas !=0){
          dtmchor.removeRow(0);
          numfilas --;
      }
    }
    private void tablaconsultahorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultahorMouseClicked
        try {
            if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                clavehorariox = tablaconsultahor.getValueAt(tablaconsultahor.getSelectedRow(), 0);
                menuContextualhor.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        } catch (ArrayIndexOutOfBoundsException evento) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Por favor seleccione un registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablaconsultahorMouseClicked

           public void obtenerdconhor(){
       try {
            limpiartablahor();
            String nombaconsul = txtcnomhor.getText();
            try {   
                    sthorarioslike.setString(1,nombaconsul+"%");
                    sthorarioslike.setString(2,"%"+nombaconsul+"%");
                    sthorarioslike.setString(3,"%"+nombaconsul);
                    ResultSet res = sthorarioslike.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datahorario[i-1] = (res.getString(i));
              }
            dtmchor.addRow(datahorario);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } 
    }
    private void btnconsultalhorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultalhorActionPerformed
        txtcnomhor.setText("");
        txtcnomhor.grabFocus();
    }//GEN-LAST:event_btnconsultalhorActionPerformed

    private void jMIconsultarhorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIconsultarhorActionPerformed
        limpiartablahor();
        jDconsultahor.setLocationRelativeTo(null);
        jDconsultahor.setVisible(true);
        txtcnomhor.grabFocus();
    }//GEN-LAST:event_jMIconsultarhorActionPerformed

    private void btnguardarhormodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarhormodActionPerformed
        if("".equals(txtnombrehormod.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture el nombre del horario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if("".equals(txthoraentdommod.getText()) ||
                "".equals(txthorasaldommod.getText()) ||
                "".equals(txthoraentlunmod.getText()) ||
                "".equals(txthorasallunmod.getText()) ||
                "".equals(txthoraentmarmod.getText()) ||
                "".equals(txthorasalmarmod.getText()) ||
                "".equals(txthoraentmiemod.getText()) ||
                "".equals(txthorasalmiemod.getText()) ||
                "".equals(txthoraentjuemod.getText()) ||
                "".equals(txthorasaljuemod.getText()) ||
                "".equals(txthoraentviemod.getText()) ||
                "".equals(txthorasalviemod.getText()) ||
                "".equals(txthoraentsabmod.getText()) ||
                "".equals(txthorasalsabmod.getText())){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor capture las horas en este horario", "Error", JOptionPane.ERROR_MESSAGE);       
        }
        else if("".equals(txttoleantentdiamod.getText()) ||
                    "".equals(txttoledesentdiamod.getText()) ||
                    "".equals(txttoleantsaldiamod.getText()) ||
                    "".equals(txttoledessaldiamod.getText())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture los minutos de tolerancia", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!txthoraentdommod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasaldommod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentlunmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasallunmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentmarmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalmarmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentmiemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalmiemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentjuemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasaljuemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentviemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalviemod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthoraentsabmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")||
                !txthorasalsabmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Por favor capture la hora en tiempo de 24 horas y con dos dígitos,"
                    + "\nejemplo 08:56, 17:15, 14:00", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!txttoleantentdiamod.getText().matches("\\d+") ||
                    !txttoledesentdiamod.getText().matches("\\d+") ||
                    !txttoleantsaldiamod.getText().matches("\\d+") ||
                    !txttoledessaldiamod.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Los minutos de tolerancia deben ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
          else if(Integer.parseInt(txttoleantentdiamod.getText()) > 59 ||
                  Integer.parseInt(txttoledesentdiamod.getText()) > 59 ||
                  Integer.parseInt(txttoleantsaldiamod.getText()) > 59 ||
                  Integer.parseInt(txttoledessaldiamod.getText()) > 59 ){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Los minutos de tolerancia no pueden ser mayor que 59 ","Error",JOptionPane.ERROR_MESSAGE);    
          }
          else{
        Validahrsaltahorm();
          }
    }//GEN-LAST:event_btnguardarhormodActionPerformed
    public void Validahrsaltahorm(){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Date dhoramaxima = null;
    
    Date dhoraentdommod = null;
    Date dhorasaldommod = null;
    Date dhoraentlunmod = null;
    Date dhorasallunmod = null;
    Date dhoraentmarmod = null;
    Date dhorasalmarmod = null;
    Date dhoraentmiemod = null;
    Date dhorasalmiemod = null;
    Date dhoraentjuemod = null;
    Date dhorasaljuemod = null;
    Date dhoraentviemod = null;
    Date dhorasalviemod = null;
    Date dhoraentsabmod = null;
    Date dhorasalsabmod = null;
    
        try {
            dhoraentdommod = sdf.parse(txthoraentdommod.getText());
            dhorasaldommod = sdf.parse(txthorasaldommod.getText());
            dhoraentlunmod = sdf.parse(txthoraentlunmod.getText());
            dhorasallunmod = sdf.parse(txthorasallunmod.getText());
            dhoraentmarmod = sdf.parse(txthoraentmarmod.getText());
            dhorasalmarmod = sdf.parse(txthorasalmarmod.getText());
            dhoraentmiemod = sdf.parse(txthoraentmiemod.getText());
            dhorasalmiemod = sdf.parse(txthorasalmiemod.getText());
            dhoraentjuemod = sdf.parse(txthoraentjuemod.getText());
            dhorasaljuemod = sdf.parse(txthorasaljuemod.getText());
            dhoraentviemod = sdf.parse(txthoraentviemod.getText());
            dhorasalviemod = sdf.parse(txthorasalviemod.getText());
            dhoraentsabmod = sdf.parse(txthoraentsabmod.getText());
            dhorasalsabmod = sdf.parse(txthorasalsabmod.getText());
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    try {
            dhoramaxima = sdf.parse("23:59");
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    if(dhoraentdommod.after(dhoramaxima) ||
       dhorasaldommod.after(dhoramaxima) ||
       dhoraentlunmod.after(dhoramaxima) ||
       dhorasallunmod.after(dhoramaxima) ||
       dhoraentmarmod.after(dhoramaxima) ||
       dhorasalmarmod.after(dhoramaxima) ||
       dhoraentmiemod.after(dhoramaxima) ||
       dhorasalmiemod.after(dhoramaxima) ||
       dhoraentjuemod.after(dhoramaxima) ||
       dhorasaljuemod.after(dhoramaxima) ||
       dhoraentviemod.after(dhoramaxima) ||
       dhorasalviemod.after(dhoramaxima) ||
       dhoraentsabmod.after(dhoramaxima) ||
       dhorasalsabmod.after(dhoramaxima)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "La hora no puede ser mayor que 23:59", "Error", JOptionPane.ERROR_MESSAGE);
        }
    else if(dhoraentdommod.after(dhorasaldommod) ||
            dhoraentlunmod.after(dhorasallunmod) ||
            dhoraentmarmod.after(dhorasalmarmod) ||
            dhoraentmiemod.after(dhorasalmiemod) ||
            dhoraentjuemod.after(dhorasaljuemod) ||
            dhoraentviemod.after(dhorasalviemod) ||
            dhoraentsabmod.after(dhorasalsabmod)){
            Toolkit.getDefaultToolkit().beep();
             JOptionPane.showMessageDialog(null, "La hora de entrada no puede ser mayor que la hora de salida", "Error", JOptionPane.ERROR_MESSAGE);
         }
          else{
              Obtenerdtshorariomod();
          }
            }
    public void Obtenerdtshorariomod(){
        String nombrehormod = txtnombrehormod.getText();
        String hentdommod = txthoraentdommod.getText();
        String hsaldommod = txthorasaldommod.getText();
        String hentlunmod = txthoraentlunmod.getText();
        String hsallunmod = txthorasallunmod.getText();
        String hentmarmod = txthoraentmarmod.getText();
        String hsalmarmod = txthorasalmarmod.getText();
        String hentmiemod = txthoraentmiemod.getText();
        String hsalmiemod = txthorasalmiemod.getText();
        String hentjuemod = txthoraentjuemod.getText();
        String hsaljuemod = txthorasaljuemod.getText();
        String hentviemod = txthoraentviemod.getText();
        String hsalviemod = txthorasalviemod.getText();
        String hentsabmod = txthoraentsabmod.getText();
        String hsalsabmod = txthorasalsabmod.getText();
        String hrstotalesmod = horaslabs.calcularhtotales(hentdommod,hsaldommod,hentlunmod,hsallunmod,hentmarmod,hsalmarmod,hentmiemod,hsalmiemod,hentjuemod,hsaljuemod,hentviemod,hsalviemod,hentsabmod,hsalsabmod);
        int toleantentdiamod = Integer.parseInt(txttoleantentdiamod.getText());
        int toledesentdiamod = Integer.parseInt(txttoledesentdiamod.getText());
        int toleantsaldiamod = Integer.parseInt(txttoleantsaldiamod.getText());
        int toledessaldiamod = Integer.parseInt(txttoledessaldiamod.getText());
        objetoutil.guardardtshorariomod(nombrehormod, hentdommod, hsaldommod, hentlunmod, hsallunmod, hentmarmod, hsalmarmod, 
        hentmiemod, hsalmiemod, hentjuemod, hsaljuemod, hentviemod, hsalviemod, hentsabmod, hsalsabmod, hrstotalesmod, clavehorariox.toString(), 
        toleantentdiamod, toledesentdiamod, toleantsaldiamod, toledessaldiamod);
        jCBhorario.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combohorario(); //y vuelves a llamar tu metodo donde llenas el combo
        jDmodhorario.setVisible(false);
        mostrardtshormod();
        txtcnomhor.grabFocus();
    }
    public void mostrardtshormod(){
               try {
            limpiartablahor();
            try {   
                    sthorariomodifi.setString(1,clavehorariox.toString());
                    ResultSet res = sthorariomodifi.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datahorario[i-1] = (res.getString(i));
              }
            dtmchor.addRow(datahorario);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    private void jMInominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMInominaActionPerformed
        try {
            ResultSet r = null;
               r = stconhorclvcero.executeQuery();
               if(r.next()){
           limpiardtsconnom();
           limresultconnom();
           jDcalculonomina.setLocationRelativeTo(null);
           jDcalculonomina.setVisible(true);
                          }
    else{
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, "Aún no ha dado de alta el horario para empleados que laboran por horas, \nes muy importante que registre este horario con clave 0, con un nombre que usted reconozca \ny con todas las horas de entrada y salida de la siguiente forma: 00:00:00 \nConsulte el manual del usuario en la sección Alta de horarios.","Error",JOptionPane.ERROR_MESSAGE);
    }    
    } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
                
    }//GEN-LAST:event_jMInominaActionPerformed

    private void btncalcularnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularnomActionPerformed
        validardtsnom();
    }//GEN-LAST:event_btncalcularnomActionPerformed
public void validardtsnom(){
    String nombreempnom = jCBempleadosnom.getSelectedItem().toString();
    String pagohrex = "";
    //Verifica si ya hay un pago de hora extra guardado
                try{
        ResultSet res = stconpagohrext.executeQuery();
         if(res.next()){
        pagohrex = res.getString("pagohrextra");   
         }
      } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
                
        if("SELECCIONE UN CAMPO".equals(nombreempnom)){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el nombre del empleado","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if("".equals(pagohrex)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aún no ha capturado el pago de hora extra, \n"
                                                + "vaya al menú Hora extra > Capturar/Actualizar  \n"
                                                + "y vuelva a intentar","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            verisiactivosouno();
}
public void verisiactivosouno(){
    int clvempactivo = 0;
    String vlrseleccionado = jCBempleadosnom.getSelectedItem().toString();
    if("SOLO EMPLEADOS ACTIVOS".equals(vlrseleccionado)){
    try {   
            ResultSet rs = stconclvsempleac.executeQuery();
            int nColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
    for (int i = 1; i <= nColumnas; i ++){
    clvempactivo = (rs.getInt(i));
    obtdtsdeactivosnom(clvempactivo);
      }
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
    else {
        obtenerdtsnom();
    }    
}
public void obtdtsdeactivosnom(int clveactivo){
        int checadasdeldia = 0;
        int diaslaborados = 0;
        Date dfechainicio = null;
        Date dfechafin = null;
        float pagoe = 0;
        float pagoemptotal = 0;
        float pagoemplehrsex = 0;
        String totalhrsextras = "";
        int tottiempoexaeds = 0;
        
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.US);
        String nombreempleado = null;
        int cempleado = clveactivo;
        int tipoemp = 0;
        int sueldoempleado = 0;
        String hrstotdehorario = "";
        int horariodeemp = 0;
        String tiposueldo = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
        DecimalFormat dosDigitos = new DecimalFormat("00");
        String tdescontado = null;
        String hrcompuestadob = "00:00:00";
        try{ 
dfechainicio = sdf.parse(dCfechainicio.getText());
dfechafin = sdf.parse(dCfechafin.getText());
}catch(Exception e){ 
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null, e.getMessage()); 
}
        //Consultamos el nombre del empleado de acuerdo a la clave que recibe el metodo
        try{
    stnombreempleado.setInt(1, cempleado);
            ResultSet r = null;
            r = stnombreempleado.executeQuery();
            while(r.next()){
              nombreempleado = r.getString("nombre");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Consultamos la clave del tipo de empleado, para saber el tipo de empleado
        try{
    stcontipoemp.setInt(1, cempleado);
            ResultSet rt = null;
            rt = stcontipoemp.executeQuery();
            while(rt.next()){
              tipoemp = rt.getInt("tipo_emp");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Consultamos el tipo del sueldo del empleado, es decir si se le paga por semana, por quincena o por hora
        try{
    stcontiposueldo.setInt(1, tipoemp);
            ResultSet rst = null;
            rst = stcontiposueldo.executeQuery();
            while(rst.next()){
              tiposueldo = rst.getString("tipo_sueldo");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Consultamos el sueldo del empleado de acuerdo al tipo de empleado que es 
        try{
    stconsueldoemp.setInt(1, tipoemp);
            ResultSet rest = null;
            rest = stconsueldoemp.executeQuery();
            while(rest.next()){
              sueldoempleado = rest.getInt("sueldo_tipo");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Consultamos la clave del horario que tiene el empleado
        try{
        stconhordeemp.setInt(1,cempleado);
                    ResultSet resu = stconhordeemp.executeQuery();
                while (resu.next()) {
                    horariodeemp = resu.getInt("horario");
                }
                }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Consultamos las horas totales del horario del empleado
        try{
        stconhrsdehorario.setInt(1,horariodeemp);
                ResultSet resul = stconhrsdehorario.executeQuery();
                while (resul.next()) {
                    hrstotdehorario = resul.getString("thrsdehrio");
                }
                }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Iteramos en todos los dias del periodo sonsultado, para acumular el tiempo laborado y las horas extras
        while(dfechainicio.before(dfechafin) || dfechainicio.equals(dfechafin)){
        String stfechainicio = sdf.format(dfechainicio);
        try {
            //Consulta los días laborados
            stcondlaborados.setString(1, stfechainicio);
            stcondlaborados.setInt(2, cempleado);
            ResultSet rs = stcondlaborados.executeQuery();
            while (rs.next()) {
                checadasdeldia = Integer.parseInt(rs.getString("count(fecha_checada)"));       
            }
            //Si el empleado checo mas de una vez, entonces se toma como un dia laborado
            if(checadasdeldia > 1){
                String horaentrada = "";
                String horasalida = "";
                String laboradas = "";
                diaslaborados ++;
                //Si el sueldo es semanal o quincenal, entonces calcula las horas 
                if("Semanal".equals(tiposueldo) || "Quincenal".equals(tiposueldo)){
   //Verificamos la hora de entrada, si la checada es menor que su hora de entrada establecida en ese día o si esta dentro de
   //los minutos de tolerancia establecidos en ese día entonces se asigna la hora de entrada establecida en ese dia, si la checada es mayor
   //que la hora de entrada establecida en ese día mas los minutos de tolrencia entonces se asigna la hora de la checada
            horaentrada = verificarhoraentrada(stfechainicio, cempleado);
            //JOptionPane.showMessageDialog(null, "La hora de entrada es: " + horaentrada);
            
    //Verificamos la hora de salida, si la checada es mayor que su hora de salida establecida en ese día o si esta dentro de
   //los minutos de tolerancia establecidos en ese día entonces se asigna la hora de salida establecida en ese dia, si la checada es menor
   //que la hora de salida establecida en ese día menos los minutos de tolrencia entonces se asigna la hora de la checada
            horasalida = verificarhorasalida(stfechainicio, cempleado);
            //JOptionPane.showMessageDialog(null, "La hora de salida es: " + horasalida);
               
            //Si no hubo un día extra entonces se calculan las horas laboradas del día
            if(diaextraae == false && diaextrads == false){
            laboradas = RestarHoras(horaentrada, horasalida);
            //JOptionPane.showMessageDialog(null, "Horas laboradas del dia = " + laboradas);   
              try{
            //Convertimos las horas laboradas del dia en segundos y hacemos el acumulado del periodo consultado
            //Si arroja un resultado negativo entonces manda un mensaje al usuario
        int hora = Integer.parseInt(laboradas.substring(0, 2));
	int min = Integer.parseInt(laboradas.substring(3, 5));
	int seg = Integer.parseInt(laboradas.substring(6));
        int hrasegundos = (((hora*60)*60)+(min*60) + seg);
        hrstotales += hrasegundos;
            }catch(NumberFormatException ex){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Resultado negativo, la checada de entrada del empleado con clave\n"
                        + cempleado + " registrada en la fecha " + stfechainicio + " es mayor que la hora de salida \n"
                        + "establecida en el horario con clave " + horariodeemp + ", la hora de entrada \n"
                        + "no puede ser mayor que la hora de salida establecida en el respectivo\n"
                        + "día del horario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            //Si hubo un día extra, entonces calcula las horas laboradas de tal día y las agrega a las horas extras
            else{
                laboradas = RestarHoras(horaentrada, horasalida);
            //JOptionPane.showMessageDialog(null, "Horas laboradas del dia = " + laboradas);   
              try{
            //Convertimos las horas laboradas del dia en segundos y las agregamos a las horas extras
            //Si arroja un resultado negativo entonces manda un mensaje al usuario
        int hora = Integer.parseInt(laboradas.substring(0, 2));
	int min = Integer.parseInt(laboradas.substring(3, 5));
	int seg = Integer.parseInt(laboradas.substring(6));
        int hrasegundos = (((hora*60)*60)+(min*60) + seg);
        tottiempoexaeds += hrasegundos;
            }catch(NumberFormatException ex){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Resultado negativo, la checada de entrada del empleado con clave\n"
                        + cempleado + " registrada en la fecha " + stfechainicio + " es mayor que la hora de salida \n"
                        + "establecida en el horario con clave " + horariodeemp + ", la hora de entrada \n"
                        + "no puede ser mayor que la hora de salida establecida en el respectivo\n"
                        + "día del horario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
                }//Fin de si el sueldo es quincenal o semanal
                
            //Si el sueldo no es semanal ni quincenal, entonces es por hora
                else{
                   String hrslabsdeldia = calculartlaborado(stfechainicio, cempleado);
                   //JOptionPane.showMessageDialog(null, "Horas laboradas del dia = " + hrslabsdeldia);
                   
                   try{
            //Convertimos las horas laboradas del dia en segundos y hacemos el acumulado del periodo consultado
            //Si arroja un resultado negativo entonces manda un mensaje al usuario
        int hora = Integer.parseInt(hrslabsdeldia.substring(0, 2));
	int min = Integer.parseInt(hrslabsdeldia.substring(3, 5));
	int seg = Integer.parseInt(hrslabsdeldia.substring(6));
        int hrasegundos = (((hora*60)*60)+(min*60) + seg);
        hrstotales += hrasegundos;
            }catch(NumberFormatException ex){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Resultado negativo, la checada de entrada del empleado con clave\n"
                        + cempleado + " registrada en la fecha " + stfechainicio + " es mayor que la hora de salida \n"
                        + "establecida en el horario con clave " + horariodeemp + ", la hora de entrada \n"
                        + "no puede ser mayor que la hora de salida establecida en el respectivo\n"
                        + "día del horario", "Error", JOptionPane.ERROR_MESSAGE);
            }
                }
                
            } //Fin de si el empleado checo mas de una vez
            //Incrementamos la fecha de inicio que se consulto, cuando sea mayor a la fecha final entonces sale de la iteración
            dfechainicio = sumaDias(dfechainicio, 1);
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
                }//Fin de la iteracion del los dias consultados
        
        //Convertimos las horas en segundos del periodo consultado al formato HH:mm:ss
        String tothrsmenor = "";
        int h = (hrstotales/3600);
	int m = ((hrstotales-(h*3600))/60);
	int s = hrstotales-(m*60)-(h*3600);
        tothrsmenor = (h < 10) ? "0" + h : String.valueOf(h);
        String totalhrs = tothrsmenor+":"+dosDigitos.format(m)+":"+dosDigitos.format(s);
        
        //Calcula el tiempo descontado
        if("Quincenal".equals(tiposueldo)){
            //Si el tipo de sueldo es quincenal, entonces el horario del empleado se debe cumplir dos veces
        String horah = "";
        String minh = "";
        String segh = "";
        int valor = 0;
        StringTokenizer token = new StringTokenizer(hrstotdehorario, ":");
                for(int i = 1;token.hasMoreTokens(); i++){
            if (i == 1){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        horah = (valor < 10) ?  "0" + valor : String.valueOf(valor);
            }
            else if (i == 2){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        minh = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
            else if (i == 3){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        segh = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
        }
        int hrasengundosh = (((Integer.parseInt(horah)*60)*60)+(Integer.parseInt(minh)*60) + Integer.parseInt(segh))*2;  

        //Convertimos el horario al doble en formato HH:mm:ss
        String hrsegmenor = "";
	int sumah = (hrasengundosh/3600);
	int sumam = ((hrasengundosh-(sumah*3600))/60);
	int sumas = hrasengundosh-(sumam*60)-(sumah*3600);
        hrsegmenor = (sumah < 10) ? "0" + sumah : String.valueOf(sumah);
        //Este es el tiempo que debe laborar el empleado en toda la quincena, es su tiempo meta 
        hrcompuestadob = hrsegmenor+":"+dosDigitos.format(sumam)+":"+dosDigitos.format(sumas);

        //Calculamos el tiempo descontado, tiempo que le falto laborar al empleado para asi obtener su sueldo base 
        int tiempodesc = hrasengundosh - hrstotales;
        
        //Convertimos el tiempo descontado a formato HH:mm:ss
        String htdescmenor = "";
	int restahoras = (tiempodesc/3600);
	int restaminutos = ((tiempodesc-(restahoras*3600))/60);
	int restasegundos = tiempodesc-(restaminutos*60)-(restahoras*3600);
        htdescmenor = (restahoras < 10) ? "0" + restahoras : String.valueOf(restahoras);
        tdescontado = htdescmenor+":"+dosDigitos.format(restaminutos)+":"+dosDigitos.format(restasegundos);
        }
        //Calcula el tiempo descontado
        else if("Semanal".equals(tiposueldo)){
            //Como el tipo de sueldo no es quincenal, entonces solo se toman las horas totales del horario del empleado
        hrcompuestadob = hrstotdehorario;
        //Obtenemos las horas, los minutos y los segundos del total de horas del horario
        String horahrio = "";
        String minhrio = "";
        String seghrio = "";
        int valor2 = 0;
        StringTokenizer token2 = new StringTokenizer(hrstotdehorario, ":");
                for(int i = 1;token2.hasMoreTokens(); i++){
            if (i == 1){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        horahrio = (valor2 < 10) ?  "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 2){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        minhrio = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 3){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        seghrio = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
        }
                
        //Se converte a segundos las horas del horario del empleado
        int hrasengundoshrio = ((Integer.parseInt(horahrio)*60)*60)+(Integer.parseInt(minhrio)*60) + Integer.parseInt(seghrio); 
        //Calculamos el tiempo descontado, tiempo que le falto laborar al empleado para asi obtener su sueldo base
        int tiempodescont = hrasengundoshrio - hrstotales;
        
        //Convertimos el tiempo descontado a formato de HH:mm:ss
        String tdescmenor = "";
	int restah = (tiempodescont/3600);
	int restam = ((tiempodescont-(restah*3600))/60);
	int restas = tiempodescont-(restam*60)-(restah*3600);
        tdescmenor = (restah < 10) ? "0" + restah : String.valueOf(restah);
        tdescontado = tdescmenor+":"+dosDigitos.format(restam)+":"+dosDigitos.format(restas);
        }
        else if("Por hora".equals(tiposueldo)){
          tdescontado = "00:00:00";  
        }
       //Calcula las horas extras y el sueldo del empleado
           int pagohoraexta = 0;
           float pagoporsegundoex = 0;
           tottiempoexaeds += tiempoextraante + tiempoextradess;
            //Convertimos las horas extras en segundos del periodo consultado al formato HH:mm:ss
        String hex = "";
        int hs = (tottiempoexaeds/3600);
	int ms = ((tottiempoexaeds-(hs*3600))/60);
	int ss = tottiempoexaeds-(ms*60)-(hs*3600);
        hex = (hs < 10) ? "0" + hs : String.valueOf(hs);
        totalhrsextras = (tottiempoexaeds != 0 ) ? hex+":"+dosDigitos.format(ms)+":"+dosDigitos.format(ss) : "00:00:00";    
        
        //JOptionPane.showMessageDialog(null, "El total de horas extras antes de la entrada son: " + tiempoextraante);
        //JOptionPane.showMessageDialog(null, "El total de horas extras despues de la salida son: " + tiempoextradess);
        
        //Consultamos el pago de las horas extras
                  try{
         ResultSet r = null;
            r = stconpagohrext.executeQuery();
            if(r.next()){
               pagohoraexta = r.getInt("pagohrextra");
                       }
            } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
         //Dividimos el pago de la hora extra entre 3600 segundos para saber cuanto se debe pagar por segundo extra
         pagoporsegundoex = ((float)pagohoraexta/(float)3600);
        //Calculamos la cantidad que se debe pagar al empleado por concepto de las horas extras, multiplicando el pago por segundo extra
         //por el total de horas extras convertidas en segundos
        pagoemplehrsex = (tottiempoexaeds * pagoporsegundoex);
            //Calculamos el sueldo del empleado enviando la clave del empleado, el total de horas laboradas del periodo consultado y el tipo de sueldo (Semanal, Quincenal o Por hora)
        float pago_emp = calcularpagoemp(cempleado, totalhrs, tiposueldo);
        pagoe = pago_emp;
        pagoemptotal = pago_emp + pagoemplehrsex;
        
        //Muestra los resultados de la nomina en pantalla
        resultconnom.append("                                    "+super.getTitle() + "\n" + 
        "|Clave del empleado: " + cempleado + "|" + "     " + "|Nombre del empleado: " + nombreempleado + "|" + "\n" + 
        "|Periodo del: " + dCfechainicio.getText() + " al " + dCfechafin.getText() + "|" + "     " + "|Forma de pago: " + tiposueldo + "|" + "\n" + 
        "|Sueldo base: " + formatoMoneda.format(sueldoempleado) + "|" + "     " + "|Días laborados: " + diaslaborados + "|" + "\n" + 
        "|*Tiempo meta: " + hrcompuestadob + " horas|" + "     " + "|Tiempo laborado: " + totalhrs + " horas|" + "\n" +
        "|Tiempo descontado: " + tdescontado + " horas|" + "     " + "|Horas extras: " + totalhrsextras + " horas|" + "\n" + 
        "|Monto horas extras: " + formatoMoneda.format(pagoemplehrsex) + "|" + "     " + "|Pago: " + formatoMoneda.format(pagoe) + "|" + "\n" + 
        "|Total: " + formatoMoneda.format(pagoemptotal) + "|" + "\n" + 
        "|*Tiempo que se debe laborar para obtener el sueldo base (solo en pago semanal y quincenal)|" + "\n\n");
        
        //Por seguridad volvemos a cero las siguientes variables
        diaextraae = false;
        diaextrads = false;
        tiempoextraante = 0;
        tiempoextradess = 0;
        hrstotales = 0;
        diaslaborados = 0;
}
public void obtenerdtsnom(){
        String nombreempleado = jCBempleadosnom.getSelectedItem().toString();
        int cempleado = 0;
        
        try{
            //Obtenemos la clave del nombre del empleado que seleccionamos
    stclaveempleado.setString(1, nombreempleado);
            ResultSet r = null;
            r = stclaveempleado.executeQuery();
            while(r.next()){
               cempleado = r.getInt("clave");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        obtdtsdeactivosnom(cempleado);
}
    private void jBlimpiarresulnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarresulnomActionPerformed
        limresultconnom();
    }//GEN-LAST:event_jBlimpiarresulnomActionPerformed
    public void limresultconnom(){
    resultconnom.setText(""); 
    }
    private void jBlimpiarconnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarconnomActionPerformed
        limpiardtsconnom();
    }//GEN-LAST:event_jBlimpiarconnomActionPerformed
public void limpiardtsconnom(){
    jCBempleadosnom.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
    llenar_comboempnom(); //y vuelves a llamar tu metodo donde llenas el combo
    dCfechainicio.setSelectedDate(Calendar.getInstance());
    dCfechafin.setSelectedDate(Calendar.getInstance());
}
    private void btnguarcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguarcontraActionPerformed
            validardtscontra();      
    }//GEN-LAST:event_btnguarcontraActionPerformed
    public void validardtscontra(){
        String nuevacontra = new String(jpnuevacontra.getPassword());
        String nuevacontrac = new String(jpcnuevacontra.getPassword());
        String indiciocon = txtindiciocontra.getText();
        if(jpnuevacontra.getText().equals("") || jpcnuevacontra.getText().equals("") || txtindiciocontra.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);
        }
        //Verificar que la nueva contraseña sea igual a la contraseña confirmada
        else if(!nuevacontra.equals(nuevacontrac)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La nueva contraseña no coincide con la contraseña confirmada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(indiciocon.equals(nuevacontra) && indiciocon.equals(nuevacontrac)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El indicio no puede ser igual a la nueva contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        obtenerdtsactclv();
    }

    public void obtenerdtsactclv(){
        String nuevacontra = new String(jpcnuevacontra.getPassword());
        String indicio = txtindiciocontra.getText();
        //Verifica si ya hay una contraseña guardada entonces solo la actualiza
                try{
        ResultSet res = stconclvadmin.executeQuery();
         if(res.next()){
        objetoutil.actualizarclv(nuevacontra, indicio);   
         }
         //Si no hay ninguna contraseña guardada entonces la inserta en la bd
         else{
            objetoutil.insertarclv(nuevacontra, indicio);} 
      } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    private void btnlimpdtscontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpdtscontraActionPerformed
        limpiardtsclv();
    }//GEN-LAST:event_btnlimpdtscontraActionPerformed
    public void limpiardtsclv(){
      jpnuevacontra.setText("");
      jpcnuevacontra.setText("");
      txtindiciocontra.setText("");  
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jDactcontraseña.setLocationRelativeTo(null);
        jDactcontraseña.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnaceptarclvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarclvActionPerformed
        verificlavead();
    }//GEN-LAST:event_btnaceptarclvActionPerformed

    //Verifica que sea correcta la clave del administrador
    public void verificlavead(){
     String contraseñausr = new String(jppassword.getPassword());
     String contraseñabd = null;
        try {
                ResultSet rs = stconclvadmin.executeQuery();
                while (rs.next()) {
                    contraseñabd = rs.getString("claveadmin");
                }
                if(contraseñabd == null){
                    jDpedirclave.setVisible(false);}
                    
                    else if(contraseñausr.equals(contraseñabd)){
                    jDpedirclave.setVisible(false);
                    }
                    
                    else{
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(jDpedirclave, "La contraseña no coincide, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);}
                
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
    private void btncancelarclvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarclvActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncancelarclvActionPerformed

    private void jDpedirclaveWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDpedirclaveWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jDpedirclaveWindowClosing

    private void lblindicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblindicioMouseClicked
        try{
        ResultSet res = stconindicio.executeQuery();
         if(res.next()){
         JOptionPane.showMessageDialog(jDpedirclave, "Indicio: " + res.getObject("indicio"));   
         }
      } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_lblindicioMouseClicked

    private void jMIaltacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIaltacheActionPerformed
       jDaltachecada.setLocationRelativeTo(null);
       jDaltachecada.setVisible(true);
       jCBempchec.grabFocus();
    }//GEN-LAST:event_jMIaltacheActionPerformed

    private void btnlimpiarcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarcheActionPerformed
        limpiardtsche();
    }//GEN-LAST:event_btnlimpiarcheActionPerformed
    public void limpiardtsche(){
    jCBempchec.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_comboempchec(); //y vuelves a llamar tu metodo donde llenas el combo
        dCCfechchec.setSelectedDate(Calendar.getInstance());
        txthrchec.setText("00:00:00");    
    }
    private void btnguardarcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarcheActionPerformed
        validardtsche();
    }//GEN-LAST:event_btnguardarcheActionPerformed

    private void btnlimptabccheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimptabccheActionPerformed
        limpiartablachec();
    }//GEN-LAST:event_btnlimptabccheActionPerformed
    public void limpiartablachec(){
        int numfilas = dtmcchec.getRowCount();
       while(numfilas !=0){
          dtmcchec.removeRow(0);
          numfilas --;
      }
    }
    private void tablaconsultachecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultachecMouseClicked
        try{
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
     clavechecadax = tablaconsultachec.getValueAt(tablaconsultachec.getSelectedRow(),0);
     numerochecadax = tablaconsultachec.getValueAt(tablaconsultachec.getSelectedRow(),4);
     menuContextualche.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }catch(ArrayIndexOutOfBoundsException evento){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro","Error",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_tablaconsultachecMouseClicked
    
    public void obtenerdconchecac(int clvemp){
       try {
            String fechainicioche = dCfechainicioche.getText();
            String fechafinche = dCfechafinche.getText();
            
            try {   
                    stchecadas.setInt(1,clvemp);
                    stchecadas.setString(2,fechainicioche);
                    stchecadas.setString(3,fechafinche);
                    ResultSet res = stchecadas.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datachecadas[i-1] = (res.getString(i));
              }
            dtmcchec.addRow(datachecadas);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void obtenerdconchec(){
       try {
            String fechainicioche = dCfechainicioche.getText();
            String fechafinche = dCfechafinche.getText();
            String vlrseleccionado = jCBnomempchec.getSelectedItem().toString();
            int claveemp = 0;
            
            try{
            //Obtenemos la clave del nombre del empleado que seleccionamos
            stclaveempleado.setString(1, vlrseleccionado);
            ResultSet r = null;
            r = stclaveempleado.executeQuery();
            while(r.next()){
               claveemp = r.getInt("clave");
                       }
            } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            
            try {   
                    stchecadas.setInt(1,claveemp);
                    stchecadas.setString(2,fechainicioche);
                    stchecadas.setString(3,fechafinche);
                    ResultSet res = stchecadas.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datachecadas[i-1] = (res.getString(i));
              }
            dtmcchec.addRow(datachecadas);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    private void btnlimpiarpnomcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarpnomcheActionPerformed
        limpiardtsconche();
    }//GEN-LAST:event_btnlimpiarpnomcheActionPerformed
    public void limpiardtsconche(){
      jCBnomempchec.removeAllItems();
      llenar_cempconche();
      dCfechainicioche.setSelectedDate(Calendar.getInstance());
      dCfechafinche.setSelectedDate(Calendar.getInstance());
    }
    private void jMIconelimcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIconelimcheActionPerformed
        limpiardtsconche();
        limpiartablachec();
        jDconsultachec.setLocationRelativeTo(null);
        jDconsultachec.setVisible(true);
        jCBnomempchec.grabFocus();
    }//GEN-LAST:event_jMIconelimcheActionPerformed

    private void jMIelitodascheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIelitodascheActionPerformed
    jDpclvdelche.setLocationRelativeTo(null);
    jDpclvdelche.setVisible(true);
    }//GEN-LAST:event_jMIelitodascheActionPerformed

    private void btnaceptarclvdelcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarclvdelcActionPerformed
    verificlaveaddelc();
    }//GEN-LAST:event_btnaceptarclvdelcActionPerformed
        //Verifica que sea correcta la clave del administrador
    public void verificlaveaddelc(){
     String contraseñausr = new String(jppassworddelche.getPassword());
     String contraseñabd = null;
        try {
                ResultSet rs = stconclvadmin.executeQuery();
                while (rs.next()) {
                    contraseñabd = rs.getString("claveadmin");
                }
                if(contraseñabd == null){
                    jppassworddelche.setText("");
                    jDpclvdelche.setVisible(false);
                    borrartodaschec();}
                    
                    else if(contraseñausr.equals(contraseñabd)){
                    jppassworddelche.setText("");
                    jDpclvdelche.setVisible(false);
                    borrartodaschec();}
                    
                    else{
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);}
                
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
    private void btncancelarclvdelcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarclvdelcActionPerformed
        jppassworddelche.setText("");       
        jDpclvdelche.setVisible(false);
    }//GEN-LAST:event_btncancelarclvdelcActionPerformed

    private void lblindiciodelcheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblindiciodelcheMouseClicked
        try{
        ResultSet res = stconindicio.executeQuery();
         if(res.next()){
         JOptionPane.showMessageDialog(null, "Indicio: " + res.getObject("indicio"));   
         }
      } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_lblindiciodelcheMouseClicked

    private void jDpclvdelcheWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDpclvdelcheWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_jDpclvdelcheWindowClosing

    private void jDaltahueWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDaltahueWindowClosing
        destroy();
    }//GEN-LAST:event_jDaltahueWindowClosing

    private void jBlimpiarsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarsalidaActionPerformed
    limpdtssalida();    
    }//GEN-LAST:event_jBlimpiarsalidaActionPerformed

    private void txtclaveemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclaveemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclaveemActionPerformed

    private void btnguardarchemodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarchemodActionPerformed
        validardtschecmod();
    }//GEN-LAST:event_btnguardarchemodActionPerformed

    private void txtcnomemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomemKeyTyped
        obtenerdcem();
    }//GEN-LAST:event_txtcnomemKeyTyped

    private void txtcnomarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomarKeyTyped
        obtenerdcarea();
    }//GEN-LAST:event_txtcnomarKeyTyped

    private void txtcnomtipeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomtipeKeyTyped
        obtenerdcontipe();
    }//GEN-LAST:event_txtcnomtipeKeyTyped

    private void txtcnomprohueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomprohueKeyTyped
        obtenerdconhue();
    }//GEN-LAST:event_txtcnomprohueKeyTyped

    private void txtcnomhorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomhorKeyTyped
        obtenerdconhor();
    }//GEN-LAST:event_txtcnomhorKeyTyped

    private void btnconsultarasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarasisActionPerformed
        validardtsasis();
    }//GEN-LAST:event_btnconsultarasisActionPerformed
    public void validardtsasis(){
        String nombreempasis = jCBempleadosasis.getSelectedItem().toString();
        if("SELECCIONE UN CAMPO".equals(nombreempasis)){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el nombre del empleado","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            verifisoloactivos();
    }
        public void verifisoloactivos(){
    String clvempactivo = null;
    String vlrseleccionado = jCBempleadosasis.getSelectedItem().toString();
    String fechainicioasis = dCfechainiasis.getText();
    String fechafinasis = dCfechafinasis.getText();
    if("SOLO EMPLEADOS ACTIVOS".equals(vlrseleccionado)){
    try {   
            ResultSet rs = stconclvsempleac.executeQuery();
            int nColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
    for (int i = 1; i <= nColumnas; i ++){
    clvempactivo = (rs.getString(i));

      }
            }
            if (error == false){
            JOptionPane.showMessageDialog(null,"Las checadas se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Las checadas no se pudieron guardar.\n ");
        }
        limpiardtsche();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        jCBempchec.grabFocus();
        }
    else {
        obtenerdtsasis();
    }
    }
        public void obtenerdtsasis(){
        try {
            int clvempleado = obtenerclvempasis();
            Date dfechainicio = null;
            Date dfechafin = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            dfechainicio = sdf.parse(dCfechainiasis.getText());
            dfechafin = sdf.parse(dCfechafinasis.getText());
            int checadasdeldia = 0;
            
            //Iteramos en todos los dias del periodo sonsultado
             while(dfechainicio.before(dfechafin) || dfechainicio.equals(dfechafin)){
             String stfechainicio = sdf.format(dfechainicio);
             try {
                 stcondlaborados.setString(1, stfechainicio);
                 stcondlaborados.setInt(2, clvempleado);
                 ResultSet rs = stcondlaborados.executeQuery();
                 while (rs.next()) {
                     checadasdeldia = Integer.parseInt(rs.getString("count(fecha_checada)"));       
                 }
                 //Si el empleado checo mas de una vez en ese día, entonces se toma como un dia laborado
                 if(checadasdeldia > 1){
                         stasistencia.setString(1,stfechainicio);
                         stasistencia.setInt(2,clvempleado);
                         ResultSet res = stasistencia.executeQuery();
                         int nColumnas = res.getMetaData().getColumnCount();
                         while (res.next()) {
                 for (int i = 1; i <= nColumnas; i++){
                 dataasistencia[i-1] = (res.getString(i));
              }
            dataasistencia[5] = verificarretardo(stfechainicio, clvempleado);
            dataasistencia[6] = calculartlaborado(stfechainicio, clvempleado);
            dataasistencia[7] = calculartlaborado(stfechainicio, clvempleado);
            dtmcasis.addRow(dataasistencia);
                         }
                 }
                 //Incrementamos la fecha de inicio que se consulto, cuando sea mayor a la fecha final entonces sale de la iteración
                 dfechainicio = sumaDias(dfechainicio, 1);
             } catch (SQLException ex) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(null,ex.getMessage());
             }
                     }//Fin de la iteracion del los dias consultados
        } catch (ParseException ex) {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage()); 
        } 
    }
    //Calcula las horas laboradas del día
        public String calculartlaborado(String fechainicio, int clvemp){
        String hrentrada = null;
        String hrsalida = null;
        try{
        //Consultamos la checada minima
                stconminhrchec.setString(1, fechainicio);
                stconminhrchec.setInt(2, clvemp);
            ResultSet resminhr = stconminhrchec.executeQuery();
            while (resminhr.next()) {
                hrentrada = resminhr.getString("MIN(checadas.hora_checada)");       
                }
            } catch (SQLException ex) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(null,ex.getMessage());
             }
        try{
                //Consultamos la checada maxima
                stconmaxhrchec.setString(1, fechainicio);
                stconmaxhrchec.setInt(2, clvemp);
            ResultSet resmaxhr = stconmaxhrchec.executeQuery();
            while (resmaxhr.next()) {
                hrsalida = resmaxhr.getString("MAX(checadas.hora_checada)");       
                }
            } catch (SQLException ex) {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(null,ex.getMessage());
             }
            //Se calculan las horas laboradas del día
            String laboradas = RestarHoras(hrentrada, hrsalida);
            return laboradas;
    }
        
    public String verificarretardo(String stfechainicio, int clvemp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dayname = null;
        String horaentdiahrio = null;
        int clvhorarioemp = 0;
        int minstolerancia = 0;
        String checentrada = null;
        Date checadaentrada = null;
        Date hrentradamastole = null;
        String tiemporetardo = null;
        
        //Obtenemos la clave del horarios que tiene el empleado
        try{
        stconhordeemp.setInt(1, clvemp);
            ResultSet res = null;
            res = stconhordeemp.executeQuery();
            while(res.next()){
               clvhorarioemp = res.getInt(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Obtenemos el nombre del dia consultado        
        try{
        stnombredia.setString(1, stfechainicio);
            ResultSet res = null;
            res = stnombredia.executeQuery();
            while(res.next()){
               dayname = res.getString(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());}
        //Obtenemos la hora de entrada del dia consultado
        if("Monday".equals(dayname)){
            try{
            stconhrentlun.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentlun.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentlun");
                       }
            }
            catch(SQLException f){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,f.getMessage());
         }
        }
            
        else if("Tuesday".equals(dayname)){
          try{
            stconhrentmar.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentmar.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentmar");
                       }
            }
            catch(SQLException g){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,g.getMessage());
         }  
        }
            
        else if("Wednesday".equals(dayname)){
          try{
            stconhrentmie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentmie.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentmie");
                       }
            }
            catch(SQLException h){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,h.getMessage());
         }
        }
        
        else if("Thursday".equals(dayname)){
         try{
            stconhrentjue.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentjue.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentjue");
                       }
            }
            catch(SQLException i){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,i.getMessage());
         }
        }
        
        else if("Friday".equals(dayname)){
          try{
            stconhrentvie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentvie.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentvie");
                       }
            }
            catch(SQLException j){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,j.getMessage());
         }
        }
        
        else if("Saturday".equals(dayname)){
          try{
            stconhrentsab.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentsab.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentsab");
                       }
            }
            catch(SQLException k){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,k.getMessage());
         }
        }
        
        else if("Sunday".equals(dayname)){
          try{
            stconhrentdom.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentdom.executeQuery();
            while(res.next()){
            horaentdiahrio = res.getString("horaentdom");
                       }
            }
            catch(SQLException l){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,l.getMessage());
         }
        }
        
            //Obtenemos los minutos de tolerancia despues de entrada del dia del horario del empleado
            try{
            stconmtstoldesent.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconmtstoldesent.executeQuery();
            while(res.next()){
            minstolerancia = res.getInt("mtstolerancia");
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
            //Obtenemos la checada de entrada de la fecha consultada
            try{
            stconminhrchasis.setString(1, stfechainicio);
            stconminhrchasis.setInt(2, clvemp);
            ResultSet res = null;
            res = stconminhrchasis.executeQuery();
            while(res.next()){
            checentrada = res.getString(1);
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
            //Sumamos a la hora de entrada del día consultado los minutos de tolerancia del horario del empleado
            String horaentmastol = Sumaminstol(horaentdiahrio, minstolerancia);
        try {
            checadaentrada = sdf.parse(checentrada);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        try {
            hrentradamastole = sdf.parse(horaentmastol);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
            //Comparamos la checada de entrada de la fecha consultada con la hora de entrada del horario del empleado, si la checada de entrada
             //es mayor entonces se toma como retardo y si es menor o igual no se toma como retardo        
            if(checadaentrada.after(hrentradamastole)){
                tiemporetardo = calcularretardo(checentrada, horaentmastol);
            }
            else{
                tiemporetardo = "Sin retardo";
            }
            
            
    return tiemporetardo;    
        
    }
        //Calcula el tiempo de retardo que tuvo el empleado en ese dia
    public String calcularretardo(String horache,String horaentrada){
        DecimalFormat dosDigitos = new DecimalFormat("00");
        
	int horach = Integer.parseInt(horache.substring(0, 2));
	int minch = Integer.parseInt(horache.substring(3, 5));

	int horaent = Integer.parseInt(horaentrada.substring(0, 2));
	int minent = Integer.parseInt(horaentrada.substring(3, 5));

	int hrchecada=(((horach*60)*60)+(minch*60));
	int hrentrada=(((horaent*60)*60)+(minent*60));
	int dif = hrchecada - hrentrada;

	int difh = (dif/3600);
	int difm = ((dif-(difh*3600))/60);
        String hrcompuesta = dosDigitos.format(difh)+":"+dosDigitos.format(difm);
  
	return hrcompuesta;
}
    
        //Suma los minutos de tolerancia despues de entrada y los minutos de tolerancia despues de salida
    public String Sumaminstol(String hora, int minutostoledes){
        DecimalFormat dosDigitos = new DecimalFormat("00");
	int horae = Integer.parseInt(hora.substring(0, 2));
	int mine = Integer.parseInt(hora.substring(3, 5));
        int sege = Integer.parseInt(hora.substring(6));

	int horatol = 0;
	int mintol = minutostoledes;
	int segtol = 59;

	int hr =(((horae*60)*60)+(mine*60)+sege);
	int mtstolerancia =(((horatol*60)*60)+(mintol*60)+segtol);
	int sumatolhr = hr + mtstolerancia;

	int sumah = (sumatolhr/3600);
	int sumam = ((sumatolhr-(sumah*3600))/60);
        int sumas = sumatolhr-(sumam*60)-(sumah*3600);
        String hrcompuesta = dosDigitos.format(sumah)+":"+dosDigitos.format(sumam)+":"+dosDigitos.format(sumas);

	return hrcompuesta;
}
    
    //Resta los minutos de tolerancia antes de salida y los minutos de tolerancia antes de entrada del horario del empleado
    public String Restaminstol(String hora, int minutostoleant){
        DecimalFormat dosDigitos = new DecimalFormat("00");
	int horas = Integer.parseInt(hora.substring(0, 2));
	int mins = Integer.parseInt(hora.substring(3, 5));
        int segs = Integer.parseInt(hora.substring(6));

	int horatol = 00;
	int mintol = minutostoleant;
	int segtol = 00;

	int hr =(((horas*60)*60)+(mins*60)+segs);
	int mtstolerancia =(((horatol*60)*60)+(mintol*60)+segtol);
	int restatolhr = hr - mtstolerancia;

	int restah = (restatolhr/3600);
	int restam = ((restatolhr-(restah*3600))/60);
        int restas = restatolhr-(restam*60)-(restah*3600);
        String hrcompuesta = dosDigitos.format(restah)+":"+dosDigitos.format(restam)+":"+dosDigitos.format(restas);

	return hrcompuesta;
}
    //Verificamos la hora de entrada, si la checada es menor que su hora de entrada establecida en ese día o si esta dentro de
   //los minutos de tolerancia establecidos en ese día entonces se asigna la hora de entrada establecida en ese dia, si la checada es mayor
   //que la hora de entrada establecida en ese día mas los minutos de tolrencia entonces se asigna la hora de la checada  
public String verificarhoraentrada(String stfechainicio, int clvemp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dayname = null;
        String horaentdiahrio = null;
        int clvhorarioemp = 0;
        int minstoleradesent = 0;
        int minstoleraantent = 0;
        String checentrada = null;
        Date checadaentrada = null;
        Date hrentradamastole = null;
        String horaentrada = null;
        
        //Obtenemos la clave del horarios que tiene el empleado
        try{
        stconhordeemp.setInt(1, clvemp);
            ResultSet res = null;
            res = stconhordeemp.executeQuery();
            while(res.next()){
               clvhorarioemp = res.getInt(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Obtenemos el nombre del dia consultado        
        try{
        stnombredia.setString(1, stfechainicio);
            ResultSet res = null;
            res = stnombredia.executeQuery();
            while(res.next()){
               dayname = res.getString(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
                    //Obtenemos la checada de entrada de la fecha consultada
            try{
            stconminhrchec.setString(1, stfechainicio);
            stconminhrchec.setInt(2, clvemp);
            ResultSet res = null;
            res = stconminhrchec.executeQuery();
            while(res.next()){
            checentrada = res.getString(1);
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
        //Obtenemos la hora de entrada del día consultado (día que se encuentra en la tabla horarios)
        if("Monday".equals(dayname)){
            try{
            stconhrentlun.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentlun.executeQuery();
            while(res.next()){
            if ( !"00:00:00".equals(res.getString("horaentlun"))){ 
              horaentdiahrio = res.getString("horaentlun");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada; 
                diaextraae = true;
            }
                       }
            }
            catch(SQLException f){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,f.getMessage());
         }
        }
            
        else if("Tuesday".equals(dayname)){
          try{
            stconhrentmar.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentmar.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentmar");
            if ( !"00:00:00".equals(res.getString("horaentmar"))){ 
              horaentdiahrio = res.getString("horaentmar");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException g){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,g.getMessage());
         }  
        }
            
        else if("Wednesday".equals(dayname)){
          try{
            stconhrentmie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentmie.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentmie");
                if ( !"00:00:00".equals(res.getString("horaentmie"))){ 
              horaentdiahrio = res.getString("horaentmie");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException h){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,h.getMessage());
         }
        }
        
        else if("Thursday".equals(dayname)){
         try{
            stconhrentjue.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentjue.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentjue");
            if ( !"00:00:00".equals(res.getString("horaentjue"))){ 
              horaentdiahrio = res.getString("horaentjue");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException i){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,i.getMessage());
         }
        }
        
        else if("Friday".equals(dayname)){
          try{
            stconhrentvie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentvie.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentvie");
            if ( !"00:00:00".equals(res.getString("horaentvie"))){ 
              horaentdiahrio = res.getString("horaentvie");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException j){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,j.getMessage());
         }
        }
        
        else if("Saturday".equals(dayname)){
          try{
            stconhrentsab.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentsab.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentsab");
            if ( !"00:00:00".equals(res.getString("horaentsab"))){ 
              horaentdiahrio = res.getString("horaentsab");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException k){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,k.getMessage());
         }
        }
        
        else if("Sunday".equals(dayname)){
          try{
            stconhrentdom.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrentdom.executeQuery();
            while(res.next()){
            //horaentdiahrio = res.getString("horaentdom");
            if ( !"00:00:00".equals(res.getString("horaentdom"))){ 
              horaentdiahrio = res.getString("horaentdom");
              diaextraae = false;
            } 
            else{
                horaentrada = checentrada;
                diaextraae = true;
            }
                       }
            }
            catch(SQLException l){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,l.getMessage());
         }
        }
        if(horaentdiahrio != null){
            //Obtenemos los minutos de tolerancia despues de entrada del dia del horario del empleado
            try{
            stconmtstoldesent.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconmtstoldesent.executeQuery();
            while(res.next()){
            minstoleradesent = res.getInt("toleradesentdia");
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
            //Obtenemos los minutos de tolerancia antes de entrada del dia del horario del empleado
            try{
            stcontolantent.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stcontolantent.executeQuery();
            while(res.next()){
            minstoleraantent = res.getInt("toleraantentdia");
                       }
            }
            catch(SQLException n){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,n.getMessage());
            }

            //Sumamos a la hora de entrada del día del horario consultado los minutos de tolerancia del horario del empleado
            String horaentmastol = Sumaminstol(horaentdiahrio, minstoleradesent);
        try {
            checadaentrada = sdf.parse(checentrada);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        try {
            hrentradamastole = sdf.parse(horaentmastol);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

        //Verificamos que la checada sea menor que la hora de entrada del dia menos los minutos de tolerancia antes de entrada
        String hrentmenostantent = Restaminstol(horaentdiahrio, minstoleraantent);
        String horaemenost = "";
        String minemenost = "";
        String segemenost = "";
        int valor = 0;
        StringTokenizer token = new StringTokenizer(hrentmenostantent, ":");
                for(int i = 1;token.hasMoreTokens(); i++){
            if (i == 1){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        horaemenost = (valor < 10) ?  "0" + valor : String.valueOf(valor);
            }
            else if (i == 2){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        minemenost = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
            else if (i == 3){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        segemenost = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
        }
        
        String horachecent = "";
        String minchecent = "";
        String segchecent = "";
        int valor2 = 0;
        StringTokenizer token2 = new StringTokenizer(checentrada, ":");
                for(int i = 1;token2.hasMoreTokens(); i++){
            if (i == 1){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
         horachecent = (valor2 < 10) ?  "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 2){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        minchecent = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 3){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        segchecent = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
        }
                
        String hrentdiah = "";
        String mnentdiah = "";
        String sgentdiah = "";
        int valorx = 0;
        StringTokenizer tokenx = new StringTokenizer(horaentdiahrio, ":");
        for(int y = 1; tokenx.hasMoreTokens(); y ++){
            if (y == 1){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                hrentdiah = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
            else if(y == 2){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                mnentdiah = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
            else if(y == 3){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                sgentdiah = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
        }
                
	int hrentmentolante =(((Integer.parseInt(horaemenost)*60)*60)+(Integer.parseInt(minemenost)*60)+Integer.parseInt(segemenost));
	int hrchecada =(((Integer.parseInt(horachecent)*60)*60)+(Integer.parseInt(minchecent)*60)+Integer.parseInt(segchecent));
        int hrentradadh =(((Integer.parseInt(hrentdiah)*60)*60)+(Integer.parseInt(mnentdiah)*60)+Integer.parseInt(sgentdiah));
            //si la checada es menor entonces se acumula el tiempo extra
            if(hrchecada < hrentmentolante){
            tiempoextraante += hrentradadh - hrchecada;
            horaentrada = horaentdiahrio;
            JOptionPane.showMessageDialog(null, "Si hubo hora extra antes de la entrada, y es: " + tiempoextraante);
            }
            //Si la checada no es menor entonces la checada se establece antes de la entrada del día o despues
            else{
                if(checadaentrada.before(hrentradamastole) || checadaentrada.equals(hrentradamastole)){
                horaentrada = horaentdiahrio;
                }
                else{
                horaentrada = checentrada; 
                } 
            }

            return horaentrada;
        }
        
        else{
            return horaentrada;
        }
    }
 //Verificamos la hora de salida, si la checada es mayor que su hora de salida establecida en ese día o si esta dentro de
   //los minutos de tolerancia establecidos en ese día entonces se asigna la hora de salida establecida en ese dia, si la checada es menor
   //que la hora de salida establecida en ese día menos los minutos de tolrencia entonces se asigna la hora de la checada
public String verificarhorasalida(String stfechainicio, int clvemp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dayname = null;
        String horasaldiahrio = null;
        int clvhorarioemp = 0;
        int minstoleraantsal = 0;
        int minstoleradessal = 0;
        String checsalida = null;
        Date checadasalida = null;
        Date hrsalidamenostole = null;
        String horasalida = null;
        
        //Obtenemos la clave del horarios que tiene el empleado
        try{
        stconhordeemp.setInt(1, clvemp);
            ResultSet res = null;
            res = stconhordeemp.executeQuery();
            while(res.next()){
               clvhorarioemp = res.getInt(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        //Obtenemos el nombre del dia consultado        
        try{
        stnombredia.setString(1, stfechainicio);
            ResultSet res = null;
            res = stnombredia.executeQuery();
            while(res.next()){
               dayname = res.getString(1);
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        //Obtenemos la checada de salida de la fecha consultada
            try{
            stconmaxhrchec.setString(1, stfechainicio);
            stconmaxhrchec.setInt(2, clvemp);
            ResultSet res = null;
            res = stconmaxhrchec.executeQuery();
            while(res.next()){
            checsalida = res.getString(1);
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
        //Obtenemos la hora de entrada del día consultado (día que se encuentra en la tabla horarios)
        if("Monday".equals(dayname)){
            try{
            stconhrsallun.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsallun.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasallun");
            if ( !"00:00:00".equals(res.getString("horasallun"))){ 
              horasaldiahrio = res.getString("horasallun");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException f){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,f.getMessage());
         }
        }
            
        else if("Tuesday".equals(dayname)){
          try{
            stconhrsalmar.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsalmar.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasalmar");
            if ( !"00:00:00".equals(res.getString("horasalmar"))){ 
              horasaldiahrio = res.getString("horasalmar");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException g){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,g.getMessage());
         }  
        }
            
        else if("Wednesday".equals(dayname)){
          try{
            stconhrsalmie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsalmie.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasalmie");
            if ( !"00:00:00".equals(res.getString("horasalmie"))){ 
              horasaldiahrio = res.getString("horasalmie");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException h){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,h.getMessage());
         }
        }
        
        else if("Thursday".equals(dayname)){
         try{
            stconhrsaljue.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsaljue.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasaljue");
            if ( !"00:00:00".equals(res.getString("horasaljue"))){ 
              horasaldiahrio = res.getString("horasaljue");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException i){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,i.getMessage());
         }
        }
        
        else if("Friday".equals(dayname)){
          try{
            stconhrsalvie.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsalvie.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasalvie");
            if ( !"00:00:00".equals(res.getString("horasalvie"))){ 
              horasaldiahrio = res.getString("horasalvie");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException j){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,j.getMessage());
         }
        }
        
        else if("Saturday".equals(dayname)){
          try{
            stconhrsalsab.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsalsab.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasalsab");
            if ( !"00:00:00".equals(res.getString("horasalsab"))){ 
              horasaldiahrio = res.getString("horasalsab");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException k){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,k.getMessage());
         }
        }
        
        else if("Sunday".equals(dayname)){
          try{
            stconhrsaldom.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconhrsaldom.executeQuery();
            while(res.next()){
            //horasaldiahrio = res.getString("horasaldom");
            if ( !"00:00:00".equals(res.getString("horasaldom"))){ 
              horasaldiahrio = res.getString("horasaldom");
              diaextrads = false;
            } 
            else{
                horasalida = checsalida; 
                diaextrads = true;
            }
                       }
            }
            catch(SQLException l){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,l.getMessage());
         }
        }
        if(horasaldiahrio != null){
            //Obtenemos los minutos de tolerancia antes de salida del dia del horario del empleado
            try{
            stconmtstolantsal.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stconmtstolantsal.executeQuery();
            while(res.next()){
            minstoleraantsal = res.getInt("toleraantsaldia");
                       }
            }
            catch(SQLException m){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,m.getMessage());
            }
            //Obtenemos los minutos de tolerancia despues de salida del dia del horario del empleado
            try{
            stcontoldessal.setInt(1, clvhorarioemp);
            ResultSet res = null;
            res = stcontoldessal.executeQuery();
            while(res.next()){
            minstoleradessal = res.getInt("toleradessaldia");
                       }
            }
            catch(SQLException n){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,n.getMessage());
            }
            
            //Restamos a la hora de salida del día consultado los minutos de tolerancia antes de salida del horario del empleado
            String horasalmenostol = Restaminstol(horasaldiahrio, minstoleraantsal);
        try {
            checadasalida = sdf.parse(checsalida);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        try {
            hrsalidamenostole = sdf.parse(horasalmenostol);
        } catch (ParseException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

        //Verificamos que la checada sea mayor que la hora de salida del dia mas los minutos de tolerancia despues de salida
        String hrsalmastdessal = Sumaminstol(horasaldiahrio, minstoleradessal);
        String horasmast = "";
        String minsmast = "";
        String segsmast = "";
        int valor = 0;
        StringTokenizer token = new StringTokenizer(hrsalmastdessal, ":");
                for(int i = 1;token.hasMoreTokens(); i++){
            if (i == 1){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        horasmast = (valor < 10) ?  "0" + valor : String.valueOf(valor);
            }
            else if (i == 2){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        minsmast = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
            else if (i == 3){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        segsmast = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
                }
        
        String horachecsal = "";
        String minchecsal = "";
        String segchecsal = "";
        int valor2 = 0;
        StringTokenizer token2 = new StringTokenizer(checsalida, ":");
                for(int i = 1;token2.hasMoreTokens(); i++){
            if (i == 1){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
         horachecsal = (valor2 < 10) ?  "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 2){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        minchecsal = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 3){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        segchecsal = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
        }
        
        String horasaldh = "";
        String minsaldh = "";
        String segsaldh = "";
        int valorx = 0;
        StringTokenizer tokenx = new StringTokenizer(horasaldiahrio, ":");
        for(int y = 1; tokenx.hasMoreTokens(); y ++){
            if (y == 1){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                horasaldh = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
            else if(y == 2){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                minsaldh = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
            else if(y == 3){
                valorx = Integer.parseInt(String.valueOf(tokenx.nextToken()));
                segsaldh = (valorx < 10) ? "0" + valorx : String.valueOf(valorx);
            }
        }

	int hrsalmastoldess =(((Integer.parseInt(horasmast)*60)*60)+(Integer.parseInt(minsmast)*60)+Integer.parseInt(segsmast));
	int hrchecada =(((Integer.parseInt(horachecsal)*60)*60)+(Integer.parseInt(minchecsal)*60)+Integer.parseInt(segchecsal));
        int hrsalidahorario =(((Integer.parseInt(horasaldh)*60)*60)+(Integer.parseInt(minsaldh)*60)+Integer.parseInt(segsaldh));
            //si la checada es mayor entonces se acumula el tiempo extra
            if(hrchecada > hrsalmastoldess){
            tiempoextradess += hrchecada - hrsalidahorario;
            horasalida = horasaldiahrio;
            }
            //Si la checada no es mayor entonces la checada se establece antes de la salida del día o igual a la salida establecida
            else{
                if(checadasalida.after(hrsalidamenostole) || checadasalida.equals(hrsalidamenostole)){
                horasalida = horasaldiahrio;
            }
            else{
                horasalida = checsalida; 
            } 
            }
            
    return horasalida; 
        }
        
        else{
          return horasalida;  
        }
        
    }
    
        public int obtenerclvempasis(){
    int clav = 0;
    String nombreemp = jCBempleadosasis.getSelectedItem().toString();
    try{
    stclaveempleado.setString(1, nombreemp);
            ResultSet res = null;
            res = stclaveempleado.executeQuery();
            while(res.next()){
               clav = res.getInt("clave");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
}
    private void btnlimpiarconaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarconaActionPerformed
        limpiardtsconasis();
    }//GEN-LAST:event_btnlimpiarconaActionPerformed
public void limpiardtsconasis(){
    jCBempleadosasis.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
    llenar_comboasis(); //y vuelves a llamar tu metodo donde llenas el combo
    dCfechainiasis.setSelectedDate(Calendar.getInstance());
    dCfechafinasis.setSelectedDate(Calendar.getInstance());
}
    private void btnlimpiarresulasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarresulasisActionPerformed
        limpiartablaasis();
        jCBempleadosasis.grabFocus();
    }//GEN-LAST:event_btnlimpiarresulasisActionPerformed
        public void limpiartablaasis(){
        int numfilas = dtmcasis.getRowCount();
       while(numfilas !=0){
          dtmcasis.removeRow(0);
          numfilas --;
      }
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        limpiardtsconasis();
        limpiartablaasis();
        jDasistencia.setLocationRelativeTo(null);
        jDasistencia.setVisible(true);
        jCBempleadosasis.grabFocus();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnimprimirnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirnomActionPerformed
               Imprimirpaginas imppaginas = new Imprimirpaginas();
               imppaginas.imprimirnomina();
    }//GEN-LAST:event_btnimprimirnomActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validardtsconche();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su entrada antes de su hora de entrada establecida,"
        + "\npor default se tomara su hora de entrada asignada en ese día."
        + "\nTodas las checadas anteriores a este tiempo serán tomadas como tiempo extra.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel93MouseClicked

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su entrada despues de su hora de entrada establecida."
        + "\nPor default se tomara su hora de entrada asignada en ese día.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su salida antes de su hora de salida establecida."
        + "\nPor default se tomara su hora de salida asignada en ese día.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su salida despues de su hora de salida establecida"
        + "\npor default se tomara su hora de salida asignada en ese día."
        + "\nTodas las checadas posteriores a este tiempo serán tomadas como tiempo extra.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel98MouseClicked

    private void btnrestaurarminstolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarminstolActionPerformed
        txttoleantentdia.setText("45");
        txttoledesentdia.setText("10");
        txttoleantsaldia.setText("10");
        txttoledessaldia.setText("45");
    }//GEN-LAST:event_btnrestaurarminstolActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiartxtpagohrex();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jDhoraextra.setLocationRelativeTo(null);
        jDhoraextra.setVisible(true);
        txtpagohrex.grabFocus();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validarpagohrex();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.US);
        int pagohrext = 0;
        try{
         ResultSet r = null;
            r = stconpagohrext.executeQuery();
            if(r.next()){
               pagohrext = r.getInt("pagohrextra");
                       }
            } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        JOptionPane.showMessageDialog(null, "El pago de la hora extra es: " + formatoMoneda.format(pagohrext), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su entrada antes de su hora de entrada establecida,"
        + "\npor default se tomara su hora de entrada asignada en ese día."
        + "\nTodas las checadas anteriores a este tiempo serán tomadas como tiempo extra.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su entrada despues de su hora de entrada establecida."
        + "\nPor default se tomara su hora de entrada asignada en ese día.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel100MouseClicked

    private void jLabel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su salida antes de su hora de salida establecida."
        + "\nPor default se tomara su hora de salida asignada en ese día.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel101MouseClicked

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        JOptionPane.showMessageDialog(null, "Tiempo que no será tomado en cuenta si el empleado "
        + "\ncheca su salida despues de su hora de salida establecida"
        + "\npor default se tomara su hora de salida asignada en ese día."
        + "\nTodas las checadas posteriores a este tiempo serán tomadas como tiempo extra.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel102MouseClicked

    private void btnrestaurarminstolmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarminstolmodActionPerformed
        txttoleantentdiamod.setText("45");
        txttoledesentdiamod.setText("10");
        txttoleantsaldiamod.setText("10");
        txttoledessaldiamod.setText("45");
    }//GEN-LAST:event_btnrestaurarminstolmodActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jDaltajustificante.setLocationRelativeTo(null);
       jDaltajustificante.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jBlimpiardtsaltajusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiardtsaltajusActionPerformed
        limpiardtsaltjus();
    }//GEN-LAST:event_jBlimpiardtsaltajusActionPerformed
    public void limpiardtsaltjus(){
        txtclvaltajusti.setText("");
        txtnombrealtajusti.setText("");
    }
    private void jBtguardarjustiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtguardarjustiActionPerformed
        validardtsjusti();
    }//GEN-LAST:event_jBtguardarjustiActionPerformed

    private void btnlimpiartablajusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiartablajusActionPerformed
        limpiartbljust();
        txtcnomjust.grabFocus();
    }//GEN-LAST:event_btnlimpiartablajusActionPerformed
    public void limpiartbljust(){
        int numfilas = dtmjustificante.getRowCount();
       while(numfilas !=0){
          dtmjustificante.removeRow(0);
          numfilas --;
      }
    }
    private void tablaconsultajustiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconsultajustiMouseClicked
        try{
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3){
     clavejustificantex = tablaconsultajusti.getValueAt(tablaconsultajusti.getSelectedRow(),0);
     menuContextualjustifi.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }catch(ArrayIndexOutOfBoundsException evento){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Por favor seleccione un registro","Error",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_tablaconsultajustiMouseClicked

    private void txtcnomjustKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnomjustKeyTyped
        obtenerdcjusti();
    }//GEN-LAST:event_txtcnomjustKeyTyped

    private void btnconsultalimjusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultalimjusActionPerformed
        txtcnomjust.setText("");
    }//GEN-LAST:event_btnconsultalimjusActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       jDconsultajust.setLocationRelativeTo(null);
       jDconsultajust.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jBtmodificarjustiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtmodificarjustiActionPerformed
        if(txtnombremodjusti.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);}                           
   else obtenerdatosjustimod();
    }//GEN-LAST:event_jBtmodificarjustiActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       jDcapactdedugral.setLocationRelativeTo(null);
       jDcapactdedugral.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void btnguardardeduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardardeduActionPerformed
        validardtsaldedu();
    }//GEN-LAST:event_btnguardardeduActionPerformed

    private void btnlimpiardtsdeduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiardtsdeduActionPerformed
        limpiardtsaldedu();
    }//GEN-LAST:event_btnlimpiardtsdeduActionPerformed
    public void limpiardtsaldedu(){
        txtdescuentofalta.setText("0.00");
        txtdescuentopermiso.setText("0.00");
        txtdescuentocomedor.setText("0.00");
        txtdescuentotrans.setText("0.00");
        txtdescuentoimss.setText("0.00");
        txtdescuentoinfona.setText("0.00");
        txtdescuentootro.setText("0.00");
    }
    
    public void validardtsaldedu(){
       if(txtdescuentofalta.getText().equals("")||
          txtdescuentopermiso.getText().equals("")||
          txtdescuentocomedor.getText().equals("")||
          txtdescuentotrans.getText().equals("")||
          txtdescuentoimss.getText().equals("")||
          txtdescuentoinfona.getText().equals("")||
          txtdescuentootro.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);                  
        }
        else if(!txtdescuentofalta.getText().matches("\\d*.\\d*")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave de la deducción debe ser de tipo decimal","Error", JOptionPane.ERROR_MESSAGE);
        }
        //else if(!txtdescuentopermiso.getText().matches("\\d+")){
            //Toolkit.getDefaultToolkit().beep();
          //  JOptionPane.showMessageDialog(null,"El descuento debe ser de tipo numérico y sin decimales","Error", JOptionPane.ERROR_MESSAGE);
        //}
    else 
            JOptionPane.showMessageDialog(null, "Puedes continuar");
            //obtenerdatosdedu();
    }
    public void obtenerdatosdedu(){
             int clavededu = Integer.parseInt(txtdescuentofalta.getText());
             String nombrededu = txtdescuentopermiso.getText();
             int descuentodedu = Integer.parseInt(txtdescuentocomedor.getText());
             objetoutil.guardardeduccion(clavededu, nombrededu, descuentodedu);
             txtdescuentofalta.grabFocus();
    }
    public void obtenerdatosjustimod()
    {   
                 String nombrejustifimod = txtnombremodjusti.getText();
                 objetoutil.guardardtsjustimodi(clavejustificantex.toString(), nombrejustifimod);         
                 //jCBarea.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                 //llenar_comboarea(); //y vuelves a llamar tu metodo donde llenas el combo
                
        jDmodjustificante.setVisible(false);
        mostrardtsmodjusti();
        txtcnomjust.grabFocus();
    }
    
    public void validardtsjusti(){
            if(txtclvaltajusti.getText().equals("")||
            txtnombrealtajusti.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);                  
        }
        else if(!txtclvaltajusti.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave del justificante debe ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
    else 
            obtenerdatosjusti();
    }
    public void obtenerdatosjusti(){
             int clavejusti = Integer.parseInt(txtclvaltajusti.getText());
             String nombrejusti = txtnombrealtajusti.getText();
             objetoutil.guardarjusti(clavejusti, nombrejusti);
             //jCBarea.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
             //llenar_comboarea(); //y vuelves a llamar tu metodo donde llenas el combo
             txtclvaltajusti.grabFocus();
    }
    public void validarpagohrex(){
        if("".equals(txtpagohrex.getText())){
         Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(null,"Por favor capture el pago de la hora extra","Error",JOptionPane.ERROR_MESSAGE);   
        }
        else if(!txtpagohrex.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"El pago de la hora extra debe ser de tipo numérico y no decimal","Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        obtenerdtshrex();
    }
    }
    public void obtenerdtshrex(){
        int pagohrextra = Integer.parseInt(txtpagohrex.getText());
         //Verifica si ya hay un pago de hora extra guardado entonces solo lo actualiza
                try{
        ResultSet res = stconpagohrext.executeQuery();
         if(res.next()){
        objetoutil.actualizarpahrex(pagohrextra);   
         }
         //Si no hay ningun pago de hora extra guardado entonces lo inserta en la bd
         else{
            objetoutil.insertarpahrex(pagohrextra);} 
      } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void limpiartxtpagohrex(){
        txtpagohrex.setText("");
    }
    public void validardtsconche(){
    String nombreempnom = jCBnomempchec.getSelectedItem().toString();
        if("SELECCIONE UN CAMPO".equals(nombreempnom)){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el nombre del empleado","Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            verificarsiactiono();
}
    public void verificarsiactiono(){
    int clvempactivo = 0;
    String vlrseleccionado = jCBnomempchec.getSelectedItem().toString();
    if("SOLO EMPLEADOS ACTIVOS".equals(vlrseleccionado)){
    try {   
            ResultSet rs = stconclvsempleac.executeQuery();
            int nColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
    for (int i = 1; i <= nColumnas; i ++){
    clvempactivo = (rs.getInt(i));
    obtenerdconchecac(clvempactivo);
      }
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        }
    else {
        obtenerdconchec();
    }    
}
    
    public void validardtschecmod(){
        try{
        String hchecada = txthrchecmod.getText();
        int horachec = Integer.parseInt(hchecada.substring(0, 2));
        int minutochec = Integer.parseInt(hchecada.substring(3, 5));
        int segundochec = Integer.parseInt(hchecada.substring(6, 8));
        if(!txthrchecmod.getText().matches("\\d[0-20-9]:\\d[0-50-9]:\\d[0-50-9]")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(horachec > 23){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "La hora capturada no puede ser mayor que 23, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else if(minutochec > 59){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El minuto capturado no puede ser mayor que 59, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else if(segundochec > 59){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El segundo capturado no puede ser mayor que 59, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else{
            obtenerdtschecmod();
        }
        } catch (NumberFormatException ex){
         Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE); 
      }catch (StringIndexOutOfBoundsException ex){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void limpdtssalida(){
        salida.setText("");
        destroy();
        objetoutil.inicializarCaptura();   
    }
    public void validardtsche(){
      try{
    String nombreempche = jCBempchec.getSelectedItem().toString();
    String hchecada = txthrchec.getText();
        int horachec = Integer.parseInt(hchecada.substring(0, 2));
        int minutochec = Integer.parseInt(hchecada.substring(3, 5));
        int segundochec = Integer.parseInt(hchecada.substring(6, 8));
        if("SELECCIONE UN CAMPO".equals(nombreempche)){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el nombre del empleado","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(!txthrchec.getText().matches("\\d[0-20-9]:\\d[0-50-9]:\\d[0-50-9]")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(horachec > 23){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "La hora capturada no puede ser mayor que 23, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else if(minutochec > 59){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El minuto capturado no puede ser mayor que 59, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else if(segundochec > 59){
              Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El segundo capturado no puede ser mayor que 59, por favor capture la hora en tiempo de 24 horas ","Error",JOptionPane.ERROR_MESSAGE);
          }
        else
            verifsitodosouno();
      } catch (NumberFormatException ex){
         Toolkit.getDefaultToolkit().beep();
         JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE); 
      }catch (StringIndexOutOfBoundsException ex){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor capture la hora en tiempo de 24 horas y con dos dígitos.\nEjemplo: 08:00:00, 21:00:00, etc.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}
    public void verifsitodosouno(){
    String clvempactivo = null;
    String vlrseleccionado = jCBempchec.getSelectedItem().toString();
    String fechachecada = dCCfechchec.getText();
    String horachecada = txthrchec.getText();
    if("SOLO EMPLEADOS ACTIVOS".equals(vlrseleccionado)){
    try {   
            ResultSet rs = stconclvsempleac.executeQuery();
            int nColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
    for (int i = 1; i <= nColumnas; i ++){
    clvempactivo = (rs.getString(i));
    objetoutil.guardarchecactivos(clvempactivo, fechachecada, horachecada);
      }
            }
            if (error == false){
            JOptionPane.showMessageDialog(null,"Las checadas se guardaron con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"ERROR, Las checadas no se pudieron guardar.\n ");
        }
        limpiardtsche();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        jCBempchec.grabFocus();
        }
    else {
        obtenerdtschec();
    }
    }
    
    public void versiseguardaron(boolean vlr){
        error = vlr;        
    }
    
    public void obtenerdtschec(){
       String clvempleado = obtenerclvemp();
       String fechachecada = dCCfechchec.getText();
       String horachecada = txthrchec.getText();
       objetoutil.guardarchec(clvempleado, fechachecada, horachecada);
        jCBempchec.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_comboempchec(); //y vuelves a llamar tu metodo donde llenas el combo 
        jCBempchec.grabFocus();
    }
    
    public void obtenerdtschecmod(){
       String fechachecada = dCCfechchecmod.getText();
       String horachecada = txthrchecmod.getText();
       objetoutil.modificarchec(fechachecada, horachecada, numerochecadax.toString());
       jDmodchecada.setVisible(false);
       mostrarchecadasm();
       //txtcnomempch.grabFocus();
    }
    public void mostrarchecadasm(){
               try {
            limpiartablachec();
            try {   
                    stchecadasmodifi.setString(1,numerochecadax.toString());
                    ResultSet res = stchecadasmodifi.executeQuery();
                    int nColumnas = res.getMetaData().getColumnCount();
                    while (res.next()) {
            for (int i = 1; i <= nColumnas; i++){
            datachecadas[i-1] = (res.getString(i));
              }
            dtmcchec.addRow(datachecadas);
                    }
                } catch (SQLException ex) {
                    Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        } catch (NullPointerException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public String obtenerclvemp(){
    String clav = null;
    String nombreemp = jCBempchec.getSelectedItem().toString();
    try{
    stclaveempleado.setString(1, nombreemp);
            ResultSet res = null;
            res = stclaveempleado.executeQuery();
            while(res.next()){
               clav = res.getString("clave");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
}
    
    public String obtenerclvempchemod(){
    String clav = null;
    String nombreemp = jCBempchecmod.getSelectedItem().toString();
    try{
    stclaveempleado.setString(1, nombreemp);
            ResultSet res = null;
            res = stclaveempleado.executeQuery();
            while(res.next()){
               clav = res.getString("clave");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
}
    //Calcula el sueldo del empleado
    public float calcularpagoemp(int clvem, String tlaboradas, String tipo_sueldo){
        int tipoemp = 0;
        int sueldotipo = 0;
        int horariodeemp = 0;
        float pagoemple = 0;
        float sentrehdehorario = 0;
        String hrsdehorario = "";
        
        try {
            //Consultamos el tipo del empleado de la clave del empleado que recibimos
            stcontipoemp.setInt(1, clvem);
                ResultSet rs = stcontipoemp.executeQuery();
                while (rs.next()) {
                    tipoemp = rs.getInt("tipo_emp");       
                }
                //Consultamos el sueldo del tipo de empleado al que pertenece el empleado con la clave consultada
                stconsueldotipo.setInt(1, tipoemp);
                ResultSet res = stconsueldotipo.executeQuery();
                while (res.next()) {
                    sueldotipo = res.getInt("sueldo_tipo");
                }
                //Consultamos el horario que pertenece al empleado consultado
                    stconhordeemp.setInt(1,clvem);
                    ResultSet resu = stconhordeemp.executeQuery();
                while (resu.next()) {
                    horariodeemp = resu.getInt("horario");
                }
                //Consultamos el total de horas del horario del empleado
                stconhrsdehorario.setInt(1,horariodeemp);
                ResultSet resul = stconhrsdehorario.executeQuery();
                while (resul.next()) {
                    hrsdehorario = resul.getString("thrsdehrio");
                }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //Convertimos el total de horas laboradas del periodo consultado en segundos
        String horalabs = "";
        String minlabs = "";
        String seglabs = "";
        int valor = 0;
        StringTokenizer token = new StringTokenizer(tlaboradas, ":");
                for(int i = 1;token.hasMoreTokens(); i++){
            if (i == 1){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        horalabs = (valor < 10) ?  "0" + valor : String.valueOf(valor);
            }
            else if (i == 2){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        minlabs = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
            else if (i == 3){
        valor = Integer.parseInt(String.valueOf(token.nextToken()));
        seglabs = (valor < 10) ? "0" + valor : String.valueOf(valor);
            }
        }
        int hrasengundosl = (((Integer.parseInt(horalabs)*60)*60)+(Integer.parseInt(minlabs)*60) + Integer.parseInt(seglabs)); 
        
        //Convertimos el total de horas del horario del empleado a segundos
        String horah = "";
        String minh = "";
        String segh = "";
        int valor2 = 0;
        StringTokenizer token2 = new StringTokenizer(hrsdehorario, ":");
                for(int i = 1;token2.hasMoreTokens(); i++){
            if (i == 1){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        horah = (valor2 < 10) ?  "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 2){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        minh = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
            else if (i == 3){
        valor2 = Integer.parseInt(String.valueOf(token2.nextToken()));
        segh = (valor2 < 10) ? "0" + valor2 : String.valueOf(valor2);
            }
        }
        //Horas del horario del empleado convertidas en segundos
        int hrasengundosh = 0; 
        
        if("Quincenal".equals(tipo_sueldo)){
            //El total de horas del horario se convierte a segundos
        hrasengundosh = (((Integer.parseInt(horah)*60)*60)+(Integer.parseInt(minh)*60) + Integer.parseInt(segh))*2;
        }
        else if("Semanal".equals(tipo_sueldo)){
            //El total de horas del horario se convierte a segundos
            hrasengundosh = (((Integer.parseInt(horah)*60)*60)+(Integer.parseInt(minh)*60) + Integer.parseInt(segh));
        }
        else if("Por hora".equals(tipo_sueldo)){
            //El total de horas del horario se convierte a segundos
            hrasengundosh = 3600;
        }
        
        //Dividimos el sueldo del empleado entre los segundos del horario (entre el total de segundos que debe laborar el empleado) para saber cuanto gana por segundo
        sentrehdehorario = ((float)sueldotipo/(float)hrasengundosh);
        //Calculamos el sueldo del empleado multiplicando el total de horas laboradas del periodo consultado convertidas a segundos por la cantidad que gana el empleado por segundo 
        pagoemple = (hrasengundosl * sentrehdehorario);
        return pagoemple;   
    }
    //Calcula las horas laboradas del día, a la hora de salida le resta la hora de entrada
    public String RestarHoras(String horaini,String horafin){
        int horai = 0;
        int mini = 0;
        int segi = 0;
        int horaf = 0;
        int minf = 0;
        int segf = 0;
        DecimalFormat dosDigitos = new DecimalFormat("00"); 
        try{
	horai = Integer.parseInt(horaini.substring(0, 2));
	mini = Integer.parseInt(horaini.substring(3, 5));
	segi = Integer.parseInt(horaini.substring(6));

	horaf = Integer.parseInt(horafin.substring(0, 2));
	minf = Integer.parseInt(horafin.substring(3, 5));
	segf = Integer.parseInt(horafin.substring(6));
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

	int ini=(((horai*60)*60)+(mini*60)+segi);
	int fin=(((horaf*60)*60)+(minf*60)+segf);
	int dif=fin-ini;

	int difh = (dif/3600);
	int difm = ((dif-(difh*3600))/60);
	int difs = dif-(difm*60)-(difh*3600);
        String hrcompuesta = dosDigitos.format(difh)+":"+dosDigitos.format(difm)+":"+dosDigitos.format(difs);

        return hrcompuesta;
}

    //Suma un dia a la fecha recibida
    public static Date sumaDias(Date fecha, int dias){ 
Calendar cal = Calendar.getInstance(); 
cal.setTime(fecha); 
cal.add(Calendar.DAY_OF_YEAR, dias); 
return cal.getTime(); 
} 
    
    public void preguntardelete(String clavebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este empleado?\nTenga en cuenta que también se borraran todas las huellas y las checadas de este empleado");
        if(respuesta == 0)
            borraremp(clavebor); 
    }
    public void preguntareliare(String clavebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar esta area?");
        if(respuesta == 0)
            borrararea(clavebor); 
    }
    public void preguntarelijusti(String clavebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este justificante?");
        if(respuesta == 0)
            borrarjustificante(clavebor); 
    }
    public void preguntarelitipe(String clavebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este tipo de empleado?");
        if(respuesta == 0)
            borrartipoem(clavebor); 
    }
    public void preguntarelihue(String clavebor, String dedocap){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar la huella de este empleado?");
        if(respuesta == 0)
            borrarhuella(clavebor, dedocap); 
    }
    public void preguntareliche(String numerochebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar la checada de este empleado?");
        if(respuesta == 0)
            borrarchecad(numerochebor); 
    }
    public void preguntarelihor(String clavebor){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este horario?");
        if(respuesta == 0)
            borrarhorario(clavebor); 
    }
    
    public void borraremp(String claveb){
        boolean error = false;
            try {
                stdelhueemp.setString(1, claveb);
                stdelhueemp.execute();
                stdelemple.setString(1, claveb);
                stdelemple.execute();
                stdelchecadas.setString(1, claveb);
                stdelchecadas.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, ex.getMessage()); 
            }
        if (error == false){
            limpiartabla();
            txtcnomem.setText("");
            txtcnomem.grabFocus();
            JOptionPane.showMessageDialog(null,"El empleado fue borrado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrararea(String claveb){
        boolean error = false;
            try {
                stdelarea.setString(1, claveb);
                stdelarea.execute();
                //stdelemple.setString(1, claveb);
                //stdelemple.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"No se puede eliminar el área seleccionada ya que esta siendo usada por algún empleado o empleados.\nCambie el área del empleado o empleados que usan esta área","Error",JOptionPane.ERROR_MESSAGE); 
            }
        if (error == false){
            limpiartablaarea();
            txtcnomar.setText("");
            txtcnomar.grabFocus();
            JOptionPane.showMessageDialog(null,"El área de trabajo fue borrado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrarjustificante(String claveb){
        boolean error = false;
            try {
                stdeljustificante.setString(1, claveb);
                stdeljustificante.execute();
                //stdelemple.setString(1, claveb);
                //stdelemple.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"No se puede eliminar el justificante seleccionado","Error",JOptionPane.ERROR_MESSAGE); 
            }
        if (error == false){
            limpiartbljust();
            txtcnomjust.setText("");
            txtcnomjust.grabFocus();
            JOptionPane.showMessageDialog(null,"El justificante fue borrado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrartipoem(String claveb){
        boolean error = false;
            try {
                stdeltipoempe.setString(1, claveb);
                stdeltipoempe.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"No se puede eliminar el tipo de empleado seleccionado ya que esta siendo usado por algún empleado o empleados.\nCambie el tipo de empleado en el empleado o empleados que hacen uso de este tipo","Error",JOptionPane.ERROR_MESSAGE); 
            }
        if (error == false){
            limpiartablatipoem();
            txtcnomtipe.setText("");
            txtcnomtipe.grabFocus();
            JOptionPane.showMessageDialog(null,"El tipo de empleado fue borrado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrarhuella(String claveb, String dedocapt){
        boolean error = false;
            try {
                stdelhue.setString(1, claveb);
                stdelhue.setString(2, dedocapt);
                stdelhue.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
        if (error == false){
            limpiartablahue();
            txtcnomprohue.setText("");
            txtcnomprohue.grabFocus();
            JOptionPane.showMessageDialog(null,"La huella del empleado fue borrada con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrarchecad(String numerocheb){
        boolean error = false;
            try {
                stdelche.setString(1, numerocheb);
                stdelche.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
        if (error == false){
            limpiartablachec();
            //txtcnomempch.setText("");
            //txtcnomempch.grabFocus();
            JOptionPane.showMessageDialog(null,"La checada del empleado fue borrada con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void borrartodaschec(){
        boolean error = false;
            try {
                stdeltodasche.execute();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
        if (error == false)
            JOptionPane.showMessageDialog(null,"Todas las checadas de todos los empleados fueron borradas con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    }
    public void borrarhorario(String claveb){
        boolean error = false;
            try {
                stdelhorario.setString(1, claveb);
                stdelhorario.execute();
                
                jCBhorario.removeAllItems();
                llenar_combohorario();
            } catch (SQLException ex) {
                error = true;
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,"No se puede eliminar el horario seleccionado ya que esta siendo usado por algún empleado o empleados.\nCambie el horario en el empleado o empleados que hacen uso de este horario","Error",JOptionPane.ERROR_MESSAGE); 
            }
        if (error == false){
            limpiartablahor();
            txtcnomhor.setText("");
            txtcnomhor.grabFocus();
            JOptionPane.showMessageDialog(null,"el horario fue borrado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);}
    }
    public void limpiardhuella(){
        jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
             llenar_comboemple(); //y vuelves a llamar tu metodo donde llenas el combo
             fingerprintImage = null;
             crearPanelHuella();
             panelContenedor.repaint();
             jp1.setBackground(null);
             jp2.setBackground(null);
             jp3.setBackground(null);
             jp4.setBackground(null);
             jp5.setBackground(null);
             jp6.setBackground(null);
             grupobotonesop.clearSelection();
             finger = null;
    }
    
    public void Validardatosarea(){
        
        if(txtclavearea.getText().equals("")||
            jtxtnombrearea.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);                  
        }
        else if(!txtclavearea.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave del área de trabajo debe ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
    else obtenerdatosarea();
    }
    public void obtenerdatosarea()
    {
             int claveare = Integer.parseInt(txtclavearea.getText());
             String nombre = jtxtnombrearea.getText();
             objetoutil.guardararea(claveare, nombre);
             jCBarea.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
             llenar_comboarea(); //y vuelves a llamar tu metodo donde llenas el combo
             txtclavearea.grabFocus();
    }
    public void Validardatostipoemp(){
        String valortiposuel = jCBtiposueldo.getSelectedItem().toString();
        if(txtclavetipo.getText().equals("") ||
           txtnombretipo.getText().equals("")||
           txtsueldoem.getText().equals("") ||
           txtsueldoem.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);                  
        }
        else if(!txtclavetipo.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave del tipo de empleado debe ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!txtsueldoem.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"El sueldo del empleado debe ser de tipo numérico y no decimal","Error", JOptionPane.ERROR_MESSAGE);
        }
        else if("SELECCIONE UN CAMPO".equals(valortiposuel)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione un tipo de sueldo","Error",JOptionPane.ERROR_MESSAGE);}
else obtenerdatostipoemp();
    }
    public void obtenerdatostipoemp(){
        int clavetipo = Integer.parseInt(txtclavetipo.getText());
        String nombretem = txtnombretipo.getText();
        String tiposueld = jCBtiposueldo.getSelectedItem().toString();
        int sueldotem = Integer.parseInt(txtsueldoem.getText());
        objetoutil.guardartipoempe(clavetipo, nombretem, tiposueld, sueldotem);
        jCBtipoempleado.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        llenar_combotipo(); //y vuelves a llamar tu metodo donde llenas el combo
        txtclavetipo.grabFocus();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Pantallaprincipal().setVisible(true);
    }
    
    public void IniciarBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
                conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/checador","isaac", "perez");
                sttipo = (PreparedStatement) conexion.prepareStatement("SELECT " + " nombre_tipo " + " FROM tipoempleados ");
                starea = (PreparedStatement) conexion.prepareStatement("SELECT " + " nombre_area " + " FROM area ");
                stclavearea = (PreparedStatement) conexion.prepareStatement("SELECT " + " clave_area " + " FROM area " + " WHERE nombre_area = ?");
                stclavetipo = (PreparedStatement) conexion.prepareStatement("SELECT " + " clave_tipo " + " FROM tipoempleados " + " WHERE nombre_tipo = ?");
                stnombreem = (PreparedStatement) conexion.prepareStatement("SELECT " + " nombre " + " FROM empleados ");
                stclaveempleado = (PreparedStatement) conexion.prepareStatement("SELECT " + " clave " + " FROM empleados " + " WHERE nombre = ?");
                stconclaexis = (PreparedStatement) conexion.prepareStatement("SELECT " + " clave " + " FROM empleados " + " WHERE clave = ?");
                stconcdatmod = (PreparedStatement) conexion.prepareStatement("SELECT " + " nombre, " + " direccion, " + " email, " + " telefono, " + " foto, "  + "area_emp, " + " tipo_emp, " + " horario, " + " estado" + " FROM empleados " + " WHERE clave = ? ");
                buscarfoto   = (PreparedStatement) conexion.prepareStatement("SELECT " + " foto " + " FROM empleados " + " where clave = ? ");
                stareamod = (PreparedStatement) conexion.prepareStatement("SELECT area.nombre_area FROM empleados " + " inner join area on area.clave_area = empleados.area_emp " + " WHERE clave = ?");
                sttipomod = (PreparedStatement) conexion.prepareStatement("SELECT tipoempleados.nombre_tipo FROM empleados " + " inner join tipoempleados on tipoempleados.clave_tipo = empleados.tipo_emp " + " WHERE clave = ?");
                stemplelike = (PreparedStatement) conexion.prepareStatement("SELECT empleados.clave, empleados.nombre, empleados.direccion, empleados.email, empleados.telefono, empleados.foto, area.nombre_area, tipoempleados.nombre_tipo, horarios.nombre_horario, empleados.estado FROM empleados "
                                                                                    + "inner join area on area.clave_area = empleados.area_emp "
                                                                                    + " inner join tipoempleados on tipoempleados.clave_tipo = empleados.tipo_emp "
                                                                                    + " inner join horarios on horarios.clave_horario = empleados.horario "
                                                                                    + " WHERE nombre LIKE ? || nombre LIKE ? || nombre LIKE ? order by clave");
                stdelhue = (PreparedStatement) conexion.prepareStatement("DELETE FROM huellas " + " WHERE id_emp = ? AND dedo_capturado = ?");
                stdelemple = (PreparedStatement) conexion.prepareStatement("DELETE FROM empleados " + " WHERE clave = ?");
                stdelchecadas = (PreparedStatement) conexion.prepareStatement("DELETE FROM checadas " + " WHERE id_empleado = ?");
                stcondtsareamod = (PreparedStatement) conexion.prepareStatement("SELECT nombre_area from area " + " WHERE clave_area = ? ");
                stcondtsjustifimod = (PreparedStatement) conexion.prepareStatement("SELECT nombre_justificante from justificantes " + " WHERE clave_justificante = ? ");
                stdelarea = (PreparedStatement) conexion.prepareStatement("DELETE FROM area " + " WHERE clave_area = ?");
                stdeljustificante = (PreparedStatement) conexion.prepareStatement("DELETE FROM justificantes " + " WHERE clave_justificante = ?");
                sttipoelike = (PreparedStatement) conexion.prepareStatement("SELECT * FROM tipoempleados " + " WHERE nombre_tipo LIKE ? || nombre_tipo LIKE ? || nombre_tipo LIKE ? order by clave_tipo");
                stcondtstipoemod = (PreparedStatement) conexion.prepareStatement("SELECT nombre_tipo, tipo_sueldo, sueldo_tipo from tipoempleados " + " WHERE clave_tipo = ? ");
                sttipoemmod = (PreparedStatement) conexion.prepareStatement("SELECT tipo_sueldo FROM tipoempleados " + " WHERE clave_tipo = ?");
                stdeltipoempe = (PreparedStatement) conexion.prepareStatement("DELETE FROM tipoempleados " + " WHERE clave_tipo = ?");
                sthuellalike = (PreparedStatement) conexion.prepareStatement("SELECT huellas.id_emp, empleados.nombre, huellas.huellap, huellas.dedo_capturado from huellas "
                                                                                    + " inner join empleados on empleados.clave = huellas.id_emp "
                                                                                    + " WHERE nombre like ? || nombre like ? || nombre like ? order by id_emp");
                stnomhorario = (PreparedStatement) conexion.prepareStatement("SELECT " + " nombre_horario " + " FROM horarios ");
                stclavehorario = (PreparedStatement) conexion.prepareStatement("SELECT " + " clave_horario " + " FROM horarios " + " WHERE nombre_horario = ?");
                stconhorario = (PreparedStatement) conexion.prepareStatement("SELECT horarios.nombre_horario FROM empleados " + " inner join horarios on horarios.clave_horario = empleados.horario " + " WHERE clave = ?");
                sthorarioslike = (PreparedStatement) conexion.prepareStatement("SELECT horarios.clave_horario, horarios.nombre_horario, horarios.horaentlun, horarios.horasallun, horarios.horaentmar, horarios.horasalmar, "
                + "horarios.horaentmie, horarios.horasalmie, horarios.horaentjue, horarios.horasaljue, horarios.horaentvie, horarios.horasalvie, horarios.horaentsab, horarios.horasalsab, horarios.horaentdom, horarios.horasaldom, horarios.thrsdehrio,"
                + "horarios.toleraantentdia, horarios.toleradesentdia, horarios.toleraantsaldia, horarios.toleradessaldia from horarios " + " WHERE nombre_horario LIKE ? || nombre_horario LIKE ? || nombre_horario LIKE ? order by clave_horario");
                stdelhorario = (PreparedStatement) conexion.prepareStatement("DELETE FROM horarios " + " WHERE clave_horario = ?");
                stcondtshorariomod = (PreparedStatement) conexion.prepareStatement("SELECT nombre_horario, TIME_FORMAT(horaentdom, '%H:%i'), TIME_FORMAT(horasaldom, '%H:%i'), TIME_FORMAT(horaentlun, '%H:%i'), TIME_FORMAT(horasallun, '%H:%i'), TIME_FORMAT(horaentmar, '%H:%i'), "
                        + "TIME_FORMAT(horasalmar, '%H:%i'), TIME_FORMAT(horaentmie, '%H:%i'), TIME_FORMAT(horasalmie, '%H:%i'), TIME_FORMAT(horaentjue, '%H:%i'), TIME_FORMAT(horasaljue, '%H:%i'), TIME_FORMAT(horaentvie, '%H:%i'), TIME_FORMAT(horasalvie, '%H:%i'), TIME_FORMAT(horaentsab, '%H:%i'), TIME_FORMAT(horasalsab, '%H:%i'), "
                        + "toleraantentdia, toleradesentdia, toleraantsaldia, toleradessaldia from horarios " + " WHERE clave_horario = ? ");
                stcondlaborados = (PreparedStatement) conexion.prepareStatement("SELECT COUNT(fecha_checada) from checadas where fecha_checada = ? and id_empleado = ?");
                stconmaxhrchec  = (PreparedStatement) conexion.prepareStatement("SELECT MAX(checadas.hora_checada) from checadas where fecha_checada = ? and id_empleado = ?");
                stconminhrchec  = (PreparedStatement) conexion.prepareStatement("SELECT MIN(checadas.hora_checada) from checadas where fecha_checada = ? and id_empleado = ?");
                stconhrsdehor = (PreparedStatement) conexion.prepareStatement("SELECT horarios.horaentdom, horarios.horasaldom, horarios.horaentlun, horarios.horasallun, horarios.horaentmar, horarios.horasalmar, horarios.horaentmie, horarios.horasalmie, horarios.horaentjue, horarios.horasaljue, horarios.horaentvie, horarios.horasalvie, horarios.horaentsab, horarios.horasalsab FROM horarios WHERE clave_horario = ?"); 
                stcontipoemp = (PreparedStatement) conexion.prepareStatement("SELECT tipo_emp FROM empleados WHERE clave = ?"); 
                stconsueldotipo = (PreparedStatement) conexion.prepareStatement("SELECT sueldo_tipo FROM tipoempleados WHERE clave_tipo = ?");
                stconhordeemp = (PreparedStatement) conexion.prepareStatement("SELECT horario FROM empleados WHERE clave = ?");
                stconhrsdehorario = (PreparedStatement) conexion.prepareStatement("SELECT thrsdehrio FROM horarios WHERE clave_horario = ?");
                stcontiposueldo = (PreparedStatement) conexion.prepareStatement("SELECT tipo_sueldo FROM tipoempleados WHERE clave_tipo = ?");
                stconsueldoemp = (PreparedStatement) conexion.prepareStatement("SELECT sueldo_tipo FROM tipoempleados WHERE clave_tipo = ?");
                stconhorclvcero = (PreparedStatement) conexion.prepareStatement( "SELECT clave_horario FROM horarios WHERE clave_horario = 0");
                stcontipsuel = (PreparedStatement) conexion.prepareStatement("SELECT tipo_sueldo FROM tipoempleados WHERE  nombre_tipo = ?");
                stconclvhorario = (PreparedStatement) conexion.prepareStatement("SELECT clave_horario FROM horarios WHERE nombre_horario = ?");
                stconclvadmin = (PreparedStatement) conexion.prepareStatement("SELECT claveadmin FROM administrador");
                stconpagohrext = (PreparedStatement) conexion.prepareStatement("SELECT pagohrextra FROM horaextra");
                stconindicio = (PreparedStatement) conexion.prepareStatement("SELECT indicio FROM administrador");
                stconestado = (PreparedStatement) conexion.prepareStatement("SELECT estado FROM empleados WHERE clave = ?");
                stconclvsempleac = (PreparedStatement) conexion.prepareStatement("SELECT clave FROM empleados WHERE estado = 'ACTIVO'");
                stchecadas = (PreparedStatement) conexion.prepareStatement("select checadas.id_empleado, empleados.nombre, checadas.fecha_checada, checadas.hora_checada, checadas.numerochecada from checadas "
                                                                            + "inner join empleados on empleados.clave = checadas.id_empleado "
                                                                            + "where id_empleado = ? and fecha_checada between ? and ? order by id_empleado, fecha_checada, hora_checada");
                stdeltodasche = (PreparedStatement) conexion.prepareStatement("TRUNCATE TABLE checadas");
                stcondtshuemod = (PreparedStatement) conexion.prepareStatement("SELECT id_emp, dedo_capturado from huellas " + " WHERE id_emp = ? and dedo_capturado = ?");
                stnombreempleado = (PreparedStatement) conexion.prepareStatement("SELECT nombre from empleados WHERE clave = ?");
                stconexisdedo = (PreparedStatement) conexion.prepareStatement("select id_emp, dedo_capturado from huellas where id_emp = ? and dedo_capturado = ?");
                stconchecmod = (PreparedStatement) conexion.prepareStatement("select id_empleado, fecha_checada, hora_checada from checadas where id_empleado = ? and numerochecada = ?");
                stdelche = (PreparedStatement) conexion.prepareStatement("DELETE FROM checadas " + " WHERE numerochecada = ?");
                starealike = (PreparedStatement) conexion.prepareStatement("SELECT * FROM area WHERE nombre_area LIKE ? || nombre_area LIKE ? || nombre_area LIKE ? order by clave_area");
                stjustifilike = (PreparedStatement) conexion.prepareStatement("SELECT * FROM justificantes WHERE nombre_justificante LIKE ? || nombre_justificante LIKE ? || nombre_justificante LIKE ? order by clave_justificante");
                stemplemodificado = (PreparedStatement) conexion.prepareStatement("SELECT empleados.clave, empleados.nombre, empleados.direccion, empleados.email, empleados.telefono, empleados.foto, area.nombre_area, tipoempleados.nombre_tipo, horarios.nombre_horario, empleados.estado FROM empleados "
                                                                                    + "inner join area on area.clave_area = empleados.area_emp "
                                                                                    + " inner join tipoempleados on tipoempleados.clave_tipo = empleados.tipo_emp "
                                                                                    + " inner join horarios on horarios.clave_horario = empleados.horario "
                                                                                    + " WHERE clave = ?");
                stareamodificada = (PreparedStatement) conexion.prepareStatement("SELECT * FROM area WHERE clave_area = ?");
                stjustimodificado = (PreparedStatement) conexion.prepareStatement("SELECT * FROM justificantes WHERE clave_justificante = ?");
                sttipomodificado = (PreparedStatement) conexion.prepareStatement("SELECT * FROM tipoempleados " + " WHERE clave_tipo = ?");
                sthorariomodifi = (PreparedStatement) conexion.prepareStatement("SELECT horarios.clave_horario, horarios.nombre_horario, horarios.horaentlun, horarios.horasallun, horarios.horaentmar, "
                        + "horarios.horasalmar, horarios.horaentmie, horarios.horasalmie, horarios.horaentjue, horarios.horasaljue, horarios.horaentvie, horarios.horasalvie, horarios.horaentsab, "
                        + "horarios.horasalsab, horarios.horaentdom, horarios.horasaldom, horarios.thrsdehrio, horarios.toleraantentdia, toleradesentdia, toleraantsaldia, toleradessaldia from horarios " + " WHERE clave_horario = ?");
                sthuellamodifi = (PreparedStatement) conexion.prepareStatement("SELECT huellas.id_emp, empleados.nombre, huellas.huellap, huellas.dedo_capturado from huellas "
                                                                                    + " inner join empleados on empleados.clave = huellas.id_emp "
                                                                                    + " WHERE id_emp = ? and dedo_capturado = ?");
                stchecadasmodifi = (PreparedStatement) conexion.prepareStatement("SELECT checadas.id_empleado, empleados.nombre, checadas.fecha_checada, checadas.hora_checada, checadas.numerochecada from checadas "
                                                                                    + " inner join empleados on empleados.clave = checadas.id_empleado "
                                                                                    + " WHERE numerochecada = ?");
                stdelhueemp = (PreparedStatement) conexion.prepareStatement("DELETE FROM huellas " + " WHERE id_emp = ?");
                stasistencia = (PreparedStatement) conexion.prepareStatement("select empleados.clave, empleados.nombre, checadas.fecha_checada, min(checadas.hora_checada), max(checadas.hora_checada) from empleados inner join checadas on empleados.clave = checadas.id_empleado where fecha_checada = ? and empleados.clave = ?");
                stnombredia = (PreparedStatement) conexion.prepareStatement("select distinct dayname(?) from checadas");
                stconhrentlun = (PreparedStatement) conexion.prepareStatement("select horaentlun from horarios where clave_horario = ?");
                stconhrentmar = (PreparedStatement) conexion.prepareStatement("select horaentmar from horarios where clave_horario = ?");
                stconhrentmie = (PreparedStatement) conexion.prepareStatement("select horaentmie from horarios where clave_horario = ?");
                stconhrentjue = (PreparedStatement) conexion.prepareStatement("select horaentjue from horarios where clave_horario = ?");
                stconhrentvie = (PreparedStatement) conexion.prepareStatement("select horaentvie from horarios where clave_horario = ?");
                stconhrentsab = (PreparedStatement) conexion.prepareStatement("select horaentsab from horarios where clave_horario = ?");
                stconhrentdom = (PreparedStatement) conexion.prepareStatement("select horaentdom from horarios where clave_horario = ?");
                
                stconhrsallun = (PreparedStatement) conexion.prepareStatement("select horasallun from horarios where clave_horario = ?");
                stconhrsalmar = (PreparedStatement) conexion.prepareStatement("select horasalmar from horarios where clave_horario = ?");
                stconhrsalmie = (PreparedStatement) conexion.prepareStatement("select horasalmie from horarios where clave_horario = ?");
                stconhrsaljue = (PreparedStatement) conexion.prepareStatement("select horasaljue from horarios where clave_horario = ?");
                stconhrsalvie = (PreparedStatement) conexion.prepareStatement("select horasalvie from horarios where clave_horario = ?");
                stconhrsalsab = (PreparedStatement) conexion.prepareStatement("select horasalsab from horarios where clave_horario = ?");
                stconhrsaldom = (PreparedStatement) conexion.prepareStatement("select horasaldom from horarios where clave_horario = ?");
                
                stconmtstoldesent = (PreparedStatement) conexion.prepareStatement("select toleradesentdia from horarios where clave_horario = ?");
                stconminhrchasis  = (PreparedStatement) conexion.prepareStatement("SELECT TIME_FORMAT(MIN(checadas.hora_checada),'%H:%i') from checadas where fecha_checada = ? and id_empleado = ?");
                
                stconmtstolantsal = (PreparedStatement) conexion.prepareStatement("select toleraantsaldia from horarios where clave_horario = ?");
                stconmaxhrchasis  = (PreparedStatement) conexion.prepareStatement("SELECT TIME_FORMAT(MAX(checadas.hora_checada),'%H:%i') from checadas where fecha_checada = ? and id_empleado = ?");
                stcontolantent = (PreparedStatement) conexion.prepareStatement("select toleraantentdia from horarios where clave_horario = ?");
                stcontoldessal = (PreparedStatement) conexion.prepareStatement("select toleradessaldia from horarios where clave_horario = ?");
                stconpagohrext = (PreparedStatement) conexion.prepareStatement("select pagohrextra from horaextra");
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_combotipo() {
        try {
            
            ResultSet rs = sttipo.executeQuery();
            modeloCombotipo.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            jCBtipoempleado.setModel(modeloCombotipo);//con esto lo agregamos al objeto al jcombobox
            while (rs.next()) {
                modeloCombotipo.addElement(rs.getObject("nombre_tipo"));
                jCBtipoempleado.setModel(modeloCombotipo);
            }
 
           // sttipo.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_combotipomod(String clavm) {
        jCBtipoempleadomod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        String nombretipoe = null;
        try {
            sttipomod.setString(1, clavm);
            ResultSet rs = sttipomod.executeQuery();
            while (rs.next()) {
                modeloCombotipomod.addElement(rs.getObject("nombre_tipo"));
                jCBtipoempleadomod.setModel(modeloCombotipomod);
                nombretipoe = rs.getString("nombre_tipo");
            }
            ResultSet res = sttipo.executeQuery();
            String addtipomode;
            while (res.next()) {
            addtipomode = res.getString("nombre_tipo");
            if(!nombretipoe.equals(addtipomode)){
            modeloCombotipomod.addElement(addtipomode);
            jCBtipoempleadomod.setModel(modeloCombotipomod);}                  
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_combohorariomod(String clavh) {
        jCBhorariomod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        String nombrehorario = null;
        try {
            stconhorario.setString(1, clavh);
            ResultSet rs = stconhorario.executeQuery();
            while (rs.next()) {
                modeloCombohorariomod.addElement(rs.getObject("nombre_horario"));
                jCBhorariomod.setModel(modeloCombohorariomod);
                nombrehorario = rs.getString("nombre_horario");
            }
            
            ResultSet res = stnomhorario.executeQuery();
            String addnomhorario;
            while (res.next()) {
            addnomhorario = res.getString("nombre_horario");
            if(!nombrehorario.equals(addnomhorario)){
            modeloCombohorariomod.addElement(addnomhorario);
            jCBhorariomod.setModel(modeloCombohorariomod);}                  
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void llenar_comboestadomod(String clavh) {
        jCBestadomod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        String estadobd = null;
        try {
            stconestado.setString(1, clavh);
            ResultSet rs = stconestado.executeQuery();
            while (rs.next()) {
                estadobd= rs.getString("estado");
                modeloComboestadomod.addElement(estadobd);
                jCBestadomod.setModel(modeloComboestadomod);
            }
            if ("ACTIVO".equals(estadobd)){
                modeloComboestadomod.addElement("INACTIVO");
                jCBestadomod.setModel(modeloComboestadomod);
            }
            else if ("INACTIVO".equals(estadobd)){
                modeloComboestadomod.addElement("ACTIVO");
                jCBestadomod.setModel(modeloComboestadomod);
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void llenar_comboarea(){
        try {
            
            ResultSet rs = starea.executeQuery();
            modeloComboare.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            jCBarea.setModel(modeloComboare);//con esto lo agregamos al objeto al jcombobox
            while (rs.next()) {
                modeloComboare.addElement(rs.getObject("nombre_area"));
                jCBarea.setModel(modeloComboare);
            }
 
            //starea.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
      public void llenar_combohorario(){
        try {
            
            ResultSet rs = stnomhorario.executeQuery();
            modeloCombohorario.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            jCBhorario.setModel(modeloCombohorario);//con esto lo agregamos al objeto al jcombobox
            while (rs.next()) {
                modeloCombohorario.addElement(rs.getObject("nombre_horario"));
                jCBhorario.setModel(modeloCombohorario);
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_comboareamod(String claveep){
        jCBareamod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        String nombreareae = null;
        try {
            stareamod.setString(1, claveep);
            ResultSet rs = stareamod.executeQuery();
            while (rs.next()) {
                modeloComboaremod.addElement(rs.getObject("nombre_area"));
                jCBareamod.setModel(modeloComboaremod);
                nombreareae = rs.getString("nombre_area");
            }
            ResultSet res = starea.executeQuery();
            String addareamode;
            while (res.next()) {
                addareamode = res.getString("nombre_area");
                if(!nombreareae.equals(addareamode)){
                modeloComboaremod.addElement(addareamode);
                jCBareamod.setModel(modeloComboaremod);}                  
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
        public void llenar_combonomhuemod(String claveep){
        jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        try {
            stnombreempleado.setString(1, claveep);
            ResultSet rs = stnombreempleado.executeQuery();
            while (rs.next()) {
                modeloCombohuemod.addElement(rs.getObject("nombre"));
                jCBemplebd.setModel(modeloCombohuemod);
            }

        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
        public void llenar_combonomchemod(String claveep){
        jCBempchecmod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        try {
            stnombreempleado.setString(1, claveep);
            ResultSet rs = stnombreempleado.executeQuery();
            while (rs.next()) {
                modeloCombochemod.addElement(rs.getObject("nombre"));
                jCBempchecmod.setModel(modeloCombochemod);
            }

        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
        public void llenar_combotipemod(String claveep){
        jCBtiposueldomod.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
        String tiposueldo = null;
        try {
            sttipoemmod.setString(1, claveep);
            ResultSet rs = sttipoemmod.executeQuery();
            while (rs.next()) {
                tiposueldo= rs.getString("tipo_sueldo");
                modeloCombotipemod.addElement(tiposueldo);
                jCBtiposueldomod.setModel(modeloCombotipemod);
            }
            if ("Semanal".equals(tiposueldo)){
                modeloCombotipemod.addElement("Quincenal");
                modeloCombotipemod.addElement("Por hora");
                jCBtiposueldomod.setModel(modeloCombotipemod);
            }
            else if ("Quincenal".equals(tiposueldo)){
                modeloCombotipemod.addElement("Semanal");
                modeloCombotipemod.addElement("Por hora");
                jCBtiposueldomod.setModel(modeloCombotipemod);
            }
            else if("Por hora".equals(tiposueldo)){
             modeloCombotipemod.addElement("Semanal");
             modeloCombotipemod.addElement("Quincenal");
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_comboemple(){
        try {
            
            ResultSet rs = stnombreem.executeQuery();
            modeloCombonem.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            jCBemplebd.setModel(modeloCombonem);//con esto lo agregamos al objeto jcombobox
            while (rs.next()) {
                modeloCombonem.addElement(rs.getObject("nombre"));
                jCBemplebd.setModel(modeloCombonem);
            }
 
            //starea.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_comboempnom(){
        try {
            
            ResultSet rs = stnombreem.executeQuery();
            modeloCombonemnom.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            modeloCombonemnom.addElement("SOLO EMPLEADOS ACTIVOS");
            jCBempleadosnom.setModel(modeloCombonemnom);//con esto lo agregamos al objeto jcombobox
            while (rs.next()) {
                modeloCombonemnom.addElement(rs.getObject("nombre"));
                jCBempleadosnom.setModel(modeloCombonemnom);
            }
 
            //starea.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void llenar_cempconche(){
        try {
            
            ResultSet rs = stnombreem.executeQuery();
            modeloCombonemcch.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            modeloCombonemcch.addElement("SOLO EMPLEADOS ACTIVOS");
            jCBnomempchec.setModel(modeloCombonemcch);//con esto lo agregamos al objeto jcombobox
            while (rs.next()) {
                modeloCombonemcch.addElement(rs.getObject("nombre"));
                jCBnomempchec.setModel(modeloCombonemcch);
            }
 
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void llenar_comboempchec(){
        try {
            
            ResultSet rs = stnombreem.executeQuery();
            modeloCombonemche.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            modeloCombonemche.addElement("SOLO EMPLEADOS ACTIVOS");
            jCBempchec.setModel(modeloCombonemche);//con esto lo agregamos al objeto jcombobox
            while (rs.next()) {
                modeloCombonemche.addElement(rs.getObject("nombre"));
                jCBempchec.setModel(modeloCombonemche);
            }
 
            //starea.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
        public void llenar_comboasis(){
        try {
            
            ResultSet rs = stnombreem.executeQuery();
            modeloComboasis.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
            modeloComboasis.addElement("SOLO EMPLEADOS ACTIVOS");
            jCBempleadosasis.setModel(modeloComboasis);//con esto lo agregamos al objeto jcombobox
            while (rs.next()) {
                modeloComboasis.addElement(rs.getObject("nombre"));
                jCBempleadosasis.setModel(modeloComboasis);
            }
 
            //starea.close();
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public void llenar_comboestado(){
     modeloComboestado.addElement("SELECCIONE UN CAMPO");
     modeloComboestado.addElement("ACTIVO");
     modeloComboestado.addElement("INACTIVO");
     jCBestado.setModel(modeloComboestado);
    }
    public void llenar_combotiposuel(){
        modeloCombotiposuel.addElement("SELECCIONE UN CAMPO");//es el primer registro q mostrara el combo
        modeloCombotiposuel.addElement("Semanal");
        modeloCombotiposuel.addElement("Quincenal");
        modeloCombotiposuel.addElement("Por hora");
        jCBtiposueldo.setModel(modeloCombotiposuel);//con esto lo agregamos al objeto jcombobox
    }
    public void Validardatosemp(){
        String valorarea = jCBarea.getSelectedItem().toString();
        String valortipo = jCBtipoempleado.getSelectedItem().toString();
        String valorhorario = jCBhorario.getSelectedItem().toString();
        String valorestado = jCBestado.getSelectedItem().toString();
        if(txtclaveem.getText().equals("") ||
           txtnombre_emp.getText().equals("") ||
           txtdireccion_emp.getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos marcados con asterisco","Error",JOptionPane.ERROR_MESSAGE);}
        else if(!txtclaveem.getText().matches("\\d+")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"La clave del empleado debe ser de tipo numérico","Error", JOptionPane.ERROR_MESSAGE);
        }    
        else if("SELECCIONE UN CAMPO".equals(valorarea)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione un área de trabajo","Error",JOptionPane.ERROR_MESSAGE);}
        else if("SELECCIONE UN CAMPO".equals(valortipo)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione un tipo de empleado","Error",JOptionPane.ERROR_MESSAGE);}
        else if("SELECCIONE UN CAMPO".equals(valorhorario)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione un horario","Error",JOptionPane.ERROR_MESSAGE);}
        else if("SELECCIONE UN CAMPO".equals(valorestado)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione un estado","Error",JOptionPane.ERROR_MESSAGE);}
   else obtenerdatosEmpleados();
    }
    
    public void coincidehuella(boolean valor){
        coincidehuella = valor;
    }
    
    public void Validardtshu(){
        String claveemp = obtenerclem();
        try{
        stconexisdedo.setString(1,claveemp);
        stconexisdedo.setString(2,finger);
        ResultSet res = null;
        res = stconexisdedo.executeQuery();
        String valorjcbn = jCBemplebd.getSelectedItem().toString();
        if("SELECCIONE UN CAMPO".equals(valorjcbn)){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el nombre del propietario de la huella","Error",JOptionPane.ERROR_MESSAGE);}
        
        else if(finger == null){
           Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"Por favor seleccione el dedo que desea capturar","Error",JOptionPane.ERROR_MESSAGE);}
            
        else if(fingerprintImage == null){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,"No hay ninguna huella capturada, por favor capture una","Error",JOptionPane.ERROR_MESSAGE);}
         
        else if (res.next()){
               Toolkit.getDefaultToolkit().beep();
               JOptionPane.showMessageDialog(null,"El dedo seleccionado ya ha sido registrado, por favor seleccione otro","Error",JOptionPane.ERROR_MESSAGE);
                       }
        else if(coincidehuella == true){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Esta huella ya ha sido registrada, \nsolo puede ser capturada una huella por cada dedo, \npor favor intente con otra.", "Error", JOptionPane.ERROR_MESSAGE);    
        }
            else{
                objetoutil.guardarhuella(claveemp, finger);
        }
        }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
        jCBemplebd.grabFocus();
    }
    
    public String obtenerclem(){
        String clav = null;
    String nombreemp = jCBemplebd.getSelectedItem().toString();
    try{
    stclaveempleado.setString(1, nombreemp);
            ResultSet res = null;
            res = stclaveempleado.executeQuery();
            while(res.next()){
               clav = res.getString("clave");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
    }
    
    public void obtenerdatosEmpleados()
    {
        try {     
                 int claveempe = Integer.parseInt(txtclaveem.getText());
                 String nombreempe = txtnombre_emp.getText();
                 String direccionempe = txtdireccion_emp.getText();
                 String emailempe = txtemail_emp.getText();
                 String telefonoempe = txttelefono_emp.getText();
                 String claveareaempe = obtenerareaempleado();
                 String clavetipoempe = obtenertipoempleado();
                 String clavehorario = obtenerhorario();
                 String valorestado = jCBestado.getSelectedItem().toString();
                 
                 if (txtfoto.getText().equals("")){
                 objetoutil.guardardtsempesinfoto(claveempe, nombreempe, direccionempe, emailempe, telefonoempe, claveareaempe, clavetipoempe, null, clavehorario, valorestado);
                jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboemple(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosnom.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboempnom(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempchec.removeAllItems();
                llenar_comboempchec();
                jCBempleadosasis.removeAllItems();
                llenar_comboasis();
                jCBnomempchec.removeAllItems();
                llenar_cempconche();
                 }
                 else{
                     FileInputStream archivoFoto;
                     File nombreFoto;
                     nombreFoto= new File(txtfoto.getText());
                     archivoFoto=new FileInputStream(nombreFoto);
                     objetoutil.guardardtsempeconfoto(claveempe, nombreempe, direccionempe, emailempe, telefonoempe, claveareaempe, clavetipoempe, archivoFoto, clavehorario, valorestado);
                jCBemplebd.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboemple(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempleadosnom.removeAllItems();//con esto limpias el combo o remueves todo lo que tiene actualmente
                llenar_comboempnom(); //y vuelves a llamar tu metodo donde llenas el combo
                jCBempchec.removeAllItems();
                llenar_comboempchec();
                jCBempleadosasis.removeAllItems();
                llenar_comboasis();
                jCBnomempchec.removeAllItems();
                llenar_cempconche();
                 }
        } catch (FileNotFoundException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        txtclaveem.grabFocus();
    }
     public String obtenerareaempleado(){
    String clav = null;
    String areadeemp = jCBarea.getSelectedItem().toString();
    try{
    stclavearea.setString(1, areadeemp);
            ResultSet res = null;
            res = stclavearea.executeQuery();
            while(res.next()){
               clav = res.getString("clave_area");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clav;
}
     public String obtenertipoempleado(){
         String tip = null;
    String tipodeemp = jCBtipoempleado.getSelectedItem().toString();
    try{
    stclavetipo.setString(1, tipodeemp);
            ResultSet res = null;
            res = stclavetipo.executeQuery();
            while(res.next()){
               tip = res.getString("clave_tipo");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return tip;
     }
     public String obtenerhorario(){
         String clavehor = null;
    String nombrehorario = jCBhorario.getSelectedItem().toString();
    try{
    stclavehorario.setString(1, nombrehorario);
            ResultSet res = null;
            res = stclavehorario.executeQuery();
            while(res.next()){
               clavehor = res.getString("clave_horario");
                       }
            }
        catch(SQLException e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
    return clavehor;
     }
/**
    * Frees Fingerprint SDK resources and finished the program.
    */
   public void destroy() {
       objetoutil.destroy();
   }
   
   public class Imprimirpaginas implements Printable{
       //Se obtienen las lineas de texto del JTextArea, la linea de texto finaliza cuando se encuentra el caracter de nueva linea \n
       StringTokenizer lineasdetexto = new StringTokenizer(resultconnom.getText(), "\n", true);
       //Se obtiene el total de lineas de texto
       int totallineas = lineasdetexto.countTokens();

    int[] paginas;  // Arreglo de número de paginas que se necesitaran para imprimir todo el texto 

    String[] textoLineas; //Lineas de texto que se imprimiran en cada hoja

    //Metodo que se crea por default cuando una clase implementa a Printable
    public int print(Graphics g, PageFormat pf, int pageIndex)
             throws PrinterException {
        //Se establece la fuente, el tipo, el tamaño, la metrica según la fuente asignada, 
        //obtiene la altura de cada linea de texto para que todas queden iguales
        Font font = new Font("Serif", Font.PLAIN, 6);
        FontMetrics metrics = g.getFontMetrics(font);
        int altodelinea = metrics.getHeight();
        //Calcula el número de lineas por pagina y el total de paginas
        if (paginas == null) {
            initTextoLineas();
            //Calcula las lineas que le caben a cada página dividiendo la altura imprimible entre la altura de la linea de texto
            int lineasPorPagina = (int)(pf.getImageableHeight()/altodelinea);
            //Calcula el numero de páginas dividiendo el total de lineas entre el numero de lineas por página
            int numeroPaginas = (textoLineas.length-1)/lineasPorPagina;
            paginas = new int[numeroPaginas];
            for (int b=0; b<numeroPaginas; b++) {
                paginas[b] = (b+1)*lineasPorPagina; 
            }
        }
        //Si se recibe un indice de página mayor que el total de páginas calculadas entonces 
        //retorna NO_SUCH_PAGE para indicar que tal pagina no existe 
        if (pageIndex > paginas.length) {
            return NO_SUCH_PAGE;
        }
        /*Por lo regular cuando dibujamos algun objeto lo coloca en la coordenada (0,0), esta coordenada 
         * se encuentra fuera del área imprimible, por tal motivo se debe trasladar la posicion de las lineas de texto
         * según el área imprimible del eje X y el eje Y 
         */
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /*Dibujamos cada línea de texto en cada página,
         * se aumenta a la posición 'y' la altura de la línea a cada línea de texto para evitar la saturación de texto 
         */

        int y = 0; 
        int start = (pageIndex == 0) ? 0 : paginas[pageIndex-1];
        int end   = (pageIndex == paginas.length) ? textoLineas.length : paginas[pageIndex];
        for (int line=start; line<end; line++) {
            y += altodelinea;
            g.drawString(textoLineas[line], 0, y);
        }
        /* Retorna PAGE_EXISTS para indicar al invocador que esta página es parte del documento impreso
         */
        return PAGE_EXISTS;
    }
    
     /* Agrega las lineas de texto al arreglo */
    public void initTextoLineas() {
        if (textoLineas == null) {
            int numLineas=totallineas;
            textoLineas = new String[numLineas];
            //Se llena el arreglo que contiene todas las lineas de texto
            while(lineasdetexto.hasMoreTokens()){
            for (int i=0;i<numLineas;i++) {
                textoLineas[i] = lineasdetexto.nextToken();
            }
            }
        }
    }
    
    //Este metodo crea un objeto Printerjob el cual es inicializado y asociado con la impresora por default
    public void imprimirnomina() {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         //Si el usuario presiona imprimir en el dialogo de impresión, 
         //entonces intenta imprimir todas las lineas de texto
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
}
           public class FilePreviewer extends JComponent implements
            PropertyChangeListener {

        ImageIcon thumbnail = null;

        @SuppressWarnings("LeakingThisInConstructor")
        public FilePreviewer(JFileChooser fc) {
            setPreferredSize(new Dimension(100, 50));
            fc.addPropertyChangeListener(this);
        }

        public void loadImage(File f) {
            if (f == null) {
                thumbnail = null;
            } else {
                ImageIcon tmpIcon = new ImageIcon(f.getPath());
                if (tmpIcon.getIconWidth() > 90) {
                    thumbnail = new ImageIcon(
                            tmpIcon.getImage().getScaledInstance(90, -1,
                            Image.SCALE_DEFAULT));
                } else {
                    thumbnail = tmpIcon;
                }
            }
        }

        public void propertyChange(PropertyChangeEvent e) {
            String prop = e.getPropertyName();
            if (SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
                if (isShowing()) {
                    loadImage((File) e.getNewValue());
                    repaint();
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            if (thumbnail != null) {
                int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
                int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;
                if (y < 0) {
                    y = 0;
                }

                if (x < 5) {
                    x = 5;
                }
                thumbnail.paintIcon(this, g, x, y);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonesopcion;
    private javax.swing.JButton btnGuardararea;
    private javax.swing.JButton btnGuardarareamod;
    private javax.swing.JButton btnLimpiararea;
    private javax.swing.JButton btnaceptarclv;
    private javax.swing.JButton btnaceptarclvdelc;
    private javax.swing.JButton btncalcularnom;
    private javax.swing.JButton btncancelarclv;
    private javax.swing.JButton btncancelarclvdelc;
    private javax.swing.JButton btncargarfoto;
    private javax.swing.JButton btncargarfotomod;
    private javax.swing.JButton btnconsultalhor;
    private javax.swing.JButton btnconsultalimar;
    private javax.swing.JButton btnconsultalimjus;
    private javax.swing.JButton btnconsultalne;
    private javax.swing.JButton btnconsultarasis;
    private javax.swing.JButton btnguarcontra;
    private javax.swing.JButton btnguardarche;
    private javax.swing.JButton btnguardarchemod;
    private javax.swing.JButton btnguardardatosemp;
    private javax.swing.JButton btnguardardatosempmod;
    private javax.swing.JButton btnguardardedu;
    private javax.swing.JButton btnguardarhor;
    private javax.swing.JButton btnguardarhormod;
    private javax.swing.JButton btnguardartipo;
    private javax.swing.JButton btnguardartipomod;
    private javax.swing.JButton btnimprimirnom;
    private javax.swing.JButton btnlimpdtscontra;
    private javax.swing.JButton btnlimpiarareac;
    private javax.swing.JButton btnlimpiarareachor;
    private javax.swing.JButton btnlimpiarareacte;
    private javax.swing.JButton btnlimpiarche;
    private javax.swing.JButton btnlimpiarcona;
    private javax.swing.JButton btnlimpiardatosemp;
    private javax.swing.JButton btnlimpiardtsdedu;
    private javax.swing.JButton btnlimpiarhor;
    private javax.swing.JButton btnlimpiarnomtipe;
    private javax.swing.JButton btnlimpiarnprohue;
    private javax.swing.JButton btnlimpiarpnomche;
    private javax.swing.JButton btnlimpiarresas;
    private javax.swing.JButton btnlimpiarresulasis;
    private javax.swing.JButton btnlimpiartablaar;
    private javax.swing.JButton btnlimpiartablajus;
    private javax.swing.JButton btnlimpiartipo;
    private javax.swing.JButton btnlimptabcche;
    private javax.swing.JButton btnlimptabprohue;
    private javax.swing.JButton btnrestaurarminstol;
    private javax.swing.JButton btnrestaurarminstolmod;
    private datechooser.beans.DateChooserCombo dCCfechchec;
    private datechooser.beans.DateChooserCombo dCCfechchecmod;
    private datechooser.beans.DateChooserCombo dCfechafin;
    private datechooser.beans.DateChooserCombo dCfechafinasis;
    private datechooser.beans.DateChooserCombo dCfechafinche;
    private datechooser.beans.DateChooserCombo dCfechainiasis;
    private datechooser.beans.DateChooserCombo dCfechainicio;
    private datechooser.beans.DateChooserCombo dCfechainicioche;
    private javax.swing.ButtonGroup grupobotonesop;
    private javax.swing.JButton jBguardarhu;
    private javax.swing.JButton jBlimpiarconnom;
    private javax.swing.JButton jBlimpiardtsaltajus;
    private javax.swing.JButton jBlimpiarhu;
    private javax.swing.JButton jBlimpiarresulnom;
    private javax.swing.JButton jBlimpiarsalida;
    private javax.swing.JButton jBtguardarjusti;
    private javax.swing.JButton jBtmodificarjusti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jCBarea;
    private javax.swing.JComboBox jCBareamod;
    private javax.swing.JComboBox jCBempchec;
    private javax.swing.JComboBox jCBempchecmod;
    private javax.swing.JComboBox jCBempleadosasis;
    private javax.swing.JComboBox jCBempleadosnom;
    private javax.swing.JComboBox jCBemplebd;
    private javax.swing.JComboBox jCBestado;
    private javax.swing.JComboBox jCBestadomod;
    private javax.swing.JComboBox jCBhorario;
    private javax.swing.JComboBox jCBhorariomod;
    private javax.swing.JComboBox jCBnomempchec;
    private javax.swing.JComboBox jCBtipoempleado;
    private javax.swing.JComboBox jCBtipoempleadomod;
    private javax.swing.JComboBox jCBtiposueldo;
    private javax.swing.JComboBox jCBtiposueldomod;
    private javax.swing.JDialog jDactcontraseña;
    private javax.swing.JDialog jDaltaarea;
    private javax.swing.JDialog jDaltachecada;
    private javax.swing.JDialog jDaltaempleado;
    private javax.swing.JDialog jDaltahorario;
    private javax.swing.JDialog jDaltahue;
    private javax.swing.JDialog jDaltajustificante;
    private javax.swing.JDialog jDaltatipoempleado;
    private javax.swing.JDialog jDasistencia;
    private javax.swing.JDialog jDcalculonomina;
    private javax.swing.JDialog jDcapactdedugral;
    private javax.swing.JDialog jDconsultaar;
    private javax.swing.JDialog jDconsultachec;
    private javax.swing.JDialog jDconsultaem;
    private javax.swing.JDialog jDconsultahor;
    private javax.swing.JDialog jDconsultahue;
    private javax.swing.JDialog jDconsultajust;
    private javax.swing.JDialog jDconsultatipe;
    private javax.swing.JDialog jDhoraextra;
    private javax.swing.JDialog jDmodchecada;
    private javax.swing.JDialog jDmodhorario;
    private javax.swing.JDialog jDmodificarare;
    private javax.swing.JDialog jDmodificarem;
    private javax.swing.JDialog jDmodificartipoe;
    private javax.swing.JDialog jDmodjustificante;
    private javax.swing.JDialog jDpclvdelche;
    private javax.swing.JDialog jDpedirclave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMAdministrador;
    private javax.swing.JMenuItem jMIaltaarea;
    private javax.swing.JMenuItem jMIaltache;
    private javax.swing.JMenuItem jMIaltaem;
    private javax.swing.JMenuItem jMIaltahue;
    private javax.swing.JMenuItem jMIaltatipoempleado;
    private javax.swing.JMenuItem jMIconelimche;
    private javax.swing.JMenuItem jMIconsultaare;
    private javax.swing.JMenuItem jMIconsultaem;
    private javax.swing.JMenuItem jMIconsultarhor;
    private javax.swing.JMenuItem jMIconsultatipe;
    private javax.swing.JMenuItem jMIelitodasche;
    private javax.swing.JMenuItem jMInomina;
    private javax.swing.JMenuItem jMaltahorario;
    private javax.swing.JMenu jMarea;
    private javax.swing.JMenu jMchecadas;
    private javax.swing.JMenu jMempleado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jMhuella;
    private javax.swing.JMenu jMtipoempleado;
    private javax.swing.JPanel jPacciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPboxn;
    private javax.swing.JPanel jPbtnlimedohu;
    private javax.swing.JPanel jPcalidad;
    private javax.swing.JPanel jPclave;
    private javax.swing.JPanel jPclave1;
    private javax.swing.JPanel jPcongrl;
    private javax.swing.JPanel jPcontcon;
    private javax.swing.JPanel jPcontcon1;
    private javax.swing.JPanel jPcontcon2;
    private javax.swing.JPanel jPcontcon3;
    private javax.swing.JPanel jPcontcon4;
    private javax.swing.JPanel jPcontcon5;
    private javax.swing.JPanel jPcontcon6;
    private javax.swing.JPanel jPcontnomnom;
    private javax.swing.JPanel jPcontnomnom1;
    private javax.swing.JPanel jPfechainifinnom;
    private javax.swing.JPanel jPfechainifinnom1;
    private javax.swing.JPanel jPindicio;
    private javax.swing.JPanel jPindicio1;
    private javax.swing.JPanel jPresultadoc;
    private javax.swing.JPanel jPresultadoc1;
    private javax.swing.JPanel jPresultadoc2;
    private javax.swing.JPanel jPresultadoc3;
    private javax.swing.JPanel jPresultadoc4;
    private javax.swing.JPanel jPresultadoc5;
    private javax.swing.JPanel jPresultadoc6;
    private javax.swing.JPanel jPresultasis;
    private javax.swing.JPanel jPresultnom;
    private javax.swing.JRadioButton jRBanulard;
    private javax.swing.JRadioButton jRBanulari;
    private javax.swing.JRadioButton jRBindiced;
    private javax.swing.JRadioButton jRBindicei;
    private javax.swing.JRadioButton jRBmediod;
    private javax.swing.JRadioButton jRBmedioi;
    private javax.swing.JRadioButton jRBmeñiqued;
    private javax.swing.JRadioButton jRBmeñiquei;
    private javax.swing.JRadioButton jRBpulgard;
    private javax.swing.JRadioButton jRBpulgari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JPanel jp5;
    private javax.swing.JPanel jp6;
    private javax.swing.JPanel jpaneldatos;
    private javax.swing.JPanel jpaneldatos1;
    private javax.swing.JPasswordField jpcnuevacontra;
    private javax.swing.JPanel jpcontdias;
    private javax.swing.JPanel jpcontdias1;
    private javax.swing.JPasswordField jpnuevacontra;
    private javax.swing.JPasswordField jppassword;
    private javax.swing.JPasswordField jppassworddelche;
    private javax.swing.JTextField jtxtnombrearea;
    private javax.swing.JTextField jtxtnombreareamod;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblfotomod;
    private javax.swing.JLabel lblimgdedos;
    private javax.swing.JLabel lblindicio;
    private javax.swing.JLabel lblindiciodelche;
    private javax.swing.JLabel lblseparadorradb;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JTextArea resultconnom;
    private javax.swing.JTextArea salida;
    private javax.swing.JTable tablaasistencia;
    private javax.swing.JTable tablaconsultaarea;
    private javax.swing.JTable tablaconsultachec;
    private javax.swing.JTable tablaconsultaemp;
    private javax.swing.JTable tablaconsultahor;
    private javax.swing.JTable tablaconsultahue;
    private javax.swing.JTable tablaconsultajusti;
    private javax.swing.JTable tablaconsultatipe;
    private javax.swing.JTextField txtclavearea;
    private javax.swing.JTextField txtclaveem;
    private javax.swing.JTextField txtclavehor;
    private javax.swing.JTextField txtclavetipo;
    private javax.swing.JTextField txtclvaltajusti;
    private javax.swing.JTextField txtcnomar;
    private javax.swing.JTextField txtcnomem;
    private javax.swing.JTextField txtcnomhor;
    private javax.swing.JTextField txtcnomjust;
    private javax.swing.JTextField txtcnomprohue;
    private javax.swing.JTextField txtcnomtipe;
    private javax.swing.JTextField txtdescuentocomedor;
    private javax.swing.JTextField txtdescuentofalta;
    private javax.swing.JTextField txtdescuentoimss;
    private javax.swing.JTextField txtdescuentoinfona;
    private javax.swing.JTextField txtdescuentootro;
    private javax.swing.JTextField txtdescuentopermiso;
    private javax.swing.JTextField txtdescuentotrans;
    private javax.swing.JTextField txtdireccion_emp;
    private javax.swing.JTextField txtdireccion_empmod;
    private javax.swing.JTextField txtemail_emp;
    private javax.swing.JTextField txtemail_empmod;
    private javax.swing.JTextField txtfoto;
    private javax.swing.JTextField txtfotomod;
    private javax.swing.JTextField txthoraentdom;
    private javax.swing.JTextField txthoraentdommod;
    private javax.swing.JTextField txthoraentjue;
    private javax.swing.JTextField txthoraentjuemod;
    private javax.swing.JTextField txthoraentlun;
    private javax.swing.JTextField txthoraentlunmod;
    private javax.swing.JTextField txthoraentmar;
    private javax.swing.JTextField txthoraentmarmod;
    private javax.swing.JTextField txthoraentmie;
    private javax.swing.JTextField txthoraentmiemod;
    private javax.swing.JTextField txthoraentsab;
    private javax.swing.JTextField txthoraentsabmod;
    private javax.swing.JTextField txthoraentvie;
    private javax.swing.JTextField txthoraentviemod;
    private javax.swing.JTextField txthorasaldom;
    private javax.swing.JTextField txthorasaldommod;
    private javax.swing.JTextField txthorasaljue;
    private javax.swing.JTextField txthorasaljuemod;
    private javax.swing.JTextField txthorasallun;
    private javax.swing.JTextField txthorasallunmod;
    private javax.swing.JTextField txthorasalmar;
    private javax.swing.JTextField txthorasalmarmod;
    private javax.swing.JTextField txthorasalmie;
    private javax.swing.JTextField txthorasalmiemod;
    private javax.swing.JTextField txthorasalsab;
    private javax.swing.JTextField txthorasalsabmod;
    private javax.swing.JTextField txthorasalvie;
    private javax.swing.JTextField txthorasalviemod;
    private javax.swing.JTextField txthrchec;
    private javax.swing.JTextField txthrchecmod;
    private javax.swing.JTextField txtindiciocontra;
    private javax.swing.JTextField txtnombre_emp;
    private javax.swing.JTextField txtnombre_empmod;
    private javax.swing.JTextField txtnombrealtajusti;
    private javax.swing.JTextField txtnombrehor;
    private javax.swing.JTextField txtnombrehormod;
    private javax.swing.JTextField txtnombremodjusti;
    private javax.swing.JTextField txtnombretipo;
    private javax.swing.JTextField txtnombretipomod;
    private javax.swing.JTextField txtpagohrex;
    private javax.swing.JTextField txtsueldoem;
    private javax.swing.JTextField txtsueldoemmod;
    private javax.swing.JTextField txttelefono_emp;
    private javax.swing.JTextField txttelefono_empmod;
    private javax.swing.JTextField txttoleantentdia;
    private javax.swing.JTextField txttoleantentdiamod;
    private javax.swing.JTextField txttoleantsaldia;
    private javax.swing.JTextField txttoleantsaldiamod;
    private javax.swing.JTextField txttoledesentdia;
    private javax.swing.JTextField txttoledesentdiamod;
    private javax.swing.JTextField txttoledessaldia;
    private javax.swing.JTextField txttoledessaldiamod;
    // End of variables declaration//GEN-END:variables
}
