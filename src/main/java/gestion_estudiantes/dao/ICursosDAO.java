package gestion_estudiantes.dao;

import gestion_estudiantes.dominio.Cursos;

import java.util.List;

public interface ICursosDAO {
    List<Cursos> listarcursos();
    boolean RegistrarCurso(Cursos curso);
    Cursos buscarCurso(int id);
}
