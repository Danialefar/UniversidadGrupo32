
package universidadgrupo32accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidadgrupo32entidades.Alumno;
import universidadgrupo32entidades.Inscripcion;
import universidadgrupo32entidades.Materia;


public class InscripcionData {
    public InscripcionData() {

        con = Conexion.getConexion();
    }
     private Connection con = null;
     
     public void guardarInscripcion(Inscripcion inscripcion) throws SQLException{
         String sql= "INSERT INTO inscripcion (idMateria, idAlumno, nota)"
                + "VALUES (?,?,?)";
        
        try 
            (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,inscripcion.getMateria().getIdMateria());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setDouble(3, inscripcion.getNota());
            
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                int idIscripcion = rs.getInt("idIscripcion");
                Alumno encontrarAlumno = inscripcion.getAlumno(idAlumno);
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setAlumno(rs.getInt("idAlumno"));
                JOptionPane.showMessageDialog(null, "ISCRIPCION AÑADIDA CON EXITO");
            }
            ps.close();
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ISCRIPCION" + ex.getMessage());
        }
         
         
     }
             
     
}
