
package exe4;

import javax.swing.JFrame;

/**
 *
 * @author RONALDO
 */
public class Janela extends JFrame{
    Janela(){
    this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        revalidate();
        this.add(new AlgCircParametrica());
}
}