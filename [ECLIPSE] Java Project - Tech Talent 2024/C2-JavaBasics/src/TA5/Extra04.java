package TA5;

import java.util.Scanner;

public class Extra04 {
	
	public static void main(String[] args) {
	/* Escribe un programa que dado un número, calcule si es primo o no.
	Un número primo es un número natural mayor que 1 que tiene únicamente
	dos divisores distintos: él	mismo y el 1*/
	
	Scanner sc = new Scanner(System.in); 
		
	System.out.println(" -- ¿SERA PRIMO? --");
	System.out.println("Por favor, introduce el número entero deseado:");
	
	int n = Integer.parseInt(sc.nextLine());
	sc.close();
	
	if (n == 1) {
		System.out.println("El número 1 no es primo...");
	}else {
		for (int i = 2; i <=Math.sqrt(n); i++) { //Creo el contador para que se pueda calcular.
			if (n % i == 0) { //Es la condición para el cálculo
				System.out.println("El numero " +n+ " NO ES primo.");
				}else {
					System.out.println("El numero " +n+ " ES primo.");
					break; /*No sé por qué, pero primos más grandes devuelven varias veces el msg...
					Añado el break para que sólo informe una vez. Creo que no acabo de entender
					La condición matemática; seguramente se repita buscando si realmente es primo,
					dividiéndolo entre los primos anteriores encontrados.*/
				}
			}
		}
	
	}	
}