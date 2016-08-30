/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import procedimientos.Util;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jvnet.substance.SubstanceLookAndFeel;
import sun.audio.*;
//import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author EQUIPO 1
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    JLabel labellog = new JLabel();
    JFrame framei;
    //=============================================================== fields
    private Clock _clock;                        // Our clock component.
    
//objeto usado para realizar todas las operaciones relacionadas al Fingerprint-SDK
   private Util procedimientosSDK;

   //Panel para mostrar la huella digital
   private JPanel fingerprintViewPanel = null;
   
   
   //Imagen de la huella actual
   private BufferedImage fingerprintImage = null;
private javax.swing.Timer timer1;
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        HiloNuevo hn = new HiloNuevo();
        Thread nuevoHilo = new Thread(hn);
        nuevoHilo.start();
        
        _clock = new Clock();
        initComponents();
        labellog.setIcon(new ImageIcon(getClass().getResource("/imagenes/Logosipahdg.png")));
        lbllogo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Logosipahds.png")));
        lbllogo2.setIcon(new ImageIcon(getClass().getResource("/imagenes/Logosipahds.png")));
        showlogo();
        //setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.ico")).getImage());
        initOthersComponets();
        inicializar();
        /*Inicializa la captura de huellas*/
        procedimientosSDK.inicializarCaptura();

        //Finalizes the program when the window is closed.
       this.addWindowListener(new java.awt.event.WindowAdapter() {
           public void windowClosing(java.awt.event.WindowEvent e) {
               destroy();
               System.exit(0);
           }
       });
       
    }
        public void showlogo(){
framei.setDefaultLookAndFeelDecorated(false);
framei = new JFrame();
framei.setUndecorated(true);
framei.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logopng.png")).getImage());
TransparentBackground bg = new TransparentBackground();
JLabel seautoriza = new JLabel("Se autoriza este programa a Techno-Cyber, Actipan.");
seautoriza.setForeground(Color.BLACK);
seautoriza.setFont(new Font("Monospaced", Font.BOLD, 18));
bg.setLayout(new BorderLayout( ));
bg.add("South",seautoriza);
bg.add("Center",labellog); 
framei.getContentPane( ).add("Center",bg); 
framei.pack( ); 
framei.setSize(645,455);
framei.setLocationRelativeTo(null);
framei.setVisible(true); 
    }
    //=============================================================== start
    public void start() {
        _clock.start();
    }
    
    //================================================================ stop
    public void stop() {
        _clock.stop();
    }
    // File   : GUI-lowlevel/animation/analogclock/Clock.java
// Purpose: An analog clock component -- Uses Timer and Calendar.
// Note   : Uses a BufferedImage for clock face so isn't drawn each time.
// Author : Fred Swartz, 1999-2007, Placed in public domain.


//////////////////////////////////////////////////////////////// Clock class
class Clock extends JComponent {
    
    //============================================================ constants
    private static final double TWO_PI   = 2.0 * Math.PI;
    
    private static final int    UPDATE_INTERVAL = 100;  // Millisecs
    
    //=============================================================== fields
    private Calendar _now = Calendar.getInstance();  // Current time.
    
    private int _diameter;                 // Height and width of clock face
    private int _centerX;                  // x coord of middle of clock
    private int _centerY;                  // y coord of middle of clock
    private BufferedImage _clockImage;     // Saved image of the clock face.
    
    private javax.swing.Timer _timer;      // Fires to update clock.
    
    //==================================================== Clock constructor
    public Clock() {
        setPreferredSize(new Dimension(240,240));
        
        _timer = new javax.swing.Timer(UPDATE_INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();
                repaint();
            }
        });
    }
    
    //================================================================ start
    /** Start the timer. */
    public void start() {
        _timer.start(); 
    }
    
    //================================================================= stop
    /** Stop the timer. */
    public void stop() {
        _timer.stop(); 
    }
    
    //=========================================================== updateTime
    private void updateTime() {
        //... Avoid creating new objects.
        _now.setTimeInMillis(System.currentTimeMillis());
    }
    
    //======================================================= paintComponent
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        //... The panel may have been resized, get current dimensions
        int w = getWidth();
        int h = getHeight();
        _diameter = ((w < h) ? w : h)-1;
        _centerX = _diameter / 2;
        _centerY = _diameter / 2;
        
        //... Create the clock face background image if this is the first time,
        //    or if the size of the panel has changed
        if (_clockImage == null
                || _clockImage.getWidth() != w
                || _clockImage.getHeight() != h) {
            _clockImage = (BufferedImage)(this.createImage(w, h));
            
            //... Get a graphics context from this image
            Graphics2D g2a = _clockImage.createGraphics();
            g2a.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            drawClockFace(g2a);
        }
        
        //... Draw the clock face from the precomputed image
        g2.drawImage(_clockImage, null, 0, 0);
        
        //... Draw the clock hands dynamically each time.
        drawClockHands(g2);
    }
    
    //====================================== convenience method drawClockHands
    private void drawClockHands(Graphics2D g2) {
        //... Get the various time elements from the Calendar object.
        int hours   = _now.get(Calendar.HOUR);
        int minutes = _now.get(Calendar.MINUTE);
        int seconds = _now.get(Calendar.SECOND);
        int millis  = _now.get(Calendar.MILLISECOND);
        
        //... second hand
        int handMin = _diameter / 8;    // Second hand doesn't start in middle.
        int handMax = _diameter / 2;    // Second hand extends to outer rim.
        double fseconds = (seconds + (double)millis/1000) / 60.0;
        drawhandseconds(g2, fseconds, 0, handMax);
        
        //... minute hand
        handMin = 0;                    // Minute hand starts in middle.
        handMax = _diameter / 3; 
        double fminutes = (minutes + fseconds) / 60.0;
        drawhandminutes(g2, fminutes, 0, handMax);
        
        //... hour hand
        handMin = 0;
        handMax = _diameter / 4;
        drawhandhours(g2, (hours + fminutes) / 12.0, 0, handMax);
    }
    
    //======================================= convenience method drawClockFace
    private void drawClockFace(Graphics2D g2) {
        int hora = 1;
        String hr [] = {"0","12","1","2","3","4","5","6","7","8","9","10","11"};
        // ... Draw the clock face.  Probably into a buffer.        
        g2.setPaint(new GradientPaint(5,30,Color.YELLOW,35,100,Color.GREEN,true));
        g2.fillOval(0, 0, _diameter, _diameter);
        g2.setColor(Color.BLACK);
        g2.drawOval(0, 0, _diameter, _diameter);
        
        int radius = _diameter / 2;
        double radiohr = _diameter / 2.2;
        
        //... Draw the tick marks around the circumference.
        for (int sec = 0; sec < 60; sec++) {
            int tickStart;
            if (sec%5 == 0) {
                tickStart = (int) radiohr - 5;  // Draw long tick mark every 5.
                //for(int hora = 1; hora < 13; hora ++){
                drawNumbers(hr[hora], g2, sec / 60.0, tickStart);
                hora ++;
                //}
            } else {
                tickStart = radius - 5;   // Short tick mark.
            }
            drawRadius(g2, sec / 60.0, tickStart , radius);
        }
    }
    
    //==================================== convenience method drawRadius
    // This draw lines along a radius from the clock face center.
    // By changing the parameters, it can be used to draw tick marks,
    // as well as the hands.
    private void drawRadius(Graphics2D g2, double percent,int minRadius, int maxRadius) {
        //... percent parameter is the fraction (0.0 - 1.0) of the way
        //    clockwise from 12.   Because the Graphics2D methods use radians
        //    counterclockwise from 3, a little conversion is necessary.
        //    It took a little experimentation to get this right.
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)(minRadius * sine);
        int dymin = _centerY + (int)(minRadius * cosine);
        
        int dxmax = _centerX + (int)(maxRadius * sine);
        int dymax = _centerY + (int)(maxRadius * cosine);
        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }
    private void drawhandseconds(Graphics2D g2, double percent,int minRadius, int maxRadius) {
        //... percent parameter is the fraction (0.0 - 1.0) of the way
        //    clockwise from 12.   Because the Graphics2D methods use radians
        //    counterclockwise from 3, a little conversion is necessary.
        //    It took a little experimentation to get this right.
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)(minRadius * sine);
        int dymin = _centerY + (int)(minRadius * cosine);
        
        int dxmax = _centerX + (int)(maxRadius * sine);
        int dymax = _centerY + (int)(maxRadius * cosine);
        g2.setColor(Color.red);
        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }
        private void drawhandminutes(Graphics2D g2, double percent,int minRadius, int maxRadius) {
        //... percent parameter is the fraction (0.0 - 1.0) of the way
        //    clockwise from 12.   Because the Graphics2D methods use radians
        //    counterclockwise from 3, a little conversion is necessary.
        //    It took a little experimentation to get this right.
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)(minRadius * sine);
        int dymin = _centerY + (int)(minRadius * cosine);
        
        int dxmax = _centerX + (int)(maxRadius * sine);
        int dymax = _centerY + (int)(maxRadius * cosine);
        g2.setColor(Color.BLUE);
        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }
        private void drawhandhours(Graphics2D g2, double percent,int minRadius, int maxRadius) {
        //... percent parameter is the fraction (0.0 - 1.0) of the way
        //    clockwise from 12.   Because the Graphics2D methods use radians
        //    counterclockwise from 3, a little conversion is necessary.
        //    It took a little experimentation to get this right.
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)(minRadius * sine);
        int dymin = _centerY + (int)(minRadius * cosine);
        
        int dxmax = _centerX + (int)(maxRadius * sine);
        int dymax = _centerY + (int)(maxRadius * cosine);
        g2.setColor(Color.BLACK);
        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }
    
        private void drawNumbers(String hr,Graphics2D g2, double percent, int minRadius) {
        //... percent parameter is the fraction (0.0 - 1.0) of the way
        //    clockwise from 12.   Because the Graphics2D methods use radians
        //    counterclockwise from 3, a little conversion is necessary.
        //    It took a little experimentation to get this right.
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)((minRadius * sine) - 6);
        int dymin = _centerY + (int)((minRadius * cosine) + 4);
        g2.setFont(new Font("Monospaced", Font.BOLD, 18));
        g2.drawString(hr,dxmin, dymin);
    }
}
public void initOthersComponets(){
    java.awt.event.ActionListener al = 
            new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    onTimer();
                } 
            };
    //Crear un temporizador e iniciarlo
    timer1 = new javax.swing.Timer(1000, al);
    timer1.start();
    _clock.start();
}

private void onTimer(){
    java.util.Date hora = new java.util.Date();
    String patron = "hh:mm:ss";
    java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(patron);
    jlbHoraActual.setText(formato.format(hora));
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpcontenedor = new javax.swing.JPanel();
        panelEstado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        panelfoto = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        panelhrdts = new javax.swing.JPanel();
        jlbHoraActual = new javax.swing.JLabel();
        paneldatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtclave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        panelhuella = new javax.swing.JPanel();
        panelreloj = new javax.swing.JPanel();
        lbllogo1 = new javax.swing.JLabel();
        jPrelojanalogico = new javax.swing.JPanel();
        lbllogo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TECHNO-CYBER, ACTIPAN");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logopng.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpcontenedor.setLayout(new java.awt.BorderLayout());
        jpcontenedor.add(panelEstado,BorderLayout.SOUTH);
        jpcontenedor.add(panelreloj, BorderLayout.NORTH);
        jpcontenedor.add(panelhuella,BorderLayout.EAST);
        jpcontenedor.add(panelfoto, BorderLayout.WEST);
        jpcontenedor.add(panelhrdts, BorderLayout.CENTER);

        panelEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panelEstado.setPreferredSize(new java.awt.Dimension(180, 130));
        panelEstado.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(new CompoundBorder (
            new EmptyBorder (2,2,2,2),
            new BevelBorder(BevelBorder.LOWERED)));
    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setAutoscrolls(true);
    jScrollPane1.setHorizontalScrollBar(null);

    salida.setColumns(20);
    salida.setEditable(false);
    salida.setFont(new java.awt.Font("Monospaced", 1, 11)); // NOI18N
    salida.setLineWrap(true);
    salida.setRows(5);
    salida.setBorder(null);
    jScrollPane1.setViewportView(salida);

    panelEstado.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    jpcontenedor.add(panelEstado, java.awt.BorderLayout.PAGE_END);

    panelfoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    panelfoto.setPreferredSize(new java.awt.Dimension(250, 6));
    panelfoto.setLayout(new java.awt.BorderLayout());

    lblfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    panelfoto.add(lblfoto, java.awt.BorderLayout.CENTER);

    jpcontenedor.add(panelfoto, java.awt.BorderLayout.LINE_START);

    panelhrdts.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    panelhrdts.setMaximumSize(new java.awt.Dimension(100, 100));
    panelhrdts.setLayout(new java.awt.BorderLayout());

    jlbHoraActual.setBackground(new java.awt.Color(153, 255, 0));
    jlbHoraActual.setFont(new java.awt.Font("Arial Black", 0, 60)); // NOI18N
    jlbHoraActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlbHoraActual.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    panelhrdts.add(jlbHoraActual, java.awt.BorderLayout.NORTH);

    paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    paneldatos.setLayout(new java.awt.GridLayout(4, 1));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Clave:");
    paneldatos.add(jLabel1);

    txtclave.setColumns(15);
    txtclave.setEditable(false);
    txtclave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txtclave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    paneldatos.add(txtclave);

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Nombre:");
    paneldatos.add(jLabel2);

    txtnombre.setColumns(15);
    txtnombre.setEditable(false);
    txtnombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    paneldatos.add(txtnombre);

    panelhrdts.add(paneldatos, java.awt.BorderLayout.CENTER);

    jpcontenedor.add(panelhrdts, java.awt.BorderLayout.CENTER);

    panelhuella.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
    panelhuella.setPreferredSize(new java.awt.Dimension(250, 23));
    panelhuella.setLayout(new java.awt.BorderLayout());
    jpcontenedor.add(panelhuella, java.awt.BorderLayout.LINE_END);

    panelreloj.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    panelreloj.setPreferredSize(new java.awt.Dimension(4, 285));
    panelreloj.setLayout(new java.awt.GridLayout(1, 3));

    lbllogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbllogo1.setToolTipText("Sistema de Pago y Asistencia por Huella Digital");
    panelreloj.add(lbllogo1);

    jPrelojanalogico.add(_clock);
    panelreloj.add(jPrelojanalogico);

    lbllogo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbllogo2.setToolTipText("Sistema de Pago y Asistencia por Huella Digital");
    panelreloj.add(lbllogo2);

    jpcontenedor.add(panelreloj, java.awt.BorderLayout.PAGE_START);

    getContentPane().add(jpcontenedor, java.awt.BorderLayout.CENTER);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.panelhuella.add(crearPanelHuella());
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */ 
        PantallaPrincipal.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.ChallengerDeepSkin");
        //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceLimeGreenTheme");
            String grFingerNativeDirectory = new File(".").getAbsolutePath();
            Util.setFingerprintSDKNativeDirectory(grFingerNativeDirectory);
            PantallaPrincipal p = new PantallaPrincipal();
           
    }
    public class HiloNuevo implements Runnable{
       
public void run(){
    try {
                Thread.sleep(6000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
thissetvisible();

}
}
public void thissetvisible(){
            /*centra la ventana en la pantalla*/
        //this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        framei.setVisible(false);
        this.setVisible(true);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
}
    /**
      * Se establece el estilo visual de la aplicación y se realiza la inicialización de la clase 
      * que contiene los procedimientos principales.
      **/   
    public void  inicializar() {
              //Crea una instancia de Util
       this.procedimientosSDK = new Util(this);       
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
       //fingerprintViewPanel.setBorder(new CompoundBorder (
               //new EmptyBorder (2,2,2,2),
               //new BevelBorder(BevelBorder.LOWERED)));           
       
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
   //Mostramos la clave, nombre, area o departamento y la foto del empleado que checo, ademas reproducimos un archivo para que el empleado se serciore de que checo bien
   public void mostrardatosenpantalla(String clav, String nombr, Icon icon){
       txtclave.setText(clav);
       txtnombre.setText(nombr);
       lblfoto.setIcon(icon);
       writeLog("Acceso correcto");
       repaccesocorrecto();
   }
   public void mostdsinfoto(String cl, String nom){
       txtclave.setText(cl);
       txtnombre.setText(nom);
       lblfoto.setIcon(new ImageIcon(getClass().getResource("/imagenes/sinfoto.png")));
       writeLog("Acceso correcto");
       repaccesocorrecto();
   }
   public void repaccesocorrecto(){
                try{
                InputStream in = getClass().getResourceAsStream("/audioschecador/accesocorrecto.wav");
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio); 
                }
                catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            //write error to log
           writeLog(e.getMessage());
       }
                
}
   
   //Si no se encuentra la huella en la bd, entonces le mostramos una imagen de error al empleado
   public void mostrarnocoincidencia(){
       Toolkit.getDefaultToolkit().beep();
       lblfoto.setIcon(new ImageIcon( getClass().getResource( "/imagenes/msjerror.png" )));
       txtclave.setText("");
       txtnombre.setText("");
       repnocoincide();
   }
   public void mostrarimgnoconectabd(){
       lblfoto.setIcon(new ImageIcon( getClass().getResource( "/imagenes/errornoconectabd.png" )));
   }
   public void repnocoincide(){
       try{
                InputStream in = getClass().getResourceAsStream("/audioschecador/nocoincide.wav");
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio); 
                }
                catch (Exception e) {
              Toolkit.getDefaultToolkit().beep();
            //write error to log
           writeLog(e.getMessage());
       }
   }
   public void nosepuedeconectarbd(){
       try{
                InputStream in = getClass().getResourceAsStream("/audioschecador/nocpdeconectar.wav");
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio); 
                }
                catch (Exception e) {
              Toolkit.getDefaultToolkit().beep();
            //write error to log
           writeLog(e.getMessage());
       }
   }
   public void repintarp(){
       panelhuella.repaint();
   }
   /**
    * Frees Fingerprint SDK resources and finished the program.
    */
   public void destroy() {
       procedimientosSDK.destroy();
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPrelojanalogico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbHoraActual;
    private javax.swing.JPanel jpcontenedor;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lbllogo1;
    private javax.swing.JLabel lbllogo2;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JPanel panelfoto;
    private javax.swing.JPanel panelhrdts;
    private javax.swing.JPanel panelhuella;
    private javax.swing.JPanel panelreloj;
    private javax.swing.JTextArea salida;
    private javax.swing.JTextField txtclave;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
