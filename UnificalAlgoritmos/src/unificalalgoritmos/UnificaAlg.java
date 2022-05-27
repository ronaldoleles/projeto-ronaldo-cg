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
    int cor, cont = 0, cont2 = 0, cont3 = 0;
    int[] pontos = new int[4];
    int[] pontosPoX;
    int[] pontosPoY;
    int minX = 10000;
    int minY = 10000;
    int maxX = 1;
    int maxY = 1;
    int teste = 1;
    int maior[] = new int[2];
    int aux1 = 0, aux2 = 0;
    int aux3 = 0, aux4 = 0;
    int raio = 0;
    int xCirc = 0;
    int yCirc = 0;
    boolean mouse = false;

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
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces:");

            qtdFaces = Integer.parseInt(qtd);
            opcao = 4;
            System.out.println("varredura");
            System.out.println("faces:" + qtdFaces);
            pontosPoX = new int[qtdFaces];
            pontosPoY = new int[qtdFaces];
        }
        if (e.getSource() == boundaryFill) {
            cont = 0;
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces:");
            qtdFaces = Integer.parseInt(qtd);
            opcao = 5;
            System.out.println("Boundary Fill");
            System.out.println("faces:" + qtdFaces);
            pontosPoX = new int[qtdFaces];
            pontosPoY = new int[qtdFaces];
        }
        if (e.getSource() == analiseGeometrica) {
            cont = 0;
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de faces:");
            qtdFaces = Integer.parseInt(qtd);
            opcao = 6;
            System.out.println("Analise Geometrica");
            System.out.println("faces:" + qtdFaces);
            pontosPoX = new int[qtdFaces];
            pontosPoY = new int[qtdFaces];
        }
        if (e.getSource() == parametrica) {
            String raioo = JOptionPane.showInputDialog(null, "Tamanho do raio:");
            raio = Integer.parseInt(raioo);
            opcao = 7;
            System.out.println("Parametrica");
        }
        if (e.getSource() == incremental) {
            String raioo = JOptionPane.showInputDialog(null, "Tamanho do raio:");
            raio = Integer.parseInt(raioo);
            opcao = 8;
            System.out.println("Incremental");
        }
        if (e.getSource() == bresenhamCirc) {
            String raioo = JOptionPane.showInputDialog(null, "Tamanho do raio:");
            raio = Integer.parseInt(raioo);
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
        //mousePosition.setText("Coordenada atual do mouse : ["+e.getX()+","+e.getY()+"]");

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

        if (opcao == 4) {
            if (cont < qtdFaces) {

                if (mouse == false) {
                    System.out.println("1: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    System.out.println("2: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    mouse = false;
                } else {
                    mouse = true;
                }

            }
            if (cont == qtdFaces) {
                System.out.println("cont: " + cont);
                System.out.println("cont2: " + cont2);

                for (int i = 0; i < cont; i++) {
                    aux1 = pontosPoX[0];
                    aux2 = pontosPoY[0];
                    // minimo x1
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }
                    //minimo x2
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }

                    //minimo y1
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }
                    //minimo y2
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }

                    //max x1
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max x2
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max y1
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }
                    //max y2
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }

                }
                for (int i = 0; i < cont + 1; i++) {

                    if (i == 0) {
                        revalidate();

                        this.add(new AlgVarredura(cont, aux1, aux2, pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux1 + "," + aux2 + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
                        revalidate();
                        aux3 = pontosPoX[1];
                        aux4 = pontosPoY[1];
                    }
                    if ((i > 0) && (i + 1 < cont)) {

                        revalidate();

                        this.add(new AlgVarredura(cont, aux3, aux4, pontosPoX[i + 1], pontosPoY[i + 1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux3 + "," + aux4 + ";" + pontosPoX[i + 1] + "," + pontosPoY[i + 1] + "]");

                        revalidate();
                        aux3 = pontosPoX[i + 1];
                        aux4 = pontosPoY[i + 1];
                    }
                    if (i + 1 == cont) {
                        revalidate();
                        repaint();
                        this.add(new AlgVarredura(cont, aux3, aux4, aux1, aux2, minX, minY, maxX, maxY));
                        System.out.println("[" + aux3 + "," + aux4 + ";" + aux1 + "," + aux2 + "]");
                        repaint();
                        revalidate();
                        i = cont;
                    }
                }
//                System.out.println("-------------------------------------------------------------------------------");
//                System.out.println("[" + pontosPoX[0] + "," + pontosPoY[0] + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
//                System.out.println("[" + pontosPoX[1] + "," + pontosPoY[1] + ";" + pontosPoX[2] + "," + pontosPoY[2] + "]");
//                System.out.println("[" + pontosPoX[2] + "," + pontosPoY[2] + ";" + pontosPoX[3] + "," + pontosPoY[3] + "]");
//                System.out.println("[" + pontosPoX[3] + "," + pontosPoY[3] + ";" + pontosPoX[0] + "," + pontosPoY[0] + "]");
//                System.out.println("Inicio xMin =[" + minX + "]yMin =[" + minY + "]xMax =[" + maxX + "]yMax =[" + maxY + "]");
//                System.out.println("-------------------------------------------------------------------------------");
                /////o que funciona

//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[0], pontosPoY[0], pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[1], pontosPoY[1], pontosPoX[2], pontosPoY[2], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[2], pontosPoY[2], pontosPoX[3], pontosPoY[3], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[3], pontosPoY[3], pontosPoX[0], pontosPoY[0], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
                // System.out.println("[" + pontosPoX[4] + "," + pontosPoY[4] + ";" + pontosPoX[5] + "," + pontosPoY[5] + "]");
                
            }

  
        }
        if (opcao == 5) {
             if (cont < qtdFaces) {

                if (mouse == false) {
                    System.out.println("1: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    System.out.println("2: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    mouse = false;
                } else {
                    mouse = true;
                }

            }
            if (cont == qtdFaces) {
                System.out.println("cont: " + cont);
                System.out.println("cont2: " + cont2);

                for (int i = 0; i < cont; i++) {
                    aux1 = pontosPoX[0];
                    aux2 = pontosPoY[0];
                    // minimo x1
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }
                    //minimo x2
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }

                    //minimo y1
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }
                    //minimo y2
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }

                    //max x1
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max x2
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max y1
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }
                    //max y2
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }

                }
                for (int i = 0; i < cont + 1; i++) {

                    if (i == 0) {
                        revalidate();

                        this.add(new AlgBF(cont, aux1, aux2, pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux1 + "," + aux2 + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
                        revalidate();
                        aux3 = pontosPoX[1];
                        aux4 = pontosPoY[1];
                    }
                    if ((i > 0) && (i + 1 < cont)) {

                        revalidate();

                        this.add(new AlgBF(cont, aux3, aux4, pontosPoX[i + 1], pontosPoY[i + 1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux3 + "," + aux4 + ";" + pontosPoX[i + 1] + "," + pontosPoY[i + 1] + "]");

                        revalidate();
                        aux3 = pontosPoX[i + 1];
                        aux4 = pontosPoY[i + 1];
                    }
                    if (i + 1 == cont) {
                        revalidate();
                        repaint();
                        this.add(new AlgBF(cont, aux3, aux4, aux1, aux2, minX, minY, maxX, maxY));
                        System.out.println("[" + aux3 + "," + aux4 + ";" + aux1 + "," + aux2 + "]");
                        repaint();
                        revalidate();
                        i = cont;
                    }
                }
//                System.out.println("-------------------------------------------------------------------------------");
//                System.out.println("[" + pontosPoX[0] + "," + pontosPoY[0] + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
//                System.out.println("[" + pontosPoX[1] + "," + pontosPoY[1] + ";" + pontosPoX[2] + "," + pontosPoY[2] + "]");
//                System.out.println("[" + pontosPoX[2] + "," + pontosPoY[2] + ";" + pontosPoX[3] + "," + pontosPoY[3] + "]");
//                System.out.println("[" + pontosPoX[3] + "," + pontosPoY[3] + ";" + pontosPoX[0] + "," + pontosPoY[0] + "]");
//                System.out.println("Inicio xMin =[" + minX + "]yMin =[" + minY + "]xMax =[" + maxX + "]yMax =[" + maxY + "]");
//                System.out.println("-------------------------------------------------------------------------------");
                /////o que funciona

//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[0], pontosPoY[0], pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[1], pontosPoY[1], pontosPoX[2], pontosPoY[2], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[2], pontosPoY[2], pontosPoX[3], pontosPoY[3], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[3], pontosPoY[3], pontosPoX[0], pontosPoY[0], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
                // System.out.println("[" + pontosPoX[4] + "," + pontosPoY[4] + ";" + pontosPoX[5] + "," + pontosPoY[5] + "]");
                
            }
        }
        if (opcao == 6) {
           if (cont < qtdFaces) {

                if (mouse == false) {
                    System.out.println("1: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    System.out.println("2: [" + e.getX() + "," + e.getY() + "]");
                    pontosPoX[cont] = e.getX() - 8;
                    pontosPoY[cont] = e.getY() - 54;
                    cont++;
                }
                if (mouse == true) {
                    mouse = false;
                } else {
                    mouse = true;
                }

            }
            if (cont == qtdFaces) {
                System.out.println("cont: " + cont);
                System.out.println("cont2: " + cont2);

                for (int i = 0; i < cont; i++) {
                    aux1 = pontosPoX[0];
                    aux2 = pontosPoY[0];
                    // minimo x1
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }
                    //minimo x2
                    if (minX > pontosPoX[i]) {
                        minX = pontosPoX[i];
                    }

                    //minimo y1
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }
                    //minimo y2
                    if (minY > pontosPoY[i]) {
                        minY = pontosPoY[i];
                    }

                    //max x1
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max x2
                    if (maxX < pontosPoX[i]) {
                        maxX = pontosPoX[i];
                    }
                    //max y1
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }
                    //max y2
                    if (maxY < pontosPoY[i]) {
                        maxY = pontosPoY[i];
                    }

                }
                for (int i = 0; i < cont + 1; i++) {

                    if (i == 0) {
                        revalidate();

                        this.add(new AlgVarredura(cont, aux1, aux2, pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux1 + "," + aux2 + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
                        revalidate();
                        aux3 = pontosPoX[1];
                        aux4 = pontosPoY[1];
                    }
                    if ((i > 0) && (i + 1 < cont)) {

                        revalidate();

                        this.add(new AlgVarredura(cont, aux3, aux4, pontosPoX[i + 1], pontosPoY[i + 1], minX, minY, maxX, maxY));

                        System.out.println("[" + aux3 + "," + aux4 + ";" + pontosPoX[i + 1] + "," + pontosPoY[i + 1] + "]");

                        revalidate();
                        aux3 = pontosPoX[i + 1];
                        aux4 = pontosPoY[i + 1];
                    }
                    if (i + 1 == cont) {
                        revalidate();
                        repaint();
                        this.add(new AlgVarredura(cont, aux3, aux4, aux1, aux2, minX, minY, maxX, maxY));
                        System.out.println("[" + aux3 + "," + aux4 + ";" + aux1 + "," + aux2 + "]");
                        repaint();
                        revalidate();
                        i = cont;
                    }
                }
//                System.out.println("-------------------------------------------------------------------------------");
//                System.out.println("[" + pontosPoX[0] + "," + pontosPoY[0] + ";" + pontosPoX[1] + "," + pontosPoY[1] + "]");
//                System.out.println("[" + pontosPoX[1] + "," + pontosPoY[1] + ";" + pontosPoX[2] + "," + pontosPoY[2] + "]");
//                System.out.println("[" + pontosPoX[2] + "," + pontosPoY[2] + ";" + pontosPoX[3] + "," + pontosPoY[3] + "]");
//                System.out.println("[" + pontosPoX[3] + "," + pontosPoY[3] + ";" + pontosPoX[0] + "," + pontosPoY[0] + "]");
//                System.out.println("Inicio xMin =[" + minX + "]yMin =[" + minY + "]xMax =[" + maxX + "]yMax =[" + maxY + "]");
//                System.out.println("-------------------------------------------------------------------------------");
                /////o que funciona

//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[0], pontosPoY[0], pontosPoX[1], pontosPoY[1], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[1], pontosPoY[1], pontosPoX[2], pontosPoY[2], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[2], pontosPoY[2], pontosPoX[3], pontosPoY[3], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
//                repaint();
//                this.add(new AlgVarredura(cont, pontosPoX[3], pontosPoY[3], pontosPoX[0], pontosPoY[0], minX, minY, maxX, maxY));
//                repaint();
//                revalidate();
                // System.out.println("[" + pontosPoX[4] + "," + pontosPoY[4] + ";" + pontosPoX[5] + "," + pontosPoY[5] + "]");
                
            }
        }
        if (opcao == 7) {
            xCirc = e.getX() - 8;
            yCirc = e.getY() - 54;
            revalidate();
            this.add(new AlgCircParametrica(cor, raio, xCirc, yCirc));
            revalidate();
        }
        if (opcao == 8) {
            xCirc = e.getX() - 8;
            yCirc = e.getY() - 54;
            revalidate();
            this.add(new AlgCircIncremental(cor, raio, xCirc, yCirc));
            revalidate();
        }
        if (opcao == 9) {
            xCirc = e.getX() - 8;
            yCirc = e.getY() - 54;
            revalidate();

            this.add(new AlgCircBresenham(cor, raio, xCirc, yCirc));
            revalidate();
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
