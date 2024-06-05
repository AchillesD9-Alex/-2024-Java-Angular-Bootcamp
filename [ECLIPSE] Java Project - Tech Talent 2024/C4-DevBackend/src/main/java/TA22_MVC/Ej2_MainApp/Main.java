package TA22_MVC.Ej2_MainApp;


import TA22_MVC.Ej2_Views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Gestión de Científicos, Proyectos y Asignaciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        String[] tables = {"Científicos", "Proyectos", "Asignado_a"};
        JComboBox<String> tableSelector = new JComboBox<>(tables);
        panel.add(tableSelector);

        JButton btnCRUD = new JButton("Seleccionar acción");
        btnCRUD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTable = (String) tableSelector.getSelectedItem();
                if (selectedTable != null) {
                    mostrarMenuCRUD(selectedTable);
                }
            }
        });
        panel.add(btnCRUD);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnSalir);

        add(panel);
    }

    private void mostrarMenuCRUD(String table) {
        String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Volver"};
        int choice = JOptionPane.showOptionDialog(this, "Seleccione una opción para " + table + ":", "Menú " + table,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (table) {
            case "Científicos":
                handleCientificos(choice);
                break;
            case "Proyectos":
                handleProyectos(choice);
                break;
            case "Asignado_a":
                handleAsignados(choice);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleCientificos(int choice) {
        switch (choice) {
            case 0:
                new AddCientificoView().setVisible(true);
                break;
            case 1:
                new ShowCientificoView().setVisible(true);
                break;
            case 2:
                new UpdateCientificoView().setVisible(true);
                break;
            case 3:
                new DeleteCientificoView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleProyectos(int choice) {
        switch (choice) {
            case 0:
                new AddProyectoView().setVisible(true);
                break;
            case 1:
                new ShowProyectosView().setVisible(true);
                break;
            case 2:
                new UpdateProyectoView().setVisible(true);
                break;
            case 3:
                new DeleteProyectoView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    private void handleAsignados(int choice) {
        switch (choice) {
            case 0:
                new AddAsignadoAView().setVisible(true);
                break;
            case 1:
                new ShowAsignadoAView().setVisible(true);
                break;
            case 2:
                new UpdateAsignadoAView().setVisible(true);
                break;
            case 3:
                new DeleteAsignadoAView().setVisible(true);
                break;
            case 4:
                break; // Volver
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}

