package TA6;

import java.util.Scanner;

public class Ej02EnunciadoClaseRandomNum {
		
	public static void main(String[] args) {
		/* 1) Preguntar CUANTOS numeros quieres
		 * 2) Establecer un método, que pida un tango, y de un numero aleatorio entero.
		  	  Se pide un rango por cada numero generado.
		 * 3) Mostrar los números generados por pantalla
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println(" -- Iniciando RANDOM NUM --");
	
		// 1)
		System.out.println("¿Cuantos numeros quieres generar?");
			int n = Integer.parseInt(sc.nextLine());
		//2) repetición de la petición del rango	
		while (n>0) {
			System.out.println("¿Cual debe de ser el MINIMO del rango?");
			int min = Integer.parseInt(sc.nextLine());
			
			System.out.println("¿Cual debe de ser el MAXIMO del rango?");
			int max = Integer.parseInt(sc.nextLine());
			// 3)
			System.out.println("Para el rango [" +min+ ", " +max+"] , el RANDOM es: " +enteroRandom(min,max));
			
			n--;
		}
		
		sc.close();
	}
	// 2) Metodo para generar el random
	public static int enteroRandom(int rango1, int rango2) {
	
		int randomNum = (int) (Math.random()* (rango2 - rango1 +1)) +rango1;
			return randomNum;
	}
	
	
	
}
