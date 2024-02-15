package TA6;


import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ej01 {
		
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
			
		System.out.println(" -- Iniciando GEOMETRY --");
	
		System.out.println("¿Qué figura quieres calcular?\nCírculo\nTriangulo\nCuadrado");
			String figura = sc.nextLine();
				figura = figura.toUpperCase();
			
		switch (figura){
			case "CIRCULO":
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
