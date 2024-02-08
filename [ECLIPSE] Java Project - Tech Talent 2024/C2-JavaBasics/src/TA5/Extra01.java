package TA5;

public class Extra01 {
	
	public static void main(String[] args) {
		/* Escribe un programa que imprima toda la tabla
		 * de multiplicar del 5 (desde 0 hasta 10).*/
		
		int n = 0;
		
		do{
		int prod = 5 * n;
		System.out.println("5 * " +n+ " = " +prod);
		n++;
		}while(n<=10); 		
	
	}
	
}
