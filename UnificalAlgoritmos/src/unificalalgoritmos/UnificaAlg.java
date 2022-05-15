package unificalalgoritmos;

/**
 *
 * @author Ronaldo
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UnificaAlg extends JFrame
        implements MouseListener, ActionListener {

    JLabel mousePosition;
    JMenuItem analitico, dda, bresenham, verde, azul, vermelho;
    int opcao = 0;
    int recarrega = 0;
    int cor, cont = 0;
    int x1;
    int y1;
    int x2 = 0, y2 = 0;
    int[] pontos = new int[4];

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public void Janela() {
        mousePosition = new JLabel();
        addMouseListener(this);
        add(mousePosition);

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
        vermelho = new JMenuItem("Vermelho");
        azul = new JMenuItem("Azul");
        verde = new JMenuItem("Verde");
        coresMenu.add(vermelho);
        coresMenu.add(verde);
        coresMenu.add(azul);

        analitico = new JMenuItem("Analitico");
        linhas.add(analitico);
        dda = new JMenuItem("DDA");
        linhas.add(dda);
        bresenham = new JMenuItem("Bresenham");
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

        azul.addActionListener(this);
        verde.addActionListener(this);
        vermelho.addActionListener(this);
        analitico.addActionListener(this);
        dda.addActionListener(this);
        bresenham.addActionListener(this);

        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("opcao" + opcao);
        if (recarrega == 1) {
            this.dispose();
            this.revalidate();
            new UnificaAlg().Janela();
            this.revalidate();
        }
        if (e.getSource() == analitico) {
            opcao = 1;

            System.out.println("analitico");
        }
        if (e.getSource() == dda) {
            opcao = 2;

            System.out.println("DDA");
        }
        if (e.getSource() == bresenham) {
            opcao = 3;

            System.out.println("Bresenham");
        }
        if (e.getSource() == vermelho) {
            cor = 1;
            System.out.println("vermelho");
        }
        if (e.getSource() == verde) {
            cor = 2;
            System.out.println("verde");
        }
        if (e.getSource() == azul) {
            cor = 3;
            System.out.println("azul");
        }

    }

    @Override

    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse clicado na coordenada 1 : ["+x1+","+y1+"]");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // mousePosition.setText("O Mouse está fora da janela de acesso");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cont++;
        if (cont == 1) {
            pontos[0] = e.getX() - 8;
            pontos[1] = e.getY() - 54;
        }
        if (cont == 2) {
            pontos[2] = e.getX() - 8;
            pontos[3] = e.getY() - 54;
            System.out.println("ponto inicial: [x1,y1][" + pontos[0] + "," + pontos[1] + "]");
            System.out.println("ponto final : [x2,y2][" + pontos[2] + "," + pontos[3] + "]");

            revalidate();
            this.add(new TodosLinha(opcao, pontos[0], pontos[1], pontos[2], pontos[3], cor));
            revalidate();

            cont = 0;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");

    }

    public void mouseDragged(MouseEvent e) {
        // mousePosition.setText("Mouse arrastado nas coordenadas : ["+e.getX()+","+e.getY()+"]");

    }

    public void mouseMoved(MouseEvent e) {
        //  mousePosition.setText("Mouse movido para as coordenadas : ["+e.getX()+","+e.getY()+"]");

    }
}
