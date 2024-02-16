package TA6;

import java.util.Scanner;

public class Extra05_METODO {
	
	public static void main(String[] args) {
	/* Dada una variable String por System.in determinar si es o no palindromo*/
	
	Scanner sc = new Scanner(System.in); 
		
	System.out.println(" -- ¿SERA PALINDROMO? --");
	System.out.println("Por favor, introduce la palabra deseada:");
	
	String word = sc.nextLine();
	sc.close();
	
	word = word.toUpperCase();
	
	String wordInv = crearInverso (word);	
	System.out.println("La palabra INVERTIDA es: " +wordInv+ ".\n");
	
	revisaPalindromo(word, wordInv);

	}
	
	public static String crearInverso (String palabraEscogida) {
	
	int lengthIndice = palabraEscogida.length();
	System.out.println("La palabra " +palabraEscogida+ " tiene " +lengthIndice+ " letras.");
	
	StringBuilder palabraReves = new StringBuilder(); /*Comando para GENERAR STRING*/
	
	System.out.println("\nVamos a invertir, una a una, las letras de la palabra empezando por el final:");
	
	for (lengthIndice = lengthIndice -1 ; lengthIndice >= 0; lengthIndice-- ) {
		palabraReves.append(palabraEscogida.charAt(lengthIndice)); 
		System.out.println(palabraReves);
	}
	
	return palabraReves.toString();
	}
	/* El metodo void no devuelve nada (no tiene return)
	 * pero genera acciones con parametros que nosotros podemos introducir.
	 */
	
	public static void revisaPalindromo(String palabraEscogida, String nuevaPalabra) { 
		if(palabraEscogida.equals(nuevaPalabra)) {
			System.out.println("La palabra " +palabraEscogida+ " ES un palindromo.");
		}else {
			System.out.println("La palabra " +palabraEscogida+ " NO ES un palindromo.");
		}
	}
	
}