package TA22_MVC.Views;

import javax.swing.*;

import TA22_MVC.Controllers.ClienteController;
import TA22_MVC.Models.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteCreateView extends JFrame {
    private ClienteController clienteController;

    public ClienteCreateView() {
        clienteController = new ClienteController();
        setTitle("Agregar Cliente");
        setSize(400, 300);
        
        // Asegúrate de usar un GridLayout desde el inicio
        setLayout(new GridLayout(8, 2));

        JTextField nombreField = new JTextField();
        JTextField apellido1Field = new JTextField();
        JTextField apellido2Field = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField dniField = new JTextField();
        JTextField fechaField = new JTextField();

        add(new JLabel("Nombre**:"));
        add(nombreField);
        add(new JLabel("Apellido1**:"));
        add(apellido1Field);
        add(new JLabel("Apellido2:"));
        add(apellido2Field);
        add(new JLabel("CP:"));
        add(direccionField);
        add(new JLabel("DNI**:"));
        add(dniField);
        add(new JLabel("Fecha** (YYYY-MM-DD):"));
        add(fechaField);

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validaciones
                if (nombreField.getText().isEmpty() || apellido1Field.getText().isEmpty() 
                        || dniField.getText().isEmpty() || fechaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                            "Todos los campos obligatorios deben ser llenados.", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    java.sql.Date.valueOf(fechaField.getText());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Debe estar en formato YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente();
                cliente.setNombre(nombreField.getText());
                cliente.setApellido1(apellido1Field.getText());
                cliente.setApellido2(apellido2Field.getText());
                cliente.setCP(direccionField.getText());
                cliente.setDni(dniField.getText());
                cliente.setFecha(java.sql.Date.valueOf(fechaField.getText()));
                clienteController.addCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
            }
        });
        add(addButton);

        // Etiqueta para indicar campos obligatorios
        JLabel obligatoriosLabel = new JLabel("**Estos campos son obligatorios");
        obligatoriosLabel.setForeground(Color.BLUE);
        add(obligatoriosLabel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteCreateView();
    }
}