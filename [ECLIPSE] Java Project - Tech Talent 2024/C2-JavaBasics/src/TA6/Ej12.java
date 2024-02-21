package TA6;

import java.util.Scanner;

public class Ej12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del array a crear:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
		
		int[]arrayCreado= crearYrellenarArrayRANDOM(lengthIntro);
		
		System.out.println("El array creado es:");
		imprimirArray(arrayCreado);
		System.out.println("\n¿Que ultimo digito quieres chequear?");
		String num2checkIntro = sc.nextLine();
		checkArray(arrayCreado, num2checkIntro);
		sc.close();
	}
	
	
	
	public static int[] crearYrellenarArrayRANDOM(int lengthArray) {
		Scanner sc = new Scanner(System.in);
		
		int array[] = new int[lengthArray];
		
		for (int i = 0; i <lengthArray; i++) {
				int randomNum = (int)(Math.random()* (300 - 1 +1)) +1;
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
	

	public static void checkArray (int array2check[], String num2check) {
		System.out.println("Los numeros cuyo ultimo digito es " +num2check+ " son:");
		for (int i = 0; i < array2check.length; i++) {
			String checkPosition = String.valueOf(array2check[i]);
			char lastDigit = checkPosition.charAt(checkPosition.length() -1);
			
			if (String.valueOf(lastDigit).equals(num2check)) {
				System.out.print("\n" +checkPosition);
			}

		}
	}
	
	
}
