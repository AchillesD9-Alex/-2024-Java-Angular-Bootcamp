package TA7;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableClase {
    public static void main(String[] args) {
        // Crear un HashMap con clave de tipo String y valor de tipo Integer
        HashMap<String, Integer> edadesAlumnos = new HashMap<>();
        Hashtable<String, Integer> edadesAlumnos2 = new Hashtable<String, Integer>();

        // Agregar elementos al HashMap Y ACTUALIZAR
        edadesAlumnos.put("Juan", 25);
        edadesAlumnos.put("María", 30);
        edadesAlumnos.put("Pedro", 28);

        // Obtener el valor asociado a una clave
        int edadDeJuan = edadesAlumnos.get("Juan");
        System.out.println("Edad de Juan: " + edadDeJuan);

        // Iterar sobre las claves del HashMap
        System.out.println("Claves en el edadesAlumnos:");
        for (String nombre : edadesAlumnos.keySet()) {
            System.out.println(nombre);
        }

        // Iterar sobre los valores del HashMap
        System.out.println("Valores en el edadesAlumnos:");
        for (int edad : edadesAlumnos.values()) {
            System.out.println(edad);
        }

        // Comprobar si una clave está en el HashMap
        boolean contienePedro = edadesAlumnos.containsKey("Pedro");
        System.out.println("¿El edadesAlumnos contiene a Pedro? " + contienePedro);

        // Eliminar un elemento del HashMap
        edadesAlumnos.remove("María");

        // Obtener el tamaño del HashMap
        int tamaño = edadesAlumnos.size();
        System.out.println("Tamaño del edadesAlumnos: " + tamaño);
    }
}