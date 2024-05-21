package C4_DevBackend.TA20.GRUPAL_EJ09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryGame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int NUM_CARDS = ROWS * COLS;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ROWS, COLS));

        // Array para almacenar las imágenes de las cartas
        ImageIcon[] cardImages = loadCardImages(); // Método para cargar las imágenes desde archivos

        // Crear JLabels para representar las cartas
        JLabel[] cards = new JLabel[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            cards[i] = new JLabel(cardImages[i]);
            cards[i].setPreferredSize(new Dimension(100, 100)); // Establecer tamaño deseado
            panel.add(cards[i]);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para cargar imágenes de las cartas desde archivos
    private static ImageIcon[] loadCardImages() {
        ImageIcon[] cardImages = new ImageIcon[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            String imagePath = "path_to_your_image_folder/image" + (i + 1) + ".jpg"; // Ruta de las imágenes
            cardImages[i] = new ImageIcon(imagePath); // Cargar la imagen desde el archivo
        }
        return cardImages;
    }
}
