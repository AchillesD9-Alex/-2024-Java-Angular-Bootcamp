package TA22_MVC.Ej2_Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TA22_MVC.Ej2_Controllers.conexion_database;

public class Cientifico {
    // Atributos
    private String DNI;
    private String nomApels;

    // Constructor vacío
    public Cientifico() {}

    // Constructor con parámetros
    public Cientifico(String DNI, String nomApels) {
        this.DNI = DNI;
        this.nomApels = nomApels;
    }

    // Getters y setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNomApels() {
        return nomApels;
    }

    public void setNomApels(String nomApels) {
        this.nomApels = nomApels;
    }

    // Métodos de acceso a datos
    public void addCientifico() {
        String sql = "INSERT INTO cientificos (DNI, nom_apels) VALUES (?, ?)";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getDNI());
            stmt.setString(2, this.getNomApels());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cientifico> getAllCientificos() {
        List<Cientifico> cientificos = new ArrayList<>();
        String sql = "SELECT * FROM cientificos";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cientifico cientifico = new Cientifico();
                cientifico.setDNI(rs.getString("DNI"));
                cientifico.setNomApels(rs.getString("nom_apels"));
                cientificos.add(cientifico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cientificos;
    }

    public static Cientifico getCientificoByDNI(String DNI) {
        Cientifico cientifico = null;
        String sql = "SELECT * FROM cientificos WHERE DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cientifico = new Cientifico();
                    cientifico.setDNI(rs.getString("DNI"));
                    cientifico.setNomApels(rs.getString("nom_apels"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cientifico;
    }

    public void updateCientifico() {
        String sql = "UPDATE cientificos SET nom_apels = ? WHERE DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getNomApels());
            stmt.setString(2, this.getDNI());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCientifico(String DNI) {
        String sql = "DELETE FROM cientificos WHERE DNI = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
