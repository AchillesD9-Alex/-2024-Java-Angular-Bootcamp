package C4_DevBackend.TA20;
import javax.swing.*;
import java.awt.*;

import javax.swing.*; // Importa las clases necesarias para la creación de la interfaz gráfica.
import java.awt.*;    // Importa las clases necesarias para el manejo de layout y otros componentes gráficos.

public class LayoutExample {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Ejemplo de Layout Managers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre del frame.
        frame.setSize(500, 500); // Establece el tamaño del frame.

        // Crear el panel principal con BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Establece BorderLayout como el layout manager del panel.

        // Crear el panel para la región norte con FlowLayout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout()); // Establece FlowLayout para el panel norte.
        northPanel.add(new JButton("Button 1")); // Añade botón al panel norte.
        northPanel.add(new JButton("Button 2")); // Añade otro botón al panel norte.

        // Crear el panel para la región central con GridLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2)); // Establece GridLayout con 2 filas y 2 columnas para el panel central.
        centerPanel.add(new JButton("Button 3")); // Añade botón a la celda (0,0).
        centerPanel.add(new JButton("Button 4")); // Añade botón a la celda (0,1).
        centerPanel.add(new JButton("Button 5")); // Añade botón a la celda (1,0).
        centerPanel.add(new JButton("Button 6")); // Añade botón a la celda (1,1).

        // Añadir los paneles norte y central al panel principal
        panel.add(northPanel, BorderLayout.NORTH); // Añade el panel norte a la región norte del panel principal.
        panel.add(centerPanel, BorderLayout.CENTER); // Añade el panel central a la región central del panel principal.

        // Añadir el panel principal al frame
        frame.add(panel); // Añade el panel principal al frame.

        // Hacer visible el frame
        frame.setVisible(true); // Hace que el frame sea visible.
    }
}
