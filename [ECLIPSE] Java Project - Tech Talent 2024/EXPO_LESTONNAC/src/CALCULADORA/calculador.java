package CALCULADORA;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.*;

public class calculador {
    public static void main(String[] args) {
        int numeros[] = {7,8,9,4,5,6,1,2,3,0};
        String operadores[] = {"/","*","-", ",", "+", "C", "="};

        // VENTANA //

        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // VENTANA //

        // PANTALLA DE CÁLCULO //

        JPanel pantalla = new JPanel();

        JTextPane pantallita = new JTextPane();
        pantallita.setBorder(new LineBorder(new Color(160, 80, 190), 4));
        pantallita.setMaximumSize(new Dimension(340, 75));
        pantallita.setFont(new Font("arial", Font.BOLD, 30));
        pantallita.setEditable(false);
        pantallita.setText("0");

        pantalla.add(pantallita);
        
        panel.setBorder(new EmptyBorder(10, 20, 10, 20));

        panel.add(pantallita);

        // PANTALLA DE CÁLCULO //

        // PANEL BOTONES NÚMEROS //

        JPanel botones = new JPanel();
        botones.setLayout(new GridBagLayout());
        GridBagConstraints caracteristicasCelda = new GridBagConstraints();
        caracteristicasCelda.fill = GridBagConstraints.BOTH;
        caracteristicasCelda.weightx = 1;
        caracteristicasCelda.weighty = 1;

        int indice_op = 0;
        int indice_nu = 0;
        int num_cel = 0;
        boolean doble = false;
        
        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 4; i++) {
                if (num_cel == 13 || num_cel == 15 || num_cel == 16) {
                    caracteristicasCelda.gridwidth = 2;
                    doble = true;
                } else {
                    caracteristicasCelda.gridwidth = 1;
                    doble = false;
                }
                if (!(i%4 == 0) && !(num_cel == 12) && !(j == 5)) {
                    JPanel panel_boton = new JPanel(new BorderLayout()); 
                    panel_boton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 

                    RoundedButton boton = new RoundedButton(String.valueOf(numeros[indice_nu]), 25, "numeros");
                    panel_boton.add(boton, BorderLayout.CENTER);

                    caracteristicasCelda.gridx = i;
                    caracteristicasCelda.gridy = j;

                    botones.add(panel_boton, caracteristicasCelda);
                    indice_nu++;

                    if (doble) {
                        i++;
                    }
                } else {
                    JPanel panel_boton = new JPanel(new BorderLayout()); 
                    panel_boton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); 

                    RoundedButton boton = new RoundedButton(null);
                    switch (num_cel) {
                        case 15:
                            boton = new RoundedButton(operadores[indice_op], 25, "cancelar");
                            break;
                    
                        case 16:
                            boton = new RoundedButton(operadores[indice_op], 25, "resultado");
                            break;
                    
                        default:
                            boton = new RoundedButton(operadores[indice_op], 25, "string");
                            break;
                    }

                    panel_boton.add(boton, BorderLayout.CENTER);
                    
                    caracteristicasCelda.gridx = i;
                    caracteristicasCelda.gridy = j;

                    botones.add(panel_boton, caracteristicasCelda);

                    indice_op++;

                    if (doble) {
                        i++;
                    }
                }
                num_cel++;
            }
        }
        panel.add(botones);

        // PANEL BOTONES NÚMEROS //

        // FUNCIONES BOTONES //

        StringBuilder operacion = new StringBuilder();

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
                                double decimal = 0;
                                int entero = 0;
                                boolean hayOperador = false;
                                double num1 = 0;
                                double num2 = 0;
                                String simbolo = "";
                                double resultado = 0;
                                
                                DecimalFormat formato = new DecimalFormat("#.###");

                                String entrada = boton.getText();

                                try {
                                    decimal = Double.parseDouble(entrada);
                                    if (!necesitaDecimal(decimal)) {
                                        entero = Integer.parseInt(entrada);
                                        operacion.append(entero);
                                    } else {
                                        operacion.append(formato.format(decimal));
                                    }
                                    pantallita.setText(operacion.toString());
                                    pantallita.repaint();
                                    pantallita.revalidate();
                                } catch (Exception exception) {
                                    String partes[] = operacion.toString().split(" ");

                                    if (partes.length == 3) {
                                        
                                    }
                                    if (entrada.equals("=") || hayOperador) {
                                        try {
                                            num1 = Double.parseDouble(partes[0]);
                                            simbolo = partes[1];
                                            num2 = Double.parseDouble(partes[2]);

                                            resultado = operaciones(num1, num2, simbolo);
                                            if (necesitaDecimal(resultado)) {
                                                resultado = Double.parseDouble(formato.format(resultado));
                                            } else {
                                                resultado = (int) resultado;
                                            }
                                            if (entrada.equals("=")) {
                                                operacion.setLength(0);
                                                pantallita.setText(String.valueOf(resultado));
                                                pantallita.repaint();
                                                pantallita.revalidate();
                                            } else {
                                                operacion.setLength(0);
                                                operacion.append(resultado);
                                                pantallita.setText(String.valueOf(resultado));
                                                pantallita.repaint();
                                                pantallita.revalidate();
                                            }
                                        } catch (Exception exceptiones) {
                                        }
                                    } else {
                                    switch (entrada) {
                                        case "C":
                                            hayOperador = false;
                                            operacion.setLength(0);
                                            pantallita.setText("0");
                                            pantallita.repaint();
                                            pantallita.revalidate();
                                            break;

                                        case ",":
                                            operacion.append(entrada);
                                            pantallita.setText(operacion.toString());
                                            pantallita.repaint();
                                            pantallita.revalidate();
                                            break;

                                        case "+":
                                        case "-":
                                        case "*":
                                        case "/":
                                            operacion.append(" "+entrada+" ");
                                            pantallita.setText(operacion.toString());
                                            pantallita.repaint();
                                            pantallita.revalidate();
                                            hayOperador = true;
                                            break;
                                
                                        default:
                                            break;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }

        // FUNCIONES BOTONES //

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static RoundedButton caracteristicas_botones(RoundedButton boton) {
        boton.setBorder(new EmptyBorder(2,2,2,2));
        boton.setFont(new Font("arial", Font.BOLD, 16));
        
        return boton;
    }

    public static double operaciones(double op1, double op2, String operador) {
        double result = 0;
        switch (operador) {
            case "+":
                result = (op1 + op2);
                break;
        
            case "-":
                result = (op1 - op2);
                break;
        
            case "*":
                result = (op1 * op2);  
                break;
        
            case "/":
                result = (op1 / op2);
                break;
        
            default:
                System.out.println("¡Has tenido un error por gilipollas!");
                break;
        }

        return result;
    }

    public static boolean necesitaDecimal(double numero) {
        boolean necesario = false;
        String numeroStr = String.valueOf(numero);

        String numeroSoloPuntos = numeroStr.replace(",", ".");
        String partes[] = numeroSoloPuntos.split("\\.");
        int decimales = Integer.parseInt(partes[1]);
        if (decimales != 0) {
            necesario = true;
        }
        return necesario;
    }    
}