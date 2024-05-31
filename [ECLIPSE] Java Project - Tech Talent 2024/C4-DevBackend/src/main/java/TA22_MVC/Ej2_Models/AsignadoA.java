package TA22_MVC.Ej2_Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TA22_MVC.Ej2_Controllers.conexion_database;

public class AsignadoA {
    // Atributos
    private String idProyecto;
    private String DNI;

    // Constructor vacío
    public AsignadoA() {}

    // Constructor con parámetros
    public AsignadoA(String idProyecto, String DNI) {
        this.idProyecto = idProyecto;
        this.DNI = DNI;
    }

    // Getters y setters
    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    // Métodos de acceso a datos
    public void addAsignadoA() {
        String sql = "INSERT INTO asignado_a (id_proyecto, DNI) VALUES (?, ?)";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getIdProyecto());
            stmt.setString(2, this.getDNI());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<AsignadoA> getAllAsignados() {
        List<AsignadoA> asignados = new ArrayList<>();
        String sql = "SELECT * FROM asignado_a";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                AsignadoA asignadoA = new AsignadoA();
                asignadoA.setIdProyecto(rs.getString("id_proyecto"));
                asignadoA.setDNI(rs.getString("DNI"));
                asignados.add(asignadoA);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignados;
    }

    public static AsignadoA getAsignadoById(String idProyecto, String DNI) {
        AsignadoA asignadoA = null;
        String sql = "SELECT * FROM asignado_a WHERE id_proyecto = ? AND DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProyecto);
            stmt.setString(2, DNI);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    asignadoA = new AsignadoA();
                    asignadoA.setIdProyecto(rs.getString("id_proyecto"));
                    asignadoA.setDNI(rs.getString("DNI"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignadoA;
    }

    public void updateAsignadoA() {
        String sql = "UPDATE asignado_a SET id_proyecto = ?, DNI = ? WHERE id_proyecto = ? AND DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getIdProyecto());
            stmt.setString(2, this.getDNI());
            stmt.setString(3, this.getIdProyecto());
            stmt.setString(4, this.getDNI());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAsignadoA(String idProyecto, String DNI) {
        String sql = "DELETE FROM asignado_a WHERE id_proyecto = ? AND DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProyecto);
            stmt.setString(2, DNI);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
