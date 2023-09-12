
package universidadgrupo32accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo32entidades.Materia;


public class MateriaData {
    private Connection con=null;
    
    public MateriaData(){
            con=Conexion.getConexion();
            
}
    public void guardarMateria(Materia materia){
    String sql="INSERT INTO materia(nombre,anio, estado)"
            + "VALUES(?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
               materia.setIdMateria(rs.getInt("idMateria"));
            JOptionPane.showMessageDialog(null, "Materia añadida con exito.");
            }
            ps.close();
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia"+ex.getMessage());
        } 
        
    }
    public Materia buscarMateria(int id) {
    
    String sql = "SELECT nombre,anio, estado FROM materia WHERE idMateria = ? AND estado = 1";
    Materia materia = null;
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre de la materia"));
                materia.setAnio();
                materia.setEstado(true);


         } else {
              JOptionPane.showMessageDialog(null, "No existe la materia");
        }
        ps.close();
    } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia ");
    }    
        return materia;
    
    }    
    
}