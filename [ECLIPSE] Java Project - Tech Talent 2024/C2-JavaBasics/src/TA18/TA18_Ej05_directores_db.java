package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej05_directores_db {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/directores_db?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Server Connected");

            insertarDespachos(conexion);
            insertarDirectores(conexion);

            conexion.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarDespachos(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        // Consulta de inserción para varios registros en la tabla despachos
        String insertDespachosQuery = "INSERT INTO despachos (num_despacho, capacidad) VALUES " +
        		 "(11, 6), " +
                 "(12, 6), " +
                 "(13, 6), " +
                 "(14, 6), " +
                 "(15, 6)";

        stmt.executeUpdate(insertDespachosQuery);

        System.out.println("Registros insertados en la tabla despachos");

        stmt.close();
    }

    private static void insertarDirectores(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        // Consulta de inserción para varios registros en la tabla directores
        String insertDirectoresQuery = "INSERT INTO directores (DNI, nom_apels, DNI_jefe, num_despacho) VALUES " +
                "('23466', 'Defer, Gervasio', NULL, 11), " +
                "('33456', 'Fuertes, Dolores', NULL, 12), " +
                "('43456', 'Tilla, Aitor', NULL, 13), " +
                "('53456', 'Porada, Eva', NULL, 14), " +
                "('73456', 'Colero, Esther', NULL, 15)";

        stmt.executeUpdate(insertDirectoresQuery);

        System.out.println("Registros insertados en la tabla directores");

        stmt.close();
    }
}


