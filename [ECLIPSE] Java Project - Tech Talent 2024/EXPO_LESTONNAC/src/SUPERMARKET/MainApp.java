package SUPERMARKET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Producto> baseDeDatos = new ArrayList<Producto>();
		ArrayList<Producto> carrito = new ArrayList<Producto>();

		rellenarbaseDeDatos(baseDeDatos);
		mostrarMenu(baseDeDatos, carrito);
	}

	// Menús de Gestión
	public static void mostrarMenu(ArrayList<Producto> baseDeDatos, ArrayList<Producto> carrito) {
		Scanner sc = new Scanner(System.in);
		int select = 0, choose = 0;
		while (select != 3) {
			menu();
			select = sc.nextInt();
			switch (select) {
			case 1:
				gestionarStock(baseDeDatos);
				break;
			case 2:
				// gestiona compra
				gestionarCarrito(baseDeDatos, carrito);
				break;
			case 3:
				// salir programa
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}

	public static void gestionarStock(ArrayList<Producto> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		while (choose != 4) {
			menuStock();
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				mostrarStock(baseDeDatos);
				break;
			case 2:
				addStock(baseDeDatos);
				break;
			case 3:
				comprobarProducto(baseDeDatos);
				break;
			case 4:
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}

	public static void gestionarCarrito(ArrayList<Producto> baseDeDatos, ArrayList<Producto> carrito) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		while (choose != 3) {
			menuCarrito();
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				// Añadir producto
				addProducto(baseDeDatos, carrito);
				break;
			case 2:
				// Comprobar carrito
				mostrarCarrito(carrito);
				break;
			case 3:
				// Hacer compra
				confirmarCompra(carrito, baseDeDatos);
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}

	// Métodos de gestión de stock
	public static void addStock(ArrayList<Producto> baseDeDatos) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre del producto:");
		String nombre = sc.nextLine().toUpperCase();
		boolean found = false;
		for (int i = 0; i < baseDeDatos.size() && !found; i++) {
			if (baseDeDatos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("El producto que quieres añadir ya está en la base de datos");
				found = true;
			}
		}

		if (!found) {
			System.out.println("Precio del producto:");
			double precio = sc.nextDouble();
			System.out.println("Cantidad del producto:");
			int cantidad = sc.nextInt();
			System.out.println("IVA del producto:");
			double iva = sc.nextDouble();
			baseDeDatos.add(new Producto(precio, iva, cantidad, nombre));
		}

	}

	public static void comprobarProducto(ArrayList<Producto> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué producto quieres comprobar?");
		String producto = sc.nextLine();
		boolean salir = false;
		for (int i = 0; i < baseDeDatos.size() && !salir; i++) {
			if ((baseDeDatos.get(i).getNombre()).equalsIgnoreCase(producto)) {
				System.out.println(baseDeDatos.get(i).toString());
				salir = true;
			}
		}

	}

	public static void mostrarStock(ArrayList<Producto> baseDeDatos) {
		for (Producto item : baseDeDatos) {
			System.out.println(item.toString());
		}
	}

	// Métodos de gestión de Compra
	public static void addProducto(ArrayList<Producto> baseDeDatos, ArrayList<Producto> carrito) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Selecciona uno de los sigüientes productos:\n");
		mostrarStock(baseDeDatos);
		String producto = sc.nextLine();
		System.out.println("¿Cuántas unidades quieres añadir al carrito?");
		int cantidad = sc.nextInt();
		boolean salir = false;
		int cantidadMax = 0;
		double precio = 0;
		double iva = 0.21;
		for (int i = 0; i < baseDeDatos.size() && !salir; i++) {
			if ((baseDeDatos.get(i).getNombre()).equalsIgnoreCase(producto)) {
				precio = baseDeDatos.get(i).getPrecio();
				iva = baseDeDatos.get(i).getIva();
				cantidadMax = baseDeDatos.get(i).getCantidad();
				salir = true;
			}
		}
		if (cantidad > cantidadMax) {
			cantidad = cantidadMax;
			System.out.println("No tenemos stock suficiente, solo puedes llevarte " + cantidad);
		}

		carrito.add(new Producto(precio, iva, cantidad, producto));

	}

	public static void mostrarCarrito(ArrayList<Producto> carrito) {
		for (Producto item : carrito) {
			System.out.println(item.toString());
		}
	}

	public static void confirmarCompra(ArrayList<Producto> carrito, ArrayList<Producto> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Confirmas esta compra? (S/N)");
		mostrarCarrito(carrito);

		String respuesta = "";
		while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("S")) {
				hacerCompra(carrito, baseDeDatos);
			} else {
				System.out.println("Compra cancelada");
				carrito.clear();
			}
		}
	}

	// Métodos de calcular la compra
	public static void hacerCompra(ArrayList<Producto> carrito, ArrayList<Producto> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		double precio = totalConIVA(carrito), efectivo = 0, cambio = 0;
		// calcular precio con iva y mostrarlo
		System.out.println("Precio total a pagar: " + precio);
		// Pagar y mostrar cambio
		System.out.println("Paga");
		efectivo = sc.nextDouble();
		while (efectivo < precio) {
			System.out.println("Cantidad insuficiente. Paga");
			efectivo = sc.nextDouble();
		}
		cambio = pagar(precio, efectivo);
		cambio = Math.round(cambio * 100.0) / 100.0;
		if (cambio != 0) {
			System.out.println("Recibes " + cambio + "€ de cambio");
		}
		actualizarStock(carrito, baseDeDatos);
		carrito.clear();
	}

	private static double totalConIVA(ArrayList<Producto> carrito) {
		double iva = 0.21;
		double sumaTotalConIVA = 0, precio = 0;
		int cantidad = 0;

		for (int i = 0; i < carrito.size(); i++) {
			precio = carrito.get(i).getPrecio();
			iva = carrito.get(i).getIva();
			cantidad = carrito.get(i).getCantidad();
			sumaTotalConIVA += (precio + (precio * iva)) * cantidad;
		}

		return sumaTotalConIVA;
	}

	public static void actualizarStock(ArrayList<Producto> carrito, ArrayList<Producto> baseDeDatos) {
		int cantidadCarrito = 0;
		int cantidadStock = 0;
		int cantidadActualizada = 0;
		String nombre = "";
		for (Producto item : carrito) {
			nombre = item.getNombre();
			cantidadCarrito = item.getCantidad();
			boolean salir = false;
			for (int i = 0; i < baseDeDatos.size() && !salir; i++) {
				if ((baseDeDatos.get(i).getNombre()).equalsIgnoreCase(nombre)) {
					cantidadStock = baseDeDatos.get(i).getCantidad();
					salir = true;

					cantidadActualizada = cantidadStock - cantidadCarrito;
					baseDeDatos.get(i).setCantidad(cantidadActualizada);
				}
			}
		}
	}

	public static double pagar(double precio, double efectivo) {
		return efectivo - precio;
	}

	// Menús
	public static void menu() {
		System.out.println("\n---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("1. Gestionar Stock");
		System.out.println("2. Hacer Compra");
		System.out.println("3. Salir");
		System.out.println("---------------------------------------");
	}

	public static void menuStock() {
		System.out.println("\n---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("	1. Listar Stock");
		System.out.println("	2. Añadir Producto");
		System.out.println("	3. Consultar Producto");
		System.out.println("	4. Salir");
		System.out.println("---------------------------------------");
	}

	public static void menuCarrito() {
		System.out.println("\n---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("	1. Añadir producto");
		System.out.println("	2. Comprobar carrito");
		System.out.println("	3. Comprar");
		System.out.println("---------------------------------------");
	}

	// Base de datos inicial
	public static void rellenarbaseDeDatos(ArrayList<Producto> baseDeDatos) {

		baseDeDatos.add(new Producto(0.50, 0.10, 10, "PAN"));
		baseDeDatos.add(new Producto(1.50, 0.21, 10, "MANZANA"));
		baseDeDatos.add(new Producto(2.50, 0.21, 10, "PERA"));
		baseDeDatos.add(new Producto(3.25, 0.21, 10, "PASTA"));
		baseDeDatos.add(new Producto(4.50, 0.21, 10, "PIZZA"));
		baseDeDatos.add(new Producto(3.20, 0.21, 10, "CANELONES"));
		baseDeDatos.add(new Producto(0.50, 0.04, 10, "AGUA"));
		baseDeDatos.add(new Producto(1.00, 0.04, 10, "LECHE"));
		baseDeDatos.add(new Producto(0.90, 0.21, 10, "PILA"));
		baseDeDatos.add(new Producto(1.40, 0.21, 10, "QUESO"));
	}

}
