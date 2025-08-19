package gestion_estudiantes.dao;

import gestion_estudiantes.dominio.Estudiantes;

import java.util.List;

public interface IEstudianteDAO {
    List<Estudiantes> listarEstudiantes();
    Estudiantes buscarPorId(int id);
    boolean RegistrarEstudiante(Estudiantes estudiante);

}
