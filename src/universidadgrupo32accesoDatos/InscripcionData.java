
package universidadgrupo32accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo32entidades.Alumno;
import universidadgrupo32entidades.Inscripcion;
import universidadgrupo32entidades.Materia;


public class InscripcionData {
    public InscripcionData() {

        con = Conexion.getConexion();
    }
     private Connection con = null;
     
     public void guardarInscripcion(Inscripcion inscripcion) {
         String sql= "INSERT INTO inscripcion (idMateria, idAlumno, nota)"
                + "VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,inscripcion.getMateria().getIdMateria());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setDouble(3, inscripcion.getNota());
            
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                int idIscripcion = rs.getInt("idIscripcion");
                JOptionPane.showMessageDialog(null, "ISCRIPCION AÑADIDA CON EXITO");
            }
            ps.close();
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }
         
         
     }
       
        
         
     public List<Inscripcion> listarInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        List<AlumnoData> alumnosDatas = new ArrayList<>();
        AlumnoData alumnoData = new AlumnoData();
        alumnosDatas = alumnoData.listarAlumnos();
        try {
            String sql = "SELECT inscripcion.*, alumno.*, materia.* FROM inscripcion "
                    + "JOIN materia ON inscripcion.idMateria = materia.idMateria "
                    + "JOIN alumno ON incripcion.idAlumno = alumnos idAlumno";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setAlumno(new Alumno());
                inscripcion.setNota(rs.getInt("nota"));
                inscripcion.setMateria(new Materia());
                inscripciones.add(inscripcion);

            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" + e.getMessage());
        }
        return inscripciones;
    }
             
     
}
