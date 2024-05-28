package TA21;

public class Geometria {
	
	// Atributos de clase
	private int id;
	private String nom;
	private double area;
	
	// Constructores
	public Geometria(int id) {
		this.id = id;
		this.nom = figura(id);
	}
	
	public Geometria() {
		this.id = 9;
		this.nom = "Default";
	}

	// Métodos propios de clase Geometria
	// Método para calcular el área del cuadrado
	public int areacuadrado(int n1){
		return n1*n1;
		}
	
	// Método para calcular el área del círculo
	public double areaCirculo(int r){
		final double PI=3.1416; 
		return  PI * Math.pow(r,2);
		}
	
	// Método para calcular el área del triángulo
	public int areatriangulo(int a, int b){
		return (a*b)/2;
		}
	
	// Método para calcular el área del rectángulo
	public int arearectangulo(int b , int h){
		return b*h;
		}
	
	// Método para calcular el área del pentágono
	public int areapentagono(int p, int a){
		return (p*a) / 2;
		}
	
	// Método para calcular el área del rombo
	public int arearombo(int D,int d){
		return (D*d)/2 ;
		}
	
	// Método para calcular el área del romboide
	public int arearomboide(int b,int h){
		return b*h ;
		}
	
	// Método para calcular el área del trapecio
	public int areatrapecio (int B , int b , int h){ 
		return ((B+b)/2)*h;
		}
	
	// Selector de figuras
	public String figura(int fiCode) {
		
		String Figura="";
		
		switch (fiCode) 
		{
		case 1: Figura= "Cuadrado";
			break;
		case 2: Figura= "Circulo";
			break;
		case 3: Figura= "Triangulo";
			break;
		case 4: Figura= "Rectangulo";
			break;
		case 5: Figura= "Pentagono";
			break;
		case 6: Figura= "Rombo";
			break;
		case 7: Figura= "Romboide";
			break;
		case 8: Figura= "Trapecio";
			break;
		default:
			Figura= "Default";
			break;
		}
		return Figura.toLowerCase(); // Convertir a minúsculas
	}
	
	// Getters y Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Geometria [id=" + id + ", nom=" + nom + ", area=" + area + "]";
	}
		
}
