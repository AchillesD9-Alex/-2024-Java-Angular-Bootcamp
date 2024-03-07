package TA7;

import java.util.HashMap;
import javax.swing.JOptionPane;


public class StockArticulos {
	
//	ATRIBUTOS
	String nombre;
	double precioBruto;
	double IVA;
	int cantidad;
	
//	CONSTRUCTORES
	public StockArticulos()	{
		this.nombre = "##";
		this.precioBruto = 0.0;
		this.IVA = 0.0;
		this.cantidad = 0;
	}
	
	public StockArticulos(String name, double precioB, double IVAprod, int cantidad)	{
		this.nombre = "##";
		this.precioBruto = 0.0;
		this.IVA = 0.0;
		this.cantidad = 0;
	}
	
    public static void main(String[] args) {
       StockArticulos leche = new StockArticulos("Leche", 1.10, 4, 20);
       StockArticulos pan = new StockArticulos("Pan", 0.90, 4, 30);
       StockArticulos huevos = new StockArticulos("Huevos", 2.50, 4, 40);
       StockArticulos arroz = new StockArticulos("Arroz", 1.30, 21, 15);
       StockArticulos pasta = new StockArticulos("Pasta", 1.25, 21, 25);
       StockArticulos tomates = new StockArticulos("Tomates", 2.35, 21, 35);
       StockArticulos patatas = new StockArticulos("Patatas", 2.10, 21, 10);
       StockArticulos manzanas = new StockArticulos("Manzanas", 1.75, 21, 45);

//        if (inventario.size() >= 10) {
//            JOptionPane.showMessageDialog(null, "¡El inventario contiene 10 o más productos!",
//            		"Mensaje", JOptionPane.INFORMATION_MESSAGE);
//        }

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
        	inventario.remove(nombre.toUpperCase());
        	
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
