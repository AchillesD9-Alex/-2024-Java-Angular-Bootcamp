package TA5;

public class Ej01 {

	public static void main(String[] args) {
		int a = 5, b = 5;
		
		System.out.println("El valor de la variable A es " + a +
				" y el de la variable B es " + b +".\n");
		
		if(a > b) {
			System.out.println("En este caso, el valor de A (" + a +
					") es mayor que el valor de B (" + b + ")");
		}else {
			if(a < b) {
				System.out.println("En este caso, el valor de B (" + b +
						") es mayor que el valor de A (" + a + ")");
				
			}else {System.out.println("En este caso, el valor de A (" + a +
					") es IGUAL que el valor de B (" + b + ")");
				}
			}
		}
	}


