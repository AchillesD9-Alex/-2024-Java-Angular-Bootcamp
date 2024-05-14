package TA10;

import java.util.Scanner;

public class TA10Ej05_Password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;

        while (repetir) {
            int longitud = obtenerLongitud(scanner); // Obtener la longitud
            int cantidad = obtenerCantidad(scanner); // Obtener la cantidad de passwords

            // Crear un array de Passwords
            Password[] passwords = new Password[cantidad];
            boolean[] esFuerte = new boolean[cantidad];

            // Generar los passwords y determinar si son fuertes o no
            for (int i = 0; i < cantidad; i++) {
                passwords[i] = new Password(longitud);
                esFuerte[i] = passwords[i].esFuerte();
            }

            // Mostrar los passwords y si son fuertes o no con formato personalizado
            System.out.println("Contraseña\t/ Es Fuerte");
            for (int i = 0; i < cantidad; i++) {
                System.out.printf("%s\t/ %b\n", passwords[i].getContraseña(), esFuerte[i]);
            }

            // Preguntar al usuario si desea transformar contraseñas débiles en fuertes
            if (preguntarTransformarDebiles(scanner, passwords, esFuerte)) {
                for (int i = 0; i < cantidad; i++) {
                    if (!esFuerte[i]) {
                        // Transformar la contraseña débil en fuerte
                        passwords[i].regenerarContraseña();
                        esFuerte[i] = true;
                    }
                }

                // Mostrar las contraseñas actualizadas
                System.out.println("Contraseñas actualizadas:");
                for (int i = 0; i < cantidad; i++) {
                    System.out.printf("%s\t/ %b\n", passwords[i].getContraseña(), esFuerte[i]);
                }
            }

            repetir = preguntarSiRepetir(scanner); // Preguntar si repetir la ejecución
        }

        System.out.println("Programa terminado.");
        scanner.close(); // Cerrar el scanner al finalizar
    }

 // Método para obtener la longitud con manejo de excepciones
    private static int obtenerLongitud(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingrese la longitud de los passwords (mínimo " + Password.getLongitudMinima() + "): ");
                int longitud = scanner.nextInt();
                if (longitud < Password.getLongitudMinima()) {
                    throw new IllegalArgumentException("La longitud de la contraseña debe ser al menos " + Password.getLongitudMinima());
                }
                return longitud;
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
    }


    // Método para obtener la cantidad de passwords con manejo de excepciones
    private static int obtenerCantidad(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de passwords a generar: ");
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
    }

    // Método para preguntar al usuario si desea transformar contraseñas débiles en fuertes
    private static boolean preguntarTransformarDebiles(Scanner scanner, Password[] passwords, boolean[] esFuerte) {
        while (true) {
            try {
                System.out.print("¿Desea transformar contraseñas débiles en fuertes? (S/N): ");
                String respuesta = scanner.next().toUpperCase();
                if (respuesta.equals("S")) {
                    // Verificar si hay contraseñas débiles
                    for (boolean fuerte : esFuerte) {
                        if (!fuerte) {
                            return true; // Si hay contraseñas débiles, retornar true
                        }
                    }
                    System.out.println("No hay contraseñas débiles para transformar.");
                    return false; // Si no hay contraseñas débiles, retornar false
                } else if (respuesta.equals("N")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Ingrese S o N.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Método para preguntar al usuario si desea repetir la ejecución
    private static boolean preguntarSiRepetir(Scanner scanner) {
        while (true) {
            try {
                System.out.print("¿Desea generar más contraseñas? (S/N): ");
                String respuesta = scanner.next().toUpperCase();
                if (respuesta.equals("S")) {
                    return true;
                } else if (respuesta.equals("N")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Ingrese S o N.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
