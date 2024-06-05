package TA22_MVC.Ej2_Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import TA22_MVC.Ej2_Controllers.AsignadoAController;
import TA22_MVC.Ej2_Controllers.ProyectoController;
import TA22_MVC.Ej2_Models.AsignadoA;
import TA22_MVC.Ej2_Models.Proyecto;

public class UpdateAsignadoAView extends JFrame {
    private JComboBox<AsignadoA> asignadoAComboBox;
    private JComboBox<String> proyectoComboBox;
    private JButton submitButton;

    public UpdateAsignadoAView() {
        setTitle("Actualizar Asignación");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Seleccionar Asignación:"));
        asignadoAComboBox = new JComboBox<>();
        cargarAsignaciones();
        panel.add(asignadoAComboBox);

        panel.add(new JLabel("Nuevo Proyecto:"));
        proyectoComboBox = new JComboBox<>();
        cargarProyectos();
        panel.add(proyectoComboBox);

        submitButton = new JButton("Actualizar");
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsignadoA asignadoA = (AsignadoA) asignadoAComboBox.getSelectedItem();
                String idProyecto = proyectoComboBox.getSelectedItem().toString();
                AsignadoAController controller = new AsignadoAController();
                controller.updateAsignadoA(asignadoA.getIdProyecto(), asignadoA.getdni_cientifico(), idProyecto);
                JOptionPane.showMessageDialog(null, "Asignación actualizada exitosamente!");
                
            }
        });

        add(panel);
    }

    private void cargarAsignaciones() {
        AsignadoAController controller = new AsignadoAController();
        List<AsignadoA> asignaciones = controller.getAllAsignados();
        for (AsignadoA asignacion : asignaciones) {
            asignadoAComboBox.addItem(asignacion);
        }
    }

    private void cargarProyectos() {
        ProyectoController controller = new ProyectoController();
        List<Proyecto> proyectos = controller.getAllProyectos();
        for (Proyecto proyecto : proyectos) {
            proyectoComboBox.addItem(proyecto.getNombre());
        }
    }
}

