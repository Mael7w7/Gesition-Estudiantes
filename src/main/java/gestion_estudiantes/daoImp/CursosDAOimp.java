package gestion_estudiantes.daoImp;

import gestion_estudiantes.conexion.Conexion;
import gestion_estudiantes.dao.ICursosDAO;
import gestion_estudiantes.dao.IMatriculaDAO;
import gestion_estudiantes.dominio.Cursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursosDAOimp implements ICursosDAO {
    @Override
    public List<Cursos> listarcursos() {
        List<Cursos> cursos = new ArrayList<>();
        PreparedStatement ps ;
        ResultSet rs;
        String sql = "SELECT * FROM cursos";
        Connection conn = Conexion.getConexion();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cursos curso = new Cursos();
                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                cursos.add(curso);
            }
            return cursos;
        } catch (Exception e) {
            System.out.println("Error al listar cursos" + e.getMessage());
        }finally{
            try{
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar " + e.getMessage());
            }
        }
        return cursos;
    }

    @Override
    public boolean RegistrarCurso(Cursos curso) {
        PreparedStatement ps ;
        Connection conn = Conexion.getConexion();
        String sql = "INSERT INTO cursos (nombre, descripcion) VALUES (?, ?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar cursos" + e.getMessage());
        }finally{
            try{
                conn.close();

            } catch (Exception e) {
                System.out.println("Error al cerrar " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Cursos buscarCurso(int id) {
        PreparedStatement ps ;
        ResultSet rs;
        Connection conn = Conexion.getConexion();
        String sql = "SELECT * FROM cursos where id_curso = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Cursos curso = new Cursos();
                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                return curso;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cursos" + e.getMessage());
        }finally{
            try{
                conn.close();
            } catch (Exception e) {
                System.out.println("Erro al cerrar " + e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) {

        CursosDAOimp cursosDAO = new CursosDAOimp();
        Cursos curso = cursosDAO.buscarCurso(1);
        System.out.println(curso);

        System.out.println("--------------------------------------------");

        List<Cursos> cursos = cursosDAO.listarcursos();
        cursos.forEach(System.out::println);
    }
}
