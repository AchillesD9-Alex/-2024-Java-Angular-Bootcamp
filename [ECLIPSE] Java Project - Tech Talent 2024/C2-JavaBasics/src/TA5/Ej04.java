package TA5;

import java.util.Scanner;

public class Ej04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Crea entrada de datos al sistema
		
		System.out.println("Vamos a calcular el área de un círculo.");
		System.out.println("Por favor, introduce el valor del radio (r):");
		
		String initialR = sc.nextLine(); //Crea el String para introducir el radio
		
		sc.close(); //Cierra la entrada de datos
		
		double r = Double.parseDouble(initialR); /*Genera double r, que es el radio
		que hemos introducido a través de consola, usando Double.parseDouble(String)*/
		
		double area = (Math.PI * Math.pow(r,  2)); /*Llama a Math para obtener Pi
			y calcular la potencia que queramos de aquello de que le digamos */
		
		System.out.println("\nEl valor del área es " + area );
		
	}

}
