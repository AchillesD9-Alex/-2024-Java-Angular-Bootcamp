package TA22_MVC.Ej1_Views;

import javax.swing.*;

import TA22_MVC.Ej1_Controllers.VideoController;
import TA22_MVC.Ej1_Models.Video;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VideoDeleteView extends JFrame {
    private VideoController videoController;

    public VideoDeleteView() {
        videoController = new VideoController();
        setTitle("Eliminar Video");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2));

        // Crear y poblar el JComboBox con los videos existentes
        JComboBox<Video> videoComboBox = new JComboBox<>();
        List<Video> videos = videoController.getAllVideos();
        for (Video video : videos) {
            videoComboBox.addItem(video);
        }

        // Añadir el JComboBox al panel
        add(new JLabel("Seleccionar Video:"));
        add(videoComboBox);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Video selectedVideo = (Video) videoComboBox.getSelectedItem();
                if (selectedVideo == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un video para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                videoController.deleteVideo(selectedVideo.getId());
                JOptionPane.showMessageDialog(null, "Video eliminado exitosamente.");
                videoComboBox.removeItem(selectedVideo);  // Elimina el video eliminado del combo box
            }
        });
        add(deleteButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VideoDeleteView();
    }
}

