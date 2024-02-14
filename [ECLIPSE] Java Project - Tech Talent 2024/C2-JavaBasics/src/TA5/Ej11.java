package TA5;

import java.util.Scanner;

public class Ej11 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- Iniciando DIAS DE LA SEMANA --");
		System.out.println("Por favor, introduce dia deseado (sin tilde):");
		
		String dia = sc.nextLine();
		dia = dia.toUpperCase(); // Lo pasamos a MAYUS para evitar formatos de entrada
		
		sc.close();
		
		switch (dia){
		
		case "LUNES":
			System.out.println("Hoy es " + dia + ". Es laboral (excepto peluquerías).");
			break;
		case "MARTES", "MIERCOLES", "JUEVES", "VIERNES":
			System.out.println("Hoy es " + dia + ". Es laboral.");
			break;
		case "SABADO":
			System.out.println("Hoy es " + dia + ". Generalmente, es festivo.");
			break;
		case "DOMINGO":
			System.out.println("Hoy es " + dia + ". Mayoritariamente es festivo.");
			break;
		
			default: System.out.println("No has introducido un dia correcto;"
					+ " recuerda NO poner tilde.");
		}
		
	}

}
