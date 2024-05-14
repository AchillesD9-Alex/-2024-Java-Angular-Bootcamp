package CALCULADORA;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class calculadora {
    public static void main(String[] args) {
        int numeros[] = {7,8,9,4,5,6,1,2,3,0};
        String operadores[] = {"/","*","-","+", "="};

        // VENTANA //

        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // PANTALLA DE CÁLCULO //
        JPanel pantalla = new JPanel();

        JTextPane pantallita = new JTextPane();
        pantallita.setBorder(new LineBorder(new Color(160, 80, 190), 4));
        pantallita.setMaximumSize(new Dimension(340, 75));
        pantallita.setEditable(false);
        pantallita.setFont(new Font("arial", Font.BOLD, 30));

        pantalla.add(pantallita);
        
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        panel.add(pantallita);

        // BOTONES NÚMEROS //

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(3, 4)); // UTILIZAR UN 'GridBagLayout' Y EN EL 'GridBagConstraints', '.gridwidth = 2;' Y ASIGNARLE 2 CELDAS DE ANCHO

        int indice_op = 0;
        int indice_nu = 0;

        // for (int i = 1; i <= 4; i++) {
        //     JPanel panel_boton = new JPanel(new BorderLayout()); 
        //     panel_boton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 

        //     RoundedButton boton = new RoundedButton(operadores[indice_op], 25);
        //     // JButton boton = new JButton(operadores[indice_op]);
        //     boton = caracteristicas_botones(boton);

        //     panel_boton.add(boton, BorderLayout.CENTER);
        //     botones.add(panel_boton);

        //     indice_op +=1;
        // };

        for (int i = 1; i <=12; i++) {
            if (!(i%4 == 0) && !(i==13) && !(i==15) && !(i==16)) {
                JPanel panel_boton = new JPanel(new BorderLayout()); 
                panel_boton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 

                RoundedButton boton = new RoundedButton(String.valueOf(numeros[indice_nu]), 25);
                // JButton boton = new JButton(String.valueOf(numeros[indice_nu]));
                boton = caracteristicas_botones(boton);

                panel_boton.add(boton, BorderLayout.CENTER);
                botones.add(panel_boton);

                indice_nu +=1;
            } else {
                JPanel panel_boton = new JPanel(new BorderLayout()); 
                panel_boton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 

                RoundedButton boton = new RoundedButton(operadores[indice_op], 25);
                // JButton boton = new JButton(operadores[indice_op]);
                boton = caracteristicas_botones(boton);

                panel_boton.add(boton, BorderLayout.CENTER);        
                botones.add(panel_boton);

                indice_op +=1;
            }
        }

        panel.add(botones);

        // FUNCIONES BOTONES //

        StringBuilder numerosOp = new StringBuilder();

        for (Component componente : botones.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panelBoton = (JPanel) componente;
                Component[] botones_array = panelBoton.getComponents();
                for (Component componente_boton : botones_array) {
                    if (componente_boton instanceof RoundedButton) {
                        RoundedButton boton = (RoundedButton) componente_boton;
                        boton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                double op1 = 0;
                                double op2 = 0;
                                double result = 0;
                                String operador = "";
                                String num = boton.getText();

                                switch(num) {
                                    case "+":
                                    case "-":
                                    case "*":
                                    case "/":
                                        op1 = Double.parseDouble(numerosOp.toString());
                                        numerosOp.setLength(0);
                                        operador = num;
                                        pantallita.revalidate();
                                        pantallita.repaint();

                                        break;
                                    
                                    case "=":
                                        op2 = Double.parseDouble(numerosOp.toString());
                                        result = operaciones(op1, op2, operador);
                                        pantallita.setText(String.valueOf(result));

                                        pantallita.revalidate();
                                        pantallita.repaint();
                                    
                                        break;
                                
                                    default:
                                        numerosOp.append(num);
                                        pantallita.setText(numerosOp.toString());
                                        pantallita.revalidate();
                                        pantallita.repaint();

                                        break;
                                }

                                    // numerosOp.append(num);
                                    // pantallita.setText(numerosOp.toString());
                                    // pantallita.revalidate();
                                    // pantallita.repaint();

                            }
                        });
                    }
                }
            }
        }        

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static RoundedButton caracteristicas_botones(RoundedButton boton) {
        boton.setBorder(new EmptyBorder(2,2,2,2));
        boton.setFont(new Font("arial", Font.BOLD, 16));
        boton.setBackground(new Color(60, 150, 230));

        return boton;
    }

    public static double operaciones(double op1, double op2, String operador) {
        double result = 0;
        switch (operador) {
            case "+":
                result = op1 + op2;
                break;
        
            case "-":
                result = op1 - op2;
                break;
        
            case "*":
                result = op1 * op2;  
                break;
        
            case "/":
                result = op1 / op2;
                break;
        
            default:
                System.out.println("¡Has tenido un error por gilipollas!");
                break;
        }
        return result;
    }
}