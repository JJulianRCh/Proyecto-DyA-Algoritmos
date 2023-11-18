package cierre.convexo;

import java.awt.Color;
import javax.swing.JPanel;

public class Linea extends JPanel {
    
    private Punto a;
    private Punto b;
    
    public Linea(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.drawLine(a.getXY()[0] + 5, a.getXY()[1] + 5, b.getXY()[0] + 5, b.getXY()[1] + 5);
    }
}
