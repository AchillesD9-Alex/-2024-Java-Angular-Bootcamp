package TA22_MVC.Models;

public class Video {
    private int id;
    private String titulo;
    private String director;
    private int clienteId;

    public Video(int id, String titulo, String director, int clienteId) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.clienteId = clienteId;
    }
    
    public Video() {
    	
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
}
