package CINE;

public class TA9Ej6_Espectador {

	private String nombre;
	private int edad;
	private double dinero;

	public TA9Ej6_Espectador() {
		generarTA9Ej6_EspectadorRandom();
	}

	public TA9Ej6_Espectador(String nombre, int edad, double dinero) {
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}
	
	public void generarTA9Ej6_EspectadorRandom() {
		
		TA9Ej6_genteRandom[] nombres = TA9Ej6_genteRandom.values();
		int random = (int) (Math.random() * nombres.length);
		this.nombre = nombres[random].toString();
		
		random = (int) (Math.random() * 100);
		this.edad = random;
		
		double money = Math.random() * 100;
		this.dinero = money;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "TA9Ej6_Espectador [nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + "]";
	}

}