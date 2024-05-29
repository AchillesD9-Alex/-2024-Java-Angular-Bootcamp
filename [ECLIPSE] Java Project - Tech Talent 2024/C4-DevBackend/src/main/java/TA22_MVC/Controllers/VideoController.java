package TA22_MVC.Controllers;

import TA22_MVC.Models.Video;
import TA22_MVC.Views.VideoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoController {
    private Video modelo;
    private VideoView vista;
    private Connection connection;

    public VideoController(Video modelo, VideoView vista, Connection connection) {
        this.modelo = modelo;
        this.vista = vista;
        this.connection = connection;
    }

    public void agregarVideo() {
        String query = "INSERT INTO videos (titulo, director, cli_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, modelo.getTitulo());
            statement.setString(2, modelo.getDirector());
            statement.setInt(3, modelo.getClienteId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarVideo() {
        String query = "UPDATE videos SET titulo = ?, director = ?, cli_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, modelo.getTitulo());
            statement.setString(2, modelo.getDirector());
            statement.setInt(3, modelo.getClienteId());
            statement.setInt(4, modelo.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVideo() {
        String query = "DELETE FROM videos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, modelo.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Video buscarVideo(int idVideo) {
        String query = "SELECT * FROM videos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idVideo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Video(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo"),
                        resultSet.getString("director"),
                        resultSet.getInt("cli_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
