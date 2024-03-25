package TRIPLE_A;

import javax.swing.JOptionPane;

public class Prueba {
    public static void main(String[] args) {
        System.out.println("\"escapadas\"");
        // StockArticulosPrueba articulos1 = new StockArticulosPrueba();
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad articulos"));
        for (int i = 1; i <= cant; i++) {
            // articulos1.agregarArticulo();
            StockArticulosPrueba.agregarArticulo();
        }
    }
}