package TA22_MVC.Ej2_Views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TA22_MVC.Ej2_Controllers.ProyectoController;

public class AddProyectoView extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldHoras;

    /**
     * Create the frame.
     */
    public AddProyectoView() {
        setTitle("Añadir Proyecto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(120, 20, 300, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(20, 60, 100, 20);
        contentPane.add(lblHoras);

        textFieldHoras = new JTextField();
        textFieldHoras.setBounds(120, 60, 100, 20);
        contentPane.add(textFieldHoras);
        textFieldHoras.setColumns(10);

        JButton btnAddProyecto = new JButton("Añadir Proyecto");
        btnAddProyecto.setBounds(250, 100, 170, 30);
        contentPane.add(btnAddProyecto);
        btnAddProyecto.addActionListener(e -> {
            addProyecto();
        });
    }

    // Método para añadir un proyecto
    private void addProyecto() {
        String nombre = textFieldNombre.getText();
        String horas = textFieldHoras.getText();

        // Verificar si los campos están vacíos
        if (nombre.isEmpty() || horas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al controlador para añadir el proyecto a la base de datos
        ProyectoController.addProyecto(null, nombre, Integer.parseInt(horas));
        JOptionPane.showMessageDialog(this, "Proyecto añadido exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    // Método para limpiar los campos de texto
    private void clearFields() {
        textFieldNombre.setText("");
        textFieldHoras.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddProyectoView frame = new AddProyectoView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
