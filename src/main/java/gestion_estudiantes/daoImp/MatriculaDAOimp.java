package gestion_estudiantes.daoImp;

import gestion_estudiantes.conexion.Conexion;
import gestion_estudiantes.dao.IMatriculaDAO;
import gestion_estudiantes.dominio.Matriculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatriculaDAOimp implements IMatriculaDAO {
    @Override
    public List<Matriculas> listarEstudiantesPorCurso() {
        List<Matriculas> matriculas = new ArrayList<Matriculas>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM matriculas ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Matriculas matricula1 = new Matriculas();
                matricula1.setIdMaatricula(rs.getInt("id_matricula"));
                matricula1.setIdestudiante(rs.getInt("id_estudiante"));
                matricula1.setIdcurso(rs.getInt("id_curso"));
                matricula1.setFechaCreacion(rs.getDate("fecha_matricula"));
                matriculas.add(matricula1);

            }
            return matriculas;

        } catch (Exception e) {
            System.out.println("Error al listar matricula " + e.getMessage());

        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el matricula " + e.getMessage());
            }
        }
        return matriculas;
    }

    @Override
    public void registrarMatricula(Matriculas matricula) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO matriculas (id_matricula,id_estudiante,id_curso,fecha_matricula) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, matricula.getIdMaatricula());
            ps.setInt(2, matricula.getIdestudiante());
            ps.setInt(3, matricula.getIdcurso());
            ps.setTimestamp(4, new java.sql.Timestamp(matricula.getFechaCreacion().getTime()));
            ps.execute();

        } catch (Exception e) {
            System.out.println("Error al registrar matricula " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        MatriculaDAOimp matriculaDAO = new MatriculaDAOimp();
            Matriculas matricula = new Matriculas(3,3, new Date());
            matriculaDAO.registrarMatricula(matricula);
        List<Matriculas> matriculaa = matriculaDAO.listarEstudiantesPorCurso();
        matriculaa.forEach(System.out::println);
    }
}
