package TA9;

import TA9.TA9Ej5_Sexo.Sexo;

public class TA9Ej5_Alumno extends TA9Ej5_Persona {

	private int nota;

	public TA9Ej5_Alumno() {
		super();
		this.nota = generarNota();
	}

	public TA9Ej5_Alumno(String nombre, int edad, Sexo sexo, int nota) {
		super(nombre, edad, sexo);
		if (nota < 0) {
			this.nota = 0;
		} else if (nota > 10) {
			this.nota = 10;
		} else {
			this.nota = nota;
		}
	}

	public TA9Ej5_Alumno(String nombre, int edad, Sexo sexo) {
		super(nombre, edad, sexo);
		this.nota = generarNota();
	}

//	Entre 0 y 10 incluidos
	public int generarNota() {
		return (int) (Math.random() * 11);
	}

	@Override
	// 50% true 50% false
	public boolean estaAusente() {
		int random = (int) (Math.random() * 2);
		return (random == 0);
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nota=" + nota + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}

}