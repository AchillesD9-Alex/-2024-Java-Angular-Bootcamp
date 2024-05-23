package C4_DevBackend.TA20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TA20_Ej04_EventPanel extends JFrame {

    private JTextArea eventTextArea;
    private JLabel eventLabel;

    public TA20_Ej04_EventPanel() {
        // Configuración del marco
        setTitle("Eventos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la etiqueta y el área de texto
        eventLabel = new JLabel("Eventos", SwingConstants.CENTER);
        eventTextArea = new JTextArea(10, 30);
        eventTextArea.setEditable(false); // El área de texto no es editable

        // Crear panel y establecer el diseño
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(eventLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        // Agregar panel al marco
        getContentPane().add(panel);

        // Agregar listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                eventTextArea.append("Ventana abierta\n");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                eventTextArea.append("Ventana cerrándose\n");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                eventTextArea.append("Ventana cerrada\n");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                eventTextArea.append("Ventana minimizada\n");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                eventTextArea.append("Ventana restaurada\n");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                eventTextArea.append("Ventana activada\n");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                eventTextArea.append("Ventana desactivada\n");
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventTextArea.append("Mouse clicado en posición (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                eventTextArea.append("Mouse presionado en posición (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventTextArea.append("Mouse liberado en posición (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eventTextArea.append("Mouse entró en el panel\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eventTextArea.append("Mouse salió del panel\n");
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TA20_Ej04_EventPanel();
            }
        });
    }
}
