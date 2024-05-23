package C4_DevBackend.TA20.GRUPAL_EJ09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int NUM_CARDS = ROWS * COLS;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_images";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String SQL_QUERY = "SELECT name, image FROM parejas ORDER BY RAND() LIMIT ?";
    private static ImageIcon backImage;
    private static ArrayList<ImageIcon> cardImages;
    private static JButton[] cardButtons;
    private static int firstCardIndex = -1;
    private static int secondCardIndex = -1;

    public static void main(String[] args) {
        loadCardImagesFromDatabase();

        JFrame frame = new JFrame("Juego de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ROWS, COLS));

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

    private static void loadCardImagesFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY)) {
            pstmt.setInt(1, NUM_CARDS / 2); // Selecciona la mitad de las imágenes necesarias
            ResultSet rs = pstmt.executeQuery();

            cardImages = new ArrayList<>();
            while (rs.next()) {
                byte[] imageData = rs.getBytes("image");
                String name = rs.getString("name");
                ImageIcon icon = new ImageIcon(imageData);
                icon.setDescription(name); // Establece la descripción como el nombre de la imagen
                cardImages.add(icon);
                
                // Crea una copia para el par y también establece la descripción
                ImageIcon iconCopy = new ImageIcon(imageData);
                iconCopy.setDescription(name);
                cardImages.add(iconCopy);
            }

            if (cardImages.size() < NUM_CARDS) {
                throw new RuntimeException("No hay suficientes imágenes en la base de datos para crear pares de cartas.");
            }

            Collections.shuffle(cardImages); // Baraja las cartas

            // Carga la imagen del dorso desde la base de datos
            loadBackImageFromDatabase();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadBackImageFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT image FROM dorso WHERE name = 'newDorso'");
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                byte[] imageData = rs.getBytes("image");
                backImage = new ImageIcon(imageData);
            } else {
                throw new RuntimeException("No se encontró la imagen del dorso en la base de datos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                if (cardImages.get(firstCardIndex).getDescription().equals(cardImages.get(secondCardIndex).getDescription())) {
                    // Cartas coinciden, se dejan descubiertas
                    firstCardIndex = -1;
                    secondCardIndex = -1;
                } else {
                    // Cartas no coinciden, se voltean después de un breve retraso
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
