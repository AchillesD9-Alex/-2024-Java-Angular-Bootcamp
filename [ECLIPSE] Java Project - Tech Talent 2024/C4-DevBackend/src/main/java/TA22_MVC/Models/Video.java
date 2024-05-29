package TA22_MVC.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Video {
    private int id;
    private String titulo;
    private String director;
    private int clienteId;

    // Constructor
    public Video(int id, String titulo, String director, int clienteId) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.clienteId = clienteId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    // Métodos de acceso a datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mvc_db1";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "password";

    public static void agregarVideo(Video video) {
        String sql = "INSERT INTO videos (titulo, director, cli_id) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getDirector());
            pstmt.setInt(3, video.getClienteId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarVideo(Video video) {
        String sql = "UPDATE videos SET titulo = ?, director = ?, cli_id = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getDirector());
            pstmt.setInt(3, video.getClienteId());
            pstmt.setInt(4, video.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarVideo(int idVideo) {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idVideo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Video obtenerVideo(int idVideo) {
        String sql = "SELECT * FROM videos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idVideo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getInt("cli_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
