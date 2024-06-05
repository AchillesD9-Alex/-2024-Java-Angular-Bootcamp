package TA22_MVC.Ej2_Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import TA22_MVC.Ej2_Controllers.CientificoController;

public class AddCientificoView extends JFrame {
    private JTextField dniField;
    private JTextField nombreField;
    private JButton submitButton;

    public AddCientificoView() {
        setTitle("Crear Científico");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Disposes only this window
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("DNI:"));
        dniField = new JTextField(20);
        panel.add(dniField);

        panel.add(new JLabel("Nombre y Apellidos:"));
        nombreField = new JTextField(20);
        panel.add(nombreField);

        submitButton = new JButton("Crear");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = dniField.getText();
                String nombre = nombreField.getText();
                CientificoController controller = new CientificoController();
                controller.addCientifico(dni, nombre);
                JOptionPane.showMessageDialog(null, "Científico creado exitosamente!");
                nombreField.setText("");
            }
        });

        add(panel);
    }
}