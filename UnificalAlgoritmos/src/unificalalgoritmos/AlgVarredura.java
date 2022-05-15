package unificalalgoritmos;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author RONALDO
 */
public class AlgVarredura extends JComponent {

    private int pixels[][];
    int qtdfaces;
    int px1 = 0;
    int py1 = 0;
    int px2 = 0;
    int py2 = 0;
    int miX = 0;
    int miY = 0;
    int maX = 0;
    int maY = 0;
    int aux1 = 0, aux2 = 0;
    int cont;

//    int px1 = 50, px2 = 250, px3 = 210, px4 = 200,
//            py1 = 50, py2 = 50, py3 = 200, py4 = 200;
    public AlgVarredura(int qtdFaces, int x1, int y1, int x2, int y2, int minX, int minY, int maxX, int maxY) {
        qtdfaces = qtdFaces;

        px1 = x1;
        py1 = y1;

        px2 = x2;
        py2 = y2;

//        miX = 10000;
//        miY = 10000;
//        maX = 0;
//        maY = 0;
        
        
        
            miX=minX;
        
            miY=minY;
        
            maX=maxX;
        
            maY=maxY;
        

        pixels = new int[1000][700];

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.red);
        poligono(g);
        if(miX!=1 &&miY!=1 &&maX!=1 &&maY!=1){
        
        g.setColor(Color.blue);
        System.out.println("xMin =[" + miX + "]yMin =[" + miY + "]xMax =[" + maX + "]yMax =[" + maY + "]");
        preVarred(g, miX, miY, maX, maY);
        }

        g.setColor(Color.red);
        poligono(g);
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x - 1][y - 1] = 1;
    }

    public int getPixel(Graphics g, int x, int y) {
        return pixels[x - 1][y - 1];
    }

    private void poligono(Graphics g) {

        algBres(g, px1, py1, px2, py2);

    }

    private void preVarred(Graphics g, int xmin, int ymin, int xmax, int ymax) {
        boolean liga;

        for (int y = ymin - 1; y <= ymax + 1; y++) {
            liga = false;
            for (int x = xmin - 1; x <= xmax + 1; x++) {
                if (liga) {
                    putPixel(g, x, y);
                }

                if ((getPixel(g, x + 1, y) > 0) & (getPixel(g, x + 2, y) < 1)) {
                    liga = !liga;
                }
            }
        }

    }

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {

        int xerr = 0, yerr = 0, dx, dy, incX, incY, dist;

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
