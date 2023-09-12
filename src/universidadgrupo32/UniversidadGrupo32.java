package universidadgrupo32;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import universidadgrupo32accesoDatos.AlumnoData;
import universidadgrupo32accesoDatos.Conexion;
import universidadgrupo32entidades.Alumno;
import universidadgrupo32entidades.Materia;

public class UniversidadGrupo32 {

    public static void main(String[] args) {

        Connection con = Conexion.getConexion();

//        Alumno alu = new Alumno(41052147, "MOYANO", "LAURA MIKAELA", LocalDate.of(2000, 10, 20), true);
//        System.out.println(alu.toString());
//
//        Materia mat = new Materia("PROGRAMACIÓN", 1, true);
//        System.out.println(mat.toString());

    }

}
