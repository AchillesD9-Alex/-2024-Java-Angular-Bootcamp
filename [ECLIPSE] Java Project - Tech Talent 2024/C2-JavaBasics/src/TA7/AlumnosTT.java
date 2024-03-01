package TA7;

import java.util.HashMap;

public class AlumnosTT {

	public static void main(String[] args) {
	HashMap <String, Integer> estudiantesTT = new HashMap<>();
		estudiantesTT.put("Laia", 23);
		estudiantesTT.put("Aurora", 30);
		estudiantesTT.put("Alexandre", 28);
		estudiantesTT.put("Jose", 26);
		estudiantesTT.put("Santos", 24);
		estudiantesTT.put("Manel", 26);
		estudiantesTT.put("Alejandro", 19);
		estudiantesTT.put("Isabel", 19);
		estudiantesTT.put("Toni", 23);
		estudiantesTT.put("Diego", 22);
		estudiantesTT.put("Sebas", 29);
		estudiantesTT.put("Abdel", 19);
		estudiantesTT.put("Joel", 19);
		estudiantesTT.put("Jessica", 26);
		estudiantesTT.put("Ana", 29);
		
	
	}
	
//	public static int[] crearYrellenarArrayRANDOM(int lengthArray) { -->length HashMap
        
        int array[] = new int[lengthArray];
        
        for (int i = 0; i <lengthArray; i++) {
                int randomNum = (int)(Math.random()* (300 - 1 +1)) +1;
                array[i] = randomNum;
        }
    
    return array;
    }
	
	public static void imprimirEdad (HashMap<String, Integer> listadoAlumnos) {
  	  for (int edad : listadoAlumnos.values()) {
  	        System.out.println(edad);
  	  }	
	}
	
	public static void imprimirNombre (HashMap<String, Integer> listadoAlumnos) {
	  	  for (String nombre : listadoAlumnos.keySet()) {
	  	        System.out.println(nombre);
	  	  }	
	}
}
