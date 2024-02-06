package TA5;

import java.util.Scanner;

public class Ej3Console {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Crea entrada de datos al sistema
		
		System.out.println(" -- Iniciando JAVA --");
		System.out.println("Por favor, introduce tu nombre:");
		
		String name = sc.nextLine(); //Crea el String para introducir el nombre de usuario
		sc.close(); //Cierra la entrada de datos
		
		System.out.println("Hola, " + name.toUpperCase() + //Cambia el nombre introducidoa  MAYUS
				".\n¡Bienvenido!");
		
	}
}
