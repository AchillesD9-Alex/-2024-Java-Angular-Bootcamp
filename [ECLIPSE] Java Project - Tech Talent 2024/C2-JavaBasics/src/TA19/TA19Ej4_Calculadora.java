package TA19;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class TA19Ej4_Calculadora extends JFrame {

	private JTextField textField;

//	FORMATO VENTANA
	public TA19Ej4_Calculadora() {
		setTitle("Calculadora");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      CREAR PANEL
		JPanel panel = new JPanel();
		panel.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 10);
		add(panel);

//      OPERANDO 1
		JLabel etiquetaop1 = new JLabel("Operando 1:");
		etiquetaop1.setBounds(10, 20, 200, 20);
		panel.add(etiquetaop1);

		JTextField textOP1 = new JTextField(20);
		textOP1.setBounds(100, 20, 100, 25); // Posicionamos el campo de texto
		panel.add(textOP1);

//      OPERANDO 2
		JLabel etiquetaop2 = new JLabel("Operando 2:");
		etiquetaop2.setBounds(10, 50, 200, 20);
		panel.add(etiquetaop2);

		JTextField textOP2 = new JTextField(20);
		textOP2.setBounds(100, 50, 100, 25);
//		
		panel.add(textOP2);

//      BOTON CALCULAR
		JButton botonAñadir = new JButton("Calcular");
		botonAñadir.setBounds(125, 110, 150, 25);
		panel.add(botonAñadir);

		// Agregar ActionListener a CALCULAR
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
//		BOTONES OPERACIONES
		JRadioButton btnSuma = new JRadioButton("+", false);
		btnSuma.setBounds(250, 10, 50, 30);
		panel.add(btnSuma);
		
		JRadioButton btnResta = new JRadioButton("-", false);
		btnResta.setBounds(310, 10, 50, 30);
		panel.add(btnResta);
		
		JRadioButton btnProd = new JRadioButton("*", false);
		btnProd.setBounds(250, 45, 50, 30);
		panel.add(btnProd);
		
		JRadioButton btnDiv = new JRadioButton("/", false);
		btnDiv.setBounds(310, 45, 50, 30);
		panel.add(btnDiv);

		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(btnSuma);
        bgroup.add(btnResta);
        bgroup.add(btnProd);
        bgroup.add(btnDiv);
        
		double op1 = Double.parseDouble(textOP1.getText());
        double op2 = Double.parseDouble(textOP2.getText());
//        double resultado = 0;
//        if (btnSuma.isSelected()) {
//            resultado = op1 + op2;
//        } else if (btnResta.isSelected()) {
//        	resultado = op1 - op2;
//        } else if (btnProd.isSelected()) {
//        	resultado = op1 * op2;
//        } else if (btnDiv.isSelected()) {
//        	resultado = op1 / op2;
//        }
        
	}

	public static void main(String[] args) {
		// Crear una instancia de la ventana
		TA19Ej4_Calculadora ventana = new TA19Ej4_Calculadora();
		// Hacer visible la ventana
		ventana.setVisible(true);
	}
}
