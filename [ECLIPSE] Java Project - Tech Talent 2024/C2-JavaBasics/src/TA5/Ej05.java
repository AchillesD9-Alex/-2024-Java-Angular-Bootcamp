package TA5;

import java.util.Scanner;

public class Ej05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Crea entrada de datos al sistema
		
		System.out.println("¿Será divisible entre 2 el número que quieres?.");
		System.out.println("Por favor, introduce número que quieras comprobar:");
		
		String initialNUM = sc.nextLine(); //Crea el String para introducir el número deseado
		
		sc.close(); //Cierra la entrada de datos
		
		double num = Double.parseDouble(initialNUM); /*Genera double num*/
		
		double resto = (num % 2);
		
		if (resto == 0) {
			System.out.println("\n¡Tu número (" + num + ") es divisible por 2!");
		}else{
			System.out.println("\nVaya... el número que has seleccionado (" + num +
					") no es divisble por 2...");
		}
		
	}

}
