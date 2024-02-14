package TA5;

import java.util.Scanner;

public class Extra05 {
	
	public static void main(String[] args) {
	/* Dada una variable String por System.in determinar si es o no palindromo*/
	
	Scanner sc = new Scanner(System.in); 
		
	System.out.println(" -- ¿SERA PALINDROMO? --");
	System.out.println("Por favor, introduce la palabra deseada:");
	
	String word = sc.nextLine();
	sc.close();
	
	word = word.toUpperCase();
	
	System.out.println("La palabra " +word+ " tiene "+word.length()+" letras.");
	int l = word.length();
	
	StringBuilder INVword = new StringBuilder(); /*Comando para GENERAR STRING*/
	
	for (l = l-1 ; l >= 0; l-- ) {
		INVword.append(word.charAt(l));
	}
	String iWord = INVword.toString(); //Transforma el formato StringVuilder a String para poder compararlo en el codicional
	System.out.println("La palabra INVERTIDA es: "+iWord+ ".\n");
	
	if(word.equals(iWord)) {
		System.out.println("La palabra " +word+ " ES un palindromo.");
	}else {
		System.out.println("La palabra " +word+ " NO ES un palindromo.");
	}
			
		

	}	
}