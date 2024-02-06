package TA5;

public class Ej9 {

	public static void main(String[] args) {

		System.out.println("¿Divisibles entre 2 y 3 del 1 al 100?\nOof... son estos:");
		
		for(int n = 1; n <= 100; n++) {
			if (n%2 == 0 || n%3 == 0){
				System.out.println(n);
			}
		}
		
	}

}
