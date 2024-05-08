package TA19;

import javax.swing.*;
import java.awt.event.*;

public class TA19Ej3_EncuestaGrafica extends JFrame {

    private JTextField textField;

    public TA19Ej3_EncuestaGrafica() {
        setTitle("Encuesta");
        setSize(420, 500); // Aumentamos el tamaño de la ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Componente Etiqueta "botón radio"
        JLabel etiquetaRadio = new JLabel("Elige un sistema operativo:");
        etiquetaRadio.setBounds(10, 20, 200, 20);
        panel.add(etiquetaRadio);

        JRadioButton rdbtnOpcion1 = new JRadioButton("Windows", false);
        rdbtnOpcion1.setBounds(10, 50, 109, 23);
        panel.add(rdbtnOpcion1);

        JRadioButton rdbtnOpcion2 = new JRadioButton("Linux", false);
        rdbtnOpcion2.setBounds(10, 80, 109, 23);
        panel.add(rdbtnOpcion2);

        JRadioButton rdbtnOpcion3 = new JRadioButton("Mac", false);
        rdbtnOpcion3.setBounds(10, 110, 109, 23);
        panel.add(rdbtnOpcion3);

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnOpcion1);
        bgroup.add(rdbtnOpcion2);
        bgroup.add(rdbtnOpcion3);

        // Componente Etiqueta "checkbox"
        JLabel etiquetaCheckbox = new JLabel("Elige tu especialidad:");
        etiquetaCheckbox.setBounds(10, 150, 200, 20);
        panel.add(etiquetaCheckbox);

        JCheckBox chckbxOpcion = new JCheckBox("Programación", false);
        chckbxOpcion.setBounds(10, 180, 150, 23);
        panel.add(chckbxOpcion);

        JCheckBox chckbxNewCheck = new JCheckBox("Diseño gráfico", false);
        chckbxNewCheck.setBounds(10, 210, 150, 23);
        panel.add(chckbxNewCheck);

        JCheckBox chckbxOpcion3 = new JCheckBox("Administración", false);
        chckbxOpcion3.setBounds(10, 240, 150, 23);
        panel.add(chckbxOpcion3);

        // Componente Slider para las horas dedicadas
        JLabel etiquetaSlider = new JLabel("Horas dedicadas en el ordenador:");
        etiquetaSlider.setBounds(10, 280, 300, 20); // Etiqueta para el slider
        panel.add(etiquetaSlider);

        JSlider sliderHoras = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        sliderHoras.setMajorTickSpacing(1);
        sliderHoras.setPaintTicks(true);
        sliderHoras.setPaintLabels(true);
        sliderHoras.setBounds(10, 310, 380, 50); // Ajustamos la posición del slider
        sliderHoras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX();
                int width = sliderHoras.getWidth();
                double proportion = (double) mouseX / width;
                int value = (int) Math.round(proportion * sliderHoras.getMaximum());
                sliderHoras.setValue(value);
            }
        });
        panel.add(sliderHoras);

        // Crear botón "Finalizar"
        JButton botonFinalizar = new JButton("Finalizar");
        botonFinalizar.setBounds(150, 380, 100, 40);
        // Agregar ActionListener al botón "Finalizar"
        botonFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos seleccionados
                String sistemaOperativo = "";
                if (rdbtnOpcion1.isSelected()) {
                    sistemaOperativo = "Windows";
                } else if (rdbtnOpcion2.isSelected()) {
                    sistemaOperativo = "Linux";
                } else if (rdbtnOpcion3.isSelected()) {
                    sistemaOperativo = "Mac";
                } else {
                    sistemaOperativo = "No seleccionado";
                }

                String especialidades = "";
                if (chckbxOpcion.isSelected()) {
                    especialidades += "Programación, ";
                }
                if (chckbxNewCheck.isSelected()) {
                    especialidades += "Diseño gráfico, ";
                }
                if (chckbxOpcion3.isSelected()) {
                    especialidades += "Administración, ";
                }
                if (!especialidades.isEmpty()) {
                    especialidades = especialidades.substring(0, especialidades.length() - 2); // Eliminar la última coma y espacio
                } else {
                    especialidades = "No seleccionado";
                }

                int horasDedicadas = sliderHoras.getValue();

                // Mostrar los datos en un JOptionPane
             // Mostrar los datos en un JOptionPane con un título personalizado
                JOptionPane.showMessageDialog(null,"Sistema operativo seleccionado: "+ sistemaOperativo +
                        "\nEspecialidades seleccionadas: " + especialidades +
                        "\nHoras dedicadas: " + horasDedicadas,
                        "Resultados encuesta", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(panel);
        panel.add(botonFinalizar);
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana
        TA19Ej3_EncuestaGrafica ventana = new TA19Ej3_EncuestaGrafica();
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}

