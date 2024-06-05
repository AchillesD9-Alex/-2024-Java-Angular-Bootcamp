package TA22_MVC.Ej2_Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import TA22_MVC.Ej2_Controllers.AsignadoAController;
import TA22_MVC.Ej2_Models.Proyecto;

public class AddAsignadoAView extends JFrame {
    private JTextField proyectoField;
    private JTextField asignadoAField;
    private JButton submitButton;

    public AddAsignadoAView() {
        setTitle("Agregar Asignación");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ID del Proyecto:"));
        proyectoField = new JTextField(20);
        panel.add(proyectoField);

        panel.add(new JLabel("DNI del Científico:"));
        asignadoAField = new JTextField(20);
        panel.add(asignadoAField);

        submitButton = new JButton("Agregar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProyecto = proyectoField.getText();
                String DNI = asignadoAField.getText();
                AsignadoAController controller = new AsignadoAController();
                controller.addAsignadoA(idProyecto, DNI);
                JOptionPane.showMessageDialog(null, "Asignación agregada exitosamente!");
                dispose();
            }
        });

        add(panel);
    }
}
