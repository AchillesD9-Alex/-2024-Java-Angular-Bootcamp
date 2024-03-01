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

public class Ej02CajaSupermercado {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in); 
    	HashMap <String,Double> compra = new HashMap<>();
    	ArrayList<Double> aListIVA = new ArrayList<>();
    	ArrayList<Double> aListBruto = new ArrayList<>();
    	ArrayList<Double> aListNeto = new ArrayList<>();
    	ArrayList<String> aListProducto = new ArrayList<>();
       
    	System.out.println("-- INICIO COMPRA --");
    	double totalDeArticulos = 0;
    	double IVA = 0;
    	do {
    		System.out.println("El articulo es...");
    			String productoComprado = sc.nextLine();
    			aListProducto.add(productoComprado); 
    		System.out.println("¿Cual es el IVA del artículo? ( 4% o 21%)");
    			String seleccionIVA = sc.nextLine();
    			aListIVA.add(Double.parseDouble(seleccionIVA));
    	
    		switch (seleccionIVA){
    			case "4":
    				IVA = 4;
    				break;
    			case "21":
    				IVA = 21;
    				break;
    			default:
    				System.out.println("Introduce como entero un 4 o 21 según el IVA");
    				break;
    		}
    	
    		System.out.println("Introduce el precio BRUTO del artículo:");
    		double articuloAcomprar = sc.nextDouble();
    									sc.nextLine();
    		double compraBruto = precioTotalBruto(articuloAcomprar);
    		double compraNeto = precioTotalIVA(articuloAcomprar, IVA);
    			aListBruto.add(compraBruto);
    			aListNeto.add(compraNeto);
    			compra.put("Precio total (bruto)", compraBruto);
    	    	compra.put("Precio total (neto)", compraNeto);
    			totalDeArticulos++;
    			
    		System.out.println("Siguiente artículo (Y/N)");
    	
    	}while(sc.nextLine().toUpperCase().equals("Y"));
    	
    	double compraBruto = 0, compraNeto = 0;
    	Iterator<Double> itB = aListBruto.iterator();
		while (itB.hasNext()) {			
			compraBruto += itB.next();
			}
		Iterator<Double> itN = aListNeto.iterator();
		while (itN.hasNext()) {			
			compraNeto += itN.next();
			}
		
    	compra.put("Articulos comprados", totalDeArticulos);
    	
    	
    	System.out.println("¿Efectivo o tarjeta?");
    		String tipoPago = sc.nextLine().toUpperCase();
    		double devolucionCambio;
    		switch (tipoPago) {
    		 case "EFECTIVO":
    			 System.out.println("Introduce la cantidad:");
    			 double pagoE = sc.nextDouble();
    			 compra.put("Efectivo entregado", pagoE);
    			 devolucionCambio = pagoE - compraNeto;
    			 System.out.println("Ha pagado con " +pagoE+ "€"+ 
    					 	"\nSu cambio es " +devolucionCambio+ "€");
    			 compra.put("El cambio a entregar es:", devolucionCambio);
    			 break;
    		case "TARJETA":
    			System.out.println("¡Gracias por su compra!");
   			 	double pagoT = compraNeto;
   			 	compra.put("Pago con tarjeta", pagoT);
   			 	devolucionCambio = pagoT - compraNeto;
   			 	System.out.println("Pago con tarjeta realizado (no hay cambio)");
   			 	compra.put("No hay cambio (pago con tarjeta)", devolucionCambio);
   			 	break;
   			 default:
   				 System.out.println("No has seleccionado un método de pago correcto");
   				 break;
    		}
    		
    
    	System.out.println("\n --RESUMEN DE LA COMPRA--"
    			+ "\nEl coste de la compra ha sido:");
    	for (int n = 0; n < totalDeArticulos; n++) {
    		System.out.println("Producto nº"+(n+1)+": " +aListProducto.get(n)+
    			"\nPrecio bruto: " +aListBruto.get(n)+
    			" / Precio neto ("+aListIVA.get(n)+"% IVA): " +aListNeto.get(n));
    		}
    
    	sc.close();
    }
    
    public static double precioTotalIVA(double precioArticuloActual, double IVA) {
    	double precioTIVA = 0;
       	precioTIVA += precioArticuloActual + precioArticuloActual*IVA/100;
       	System.out.println("Metodo IVA, sumatorio:" +precioTIVA);
    	return precioTIVA;
    }
    
    public static double precioTotalBruto(double precioArticuloActual) {
    	double precioTbruto = 0;
       	precioTbruto += precioArticuloActual;
    	return precioTbruto;
    }
    

            
}