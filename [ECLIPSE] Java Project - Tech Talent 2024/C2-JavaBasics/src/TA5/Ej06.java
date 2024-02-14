package TA5;

import java.util.Scanner;

public class Ej06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Crea entrada de datos al sistema
		
		System.out.println("¿Quieres saber el precio con IVA del producto?.");
		System.out.println("Introduce el importe del producto deseado:");
		
		String initialPROD = sc.nextLine(); //Crea el String para introducir el importe del producto
		
		sc.close(); //Cierra la entrada de datos
		
		double prod = Double.parseDouble(initialPROD); //Genera double prod
		final double IVA = 0.21; //Generamos CTE IVA
		double price = prod + (prod * IVA);
		
		System.out.println("\nEl importe final con IVA es de " + price + " €");
		
	}
		
}

