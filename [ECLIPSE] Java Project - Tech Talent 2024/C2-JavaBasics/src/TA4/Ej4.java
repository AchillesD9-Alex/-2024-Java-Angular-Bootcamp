package TA4;

public class Ej4 {

	public static void main(String[] args) {
		/*Crea una variable entera N y dale un valor*/
		int n=1;
		
		/*Sigue los siguientes pasos:
		 Incrementa N en 77
		 Decreenta en 3
		 Duplica su valor*/
		
		n += 77; // += Coge el valor anterior y, en este caso, le suma el siguiente valor que pongamos; es decir: n + 77)
		System.out.println(n);
		
		n -= 3; // -= Coge el valor anterior y, en este caso, le resta el siguiente valor que pongamos; es decir:  n - 3)
		System.out.println(n);
		
		n *= 2; //*= Coge el valor anterior y, en este caso, lo multiplica por el siguiente valor que pongamos; es decir:  n * 2)
		System.out.println(n);
		
		/*Si por ejemplo N = 1 la salida del programa será:
			Valor inicial de N = 1
			N + 77 = 78
			N - 3 = 75
			N * 2 = 150 */
			
		}
		
}