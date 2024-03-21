package TA9;

import javax.swing.JOptionPane;

public class Elctrodomestico {

	// Atributos (o campos/propiedades)
	protected double precioBase;
	protected String color; //BLANCO / NEGRO / ROJO / AZUL / GRIS
	protected String consumo; // A - F
	protected double peso;
	
    
//	Constructor por defecto
	public Elctrodomestico() {
		this.precioBase = 100;
		this.color = "BLANCO";
		this.consumo = "F";
		this.peso = 5;
	}
	
//	Constructor precio+peso, resto defecto
	public Elctrodomestico(double precio, double peso) {
		this.precioBase = precio;
		this.peso = peso;
	}

//	Constructor TODO
	public Elctrodomestico(double precio, String color, String consumo, double peso) {
		this.precioBase = precio;
		this.color = color;
		this.consumo = consumo;
		this.peso = peso;
	}

	
//	Métodos (o funciones)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	public double getprecioBase() {
		return precioBase;
	}

	public void setprecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
	
	
}
