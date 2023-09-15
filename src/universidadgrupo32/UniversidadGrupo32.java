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

//      Alumno a1 = new Alumno(37555278, "ABACA", "MARTIN", LocalDate.of(1994, 10, 8), true);
        AlumnoData alum = new AlumnoData();
        Alumno aluE=alum.buscarAlumno(48888888);
        if(aluE!=null){
        System.out.println(aluE.getDni()+"-"+aluE.getApellido()+", "+aluE.getNombre()+" - "+aluE.isActivo());
        
        }



/*        MateriaData mat=new MateriaData();
          for(Materia materia:mat.listarMaterias())}
                
              System.out.println(materia.getNombre());
  */
              }

}
