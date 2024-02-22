package TA7;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListClase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> lista = new ArrayList<>();
		
//		Metodo ADD, añade elementos a nuestra lista
		lista.add(1);
		lista.add(2);
		lista.add(3);
		System.out.println("ADD (1), (2) y (3). Son 3 valores y 3 posiciones\n" +lista.toString());
		
//		Metodo REMOVE, elimina elementos de la lista mediante el indice
		lista.remove(2); //Elimino el último elemento, no el valor 2 del indice 1 !!
		System.out.println("REMOVE(2), posición\n" +lista.toString());
		
//		Metodo SIZE, indica el numero de elementos de la lista
		System.out.println("SIZE\n" +lista.toString());
		
//		Metodo GET, devolvemos un elemento de un indice
		System.out.println("GET(0), primer elemento\n" +lista.get(0)); //Primer elemento
		
//		Metodo ITERATOR, util para recorrer un arrayList
		System.out.println("ITERATOR y devuelve el arrayList");
		Iterator<Integer> it = lista.iterator();
		int num;
		while (it.hasNext()) {			//Mientras el iterator it tenga un valor a continuación
			num = it.next();			//Se guardará ese valor en la variable num
			System.out.println(num);	//Y se devovlerá ese valor 
		}
		
//		Metodo indexOf, util para saber la posición de un elemento
		System.out.println("indexOf(1), devuelve posicion del valor 1:\n" +lista.indexOf(1)); //Devuelve la posición del valor 1
		
//		Metodo CLEAR, elimina TODOS los elementos
		lista.clear();
		
		System.out.println("CLEAR, elimina TODOS los valores del arrayList\n" +lista.toString());
		
	}

}
