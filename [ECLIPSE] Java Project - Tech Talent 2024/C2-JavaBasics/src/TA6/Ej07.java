package TA6;

import java.util.Scanner;

public class Ej07 {
		
	public static void main(String[] args) {
		
		int euros;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡CAMBIO MONEDAS! --");
		System.out.println("Por favor, introduce cuantos € quieres convertir: ");
			euros = Integer.parseInt(sc.nextLine());
		System.out.println("¿A qué moneda sera? ¿Libras, dolares o yenes?");
			String divisa = sc.nextLine().toUpperCase();
		
		sc.close();
		
		
		//A case de switch
		System.out.println(euros+ "€  son "  +cambioDivisa+ " ");
	}
	
	public static int cambioDivisa (int numINTRO) {
		
		switch
			case("LIBRAS")
	}
}
