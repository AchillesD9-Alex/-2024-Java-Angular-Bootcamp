package TA4;

public class Ej5 {

	public static void main(String[] args) {
		/*Programa java que declare cuatro variables enteras A, B, C y D y
		asígnale un valor a cada una. A continuación realiza las instrucciones
		necesarias para que: */
		int a = 2, b = 3, c = 4, d = 5;
		System.out.println("Los datos iniclaes son:\n" +a);		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d +"\n");
		
		//DATOS INICIALES: a 2, b 3, c 4 d 5
		/* B tome el valor de C */
		
		b = c;
		// El cambio es secuencial, NO ES UN INTERCAMBIO
		//a 2, b 4, c 4 d 5
		
		/* C tome el valor de A */
		c = a;
		//a 2, b 4, c 2 d 5
		
		/* A tome el valor de D */
		a = d;
		//a 5, b 4, c 4 d 5
		
		/* D tome el valor de B */
		d = b;
		//a 2, b 4, c 4 d 4
		
		System.out.println("Los datos intercambiados son: \n" +a);		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}

}
