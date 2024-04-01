package TA9;

public class TA9Ej3_MainApp {

	public static void main(String[] args) {
		TA9Ej3_Libro libro1 = new TA9Ej3_Libro("12345", "El señor de los anillos",
												"J.R.R. Tolkien", 1000);
		TA9Ej3_Libro libro2 = new TA9Ej3_Libro("67890", "Harry Potter y la piedra filosofal",
												"J.K. Rowling", 500);

		System.out.println(libro1.toString());
		System.out.println(libro2.toString());

		System.out.println("\nEl libro con más páginas:\n" + libro1.compararPaginas(libro2).toString());
	}
	
}
