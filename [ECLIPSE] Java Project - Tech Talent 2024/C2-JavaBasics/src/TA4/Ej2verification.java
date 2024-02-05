package TA4;

public class Ej2verification {

	public static void main(String[] args) {
		
	//VERIFICACIÓN. CREO Ej2 para verificar la condición del ejercicio.
		/*Si por ejemplo le hemos dado a N el valor 5, a A el valor 4.56 y a C el valor ‘a’, se debe
mostrar por pantalla:
• Variable N = 5
• Variable A = 4.56
• Variable C = a
• 5 + 4.56 = 9.559999999999999
• 4.56 - 5 = -0.4400000000000004
• Valor numérico del carácter a = 97*/
		
		int n=5;
		double a=4.56;
		char c='a'; 

		
	/*Muestra por pantalla el valor de cada variable*/
			
	System.out.println("El valor de la variable n es " +n);
	System.out.println("El valor de la variable a es " +a);
	System.out.println("El valor (carácter) de la variable c es " +c+ "\n");
	
	
	/*Muestra por pantalla la suma de N + A*/
	
	double sumaNA=n+a;
	System.out.println("El valor de la suma de n + a es: " +sumaNA);
	
	/*Muestra por pantalla la diferencia de A - N*/
	
	double restaAN=a-n;
	System.out.println("El valor de la diferencia de a - n es: " +restaAN);
	
	/*Muestra por pantalla el valor numérico correspondiente al carácter que contiene la variable C */
	
	int valorNumC=(int)c;
	
	System.out.println("El carácter de c es " +c+ " (dicho anteriormente arriba) y su valor numérico es: " +valorNumC+ "\n");
	
	System.out.println("FIN DE PROGRAMA");
	
	}

}
