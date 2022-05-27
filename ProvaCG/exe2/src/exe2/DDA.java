
package exe2;

import java.awt.Graphics;
import javax.swing.JFrame;

public class DDA extends JFrame {

    public DDA() {
        
        
        this.setTitle("Algoritmo DDA");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
//        algDDA(g,25+1,25+10,312+1,125+10); 
//         algDDA(g,25+1,25+10,350+1,350+10);
//         algDDA(g,25+1,25+10,350+1,10+10); 
//         algDDA(g,25+1,25+10,10+1,350+10); 
//         algDDA(g,25+1,25+10,125+1,312+10);
algDDA(g,25,25,312,125); 
         algDDA(g,25,25,350,350);
         algDDA(g,25,25,350,10); 
         algDDA(g,25,25,10,350); 
         algDDA(g,25,25,125,312);
    }
 
    private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
        
        float x=xi, y=yi;
        int dx = Math.abs(xf - xi);
        int dy = Math.abs(yf - yi);
        
        System.out.println("dx e dy= "+dx+"-"+dy);
        
        int steps = (dx > dy) ? dx : dy;
        
        System.out.println("steps = "+steps);
        
        float xInc = (float) dx / steps;
        float yInc = (float) dy / steps;
        
        System.out.println("incs= "+xInc+"-"+yInc);
        
        for(int i=0; i<steps; i++) {
            x += xInc;
            y += yInc;
            putPixel(g,Math.round(x),Math.round(y));
            
        }
        
    }
    
    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x+10, y+10, x+10, y+10);
    }
    
    public static void main(String[] args) {
       new DDA();
    }
    
}