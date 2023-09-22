package universidadgrupo32accesoDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo32entidades.Alumno;

public class AlumnoData {

    public AlumnoData() {

        con = Conexion.getConexion();
    }

    private Connection con = null;

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaDeNacimiento, estado)"
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "ALUMNO AÑADIDO CON EXITO - I.D. : " + alumno.getIdAlumno());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int dni) {

        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaDeNacimiento, estado "
                + "FROM alumno WHERE dni = ? ";
        Alumno alumno = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaDeNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ALUMNO");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + ex.getMessage());
        }

        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE estado=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaDeNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + e.getMessage());
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fecgaDeNacimiento=?"
                + "WHERE dni=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "ALUMNO MODIFICADO EXITOSAMENTE");
            } else {
                JOptionPane.showMessageDialog(null, "El ALUMNO NO EXISTE");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + e.getMessage());
        }

    }

    public void bajaAlumno(int dni) {
        try {
            String sql = "UPDATE alumno SET estado=0 WHERE dni=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "SE DIÓ DE BAJA EL ALUMNO");
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO" + e.getMessage());
        }

    }

}
