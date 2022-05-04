
package unificaalgoritmos;

/**
 *
 * @author RONALDO
 */
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Janela extends JFrame {
    
    
    public Janela(){
        //cria barra de menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        //cria as opções na barra de menu
        JMenu primitivasMenu = new JMenu("Primitivas");
        JMenu coresMenu = new JMenu("Cores");
        menuBar.add(primitivasMenu);
        menuBar.add(coresMenu);
        
        //cria itens em primitivas e cores
        JMenu linhas = new JMenu("Linhas");
        JMenu poligonos = new JMenu("Poligonos");
        JMenu circulos = new JMenu("Circulos");
        primitivasMenu.add(linhas);
        primitivasMenu.add(poligonos);
        primitivasMenu.add(circulos);
        JMenuItem vermelho= new JMenuItem("Vermelho");
        JMenuItem azul = new JMenuItem("Azul");
        JMenuItem verde = new JMenuItem("Verde");
        coresMenu.add(vermelho);
        coresMenu.add(verde);
        coresMenu.add(azul);
        
        JMenuItem analitico = new JMenuItem("Analitico");
        linhas.add(analitico);
        JMenuItem dda = new JMenuItem("DDA");
        linhas.add(dda);
        JMenuItem bresenham = new JMenuItem("Bresenham");
        linhas.add(bresenham);
        
        JMenuItem varredura = new JMenuItem("Varredura");
        poligonos.add(varredura);
        JMenuItem boundaryFill = new JMenuItem("BoundaryFill");
        poligonos.add(boundaryFill);
        JMenuItem analiseGeometrica = new JMenuItem("Analise Geométrica");
        poligonos.add(analiseGeometrica);
        
        JMenuItem parametrica = new JMenuItem("Parametrica");
        circulos.add(parametrica);
        JMenuItem incremental = new JMenuItem("Incremental com simetria");
        circulos.add(incremental);
        JMenuItem bresenhamCirc = new JMenuItem("Bresenham");
        circulos.add(bresenhamCirc);
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
       //this.add(new TodosLinha());
      // this.setTitle("Algoritmo de Geração de Linhas - Todos");
        
      
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
