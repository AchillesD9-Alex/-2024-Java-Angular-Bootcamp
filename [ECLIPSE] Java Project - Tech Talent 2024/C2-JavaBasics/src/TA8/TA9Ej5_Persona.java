package TA8;

import javax.swing.JOptionPane;

public class TA9Ej5_Persona {

	// Atributos (o campos/propiedades)
	private String nombre;
	private int edad;
	private String DNI;
	private char sexo;
	private double peso;
	private double altura;
	private String ciudad;

	// Constantes para el sexo
    private static final char SEXO_HOMBRE = 'H';
    private static final char SEXO_MUJER = 'M';
    
//	Constructor por defecto
	public TA9Ej5_Persona() {
		this.nombre = "";
		this.edad = 0;
		this.DNI ="";
		this.sexo = SEXO_HOMBRE;
		this.peso = 0;
		this.altura = 0;
		this.ciudad = "";
	}
	 
//	Para ejercicio de clase en MainApp
	public TA9Ej5_Persona(String nombre, int edad, String ciudad) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI ="";
		this.sexo = SEXO_HOMBRE;
		this.peso = 0;
		this.altura = 0;
		this.ciudad = ciudad;		
	}
	
//	Constructor nombre, edad y sexo; resto por defecto
	public TA9Ej5_Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI ="";
		this.sexo = sexo;
		this.peso = 0;
		this.altura = 0;
		this.ciudad = "";
	}

//	Constructor todos los atributos como parámetro
	public TA9Ej5_Persona(String nombre, int edad, String DNI, char sexo, double peso,
					double altura, String ciudad) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.ciudad = ciudad;
	}
	
	
	// Métodos (o funciones)
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo() {
    	String sexoINTRO = (JOptionPane.showInputDialog("¿Hombre o mujer? (H/M)").toUpperCase());
    	
    	switch (sexoINTRO) {
    		case ("H"):
    			this.sexo = SEXO_HOMBRE;
    			break;
    		
    		case ("M"):
    			this.sexo = SEXO_MUJER;
    			break;
    		
    		default:
    			JOptionPane.showInputDialog("No has introducido correctamente si es Hombre o Mujer");
    	}
		
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String imprimirPersona() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
	 // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
	
}
