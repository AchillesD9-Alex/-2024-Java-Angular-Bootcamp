package TA5;

import java.util.Scanner;

public class Ej11 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- Iniciando DIAS DE LA SEMANA --");
		System.out.println("Por favor, introduce dia deseado (sin tilde):");
		
		String dia = sc.nextLine();
		
		sc.close();
		
		switch (dia){
		
		case "Lunes":
			System.out.println("Hoy es " + dia + ". Es laboral (excepto peluquerías).");
			break;
		case "Martes":
			System.out.println("Hoy es " + dia + ". Es laboral.");
			break;
		case "Miercoles":
			System.out.println("Hoy es " + dia + ". Es laboral.");
			break;
		case "Jueves":
			System.out.println("Hoy es " + dia + ". Es laboral.");
			break;
		case "Viernes":
			System.out.println("Hoy es " + dia + ". Es laboral.");
			break;
		case "Sabado":
			System.out.println("Hoy es " + dia + ". Generalmente, es festivo.");
			break;
		case "Domingo":
			System.out.println("Hoy es " + dia + ". Mayoritariamente es festivo.");
			break;
		
			default: System.out.println("No has introducido un dia correcto;"
					+ " recuerda NO poner tilde.");
		}
		
	}

}
