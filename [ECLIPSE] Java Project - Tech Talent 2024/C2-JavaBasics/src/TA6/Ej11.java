package TA6;

import java.util.Scanner;

public class Ej11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud de los arrays a crear:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
		
		System.out.println("Para el primer array:");
		int[]array1= crearYrellenarArrayRANDOM(lengthIntro);
		
		System.out.println("Para el segundo array:");
		int[]array2= crearYrellenarArrayRANDOM(lengthIntro);
		
		System.out.println("El primer array generado es:");
		imprimirArray(array1);
		System.out.println("\n\nEl segundo array generado es:");
		imprimirArray(array2);
		int[]array1x2 = multiplicarArrays(lengthIntro,array1, array2);
		System.out.println("\n\nEl array producto entre el primero y el segundo es:");
		imprimirArray(array1x2);
		sc.close();
	}
	
	public static int[] multiplicarArrays(int lengthArrays, int[] primerArray, int[] segundoArray) {
		
		int arrayMultiplicado[] = new int[lengthArrays];
		
		for (int i = 0; i <lengthArrays; i++) {
				arrayMultiplicado[i] = primerArray[i]*segundoArray[i];
		}
	
	return arrayMultiplicado;
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
