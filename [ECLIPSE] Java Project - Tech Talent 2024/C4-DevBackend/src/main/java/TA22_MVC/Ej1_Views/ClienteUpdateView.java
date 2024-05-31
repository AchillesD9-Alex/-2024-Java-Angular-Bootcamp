package TA22_MVC.Ej1_Views;

import javax.swing.*;

import TA22_MVC.Ej1_Controllers.ClienteController;
import TA22_MVC.Ej1_Models.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ClienteUpdateView extends JFrame {
    private ClienteController clienteController;

    public ClienteUpdateView() {
        clienteController = new ClienteController();
        setTitle("Actualizar Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));

        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField apellido1Field = new JTextField();
        JTextField apellido2Field = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField dniField = new JTextField();
        JTextField fechaField = new JTextField();
        
        JComboBox<String> clienteComboBox = new JComboBox<>();
        List<Cliente> clientes = new ClienteController().getAllClientes();
        for (Cliente cliente : clientes) {
            clienteComboBox.addItem(cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2());
        }
        
//        add(new JLabel("ID:"));
//        add(idField);
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido1:"));
        add(apellido1Field);
        add(new JLabel("Apellido2:"));
        add(apellido2Field);
        add(new JLabel("CP:"));
        add(direccionField);
        add(new JLabel("DNI:"));
        add(dniField);
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        add(fechaField);
        add(new JLabel("Cliente**:"));
        add(clienteComboBox);

        JButton updateButton = new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    int selectedIndex = clienteComboBox.getSelectedIndex();
        	    Cliente selectedCliente = clientes.get(selectedIndex);
        	    if (selectedCliente != null) {
        	        // Verificar y actualizar solo si el campo no está vacío
        	        String nuevoNombre = nombreField.getText().trim();
        	        if (!nuevoNombre.isEmpty()) {
        	            selectedCliente.setNombre(nuevoNombre);
        	        }

        	        String nuevoApellido1 = apellido1Field.getText().trim();
        	        if (!nuevoApellido1.isEmpty()) {
        	            selectedCliente.setApellido1(nuevoApellido1);
        	        }

        	        String nuevoApellido2 = apellido2Field.getText().trim();
        	        if (!nuevoApellido2.isEmpty()) {
        	            selectedCliente.setApellido2(nuevoApellido2);
        	        }

        	        String nuevaDireccion = direccionField.getText().trim();
        	        if (!nuevaDireccion.isEmpty()) {
        	            selectedCliente.setCP(nuevaDireccion);
        	        }

        	        String nuevoDni = dniField.getText().trim();
        	        if (!nuevoDni.isEmpty()) {
        	            selectedCliente.setDni(nuevoDni);
        	        }

        	        String nuevaFechaTexto = fechaField.getText().trim();
        	        if (!nuevaFechaTexto.isEmpty()) {
        	            try {
        	                selectedCliente.setFecha(java.sql.Date.valueOf(fechaField.getText()));
        	            } catch (IllegalArgumentException ex) {
        	                JOptionPane.showMessageDialog(null, "Fecha no válida. Debe estar en el formato AAAA-MM-DD.");
        	                return;
        	            }
        	        }

        	        ClienteController.updateCliente(selectedCliente);
        	        JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");

        	        // Refrescar el JComboBox
        	        clienteComboBox.removeAllItems(); // Eliminar todos los elementos actuales

        	        // Añadir los elementos actualizados
        	        for (Cliente cliente : clientes) {
        	            clienteComboBox.addItem(cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2());
        	        }

        	        // Seleccionar nuevamente el cliente actualizado
        	        clienteComboBox.setSelectedIndex(selectedIndex);

        	    } else {
        	        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        	    }
        	}


        });
        add(updateButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteUpdateView();
    }
}

