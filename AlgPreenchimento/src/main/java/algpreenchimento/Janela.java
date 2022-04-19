
package algpreenchimento;

import javax.swing.JFrame;

/**
 *
 * @author RONALDO
 */
public class Janela extends JFrame{

    public Janela() {
        
        this.add(new AlgVarred());
        this.setTitle("Algoritmo de varredura");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
