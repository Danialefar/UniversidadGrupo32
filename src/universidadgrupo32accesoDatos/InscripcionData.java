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
 private MateriaData md=new MateriaData();
    private AlumnoData ad=new AlumnoData();
//hola hola 
    public void guardarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria)"
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3,inscripcion.getMateria().getIdMateria() );

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "ISCRIPCION AÑADIDA CON EXITO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }

    }
    
    public void actualizarNota(int idAlumno, int idMateria ,double nota ){
        String sql= "UPDATE inscripcion SET nota=? WHERE idAlumno=? and idMateria=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3,idMateria );
            int filas=ps.executeUpdate();
            if (filas>0){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }    
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }
    }

    public void borrarInscripcionMateriaAlumno(int IdAlumno, int idMateria){
        
        String sql="Delete From inscripcion WHERE IdAlumno=?  and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IdAlumno);
            ps.setInt(2,idMateria);
            int filas=ps.executeUpdate();
            if (filas>0){
                JOptionPane.showMessageDialog(null, "Se elimino la inscripcion");}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" + ex.getMessage());
        }
    }        
            
    public List<Inscripcion> listarInscripciones() {
        
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu=ad.buscarAlumnoId(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateriaID(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" );
        }
        return inscripciones;
    }
    public List<Inscripcion> obtenerInscripcionmesPorAlumno(int dni) {
        
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu=ad.buscarAlumnoId(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateriaID(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" );
        }
        return inscripciones;
    }
    
    public List<Inscripcion> obtenerInscripcionmesPorAlumno2(int idAlumno) {
        
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu=ad.buscarAlumnoId(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateriaID(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" );
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno){
         ArrayList<Materia> mat = new ArrayList<>();
         String sql="SELECT inscripcion.idmateria,materia.nombre,materia.año FROM inscripcion ,materia WHERE inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno=?";
        try {       
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mt=new Materia();
                mt.setIdMateria(rs.getInt("idMateria"));
                mt.setNombre(rs.getString("nombre"));
                mt.setAnio(rs.getInt("año"));
                mat.add(mt);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" );
        }
        return mat ;   
    }

    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN (SELECT inscripcion.idMateria FROM inscripcion WHERE idAlumno= ?)";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mat=new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("año"));
                materias.add(mat);
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION" );
        }
        return materias;
    }
    
     public List<Alumno> obtenerAlumnoXMateria(int idMateria){
       ArrayList<Alumno> alumnosMaterias = new ArrayList<>();
       String sql="SELECT alumno.idAlumno,alumno.dni,alumno.nombre,alumno.apellido,alumno.fechadenacimiento,alumno.estado FROM inscripcion ,alumno  WHERE inscripcion.idAlumno=alumno.idAlumno AND (idMateria=? AND alumno.estado=1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idMateria);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Alumno alu=new Alumno();
                 alu.setIdAlumno(rs.getInt("idalumno"));
                 alu.setApellido(rs.getString("apellido"));
                 alu.setNombre(rs.getString("nombre"));
                 alu.setFechaNac(rs.getDate("fechadenacimiento").toLocalDate());
                 alu.setActivo((rs.getBoolean("estado")));
                 alumnosMaterias.add(alu);
             }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA" + ex.getMessage());
        }
       return alumnosMaterias;
    }
}
