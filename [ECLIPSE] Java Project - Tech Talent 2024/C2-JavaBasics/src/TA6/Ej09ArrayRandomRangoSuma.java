package TA6;

import java.util.Scanner;

public class Ej09ArrayRandomRangoSuma {
	/* Crea un array cuya longitud sea entrada por teclado
	 * Rellena el array mediante un metodo que genere numeros aleatorios, pero cada vez que vaya
	 * a generarse un numero, deberá de estar en un rago que el usuario introduzca.
	 * Al final, muestra el array generado.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del Array:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
			
		int[]arrayCreado = crearYrellenarArrayRANDOM(lengthIntro);
		
		System.out.print("El array creado es: ");
		imprimirArray(arrayCreado);
		System.out.println("\nLa suma de los valores del array es: " +sumaArray(lengthIntro, arrayCreado));
		
	}
	
	public static int sumaArray(int lenghtArray, int[] arrayAsumar) {
		int sumaValores = 0;
		int i = 0;
		do{
			sumaValores += arrayAsumar[i];
			i++;
		}while (lenghtArray > i);
		
	return sumaValores;	
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
