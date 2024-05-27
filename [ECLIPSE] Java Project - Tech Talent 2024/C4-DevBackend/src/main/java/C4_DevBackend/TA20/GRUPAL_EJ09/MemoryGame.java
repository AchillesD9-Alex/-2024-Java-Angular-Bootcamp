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
    private static int moveCount = 0;
    private static int pairsFound = 0; // Contador de pares encontrados
    private static JLabel moveCounterLabel;

    public static void main(String[] args) {
        loadCardImagesFromDatabase();

        JFrame frame = new JFrame("Juego de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ROWS, COLS));

        cardButtons = new JButton[NUM_CARDS];
        Dimension buttonSize = new Dimension(frame.getWidth() / COLS, frame.getHeight() / ROWS);

        for (int i = 0; i < NUM_CARDS; i++) {
            cardButtons[i] = new JButton();
            cardButtons[i].setIcon(scaleImageIcon(backImage, buttonSize));
            cardButtons[i].setPreferredSize(buttonSize);
            cardButtons[i].setBorderPainted(false);
            cardButtons[i].setContentAreaFilled(false);
            cardButtons[i].addActionListener(new CardClickListener(i));
            panel.add(cardButtons[i]);
        }

        // Crear y añadir el contador de movimientos
        moveCounterLabel = new JLabel("Movimientos: 0");
        JPanel topPanel = new JPanel();
        topPanel.add(moveCounterLabel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear el menú "Juego"
        JMenu gameMenu = new JMenu("Juego");

        // Crear y añadir el ítem "Reiniciar"
        JMenuItem restartItem = new JMenuItem("Reiniciar");
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        gameMenu.add(restartItem);

        // Crear y añadir el ítem "Finalizar"
        JMenuItem exitItem = new JMenuItem("Finalizar");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        gameMenu.add(exitItem);

        // Añadir el menú "Juego" a la barra de menú
        menuBar.add(gameMenu);

        // Crear el menú "Información"
        JMenu infoMenu = new JMenu("Información");

        // Crear y añadir el ítem "Acerca de"
        JMenuItem aboutItem = new JMenuItem("Memory Game Espacial, creado por Jose, Alex y Aurora, los mejores!");
        infoMenu.add(aboutItem);

        // Añadir el menú "Información" a la barra de menú
        menuBar.add(infoMenu);

        // Establecer la barra de menú en el frame
        frame.setJMenuBar(menuBar);

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

    private static ImageIcon scaleImageIcon(ImageIcon icon, Dimension size) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
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
                cardButtons[index].setIcon(scaleImageIcon(cardImages.get(index), cardButtons[index].getSize()));
            } else if (secondCardIndex == -1 && index != firstCardIndex) {
                secondCardIndex = index;
                cardButtons[index].setIcon(scaleImageIcon(cardImages.get(index), cardButtons[index].getSize()));

                // Incrementar y actualizar el contador de movimientos
                moveCount++;
                moveCounterLabel.setText("Movimientos: " + moveCount);

                // Verificar si las cartas coinciden
                if (cardImages.get(firstCardIndex).getDescription().equals(cardImages.get(secondCardIndex).getDescription())) {
                    // Cartas coinciden, se dejan descubiertas
                    pairsFound++;
                    firstCardIndex = -1;
                    secondCardIndex = -1;
                    checkGameWon();
                } else {
                    // Cartas no coinciden, se voltean después de un breve retraso
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardButtons[firstCardIndex].setIcon(scaleImageIcon(backImage, cardButtons[firstCardIndex].getSize()));
                            cardButtons[secondCardIndex].setIcon(scaleImageIcon(backImage, cardButtons[secondCardIndex].getSize()));
                            firstCardIndex = -1;
                            secondCardIndex = -1;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }

        private void checkGameWon() {
            if (pairsFound == NUM_CARDS / 2) {
                JOptionPane.showMessageDialog(null, "¡¡FELICIDADES, HAS GANADO!!");
            }
        }
    }

    private static void restartGame() {
        // Reiniciar las variables del juego
        firstCardIndex = -1;
        secondCardIndex = -1;
        moveCount = 0;
        pairsFound = 0; // Reiniciar el contador de pares encontrados
        moveCounterLabel.setText("Movimientos: 0");

        // Barajar las cartas nuevamente
        Collections.shuffle(cardImages);

        // Volver a poner todas las cartas boca abajo
        Dimension buttonSize = new Dimension(cardButtons[0].getWidth(), cardButtons[0].getHeight());
        for (int i = 0; i < NUM_CARDS; i++) {
            cardButtons[i].setIcon(scaleImageIcon(backImage, buttonSize));
        }
    }
}