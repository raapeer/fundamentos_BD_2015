package interfaz;

import javax.swing.*; 
import java.awt.*;  


public class TransparentBackground extends JComponent {
//Imagen que captura lo que esta detras
private Image background; 

public TransparentBackground() {
//Metodo que se encarga de obtener el fondo
updateBackground( ); 
} 

public void updateBackground( ) { 
try { 
    //Crea un objeto de la clase robot, que es la que permite capturar lo que esta detras
Robot rbt = new Robot( ); 
Toolkit tk = Toolkit.getDefaultToolkit( );
//Obtiene el tamaño del frame que contiene la imagen en este caso framei
Dimension dim = tk.getScreenSize( ); 

//Captura lo que esta detras creando un rectangulo del tamaño del frame que contiene la imagen
//en este caso framei
background = rbt.createScreenCapture( 
new Rectangle(0,0,(int)dim.getWidth( ), 
(int)dim.getHeight( ))); 
} catch (Exception ex) { 
ex.printStackTrace( ); 
} 
}

//Dibuja la imagen en el frame contenedor de imagen, en este caso framei
public void paintComponent(Graphics g) { 
Point pos = this.getLocationOnScreen(); 
Point offset = new Point(-pos.x,-pos.y); 
g.drawImage(background,offset.x,offset.y,null); 
} 
}