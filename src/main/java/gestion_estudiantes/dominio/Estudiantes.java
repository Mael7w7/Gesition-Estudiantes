package gestion_estudiantes.dominio;

import java.util.Objects;

public class Estudiantes {
    private int idEstudiante;
    private String nombre;
    private String email;

    //contructor
    public Estudiantes() {
    }

    //contructor para agregar
    public Estudiantes(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //contructor con todos
    public Estudiantes(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    //contructor con todos
    public Estudiantes(int idEstudiante, String nombre, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.email = email;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //metodo toString

    @Override
    public String toString() {
        return "Estudiantes : {" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estudiantes that = (Estudiantes) o;
        return idEstudiante == that.idEstudiante && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, nombre, email);
    }
}
