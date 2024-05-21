package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TA18_Ej02_Empleados 
{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/empleados_db?useTimezone=true&serverTimezone=UTC", "root", "");

            System.out.println("Conexión establecida");

            // Insertar registros en la tabla departamentos
            insertarDepartamentos(conexion);

            // Insertar registros en la tabla empleados
            insertarEmpleados(conexion);

            // Cerrar la conexión
            conexion.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    public static void insertarDepartamentos(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        // Consulta de inserción para varios registros en la tabla departamentos
        String insertDepartamentosQuery = "INSERT IGNORE INTO departamentos (cod_departamento, nombre, presupuesto) VALUES " +
                "(12, 'Facturación', 50000), " +
                "(13, 'Estrategia empresarial', 60000), " +
                "(14, 'Soporte TIC', 80000), " +
                "(15, '', 55000), " +
                "(16, 'Contabilidad', 70000)";
        
        stmt.executeUpdate(insertDepartamentosQuery);
        
        System.out.println("Registros insertados en la tabla departamentos");

        stmt.close();
    }

    public static void insertarEmpleados(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        // Consulta de inserción para varios registros en la tabla empleados
        String insertEmpleadosQuery = "INSERT INTO empleados (dni, nombre, apellidos, cod_departamento) VALUES " +
                "('1234678A', 'Juan', 'Pérez', 16), " +
                "('2346789B', 'María', 'López', 12), " +
                "('3467890C', 'Pedro', 'Gómez', 13), " +
                "('4678901D', 'Ana', 'Martínez', 14), " +
                "('6789012E', 'Carlos', 'Sánchez', 15)";

        stmt.executeUpdate(insertEmpleadosQuery);

        System.out.println("Registros insertados en la tabla empleados");

        stmt.close();
    }
}



