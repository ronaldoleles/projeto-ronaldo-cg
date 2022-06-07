
package algrecortlinha;

import java.awt.Cursor;
import javax.swing.JFrame;

/**
 *
 * @author RONALDO
 */
public class Janela extends JFrame {
    Janela(){
         this.setTitle("Algoritmo de Recorte de Retas de Cohen-Sutherland");
       this.setSize(500,300);
       this.add("Center",new RecorteLinha());
       this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
    }
}
