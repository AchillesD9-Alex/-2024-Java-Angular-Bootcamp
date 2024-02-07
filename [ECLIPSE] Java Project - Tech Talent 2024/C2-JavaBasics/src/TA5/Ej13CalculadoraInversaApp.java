package TA5;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ej13CalculadoraInversaApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" -- Iniciando CalculadoraInversa --");
		System.out.println("Por favor, introduce el primer operando (nº entero):");
			String aINTRO = sc.nextLine();
			int a = Integer.parseInt(aINTRO);
			
		System.out.println("Por favor, introduce el segundo operando (nº entero):");	
			String bINTRO = sc.nextLine();
			int b = Integer.parseInt(bINTRO);
			
		System.out.println("¿Qué operación deseas hacer?\nSuma (+), Resta (-), Producto (*), División (/)"
				+ "\nPotencia (^), usando 1º operando como base y segundo como exponente"
				+ "\nMódulo (%), resto de la división entre operando 1 y 2");
			String op = sc.nextLine();
			
		
	switch (op){
		case "+":
			JOptionPane.showInternalMessageDialog(null,
			"La suma entre " +a+ " y " +b+ " es: " +(a + b));
				break;
		
		case "-":
			JOptionPane.showInternalMessageDialog(null,
			"La resta de " +a+ " y " +b+ " es: " +(a - b));
				break;
		
		case "*":
			JOptionPane.showInternalMessageDialog(null,
			"El producto de " +a+ " por " +b+ " es: " +(a * b));
				break;
				
		case "/":
			JOptionPane.showInternalMessageDialog(null,
			"La division de " +a+ " entre " +b+ " es: " +(a / b));
				break;
		
		case "%":
			JOptionPane.showInternalMessageDialog(null,
			"El modulo de " +a+ " entre " +b+ " es: " +(a % b));
				break;
		
		case "^":
			JOptionPane.showInternalMessageDialog(null,
			"La potencia de " +a+ " elevado a " +b+ " es: " +(Math.pow(a, b)));
				break;
		
		}
		sc.close();
	}
}
