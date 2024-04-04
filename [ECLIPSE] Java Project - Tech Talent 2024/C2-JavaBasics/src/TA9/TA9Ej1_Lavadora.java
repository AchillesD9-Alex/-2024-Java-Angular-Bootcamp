package TA9;

public class TA9Ej1_Lavadora extends TA9Ej1_Electrodomestico{

//	Atributos (o campos/propiedades): heredados de superclase
	private int carga;
	
//	CONSTANTES
	private final static int carga_DEFAULT = 5;
    
//	Constructor por defecto
	public TA9Ej1_Lavadora() {
		super();
		this.carga = carga_DEFAULT;
	}
	
//	Constructor precio+peso, resto defecto
	public TA9Ej1_Lavadora(double precio, int peso) {
		super(precio, peso);
		this.precioBase = precio;
		this.peso = peso;
	}

//	Constructor TODO
	public TA9Ej1_Lavadora(double precioBase, colorE color, consumoE consumo,
							int peso, int carga) {
		super(precioBase, color, consumo, peso);
		this.carga = carga;
	}

	
//	Métodos (o funciones)
		
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	public String TA9Ej1_Lavadora_toString() {
        return "Lavadora{" +
                "precio = " + precioBase +
                ", color = " + color +
                ", consumo = '" + consumo + '\'' +
                ", peso = " + peso +
                '}';
    }
	
	public double precioFinal() {
		 
		double extraCarga = 0;
		    if(carga>30) {
		    	extraCarga = 50;
		    }
		    
		return super.precioFinal() + extraCarga;
	}
}
