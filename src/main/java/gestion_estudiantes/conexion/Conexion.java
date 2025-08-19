package gestion_estudiantes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/gestion_cursos";
        String usuario = "root";
        String clave = "admin";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);

        } catch (Exception e) {
            System.out.println("Error al conectarse : " +e.getMessage());
        }
        return con;

    }

    public static void main(String[] args) {
        Connection con = getConexion();
        if (con != null) {
        System.out.println("Conexion exitos .. " );
        }else {
            System.out.println("Error conexion ... ");
        }
    }
}
