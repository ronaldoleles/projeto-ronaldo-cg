

package alganalitic;
/**
 *
 * @author Ronaldo
 */
import javax.swing.JFrame;


public class Janela extends JFrame {
    
    public Janela(){
       //codigo para rodar Algoritmo Analitic 
         //this.add(new Desenho());
         //this.setTitle("Algoritmo Analitic");
       
        this.add(new DDA());
        this.setTitle("Algoritmo DDA");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
