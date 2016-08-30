/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *Esta clase calcula las horas que se deben laborar en el horario
 * establecido
 * @author yo
 */
public class hlabsfromhorario {
    
    public String calcularhtotales(String hentdom, String hsaldom, String hentlun, String hsallun, 
        String hentmar, String hsalmar, String hentmie, String hsalmie, String hentjue, String hsaljue, 
        String hentvie, String hsalvie, String hentsab, String hsalsab){
        int hrsensegundos = 0;
        DecimalFormat dosDigitos = new DecimalFormat("00");
        String hora = "";
        
        //Se calculan las horas que se deben laborar el día domingo
        int horaidom = Integer.parseInt(hentdom.substring(0, 2));
	int minidom = Integer.parseInt(hentdom.substring(3, 5));
	int segidom = 0;
	int horafdom = Integer.parseInt(hsaldom.substring(0, 2));
	int minfdom = Integer.parseInt(hsaldom.substring(3, 5));
	int segfdom = 0;
	int inidom=(((horaidom*60)*60)+(minidom*60)+segidom);
        int findom=(((horafdom*60)*60)+(minfdom*60)+segfdom);
	int difdom=findom-inidom;
        hrsensegundos += difdom;
        
        
        int horailun = Integer.parseInt(hentlun.substring(0, 2));
	int minilun = Integer.parseInt(hentlun.substring(3, 5));
	int segilun = 0;
	int horaflun = Integer.parseInt(hsallun.substring(0, 2));
	int minflun = Integer.parseInt(hsallun.substring(3, 5));
	int segflun = 0;
	int inilun=(((horailun*60)*60)+(minilun*60)+segilun);
	int finlun=(((horaflun*60)*60)+(minflun*60)+segflun);
	int diflun=finlun-inilun;
        hrsensegundos += diflun;
        
        int horaimar = Integer.parseInt(hentmar.substring(0, 2));
	int minimar = Integer.parseInt(hentmar.substring(3, 5));
	int segimar = 0;
	int horafmar = Integer.parseInt(hsalmar.substring(0, 2));
	int minfmar = Integer.parseInt(hsalmar.substring(3, 5));
	int segfmar = 0;
	int inimar=(((horaimar*60)*60)+(minimar*60)+segimar);
	int finmar=(((horafmar*60)*60)+(minfmar*60)+segfmar);
	int difmar=finmar-inimar;
        hrsensegundos += difmar;
        
        int horaimie = Integer.parseInt(hentmie.substring(0, 2));
	int minimie = Integer.parseInt(hentmie.substring(3, 5));
	int segimie = 0;
	int horafmie = Integer.parseInt(hsalmie.substring(0, 2));
	int minfmie = Integer.parseInt(hsalmie.substring(3, 5));
	int segfmie = 0;
	int inimie=(((horaimie*60)*60)+(minimie*60)+segimie);
	int finmie=(((horafmie*60)*60)+(minfmie*60)+segfmie);
	int difmie=finmie-inimie;
        hrsensegundos += difmie;
        
        int horaijue = Integer.parseInt(hentjue.substring(0, 2));
	int minijue = Integer.parseInt(hentjue.substring(3, 5));
	int segijue = 0;
	int horafjue = Integer.parseInt(hsaljue.substring(0, 2));
	int minfjue = Integer.parseInt(hsaljue.substring(3, 5));
	int segfjue = 0;
	int inijue=(((horaijue*60)*60)+(minijue*60)+segijue);
	int finjue=(((horafjue*60)*60)+(minfjue*60)+segfjue);
	int difjue=finjue-inijue;
        hrsensegundos += difjue;
        
        int horaivie = Integer.parseInt(hentvie.substring(0, 2));
	int minivie = Integer.parseInt(hentvie.substring(3, 5));
	int segivie = 0;
	int horafvie = Integer.parseInt(hsalvie.substring(0, 2));
	int minfvie = Integer.parseInt(hsalvie.substring(3, 5));
	int segfvie = 0;
	int inivie=(((horaivie*60)*60)+(minivie*60)+segivie);
	int finvie=(((horafvie*60)*60)+(minfvie*60)+segfvie);
	int difvie=finvie-inivie;
        hrsensegundos += difvie;
        
        int horaisab = Integer.parseInt(hentsab.substring(0, 2));
	int minisab = Integer.parseInt(hentsab.substring(3, 5));
	int segisab = 0;
	int horafsab = Integer.parseInt(hsalsab.substring(0, 2));
	int minfsab = Integer.parseInt(hsalsab.substring(3, 5));
	int segfsab = 0;
	int inisab=(((horaisab*60)*60)+(minisab*60)+segisab);
	int finsab=(((horafsab*60)*60)+(minfsab*60)+segfsab);
	int difsab=finsab-inisab;
        hrsensegundos += difsab;
        
        int h = (hrsensegundos/3600);
	int m = ((hrsensegundos-(h*3600))/60);
	int s = hrsensegundos-(m*60)-(h*3600);
        hrsensegundos = 0;
        if(h < 10){
            hora = "0" + h;
        }
        else{
            hora = String.valueOf(h);
        }
        
        return hora+":"+dosDigitos.format(m)+":"+dosDigitos.format(s);
    }
    
}
