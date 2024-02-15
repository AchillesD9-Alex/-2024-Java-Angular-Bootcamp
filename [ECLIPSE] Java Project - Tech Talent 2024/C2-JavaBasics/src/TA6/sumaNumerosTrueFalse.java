package TA6;

import java.util.Scanner;

public class sumaNumerosTrueFalse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" -- ¿MAYOR O IGUAL QUE CERO? --");
		System.out.println("Por favor, introduce el primer operador a sumar:");
		int op1 = Integer.parseInt(sc.nextLine());
		System.out.println("Por favor, introduce el segundo operador a sumar:");
		int op2 = Integer.parseInt(sc.nextLine());
		sc.close(); 
		System.out.println("Los operadores introducidos son:"
				+ "\nOperador 1: "+op1+
				"\nOperador 2: " +op2+"\n");
		
		if (sumaNum(op1, op2)) {
			System.out.println("Su suma es mayor o igual que 0 (resultado positivo).");
		}else {
			System.out.println("Su suma es menor que 0 (resultado negativo).");
		}
	}
	
	public static boolean sumaNum (int num1, int num2) {
		int result = num1 + num2;
		
		if (result >= 0) {
			return true;
		}else {
			return false;
		}
	}
	
}
