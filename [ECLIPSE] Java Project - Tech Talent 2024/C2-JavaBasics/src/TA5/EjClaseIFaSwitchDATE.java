package TA5;

import java.text.SimpleDateFormat;
import java.util.Date;


public class EjClaseIFaSwitchDATE {

	public static void main(String[] args) {
			
	Date fecha = new Date();
	SimpleDateFormat formatoHora = new SimpleDateFormat("h");//Elegimos qué escoger de la fecha entera 
	int horaNum = Integer.parseInt(formatoHora.format(fecha)); 
	
	String message; /*Creamos variable para usarla en los case y
					así usar un solo system.out después del switch*/ 
	
	switch (horaNum) {
		case 9:
			message = "Son las 9.";
			break;
		case 10:
			message = "Son las 10.";
			break;
		default:
			message = "Son las " +horaNum+ ".";
		}
	System.out.println(message);
	}			
}
		
	


