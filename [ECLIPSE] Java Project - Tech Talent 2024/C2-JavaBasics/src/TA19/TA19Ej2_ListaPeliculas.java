package TA19;

import javax.swing.*;
import java.awt.event.*;

public class TA19Ej2_ListaPeliculas extends JFrame {
    
    private JTextField textField;
    
    public TA19Ej2_ListaPeliculas() {
        setTitle("Peliculas");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        // Crear un campo de texto
        textField = new JTextField(20);
        textField.setBounds(10, 20, 180, 25); // Posicionamos el campo de texto
        panel.add(textField);
        
//      Componente Etiqueta
  		JLabel etiqueta= new JLabel("Escribe el título de una película");
  		etiqueta.setBounds(200, 20, 200, 20);
  		
        
      //Componente "Menú de selección"
  		JComboBox comboBox = new JComboBox<>();
  		comboBox.setBounds(10, 50, 180, 25);
  		
  		JLabel etiquetaCombo= new JLabel("Películas agregadas");
  		etiquetaCombo.setBounds(200, 50, 200, 20);
		
        
        // Crear un botón
        JButton botonAñadir = new JButton("Añadir pelicula");
        botonAñadir.setBounds(125, 110, 150, 25); //Añadimos posicion del botón
        // Agregar ActionListener al botón
        botonAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de texto
                String pelicula = textField.getText();
                comboBox.addItem(pelicula);
            	}
        	}
        );
       
        add(panel);
        panel.add(etiqueta);
		panel.add(comboBox);
		panel.add(etiquetaCombo);
		panel.add(botonAñadir);
        
    }
    
    public static void main(String[] args) {
        // Crear una instancia de la ventana
        TA19Ej2_ListaPeliculas ventana = new TA19Ej2_ListaPeliculas();
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
