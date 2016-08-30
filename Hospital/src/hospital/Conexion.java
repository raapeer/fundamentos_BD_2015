/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hospital;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alumno
 */
public class Conexion {
    
/*
    //conexion tese netbeans 8, Driver
    
    public static Connection conectar(){
        Connection cn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=Biblioteca;user=sa;password=sasa;";
            cn=DriverManager.getConnection(url);
           return (cn);
        } catch (Exception e) {
            System.out.print("Error al conectar con la base de dtos:" + e);
            return null;
        }
    }
*/
    
    
        //conexion tese netbeans 8, Driver laptop
    
    public static Connection conectar(){
        Connection cn=null;
        try {
           // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=Dentista;user=sa; password=sasa";
            //cn = DriverManager.getConnection("jdbc:odbc:BibliotecaTese","sa","sasa");
           cn=DriverManager.getConnection(url);
            return (cn);
        } catch (Exception e) {
            System.out.print("Error al conectar con la base de dtos:" + e);
            return null;
        }
    }

}
