package unificalalgoritmos;

/**
 *
 * @author Ronaldo
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class TodosLinha extends JComponent {

    int oPcao = 0;
    int cOr = 0;
    int xJ1 = 0, yJ1 = 0;
    int xJ2 = 0, yJ2 = 0;

    TodosLinha(int opcao, int x1, int y1, int x2, int y2, int cor) {

        oPcao = opcao;
        cOr = cor;
        xJ1 = x1;
        yJ1 = y1;
        xJ2 = x2;
        yJ2 = y2;

    }

    @Override
    public void paint(Graphics g) {
        // System.out.println("coordenadas 1: [" + xJ1[0] + "," + yJ1[0] + "]");
        //  System.out.println("coordenadas 2: [" + xJ1[1] + "," + yJ1[1] + "]");

        if (oPcao == 1) {
            if (cOr == 1) {
                g.setColor(Color.red);
            }
            if (cOr == 2) {
                g.setColor(Color.green);
            }
            if (cOr == 3) {
                g.setColor(Color.blue);
            }
            algAnalitic(g, xJ1, yJ1, xJ2, yJ2);
        }
        if (oPcao == 2) {

            if (cOr == 1) {
                g.setColor(Color.red);
            }
            if (cOr == 2) {
                g.setColor(Color.green);
            }
            if (cOr == 3) {
                g.setColor(Color.blue);
            }
            algDDA(g, xJ1, yJ1, xJ2, yJ2);

        }
        if (oPcao == 3) {

            if (cOr == 1) {
                g.setColor(Color.red);
            }
            if (cOr == 2) {
                g.setColor(Color.green);
            }
            if (cOr == 3) {
                g.setColor(Color.blue);
            }
            algBres(g, xJ1, yJ1, xJ2, yJ2);

        }
    }

    public void algAnalitic(Graphics g, int x1, int y1, int x2, int y2) {
        float m, b, dy, dx;
        dy = y2 - y1;
        dx = x2 - x1;

        m = (float) dy / dx;
        // System.out.println(m);

        b = (float) (y1 - m * x1);
        //  System.out.println(b);

        for (int x = x1; x <= x2; x++) {
            int y = (int) (m * x + b);
            //  System.out.println(y);
            putPixel(g, x, y);
        }
    }

    private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {

        int steps;
        float x = xi, y = yi, incX, incY;
        // System.out.println("xi: " + x + "- yi: " + y);

        int dx = xf - xi;
        int dy = yf - yi;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
            incX = 1;
            incY = (float) dy / dx;
            if (dx < 0) {
                incX = -1;
            }
        } else if (Math.abs(dx) < Math.abs(dy)) {
            steps = Math.abs(dy);
            incY = 1;
            incX = (float) dx / dy;
            if (dy < 0) {
                incY = -1;
            }
        } else {
            steps = Math.abs(dy);
            incY = 1;
            incX = 1;
            if (dy < 0) {
                incY = -1;
            }
            if (dx < 0) {
                incX = -1;
            }
        }

        // System.out.println(steps + "/" + dx + "/" + dy + "/" + incX + "/" + incY);
        for (int i = 0; i < steps; i++) {
            x = x + incX;
            y = y + incY;
            putPixel(g, Math.round(x), Math.round(y));
            // System.out.println("xi: " + x + "- yi: " + y);
        }

    }

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {

        int x = xi, y = yi, d = 0, dx = xf - xi, dy = yf - yi, c, m, incX = 1, incY = 1;

        if (dx < 0) {
            incX = -1;
            dx = -dx;
        }
        if (dy < 0) {
            incY = -1;
            dy = -dy;
        }
        // System.out.println(dx + "-" + dy + "-" + incX + "-" + incY);

        if (dy <= dx) {
            c = 2 * dx;
            m = 2 * dy;
            // System.out.println(c + "-" + m);
            if (incX < 0) {
                dx++;
            }
            for (;;) {
                putPixel(g, x, y);
                if (x == xf) {
                    break;
                }
                x += incX;
                d += m;
                if (d >= dx) {
                    y += incY;
                    d -= c;
                }
                //System.out.println(x + "-" + y);
            }
        } else {
            c = 2 * dy;
            m = 2 * dx;
            // System.out.println(c + "-" + m);
            if (incY < 0) {
                dy++;
            }
            for (;;) {
                putPixel(g, x, y);
                if (y == yf) {
                    break;
                }
                y += incY;
                d += m;
                if (d >= dy) {
                    x += incX;
                    d -= c;
                }
                // System.out.println(x + "-" + y);
            }

        }
    }

    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

}
