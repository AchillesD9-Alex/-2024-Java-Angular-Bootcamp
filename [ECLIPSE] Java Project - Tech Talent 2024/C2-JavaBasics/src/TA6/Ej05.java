package TA6;

import java.util.Scanner;

public class Ej05 {
		
	public static void main(String[] args) {
		
		int bin;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡DECIMAL A BINARIO! --");
		System.out.println("Por favor, introduce el número entero deseado:");
			
		bin = Integer.parseInt(sc.nextLine());
		sc.close();
					
		System.out.println("El binario generado es: " +dec2bin(bin));
	}
	
	public static String dec2bin (int decimal) {
		
		if (decimal == 0) {
			return "0";
		}
		
		StringBuilder binario = new StringBuilder();
		
		int residuo;
		do {
			residuo = decimal % 2;
			binario.insert(0, residuo);
			decimal = decimal / 2;
			System.out.println(residuo + " " + decimal);
			 
			}while(decimal > 0);
		return binario.toString(); //StringBuilder --> String
	}
}
