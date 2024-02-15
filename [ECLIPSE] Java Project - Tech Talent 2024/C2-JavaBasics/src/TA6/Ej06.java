package TA6;

import java.util.Scanner;

public class Ej06 {
		
	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡NUMERO DE NUMEROS! ... ¿Que?...--");
		System.out.println("Por favor, introduce el número entero deseado:");
			
		num = Integer.parseInt(sc.nextLine());
		sc.close();
					
		System.out.println("El número " +num+ " tiene " +aContarNum(num)+ " cifras.");
	}
	
	public static int aContarNum (int numINTRO) {
		
		String numero = String.valueOf(numINTRO); // int --> string
		return numero.length();
	}
}
