/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procedimientos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EQUIPO 1
 */
public class formatosfechahora {
    
    public String obtenerfecha(){
        //Obtener unicamente la fecha del sistema
        DateFormat yearp = new SimpleDateFormat("yyyy/MM/dd");
            String fechasalida = yearp.format(new Date());
            return fechasalida;
    }
    
    public String obtenerhora(){
        //Obtener unicamente la hora del sistema
        DateFormat df2p = new SimpleDateFormat("HH:mm:ss");
            String horasalida = df2p.format(new Date());
            return horasalida;
    }
    
}
