package TA7;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;

/* Junta el ej 2 y 3. COnforme compres artículos, deberán restarse del stock.
 * Deben de conservarse las opciones del stock del ej 3.
 * Mejora lo que consideres oportuno.
 */

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
    
    public static StockArticulos buscarArticulo(String nombre) {
        for (StockArticulos producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static void modificarCantidad() {
        String nombre = JOptionPane.showInputDialog
        			("Ingrese el nombre del artículo cuya cantidad desea modificar:");
        				nombre = nombre.toUpperCase(); // Convertir a mayúsculas

        for (StockArticulos producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog
                	("Ingrese la nueva cantidad para el artículo '"+ nombre + "':"));
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
        StringBuilder stock = new StringBuilder("INVENTARIO ACTUAL:\n");
        
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
        StockArticulos leche = new StockArticulos("LECHE", 1.10, 4, 20);
        	inventario.add(leche);
        StockArticulos pan = new StockArticulos("PAN", 0.90, 4, 30);
        	inventario.add(pan);
        StockArticulos huevos = new StockArticulos("HUEVOS", 2.50, 4, 40);
        	inventario.add(huevos);
        StockArticulos arroz = new StockArticulos("ARROZ", 1.30, 21, 15);
        	inventario.add(arroz);
        StockArticulos pasta = new StockArticulos("PASTA", 1.25, 21, 25);
        	inventario.add(pasta);
        StockArticulos tomates = new StockArticulos("TOMATES", 2.35, 21, 35);
        	inventario.add(tomates);
        StockArticulos patatas = new StockArticulos("PATATAS", 2.10, 21, 10);
        	inventario.add(patatas);
        StockArticulos manzanas = new StockArticulos("MANZANAS", 1.75, 21, 45);
        	inventario.add(manzanas);
        
        Scanner sc = new Scanner(System.in);
        boolean otroCliente = true;
        double gananciasBrutoTotal = 0;
        double gananciasNetoTotal = 0;

        while (otroCliente) {
			HashMap<String, Double[]> compra = new HashMap<>();
			
			System.out.println("Este es el stock actual de la tienda:\n");
			mostrarStock();
			
			System.out.println("-- INICIO COMPRA --");
			comprarArticulos(sc, compra);
			imprimirResumenCompra(compra);

			double totalCompraBruto = calcularTotalCompraBruto(compra);
			double totalCompraNeto = calcularTotalCompraNeto(compra);
			gananciasBrutoTotal += totalCompraBruto;
			gananciasNetoTotal += totalCompraNeto;
			imprimirTotalesCompra(totalCompraBruto, totalCompraNeto);
			procesarPago(sc, totalCompraNeto);

			System.out.println("¿Hay otro cliente? (Y/N)");
			String respuesta = sc.nextLine().toUpperCase();

			if (!respuesta.equals("Y")) {
				otroCliente = false;
				System.out.println("\n-- CAJA FINAL --" +
						"\nGanancias totales (Bruto): " + gananciasBrutoTotal
						+ "\nGanancias totales (Neto): " + gananciasNetoTotal);
				
			} else {
				mostrarOpcionesInventario();
			}

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
                    
//			CIERRE SWITCH
            }
            
//		CIERRE WHILE
        }
      }
//	CIERRE MAIN 
    }
    
//  METODOS EJ2
 

 // Va pidiendo los artículos conforme pasan por caja
    public static void comprarArticulos(Scanner sc, HashMap<String, Double[]> compra) {
        double totalDeArticulos = 0;
        do {
            System.out.println("Ingrese el nombre del artículo:");
            String nombreProductoComprado = sc.nextLine();

            // Buscar el artículo en el inventario
            StockArticulos articulo = buscarArticulo(nombreProductoComprado);

            if (articulo != null) {
                System.out.println("Cantidad disponible: " + articulo.cantidad);

                // Verificar si hay suficiente cantidad en el inventario
                System.out.println("¿Cuántos desea comprar?");
                int cantidad = Integer.parseInt(sc.nextLine());
                if (cantidad > articulo.cantidad) {
                    System.out.println("No hay suficiente cantidad disponible.");
                    continue;
                }

                // Agregar el artículo a la compra
                double precioConIVA = calcularPrecioConIVA(articulo.precioBruto, articulo.IVA);
                compra.put(nombreProductoComprado, new Double[]{articulo.precioBruto, precioConIVA, articulo.IVA, (double) cantidad});
                totalDeArticulos++;
                // Restar la cantidad comprada del inventario
                articulo.cantidad -= cantidad;
            } else {
                System.out.println("El artículo no está disponible en el inventario.");
            }

            System.out.println("¿Desea añadir otro artículo? (Y/N)");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }
    
    // Método para procesar el pago
    public static void procesarPago(Scanner sc, double totalCompraNeto) {
        System.out.println("\n¿Efectivo o tarjeta?");
        String tipoPago = sc.nextLine().toUpperCase();

        switch (tipoPago) {
            case "EFECTIVO":
                System.out.println("Introduzca la cantidad entregada:");
                double efectivoEntregado = Double.parseDouble(sc.nextLine());
                double cambio = efectivoEntregado - totalCompraNeto;
                if (cambio >= 0) {
                    System.out.println("Pago recibido. Su cambio es: " + cambio);
                } else {
                    System.out.println("La cantidad entregada es insuficiente.");
                }
                break;
            case "TARJETA":
                System.out.println("Pago con tarjeta realizado.");
                break;
            default:
                System.out.println("Método de pago no reconocido (escribe 'efectivo' o 'tarjeta' la siguiente vez).");
                break;
        }
    }
//  Te da el tiquet de la compra
    public static void imprimirResumenCompra(HashMap<String, Double[]> compra) {
        System.out.println("-- RESUMEN DE LA COMPRA --");
        for (String nombreProducto : compra.keySet()) {
            Double[] detalles = compra.get(nombreProducto);

            double precioBruto = detalles[0];
            double precioNeto = detalles[1];
            double iva = detalles[2];
            System.out.println("Producto: " + nombreProducto +
                    "\nPrecio Bruto: " + precioBruto + "€ / Precio Neto: " + precioNeto +
                    "€ / IVA: " + iva + "%");
        }
    }
    
//  Devuelve por consola Total Bruto y Total Neto
    public static void imprimirTotalesCompra(double totalCompraBruto, double totalCompraNeto) {
        System.out.println("Total de la compra (Bruto): " + totalCompraBruto +
                "\nTotal de la compra (Neto): " + totalCompraNeto);
    }
//	Método para mostrar opciones del inventario
    public static void mostrarOpcionesInventario() {
        System.out.println("\nOpciones del inventario:"
                + "\n1. Agregar artículo"
                + "\n2. Eliminar artículo"
                + "\n3. Modificar cantidad"
                + "\n4. Mostrar stock"
                + "\n5. Salir");
    }
    
//  Calcula el precio neto a partir del bruto y su IVA
    public static double calcularPrecioConIVA(double precio, double iva) {
        return precio * (1 + iva / 100);
    }
    
//  Calcula el total Bruto de la compra
    public static double calcularTotalCompraBruto(HashMap<String, Double[]> compra) {
        double totalCompraBruto = 0;
        for (Double[] detalles : compra.values()) {
            totalCompraBruto += detalles[0];
        }
        return totalCompraBruto;
    }

//  Calcula el total Neto de la compra
    public static double calcularTotalCompraNeto(HashMap<String, Double[]> compra) {
        double totalCompraNeto = 0;
        for (Double[] detalles : compra.values()) {
            totalCompraNeto += detalles[1];
        }
        return totalCompraNeto;
    }
}
