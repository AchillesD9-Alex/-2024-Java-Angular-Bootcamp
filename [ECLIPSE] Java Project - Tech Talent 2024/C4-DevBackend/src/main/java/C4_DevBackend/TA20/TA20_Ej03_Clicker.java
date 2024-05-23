package C4_DevBackend.TA20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TA20_Ej03_Clicker {

    private int countButton1 = 0;
    private int countButton2 = 0;

    public TA20_Ej03_Clicker() {
        // Crear el marco de la aplicación
        JFrame frame = new JFrame("Clicker pa que te aburras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear etiquetas
        JLabel label1 = new JLabel("Botón 1: 0 clicks", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Botón 2: 0 clicks", SwingConstants.CENTER);

        // Crear botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Agregar ActionListeners a los botones
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countButton1++;
                label1.setText("Botón 1: " + countButton1 + " clicks");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countButton2++;
                label2.setText("Botón 2: " + countButton2 + " clicks");
            }
        });

        // Crear panel con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        // Definir la posición y el comportamiento de cada componente dentro del GridBagLayout:
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // Configurar y agregar componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(label2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(button1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button2, gbc);

        // Agregar el panel al marco
        frame.getContentPane().add(panel);

        // Hacer visible el marco
        frame.setVisible(true);
    }

//  MAIN
    public static void main(String[] args) {
        // Crear y mostrar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TA20_Ej03_Clicker();
            }
        });
    }
}
