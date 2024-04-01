package TA9;

public class TA9Ej2_MainApp {

	public static void main(String[] args) {
		
		TA9Ej2_Serie[] series = new TA9Ej2_Serie[5];
		TA9Ej2_Videojuego[] videojuegos = new TA9Ej2_Videojuego[5];
		
//		Agregamos las series y los videojuegos: 
		series[0] = new TA9Ej2_Serie("Doctor Who", 26, "Ciencia ficción", "Sydney Newman, C. E. Webber, Donald Wilson");
		series[1] = new TA9Ej2_Serie("Jessica Jones", 2, "Drama", "Melissa Rosenberg");
		series[2] = new TA9Ej2_Serie("Juego de Tronos", 8, "Fantasía", "David Benioff, D. B. Weiss");
		series[3] = new TA9Ej2_Serie("Misfits", 5, "Drama", "Howard Overman");
		series[4] = new TA9Ej2_Serie("Heroes", 3, "Ciencia ficción", "Tim Kring");

		videojuegos[0] = new TA9Ej2_Videojuego("Genshin Impact", 80, "RPG /Mundo abierto", "Hoyoverse");
		videojuegos[1] = new TA9Ej2_Videojuego("Honkai Star Rail", 50, "RPG /Combate por turnos", "Hoyoverse");
		videojuegos[2] = new TA9Ej2_Videojuego("Honkai Impact 3rd", 100, "RPG de acción", "Hoyoverse");
		videojuegos[3] = new TA9Ej2_Videojuego("Final Fantasy XIII", 50, "RPG /Combate por turnos", "Square Enix");
		videojuegos[4] = new TA9Ej2_Videojuego("Bravely Default", 45, "RPG /Combate por turnos", "Square Enix");

//		"Entregamos" las series y videojuegos que queramos para compararlas:
		series[0].entregar(); // Seran true
		series[2].entregar();
		videojuegos[1].entregar();
		videojuegos[2].entregar();
		videojuegos[3].entregar();
		videojuegos[4].entregar();

		int seriesEntregadas = contarEntregados(series);
			System.out.println("Total de SERIES entregadas: " + seriesEntregadas);

		int videojuegosEntregados = contarEntregados(videojuegos);
			System.out.println("Total de VIDEOJUEGOS entregados: " + videojuegosEntregados);

		TA9Ej2_Videojuego videojuegoMasHoras = obtenerVideojuegoMasHoras(videojuegos);
			System.out.println("\nEl videojuego con más horas estimadas es: \n" + videojuegoMasHoras);
			
		TA9Ej2_Serie serieMasTemporadas = obtenerSerieMasTemporadas(series);
			System.out.println("\nLa serie con más temporadas es: \n" + serieMasTemporadas);
	}

//	--- METODOS ---
	public static int contarEntregados(TA9Ej2_Entregable[] entregables) {
		int count = 0;
		for (TA9Ej2_Entregable entregable : entregables) {
			if (entregable.isEntregado()) {
				count++;
			}
		}
		return count;
	}

	public static TA9Ej2_Videojuego obtenerVideojuegoMasHoras(TA9Ej2_Videojuego[] videojuegos) {
		TA9Ej2_Videojuego masHoras = videojuegos[0];
		for (int i = 1; i < videojuegos.length; i++) {
			if (videojuegos[i].getHorasEstimadas() > masHoras.getHorasEstimadas()) {
				masHoras = videojuegos[i];
			}
		}
		return masHoras;
	}

	public static TA9Ej2_Serie obtenerSerieMasTemporadas(TA9Ej2_Serie[] series) {
		TA9Ej2_Serie masTemporadas = series[0];
		for (int i = 1; i < series.length; i++) {
			if (series[i].getNumeroTemporadas() > masTemporadas.getNumeroTemporadas()) {
				masTemporadas = series[i];
			}
		}
		return masTemporadas;
	}
	
}