package universidadgrupo32accesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;
import universidadgrupo32entidades.Alumno;

public class AlumnoData {

    public AlumnoData() {

        con = Conexion.getConexion();
    }

    private Connection con = null;

    public void guardarAlumno(Alumno alumno) throws SQLException {

        String sql= "INSERT INTO alumno (dni, apellido, nombre, fechaNac, estado)"
                + "VALUES (?,?,?,?,?)";
        
        try 
            (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                JOptionPane.showMessageDialog(null, "ALUMNO AÑADIDO CON EXITO");
            }
            ps.close();
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + ex.getMessage());
        }
    }

}
