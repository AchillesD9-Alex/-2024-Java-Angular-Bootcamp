package TA22_MVC.Ej2_Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TA22_MVC.Ej2_Controllers.CientificoController;
import TA22_MVC.Ej2_Models.Cientifico;

import java.util.List;

public class ShowCientificoView extends JFrame {
    private JTextArea resultArea;
    private JButton submitButton;

    public ShowCientificoView() {
        setTitle("Leer Científico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Disposes only this window
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        submitButton = new JButton("Mostrar Científicos");
        panel.add(submitButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CientificoController controller = new CientificoController();
                List<Cientifico> cientificos = controller.getAllCientificos();
                if (cientificos != null && !cientificos.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Cientifico cientifico : cientificos) {
                        sb.append("DNI: ").append(cientifico.getDNI()).append("\tNombre: ").append(cientifico.getNomApels()).append("\n");
                    }
                    resultArea.setText(sb.toString());
                } else {
                    resultArea.setText("No hay científicos en la base de datos.");
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowCientificoView().setVisible(true);
            }
        });
    }
}