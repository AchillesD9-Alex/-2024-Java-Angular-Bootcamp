package TA8;

public class MainApp {

	public static void main(String[] args) {
//		--- PERSONA ---
//		Constructor 1: nombre, edad ciudad
		TA9Ej5_Persona persona1 = new TA9Ej5_Persona("Ana", 25, "Barcelona");

		System.out.println(persona1.getNombre()); // Imprime "Ana"
		System.out.println(persona1.getEdad()); // Imprime 25

		persona1.setCiudad("Valencia"); //Mod. Barcelona --> Valencia
		System.out.println(persona1.toString()); // Imprime "Persona{nombre='Ana', edad=25, ciudad='Valencia'}"

//		Constructor 2: nombre, edad y sexo
		TA9Ej5_Persona persona2 = new TA9Ej5_Persona("Paco", 30, "H");

		System.out.println(persona1.getSexo()); // Imprime H
		
//	Constructor 3: todos los atributos por parámetos
		TA9Ej5_Persona persona3 = new TA9Ej5_Persona("Pedro", 27, "45396532A", 'H', 89.7, 1.78, "Tortosa");
		System.out.println(persona3.imprimirPersona()+"\n");
		
//		--- PASSWORD ---
//		Constructor 1: por defecto
		Password pass1 = new Password();
		System.out.println(pass1.imprimirPass());
		
//		Constructir 2: dar longitud y generar random pass
		Password pass2 = new Password(3);
		System.out.println(pass2.imprimirPass());
		
//		Constructor 3: todos los atributos como parámetro
		Password pass3 = new Password("Hola", 4);
		System.out.println(pass3.imprimirPass()+"\n");
		
//		--- ELECTRODOMESTICO ---
//		Constructor 1: por defecto
		Electrodomestico elec1 = new Electrodomestico();
		System.out.println(elec1.imprimirElectrodomestico());
		
//		Constructor 2: precio+peso, resto defecto
		Electrodomestico elec2 = new Electrodomestico(500,23.4);
		System.out.println(elec2.imprimirElectrodomestico());
		
//		Constructor 3: todos los atributos como parámetro
		Electrodomestico elec3 = new Electrodomestico(1200, "negro", "A", 35.2);
		System.out.println(elec3.imprimirElectrodomestico()+"\n");
		
//		--- SERIE ---
//		Constructor 1: por defecto
		Serie serie1 = new Serie();
		System.out.println(serie1.imprimirSerie());
		
//		Constructor 2: titulo + creador
		Serie serie2 = new Serie("Jessica Jones", " Brian Michael Bendis");
		System.out.println(serie2.imprimirSerie());
		
//		Constructor 3: todos los atributos como parámetro EXCEPTO entregado
		Serie serie3 = new Serie("Doctor Who", 26, "SciFi", "Sydney Newman");
		System.out.println(serie3.imprimirSerie());

	}
	
}
