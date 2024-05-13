package TA10;

public class TA10Ej02_Exception {
    public static void main(String[] args) {
//    	Empieza bucle try-throw-catch-finally
        try {
            System.out.println("Mensaje mostrado por pantalla");
            
          //Instanciamos CusteomException y le añadimos el mensaje que queremos
            throw new CustomException("Esto es un objeto Exception");
            	//con throw, a partir de aqui ya no lee nada.
          
        // Creamos el objeto de la class CustomException y aplicamos las instrucciones que queremos.
        } catch (CustomException elObCapturadorrr) {
        	System.out.println("Excepción capturada con mensaje: " + elObCapturadorrr.getMessage());
        	
//      Se realiza independientemente de que se realice una expeción o no	
        } finally { 
            System.out.println("Programa terminado"); 
        }
    }
}

class CustomException extends Exception {
    public CustomException(String mensaje) {
        super(mensaje);
    }
}

/* 
 * En Java, todas las excepciones deben ser subclases de la clase base Throwable, ya sea directa o indirectamente.
 * La clase Throwable tiene dos subclases principales: Exception y Error.
 * Como esperamos que sea una excepción que el programa pueda tratar, extendemos Exception.
 * Generamos el constructor con un string para poder introducir más tarde el mensaje que queremos.
 * Con throw new instaciamos la expeción de tpo CustomException y la capturamos y nombramos en catch.
 * En catch expresamos las instrucciones necesarias para que podamos tratar esa CustomException.
 * finally se ejecuta independientemente de que se haya generado y tratado una CustomException o no.
*/
