package TA6;

import java.util.Scanner;

public class sumaNumTrueFalse2EJERCICIO {
/*Dividir el metodo sumaNum() en dos:
 * 1) Devovler un int del cálculo de la suma
 * 2) Crear método positivo(int result), pero devuelvo un booleano
 */
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" -- ¡A SUMAR! ¿POSITIVO O NEGATIVO? --");
		System.out.println("Por favor, introduce el primer operador a sumar:");
		int op1 = Integer.parseInt(sc.nextLine());
		System.out.println("Por favor, introduce el segundo operador a sumar:");
		int op2 = Integer.parseInt(sc.nextLine());
		sc.close();
		
		int result = sumaNum (op1, op2);
		System.out.println("Los operadores introducidos son:"
				+ "\nOperador 1: "+op1+
				"\nOperador 2: " +op2+
				"\n\nLa suma de los operadores es: " +result);
		
		
		if (positivo(result)) {
			System.out.println("Su suma es mayor o igual que 0 (resultado positivo).");
		}else {
			System.out.println("Su suma es menor que 0 (resultado negativo).");
		}
	}
	
	public static int sumaNum (int num1, int num2) {
		
		return num1+num2;
	}
		
	public static boolean positivo (int check) {
		if (check >= 0) {
			return true;
		}else {
			return false;
		}
	}

}
