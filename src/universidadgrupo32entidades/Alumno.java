package universidadgrupo32entidades;

import java.time.LocalDate;

public class Alumno {

    private int IdAlumno;
    private int dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private boolean activo;

    public Alumno() {
    }
   
     public Alumno(int IdAlumno,String apellido,String nombre){
        this.IdAlumno = IdAlumno;
        this.apellido= apellido;
        this.nombre=nombre;
  }
     
    public Alumno(int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public Alumno(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }
    

    public Alumno(int IdAlumno, int dni, String apellido, String nombre, LocalDate fechaNac, boolean activo) {
        this.IdAlumno = IdAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return  dni + " - " + apellido + ", " + nombre + " - " + fechaNac ;
        
    }
     
    
}
