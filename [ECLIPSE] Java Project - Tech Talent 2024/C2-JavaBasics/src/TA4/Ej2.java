package TA4;

public class Ej2 {

	public static void main(String[] args) {
		/* Escribe un programa Java que realice lo siguiente: declarar una variable N de tipo int,
una variable A de tipo double y una variable C de tipo char y asigna a cada una un valor*/
	
		int n=20;
		double a=10.5;
		char c='2'; //Es el carácter 2, no el valor numérico del carácter según tabla.

		
	/*Muestra por pantalla el valor de cada variable*/
			
	System.out.println("El valor de la variable n es " +n);
	System.out.println("El valor de la variable a es " +a);
	System.out.println("El valor (carácter) de la variable c es " +c);
	System.out.println("");
	
	/*Muestra por pantalla la suma de N + A*/
	
	double sumaNA=n+a;
	System.out.println("El valor de la suma de n + a es: " +sumaNA);
	
	/*Muestra por pantalla la diferencia de A - N*/
	
	double restaAN=a-n;
	System.out.println("El valor de la diferencia de a - n es: " +restaAN);
	
	/*Muestra por pantalla el valor numérico correspondiente al carácter que contiene la variable C */
	
	int valorNumC=(int)c;
	
	System.out.println("El carácter de c es " +c+ " (dicho anteriormente arriba) y su valor numérico es: " +valorNumC);
	
	System.out.println("FIN");
	
	}

}
