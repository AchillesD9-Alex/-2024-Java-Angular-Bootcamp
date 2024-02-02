package TA2;

public class Test4 {
	public static void main (String args[]){
		
		//Palabras random para que aparezcan en la consola, con ENTER
		System.out.println("Hola");
		System.out.println("Adios");
		System.out.println("Cucu"); // El comando */ no aporta ningún comentario, por lo que lo quito

		for(int i=0; i<6; i++)
			//for (inicialización; condición; actualización) { (...) }
			//Elimino */ ya que no tiene sentido y genera error, aunque era para poner un comentario, pero he decidido borrarlo porque yo ya pongo bastantes
			//Elimino las comillas en el tercer espacio del for para que se pueda ejecutar lo que quiero, que es añadir +1 (i++) al valor de la variable i  
			
		System.out.println(i);
			// Cambio i+ por i, para que enseñe la variable cada vez que se actualice hasta el final del bucle for
			//Elimino las comillas para que no se coja como la letra, sino como la variable i creada con el int i=0 en el for
			//Cambio print a printlr para que los valores de la variable i salgan con el enter y no todo seguidos en la misma línea de la consola

		System.out.println("FIN DE PROGRAMA"); //Avisa de finalización de todo lo demás, ya que es la última línea del programa que se ejecuta
	
	}

}