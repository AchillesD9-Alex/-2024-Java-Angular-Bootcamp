package TA22_MVC.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import TA22_MVC.Controllers.conexion_database;

public class Video {
    // Atributos del video
    private int id;
    private String title;
    private String director;
    private int cli_id;

    // Constructor vacío
    public Video() {}

    // Constructor con parámetros
    public Video(int id, String title, String director, int cli_id) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.cli_id = cli_id;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String toString() {
        return title;  // Mostrar el título del video en el JComboBox
    }
    // Métodos de acceso a datos
    public void addVideo() {
        String sql = "INSERT INTO videos (title, director, cli_id) VALUES (?, ?, ?)";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getTitle());
            stmt.setString(2, this.getDirector());
            stmt.setInt(3, this.getCli_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Video> getAllVideos() {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Video video = new Video();
                video.setId(rs.getInt("id"));
                video.setTitle(rs.getString("title"));
                video.setDirector(rs.getString("director"));
                video.setCli_id(rs.getInt("cli_id"));
                videos.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    public static Video getVideoById(int id) {
        Video video = null;
        String sql = "SELECT * FROM videos WHERE id = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    video = new Video();
                    video.setId(rs.getInt("id"));
                    video.setTitle(rs.getString("title"));
                    video.setDirector(rs.getString("director"));
                    video.setCli_id(rs.getInt("cli_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }

    public void updateVideo() {
        String sql = "UPDATE videos SET title = ?, director = ?, cli_id = ? WHERE id = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getTitle());
            stmt.setString(2, this.getDirector());
            stmt.setInt(3, this.getCli_id());
            stmt.setInt(4, this.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteVideo(int id) {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (Connection conn = conexion_database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Método para obtener todos los IDs de los videos
    public static List<Integer> getAllVideoIds() {
        List<Integer> ids = new ArrayList<>();
        try (Connection conn = conexion_database.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery("SELECT id FROM videos")) {
            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}