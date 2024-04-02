package TA9;

public class TA9Ej6_Cine {

	private TA9Ej6_Peliculas pelicula;
	private double precio;
	private int filas;
	private int columnas;

	public TA9Ej6_Cine() {
		this.pelicula = new TA9Ej6_Peliculas();
		this.precio = 10;
		this.filas = 8;
		this.columnas = 8;
	}

	public TA9Ej6_Cine(TA9Ej6_Peliculas pelicula, double precio, int filas, int columnas) {
		this.pelicula = pelicula;
		this.precio = precio;
		this.filas = filas;
		this.columnas = columnas;
	}

	public void dibujarTA9Ej6_Cine() {
		for (int i = this.filas; i > 0; i--) {
			for (int j = 0; j < this.columnas; j++) {
				char c = (char) (65 + j);
				System.out.print(Integer.toString(i) + c + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public TA9Ej6_Peliculas getTA9Ej6_Peliculas() {
		return pelicula;
	}

	public void setTA9Ej6_Peliculas(TA9Ej6_Peliculas pelicula) {
		this.pelicula = pelicula;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	@Override
	public String toString() {
		return "TA9Ej6_Cine [pelicula=" + pelicula + ", precio=" + precio + ", filas=" + filas + ", columnas=" + columnas
				+ "]";
	}

}