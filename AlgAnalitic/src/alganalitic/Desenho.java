

package alganalitic;

/**
 *
 * @author Ronaldo
 */
import javax.swing.JComponent;
import java.awt.Graphics;

public class Desenho extends JComponent {
    
    public Desenho(){
         
    }
    public void paint(Graphics g){
        //algAnalitic(g,10,10,350,350);//45°
       // algAnalitic(g,10,10,350,10);//0°
        //algAnalitic(g,10,10,10,350);//90°
        algAnalitic(g,10,10,312,125);//22°
        
    }
    
     public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    private void algAnalitic(Graphics g, int xi, int yi, int xf, int yf) {
        float m, b;
        int dy, dx, x, y;
        dy = yf - yi;
        dx = xf - xi;
        
        m = (float) dy/dx;
        
        b = (float) (yi - m * xi);
        
        for(x = xi; x<=xf; x++) {
            y = (int) (m * x + b);
            putPixel(g,x,y); 
        }
    }
}
