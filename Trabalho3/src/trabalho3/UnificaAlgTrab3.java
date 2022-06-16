package trabalho3;

/**
 *
 * @author RONALDO
 */
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UnificaAlgTrab3 extends JFrame implements ActionListener {

    JLabel mousePosition;
    JMenuItem linhasR, poligonosR, bezierC, bSplineC, translacao, rotacao, escala, limparS;
    int opcao = 0;
    int qtdPontos = 0;
    int atual = 0;

    UnificaAlgTrab3() {
        //coordenadas do mouse
//        mousePosition = new JLabel();
//        addMouseListener(this);
//        add(mousePosition);

        //cria barra de menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //cria as opções na barra de menuBar
        JMenu recortes = new JMenu("Recortes");
        JMenu curvas = new JMenu("Curvas");
        JMenu transformacoes = new JMenu("Transformações");
        JMenu limpar = new JMenu("limpar");

        menuBar.add(recortes);
        menuBar.add(curvas);
        menuBar.add(transformacoes);
        menuBar.add(limpar);

        //cria opções no menuItem
        linhasR = new JMenuItem("Linhas Retas");
        recortes.add(linhasR);
        poligonosR = new JMenuItem("Poligono");
        recortes.add(poligonosR);

        bezierC = new JMenuItem("Bézier");
        curvas.add(bezierC);
        bSplineC = new JMenuItem("B-Spline");
        curvas.add(bSplineC);

        translacao = new JMenuItem("Translação");
        transformacoes.add(translacao);
        escala = new JMenuItem("Escala");
        transformacoes.add(escala);
        rotacao = new JMenuItem("Rotação");
        transformacoes.add(rotacao);
        limparS = new JMenuItem("Sim");
        limpar.add(limparS);

        linhasR.addActionListener(this);
        poligonosR.addActionListener(this);
        bezierC.addActionListener(this);
        bSplineC.addActionListener(this);
        translacao.addActionListener(this);
        escala.addActionListener(this);
        rotacao.addActionListener(this);
        limparS.addActionListener(this);

        //desenha janela
        this.setTitle("Trabalho 3");
        this.setSize(1000, 500);

        //this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == limparS) {
            opcao = 0;
            this.setVisible(false);
            System.out.println("Limpar");
            new UnificaAlgTrab3();
        }
        if (e.getSource() == linhasR) {
            opcao = 1;
            revalidate();
            this.add("Center", new RecorteLinha());
            revalidate();
            System.out.println("linhas Retas");
        }
        if (e.getSource() == poligonosR) {
            opcao = 2;
            revalidate();
            this.add("Center", new RecortePoli());
            revalidate();
            System.out.println("poligonos");
        }
        if (e.getSource() == bezierC) {
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de Pontos:");
            qtdPontos = Integer.parseInt(qtd);

            opcao = 3;
            revalidate();
            this.add("Center", new Bezier(qtdPontos));
            revalidate();

            System.out.println("bezier");
        }
        if (e.getSource() == bSplineC) {
            String qtd = JOptionPane.showInputDialog(null, "Quantidade de Pontos:");
            qtdPontos = Integer.parseInt(qtd);
            opcao = 4;
            revalidate();
            this.add("Center", new BSpline(qtdPontos));
            revalidate();
            System.out.println("b-spline");

        }
        if (e.getSource() == translacao) {
            opcao = 5;
            System.out.println("translação");
            revalidate();
            repaint();
            this.add(new TransformaGeo(opcao, atual));
            repaint();
            revalidate();

        }
        if (e.getSource() == escala) {
            opcao = 6;
            System.out.println("Escala");
            revalidate();
            repaint();
            this.add(new TransformaGeo(opcao, atual));
            repaint();
            revalidate();

        }
        if (e.getSource() == rotacao) {
            opcao = 7;
            System.out.println("rotação");
            revalidate();
            repaint();
            this.add(new TransformaGeo(opcao, atual));
            repaint();
            revalidate();

        }
       
        System.out.println("opcao:" + opcao);

    }

}
