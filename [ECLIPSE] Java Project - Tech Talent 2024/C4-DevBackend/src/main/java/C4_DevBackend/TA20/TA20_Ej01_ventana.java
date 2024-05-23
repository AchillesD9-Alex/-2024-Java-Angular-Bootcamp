package C4_DevBackend.TA20;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class TA20_Ej01_ventana {

    public static void main(String[] args) {
        // Crear y configurar el marco de la ventana principal
        JFrame frame = new JFrame("MegaVentana de la Muerte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        frame.setSize(340, 300); // Ajustar el tamaño para acomodar la imagen

        // Crear una etiqueta con texto centrado
        JLabel label = new JLabel("¡WASSAAAAAAA!", SwingConstants.CENTER);

        // Cargar la imagen desde la base de datos
        ImageIcon imageIcon = loadImageFromDatabase();
        JLabel imageLabel = new JLabel(imageIcon);

        // Crear un panel con BorderLayout para organizar los componentes
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH); // Añadir la etiqueta en la parte superior
        panel.add(imageLabel, BorderLayout.CENTER); // Añadir la imagen en el centro

        // Añadir el panel al marco
        frame.getContentPane().add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private static ImageIcon loadImageFromDatabase() {
        ImageIcon imageIcon = null;

        // Información de la base de datos
        String url = "jdbc:mysql://localhost:3306/DB_IMAGES";
        String username = "root";
        String password = "";

        // Consulta SQL para obtener la imagen
        String query = "SELECT image FROM wassa WHERE name = 'wassa'";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("image");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                imageIcon = new ImageIcon(imageBytes);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return imageIcon;
    }
}
