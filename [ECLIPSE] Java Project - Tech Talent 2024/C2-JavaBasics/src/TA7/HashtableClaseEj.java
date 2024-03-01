package TA7;

import java.util.HashMap;

import java.util.Scanner;

public class HashtableClaseEj {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in); 
//      Crear un HashMap con clave de tipo String y valor de tipo Integer
        HashMap<String, Integer> edadesAlumnos = new HashMap<>();


//      Agregar elementos al HashMap Y ACTUALIZAR
        edadesAlumnos.put("Juan", 25);
        edadesAlumnos.put("María", 30);
        edadesAlumnos.put("Pedro", 28);

        // Obtener el tamaño del HashMap
        int tamaño = edadesAlumnos.size();
        System.out.println("Tamaño del edadesAlumnos: " + tamaño);
        
//    	Crear un método que realice los put() para asignar key=>value
//    	Entrada de datos por consola los parámetros
//    	Crear dos alumnos mas en edadesAlumnos
        
        System.out.println("¿Cuantas personas más quieres añadir?");
        	int personasAdicionales = sc.nextInt();
        System.out.println("¡Vamos a añadir " +personasAdicionales+ " personas más al listado!");
       
        int totalAlumnos = tamaño + personasAdicionales;
        int i = tamaño;
        do {
        	System.out.println("Persona número " +(++tamaño)+":");
          infoRequest(edadesAlumnos);
           i++;
        
        }while(i<(totalAlumnos));
        
        tamaño = edadesAlumnos.size();
        System.out.println("Tamaño actualizado del edadesAlumnos: " + tamaño);
        
    	System.out.println("\nEl listado nuevo es:"
    			+ "\nNombre / Edad");
    	imprimirKey_asociado_Value(edadesAlumnos);
    	
    	sc.close();
    }
    
    
    public static void infoRequest(HashMap <String, Integer> listadoHashmap) {
    	String nombreAlumno;
    	int edadAlumno;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("¿Como se llama el nuevo alumno?");
    		nombreAlumno = sc.nextLine();
    	System.out.println("¿Cual es su edad?");
    		edadAlumno = sc.nextInt();
    	
    	listadoHashmap.put(nombreAlumno, edadAlumno);
    	
    }
    
//	Devuelve KEY / VALUE(KEY), para mostrar listados del Hashmap
    public static void imprimirKey_asociado_Value (HashMap <String, Integer> listadoHashmap) {
    // Iterar sobre las claves del HashMap
    	for (String key : listadoHashmap.keySet()) {
        int valueDeKey = listadoHashmap.get(key);
        	System.out.println(key+ " / " +valueDeKey);
    	}	
    }
    
//	No lo uso; devuelve el value todas las key del Hashmap
    public static void imprimirValue (HashMap<String, Integer> listadoHashmap) {
        // Iterar sobre las claves del HashMap
    	  for (int value : listadoHashmap.values()) {
    	        System.out.println(value);
    	  }	
    }

        
}