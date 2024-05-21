package C4_DevBackend.TA20;

import javax.swing.*;
import java.awt.*;

public class TA20_Ej01_ventana 
{
	public static void main(String[] args) {
        // Configuración de la ventana principal
        JFrame frame = new JFrame("MegaVentana de la Muerte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Tamaño inicial de la ventana
        
        // Configuración de una etiqueta
        JLabel label = new JLabel("¡WASSAAAAAAA!", SwingConstants.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}