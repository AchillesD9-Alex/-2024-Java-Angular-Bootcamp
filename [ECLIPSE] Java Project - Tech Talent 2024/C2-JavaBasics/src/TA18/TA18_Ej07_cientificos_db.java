package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej07_cientificos_db {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cientificos_db?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conexión establecida con la base de datos");

            insertarCientificos(conexion);
            insertarProyecto(conexion);
            insertarAsignadoA(conexion);

            conexion.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarCientificos(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertCientificosQuery = "INSERT INTO cientificos (DNI, nom_apels) VALUES " +
                "('11345678', 'John Doe'), " +
                "('22456789', 'Jane Smith'), " +
                "('33567890', 'Alice Johnson'), " +
                "('44678901', 'Bob Brown'), " +
                "('55789012', 'Eva Martinez')";

        stmt.executeUpdate(insertCientificosQuery);

        System.out.println("Registros insertados en la tabla cientificos");

        stmt.close();
    }

    private static void insertarProyecto(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertProyectoQuery = "INSERT INTO proyecto (id_proyecto, nombre, horas) VALUES " +
                "('PR11', 'Proyecto Alma', 100), " +
                "('PR12', 'Proyecto Bocachancla', 150), " +
                "('PR13', 'Proyecto Carretera', 200), " +
                "('PR14', 'Proyecto Dedal', 120), " +
                "('PR15', 'Proyecto StereoHearts', 180)";

        stmt.executeUpdate(insertProyectoQuery);

        System.out.println("Registros insertados en la tabla proyecto");

        stmt.close();
    }

    private static void insertarAsignadoA(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertAsignadoAQuery = "INSERT INTO asignado_a (DNI, id_proyecto) VALUES " +
                "('11345678', 'PR11'), " +
                "('22456789', 'PR12'), " +
                "('33567890', 'PR13'), " +
                "('44678901', 'PR14'), " +
                "('55789012', 'PR15')";

        stmt.executeUpdate(insertAsignadoAQuery);

        System.out.println("Registros insertados en la tabla asignado_a");

        stmt.close();
    }
}