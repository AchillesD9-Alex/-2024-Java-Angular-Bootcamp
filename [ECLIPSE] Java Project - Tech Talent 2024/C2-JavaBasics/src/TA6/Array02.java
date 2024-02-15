package TA6;

public class Array02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[] = {5, 6, 5, 2, 3}; //Declara array NUM1 y le asigna valores
		int num2[] = new int[5]; //Declara array NUM2, de tipo INT con 5 INDICES = 5 lugares (POSICION = TAMAÑO)
									//PRIMERA POSICIÓN = INIDICE CERO
		
		num2[0] = 5; //Asigna el valor 5 a la primera posición del Array NUM2.
		num2[1] = 9; //Asigna el valor 9 a la segunda posición del Array NUM2.
		//Las demás posiciones del array NUM2 no han sido declaradas, por lo que se consideran 0.
		//Ahora mismo, num2[] = { 5, 9, 0, 0, 0}
		
		System.out.println(num1[3] +" y "+ num2[1]); 
		
		//num1 [5] = 7; --> fuera del tamaño máximo del array
		num1 [2] = 4; //num1 = {5, 6, 4, 2, 3}
		
		/* RECORRER ARRAYS
		 * Creamos un bucle, que vaya desde la posición 1 a la última.
		 * Usamos un contador i para movernos por el índice del array ( 0 a 4)
		 * Y mostramos el valor de cada posición con un system.out */
		
				
		for (int i = 0; i < num1.length; i++) { //length = tamaño array
			System.out.println(num1[i]);
		}
		
		System.out.println("\n");
		
		int num[] = new int[10]; //Indice 0 a 9, tamaño 10
		
		// asigna a todas las posiciones valoes de 5 en 5
		for (int j = 0, multiplo = 5; j < num1.length; j++, multiplo += 5) { //valor multiplo +5
			num[j] = multiplo; //sobreescribe array con variable multiplo
			System.out.println(num[j]);
		}
		
	}

}
