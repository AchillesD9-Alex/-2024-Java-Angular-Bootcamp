package TA5;

import java.util.Scanner;

public class Ej12DoWhile {
	
	public static void main(String[] args) {
		
		String passTRUE = "password";
		int n = 0;
		String pass;
		
		Scanner sc = new Scanner(System.in); 
		System.out.println(" -- INICIANDO SISTEMA --");
		System.out.println("Por favor, introduce la contraseña:");
		
		do{
		pass = sc.nextLine();
			
			
			if(pass.equals(passTRUE)){
					System.out.println("Enhorabuena. Bienvenido, usuario."
							+ "\n Nº de intentos restantes: " + (3-(n+1)));
			
			}else{n++;
					System.out.println("Contraseña incorrecta. Vuelve a interntarlo."
						+ "\n Nº de intentos restantes: " + (3-n));
					}		
		
		}while(n<3 && !pass.equals(passTRUE)); // !nom.equals en String o != para NUM
		//Chat GPT me ha puesto and diferente aunque yo tenía puesto OR || igual (equals)
		//Aprovecho y lo dejo así para ver las dos opciones
		
		sc.close();
	}
	
}
