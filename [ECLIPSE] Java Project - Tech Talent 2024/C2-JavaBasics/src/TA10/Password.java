package TA10;

import java.util.Random;

public class Password {
    private static final int LONGITUD_MINIMA = 8; // Longitud mínima de contraseña
    private int longitud;
    private String contraseña;

    // Constructor por defecto
    public Password() {
        this.longitud = LONGITUD_MINIMA; // Establecer longitud mínima por defecto
        this.contraseña = generarPassword();
    }

    // Constructor con longitud personalizada
    public Password(int longitud) {
        if (longitud < LONGITUD_MINIMA) {
            throw new IllegalArgumentException("La longitud de la contraseña debe ser al menos " + LONGITUD_MINIMA);
        }
        this.longitud = longitud;
        this.contraseña = generarPassword();
    }

    // Método para verificar si la contraseña es fuerte
    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (int i = 0; i < contraseña.length(); i++) {
            char caracter = contraseña.charAt(i);
            if (Character.isUpperCase(caracter)) {
                mayusculas++;
            } else if (Character.isLowerCase(caracter)) {
                minusculas++;
            } else if (Character.isDigit(caracter)) {
                numeros++;
            }
        }

        return mayusculas > 2 && minusculas > 1 && numeros > 5;
    }

    // Método para generar una contraseña aleatoria
    private String generarPassword() {
        StringBuilder pass = new StringBuilder();
        Random random = new Random();
        String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String caracteres = letrasMayusculas + letrasMinusculas + numeros;

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            pass.append(caracteres.charAt(indice));
        }

        return pass.toString();
    }

    // Getters y setters
    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }
    
    public static int getLongitudMinima() {
        return LONGITUD_MINIMA;
    }

    public void setLongitud(int longitud) {
        if (longitud < LONGITUD_MINIMA) {
            throw new IllegalArgumentException("La longitud de la contraseña debe ser al menos " + LONGITUD_MINIMA);
        }
        this.longitud = longitud;
        this.contraseña = generarPassword(); // Regenerar la contraseña con la nueva longitud
    }

    // Método para regenerar la contraseña con la longitud actual
    public void regenerarContraseña() {
        this.contraseña = generarPassword();
    }
}

