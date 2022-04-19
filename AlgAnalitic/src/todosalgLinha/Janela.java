

package todosalgLinha;
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
       
       //codigo para rodar Algoritmo DDA
        //this.add(new DDA());
        //this.setTitle("Algoritmo DDA");
        
       //codigo para rodar Algoritmo Bres
       // this.add(new algbres());
       // this.setTitle("Algoritmo Bres");
        
       //codigo unindo analitic, DDA e bres
       this.add(new TodosLinha());
       this.setTitle("Algoritmo de Geração de Linhas - Todos");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
