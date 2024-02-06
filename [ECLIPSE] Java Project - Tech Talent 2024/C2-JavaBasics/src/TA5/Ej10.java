package TA5;

import java.util.Scanner;

public class Ej10 {
	
	public static void main(String[] args) {
		
		double ventaT = 0;
				
		Scanner sc = new Scanner(System.in); 
		
		System.out.println(" -- Iniciando VENTAS TOTALES --");
		System.out.println("Por favor, introduce el Nº VENTAS:");
		
		String TEXTnºVENTAS = sc.nextLine();
		int nºVENTAS = Integer.parseInt(TEXTnºVENTAS);
				
		
		for (int n = 0; n < nºVENTAS; n++){ //Creo contador para hacer loop en el for
			System.out.println("Por favor, introduce las ganancias de la venta número " + (n+1));
			
			String TEXTventa = sc.nextLine();
			double venta = Double.parseDouble(TEXTventa);
		
			ventaT = ventaT + venta; //Realizo el sumatorio de las ganancias de venta con ventaT	
			}
		
		sc.close(); /*Cierra la entrada de datos;
					no la cierro antes por la dinámica del loop con venta*/
		
			
	System.out.println("\nHa habido un total de " + nºVENTAS +
			" ventas.\nLa suma total de ganancias es de: " + ventaT + " €");
	}
	
}
