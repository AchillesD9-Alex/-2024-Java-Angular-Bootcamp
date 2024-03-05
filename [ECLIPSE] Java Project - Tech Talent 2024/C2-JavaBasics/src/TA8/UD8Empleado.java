package TA8;

import java.util.HashMap;

import java.util.Scanner;

public class UD8Empleado {
//	Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private int salario;
    
public boolean plus (double sueldoPlus) {
	boolean aumento=false;
	if(edad>10) {
		salario += sueldoPlus;
		aumento=true;
	}return aumento;
	
 }
}