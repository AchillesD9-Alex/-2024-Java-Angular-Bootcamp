package TA9;

import java.util.Arrays;

import TA9.TA9Ej5_Materia.Materia;
import TA9.TA9Ej5_Sexo.Sexo;

public class TA9Ej5_Aula {

	private int id;
	private int maxEstudiantes;
	private Materia materia;
	private TA9Ej5_Alumno[] alumnos;
	private TA9Ej5_Profesor profesor;

	public TA9Ej5_Aula() {
		this.id = 0;
		this.maxEstudiantes = 10;
		this.materia = Materia.matemáticas;
		this.alumnos = new TA9Ej5_Alumno[this.maxEstudiantes];
		this.profesor = null;
	}

	public TA9Ej5_Aula(int id, int maxEstudiantes, Materia materia, TA9Ej5_Profesor profesor) {
		this.id = id;
		this.maxEstudiantes = maxEstudiantes;
		this.materia = materia;
		this.alumnos = new TA9Ej5_Alumno[maxEstudiantes];
		this.profesor = profesor;
	}

	public TA9Ej5_Aula(int id, int maxEstudiantes, Materia materia,
					TA9Ej5_Alumno[] alumnos, TA9Ej5_Profesor profesor) {
		this.id = id;
		this.maxEstudiantes = maxEstudiantes;
		this.materia = materia;
		this.alumnos = alumnos;
		this.profesor = profesor;
	}

	public boolean darClase() {
		return ((!this.profesor.estaAusente()) && (this.profesor.getMateria() == this.materia)
				&& (alumnosDisponibles()));
	}

	public boolean alumnosDisponibles() {
		int count = 0;
		for (int i = 0; i < this.alumnos.length; i++) {
			if (this.alumnos[i].estaAusente()) {
				count++;
			}
		}
		System.out.println("Hay "+ count +" alumnos ausentes de " + this.alumnos.length);
		
	return (count < (this.alumnos.length / 2));
	}

	public void entregarNotas() {
		if (darClase()) {
			System.out.println("La cantidad de alumnos permite dar clase");
			int hombresAprobados = 0, mujeresAprobadas = 0;
			for (int i = 0; i < this.alumnos.length; i++) {
				if (this.alumnos[i].getSexo() == Sexo.H) {
					if (this.alumnos[i].getNota() >= 5) {
						hombresAprobados++;
					}
				} else {
					if (this.alumnos[i].getNota() >= 5) {
						mujeresAprobadas++;
					}
				}

			}
			System.out.println("Hombres aprobados: " + hombresAprobados);
			System.out.println("Mujeres aprobadas: " + mujeresAprobadas + "\n");
		} else {
			System.out.println("No se ha podido dar clase\n");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxEstudiantes() {
		return maxEstudiantes;
	}

	public void setMaxEstudiantes(int maxEstudiantes) {
		this.maxEstudiantes = maxEstudiantes;
	}

	public Materia getTA9Ej5_Materia() {
		return materia;
	}

	public void setTA9Ej5_Materia(Materia materia) {
		this.materia = materia;
	}

	public TA9Ej5_Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(TA9Ej5_Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public TA9Ej5_Profesor getTA9Ej5_Profesor() {
		return profesor;
	}

	public void setTA9Ej5_Profesor(TA9Ej5_Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
		public String toString() {
			return "Aula [id=" + id + ", maxEstudiantes=" + maxEstudiantes +
					", materia=" + materia + ", alumnos=" + Arrays.toString(alumnos) +
					", profesor=" + profesor + "]";
	}
	
}
	