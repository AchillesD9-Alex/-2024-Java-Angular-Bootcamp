package TA6;

import java.util.Scanner;

public class Ej02 {
	/* Crea una aplicación que nos genere una cantidad de números enteros aleatorios que 
	nosotros le pasaremos por teclado.
	1) Crea un método donde pasamos como parámetros entre que números queremos que los genere,
	   podemos pedirlas por teclado antes de generar los números.
	2) Este método devolverá un número entero aleatorio.
	3) Muestra estos números por pantalla.
	 */
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		System.out.println(" -- Iniciando RANDOM NUM --");
		System.out.println("¿Cuantos numeros quieres generar?");
			int n = Integer.parseInt(sc.nextLine());
			
		int min = minimo();
		System.out.println("El mínimo introducido es: " +min);
		int max = maximo();
		System.out.println("El maximo introducido es: " +max);
		sc.close();
		
		System.out.println("\nLos numeros generados son:");
		randomGenerator(n, min, max);
		
	}
	
//	1) METODOS CREADOS:
	public static int minimo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cual debe de ser el MINIMO del rango?");
		int minINTRO = Integer.parseInt(sc.nextLine());
		
	return minINTRO;
	}
	
	public static int maximo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cual debe de ser el MAXIMO del rango?");
		int maxINTRO = Integer.parseInt(sc.nextLine());
		sc.close();
	return maxINTRO;
	}
	
	public static void randomGenerator(int totalNumbers, int minValue, int maxValue) {
	for(int counter = 0; counter < totalNumbers; counter++) { 
//		Genera X valores entre MIN y MAX. Luego suma MIN para llevarlo al rango
		int randomNum = ((int) (Math.random()*(maxValue - minValue + 1)) + minValue);
		System.out.print(randomNum +" ,");
		}
	}
}
