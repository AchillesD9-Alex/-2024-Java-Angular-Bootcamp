package TA6;

import java.util.Scanner;

public class Ej08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del Array:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
			
		int[]arrayCreado = crearYrellenarArray(lengthIntro);
		
		imprimirArray(arrayCreado);
	}
	
	public static int[] crearYrellenarArray(int lengthArray) {
		Scanner sc = new Scanner(System.in);
			
		int array[] = new int[lengthArray];
		
		for (int i = 0; i <lengthArray; i++) {
				System.out.println("Ingresa el valor deseado a introducir al array");
				int valorDeseado = Integer.parseInt(sc.nextLine());
				array[i] = valorDeseado;
		}
	return array;
	}
	
	public static void imprimirArray (int lista[]) {
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i]);
			if (i < lista.length -1) {
				System.out.print(", ");
			}
		}
	}
	
}
