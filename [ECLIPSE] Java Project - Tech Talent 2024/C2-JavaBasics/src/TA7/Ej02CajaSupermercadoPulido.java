package TA7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/* Gestiona el flujo de ventas de un supermercado:
 * Debes guardar los productos comprados.
 * Mostrará por pantalla:
 	IVA aplicado (4 ó 21%) / precio bruto / precio neto
 	Cantidad de artículos comprados / Pago / Devolución 
 */

public class Ej02CajaSupermercadoPulido {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double[]> compra = new HashMap<>();

        System.out.println("-- INICIO COMPRA --");
        double totalDeArticulos = 0;
        double totalCompraBruto = 0;
        double totalCompraNeto = 0;

        do {
            System.out.println("Ingrese el nombre del artículo:");
            String nombreProductoComprado = sc.nextLine();

            System.out.println("¿Cuál es el precio del artículo?");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.println("¿Cuál es el IVA del artículo? (4% o 21%)");
            double iva = Double.parseDouble(sc.nextLine());

            double precioConIVA = calcularPrecioConIVA(precio, iva);

            compra.put(nombreProductoComprado, new Double[]{precio, precioConIVA, iva});
            totalCompraBruto += precio;
            totalCompraNeto += precioConIVA;

            totalDeArticulos++;

            System.out.println("¿Desea añadir otro artículo? (Y/N)");
        } while (sc.nextLine().equalsIgnoreCase("Y"));

        System.out.println("-- RESUMEN DE LA COMPRA --");
        for (String nombreProducto : compra.keySet()) {
            Double[] detalles = compra.get(nombreProducto);
            
            double precioBruto = detalles[0];
            double precioNeto = detalles[1];
            double iva = detalles[2];
            System.out.println("Producto: " +nombreProducto+
            		"\nPrecio Bruto: " + precioBruto + "€ / Precio Neto: " + precioNeto +
            			"€ / IVA: " + iva + "%");
        }

        System.out.println("Total de artículos comprados: " + totalDeArticulos+
        	"\nTotal de la compra (Bruto): " + totalCompraBruto+
        	"\nTotal de la compra (Neto): " + totalCompraNeto);

        System.out.println("¿Efectivo o tarjeta?");
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
                System.out.println("Método de pago no reconocido"
                		+ "(escribe \'efectivo\' o \'tarjeta\' la siguiente vez");
                break;
        }

        sc.close();
    }

    public static double calcularPrecioConIVA(double precio, double iva) {
        return precio * (1 + iva / 100);
    }
            
}