package TA7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/* Pide el numero de alumnos del curso de programación.
 * Crea un Hashmap para guardar sus nombres y su nota media.
 * La nota media se calculará mediante un método (parcialA + parcialB).
 * Todos estos datos se han de proporcionar por pantalla.
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
            System.out.println("Array detalles para " + nombreProducto + ": ");
            for (int i = 0; i < detalles.length; i++) {
                System.out.println("Elemento " + i + ": " + detalles[i]);
            }
            double precioBruto = detalles[0];
            double precioNeto = detalles[1];
            double iva = detalles[2];
            System.out.println("Producto: " + nombreProducto);
            System.out.println("Precio Bruto: " + precioBruto + "€ / Precio Neto: " + precioNeto + "€ / IVA: " + iva + "%");
            System.out.println();
        }

        System.out.println("Total de artículos comprados: " + totalDeArticulos);
        System.out.println("Total de la compra (Bruto): " + totalCompraBruto);
        System.out.println("Total de la compra (Neto): " + totalCompraNeto);

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
                System.out.println("Método de pago no reconocido.");
                break;
        }

        sc.close();
    }

    public static double calcularPrecioConIVA(double precio, double iva) {
        return precio * (1 + iva / 100);
    }
            
}