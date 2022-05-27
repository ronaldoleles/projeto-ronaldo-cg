
package exe4;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
/**
 *
 * @author RONALDO
 */
public class AlgCircParametrica extends JComponent{
    

    private int desloc; 
    
    public AlgCircParametrica() {
        desloc = 110;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        algParam(g,100);
        
    }
    
    public void algParam(Graphics g, int raio) {
        int x, y;
        for (int ang=0; ang<360; ang++) {
            System.out.println("Loops: "+ang);
            x = (int) (raio * Math.cos(Math.PI*ang/180));
            y = (int) (raio * Math.sin(Math.PI*ang/180));
            putPixel(g,x,y);
        }
    }

    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x+desloc, y+desloc, x+desloc, y+desloc);
    }
}
