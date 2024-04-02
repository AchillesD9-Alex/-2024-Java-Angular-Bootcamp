package TA9;

import TA9.TA9Ej5_Materia.Materia;
import TA9.TA9Ej5_Sexo.Sexo;

public class TA9Ej5_MainApp {

	public static void main(String[] args) {

		TA9Ej5_Profesor prof1 = new TA9Ej5_Profesor("Vicente", 50, Sexo.H, Materia.matemáticas);
		TA9Ej5_Profesor prof2 = new TA9Ej5_Profesor("Ana", 42, Sexo.M, Materia.filosofía);
		TA9Ej5_Profesor prof3 = new TA9Ej5_Profesor("Arnau", 38, Sexo.H, Materia.física);

		TA9Ej5_Alumno alumno1 = new TA9Ej5_Alumno("Paco", 20, Sexo.H);
		TA9Ej5_Alumno alumno2 = new TA9Ej5_Alumno("Vanesa", 21, Sexo.M);
		TA9Ej5_Alumno alumno3 = new TA9Ej5_Alumno("Miguel", 22, Sexo.H);
		TA9Ej5_Alumno alumno4 = new TA9Ej5_Alumno("Marta", 23, Sexo.M);
		TA9Ej5_Alumno alumno5 = new TA9Ej5_Alumno("Fernando", 24, Sexo.H);
		TA9Ej5_Alumno alumno6 = new TA9Ej5_Alumno("Carla", 24, Sexo.M);
		TA9Ej5_Alumno alumno7 = new TA9Ej5_Alumno("Juan", 23, Sexo.H);
		TA9Ej5_Alumno alumno8 = new TA9Ej5_Alumno("Carmen", 22, Sexo.M);
		TA9Ej5_Alumno alumno9 = new TA9Ej5_Alumno("Albert", 21, Sexo.H);
		TA9Ej5_Alumno alumno10 = new TA9Ej5_Alumno("Marina", 20, Sexo.M);

		TA9Ej5_Alumno[] alumnos = { alumno1, alumno2, alumno3, alumno4, alumno5, alumno6,
				alumno7, alumno8, alumno9, alumno10 };

		TA9Ej5_Aula aula1 = new TA9Ej5_Aula(1, 10, Materia.matemáticas,
											(TA9Ej5_Alumno[]) alumnos, (TA9Ej5_Profesor) prof1);
		TA9Ej5_Aula aula2 = new TA9Ej5_Aula(2, 10, Materia.filosofía,
											(TA9Ej5_Alumno[]) alumnos, (TA9Ej5_Profesor) prof2);
		TA9Ej5_Aula aula3 = new TA9Ej5_Aula(3, 10, Materia.física,
											(TA9Ej5_Alumno[]) alumnos, (TA9Ej5_Profesor) prof3);
		TA9Ej5_Aula aula4 = new TA9Ej5_Aula(4, 10, Materia.física,
											(TA9Ej5_Alumno[]) alumnos, (TA9Ej5_Profesor) prof1);
		
		System.out.println("Resultados del aula 1:");
			aula1.entregarNotas();
		System.out.println("Resultados del aula 2:");
			aula2.entregarNotas();
		System.out.println("Resultados del aula 3:");
			aula3.entregarNotas();
		System.out.println("Resultados del aula 4:");
			aula4.entregarNotas();
	}



}