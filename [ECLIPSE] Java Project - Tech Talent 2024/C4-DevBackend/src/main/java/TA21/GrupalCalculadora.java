package TA21;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class GrupalCalculadora extends JFrame {

    private JTextField textField;

    public GrupalCalculadora() {
        setTitle("Calculadora");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 10);
        add(panel);

        JLabel etiquetaop1 = new JLabel("Operando 1:");
        etiquetaop1.setBounds(10, 20, 200, 20);
        panel.add(etiquetaop1);

        JTextField textOP1 = new JTextField(20);
        textOP1.setBounds(100, 20, 100, 25);
        panel.add(textOP1);

        JLabel etiquetaop2 = new JLabel("Operando 2:");
        etiquetaop2.setBounds(10, 50, 200, 20);
        panel.add(etiquetaop2);

        JTextField textOP2 = new JTextField(20);
        textOP2.setBounds(100, 50, 100, 25);
        panel.add(textOP2);

        JLabel resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoLabel.setBounds(10, 80, 380, 20);
        panel.add(resultadoLabel);

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

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(125, 110, 150, 25);
        panel.add(btnCalcular);

        JMenuBar barraMenu = new JMenuBar();
        JMenu Help = new JMenu("Help");
        barraMenu.add(Help);

        JMenuItem about = new JMenuItem("About");
        Help.add(about);
        setJMenuBar(barraMenu);

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GrupalCalculadora.this, "Esta es una calculadora simple.", "Acerca de",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Instancia de la nueva clase LogicCalculadora
        LogicCalculadora calc = new LogicCalculadora();

        // Modificar el ActionListener para usar la instancia de LogicCalculadora
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double op1 = Double.parseDouble(textOP1.getText());
                    double op2 = Double.parseDouble(textOP2.getText());
                    double resultado = 0;

                    if (btnSuma.isSelected()) {
                        resultado = calc.suma(op1, op2);
                    } else if (btnResta.isSelected()) {
                        resultado = calc.resta(op1, op2);
                    } else if (btnProd.isSelected()) {
                        resultado = calc.multiplicacion(op1, op2);
                    } else if (btnDiv.isSelected()) {
                        resultado = calc.division(op1, op2);
                    }

                    resultadoLabel.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese números válidos");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GrupalCalculadora ventana = new GrupalCalculadora();
        ventana.setVisible(true);
    }
}
