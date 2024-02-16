package TA6;

import java.util.Scanner;

public class Ej09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del Array:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
			
		int[]arrayCreado = crearYrellenarArrayRANDOM(lengthIntro);
		
		imprimirArray(arrayCreado);
	}
	
	public static int[] crearYrellenarArrayRANDOM(int lengthArray) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el valor minimo de numero aleatorio:");
			int randomMin = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el valor máximo de numero aleatorio:");
			int randomMax = Integer.parseInt(sc.nextLine());
		
		int array[] = new int[lengthArray];
		
		for (int i = 0; i <lengthArray; i++) {
				int randomNum = (int)(Math.random()* (randomMax -randomMin +1)) +randomMin;
				array[i] = randomNum;
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
