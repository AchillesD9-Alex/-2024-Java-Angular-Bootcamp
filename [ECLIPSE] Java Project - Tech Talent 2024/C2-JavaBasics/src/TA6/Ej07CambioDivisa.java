package TA6;

import java.util.Scanner;

public class Ej07CambioDivisa {
	/*  Crea un aplicación que nos convierta una cantidad de euros introducida por teclado a otra moneda,
	 	estas pueden ser a dolares, yenes o libras. El método tendrá como parámetros, la cantidad de euros
	 	y la moneda a pasar que sera una cadena, este no devolverá ningún valor.
	 	Mostrara un mensaje indicando el cambio (void).
	 */
	public static void main(String[] args) {
		
		int euros;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- ¡CAMBIO MONEDAS! --");
		System.out.println("Por favor, introduce cuantos € quieres convertir: ");
			euros = Integer.parseInt(sc.nextLine());
		System.out.println("¿A qué moneda sera? ¿Libras, dolares o yenes?");
			String divisa = sc.nextLine().toUpperCase();
		
		cambioDivisa(euros, divisa);
		
		sc.close();
	}
	/* 	No he tenido problemas en crear las instrucciones del método, pero no me aclaraba
	 *  sobre qué podía hacer para vincular el método con el main, porque había puesto
	 *  la entrada de datos en el método, cuando tenia que estar en el main.
	 */
	
	
	public static void cambioDivisa (double eurosAcambiar, String divisaDeseada) {
		double cambio = 0;		
		switch(divisaDeseada) {
			case "LIBRAS":
				cambio = eurosAcambiar*0.86;
				System.out.println("El cambio equivalente a " +divisaDeseada+ " es: " +cambio);
				break;
				
			case "DOLARES":
				cambio = eurosAcambiar*1.28611;
				System.out.println("El cambio equivalente a " +divisaDeseada+ " es: " +cambio);
				break;
				
			case "YENES":
				cambio = eurosAcambiar*129.852;
				System.out.println("El cambio equivalente a " +divisaDeseada+ " es: " +cambio);
				break;
				
			default:
				System.out.println("No has seleccionado una divisa correcta");
				break;
		}		
	}
}
