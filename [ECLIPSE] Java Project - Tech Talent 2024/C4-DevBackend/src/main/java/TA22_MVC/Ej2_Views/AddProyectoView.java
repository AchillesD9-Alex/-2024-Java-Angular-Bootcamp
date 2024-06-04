package TA22_MVC.Ej2_Views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import TA22_MVC.Ej2_Controllers.ProyectoController;

public class AddProyectoView extends JFrame {
    private JTextField idProyectoField;
    private JTextField nombreField;
    private JTextField horasField;
    private JButton crearButton;

    public AddProyectoView() {
        setTitle("Crear Proyecto");
        setLayout(null);

        JLabel idProyectoLabel = new JLabel("ID Proyecto:");
        idProyectoLabel.setBounds(30, 30, 100, 30);
        add(idProyectoLabel);

        idProyectoField = new JTextField();
        idProyectoField.setBounds(150, 30, 150, 30);
        add(idProyectoField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(30, 70, 100, 30);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(150, 70, 150, 30);
        add(nombreField);

        JLabel horasLabel = new JLabel("Horas:");
        horasLabel.setBounds(30, 110, 100, 30);
        add(horasLabel);

        horasField = new JTextField();
        horasField.setBounds(150, 110, 150, 30);
        add(horasField);

        crearButton = new JButton("Crear");
        crearButton.setBounds(150, 150, 100, 30);
        add(crearButton);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProyecto = idProyectoField.getText();
                String nombre = nombreField.getText();
                int horas = Integer.parseInt(horasField.getText());
                ProyectoController.addProyecto(idProyecto, nombre, horas);
                JOptionPane.showMessageDialog(null, "Proyecto creado con éxito!");
            }
        });

        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
