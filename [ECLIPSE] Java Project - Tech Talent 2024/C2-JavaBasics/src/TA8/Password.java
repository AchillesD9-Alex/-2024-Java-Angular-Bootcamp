package TA8;

import javax.swing.JOptionPane;

public class Password {

	// Atributos (o campos/propiedades)
	private String contraseña;
	private int longitud;

//	Constructor por defecto
	public Password() {
		this.contraseña = "12345678";
		this.longitud = 8;
	}
	
//	Constructor contraseña (no se pide)
	public Password(String contraseña) {
		setContraseña(contraseña);
	}
	
//	Constructor longitud + generar contraseña aleatoria
	public Password(int longitud) {
		setLongitud(longitud);
	}

//	Constructor todos los atributos como parámetro
	public Password(String contraseña, int longitud) {
		this.contraseña = contraseña;
		this.longitud = longitud;
	}
	
	
	// Métodos (o funciones)
	public String getContraseña() {
		return contraseña;
	}

//	Con la longitud que tenga actualmente la Password, se pide una contraseña al usuario.
	/* Se pide como string para que quede claro en el contructor; si tuviese un main,
	 * la peticion de la contraseña mediante JOpP estaría ahí. Ahora mismo repito el
	 * input de la contraseña, pero soy consciente de ello.
	 */
	public void setContraseña(String contraseña) {
		int longitud = getLongitud();
		contraseña = JOptionPane.showInputDialog
        		("Ingrese la nueva contraseña de " +longitud+ " carácteres.");
		int longitudNewPas = contraseña.length();
		
        while (longitudNewPas != longitud){
        	System.out.println("La contraseña introducida no cumple con la longitud necesaria: "
        			+longitud+ "carácteres.");
        	contraseña = JOptionPane.showInputDialog
            		("Ingrese la nueva contraseña de " +longitud+ " carácteres.");
        	longitudNewPas = contraseña.length();
        }
        
        this.contraseña = contraseña;
		
	}

//	Se pide una contraseña al usuario y se actualiza la length de Password acorde a la nueva contraseña.
	public void setFreeContraseña() {
		
		String contraseña = JOptionPane.showInputDialog
        		("Ingrese la nueva contraseña.");
		
        this.longitud = contraseña.length();
        this.contraseña = contraseña;
	}
	
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
    	longitud = Integer.parseInt(JOptionPane.showInputDialog("Introduce la longitud nueva deseada:"));
//		Caracteres que pueden estar en la contraseña
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder contraseñaAleatoria = new StringBuilder();

        // Generar la contraseña aleatoria
        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = (int) (Math.random() * caracteres.length());
            contraseñaAleatoria.append(caracteres.charAt(indiceAleatorio));
        }
       
        this.contraseña = contraseñaAleatoria.toString();
        this.longitud = longitud;
    }
	
	public String imprimirPass() {
        return "Password{" +
                "contraseña='" + contraseña + '\'' +
                ", longitud=" + longitud +
                '}';
    }
}
