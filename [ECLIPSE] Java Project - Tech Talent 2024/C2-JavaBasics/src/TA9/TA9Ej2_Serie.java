package TA9;

public class TA9Ej2_Serie implements TA9Ej2_Entregable {
//		Atributos
		private String titulo;
		private int numeroTemporadas;
	    private boolean entregado;
	    private String genero;
	    private String creador;

	    // Constructor por defecto
	    public TA9Ej2_Serie() {
	        this.numeroTemporadas = 3;
	        this.entregado = false;
	        this.genero = "";
	        this.creador = "";
	    }

	    // Constructor con titulo y creador
	    public TA9Ej2_Serie(String titulo, String creador) {
	        this();
	    	this.titulo = titulo;
	        this.creador = creador;
	    }

	    // Constructor con todos los atributos excepto entregado
	    public TA9Ej2_Serie(String titulo, int numeroTemporadas,
	    						String genero, String creador) {
	        this();
	    	this.titulo = titulo;
	        this.numeroTemporadas = numeroTemporadas;
	        this.genero = genero;
	        this.creador = creador;
	    }

//		--- METODOS ---
	    
	    public String getTitulo() {
	        return titulo;
	    }

	    public int getNumeroTemporadas() {
	        return numeroTemporadas;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public String getCreador() {
	        return creador;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public void setNumeroTemporadas(int numeroTemporadas) {
	        this.numeroTemporadas = numeroTemporadas;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public void setCreador(String creador) {
	        this.creador = creador;
	    }

//	 	--- OVERRIDE ---
	    
	    @Override
	    public String toString() {
	        return "Serie{" +
	                "titulo='" + titulo + '\'' +
	                ", numeroTemporadas=" + numeroTemporadas +
	                ", entregado=" + entregado +
	                ", genero='" + genero + '\'' +
	                ", creador='" + creador + '\'' +
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

		@Override
	    public int compareTo(Object o) {
			TA9Ej2_Serie otherSerie = (TA9Ej2_Serie) o;
	        return Integer.compare(this.numeroTemporadas, otherSerie.getNumeroTemporadas());
	    }

}
