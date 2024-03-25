package TA9;

public class ElectrodomesticoTA9 {

	// Atributos (o campos/propiedades)
	protected double precioBase;
	protected colorE color;
	protected consumoE consumo;
	protected int peso;
	
//	CONSTANTES
	private final static double precioBase_DEFAULT = 100;
	private final static colorE color_DEFAULT = colorE.BLANCO; //BLANCO / NEGRO / ROJO / AZUL / GRIS
		enum colorE {
			BLANCO, NEGRO, ROJO, AZUL, GRIS
		}
	private final static consumoE consumo_DEFAULT = consumoE.F; // A - F
		enum consumoE {
			A, B, C, D, E, F
		}
	private final static int peso_DEFAULT = 5;

    
//	Constructor por defecto
	public ElectrodomesticoTA9() {
		this.precioBase = precioBase_DEFAULT;
		this.color = color_DEFAULT;
		this.consumo = consumo_DEFAULT;
		this.peso = peso_DEFAULT;
	}
	
//	Constructor precio+peso, resto defecto
	public ElectrodomesticoTA9(double precio, int peso) {
		this();
		this.precioBase = precio;
		this.peso = peso;
	}

//	Constructor TODO
	public ElectrodomesticoTA9(double precio, colorE color, consumoE consumo, int peso) {
		this.precioBase = precio;
		this.color = color;
		this.consumo = consumo;
		this.peso = peso;
	}

	
//	Métodos (o funciones)
	public colorE getColor() {
		return color;
	}

	public void setColor(colorE color) {
		this.color = color;
	}
	
	public double getprecioBase() {
		return precioBase;
	}

	public void setprecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public consumoE getConsumo() {
		return consumo;
	}

	public void setConsumo(consumoE consumo) {
		this.consumo = consumo;
	}
	
	public String ElectrodomesticoTA9_toString() {
        return "Electrodomestico{" +
                "precio = " + precioBase +
                ", color = " + color +
                ", consumo = '" + consumo + '\'' +
                ", peso = " + peso +
                '}';
    }
	
	public double precioFinal(consumoE consumo, int peso) {
		
		double precioConsumoTabla = 0;
		switch (consumo){
			case A:
				precioConsumoTabla = 100;
					break;
			case B:
				precioConsumoTabla = 80;
					break;
			case C:
				precioConsumoTabla = 60;
					break;
			case D:
				precioConsumoTabla = 50;
					break;
			case E:
				precioConsumoTabla = 30;
					break;
			case F:
				precioConsumoTabla = 10;
					break;
			default:
				System.out.println("Consumo incorrecto (A to F).");
		}
		
		 double precioPesoTabla = 0;
		    if (peso >= 0 && peso <= 19) {
		        precioPesoTabla = 10;
		    } else if (peso >= 20 && peso <= 49) {
		        precioPesoTabla = 50;
		    } else if (peso >= 50 && peso <= 79) {
		        precioPesoTabla = 80;
		    } else if (peso >= 80) {
		        precioPesoTabla = 100;
		    } else {
		        System.out.println("Peso incorrecto. Introduce el valor entero más próximo.");
		    }
		
		return precioConsumoTabla + precioPesoTabla;
	}
}
