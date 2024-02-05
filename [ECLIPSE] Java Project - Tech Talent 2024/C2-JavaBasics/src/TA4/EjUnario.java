package TA4;

public class EjUnario {
	
	public static void main(String[] args) {
	
	/*Operador = 10, y mostrar operador.*/
	int op=10;
	System.out.println("El valor del operador es "+op);
	
	/*operador++ y mostrar*/
	op++;
	System.out.println("El valor del operador++ es "+op);
		
	/*++operador y mostrar*/
	++op;
	System.out.println("El valor del ++operador es "+op);
	System.out.println("");
	
	/*Pero, si lo hacemos en el System.out directamente...*/
	op=10;
	System.out.println(op); //Muestra op, que es 10.
	System.out.println(op++); //Muestra op, que vale 10, y luego le suma +1, por lo que op = 11 ahora.
								//No queda registro de este +1
	System.out.println(++op); //Le suma +1 al op (11 que valía +1 = 12) y luego lo muestra.
	
	}
}
