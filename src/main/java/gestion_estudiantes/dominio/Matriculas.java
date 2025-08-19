package gestion_estudiantes.dominio;

import java.util.Date;
import java.util.Objects;

public class Matriculas {
    private int idMaatricula;
    private int idestudiante;
    private int idcurso;
    private Date fechaCreacion;

    public Matriculas() {
    }

    public Matriculas(int idestudiante, int idcurso, Date fechaCreacion) {
        this.idestudiante = idestudiante;
        this.idcurso = idcurso;
        this.fechaCreacion = fechaCreacion;
    }

    public Matriculas(int idMaatricula, int idestudiante, int idcurso, Date fechaCreacion) {
        this.idMaatricula = idMaatricula;
        this.idestudiante = idestudiante;
        this.idcurso = idcurso;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdMaatricula() {
        return idMaatricula;
    }

    public void setIdMaatricula(int idMaatricula) {
        this.idMaatricula = idMaatricula;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Matriculas{" +
                "idMaatricula=" + idMaatricula +
                ", idestudiante=" + idestudiante +
                ", idcurso=" + idcurso +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Matriculas that = (Matriculas) o;
        return idMaatricula == that.idMaatricula && idestudiante == that.idestudiante && idcurso == that.idcurso && Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMaatricula, idestudiante, idcurso, fechaCreacion);
    }
}
