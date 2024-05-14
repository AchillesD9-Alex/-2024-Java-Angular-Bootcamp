package CALCULADORA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MiniCalculadora extends JFrame implements ActionListener {
	private JTextField campoTexto1, campoTexto2, campoResultado;
	private JButton sumaBoton, restaBoton, multBoton, divBoton, resetBoton, porcentajeBoton;
	private JLabel etiqueta1, etiqueta2, etiquetaResultado;
	private ArrayList<String> historialCalculos;

	public MiniCalculadora() {
		setTitle("Pascal's_Calculator.exe");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 2));
		setResizable(false);

		// menú
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuOpciones = new JMenu("Opciones");

		JMenuItem itemHistorial = new JMenuItem("Historial");
		itemHistorial.addActionListener(this);
		menuOpciones.add(itemHistorial);
		JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
		itemAcercaDe.addActionListener(this);
		menuOpciones.add(itemAcercaDe);
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(this);
		menuOpciones.add(itemSalir);

		barraMenu.add(menuOpciones);
		setJMenuBar(barraMenu);

		historialCalculos = new ArrayList<>();

		// etiquetas
		etiqueta1 = new JLabel("Operando 1:");
		add(etiqueta1);
		campoTexto1 = new JTextField();
		customizarCampoTexto(campoTexto1);
		add(campoTexto1);

		etiqueta2 = new JLabel("Operando 2:");
		add(etiqueta2);
		campoTexto2 = new JTextField();
		customizarCampoTexto(campoTexto2);
		add(campoTexto2);

		etiquetaResultado = new JLabel("Resultado:");
		add(etiquetaResultado);
		campoResultado = new JTextField();
		campoResultado.setEditable(false);
		customizarCampoTexto(campoResultado);
		add(campoResultado);

		// botones
		sumaBoton = new JButton("+");
		sumaBoton.addActionListener(this);
		customizarBoton(sumaBoton, Color.GREEN.darker());
		add(sumaBoton);

		restaBoton = new JButton("-");
		restaBoton.addActionListener(this);
		customizarBoton(restaBoton, Color.RED.darker());
		add(restaBoton);

		multBoton = new JButton("x");
		multBoton.addActionListener(this);
		customizarBoton(multBoton, Color.BLUE.darker());
		add(multBoton);

		divBoton = new JButton("/");
		divBoton.addActionListener(this);
		customizarBoton(divBoton, Color.ORANGE.darker());
		add(divBoton);

		resetBoton = new JButton("c");
		resetBoton.addActionListener(this);
		customizarBoton(resetBoton, Color.GRAY);
		add(resetBoton);

		porcentajeBoton = new JButton("%");
		porcentajeBoton.addActionListener(this);
		customizarBoton(porcentajeBoton, Color.YELLOW.darker());
		add(porcentajeBoton);

		setVisible(true);
	}

	private void customizarBoton(JButton boton, Color color) {
		boton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		boton.setFocusPainted(false);
		boton.setBackground(color);
		boton.setForeground(Color.WHITE);

		boton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				boton.setBackground(boton.getBackground().darker());
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				boton.setBackground(boton.getBackground().brighter());
			}
		});
	}

	private void customizarCampoTexto(JTextField campoTexto) {
		campoTexto.setBackground(Color.LIGHT_GRAY);
		campoTexto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		campoTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Acerca de")) {
			String mensajeAcercaDe = "Pascal's_Calculator\nVersión 1.0\n\nDesarrollado por:\n" + "LAJ TechTigresas";
			JOptionPane.showMessageDialog(this, mensajeAcercaDe, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("Salir")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Historial")) {
			mostrarHistorial();
		} else if (e.getSource() == resetBoton) {
			campoTexto1.setText("");
			campoTexto2.setText("");
			campoResultado.setText("");
		} else {
			double num1, num2;
			try {
				num1 = Double.parseDouble(campoTexto1.getText());
				num2 = Double.parseDouble(campoTexto2.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "¡Por favor, introduce caracteres validos!", "Atención", JOptionPane.WARNING_MESSAGE);
				return;
			}

			double resultado = 0.0;

			if (e.getSource() == sumaBoton) {
				resultado = num1 + num2;
			} else if (e.getSource() == restaBoton) {
				resultado = num1 - num2;
			} else if (e.getSource() == multBoton) {
				resultado = num1 * num2;
			} else if (e.getSource() == divBoton) {
				if (num2 != 0) {
					resultado = num1 / num2;
				} else {
					JOptionPane.showMessageDialog(this, "¡Ups! No se puede dividir por cero.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else if (e.getSource() == porcentajeBoton) {
				resultado = (num1 * num2) / 100;
			}

			campoResultado.setText(String.valueOf(resultado));

			String calculo = num1 + " " + e.getActionCommand() + " " + num2 + " = " + resultado;
			agregarAlHistorial(calculo);
		}
	}

	private void agregarAlHistorial(String calculo) {
		historialCalculos.add(calculo);
	}

	private void mostrarHistorial() {
		JTextArea areaHistorial = new JTextArea();
		areaHistorial.setEditable(false);
		areaHistorial.setRows(10);
		areaHistorial.setColumns(30);

		StringBuilder textoHistorial = new StringBuilder();
		for (String calculo : historialCalculos) {
			textoHistorial.append(calculo).append("\n");
		}
		areaHistorial.setText(textoHistorial.toString());

		JScrollPane scrollPane = new JScrollPane(areaHistorial);
		JOptionPane.showMessageDialog(this, scrollPane, "Historial de cálculos", JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) {
		new MiniCalculadora();
	}
}