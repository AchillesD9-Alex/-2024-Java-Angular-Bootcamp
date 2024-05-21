package C4_DevBackend.TA20.GRUPAL_EJ09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int NUM_CARDS = ROWS * COLS;
    private static final String IMAGE_FOLDER_PATH = "C:/Users/ALEX/-2024-Java-Angular-Bootcamp/[ECLIPSE] Java Project - Tech Talent 2024/C4-DevBackend/images";
    private static final String BACK_IMAGE_NAME = "dorso.jpg";  // Nombre del archivo del dorso

    private static ImageIcon backImage;
    private static ArrayList<ImageIcon> cardImages;
    private static JButton[] cardButtons;
    private static int firstCardIndex = -1;
    private static int secondCardIndex = -1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ROWS, COLS));

        loadCardImages();

        cardButtons = new JButton[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            cardButtons[i] = new JButton();
            cardButtons[i].setIcon(backImage);
            cardButtons[i].addActionListener(new CardClickListener(i));
            panel.add(cardButtons[i]);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void loadCardImages() {
        cardImages = new ArrayList<>();
        File folder = new File(IMAGE_FOLDER_PATH);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            throw new RuntimeException("No se encontraron imágenes en la carpeta especificada.");
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.equals(BACK_IMAGE_NAME)) {
                    backImage = new ImageIcon(file.getAbsolutePath());
                } else {
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    cardImages.add(icon);
                }
            }
        }

        if (cardImages.size() * 2 < NUM_CARDS) {
            throw new RuntimeException("No hay suficientes imágenes para crear pares de cartas.");
        }

        // Duplicar imágenes para crear pares
        ArrayList<ImageIcon> pairs = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS / 2; i++) {
            pairs.add(cardImages.get(i));
            pairs.add(cardImages.get(i));
        }

        // Barajar las cartas
        Collections.shuffle(pairs);

        // Reasignar la lista barajada a cardImages
        cardImages = pairs;
    }

    private static class CardClickListener implements ActionListener {
        private int index;

        public CardClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (firstCardIndex == -1) {
                firstCardIndex = index;
                cardButtons[index].setIcon(cardImages.get(index));
            } else if (secondCardIndex == -1 && index != firstCardIndex) {
                secondCardIndex = index;
                cardButtons[index].setIcon(cardImages.get(index));

                // Verificar si las cartas coinciden
                if (cardImages.get(firstCardIndex).equals(cardImages.get(secondCardIndex))) {
                    firstCardIndex = -1;
                    secondCardIndex = -1;
                } else {
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardButtons[firstCardIndex].setIcon(backImage);
                            cardButtons[secondCardIndex].setIcon(backImage);
                            firstCardIndex = -1;
                            secondCardIndex = -1;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}

