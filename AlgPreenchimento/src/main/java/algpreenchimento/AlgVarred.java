
package algpreenchimento;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author RONALDO
 */
public class AlgVarred extends JComponent{
    
    int pixels[][];
    
    public AlgVarred() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        preVarred(g,10,10,250,250);
        g.setColor(Color.red);
        poligono(g);
        
        
    }
    
    public void preVarred(Graphics g, int xmin, int ymin, int xmax, int ymax) {
        boolean liga;
        
        for (int y=ymin-1; y<=ymax+1; y++) {
            liga = false;
            for(int x=xmin-1; x<=xmax+1; x++) {
                if (liga) putPixel(g,x,y);
                if((getPixel(g,x+1,y) > 0)&(getPixel(g,x+2,y)<1)) liga = !liga;
                
                
            }
        }
    }
    
    public void poligono(Graphics g) {
        algBres(g,50,50,250,50);
        algBres(g,250,50,250,250);
        algBres(g,250,250,50,250);
        algBres(g,50,250,50,50);
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
}
