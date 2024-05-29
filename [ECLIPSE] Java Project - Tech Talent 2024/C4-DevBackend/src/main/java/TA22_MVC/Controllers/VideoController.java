package TA22_MVC.Controllers;

import TA22_MVC.Models.Video;
import TA22_MVC.Views.VideoView;

public class VideoController {
    private Video modelo;
    private VideoView vista;

    public VideoController(Video modelo, VideoView vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }

    private void initController() {
        vista.addAgregarListener(e -> agregarVideo());
        vista.addActualizarListener(e -> actualizarVideo());
        vista.addEliminarListener(e -> eliminarVideo());
        vista.addBuscarListener(e -> buscarVideo());
    }

    public void agregarVideo() {
        Video video = new Video(
            0, 
            vista.getTitulo(), 
            vista.getDirector(), 
            vista.getClienteId()
        );
        Video.agregarVideo(video);
    }

    public void actualizarVideo() {
        Video video = new Video(
            modelo.getId(), 
            vista.getTitulo(), 
            vista.getDirector(), 
            vista.getClienteId()
        );
        Video.actualizarVideo(video);
    }

    public void eliminarVideo() {
        Video.eliminarVideo(modelo.getId());
    }

    public void buscarVideo() {
        int idVideo = modelo.getId();
        Video video = Video.obtenerVideo(idVideo);
        if (video != null) {
            vista.setTitulo(video.getTitulo());
            vista.setDirector(video.getDirector());
            vista.setClienteId(video.getClienteId());
        }
    }
}
