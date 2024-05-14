package CALCULADORA;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundedButton extends JButton {

    // ATRIBUTOS
    private int arco = 0;
    private Color colorPredeterminado = new Color(ABORT);
    private Color colorBorde = new Color(ABORT);
    private Color colorHover = new Color(ABORT);

    private Color col_numeros = new Color(189, 207, 213);
    private Color col_strings = new Color(33, 184, 236);
    private Color col_cancelar = new Color(255, 59, 59);
    private Color col_resultado = new Color(34, 135, 216);

    // CONSTRUCCTORES
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    public RoundedButton(String text, int arco) {
        super(text);

        this.arco = arco;
        setContentAreaFilled(false);
    }

    public RoundedButton(String text, int arco, String tipo) {
        super(text);

        this.arco = arco;

        int rojo = 0;
        int verde = 0;
        int azul = 0;

        switch (tipo) {
            case "numeros":
                rojo = (int) (col_numeros.getRed()*0.6);
                verde = (int) (col_numeros.getGreen()*0.6);
                azul = (int) (col_numeros.getBlue()*0.6);
                colorHover = new Color(rojo, verde, azul);

                rojo = (int) (col_numeros.getRed()*0.8);
                verde = (int) (col_numeros.getGreen()*0.8);
                azul = (int) (col_numeros.getBlue()*0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_numeros.getRGB());

                break;
        
            case "cancelar":
                rojo = (int) (col_cancelar.getRed()*0.6);
                verde = (int) (col_cancelar.getGreen()*0.6);
                azul = (int) (col_cancelar.getBlue()*0.6);
                colorHover = new Color(rojo, verde, azul);
                
                rojo = (int) (col_cancelar.getRed()*0.8);
                verde = (int) (col_cancelar.getGreen()*0.8);
                azul = (int) (col_cancelar.getBlue()*0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_cancelar.getRGB());
            
                break;
        
            case "resultado":
                rojo = (int) (col_resultado.getRed()*0.6);
                verde = (int) (col_resultado.getGreen()*0.6);
                azul = (int) (col_resultado.getBlue()*0.6);
                colorHover = new Color(rojo, verde, azul);
                
                rojo = (int) (col_resultado.getRed()*0.8);
                verde = (int) (col_resultado.getGreen()*0.8);
                azul = (int) (col_resultado.getBlue()*0.8);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_resultado.getRGB());
                
                break;
        
            case "string":
                rojo = (int) (col_strings.getRed()*0.6);
                verde = (int) (col_strings.getGreen()*0.6);
                azul = (int) (col_strings.getBlue()*0.6);
                colorHover = new Color(rojo, verde, azul);
                
                rojo = (int) (col_strings.getRed()*0.6);
                verde = (int) (col_strings.getGreen()*0.6);
                azul = (int) (col_strings.getBlue()*0.6);
                colorBorde = new Color(rojo, verde, azul);

                colorPredeterminado = new Color(col_strings.getRGB());
                
                break;
        
            default:
                colorHover = new Color(Color.black.getRGB());

                break;
        }
        setContentAreaFilled(false);
    }

    // MÉTODOS
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(colorHover);
        } else {
            g.setColor(colorPredeterminado);
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(3)); // Ancho del borde de 3 píxeles
        g2.setColor(colorBorde);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arco, arco));
        g2.dispose();
    }

    // NO UTILIZADO / NO NECESARIO
    @Override
    public boolean contains(int x, int y) {
        return new Rectangle(0, 0, getWidth(), getHeight()).contains(x, y);
    }
    // NO UTILIZADO / NO NECESARIO
}