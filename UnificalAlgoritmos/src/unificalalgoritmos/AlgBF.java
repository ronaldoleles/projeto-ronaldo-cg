package unificalalgoritmos;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 *
 * @author Ronaldo
 */
public class AlgBF extends JComponent {

//    private int px1 = 25, px2 = 125, px3 = 110, px4 = 100,
//            py1 = 25, py2 = 25, py3 = 100, py4 = 100;
    private int pixels[][];
    int px1 = 0;
    int py1 = 0;
    int px2 = 0;
    int py2 = 0;
    int miX;
    int miY;
    int maX;
    int maY;

    public AlgBF(int x1, int y1, int x2, int y2, int minX, int minY, int maxX, int maxY) {
        
        px1 = x1;
        py1 = y1;
        px2 = x2;
        py2 = y2;
        
        miX = minX;
        miY = minY;
        maX = maxX;
        maY = maxY;
        pixels = new int[1000][700];
       
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.red);
        poligono(g);
        if (miX != 1 && miY != 1 && maX != 1 && maY != 1) {
            g.setColor(Color.blue);
           
          //  preBF(g, maX, maY);
        }
    }

    public void poligono(Graphics g) {
        repaint();
        algBres(g, px1, py1, px2, py2);
        // algBres(g, px2, py2, px3, py3);
        //  algBres(g, px3, py3, px4, py4);
        // algBres(g, px4, py4, px1, py1);
    }

    public void preBF(Graphics g, int x, int y) {
        if (getPixel(g, x, y) == 0) {
            putPixel(g, x, y);

            preBF(g, x + 1, y);
            preBF(g, x - 1, y);
            preBF(g, x, y + 1);
            preBF(g, x, y - 1);

        }
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x - 1][y - 1] = 1;
    }

    public int getPixel(Graphics g, int x, int y) {
        return pixels[x - 1][y - 1];
    }

    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr = 0, yerr = 0, dx, dy;
        int incX, incY;

        dx = xf - xi;
        dy = yf - yi;

        if (dx > 0) {
            incX = 1;
        } else if (dx == 0) {
            incX = 0;
        } else {
            incX = -1;
        }

        if (dy > 0) {
            incY = 1;
        } else if (dy == 0) {
            incY = 0;
        } else {
            incY = -1;
        }

        dx = Math.abs(dx);
        dy = Math.abs(dy);

        if (dx > dy) {
            dist = dx;
        } else {
            dist = dy;
        }

        for (int k = 0; k <= dist; k++) {
            putPixel(g, xi, yi);
            xerr = xerr + dx;
            yerr = yerr + dy;

            if (xerr > dist) {
                xerr = xerr - dist;
                xi = xi + incX;
            }
            if (yerr > dist) {
                yerr = yerr - dist;
                yi = yi + incY;
            }
        }

    }
}
