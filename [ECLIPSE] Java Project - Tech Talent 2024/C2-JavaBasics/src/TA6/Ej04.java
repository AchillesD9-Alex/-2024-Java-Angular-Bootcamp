package TA6;

import java.util.Scanner;

public class Ej04 {
		
	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡A FACTORIZAR! --");
		System.out.println("Por favor, introduce el número entero deseado:");
			
		num = Integer.parseInt(sc.nextLine());
		sc.close();
					
		System.out.println("El factorial es: " +factorizar(num));
	}
	
	public static int factorizar (int numINTRO) {
		int prod = 1; //1 para no multiplicar por cero y fastidiar el cálculo
		
		do {
			 prod *= numINTRO--; //*= --> prod = prod * numIntro--;
			}while(numINTRO > 1);
	return prod;
	}
}
