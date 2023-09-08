
package universidadgrupo32entidades;

public class Inscripcion {
    private int IdInscripcion;
    private Materia materia;
    private Alumno alumno;
    private double nota;

    public Inscripcion() {
    }

    public Inscripcion(Materia materia, Alumno alumno, double nota) {
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Inscripcion(int IdInscripcion, Materia materia, Alumno alumno, double nota) {
        this.IdInscripcion = IdInscripcion;
        this.materia = materia;
        this.alumno = alumno;
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return IdInscripcion;
    }

    public void setIdInscripcion(int IdInscripcion) {
        this.IdInscripcion = IdInscripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String insc= alumno.getApellido()+", "+alumno.getNombre()+" - "+materia.getNombre()+" "+materia.getAnio();
        return insc;
    }
    
    
}
