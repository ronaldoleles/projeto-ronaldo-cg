

package alganalitic;
/**
 *
 * @author Ronaldo
 */
import javax.swing.JFrame;

public class Janela extends JFrame {
    
    public Janela(){
        
        this.add(new Desenho());

        this.setTitle("Algoritmo Analitic");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
