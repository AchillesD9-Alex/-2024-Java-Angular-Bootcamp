package TA6;

import java.util.Scanner;

public class Ej06 {
	/*  Crea una aplicación que nos cuente el número de cifras de un número entero positivo pedido por teclado.
		Hay que controlarlo. Crea un método que realice esta acción;
	 	pasando el número por parámetro, devolverá el número de cifras.
	 */
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
