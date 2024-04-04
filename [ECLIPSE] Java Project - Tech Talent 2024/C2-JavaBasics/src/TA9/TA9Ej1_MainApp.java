package TA9;

public class TA9Ej1_MainApp {

	public static void main(String[] args) {
	
		TA9Ej1_Electrodomestico arrayE[]= new TA9Ej1_Electrodomestico [10]; 
		
//		--- ELECTRODOMESTICOS ---
		TA9Ej1_Electrodomestico elec1 = new TA9Ej1_Electrodomestico (800,
				TA9Ej1_Electrodomestico.colorE.NEGRO, TA9Ej1_Electrodomestico.consumoE.A, 50);
			System.out.println(elec1.ElectrodomesticoTA9_toString()+"\n");
			arrayE[0] = elec1;
		
		TA9Ej1_Electrodomestico elec2 = new TA9Ej1_Electrodomestico (700, TA9Ej1_Electrodomestico.colorE.AZUL,
				TA9Ej1_Electrodomestico.consumoE.A, 50);
			System.out.println(elec2.ElectrodomesticoTA9_toString()+"\n");
			arrayE[1] = elec2;
			
		TA9Ej1_Electrodomestico elec3 = new TA9Ej1_Electrodomestico (600, TA9Ej1_Electrodomestico.colorE.GRIS,
				TA9Ej1_Electrodomestico.consumoE.A, 50);
			System.out.println(elec3.ElectrodomesticoTA9_toString()+"\n");
			arrayE[2] = elec3;
		
		TA9Ej1_Electrodomestico elec4 = new TA9Ej1_Electrodomestico (500, TA9Ej1_Electrodomestico.colorE.ROJO,
				TA9Ej1_Electrodomestico.consumoE.A, 50);
			System.out.println(elec4.ElectrodomesticoTA9_toString()+"\n");
			arrayE[3] = elec4;
		
//		--- LAVADORAS ---
		TA9Ej1_Lavadora lavadora1 = new TA9Ej1_Lavadora (800, TA9Ej1_Lavadora.colorE.AZUL,
				TA9Ej1_Lavadora.consumoE.C, 30, 15);
			System.out.println(lavadora1.TA9Ej1_Lavadora_toString()+"\n");
			arrayE[4] = lavadora1;
		
		TA9Ej1_Lavadora lavadora2 = new TA9Ej1_Lavadora (900, TA9Ej1_Lavadora.colorE.ROJO,
				TA9Ej1_Lavadora.consumoE.B, 40, 20);
			System.out.println(lavadora2.TA9Ej1_Lavadora_toString()+"\n");
			arrayE[5] = lavadora2;
			
		TA9Ej1_Lavadora lavadora3 = new TA9Ej1_Lavadora (1000, TA9Ej1_Lavadora.colorE.GRIS,
				TA9Ej1_Lavadora.consumoE.A, 100, 60);
			System.out.println(lavadora3.TA9Ej1_Lavadora_toString()+"\n");
			arrayE[6] = lavadora3;
		
//		--- TELEVISION ---
		TA9Ej1_Television tv1 = new TA9Ej1_Television (800, TA9Ej1_Television.colorE.NEGRO,
				TA9Ej1_Television.consumoE.C, 30, 15);
			System.out.println(tv1.TA9Ej1_Television_toString()+"\n");
			arrayE[7] = tv1;
		
		TA9Ej1_Television tv2 = new TA9Ej1_Television (900, TA9Ej1_Television.colorE.NEGRO,
				TA9Ej1_Television.consumoE.B, 40, 20);
			System.out.println(tv2.TA9Ej1_Television_toString()+"\n");
			arrayE[8] = tv2;
		
		TA9Ej1_Television tv3 = new TA9Ej1_Television (1000, TA9Ej1_Television.colorE.NEGRO,
				TA9Ej1_Television.consumoE.A, 100, 60);
			System.out.println(tv3.TA9Ej1_Television_toString()+"\n");
			arrayE[9] = tv3;

			double totalTV = 0;
			double totalLavadoras = 0;
			double totalElec = 0;

			for (TA9Ej1_Electrodomestico elec : arrayE) {
				if (elec instanceof TA9Ej1_Television) {
					totalTV += ((TA9Ej1_Television) elec).precioFinal();
				} else if (elec instanceof TA9Ej1_Lavadora) {
					totalLavadoras += ((TA9Ej1_Lavadora) elec).precioFinal();
				} else {
					totalElec += elec.precioFinal();
				}
			}

			double total = totalElec + totalTV + totalLavadoras;

			System.out.println("La suma de todas las televisiones es: " + totalTV);
			System.out.println("La suma de todas las lavadoras es: " + totalLavadoras);
			System.out.println("La suma de todos los electrodomesticos es: " + total);
		
	}
	
}
