package TA22_MVC.Views;

import javax.swing.*;

import TA22_MVC.Controllers.VideoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoDeleteView extends JFrame {
    private VideoController videoController;

    public VideoDeleteView() {
        videoController = new VideoController();
        setTitle("Eliminar Video");
        setSize(400, 150);
        setLayout(new GridLayout(0, 2));

        JTextField idField = new JTextField();
        add(new JLabel("ID:"));
        add(idField);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                videoController.deleteVideo(id);
                JOptionPane.showMessageDialog(null, "Video eliminado exitosamente.");
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

