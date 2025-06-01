package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionA {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=NutricionBD;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASS = "1234";

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de SQL Server.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la conexión SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}