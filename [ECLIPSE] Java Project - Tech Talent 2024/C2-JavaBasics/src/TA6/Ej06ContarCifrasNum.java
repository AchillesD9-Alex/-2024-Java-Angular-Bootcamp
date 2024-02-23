package TA6;

import java.util.Scanner;

public class Ej06ContarCifrasNum {
	/*  Crea una aplicación que nos cuente el número de cifras de un número entero positivo pedido por teclado.
		Hay que controlarlo. Crea un método que realice esta acción;
	 	pasando el número por parámetro, devolverá el número de cifras.
	 */
	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡NUMERO DE NUMEROS! ... ¿Que?...--");
		System.out.println("Por favor, introduce el número entero positivo deseado:");
			num = Integer.parseInt(sc.nextLine());
		
//		Filtro para asegurar que solo entren num enteros positivos
		do {
			System.out.println("No has introducido un numero entero positivo..."
				+ "\nVuelve a intentarlo.");
				num = Integer.parseInt(sc.nextLine());
		}while(num < 0);
		sc.close();
					
		System.out.println("El número " +num+ " tiene " +aContarNum(num)+ " cifras.");
	}
	
//	Metodo escogido, pasamos el numero a string y devolvemos su longitud,
//	que equivale al numero de cifras del numero.
	public static int aContarNum (int numINTRO) {
		
		String numero = String.valueOf(numINTRO); // int --> string
		return numero.length();
	}
}
