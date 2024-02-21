package TA6;

import java.util.Scanner;

public class Ej10 {

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
		int i = 0;
		
		/* Añado la condición if al bucle, que lo cambio de un for a un do-while
		 * en el bucle añado la verificación de que sea primo, con el metodo añadido
		 * de boolean (mas adelante)
		 * Sumo +1 al contador DESPUES de añadir el valor al array, sino daria error
		 * ya que se "desbordaría" (querria añadir valor a una posición incorrecta)*/
		
		do{
			int randomNum = (int)(Math.random()* (randomMax -randomMin +1)) +randomMin;
				
				if (saber(randomNum)) {
					array[i] = randomNum;
					i++;
				}
				
		}while(i < lengthArray);
		
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
	
	
	/*Añado el metodo boolean para saber si el numero es primo
	 * del ejericio 3. */
	
	public static boolean saber (int numINTRO) {
		
		if (numINTRO <= 1) {
			return false;
		}
		for (int contador = 2; contador <=Math.sqrt(numINTRO); contador++) { 
			if (numINTRO % contador == 0) {
				return false;
					}
			}
		return true;
		
		}

}
