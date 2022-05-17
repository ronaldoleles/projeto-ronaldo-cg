package unificalalgoritmos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Ronaldo
 */
public class AlgCircIncremental extends JComponent {

    private int deslocx;
    private int deslocy;
    int raioP;
    int corP;

    public AlgCircIncremental(int cor, int raio, int xCirc, int yCirc) {
        deslocx = xCirc;
        deslocy = yCirc;
        raioP = raio;
        corP = cor;
    }

    @Override
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
        algIncSem(g, raioP);
    }

    public void algIncSem(Graphics g, int raio) {
        int x = 0, y = 0;
        double ang = 0.0;

        while (ang < Math.PI / 4) {
            x = (int) (raio * Math.cos(ang));
            y = (int) (raio * Math.sin(ang));
            //putPixel(g,x,y);
            simetria(g, x, y);
            ang = ang + (double) 1 / raio;
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
