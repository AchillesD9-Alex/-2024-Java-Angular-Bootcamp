package TA22_MVC.Ej2_Views;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import TA22_MVC.Ej2_Controllers.ProyectoController;
import TA22_MVC.Ej2_Models.Proyecto;

public class ShowProyectosView extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public ShowProyectosView() {
        setTitle("Listar Proyectos");
        setLayout(new BorderLayout());

        String[] columnNames = {"ID Proyecto", "Nombre", "Horas"};
        List<Proyecto> proyectos = ProyectoController.getAllProyectos();
        String[][] data = new String[proyectos.size()][3];
        
        for (int i = 0; i < proyectos.size(); i++) {
            data[i][0] = proyectos.get(i).getIdProyecto();
            data[i][1] = proyectos.get(i).getNombre();
            data[i][2] = String.valueOf(proyectos.get(i).getHoras());
        }
        
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}