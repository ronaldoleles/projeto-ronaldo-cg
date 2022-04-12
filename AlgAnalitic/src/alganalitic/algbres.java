
package alganalitic;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author RONALDO
 */
public class algbres extends JComponent{
    
    @Override
    public void paint(Graphics g) {
        algBres(g,10,10,350,350);//45°
        algBres(g,10,10,350,10);//0°
        algBres(g,10,10,10,350);//90°
        algBres(g,10,10,312,125);//22°
        algBres(g,10,10,125,312);//67°
        
    }
      public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
    
    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
       int x = xi, y = yi, d=0, dx = xf-xi, dy = yf-yi, c, m, incX=1, incY=1;
       
       if(dx < 0) {incX = -1; dx = -dx;}
       if(dy < 0) {incY = -1; dy = -dy;}
       
       
       if(dy <= dx) {
           c = 2 * dx; m = 2 * dy;
           if(incX < 0) dx++;
           for(;;) {
               putPixel(g,x,y);
               if (x == xf) break;
               x += incX;
               d += m;
               if(d >= dx) {y += incY; d -= c;}

           }
       } else {
           c = 2 * dy; m = 2 * dx;
           if(incY < 0) dy++;
           for(;;) {
               putPixel(g,x,y);
               if (y == yf) break;
               y += incY;
               d += m;
               if(d >= dy) {x += incX; d -= c;}

       }
       
    }   
  }
}
