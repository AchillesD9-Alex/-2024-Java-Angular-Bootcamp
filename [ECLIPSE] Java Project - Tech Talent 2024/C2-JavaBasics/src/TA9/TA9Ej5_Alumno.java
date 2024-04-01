package TA9;

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

	public int generarNota() {
		return (int) (1 + Math.random() * 10);
	}

	@Override
	// 50% true 50% false
	public boolean estaAusente() {
		int random = (int) (Math.random() * 2);
		//System.out.println("Alumno ausente: " + random);
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