package gestion_estudiantes.dao;

import gestion_estudiantes.dominio.Cursos;
import gestion_estudiantes.dominio.Estudiantes;
import gestion_estudiantes.dominio.Matriculas;

import java.util.List;

public interface IMatriculaDAO {
    List<Matriculas> listarEstudiantesPorCurso();
    void registrarMatricula(Matriculas matricula);



}
