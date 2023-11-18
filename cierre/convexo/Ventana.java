package cierre.convexo;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    NubePuntos nube = new NubePuntos();
    
    public Ventana() {
        
        add(nube);
        
        setTitle("Cierre Convexo");
        setSize(800,600);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Ventana();
    }
}
