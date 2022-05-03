
package algpreenchimento;

import javax.swing.JFrame;

/**
 *
 * @author RONALDO
 */
public class Janela extends JFrame{

    public Janela() {
        //roda alg de varredura
        //this.add(new AlgVarred());
        //this.setTitle("Algoritmo de varredura");
        
        //roda alg Boundary-Fill
        //this.add(new AlgBoundaryFill());
        //this.setTitle("Algoritmo de Boundary-Fill");
        
        //roda alg Preenchimento de Areas
        this.add(new AlgAreas());
        this.setTitle("Algoritmo de Preenchimento de Areas");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
