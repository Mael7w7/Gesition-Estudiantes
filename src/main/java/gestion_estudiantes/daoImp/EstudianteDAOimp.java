package gestion_estudiantes.daoImp;

import gestion_estudiantes.conexion.Conexion;
import gestion_estudiantes.dao.IEstudianteDAO;
import gestion_estudiantes.dominio.Estudiantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class EstudianteDAOimp implements IEstudianteDAO {

    @Override
    public List<Estudiantes> listarEstudiantes() {
        List<Estudiantes> estudiantes = new ArrayList<Estudiantes>();
        PreparedStatement ps ;
        ResultSet rs ;
        Connection conn = Conexion.getConexion();
        String sql = "SELECT * FROM estudiantes";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Estudiantes estudiante = new Estudiantes();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);

            }
            return estudiantes;
        } catch (Exception e) {
            System.out.println("Error al consultar estudiantes" + e.getMessage());
        } finally {
            try{
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar estudiantes" + e.getMessage());
            }
        }
        return estudiantes;
    }

    @Override
    public Estudiantes buscarPorId(int id) {
        PreparedStatement ps ;
        ResultSet rs ;
        Connection conn = Conexion.getConexion();
        String sql = "SELECT * FROM estudiantes WHERE id_estudiante = ?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Estudiantes estudiante = new Estudiantes();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setEmail(rs.getString("email"));
                return estudiante;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar estudiantes" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean RegistrarEstudiante(Estudiantes estudiante) {
        PreparedStatement ps ;
        Connection conn = Conexion.getConexion();
        String sql = "INSERT INTO estudiantes (nombre,email) VALUES (?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar estudiante" + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        EstudianteDAOimp estudiante = new EstudianteDAOimp();
        Estudiantes estudiantes = new Estudiantes("Camila","amor@gmail.com");
        estudiante.RegistrarEstudiante(estudiantes);
        System.out.println("-------------------------------------------");
        List<Estudiantes> listaestudiantes = estudiante.listarEstudiantes();
        listaestudiantes.forEach(System.out::println);
    }
}
