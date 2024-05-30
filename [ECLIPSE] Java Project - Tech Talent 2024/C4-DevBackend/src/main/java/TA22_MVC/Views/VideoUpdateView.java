package TA22_MVC.Views;

import javax.swing.*;

import TA22_MVC.Controllers.VideoController;
import TA22_MVC.Models.Video;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VideoUpdateView extends JFrame {
	private VideoController videoController;
	private JComboBox<Integer> idComboBox;
	private JTextField titleField;
	private JTextField directorField;
	private JTextField cliIdField;

	public VideoUpdateView() {
		videoController = new VideoController();
		setTitle("Actualizar Video");
		setSize(400, 300);
		setLayout(new GridLayout(0, 2));

		idComboBox = new JComboBox<>();
		titleField = new JTextField();
		directorField = new JTextField();
		cliIdField = new JTextField();

		// Llenar el JComboBox con los IDs de los videos existentes
        List<Integer> videoIds = videoController.getAllVideoIds();
        for (Integer id : videoIds) {
            idComboBox.addItem(id);
        }
		
		idComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedId = (int) idComboBox.getSelectedItem();
				Video video = videoController.getVideoById(selectedId);
				if (video != null) {
					titleField.setText(video.getTitle());
					directorField.setText(video.getDirector());
					cliIdField.setText(String.valueOf(video.getCli_id()));
				}
			}
		});

		add(new JLabel("ID:"));
		add(idComboBox);
		add(new JLabel("Título:"));
		add(titleField);
		add(new JLabel("Director:"));
		add(directorField);
		add(new JLabel("ID Cliente:"));
		add(cliIdField);

		JButton updateButton = new JButton("Actualizar");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) idComboBox.getSelectedItem();
				Video video = videoController.getVideoById(id);
				if (video != null) {
					video.setTitle(titleField.getText());
					video.setDirector(directorField.getText());
					video.setCli_id(Integer.parseInt(cliIdField.getText()));
					videoController.updateVideo(video);
					JOptionPane.showMessageDialog(null, "Video actualizado exitosamente.");
				} else {
					JOptionPane.showMessageDialog(null, "Video no encontrado.");
				}
			}
		});
		add(updateButton);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new VideoUpdateView();
	}
}