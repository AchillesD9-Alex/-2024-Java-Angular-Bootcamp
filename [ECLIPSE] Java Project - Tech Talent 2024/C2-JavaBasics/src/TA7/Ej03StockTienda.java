package TA7;

import java.util.HashMap;
import javax.swing.JOptionPane;

/* Crea una base de datos de 10 artículos para controlar el stock de productos
  	de una tienda por medio de un HASHMAP (articulo:precio).
 * El usuario podrá añadir, por medio de interfaz visual, artículos nuevos y
 	cantidades de estos.
 * El usario podrá consultar la información almacenada en el diccionario referente
 	a un articulo concreto e incluso listar toda la información en la terminal del programa.
 */

public class Ej03StockTienda {
    public static void main(String[] args) {
        HashMap<String, Integer> inventario = new HashMap<>();

        agregarProducto(inventario, "Leche", 20);
        agregarProducto(inventario, "Pan", 30);
        agregarProducto(inventario, "Huevos", 40);
        agregarProducto(inventario, "Arroz", 15);
        agregarProducto(inventario, "Pasta", 25);
        agregarProducto(inventario, "Tomates", 35);
        agregarProducto(inventario, "Patatas", 10);
        agregarProducto(inventario, "Manzanas", 45);

        if (inventario.size() >= 10) {
            JOptionPane.showMessageDialog(null, "¡El inventario contiene 10 o más productos!",
            		"Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

        boolean continuar = true; // Variable para controlar si continuar en el bucle while

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,
            		"Seleccione una opción:\n" +
            				"1. Agregar artículo\n" +
                            "2. Eliminar artículo\n" +
                            "3. Modificar cantidad\n" +
                            "4. Mostrar stock\n" +
                            "5. Salir", "Menú de Opciones", JOptionPane.PLAIN_MESSAGE);

            switch (opcion) {
                case "1":
                    listarProductos(inventario);
                    agregarArticulo(inventario);
                    break;
                case "2":
                    listarProductos(inventario);
                    eliminarArticulo(inventario);
                    break;
                case "3":
                    listarProductos(inventario);
                    modificarCantidad(inventario);
                    break;
                case "4":
                    mostrarStock(inventario);
                    // Preguntar al usuario si desea continuar después de mostrar el stock
                    continuar = JOptionPane.showConfirmDialog(null,
                    		"¿Desea realizar otra acción?",
                    			"Continuar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    break;
                case "5":
                    continuar = false; // Salir del bucle
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                    		"Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void agregarProducto(HashMap<String, Integer> inventario, String nombre, int cantidad) {
        inventario.put(nombre.toUpperCase(), cantidad);
    }
    
    public static void agregarArticulo(HashMap<String, Integer> inventario) {
        String nombre = JOptionPane.showInputDialog
        			("Ingrese el nombre del artículo:");
        
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog
        			("Ingrese la cantidad del artículo:"));

        	agregarProducto(inventario, nombre, cantidad);

        if (inventario.size() >= 10) {
            JOptionPane.showMessageDialog(null,
            		"¡El inventario contiene 10 o más productos!",
            			"Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
        		"¡Artículo agregado correctamente!",
        			"Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarStock(HashMap<String, Integer> inventario) {
        JOptionPane.showMessageDialog(null, inventario.toString(),
        		"Inventario Actual", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void eliminarArticulo(HashMap<String, Integer> inventario) {
        String nombre = JOptionPane.showInputDialog
        		("Ingrese el nombre del artículo a eliminar:");
        	inventario.remove(nombre);
        	
        JOptionPane.showMessageDialog(null,
        		"¡Artículo eliminado correctamente!",
        			"Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void modificarCantidad(HashMap<String, Integer> inventario) {
        String nombre = JOptionPane.showInputDialog
        		("Ingrese el nombre del artículo cuya cantidad desea modificar:");
        
        if (inventario.containsKey(nombre)) {
            int cantidadActual = inventario.get(nombre);
            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog
            		("Ingrese la nueva cantidad para el artículo '" + nombre + "':"));
            	inventario.put(nombre, nuevaCantidad);
            	
            	JOptionPane.showMessageDialog(null,
            			"¡Cantidad modificada correctamente!",
            				"Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
            		"El artículo '" + nombre + "' no existe en el inventario.",
            			"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void listarProductos(HashMap<String, Integer> inventario) {
        StringBuilder lista = new StringBuilder("Productos disponibles:\n");
        for (String producto : inventario.keySet()) {
            lista.append(producto).append("\n");
        }
        JOptionPane.showMessageDialog(null,
        		lista.toString(), "Lista de Productos", JOptionPane.PLAIN_MESSAGE);
    }
}
