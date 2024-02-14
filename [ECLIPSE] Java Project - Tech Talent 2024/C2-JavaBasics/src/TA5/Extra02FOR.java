package TA5;

public class Extra02FOR {
	
	public static void main(String[] args) {
		/* Escribe un programa que imprima todas
		 * las tablas de multiplicar del 1 al 9 (desde 0 hasta 10).*/
	
	for (int i = 1; i <= 10; i++){
			for (int j=0; j<= 10; j++){
				System.out.println(i+ " * " +j+ " = " +(i*j));
			}
		}
	}
						
}

