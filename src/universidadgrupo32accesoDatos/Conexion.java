
package universidadgrupo32accesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String BD="universidadulp";
    private static final String USUARIO="root";
    private static final String PASS="";
    private static Connection conexion;
    
    private Conexion() {}  
    
    public static Connection getConexion(){
    
        if (conexion==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(URL+BD,USUARIO,PASS);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DRIVERS" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LA BASE DE DATOS" + ex.getMessage());
            }
        
        }
    return conexion;
    }
}
