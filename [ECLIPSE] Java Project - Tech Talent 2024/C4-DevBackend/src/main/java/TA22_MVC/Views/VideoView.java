package TA22_MVC.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoView {
	private JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtDirector;
	private JTextField txtClienteId;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;

	public VideoView() {
		frame = new JFrame("Gestión de Videos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(10, 20, 80, 25);
		panel.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(100, 20, 160, 25);
		panel.add(txtTitulo);

		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(10, 60, 80, 25);
		panel.add(lblDirector);

		txtDirector = new JTextField();
		txtDirector.setBounds(100, 60, 160, 25);
		panel.add(txtDirector);

		JLabel lblClienteId = new JLabel("Cliente ID:");
		lblClienteId.setBounds(10, 100, 80, 25);
		panel.add(lblClienteId);

		txtClienteId = new JTextField();
		txtClienteId.setBounds(100, 100, 160, 25);
		panel.add(txtClienteId);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 160, 100, 25);
		panel.add(btnAgregar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(120, 160, 100, 25);
		panel.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(230, 160, 100, 25);
		panel.add(btnEliminar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 200, 100, 25);
		panel.add(btnBuscar);
	}

	public String getTitulo() {
		return txtTitulo.getText();
	}

	public String getDirector() {
		return txtDirector.getText();
	}

	public int getClienteId() {
		return Integer.parseInt(txtClienteId.getText());
	}

	public void setTitulo(String titulo) {
		txtTitulo.setText(titulo);
	}

	public void setDirector(String director) {
		txtDirector.setText(director);
	}

	public void setClienteId(int clienteId) {
		txtClienteId.setText(String.valueOf(clienteId));
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

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
