package TA9;

public class TA9Ej1_Television extends TA9Ej1_Electrodomestico{

//	Atributos (o campos/propiedades): heredados de superclase
	private int resolucion;
	private boolean sinTDT;
	
//	CONSTANTES
	private final static int resolucion_DEFAULT = 20;
	private final static boolean sinTDT_DEFAULT = false;
    
//	Constructor por defecto
	public TA9Ej1_Television() {
		super();
		this.resolucion = resolucion_DEFAULT;
	}
	
//	Constructor precio+peso, resto defecto
	public TA9Ej1_Television(double precio, int peso) {
		super(precio, peso);
		this.precioBase = precio;
		this.peso = peso;
	}

//	Constructor TODO
	public TA9Ej1_Television(double precioBase, colorE color, consumoE consumo, int peso, int resolucion) {
		super(precioBase, color, consumo, peso);
		this.resolucion = resolucion;
	}

	
//	Métodos (o funciones)
		
	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	
	public String TA9Ej1_Television_toString() {
        return "TV {" +
                "precio = " + precioBase +
                ", color = " + color +
                ", consumo = '" + consumo + + '\'' +
                 ", peso = " + peso +
                '}';
    }
	
	public double precioFinal() {
		double extraResolucion = 1;
		int extraTDT = 0;
		
		if (resolucion > 40) {
			extraResolucion = 1.3;
		}
			
		if (sinTDT) {
			extraTDT = 50;
		}
		return super.precioFinal() * extraResolucion + extraTDT;
	}
}
