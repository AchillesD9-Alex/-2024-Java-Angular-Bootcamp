package TA18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TA18_Ej04_peliculas_salas {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/peliculas_salas?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Server Connected");

            insertarPeliculas(conexion);
            insertarSalas(conexion);

            conexion.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con mi base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarPeliculas(Connection conexion) throws SQLException {
        String insertPeliculasQuery = "INSERT INTO peliculas (cod_pelicula, nombre, cal_edad) VALUES " +
                "(16, 'Tin tin', 18), " +
                "(12, 'Aquaman', 12), " +
                "(13, 'Dune 2', 15), " +
                "(14, 'El viaje de Chihiro', 12), " +
                "(15, 'Transformers', 18)";
        
        PreparedStatement statement = conexion.prepareStatement(insertPeliculasQuery);
        statement.executeUpdate();
        System.out.println("Registros insertados en la tabla peliculas");
        statement.close();
    }

    private static void insertarSalas(Connection conexion) throws SQLException {
        String insertSalasQuery = "INSERT INTO salas (cod_sala, nombre, cod_pelicula) VALUES " +
                "('S12', 'Sala de Comics', 12), " +
                "('S13', 'Sala de DC', 13), " +
                "('S14', 'Sala de la siesta', 14), " +
                "('S15', 'Sala old-school JP', 15), " +
                "('S16', 'Sala MK.2', 16)";
        
        PreparedStatement statement = conexion.prepareStatement(insertSalasQuery);
        statement.executeUpdate();
        System.out.println("Registros insertados en la tabla salas");
        statement.close();
    }
}


