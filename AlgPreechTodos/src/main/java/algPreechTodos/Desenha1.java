
package algPreechTodos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JComponent;

/**
 *
 * @author RONALDO
 */
public class Desenha1 extends JComponent{
    
         private int px1=50, px2=250, px3=210, px4=200,
                    py1=50, py2=50, py3=200, py4=200;  
    
    private Polygon p;
   
    public Desenha1() {
        p = new Polygon();
        
        p.addPoint(px1, py1);
        p.addPoint(px2, py2);
        p.addPoint(px3, py3);
        p.addPoint(px4, py4);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        
        g.fillPolygon(p);
        g.setColor(Color.blue);
        g.drawPolygon(p);
        
    }
}
