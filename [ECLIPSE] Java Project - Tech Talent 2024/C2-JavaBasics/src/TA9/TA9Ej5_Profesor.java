package TA9;

import TA9.TA9Ej5_Materia.Materia;
import TA9.TA9Ej5_Sexo.Sexo;

public class TA9Ej5_Profesor extends TA9Ej5_Persona {

	private Materia materia;
	private Sexo sexo;

	public TA9Ej5_Profesor() {
		super();
		this.materia = Materia.matemáticas;
	}

	public TA9Ej5_Profesor(String nombre, int edad, Sexo sexo, Materia materia) {
		super(nombre, edad, sexo);
		this.materia = materia;

	}

	@Override
	// 20% true 80% false
	public boolean estaAusente() {
		int random = (int) (Math.random() * 5);
		//System.out.println("Profesor ausente: " + random);
		return (random == 0);
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Profesor [materia=" + materia + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + "]";
	}

	

}