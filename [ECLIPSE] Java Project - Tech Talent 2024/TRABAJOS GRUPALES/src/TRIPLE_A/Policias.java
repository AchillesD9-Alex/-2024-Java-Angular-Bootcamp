package TRIPLE_A;

import javax.swing.*;

public class Policias {
    // ATRIBUTOS
    private boolean policia;

    // CONTRUCTORES
    public Policias(JTextField textoIntroducido, String tipo) {
        switch (tipo) {
            case "letras":
                if (!policiaProducto(textoIntroducido)) {
                    this.policia = false;
                } else {
                    this.policia = true;
                }
                break;
        
            case "enteros":
                if (!policiaCantidad(textoIntroducido)) {
                    this.policia = false;
                } else {
                    this.policia = true;
                }
                break;
        
            case "decimales":
                if (!policiaPrecio(textoIntroducido)) {
                    this.policia = false;
                } else {
                    this.policia = true;
                }
                break;
        
            default:
                break;
        }
    }

    //METODOS
    public boolean getBoolean() {
        return policia;
    }

    public static boolean policiaProducto(JTextField productoTxt) {
        if (productoTxt.getText().matches("[a-zA-Z ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean policiaPrecio(JTextField precioTxt) {
        if (precioTxt.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            if (Double.parseDouble(precioTxt.getText()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean policiaCantidad(JTextField cantidadTxt) {
        if (cantidadTxt.getText().matches("[0-9]+")) {
            if (Integer.parseInt(cantidadTxt.getText()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
