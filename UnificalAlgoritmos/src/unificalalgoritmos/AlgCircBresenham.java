package unificalalgoritmos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Ronaldo
 */
public class AlgCircBresenham extends JComponent{

    private int deslocx;
    private int deslocy;
    int raioP;
    int corP;

    public AlgCircBresenham(int cor, int raio, int xCirc, int yCirc) {
        deslocx = xCirc;
        deslocy = yCirc;
        raioP = raio;
        corP = cor;
    }

    public void paint(Graphics g) {
           g.setColor(Color.red);
        
        if (corP == 1) {
            g.setColor(Color.red);
        }
        if (corP == 2) {
            g.setColor(Color.green);
        }
        if (corP == 3) {
            g.setColor(Color.blue);
        }
        algBres(g, raioP);

    }

    public void algBres(Graphics g, int raio) {
        int x = 0, y = raio, u = 1, v = 2 * raio - 1, e = 0;

        while (x <= y) {
            simetria(g, x, y);
            x++;
            e = e + u;
            u = u + 2;
            if (v < (2 * e)) {
                y--;
                e = e - v;
                v = v - 2;
            }
        }

    }

    private void simetria(Graphics g, int x, int y) {
        putPixel(g, x, y);
        putPixel(g, x, -y);
        putPixel(g, -x, y);
        putPixel(g, -x, -y);

        putPixel(g, y, x);
        putPixel(g, y, -x);
        putPixel(g, -y, x);
        putPixel(g, -y, -x);

    }

    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x + deslocx, y + deslocy, x + deslocx, y + deslocy);
    }
}
