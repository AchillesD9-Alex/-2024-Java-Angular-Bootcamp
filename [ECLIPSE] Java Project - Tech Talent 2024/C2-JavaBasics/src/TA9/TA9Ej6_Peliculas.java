package TA9;

public class TA9Ej6_Peliculas {

	private String titulo;
	private int duracion;
	private int edadMinima;
	private String director;

	public TA9Ej6_Peliculas() {
		this.titulo = "título";
		this.duracion = 60;
		this.edadMinima = 18;
		this.director = "director";
	}

	public TA9Ej6_Peliculas(String titulo, int duracion, int edadMinima, String director) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "TA9Ej6_Peliculas [titulo=" + titulo + ", duracion=" + duracion + ", edadMinima=" + edadMinima + ", director=" + director
				+ "]";
	}

}