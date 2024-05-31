package TA22_MVC.Ej2_Views;
import java.awt.EventQueue;

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
        comboBoxProyectos.setBounds(120, 20, 200, 20);
        contentPane.add(comboBoxProyectos);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 80, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(120, 60, 200, 20);
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
        DefaultComboBoxModel<String> modelProyectos = new DefaultComboBoxModel<>();
        for (Proyecto proyecto : ProyectoController.getAllProyectos()) {
            modelProyectos.addElement(proyecto.getIdProyecto() + " - " + proyecto.getNombre());
        }
        comboBoxProyectos.setModel(modelProyectos);

        // Acción para el botón de Actualizar
        btnActualizar.addActionListener(e -> {
            String proyectoSeleccionado = (String) comboBoxProyectos.getSelectedItem();
            if (proyectoSeleccionado != null) {
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Proceder con la actualización de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    String idProyecto = proyectoSeleccionado.split(" - ")[0];
                    String nombre = textFieldNombre.getText();
                    int horas = Integer.parseInt(textFieldHoras.getText());
                    ProyectoController.updateProyecto(idProyecto, nombre, horas);
                    JOptionPane.showMessageDialog(this, "Proyecto actualizado exitosamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
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
