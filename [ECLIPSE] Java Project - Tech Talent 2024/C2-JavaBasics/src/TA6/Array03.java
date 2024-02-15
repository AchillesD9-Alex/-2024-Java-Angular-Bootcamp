package TA6;

import java.util.Scanner;

public class Array03 {

	public static void main(String[] args) {
		/* Pedir 3 strings (participantes) por pantalla.
		 *  Realizar un recorrido del array y mostrar los 3 participantes.
		 *  y a continuación con método Math.random, rango indice 0 al 2 (lenght-1)
		 *  te dé el ganador */
		
		String ppl[] = new String[3];
		Scanner sc = new Scanner(System.in);
		
		/*System.out.println(" -- Iniciando GACHA --");
		System.out.println("Introduce el primer participante:");
			ppl[0]=sc.nextLine();
		System.out.println("Introduce el segundo participante:");
			ppl[1]=sc.nextLine();
		System.out.println("Introduce el tercer participante:");
			ppl[2]=sc.nextLine();
			
		System.out.println("Los apeticipantes son:"
				+ "\n- " +ppl[0]+
				"\n- " +ppl[1]+
				"\n- " +ppl[2]);
		System.out.println("¡Ha ganado " +gacha(3)+ " !");*/
		
		//recorremos array para darle valores (string) = nombre participantes
		for (int i = 0; i <ppl.length; i++) {
			System.out.println("Ingresa el participante nº" +(i+1)+ ": ");
			ppl[i] = sc.nextLine();
		}
		
		/*Creación String listPpl, que coge los valores del array ppl
		 * Muestra cada indice del array ppl mediante un system.out
		 * Genera la lista de participantes.
		 */
		System.out.println("Los participantes son:");
		for (String listPpl: ppl) {
			System.out.println("- " +listPpl);
		}
							
		int indiceWin = (int)(Math.random()* (ppl.length));
		String winner = ppl[indiceWin];
		System.out.println("¡El ganador es " +winner+ "!");
		sc.close();
	}

	
}