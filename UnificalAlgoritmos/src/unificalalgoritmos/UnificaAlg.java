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
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UnificaAlg extends JFrame
        implements MouseListener, ActionListener {

    JLabel mousePosition;
    JMenuItem analitico, dda, bresenham, verde, azul, vermelho, varredura, boundaryFill, analiseGeometrica, parametrica, incremental, bresenhamCirc;
    int opcao = 0;
    int qtdFaces = 0;
    int recarrega = 0;
    int cor, cont = 0;
    int[] pontos = new int[4];
    int[] pontosPoligono = new int[4];
    int minX = 10000;
    int minY = 10000;
    int maxX = 1;
    int maxY = 1;
    int teste=1;
    int maior[] = new int[2];
    int aux1 = 0, aux2 = 0;

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

        varredura = new JMenuItem("Varredura");
        poligonos.add(varredura);
        boundaryFill = new JMenuItem("BoundaryFill");
        poligonos.add(boundaryFill);
        analiseGeometrica = new JMenuItem("Analise Geométrica");
        poligonos.add(analiseGeometrica);

        parametrica = new JMenuItem("Parametrica");
        circulos.add(parametrica);
        incremental = new JMenuItem("Incremental com simetria");
        circulos.add(incremental);
        bresenhamCirc = new JMenuItem("Bresenham");
        circulos.add(bresenhamCirc);

        azul.addActionListener(this);
        verde.addActionListener(this);
        vermelho.addActionListener(this);
        analitico.addActionListener(this);
        dda.addActionListener(this);
        bresenham.addActionListener(this);
        varredura.addActionListener(this);
        boundaryFill.addActionListener(this);
        analiseGeometrica.addActionListener(this);
        parametrica.addActionListener(this);
        incremental.addActionListener(this);
        bresenhamCirc.addActionListener(this);

        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        if (e.getSource() == varredura) {
            cont = 0;
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces");
            qtdFaces = Integer.parseInt(qtd);
            opcao = 4;
            System.out.println("varredura");
            System.out.println("faces:" + qtdFaces);
        }
        if (e.getSource() == boundaryFill) {
            cont = 0;
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces");
            qtdFaces = Integer.parseInt(qtd);
            opcao = 5;
            System.out.println("Boundary Fill");
            System.out.println("faces:" + qtdFaces);
        }
        if (e.getSource() == analiseGeometrica) {
            cont = 0;
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces");
            qtdFaces = Integer.parseInt(qtd);
            opcao = 6;
            System.out.println("Analise Geometrica");
            System.out.println("faces:" + qtdFaces);
        }
        if (e.getSource() == parametrica) {
            opcao = 7;
            System.out.println("Parametrica");
        }
        if (e.getSource() == incremental) {
            opcao = 8;
            System.out.println("Incremental");
        }
        if (e.getSource() == bresenhamCirc) {
            opcao = 9;
            System.out.println("Bresenham Circulo");
        }
        System.out.println("opcao: " + opcao);

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

        if (opcao == 1 || opcao == 2 || opcao == 3) {
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

        if (opcao == 4 || opcao == 5 || opcao == 6) {

            cont++;
            System.out.println("cont: " + cont);
            if (cont == 1) {
                pontosPoligono[0] = e.getX() - 8;
                pontosPoligono[1] = e.getY() - 54;
                if(pontosPoligono[0]<minX){
                    minX = pontosPoligono[0];
                }
                if(pontosPoligono[1]<minY){
                    minY = pontosPoligono[1];
                }

            }
            if (cont == 2) {
                pontosPoligono[2] = e.getX() - 8;
                pontosPoligono[3] = e.getY() - 54;
                aux1 = pontosPoligono[2];
                aux2 = pontosPoligono[3];
                if(pontosPoligono[2]<minX){
                    minX = pontosPoligono[2];
                }
                if(pontosPoligono[3]<minY){
                    minY = pontosPoligono[3];
                }
                if(pontosPoligono[2]>maxX){
                    maxX = pontosPoligono[2];
                }
                if(pontosPoligono[3]>maxY){
                    maxY = pontosPoligono[3];
                }
                
                revalidate();
                this.add(new AlgVarredura(qtdFaces, pontosPoligono[0], pontosPoligono[1], pontosPoligono[2], pontosPoligono[3],teste,teste,teste,teste));
                revalidate();

            }
            if (cont > 2) {

                pontosPoligono[2] = e.getX() - 8;
                pontosPoligono[3] = e.getY() - 54;
                
                if(pontosPoligono[2]<minX){
                    minX = pontosPoligono[2];
                }
                if(pontosPoligono[3]<minY){
                    minY = pontosPoligono[3];
                }
                if(pontosPoligono[2]>maxX){
                    maxX = pontosPoligono[2];
                }
                if(pontosPoligono[3]>maxY){
                    maxY = pontosPoligono[3];
                }
                
                
                revalidate();
                this.add(new AlgVarredura(qtdFaces, aux1, aux2, pontosPoligono[2], pontosPoligono[3],teste,teste,teste,teste));
                aux1 = pontosPoligono[2];
                aux2 = pontosPoligono[3];
//                
//                if(aux1<minX){
//                    minX = aux1;
//                }
//                if(aux2<minY){
//                    minY = aux2;
//                }
//                if(aux1>maxX){
//                    maxX = aux1;
//                }
//                if(aux2>maxY){
//                    maxY = aux2;
//                }
                revalidate();

            }
            if (cont == qtdFaces) {
                System.out.println("F principal xMin =[" + minX + "]yMin =[" + minY + "]xMax =[" + maxX + "]yMax =[" + maxY + "]");
                revalidate();
                this.add(new AlgVarredura(qtdFaces, pontosPoligono[2], pontosPoligono[3], pontosPoligono[0], pontosPoligono[1],minX,minY,maxX,maxY));
                
                revalidate();
            }

        }
        if (opcao == 7 || opcao == 8 || opcao == 9) {

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
