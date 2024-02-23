package TA6;

import java.util.Scanner;

public class Ej08ArrayCrearRellenarImprimir {
	/*	Crea un array de 10 posiciones de números con valores pedidos por teclado.
	 * Muestra por consola el indice y el valor al que corresponde.
	 * Haz dos métodos, uno para rellenar valores y otro para mostrar.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		En vez de fijar el array a 10 posiciones he decidido que se pida por teclado.
//		Lo he hecho para que el codigo sea mas reutilizable en el futuro.
		System.out.println("Ingresa la longitud del Array:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
			
		int[]arrayCreado = crearYrellenarArray(lengthIntro);
		
		System.out.print("El array introducido es: ");
		imprimirArray(arrayCreado);
		;
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
