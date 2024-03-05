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

public class Ej02CajaSupermercadoPulidoMetodos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean otroCliente = true;
        double gananciasBrutoTotal = 0;
        double gananciasNetoTotal = 0;

        while (otroCliente) {
            HashMap<String, Double[]> compra = new HashMap<>();
            
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
                System.out.println("\n-- CAJA FINAL --"
                		+"\nGanancias totales (Bruto): " + gananciasBrutoTotal +
                        "\nGanancias totales (Neto): " + gananciasNetoTotal);
            }
        }

        sc.close();
    }

//  Va pidiendo los artículos conformen pasan por caja
    public static void comprarArticulos(Scanner sc, HashMap<String, Double[]> compra) {
        double totalDeArticulos = 0;
        do {
            System.out.println("Ingrese el nombre del artículo:");
            String nombreProductoComprado = sc.nextLine();

            System.out.println("¿Cuál es el precio del artículo?");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.println("¿Cuál es el IVA del artículo? (4% o 21%)");
            double iva = Double.parseDouble(sc.nextLine());

            double precioConIVA = calcularPrecioConIVA(precio, iva);

            compra.put(nombreProductoComprado, new Double[]{precio, precioConIVA, iva});
            totalDeArticulos++;

            System.out.println("¿Desea añadir otro artículo? (Y/N)");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
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

//  Devuelve por consola Total Bruto y Total Neto
    public static void imprimirTotalesCompra(double totalCompraBruto, double totalCompraNeto) {
        System.out.println("Total de la compra (Bruto): " + totalCompraBruto +
                "\nTotal de la compra (Neto): " + totalCompraNeto);
    }

//  Pide el método de pago: efectivo o tarjeta
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
                System.out.println("Método de pago no reconocido"
                        + "(escribe \'efectivo\' o \'tarjeta\' la siguiente vez.");
                break;
        }
    }

//  Calcula el precio neto a partir del bruto y su IVA
    public static double calcularPrecioConIVA(double precio, double iva) {
        return precio * (1 + iva / 100);
    }
    
}