package TA7;

import java.util.HashMap;

import java.util.Scanner;

/* Pide el numero de alumnos del curso de programación.
 * Crea un Hashmap para guardar sus nombres y su nota media.
 * La nota media se calculará mediante un método (parcialA + parcialB).
 * Todos estos datos se han de proporcionar por pantalla.
 */

public class Ej01NotasAlumnos {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in); 
//      Crear un HashMap con clave de tipo String y valor de tipo Integer
        HashMap<String, Double> notaMediaAlumnos = new HashMap<>();
        
        System.out.println("¿Cuantos alumnos hay en el curso?");
        	int alumnosTotales = sc.nextInt();
       
        int i = 0;
        do {
        	System.out.println("Alumno número " +(i+1)+":");
          infoRequest(notaMediaAlumnos);
           i++;
        
        }while(i<alumnosTotales);
               
    	System.out.println("\nEl listado de alumnos con sus notas es:"
    			+ "\nNombre / Nota media");
    	imprimirKey_asociado_Value(notaMediaAlumnos);
    	
    	sc.close();
    }
    
    
    public static void infoRequest(HashMap <String, Double> listadoHashmap) {
     	Scanner sc = new Scanner(System.in);
    	String nombreAlumno;
    	double primerParcial; double segundoParcial; double notaMedia;
    	
    	System.out.println("¿Cual es su nombre?");
    		nombreAlumno = sc.nextLine();
    	System.out.println("Nota primer parcial:");
    		primerParcial = sc.nextDouble();
    	System.out.println("Nota segundo parcial:");
    		segundoParcial = sc.nextDouble();
    	
    	notaMedia = calcularMedia(primerParcial, segundoParcial);
    	
    	introducirInfoAlumno(listadoHashmap,nombreAlumno, notaMedia);
    }
    
    public static double calcularMedia (double notaPrimerParcial, double notaSegundoParcial) {
    	double notaMediaCalculada = ((notaPrimerParcial + notaSegundoParcial)/2);
    	return notaMediaCalculada;
    }
    
    public static void introducirInfoAlumno (HashMap <String, Double> listadoAlumnos, String nombreAlumno, double notaMedia) {
    	listadoAlumnos.put(nombreAlumno, notaMedia);
    }
    
//	Devuelve KEY / VALUE(KEY), para mostrar listados del Hashmap
    public static void imprimirKey_asociado_Value (HashMap <String, Double> listadoHashmap) {
    // Iterar sobre las claves del HashMap
    	for (String key : listadoHashmap.keySet()) {
        double valueDeKey = listadoHashmap.get(key);
        	System.out.println(key+ " / " +valueDeKey);
    	}	
    }
            
}