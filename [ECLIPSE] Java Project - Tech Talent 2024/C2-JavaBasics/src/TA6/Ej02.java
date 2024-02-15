package TA6;

import java.util.Scanner;

public class Ej02 {
		
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
			
		System.out.println(" -- Iniciando RANDOM NUM --");
	
		System.out.println("¿Cuantos numeros quieres generar?");
			int n = Integer.parseInt(sc.nextLine());
			
		int min = minimo();
		System.out.println("El mínimo introducido es: " +min);
			
			
		int max = maximo();
		System.out.println("El mínimo introducido es: " +max);
		
		sc.close();
		
		System.out.println("Los numeros generados son:");
		for(int counter = 0; counter < n; counter++) { 
			int randomNum = ((int) Math.random()*(max - min + 1) + min);
			/*Genera X valores entre MIN y MAX.	luego suma MIN para llevarlo al rango*/
			System.out.println(randomNum +" ,");
		}
		
	}
	
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
	
}
