package TA22_MVC.MainApp;

import TA22_MVC.Controllers.ClienteController;
import TA22_MVC.Controllers.VideoController;
import TA22_MVC.Models.Cliente;
import TA22_MVC.Models.Video;
import TA22_MVC.Views.ClienteView;
import TA22_MVC.Views.VideoView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TA22_Main {
    public static void main(String[] args) {
        // Conexión a la base de datos
        String jdbcUrl = "jdbc:mysql://localhost:3306/mvc_db1";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            // Creación del modelo y la vista para Cliente
            Cliente modeloCliente = new Cliente();
            ClienteView vistaCliente = new ClienteView();
            ClienteController controladorCliente = new ClienteController(modeloCliente, vistaCliente, connection);

            // Creación del modelo y la vista para Video
            Video modeloVideo = new Video();
            VideoView vistaVideo = new VideoView();
            VideoController controladorVideo = new VideoController(modeloVideo, vistaVideo, connection);

            // Configuración de listeners para Cliente
            vistaCliente.addAgregarListener(e -> controladorCliente.agregarCliente());
            vistaCliente.addActualizarListener(e -> controladorCliente.actualizarCliente());
            vistaCliente.addEliminarListener(e -> controladorCliente.eliminarCliente());
            vistaCliente.addBuscarListener(e -> {
            	int idCliente = vistaCliente.getId();
                controladorCliente.buscarCliente(idCliente);
            });

            // Configuración de listeners para Video
            vistaVideo.addAgregarListener(e -> controladorVideo.agregarVideo());
            vistaVideo.addActualizarListener(e -> controladorVideo.actualizarVideo());
            vistaVideo.addEliminarListener(e -> controladorVideo.eliminarVideo());
            vistaVideo.addBuscarListener(e -> {
            	int idVideo = vistaVideo.getId();
                controladorVideo.buscarVideo(idVideo);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
