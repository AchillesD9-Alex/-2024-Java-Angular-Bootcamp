package TA22_MVC.Ej2_Views;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import TA22_MVC.Ej2_Controllers.ProyectoController;
import TA22_MVC.Ej2_Models.Proyecto;

public class ShowProyectosView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldIdProyecto;
    private JTextField textFieldNombre;
    private JTextField textFieldHoras;

    /**
     * Create the frame.
     */
    public ShowProyectosView() {
        setTitle("Mostrar Proyectos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblIdProyecto = new JLabel("ID Proyecto:");
        lblIdProyecto.setBounds(10, 10, 100, 20);
        contentPane.add(lblIdProyecto);

        textFieldIdProyecto = new JTextField();
        textFieldIdProyecto.setBounds(120, 10, 100, 20);
        contentPane.add(textFieldIdProyecto);
        textFieldIdProyecto.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(230, 10, 100, 20);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(320, 10, 200, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(530, 10, 100, 20);
        contentPane.add(lblHoras);

        textFieldHoras = new JTextField();
        textFieldHoras.setBounds(590, 10, 100, 20);
        contentPane.add(textFieldHoras);
        textFieldHoras.setColumns(10);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(700, 10, 80, 20);
        contentPane.add(btnFiltrar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 770, 510);
        contentPane.add(scrollPane);

        // Tabla para mostrar proyectos
        table = new JTable();
        scrollPane.setViewportView(table);
        DefaultTableModel model = new DefaultTableModel(new Object[][] {},
                new String[] { "ID Proyecto", "Nombre", "Horas" });
        table.setModel(model);

        // Filtrar los proyectos según los criterios ingresados
        btnFiltrar.addActionListener(e -> {
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            table.setRowSorter(sorter);
            RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(
                    RowFilter.regexFilter("(?i)" + textFieldIdProyecto.getText(), 0),
                    RowFilter.regexFilter("(?i)" + textFieldNombre.getText(), 1),
                    RowFilter.regexFilter("(?i)" + textFieldHoras.getText(), 2));
            sorter.setRowFilter(rf);
        });

        // Cargar todos los proyectos al abrir la vista
        loadProyectos();
    }

    // Método para cargar todos los proyectos en la tabla
    private void loadProyectos() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los proyectos
        for (Proyecto proyecto : ProyectoController.getAllProyectos()) {
            model.addRow(new Object[] { proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getHoras() });
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowProyectosView frame = new ShowProyectosView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
