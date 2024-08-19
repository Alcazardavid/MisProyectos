
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus_Ortega
 */
public class ConexionBD {
        
    Connection connection = null;// Después de establecer la conexión, la variable 'connection' apuntará a la conexión real.
    
    String usuario = "postgres";//creamos una variable que contenga una cadena del nombre del usuario
    String contraseña = "puma99912";//creamos una variable que cotenga una cadena la contraseña 
    String bd = "productos";//creamos una variable que cotenga una cadena el nombre de la base de datos
    String ip = "localhost";//creamos una variable que cotenga una cadena de la IP
    String puerto = "5432";//creamos una variable que cotenga una cadena del puerto
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    /**
     * Este es el metodo de tipo "connection" para realizar la conexion a la base de datos llmada "establecerConexion"
     * @return y retornamos la connectNewClassion.
     */
    public Connection establecerConexion(){
        try{//un try para verificar si no hay ningun error al conectarse a la BD
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(cadena,usuario,contraseña);    
            //JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "error: "+ e.toString());
        }
        return connection;
    }
     public static void main(String[] args) {
         ConexionBD javaPostgreSQLBasic = new ConexionBD();
        javaPostgreSQLBasic.establecerConexion(); 
    }

}