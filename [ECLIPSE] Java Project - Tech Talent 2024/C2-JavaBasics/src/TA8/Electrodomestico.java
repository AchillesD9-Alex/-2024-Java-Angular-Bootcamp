package TA8;

import javax.swing.JOptionPane;

public class Electrodomestico {

	// Atributos (o campos/propiedades)
	private double precioBase;
	private String color; //BLANCO / NEGRO / ROJO / AZUL / GRIS
	private String consumo; // A - F
	private double peso;
	
    
//	Constructor por defecto
	public Electrodomestico() {
		this.precioBase = 100;
		this.color = "BLANCO";
		this.consumo = "F";
		this.peso = 5;
	}
	
//	Constructor precio+peso, resto defecto
	public Electrodomestico(double precio, double peso) {
		this.precioBase = precio;
		this.color = "BLANCO";
		this.consumo = "F";
		this.peso = peso;
	}

//	Constructor TODO
	public Electrodomestico(double precio, String color, String consumo, double peso) {
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
	
	public String imprimirElectrodomestico() {
        return "Electrodomestico{" +
                "precio='" + precioBase + '\'' +
                ", color=" + color +
                ", consumo='" + consumo + '\'' +
                ", peso=" + peso +
                '}';
    }
}
