package TA22_MVC.MainApp;

import TA22_MVC.Controllers.ClienteController;
import TA22_MVC.Controllers.VideoController;
import TA22_MVC.Models.Cliente;
import TA22_MVC.Models.Video;
import TA22_MVC.Views.ClienteView;
import TA22_MVC.Views.VideoView;

public class TA22_Main {
    public static void main(String[] args) {
        // Crear el modelo
        Cliente modeloCliente = new Cliente(0, "", "", "", 0, null);
        Video modeloVideo = new Video(0, "", "", 0);

        // Crear la vista
        ClienteView vistaCliente = new ClienteView();
        VideoView vistaVideo = new VideoView();

        // Crear el controlador
        ClienteController clienteController = new ClienteController(modeloCliente, vistaCliente);
        VideoController videoController = new VideoController(modeloVideo, vistaVideo);

        // Inicializar la vista
        vistaCliente.setVisible(true);
        vistaVideo.setVisible(true);
    }
}
