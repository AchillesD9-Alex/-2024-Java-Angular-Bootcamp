package TA6;

public class Array01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[] = {5, 6, 5, 2, 3}; //Declara array NUM1 y le asigna valores
		int num2[] = new int[5]; //Declara array NUM2, de tipo INT con 5 INDICES (posición 0 a 4)
		
		num2[0] = 5; //Asigna el valor 5 a la primera posición del Array NUM2.
		num2[1] = 9; //Asigna el valor 9 a la segunda posición del Array NUM2.
		//Las demás posiciones del array NUM2 no han sido declaradas, por lo que se consideran 0.
		//Ahora mismo, num2[] = { 5, 9, 0, 0, 0}
		
		System.out.println(num1[3] +" y "+ num2[1]);
		
	}

}
