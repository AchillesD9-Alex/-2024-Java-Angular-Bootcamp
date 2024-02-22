package TA6;


import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ej01CalcularArea {
	
	/*  Crea una aplicación que nos calcule el área de un circulo, cuadrado o triangulo.
	 	1) Pediremos la figura que queremos calcular su área y nos pedirá los valores necesarios para calcular el área.
	 	2) Crea un método por cada figura para calcular cada área, este devolverá un número real.
	 	3) Muestra el resultado por pantalla.
	 */
		
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		System.out.println(" -- Iniciando GEOMETRY --");
		
//	1) Pedimos la figura:

		System.out.println("¿Qué figura quieres calcular?\nCírculo\nTriangulo\nCuadrado");
			String figura = sc.nextLine();
				figura = figura.toUpperCase(); // a MAYUS para asegurar entrada correcta al switch
				
//	3) Dentro del Switch, con el case adecuado, utilizamos el metodo creado y enseñamos los resultados por pantalla.
				
		switch (figura){
			case "CIRCULO":
//				Ejemplo de petición de datos para usar en el metodo:
				System.out.println("¿Que valor tiene el RADIO?"); 
						double  r = Integer.parseInt(sc.nextLine());
				System.out.println("El área del CIRCULO es: " +(circulo(r)));
					break;
			
			case "TRIANGULO":
				System.out.println("¿Que valor tiene la BASE?");
					int  b = Integer.parseInt(sc.nextLine());
				System.out.println("¿Que valor tiene la ALTURA?");
					int  h = Integer.parseInt(sc.nextLine());
				System.out.println("El área del TRIANGULO es: " +triangulo(b, h));
						break;
			
			case "CUADRADO":
				System.out.println("¿Que valor tiene el LADO");
					int  c = Integer.parseInt(sc.nextLine());
				System.out.println("El área del CUADRADO es: " +cuadrado(c));
					break;
					
			default:
				System.out.println("No has especificado correctamente la figura..."+
						"\nVuelve a iniciar el programa, por favor.");
						}
			sc.close();
		}
	
//	2) Creamos los métodos para cada figura; realizarán los cálculos del área.
	public static double circulo(double radio) {
		return Math.pow(radio, 2)*Math.PI;
	}
	public static double triangulo(double base, double altura) {
		return (base*altura)/2;
	}
	public static double cuadrado(double lado) {
		return lado*lado;
	}
}
