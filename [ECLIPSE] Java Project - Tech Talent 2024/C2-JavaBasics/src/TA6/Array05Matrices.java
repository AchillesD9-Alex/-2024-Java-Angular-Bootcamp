package TA6;

import java.util.Scanner;

public class Array05Matrices {

	public static void main(String[] args) {
		int array[][] = new int [3][5]; // Creará un array de 3 filas x 5 columnas
		array[0][1] = 5; //fila 1, columna 2 = 5
		array[1][3] = 6; //fila 2, columna 4 = 6
		
		int matriz[][] = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15} };
		
		//Recorremos el array multidimensional
		for(int i = 0; i<matriz.length;i++) {
			for(int j = 0;j<matriz[0].length;j++) {
				System.out.print(matriz[i][j]);
				if(j<matriz[0].length -1) {
					System.out.print(", ");
				}
				
			}
			System.out.println();
		}
		
	}
}