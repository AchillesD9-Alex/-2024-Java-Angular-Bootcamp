package TA8;

import javax.swing.JOptionPane;

public class Serie {

	// Atributos (o campos/propiedades)
	private String titulo; 
	private int temporadas;
	private boolean entregado;
	private String genero;
	private String creador;
    
//	Constructor por defecto
	public Serie() {
		this.titulo = "";
		this.temporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	}
	
//	Constructor titulo + creador
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.temporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = creador;
	}

//	Constructor TODO menos entregado
	public Serie(String titulo, int temporadas, String genero, String creador) {
		this.titulo = titulo;
		this.temporadas = temporadas;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	}

	
//	Métodos (o funciones)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	
	public boolean entregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	public String imprimirSerie() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", temporadas=" + temporadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", creador=" + creador +
                '}';
    }
}
