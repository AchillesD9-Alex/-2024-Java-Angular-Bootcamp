package TA9;

import java.util.Scanner;

public class TA9Ej4_MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el valor de a:");
			double a = sc.nextDouble();
		System.out.println("Introduce el valor de b:");
			double b = sc.nextDouble();
		System.out.println("Introduce el valor de c:");
			double c = sc.nextDouble();
			
		TA9Ej4_Raices r = new TA9Ej4_Raices(a, b, c);
		r.calcular();
	}

}