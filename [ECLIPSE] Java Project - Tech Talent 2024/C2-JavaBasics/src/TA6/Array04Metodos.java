package TA6;

import java.util.Scanner;

public class Array04Metodos {

	public static void main(String[] args) {
		int num[] = rellenarArrayDesde(5); // Creará: num[] = {5, 6, 7, 8, 9 , 10, 11, 12, 13, 14}
		imprimirArray(num); //Mostrará el array en consola
	
	}
	
	public static int[] rellenarArrayDesde(int a) {
		int num[] = new int[10];
		
		for (int i = 0; i< num.length; i++) {
			num[i] = a;
			a++;
		}
		return num;
		
	}
	
	public static void imprimirArray (int lista[]) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
	
}