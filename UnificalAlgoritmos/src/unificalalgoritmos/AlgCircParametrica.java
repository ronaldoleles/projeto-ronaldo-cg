package unificalalgoritmos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Ronaldo
 */
public class AlgCircParametrica extends JComponent {

    private int deslocx;
    private int deslocy;
    int raioP;
    int corP;

    public AlgCircParametrica(int cor, int raio, int xCirc, int yCirc) {
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
        algParam(g, raioP);

    }

    public void algParam(Graphics g, int raio) {
        int x, y;
        for (int ang = 0; ang < 360; ang++) {
            x = (int) (raio * Math.cos(Math.PI * ang / 180));
            y = (int) (raio * Math.sin(Math.PI * ang / 180));
            putPixel(g, x, y);
        }
    }

    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x + deslocx, y + deslocy, x + deslocx, y + deslocy);
    }
}
