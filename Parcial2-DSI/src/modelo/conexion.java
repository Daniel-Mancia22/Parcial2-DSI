package modelo;

import java.sql.Connection; 
import java.sql.*;

public class conexion {
    String servidor = "localhost:3306";
    String baseDatos = "examen";
    String usuario = "user-parcial2";
    String clave = "123parcial2";
    String url = "jdbc:mysql://" + servidor + "/" + baseDatos;
    Connection cx;

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cx = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conectado a " + baseDatos);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendoError: " + e.getErrorCode());
        }
        return cx;
    }

    public void desconectar() {
        if (cx != null) {
            try {
                cx.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion: " + ex.getMessage());
            }
        }
    }
}