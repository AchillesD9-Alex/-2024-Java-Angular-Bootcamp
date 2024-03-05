package TA7;

import java.util.Arrays;
import java.util.HashMap;

public class TEAM_AlumnosTT {

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
		
	String arrayAlfabeto[] = ordenarAlfabeto(estudiantesTT);
	
	imprimirArray(arrayAlfabeto);
	gruposFinales(estudiantesTT);
	}
	
	public static void gruposFinales (HashMap <String, Integer> listadoAlumnos) {
//		Array origen de datos ordenados
		String arrayAlfabeto[] = ordenarAlfabeto(listadoAlumnos);
		
//		Arrays generados para cada grupo y "división" del arrayOG + imprimir en consola
		String grupo1[] = new String[3];
			System.arraycopy(arrayAlfabeto, 0, grupo1, 0, 3);
			System.out.println("\nGrupo1: ");
			imprimirArray(grupo1);
			
		String grupo2[] = new String[3];
			System.arraycopy(arrayAlfabeto, 3, grupo2, 0, 3);
			System.out.println("\nGrupo2: ");
			imprimirArray(grupo2);
			
		String grupo3[] = new String[3];
			System.arraycopy(arrayAlfabeto, 6, grupo3, 0, 3);
			System.out.println("\nGrupo3: ");
			imprimirArray(grupo3);
			
		String grupo4[] = new String[3];
			System.arraycopy(arrayAlfabeto, 9, grupo4, 0, 3);
			System.out.println("\nGrupo4: ");
			imprimirArray(grupo4);
			
		String grupo5[] = new String[3];
			System.arraycopy(arrayAlfabeto, 12, grupo5, 0, 3);
			System.out.println("\nGrupo5: ");
			imprimirArray(grupo5);		
		
	}
	
	public static String[] ordenarAlfabeto (HashMap <String, Integer> listadoAlumnos) {
		
		String arrayNombre[] = keyHashmap(listadoAlumnos);	
		Arrays.sort(arrayNombre);
		return arrayNombre;
	}
	
//	public static int[] crearYrellenarArrayRANDOM(int lengthArray) { -->length HashMap
//        
//        int array[] = new int[lengthArray];
//        
//        for (int i = 0; i <lengthArray; i++) {
//                int randomNum = (int)(Math.random()* (300 - 1 +1)) +1;
//                array[i] = randomNum;
//        }
//    
//    return array;
//    }
	
	public static String[] ordenarAleatorio(HashMap<String, Integer> listadoAlumnos) {
		int lengthArray = listadoAlumnos.size();
		boolean checkPosiciones[] = new boolean[lengthArray];
		String arrayNombre[] = keyHashmap(listadoAlumnos);
		String arrayNombreAleatorio[] = new String [lengthArray];
				
        int nuevaPosicion = 0;
        for (int i = 0; i < lengthArray; i++) {
            do {
                nuevaPosicion = (int) (Math.random() * lengthArray);
            } while (checkPosiciones[nuevaPosicion]);
            arrayNombreAleatorio[i] = arrayNombre[nuevaPosicion];
            checkPosiciones[nuevaPosicion] = true;
       
        }
        return arrayNombreAleatorio;
    }
	
	
	public static void imprimirEdad (HashMap<String, Integer> listadoAlumnos) {
  	  for (int edad : listadoAlumnos.values()) {
  	        System.out.println(edad);
  	  }	
	}
	
	public static String[] keyHashmap (HashMap<String, Integer> listadoAlumnos) {
		int lengthArray = listadoAlumnos.size();
		String nombreAlumno[] = new String[lengthArray];
		
		int indice = 0;
	  	  for (String key : listadoAlumnos.keySet()) {
	  	        nombreAlumno[indice++] = key;
	  	  }	
	return nombreAlumno;
	}
	
	public static void imprimirArray (String arrayEscogido[]) {
		for (int i = 0; i < arrayEscogido.length; i++) {
			System.out.print(arrayEscogido[i]);
			if (i < arrayEscogido.length -1) {
				System.out.print(", ");
			}
		}
	}
}
