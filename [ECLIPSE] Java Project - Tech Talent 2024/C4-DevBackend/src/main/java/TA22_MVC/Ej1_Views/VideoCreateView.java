package TA22_MVC.Ej1_Views;

import javax.swing.*;

import TA22_MVC.Ej1_Controllers.ClienteController;
import TA22_MVC.Ej1_Controllers.VideoController;
import TA22_MVC.Ej1_Models.Cliente;
import TA22_MVC.Ej1_Models.Video;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VideoCreateView extends JFrame {
    private VideoController videoController;

    public VideoCreateView() {
        videoController = new VideoController();
        setTitle("Agregar Video");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Asegúrate de establecer GridLayout
        setLayout(new GridLayout(5, 2)); // 5 filas y 2 columnas

        JTextField titleField = new JTextField();
        JTextField directorField = new JTextField();

        JComboBox<String> clienteComboBox = new JComboBox<>();
        List<Cliente> clientes = new ClienteController().getAllClientes();
        for (Cliente cliente : clientes) {
            clienteComboBox.addItem(cliente.getNombre() + " " + cliente.getApellido1() + " " + cliente.getApellido2());
        }

        add(new JLabel("Título**:"));
        add(titleField);
        add(new JLabel("Director**:"));
        add(directorField);
        add(new JLabel("Cliente**:"));
        add(clienteComboBox);

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (titleField.getText().isEmpty() || directorField.getText().isEmpty() || clienteComboBox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Todos los campos obligatorios deben ser llenados.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Video video = new Video();
                video.setTitle(titleField.getText());
                video.setDirector(directorField.getText());

                int selectedIndex = clienteComboBox.getSelectedIndex();
                Cliente selectedCliente = clientes.get(selectedIndex);
                video.setCli_id(selectedCliente.getId());

                videoController.addVideo(video);
                JOptionPane.showMessageDialog(null, "Video agregado exitosamente.");
            }
        });
        add(addButton);

        // Etiqueta para indicar campos obligatorios
        JLabel obligatoriosLabel = new JLabel("**Campo obligatorio");
        obligatoriosLabel.setForeground(Color.BLUE);
        add(obligatoriosLabel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VideoCreateView();
    }
}