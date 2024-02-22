package TA6;

import java.util.Scanner;

public class Ej03EsPrimoMetodo {
		
	public static void main(String[] args) {
		/* Escribe un programa que dado un número, calcule si es primo o no.
		Un número primo es un número natural mayor que 1 que tiene únicamente
		dos divisores distintos: él	mismo y el 1*/
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¿SERA PRIMO? --");
		System.out.println("Por favor, introduce el número entero deseado:");
		boolean primo = saber ( Integer.parseInt ( sc.nextLine() ) );
		
		if (primo){
			System.out.println("El número escogido es primo.");
			}else {
				System.out.println("El número escogido no es primo");
			}
	}
	
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
