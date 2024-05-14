package SUPERMARKET;

import java.text.DecimalFormat;

public class Producto {

	private double precio;
	private double iva;
	private int cantidad;
	private String nombre;

	public Producto(double precio, double iva, int cantidad, String nombre) {
		this.precio = precio;
		this.iva = iva;
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	public Producto() {
		this.precio = 1;
		this.iva = 0.21;
		this.cantidad = 10;
		this.nombre = "";
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return nombre + ": [precio: " + df.format(precio) + "€ | IVA: " + Math.round(iva * 100) + "% | cantidad: "
				+ cantidad + "]";
	}

}
