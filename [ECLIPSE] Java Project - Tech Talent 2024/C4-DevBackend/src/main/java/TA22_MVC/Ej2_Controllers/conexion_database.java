package TA22_MVC.Ej2_Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion_database {
    private static final String URL = "jdbc:mysql://localhost:3306/cientificos_db"; // URL de la base de datos
    private static final String USER = "root"; // Nombre de usuario de la base de datos
    private static final String PASSWORD = ""; // Contraseña de la base de datos

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase del driver no encontrada");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Probar la conexión
        Connection conn = conexion_database.getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
