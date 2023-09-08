/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo32;

import java.sql.Connection;
import universidadgrupo32accesoDatos.Conexion;

/**
 *
 * @author vvted
 */
public class UniversidadGrupo32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con = Conexion.getConexion();
    }
    
}
