package juegodelavida;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class JuegoDeLaVida extends JFrame {

    private final int[][] MOV = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
    {1, 1}, {1, 0}, {1, - 1}, {0, -1}};

    private int[][] celulas;
    private JPanel tablero;
    private int w, h, dw, dh;

    public JuegoDeLaVida() throws InterruptedException {
        setSize(1200, 800);
        w = 60;
        h = 40;
        celulas = new int[w][h];
        dw = getWidth() / w;
        dh = getHeight() / h;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                celulas[i][j] = (int) (Math.random() * 2);
            }
        }

        tablero = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                pintarTablero(g);
            }
        };

        add(tablero);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            sigTablero();
            repaint(); //repinta la ventana
            Thread.sleep(500);
        }
    }

    private void pintarTablero(Graphics g) {
        int x, y = 0;
        for (int i = 0; i < h; i++) {
            x = 0;
            for (int j = 0; j < w; j++) {
                if (celulas[j][i] == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRect(x, y, dw, dh);
                x += dw;
            }
            y += dh;
        }
    }

    //--------------------Algoritmo------------------------------
    private boolean esUno(int x, int y) {
        try {
            return celulas[x][y] == 1;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private int contarUnos(int x, int y) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            if (esUno(x + MOV[i][0], y + MOV[i][1])) {
                cont++;
            }
        }
        return cont;
    }

    private int aplicarReglas(int x, int y) {
        int cont = contarUnos(x, y);
        if (esUno(x, y) && (cont == 2 || cont == 3)) {
            return 1;
        } else if (!esUno(x, y) && cont == 3) {
            return 1;
        }
        return 0;
    }

    private void sigTablero() {
        int[][] generacion = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                generacion[i][j] = aplicarReglas(i, j);
            }
        }
        celulas = generacion;
    }

    public static void main(String[] args) throws InterruptedException {
        new JuegoDeLaVida();
    }
}
