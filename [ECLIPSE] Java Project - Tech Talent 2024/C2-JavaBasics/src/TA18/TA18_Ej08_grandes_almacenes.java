package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej08_grandes_almacenes {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/grandes_almacenes";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            insertarCajeros(conexion);
            insertarMaquinasRegistradoras(conexion);
            insertarProductos(conexion);
            insertarVentas(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertarCajeros(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertCajerosQuery = "INSERT INTO cajeros (cod_cajero, nom_apels) VALUES " +
                "(11, 'Juan Perez'), " +
                "(12, 'Maria Gomez'), " +
                "(13, 'Carlos Sanchez'), " +
                "(14, 'Laura Fernandez'), " +
                "(15, 'Ana Martinez')";

        stmt.executeUpdate(insertCajerosQuery);

        System.out.println("Registros insertados en la tabla cajeros");

        stmt.close();
    }

    private static void insertarMaquinasRegistradoras(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertMaquinasQuery = "INSERT INTO maq_registradoras (cod_maq, piso) VALUES " +
                "(111, 1), " +
                "(112, 1), " +
                "(113, 2), " +
                "(114, 2), " +
                "(115, 3)";

        stmt.executeUpdate(insertMaquinasQuery);

        System.out.println("Registros insertados en la tabla maquinas_registradoras");

        stmt.close();
    }

    private static void insertarProductos(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertProductosQuery = "INSERT INTO productos (cod_productos, nombre, precio) VALUES " +
                "(511, 'Leche', 100), " +
                "(512, 'Huevo', 150), " +
                "(513, 'Champú', 200), " +
                "(514, 'Aceite', 250), " +
                "(515, 'Miel', 300)";

        stmt.executeUpdate(insertProductosQuery);

        System.out.println("Registros insertados en la tabla productos");

        stmt.close();
    }

    private static void insertarVentas(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        String insertVentasQuery = "INSERT INTO venta (cod_productos, cod_maq, cod_cajero) VALUES " +
                "(511, 111, 11), " +
                "(512, 112, 12), " +
                "(513, 113, 13), " +
                "(514, 114, 14), " +
                "(515, 115, 15)";

        stmt.executeUpdate(insertVentasQuery);

        System.out.println("Registros insertados en la tabla venta");

        stmt.close();
    }
}

