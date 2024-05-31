package TA22_MVC.Ej2_Views;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import TA22_MVC.Ej2_Controllers.ProyectoController;
import TA22_MVC.Ej2_Models.Proyecto;

public class DeleteProyectoView extends JFrame {

    private JPanel contentPane;
    private JList<String> listProyectos;

    /**
     * Create the frame.
     */
    public DeleteProyectoView() {
        setTitle("Eliminar Proyecto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblProyectos = new JLabel("Proyectos:");
        lblProyectos.setBounds(20, 20, 100, 20);
        contentPane.add(lblProyectos);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 50, 200, 150);
        contentPane.add(scrollPane);

        listProyectos = new JList<>();
        scrollPane.setViewportView(listProyectos);

        JButton btnEliminarSeleccionados = new JButton("Eliminar Proyectos Seleccionados");
        btnEliminarSeleccionados.setBounds(250, 50, 170, 30);
        contentPane.add(btnEliminarSeleccionados);

        // Obtener la lista de proyectos y mostrarla en la lista
        DefaultListModel<String> modelProyectos = new DefaultListModel<>();
        for (Proyecto proyecto : ProyectoController.getAllProyectos()) {
            modelProyectos.addElement(proyecto.getIdProyecto() + " - " + proyecto.getNombre());
        }
        listProyectos.setModel(modelProyectos);

        // Acción para el botón de Eliminar Proyectos Seleccionados
        btnEliminarSeleccionados.addActionListener(e -> {
            int[] indicesSeleccionados = listProyectos.getSelectedIndices();
            if (indicesSeleccionados.length == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un proyecto a eliminar", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Proceder con la eliminación de los proyectos seleccionados?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Eliminar los proyectos seleccionados
                    for (int indice : indicesSeleccionados) {
                        String proyectoSeleccionado = listProyectos.getModel().getElementAt(indice);
                        String idProyecto = proyectoSeleccionado.split(" - ")[0];
                        ProyectoController.deleteProyecto(idProyecto);
                    }
                    // Actualizar la lista de proyectos después de eliminar
                    modelProyectos.removeAllElements();
                    for (Proyecto proyecto : ProyectoController.getAllProyectos()) {
                        modelProyectos.addElement(proyecto.getIdProyecto() + " - " + proyecto.getNombre());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteProyectoView frame = new DeleteProyectoView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
