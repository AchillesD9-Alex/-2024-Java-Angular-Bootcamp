package TA5;

import java.util.Scanner;

public class EjClaseIF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* [1 - 11h] buenos días
		 * [12 - 19h] buenas tardes
		 * [20-23h] buenas noches
		 */
	Scanner sc = new Scanner(System.in);
		
	System.out.println(" -- Iniciando SALUDO --");
	System.out.println("Por favor, introduce la hora (valor entero, de 1am a 23pm):");
		String horaINTRO = sc.nextLine();
		int hora = Integer.parseInt(horaINTRO);
	sc.close();
	
	if(hora >= 1 && hora <= 11) {
		System.out.println("Son las " +hora+"am.\n¡Buenos dias!");
		
		}else if (hora >= 12 && hora <= 19) {
			System.out.println("Son las " +hora+"pm.\n¡Buenas tardes!");
			
		}else if (hora >= 20 && hora <= 23) {
			System.out.println("Son las " +hora+"pm.\n¡Buenas noche!");
			
		}else if(hora < 1 && hora >= 0){
			System.out.println("El rango 0 a antes de 1 am no es valido..."
					+ "\nPrueba con un entero entre 1 y 23, según la hora deseada.");
		}
	
	else{
		System.out.println("No has introducido el rango válido."
			+ "\nPrueba con un entero entre 1 y 23, según la hora deseada.");
		}
				
		
	}
}
		
	


