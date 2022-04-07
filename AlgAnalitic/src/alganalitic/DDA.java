
package alganalitic;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Aluno1
 */
public class DDA extends JComponent {

    public void paint(Graphics g) {
        algDDA(g,10,10,350,350);//45°
        algDDA(g,10,10,350,10);//0°
        algDDA(g,10,10,10,350);//90°
        algDDA(g,10,10,312,125);//22°
        algDDA(g,10,10,125,312);//67°
        
    }
    
    private void putPixel(Graphics g, int x, int y){
     g.drawLine(x, y, x, y);
    }

    private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
       float x = xi;
       float y = yi;
       float dx = xf - xi;
       float dy = yf - yi;
       
       float steps = (dx>dy)?dx:dy;
       
       float xInc = (float)dx/steps;
       float yInc = (float)dy/steps;
       
       for(int i=0;i<steps;i++){
           x += xInc;
           y += yInc;
           
           putPixel(g,Math.round(x),Math.round(y));
       }
       
    }
    
    
}
