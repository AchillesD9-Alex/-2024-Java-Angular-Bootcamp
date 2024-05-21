package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej06_piezas_proveedores 
{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/piezas_proveedores?useTimezone=true&serverTimezone=UTC",
                    "root", "");
            System.out.println("Server Connected");

            // Insertar registros en la tabla piezas
            insertarPiezas(conexion);

            // Insertar registros en la tabla proveedores
            insertarProveedores(conexion);

            // Insertar registros en la tabla suministra
            insertarSuministra(conexion);

            conexion.close(); // Cerrar la conexión después de usarla
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con mi base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarPiezas(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        // Consulta de inserción para varios registros en la tabla piezas
        String insertPiezasQuery = "INSERT INTO piezas (nombre) VALUES " +
                "('taladro'), " +
                "('cuchilla'), " +
                "('bisturi'), " +
                "('botella'), " +
                "('trompeta')";

        stmt.executeUpdate(insertPiezasQuery);

        System.out.println("Registros insertados en la tabla piezas");

        stmt.close();
    }

    private static void insertarProveedores(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        // Consulta de inserción para varios registros en la tabla proveedores
        String insertProveedoresQuery = "INSERT INTO proveedores (id_proveedor, nombre) VALUES " +
                "('1500', 'Bosch'), " +
                "('2500', 'Samsung Electronics'), " +
                "('3500', 'LG Electronics'), " +
                "('4500', 'Sony Corporation'), " +
                "('5500', 'Lenovo Group Ltd.')";

        stmt.executeUpdate(insertProveedoresQuery);

        System.out.println("Registros insertados en la tabla proveedores");

        stmt.close();
    }

    private static void insertarSuministra(Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();

        // Consulta de inserción para varios registros en la tabla suministra
        String insertSuministraQuery = "INSERT INTO suministra (precio, cod_pieza, id_proveedor) VALUES " +
                "(10, '11','1500' ), " +
                "(15, '12', '2500'), " +
                "(20, '13', '3500'), " +
                "(25, '14', '4500'), " +
                "(30, '15', '5500')";

        stmt.executeUpdate(insertSuministraQuery);

        System.out.println("Registros insertados en la tabla suministra");

        stmt.close();
    }
}



