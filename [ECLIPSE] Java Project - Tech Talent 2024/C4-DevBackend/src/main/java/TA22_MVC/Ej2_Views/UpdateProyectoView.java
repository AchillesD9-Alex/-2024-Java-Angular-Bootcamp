package TA22_MVC.Ej2_Views;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import TA22_MVC.Ej2_Controllers.ProyectoController;
import TA22_MVC.Ej2_Models.Proyecto;

public class UpdateProyectoView extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> comboBoxProyectos;
    private JTextField textFieldNombre;
    private JTextField textFieldHoras;
    private List<Proyecto> proyectos;

    /**
     * Create the frame.
     */
    public UpdateProyectoView() {
        setTitle("Actualizar Proyecto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblProyecto = new JLabel("Proyecto:");
        lblProyecto.setBounds(20, 20, 80, 20);
        contentPane.add(lblProyecto);

        comboBoxProyectos = new JComboBox<>();
        comboBoxProyectos.setBounds(120, 20, 300, 20);
        contentPane.add(comboBoxProyectos);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 80, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(120, 60, 300, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(20, 100, 80, 20);
        contentPane.add(lblHoras);

        textFieldHoras = new JTextField();
        textFieldHoras.setBounds(120, 100, 100, 20);
        contentPane.add(textFieldHoras);
        textFieldHoras.setColumns(10);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 150, 100, 30);
        contentPane.add(btnActualizar);

        // Obtener la lista de proyectos y mostrarla en el ComboBox
        proyectos = new ProyectoController().getAllProyectos();
        DefaultComboBoxModel<String> modelProyectos = new DefaultComboBoxModel<>();
        for (Proyecto proyecto : proyectos) {
            modelProyectos.addElement(proyecto.getIdProyecto() + " - " + proyecto.getNombre());
        }
        comboBoxProyectos.setModel(modelProyectos);

        // Acción para el botón de Actualizar
        btnActualizar.addActionListener(e -> {
            int selectedIndex = comboBoxProyectos.getSelectedIndex();
            if (selectedIndex >= 0) {
                Proyecto selectedProyecto = proyectos.get(selectedIndex);
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Proceder con la actualización de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    String idProyecto = selectedProyecto.getIdProyecto();
                    String nombre = textFieldNombre.getText();
                    String horasText = textFieldHoras.getText();
                    Integer horas = null;
                    if (!horasText.isEmpty()) {
                        try {
                            horas = Integer.parseInt(horasText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "El campo horas debe ser un número entero", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    // Actualizar solo los campos rellenados
                    ProyectoController.updateProyecto(idProyecto, nombre.isEmpty() ? null : nombre, horas);
                    JOptionPane.showMessageDialog(this, "Proyecto actualizado exitosamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Refrescar la lista de proyectos después de la actualización
                    proyectos = new ProyectoController().getAllProyectos();
                    modelProyectos.removeAllElements();
                    for (Proyecto proyecto : proyectos) {
                        modelProyectos.addElement(proyecto.getIdProyecto() + " - " + proyecto.getNombre());
                    }
                    comboBoxProyectos.setModel(modelProyectos);
                    comboBoxProyectos.setSelectedIndex(selectedIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un proyecto", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateProyectoView frame = new UpdateProyectoView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
