package TA10;

import javax.swing.JOptionPane;

public class TA10Ej04_Calculo {

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            try {
                // Mostrar opciones al usuario
                String[] options = {"Suma", "Resta", "Producto", "División", "Potencia", "Raíz Cuadrada", "Raíz Cúbica"};
                String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la operación que desea realizar:", "Seleccionar Operación", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (seleccion == null) {
                    // Si el usuario cancela la operación
                    continuar = false;
                    continue;
                }

                double numero1 = 0, numero2 = 0;

                // Obtener números del usuario según la operación seleccionada
                if (!seleccion.equals("Raíz Cuadrada") && !seleccion.equals("Raíz Cúbica")) {
                    numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                    numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                } else {
                    numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el número:"));
                }

                double resultado = 0;

                // Realizar la operación seleccionada
                switch (seleccion) {
                    case "Suma":
                        resultado = numero1 + numero2;
                        break;
                    case "Resta":
                        resultado = numero1 - numero2;
                        break;
                    case "Producto":
                        resultado = numero1 * numero2;
                        break;
                    case "División":
                        if (numero2 == 0) {
                            throw new ArithmeticException("No se puede dividir por cero");
                        }
                        resultado = numero1 / numero2;
                        break;
                    case "Potencia":
                        resultado = Math.pow(numero1, numero2);
                        break;
                    case "Raíz Cuadrada":
                        if (numero1 < 0) {
                            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
                        }
                        resultado = Math.sqrt(numero1);
                        break;
                    case "Raíz Cúbica":
                        resultado = Math.cbrt(numero1);
                        break;
                }

                // Mostrar el resultado al usuario
                JOptionPane.showMessageDialog(null, "El resultado de la operación " + seleccion + " es: " + resultado);

            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de Cálculo", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor ingrese un número válido", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }

            // Preguntar si el usuario quiere realizar otra operación
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) {
                continuar = false;
            }
        }
    }
}
