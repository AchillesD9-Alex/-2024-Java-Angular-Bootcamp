package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej01_Tienda_Informatica {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Conexión establecida con éxito");

            // Crear la base de datos
            try (Statement stmt = conexion.createStatement()) {
                String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS tienda_infor";
                stmt.executeUpdate(createDatabaseQuery);
                System.out.println("Base de datos creada o ya existente: tienda_infor");

                // Usar la base de datos
                String useDatabaseQuery = "USE tienda_infor";
                stmt.executeUpdate(useDatabaseQuery);
                System.out.println("Usando la base de datos: tienda_infor");

                // Crear la tabla fabricantes
                String createFabricantesTableQuery = "CREATE TABLE IF NOT EXISTS fabricantes (" +
                        "cod_fabricantes INT, " +
                        "nombre VARCHAR(100), " +
                        "PRIMARY KEY (cod_fabricantes)" +
                        ")";
                stmt.executeUpdate(createFabricantesTableQuery);
                System.out.println("Tabla creada o ya existente: fabricantes");

                // Insertar registros en la tabla fabricantes
                String insertFabricantesQuery = "INSERT IGNORE INTO fabricantes (cod_fabricantes, nombre) VALUES " +
                        "(11, 'Leroy Merlin'), " +
                        "(12, 'Ikea'), " +
                        "(13, 'Bauhaus'), " +
                        "(14, 'Bricomart'), " +
                        "(15, 'Fesmes')";
                stmt.executeUpdate(insertFabricantesQuery);
                System.out.println("Registros insertados en la tabla fabricantes");

                // Crear la tabla articulos
                String createArticulosTableQuery = "CREATE TABLE IF NOT EXISTS articulos (" +
                        "cod_articulos INT, " +
                        "nombre VARCHAR(100), " +
                        "precio INT, " +
                        "cod_fabricantes INT, " +
                        "PRIMARY KEY (cod_articulos), " +
                        "FOREIGN KEY (cod_fabricantes) " +
                        "REFERENCES fabricantes(cod_fabricantes) " +
                        "ON DELETE SET NULL " +
                        "ON UPDATE CASCADE" +
                        ")";
                stmt.executeUpdate(createArticulosTableQuery);
                System.out.println("Tabla creada o ya existente: articulos");

                // Insertar registros en la tabla articulos
                String insertArticulosQuery = "INSERT IGNORE INTO articulos (cod_articulos, nombre, precio, cod_fabricantes) VALUES " +
                        "(112, 'Tornillo', 100, 11), " +
                        "(113, 'Arandela', 150, 12), " +
                        "(114, 'Tuerca', 200, 13), " +
                        "(115, 'Brida', 120, 14), " +
                        "(116, 'Masilla', 180, 15)";
                stmt.executeUpdate(insertArticulosQuery);
                System.out.println("Registros insertados en la tabla articulos");
            } catch (SQLException e) {
                System.err.println("Error al ejecutar las consultas SQL: " + e.getMessage());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }
}

