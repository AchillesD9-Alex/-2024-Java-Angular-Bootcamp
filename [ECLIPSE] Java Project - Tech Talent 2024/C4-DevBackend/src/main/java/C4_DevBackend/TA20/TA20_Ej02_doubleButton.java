package C4_DevBackend.TA20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TA20_Ej02_doubleButton 
{
	public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("SuperVentana con 2 botones waaahhhhw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 200);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear la etiqueta
        JLabel label = new JLabel("El último botón pulsado es (ninguno)", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        
        // Crear el panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Crear los botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Añadir acción a los botones
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("El último botón pulsado es Botón 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("El último botón pulsado es Botón 2");
            }
        });

        // Añadir los botones al panel de botones
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Añadir el panel de botones al panel principal
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        frame.getContentPane().add(panel);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}