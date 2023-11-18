package cierre.convexo;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.awt.Graphics;

public final class NubePuntos extends JPanel {

    private ArrayList<Punto> nube;
    Punto Mx, mx, My, my;

    public NubePuntos() {
        setBackground(Color.black);
        Random r = new Random();
        nube = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            nube.add(new Punto(r.nextInt(500) + 50, r.nextInt(500) + 50));
        }
        mx = Mx = My = my = nube.get(0);
        for (int i = 1; i < nube.size(); i++) {
            if (nube.get(i).getXY()[0] < mx.getXY()[0]) {
                mx = nube.get(i);
            }
            if (nube.get(i).getXY()[0] > Mx.getXY()[0]) {
                Mx = nube.get(i);
            }
            if (nube.get(i).getXY()[1] < my.getXY()[1]) {
                my = nube.get(i);
            }
            if (nube.get(i).getXY()[1] > My.getXY()[1]) {
                My = nube.get(i);
            }
        }
        //Ordenamos la lista de los puntos 
        Collections.sort(nube, new Comparator<Punto>() {
            @Override
            public int compare(Punto p1, Punto p2) {
                int comparacionX = Integer.compare(p1.getXY()[0], p2.getXY()[0]);
                if (comparacionX != 0) {
                    return comparacionX;
                }

                // Si las coordenadas x son iguales, comparar por coordenada y
                return Integer.compare(p1.getXY()[1], p2.getXY()[1]);
            }
        
        });
    }
    
    private void dividirNube(Graphics g, ArrayList<Punto> nube) {
        int mitad = nube.size() / 2;
        int div = (nube.get(mitad - 1).getXY()[0] + nube.get(mitad).getXY()[0]) / 2;
        Punto p1 = new Punto(div, 50);
        Punto p2 = new Punto(div, 550);
        Linea l = new Linea(p1, p2);
        l.paint(g);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        for (Punto aux : nube) {
            aux.paint(g);
        }
        g.setColor(Color.red);
        Mx.paint(g);
        mx.paint(g);
        My.paint(g);
        my.paint(g);
        dividirNube(g, nube);
    }
    
}
