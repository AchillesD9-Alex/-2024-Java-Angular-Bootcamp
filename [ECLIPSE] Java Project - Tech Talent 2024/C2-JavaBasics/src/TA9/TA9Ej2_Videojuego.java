package TA9;

public class TA9Ej2_Videojuego implements TA9Ej2_Entregable{
    // Atributos
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String company;

    
    // Constructor por defecto
    public TA9Ej2_Videojuego() {
        this.horasEstimadas = 10;
        this.entregado = false;
        this.genero = "";
        this.company = "";
    }

    // Constructor con titulo y horas estimadas
    public TA9Ej2_Videojuego(String titulo, int horasEstimadas) {
        this();
    	this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
    }

    // Constructor con todos los atributos excepto entregado
    public TA9Ej2_Videojuego(String titulo, int horasEstimadas,
    							String genero, String company) {
        this();
    	this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.company = company;   
    }

//    --- METODOS ---
    
    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public String getcompany() {
        return company;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setcompany(String company) {
        this.company = company;
    }

  
//  --- OVERRIDE ---
    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
	public void entregar() {
		this.entregado = true;
	}

	@Override
	public void devolver() {	
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return entregado;
	}

//	Metodo compareTo "es videojuego un videojuego?"
	@Override
    public int compareTo(Object o) {
		TA9Ej2_Videojuego otherVideojuego = (TA9Ej2_Videojuego) o;
        return Integer.compare(this.horasEstimadas, otherVideojuego.getHorasEstimadas());
    }
}