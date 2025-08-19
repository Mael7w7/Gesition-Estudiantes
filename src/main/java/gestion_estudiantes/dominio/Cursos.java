package gestion_estudiantes.dominio;

import java.util.Objects;

public class Cursos {
    private int idCurso;
    private String nombre;
    private String descripcion;

    public Cursos(int idCurso, String nombre, String descripcion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Cursos() {
    }

    public Cursos(int idCurso) {
        this.idCurso = idCurso;
    }

    public Cursos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cursos :{" +
                "idCurso=" + idCurso +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cursos cursos = (Cursos) o;
        return idCurso == cursos.idCurso && Objects.equals(nombre, cursos.nombre) && Objects.equals(descripcion, cursos.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombre, descripcion);
    }
}
