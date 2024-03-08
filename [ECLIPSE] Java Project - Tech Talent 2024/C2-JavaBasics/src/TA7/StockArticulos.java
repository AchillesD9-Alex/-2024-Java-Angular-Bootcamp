package TA7;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class StockArticulos {

    //	ATRIBUTOS
    String nombre;
    double precioBruto;
    double IVA;
    int cantidad;

    // Lista para almacenar los productos
    static List<StockArticulos> inventario = new ArrayList<>();

    //	CONSTRUCTORES
    public StockArticulos() {
        this.nombre = "##";
        this.precioBruto = 0.0;
        this.IVA = 0.0;
        this.cantidad = 0;
    }

    public StockArticulos(String nombre, double precioBruto, double IVA, int cantidad) {
        this.nombre = nombre;
        this.precioBruto = precioBruto;
        this.IVA = IVA;
        this.cantidad = cantidad;
    }

    public static void agregarArticulo() {
        String nombre = JOptionPane.showInputDialog
        		("Ingrese el nombre del artículo:");
        			nombre = nombre.toUpperCase(); // Convertir a mayúsculas
        double precioBruto = Double.parseDouble(JOptionPane.showInputDialog
        		("Ingrese el precio bruto del artículo:"));
        double IVA = Double.parseDouble(JOptionPane.showInputDialog
        		("Ingrese el IVA del artículo:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog
        		("Ingrese la cantidad del artículo:"));

        StockArticulos producto = new StockArticulos(nombre, precioBruto, IVA, cantidad);
        inventario.add(producto);

        if (inventario.size() >= 10) {
            JOptionPane.showMessageDialog(null,
            		"¡El inventario contiene 10 o más productos!",
            			"Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,
        			"¡Artículo agregado correctamente!",
        				"Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void eliminarArticulo() {
        String nombre = JOptionPane.showInputDialog
        		("Ingrese el nombre del artículo a eliminar:");
        			nombre = nombre.toUpperCase(); // Convertir a mayúsculas

        Iterator<StockArticulos> iterator = inventario.iterator();
        while (iterator.hasNext()) {
            StockArticulos producto = iterator.next();
            
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                iterator.remove();
                JOptionPane.showMessageDialog(null,
                			"¡Artículo eliminado correctamente!",
                				"Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null,
        		"El artículo '" + nombre + "' no existe en el inventario.",
        			"Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void modificarCantidad() {
        String nombre = JOptionPane.showInputDialog
        			("Ingrese el nombre del artículo cuya cantidad desea modificar:");
        				nombre = nombre.toUpperCase(); // Convertir a mayúsculas

        for (StockArticulos producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog
                		("Ingrese la nueva cantidad para el artículo '" + nombre + "':"));
                			producto.cantidad = nuevaCantidad;
		        JOptionPane.showMessageDialog(null,
		        		"¡Cantidad modificada correctamente!",
                        	"Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,
        		"El artículo '" + nombre + "' no existe en el inventario.",
        			"Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarStock() {
        StringBuilder stock = new StringBuilder("Inventario Actual:\n");
        
        for (StockArticulos producto : inventario) {
            stock.append(producto.nombre).append(": ").append(producto.cantidad).append("\n");
        }
        JOptionPane.showMessageDialog(null, stock.toString(),
                "Inventario Actual", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void listarProductos() {
        StringBuilder lista = new StringBuilder("Productos disponibles:\n");
        for (StockArticulos producto : inventario) {
            lista.append(producto.nombre).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(),
        		"Lista de Productos", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        StockArticulos leche = new StockArticulos("Leche", 1.10, 4, 20);
        	inventario.add(leche);
        StockArticulos pan = new StockArticulos("Pan", 0.90, 4, 30);
        	inventario.add(pan);
        StockArticulos huevos = new StockArticulos("Huevos", 2.50, 4, 40);
        	inventario.add(huevos);
        StockArticulos arroz = new StockArticulos("Arroz", 1.30, 21, 15);
        	inventario.add(arroz);
        StockArticulos pasta = new StockArticulos("Pasta", 1.25, 21, 25);
        	inventario.add(pasta);
        StockArticulos tomates = new StockArticulos("Tomates", 2.35, 21, 35);
        	inventario.add(tomates);
        StockArticulos patatas = new StockArticulos("Patatas", 2.10, 21, 10);
        	inventario.add(patatas);
        StockArticulos manzanas = new StockArticulos("Manzanas", 1.75, 21, 45);
        	inventario.add(manzanas);
        

        boolean continuar = true; // Variable para controlar si continuar en el bucle while

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" + "1. Agregar artículo\n" + "2. Eliminar artículo\n"
                            + "3. Modificar cantidad\n" + "4. Mostrar stock\n" + "5. Salir",
                    "Menú de Opciones", JOptionPane.PLAIN_MESSAGE);

            switch (opcion) {
                case "1":
                    agregarArticulo();
                    break;
                case "2":
                    eliminarArticulo();
                    break;
                case "3":
                    modificarCantidad();
                    break;
                case "4":
                    mostrarStock();
                    // Preguntar al usuario si desea continuar después de mostrar el stock
                    continuar = JOptionPane.showConfirmDialog(null,
                    		"¿Desea realizar otra acción?", "Continuar",
                    			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
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
}
