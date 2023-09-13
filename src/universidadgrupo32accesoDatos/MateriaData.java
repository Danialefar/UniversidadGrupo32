
package universidadgrupo32accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public void modificarMateria(Materia materia){
    
          String sql="UPDATE materia SET nombre= ?,anio= ?" + "WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
             if(exito==1){
             
                 JOptionPane.showMessageDialog(null, "Materia modificada");
             
             }
             
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        
        }
    }
            
    
    
    public List<Materia> listarMaterias() {
    
    String sql = "SELECT nombre,anio, estado FROM materia WHERE idMateria = ? AND estado = 1";
    ArrayList<Materia> materias =  new ArrayList<>();
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        
        
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idAlumno"));
                materia.setNombre(rs.getString("nombre de la materia"));
                materia.setAnio();
                materia.setEstado(true);

                materias.add(materia);
        } 
        ps.close();
        
    } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia ");
    }    
        return materias;
    
    }
}    