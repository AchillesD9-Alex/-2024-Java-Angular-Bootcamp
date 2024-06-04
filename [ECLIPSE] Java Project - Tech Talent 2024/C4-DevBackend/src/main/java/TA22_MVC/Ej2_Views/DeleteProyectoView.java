package TA22_MVC.Ej2_Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import TA22_MVC.Ej2_Controllers.ProyectoController;


public class DeleteProyectoView extends JFrame {
    private JComboBox<String> proyectoComboBox;
    private JButton submitButton;

    public DeleteProyectoView() {
        setTitle("Eliminar Proyecto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Disposes only this window
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ProyectoController controller = new ProyectoController();
        List<String> nombresProyectos = controller.getAllNombresProyectos(); // Obtener nombres de proyectos

        panel.add(new JLabel("Seleccione el proyecto a eliminar:"));
        proyectoComboBox = new JComboBox<>(nombresProyectos.toArray(new String[0]));
        panel.add(proyectoComboBox);

        submitButton = new JButton("Eliminar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) proyectoComboBox.getSelectedItem();
                if (nombreSeleccionado != null) {
                    ProyectoController controller = new ProyectoController();
                    controller.deleteProyecto(nombreSeleccionado);
                    JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente!");
                    dispose();  // Close this window after action
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un proyecto a eliminar.");
                }
            }
        });

        add(panel);
    }
}