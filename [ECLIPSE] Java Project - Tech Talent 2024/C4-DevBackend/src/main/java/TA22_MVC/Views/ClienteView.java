package TA22_MVC.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView {
    private JFrame frame;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtDni;
    private JTextField txtId;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;

    public ClienteView() {
        frame = new JFrame("Gestión de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 20, 80, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 160, 25);
        panel.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 60, 80, 25);
        panel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 60, 160, 25);
        panel.add(txtApellido);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 100, 80, 25);
        panel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 100, 160, 25);
        panel.add(txtDireccion);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(10, 140, 80, 25);
        panel.add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(100, 140, 160, 25);
        panel.add(txtDni);
        
        JLabel lblId = new JLabel("ID:"); 
        lblId.setBounds(10, 180, 80, 25);
        panel.add(lblId);

        txtId = new JTextField(); 
        txtId.setBounds(100, 180, 160, 25);
        panel.add(txtId);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 200, 100, 25);
        panel.add(btnAgregar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(120, 200, 100, 25);
        panel.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(230, 200, 100, 25);
        panel.add(btnEliminar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(10, 240, 100, 25);
        panel.add(btnBuscar);
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public int getDni() {
        return Integer.parseInt(txtDni.getText());
    }

    public int getId() {
        return Integer.parseInt(txtId.getText());
    }

 // Métodos para establecer valores en los campos de texto
    public void setNombre(String nombre) {
        txtNombre.setText(nombre);
    }

    public void setApellido(String apellido) {
        txtApellido.setText(apellido);
    }

    public void setDireccion(String direccion) {
        txtDireccion.setText(direccion);
    }

    public void setDni(int dni) {
        txtDni.setText(String.valueOf(dni));
    }

    public void addAgregarListener(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }

    public void addActualizarListener(ActionListener listener) {
        btnActualizar.addActionListener(listener);
    }

    public void addEliminarListener(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void addBuscarListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }
    
}

