package TA6;

import java.util.Scanner;

public class Ej10ArrayRandomMayorNum {
	/* Crea un array de tamaño pedido por teclado.
	 * El array contendrá numeros aleatorios primos entre un rango deseado.
	 * Devuelve por consola el numero primo mayor que se haya generado.
	 * Comprueba que el numero sea primo. 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del Array:");
			int lengthIntro = Integer.parseInt(sc.nextLine());
			
		int[]arrayCreado = crearYrellenarArrayRANDOM(lengthIntro);
		
		System.out.print("El array generado es: ");
		imprimirArray(arrayCreado);
		
		System.out.print("\nEl numero primo mas grande que contiene es: " +mayorNum(arrayCreado));
		
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
	
	public static int mayorNum (int[] arrayEscogido) {
//	Comparamos todas las posiciones del array; suponemos que el primer valor es el mas grande.
//	Iremos sobreescribiendo el valor segun si encontramos uno que sea mayor al actual o no.
		int max = arrayEscogido[0];
		for (int i = 1; i < arrayEscogido.length; i++) {
	        if (arrayEscogido[i] > max) {
	            max = arrayEscogido[i];
	        }
		}
	    return max;
	}

}
