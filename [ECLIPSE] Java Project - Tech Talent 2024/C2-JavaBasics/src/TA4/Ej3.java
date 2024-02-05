package TA4;

public class Ej3 {

	public static void main(String[] args) {
		/*Escribe un programa Java que realice lo siguiente: declarar dos variables X e Y de tipo int,
		dos variables N y M de tipo double y asigna a cada una un valor. A continuación muestra por
		pantalla*/
		
		int x = 2, y = 10;
		double n = 2.5, m = 10.5;
		
		/*El valor de cada variable*/
		System.out.println("El valor de las variables es el siguiente:");
		System.out.println("Variable X (int): " +x);
		System.out.println("Variable Y (int): " +y);
		System.out.println("Variable N (double): " +n);
		System.out.println("Variable M (double): " +m+ "\n");
		
		
		/*La suma de X + Y*/
		int sumaXY=x+y;
		System.out.println("X + Y es " +sumaXY);
		
		/*La diferencia de X - Y*/
		int restaXY=x-y;
		System.out.println("X - Y es " +restaXY);
		
		/*El producto de X * Y*/
		int prodXY=x*y;
		System.out.println("X * Y es " +prodXY);
		
		/*El coeficiente de X / Y*/
		int coefXY=x/y;
		System.out.println("X / Y es " +coefXY);
		
		/*El resto de X % Y*/
		int restoXY=x%y;
		System.out.println("X % Y es " +restoXY);	
		
		/*La suma de N + M*/
		double sumaNM=n+m;
		System.out.println("N + M es " +sumaNM);
		
		/*La diferencia de N - M*/
		double restaNM=n-m;
		System.out.println("N - M es " +restaNM);
		
		/*El producto de N * M*/
		double prodNM=n*m;
		System.out.println("N * M es " +prodNM);
		
		/*El coeficiente de N / M*/
		double coefNM=n/m;
		System.out.println("N / M es " +coefNM);	
		
		/*El resto N % M*/
		double restoNM=n%m;
		System.out.println("N % M es " +restoNM);
		
		/*La suma de X + N*/
		double sumaXN=x+n;
		System.out.println("X - N es " +sumaXN);
		
		/*El coeciente Y / M*/
		double coefYM=y/m;
		System.out.println("Y / M es " +coefYM);
		
		/*El resto de Y % M*/
		double restoYM=y%m;
		System.out.println("Y % M es " +restoYM);
		
		/*Dl doble de cada variable*/
		int dobleX=x*2, dobleY=y*2;
		double dobleN=n*2, dobleM=m*2;
		
		System.out.println("");
		System.out.println("El doble de las variables es el siguiente:");
		System.out.println("X*2 vale " +dobleX);
		System.out.println("Y*2 vale " +dobleY);
		System.out.println("N*2 vale " +dobleN);
		System.out.println("M*2 vale " +dobleM);
		
		/*La suma de todas las variables*/
		double sumaALL=x+y+n+m;
		System.out.println("El valor de la suma de todas las variables es " +sumaALL);
		
		/*El producto de todas las variables*/
		double prodALL=x*y*n*m;
		System.out.println("El valor del producto de todas las variables es " +prodALL);
		
		System.out.println("");
		System.out.println("FIN DE PROGRAMA");
		
	}
}
