package TA22_MVC.Ej2_Views;

import javax.swing.*;
import java.awt.BorderLayout;
import TA22_MVC.Ej2_Controllers.CientificoController;
import TA22_MVC.Ej2_Models.Cientifico;
import java.util.List;

public class ShowCientificoView extends JFrame {
	private JTable table;
    private JScrollPane scrollPane;

    public ShowCientificoView() {
    	setTitle("Listar Cientificos");
        setLayout(new BorderLayout());

        String[] columnNames = {"DNI", "Nombre"};
        List<Cientifico> cientificos = CientificoController.getAllCientificos();
        String[][] data = new String[cientificos.size()][2];
        
        for (int i = 0; i < cientificos.size(); i++) {
            data[i][0] = cientificos.get(i).getDNI();
            data[i][1] = cientificos.get(i).getNomApels();
        }
        
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}