package TA5;

import javax.swing.JOptionPane;

public class Ej3JOptionPane {
	
	public static void main(String[] args) {
		

		String user_Name = JOptionPane.showInputDialog(
				"Por favor, introduce tu nombre:");
		
		JOptionPane.showInternalMessageDialog(null,
				"¡Hola, " + user_Name + "!");
	}
}
