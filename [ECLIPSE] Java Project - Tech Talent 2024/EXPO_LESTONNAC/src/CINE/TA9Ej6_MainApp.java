package CINE;

import java.util.Scanner;

public class TA9Ej6_MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TA9Ej6_Peliculas p = new TA9Ej6_Peliculas("Avatar", 162, 7, "James Cameron");
		TA9Ej6_Cine c = new TA9Ej6_Cine(p, 20, 8, 8);

		int capacidad = c.getColumnas() * c.getFilas();
		TA9Ej6_Butaca[][] asientos = new TA9Ej6_Butaca[c.getFilas()][c.getColumnas()];

		rellenarTA9Ej6_Butacas(asientos);
		dibujarTA9Ej6_Cine(asientos);

		System.out.println("Introduce el número de espectadores que van al cine:");
		int n = sc.nextInt();
		TA9Ej6_Espectador[] espectadores = new TA9Ej6_Espectador[n];
		
		generarTA9Ej6_Espectadores(n, espectadores);
		sentarTA9Ej6_Espectadores(espectadores, capacidad, c, asientos, p);
		System.out.println();
		dibujarTA9Ej6_Cine(asientos);
		
		sc.close();
	}

	public static void sentarTA9Ej6_Espectadores(TA9Ej6_Espectador[] espectadores,
			int capacidad, TA9Ej6_Cine c, TA9Ej6_Butaca[][] asientos,TA9Ej6_Peliculas p) {
		int count = 0;
		//Mientras queden espectadores por asignarle un asiento
		while (count < espectadores.length && hayEspacio(asientos)) {
			int fila = generarTA9Ej6_Butaca(c.getFilas());
			int columna = generarTA9Ej6_Butaca(c.getColumnas());
			while (asientos[fila][columna].ifOcupada()) {
				fila = generarTA9Ej6_Butaca(c.getFilas());
				columna = generarTA9Ej6_Butaca(c.getColumnas());
			}
			if (puedeSentarse(espectadores[count], c, p, asientos)) {
				asientos[fila][columna].ocuparTA9Ej6_Butaca();	
			}
			count++;
		}
	}

	public static int generarTA9Ej6_Butaca(int n) {
		return (int) (Math.random() * n);
	}

	public static void generarTA9Ej6_Espectadores(int n, TA9Ej6_Espectador[] espectadores) {
		for (int i = 0; i < n; i++) {
			espectadores[i] = new TA9Ej6_Espectador();
		}
	}

	public static void dibujarTA9Ej6_Cine(TA9Ej6_Butaca[][] asientos) {
		for (int i = asientos.length - 1; i >= 0; i--) {
			for (int j = 0; j < asientos[i].length; j++) {
				TA9Ej6_Butaca asientoActual = asientos[i][j];
				System.out.print(Integer.toString(asientoActual.getfila()) + asientoActual.getcolumna() + "(");
				if (asientoActual.ifOcupada()) {
					System.out.print("X) ");
				} else {
					System.out.print(" ) ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rellenarTA9Ej6_Butacas(TA9Ej6_Butaca[][] asientos) {
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = new TA9Ej6_Butaca();
				asientos[i][j].setfila(i + 1);;
				asientos[i][j].setcolumna((char) (65 + j));
			}
		}
	}

	public static boolean puedeSentarse(TA9Ej6_Espectador e, TA9Ej6_Cine c,
											TA9Ej6_Peliculas p, TA9Ej6_Butaca[][] a) {
/* Queria contabilizar las personas que no podian asistir según su casuística,
 * pero como el metodo es individual no puedo realizarlo... debería separar los metodos
 * para poder utilizar los conatadores.
 */
		
//		int sinDinero = 0;
//		int sinEdad = 0;
//		int sinAmbas = 0;
		if(tieneDinero(e, c) == false) {
			System.out.println(e.getNombre() + " no tiene suficiente dinero.");
//			sinDinero++;
		}else if(tieneEdad(p, e) == false){
			System.out.println(e.getNombre() + " no tiene suficiente edad.");
//			sinEdad++;
		}else if (tieneDinero(e, c) == false && tieneEdad(p, e) == false) {
			System.out.println(e.getNombre() + " no tiene suficiente dinero ni edad.");
//			sinAmbas++;
		}
//		System.out.println("\nHay un total de "+(sinDinero+sinEdad+sinAmbas)+" personas"
//								+ " que no van a poder asistir a la pelicula.");
//		System.out.println("De estas, " +sinDinero+" es por falta de dinero."+
//								"\n"+sinEdad+ " no tienen edad suficiente."+
//								"\n"+sinAmbas+ " no tienen dinero ni edad suficiente.");
		return ((tieneDinero(e, c)) && (tieneEdad(p, e)));
	}

	public static boolean tieneDinero(TA9Ej6_Espectador e, TA9Ej6_Cine c) {
		return (e.getDinero() >= c.getPrecio());
	}

	public static boolean hayEspacio(TA9Ej6_Butaca[][] asientos) {
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (!asientos[i][j].ifOcupada()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean tieneEdad(TA9Ej6_Peliculas p, TA9Ej6_Espectador e) {
		return (e.getEdad() >= p.getEdadMinima());
	}

}