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

public class MemoGame_copy {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int NUM_CARDS = ROWS * COLS;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_images"; // URL de la base de datos
    private static final String USERNAME = "root"; // Nombre de usuario de la base de datos
    private static final String PASSWORD = ""; // Contraseña de la base de datos

    private static final String SQL_QUERY = "SELECT image FROM images ORDER BY RAND() LIMIT ?"; // Consulta SQL para obtener rutas de imágenes aleatorias
    private static final String IMAGE_NAME_PATTERN = "meme%d"; // Patrón de nombre de imagen

    private static ImageIcon backImage;
    private static ArrayList<ImageIcon> cardImages;
    private static JButton[] cardButtons;
    private static int firstCardIndex = -1;
    private static int secondCardIndex = -1;

    public static void main(String[] args) {
        loadCardImagesFromDatabase(NUM_CARDS);

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

    private static void loadCardImagesFromDatabase(int numCards) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY)) {
            pstmt.setInt(1, numCards / 2);
            ResultSet rs = pstmt.executeQuery();

            cardImages = new ArrayList<>();
            while (rs.next()) {
                byte[] imageData = rs.getBytes("image");
                ImageIcon icon = new ImageIcon(imageData);
                cardImages.add(icon);
                cardImages.add(icon); // Duplica la imagen para crear un par
            }

            if (cardImages.size() < numCards) {
                throw new RuntimeException("No hay suficientes imágenes en la base de datos para crear pares de cartas.");
            }

            Collections.shuffle(cardImages); // Baraja las cartas

            // Carga la imagen del dorso
            // Suponiendo que el dorso siempre está en la misma ubicación
            backImage = new ImageIcon("C:\\Users\\ALEX\\-2024-Java-Angular-Bootcamp\\[ECLIPSE] Java Project - Tech Talent 2024\\C4-DevBackend\\DB_IMAGES\\wassa.jpeg");

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
                if (cardImages.get(firstCardIndex).equals(cardImages.get(secondCardIndex))) {
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

