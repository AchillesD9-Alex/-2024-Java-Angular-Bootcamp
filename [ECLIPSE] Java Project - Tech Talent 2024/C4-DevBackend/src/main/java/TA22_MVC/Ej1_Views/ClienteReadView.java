package TA22_MVC.Ej1_Views;

import javax.swing.*;

import TA22_MVC.Ej1_Controllers.ClienteController;
import TA22_MVC.Ej1_Models.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteReadView extends JFrame {
    private ClienteController clienteController;

    public ClienteReadView() {
        clienteController = new ClienteController();
        setTitle("Mostrar Todos los Clientes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Cambiar la fuente y el tamaño del texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Actualizar Lista");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clientes = clienteController.getAllClientes();
                textArea.setText("");
                for (Cliente cliente : clientes) {
                    textArea.append(cliente.getId() + ": " + cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2() + "\n");
                }
            }
        });
        add(refreshButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteReadView();
    }
}

