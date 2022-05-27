
package exe3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Boundary extends JFrame {

    private int pixels[][];
    int log = 0;
    
    
    
    public Boundary() {
        
        pixels = new int[300][300];
        
        this.setTitle("Algoritmo Boundary-Fill");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
       // Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.red);
        criaPoligono(g);
        g.setColor(Color.blue);
        boundaryFill(g,60,60);
        g.setColor(Color.red);
        criaPoligono(g);
        
        
    }
    
    public void boundaryFill(Graphics g, int x, int y) {
         
                if (getPixel(g, x, y) == 0) {
            putPixel(g, x, y);

            boundaryFill(g, x + 1, y);
            boundaryFill(g, x - 1, y);
            boundaryFill(g, x, y + 1);
            boundaryFill(g, x, y - 1);

        }
    }
    
    public void criaPoligono(Graphics g) {
        algBres(g,50,50,113,53);
        algBres(g,113,53,107,113);
        algBres(g,107,113,53,107);
        algBres(g,53,107,50,50);
    }
    
    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr=0, yerr=0, dx, dy;
        int incX, incY;
        
        dx = xf - xi ;
        dy = yf - yi; 
        
        if (dx > 0) incX = 1;
        else if(dx==0) incX = 0;
        else incX = -1;
        
         if (dy > 0) incY = 1;
         else if(dy==0) incY = 0;
        else incY = -1;
         
         dx = Math.abs(dx);
         dy = Math.abs(dy);
         
         if (dx > dy) dist = dx;
         else dist = dy;
         
         for (int k=0; k<=dist; k++) {
             putPixel(g,xi,yi);
             xerr = xerr + dx;
             yerr = yerr + dy;
             
             if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
             if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
         }
        
    }
    
   public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
         return pixels[x-1][y-1];
    }
    
    public static void main(String[] args) {
        new Boundary();
    }
    
}
