package TA5;

import java.util.Scanner;

public class Extra03 {
	
	public static void main(String[] args) {
		/* Escribe un programa que dado un número, sume dicho número con todos los
		anteriores. Por ejemplo, para el número 5 el resultado debería ser
		15 (5 + 4 + 3 + 2 +1)*/
	
	
	
	Scanner sc = new Scanner(System.in); 
		
	System.out.println(" -- ¡SUMEMOS! --");
	System.out.println("Por favor, introduce el número entero deseado:");
		
	int i = Integer.parseInt(sc.nextLine());
	sc.close();
	
	int suma = 0;
	
	do {
		 suma = suma + i--;
		}while(i >= 1);
			
	System.out.println("La suma es: " +suma);
	}	
}