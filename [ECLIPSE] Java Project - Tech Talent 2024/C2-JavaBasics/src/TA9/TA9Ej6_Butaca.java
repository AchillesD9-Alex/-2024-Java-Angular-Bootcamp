package TA9;

public class TA9Ej6_Butaca {

	private int fila;
	private char columna;
	private boolean ocupada;

	public TA9Ej6_Butaca() {
		this.fila = 1;
		this.columna = 'A';
		this.ocupada = false;
	}

	public TA9Ej6_Butaca(int fila, char columna,
				boolean ocupada) {
		this.fila = fila;
		this.columna = columna;
		this.ocupada = ocupada;
	}

	public int getfila() {
		return fila;
	}

	public void setfila(int fila) {
		this.fila = fila;
	}

	public char getcolumna() {
		return columna;
	}

	public void setcolumna(char columna) {
		this.columna = columna;
	}

	public boolean ifOcupada() {
		return ocupada;
	}

	public void ocuparTA9Ej6_Butaca() {
		this.ocupada = true;
	}

	@Override
	public String toString() {
		return "TA9Ej6_Butaca [fila=" + fila + ", columna=" + columna + ", ocupada=" + ocupada + "]";
	}

}