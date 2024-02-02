package TA2;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creación de un objeto Integer usando el segundo constructor
		Integer num1 = Integer.valueOf("125"); //No tiene sentido, pero lo dice el problema

		//Creación de un objeto Integer usando el primer constructor
		Integer num2 = Integer.valueOf(20);
		
		//Obtención del entero que almacena cada objeto Integer
		//Si no se hace esto, las líneas siguientes causarían error de compilación

		int n1=num1.intValue(); //Corrige el txt a num, es un paso que no debería de estar, pero hace que el programa acabe dando la suma correcta

		int n2=num2.intValue();

		System.out.println("Suma de "+n1+" y "+n2+" vale "+(n1+n2)); //Salida de frase

		if(n1+n2>130)
			n1++; //+1 al valor de la variable n1
		else
			n1--; //-1 al valor de la variable n1
		System.out.println(n1); //Nos expresa el nuevo valor en la consola
		}
	}