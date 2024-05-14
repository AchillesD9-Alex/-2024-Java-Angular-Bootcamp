package TA10;

import java.util.Random;

public class TA10Ej03_ParImpar {

    public static void main(String[] args) {
        try {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(1000); //random [0-999]
            System.out.println("Generando numero aleatorio...");
            System.out.println("El numero aleatorio generado es: " + numeroAleatorio);
            
//     Determinamos si el número es par o impar
            if (esPar(numeroAleatorio)) {
                throw new ParException("Es PAR");
            } else {
                throw new ImparException("Es IMPAR");
            }
        } catch (ParException e) {
            System.out.println(e.getMessage());
        
        } catch (ImparException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}

class ParException extends Exception {
    public ParException(String message) {
        super(message);
    }
}

class ImparException extends Exception {
    public ImparException(String message) {
        super(message);
    }
}

