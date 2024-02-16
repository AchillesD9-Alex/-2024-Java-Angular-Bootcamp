package TA6;

import java.util.Scanner;

public class Ej07 {
		
	public static void main(String[] args) {
		
		int euros;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡CAMBIO MONEDAS! --");
		
		System.out.println("Por favor, introduce cuantos € quieres convertir: ");
		 euros = Integer.parseInt(sc.nextLine());
		System.out.println("¿A qué moneda sera? ¿Libras, dolares o yenes?");
			String divisa = sc.nextLine().toUpperCase();
		
		if (cambioDivisa(euros, divisa) < 0) {
			System.out.println("El valor introducido es negativo o no es un numero.");
		}else {
		System.out.println("El cambio equivale a "  +cambioDivisa(euros, divisa)+ " " +divisa);
		}
		sc.close();
	}
	/* No he tenido problemas en crear las instrucciones del método, pero no me aclaraba
	 *  sobre qué podía hacer para vincular el método con el main, porque había puesto
	 *  la entrada de datos en el método, cuando tenia que estar en el main.
	 */
	
	
	public static double cambioDivisa (double eurosAcambiar, String divisaDeseada) {
						
		switch(divisaDeseada) {
			case "LIBRAS":
				return eurosAcambiar*0.86;
				
			case "DOLARES":
				return eurosAcambiar*1.28611;
				
			case "YENES":
				return eurosAcambiar*129.852;
				
			default:
				return -1;
		}		
	}
}
