package cierre.convexo;

import javax.swing.JPanel;

public class Punto extends JPanel {
    
    private int x;
    private int y;
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[] getXY() {
        int[] xy = {x, y};
        return xy;
    }
    
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 10, 10);
    }
    
    @Override 
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
