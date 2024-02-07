package TA5;

import java.util.Scanner;

public class Ej12For {
	
	public static void main(String[] args) {
		
		String passTRUE = "password";
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println(" -- INICIANDO SISTEMA --");
		System.out.println("Por favor, introduce la contraseña:");
			
		for(n=3;n>0;n--){
			 		
			String pass = sc.nextLine();
			
			
			if(pass.equals(passTRUE)){n--; // EQUALS para comparar Strings, == para comparar NUM
					System.out.println("Bienvenido, usuario."
							+ "\n Te quedaban " + n + " intento(s)."
							+ "\n¡Enhorabuena!");
					break; //Para salir del bucle
			
			}else{System.out.println("Contraseña incorrecta. Vuelve a intentarlo."
						+ "\n Nº de intentos restantes: " + (n-1) );
			
				}		
			
		}
		sc.close();
		
		}
}
