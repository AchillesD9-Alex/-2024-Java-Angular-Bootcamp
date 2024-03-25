package TA9;

import TA9.ElectrodomesticoTA9.colorE;
import TA9.ElectrodomesticoTA9.consumoE;

public class MainAppTA9 {

	public static void main(String[] args) {
		/*
//		--- PERSONA ---
//		Constructor 1: nombre, edad ciudad
		Persona persona1 = new Persona("Ana", 25, "Barcelona");

		System.out.println(persona1.getNombre()); // Imprime "Ana"
		System.out.println(persona1.getEdad()); // Imprime 25

		persona1.setCiudad("Valencia"); //Mod. Barcelona --> Valencia
		System.out.println(persona1.toString()); // Imprime "Persona{nombre='Ana', edad=25, ciudad='Valencia'}"

//		Constructor 2: nombre, edad y sexo
		Persona persona2 = new Persona("Paco", 30, "H");

		System.out.println(persona1.getSexo()); // Imprime H
		
//	Constructor 3: todos los atributos por parámetos
		Persona persona3 = new Persona("Pedro", 27, "45396532A", 'H', 89.7, 1.78, "Tortosa");
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
		*/
		
//		--- ELECTRODOMESTICO ---
//		Constructor 1: por defecto
		ElectrodomesticoTA9 elec1 = new ElectrodomesticoTA9();
		System.out.println(elec1.ElectrodomesticoTA9_toString());
		
//		Constructor 2: precio+peso, resto defecto
		ElectrodomesticoTA9 elec2 = new ElectrodomesticoTA9(500,23.4);
		System.out.println(elec2.ElectrodomesticoTA9_toString());
		
//		Constructor 3: todos los atributos como parámetro
		ElectrodomesticoTA9 elec3 = new ElectrodomesticoTA9(1200, TA9.ElectrodomesticoTA9.colorE.NEGRO,
									TA9.ElectrodomesticoTA9.consumoE.A, 35.2);
		System.out.println(elec3.ElectrodomesticoTA9_toString()+"\n");
		
		/*
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
		*/
	}
	
}
