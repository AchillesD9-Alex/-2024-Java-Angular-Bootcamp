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
	
	System.out.println("\nVamos a invertir, una a una, las letras de la palabra empezando por el final:");
	
	for (l = l-1 ; l >= 0; l-- ) {		//l = l-1 para cuadrar los indices; último carácter = length -1
		INVword.append(word.charAt(l)); //charAt: dice el carácter de la posición y append lo concatena a INVword
		System.out.println(INVword);
	}
	String iWord = INVword.toString();	//Transforma el formato StringBuilder a String para poder compararlo en el codicional
	System.out.println("La palabra INVERTIDA es: "+iWord+ ".\n");
	
	if(word.equals(iWord)) {
		System.out.println("La palabra " +word+ " ES un palindromo.");
	}else {
		System.out.println("La palabra " +word+ " NO ES un palindromo.");
	}
			
		

	}	
}