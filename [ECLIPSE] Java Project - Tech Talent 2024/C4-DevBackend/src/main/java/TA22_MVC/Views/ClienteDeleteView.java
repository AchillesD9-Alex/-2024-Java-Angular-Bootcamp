package TA22_MVC.Views;

import javax.swing.*;

import TA22_MVC.Controllers.ClienteController;
import TA22_MVC.Models.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteDeleteView extends JFrame {
    private ClienteController clienteController;

    public ClienteDeleteView() {
        clienteController = new ClienteController();
        setTitle("Eliminar Cliente");
        setSize(400, 150);
        setLayout(new GridLayout(0, 2));

        // ComboBox para listar los clientes
        JComboBox<String> clienteComboBox = new JComboBox<>();
        List<Cliente> clientes = clienteController.getAllClientes();
        for (Cliente cliente : clientes) {
            clienteComboBox.addItem(cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2());
        }
        add(new JLabel("Cliente:"));
        add(clienteComboBox);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clienteComboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    int id = clientes.get(selectedIndex).getId();
                    clienteController.deleteCliente(id);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente para eliminar.");
                }
            }
        });
        add(deleteButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteDeleteView();
    }
}


