/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 * @author fabio.lgvieira
 */
public class RPGGame {

    static Random randomizar = new Random();
    static JFrame jframe, framePergunta;
    static JTextField jtxtfd;
    static JTextArea txtarea;
    public static boolean running = false;
    static String commands[], nomePlayer;
    //public static int characterPosition[][], vila[][],floresta[][];
    static int posX = 0, posY = 0, perguntaEscolhida, tentativas;

    public static void main(String[] args) {
        // TODO code application logic here
        keyBoardInput();  // chama o metodo de Input
        start(); // chama o metodo start()
    }

    public static void start() {
        createJFrame(); // chama o metodo que ira criar a janela
        //menu

        txtarea.setText("Digite seu nome nessa aventura:\n");

    }

    public static void run() {
        running = true;
        while (running) {

            gameOver();

            if (false) {
                txtarea.append("you're dead game is over");
            }
        }
    }

    public static void gameOver() {
        running = false;
        txtarea.append("you're dead the game is over");
    }

    public static void keyBoardInput() {
        commands = new String[]{"w", "s", "a", "d", "meu nome", "/comandos", "ir para flroesta", "ir para vila", "ir para caverna",
            "atacar", "ver", "abrir", "pos"};
        jtxtfd = new JTextField("Digite o comando aqui", 62);
        jtxtfd.setFocusable(true);
        jtxtfd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str = jtxtfd.getText().toString();

                if (Arrays.asList(commands).contains(str)) { // verifica se o comando digitado ( str ) está dentro do array de comandos 
                    switch (str) {  // troca para cada caso dependendo do comando digitado
                        case "meu nome":
                            if (nomePlayer == null) {
                                txtarea.append("você nao tem nome");
                            } else {
                                txtarea.append("seu nome é " + nomePlayer);
                            }
                            break;
                        case "w":
                            posX += 0;
                            posY += 1;
                            //characterPosition = [posX][posY];
                            txtarea.append("voce andou pra cima");
                            break;
                        case "s":
                            posX += 0;
                            posY -= 1;
                            txtarea.append("voce andou pra baixo");
                            break;
                        case "a":
                            posX -= 1;
                            posY += 0;
                            txtarea.append("voce andou pra esquerda");
                            break;
                        case "d":
                            posX += 1;
                            posY += 0;
                            txtarea.append("voce andou pra direita");
                            break;
                        case "/comandos":
                            JOptionPane.showMessageDialog(null, Arrays.asList(commands), "Comandos", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "ir para floresta":
                            geradorMapa(1);
                            txtarea.append("voce foi para a floresta");
                            break;
                        case "ir para vila":
                            geradorMapa(0);
                            txtarea.append("voce para a vila");
                            break;
                        case "ir para caverna":
                            //geradorMapa(2);
                            txtarea.append("voce foi para a caverna");
                            break;
                        case "atacar":
                            break;
                        case "ver":
                            criaPergunta();//geraPergunta('f');
                            break;
                        case "abrir":
                            break;
                        case "pos":
                            txtarea.append("X: " + posX + "Y: " + posY);
                            break;
                    }
                } else if (nomePlayer == null) {
                    nomePlayer = str;
                    txtarea.append("Nome salvo com sucesso!");
                } else {
                    txtarea.append("Comando inválido, por favor digita um comando válido!"
                            + " Para ver os comandos, digite /comandos");
                }
                txtarea.append("\n");
                jtxtfd.setText("");
            }
        }
        );

        jtxtfd.addFocusListener(
                new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0
            ) {
                jtxtfd.setText("Digite o comando aqui");
            }

            @Override
            public void focusGained(FocusEvent arg0
            ) {
                jtxtfd.setText("");
            }
        }
        );
    }

    public static void geradorMapa(int mapa) {

    }

    public static void geraPergunta(char dificuldade) { //gerador de perguntas baseado em uma certa dificuldade
        criaPergunta();
        String perguntasFaceis[] = {"1", "2", "3"}, perguntasMedias[] = {"1", "2"}, perguntasDificeis[] = {"1", "2"};
        if (dificuldade == 'f' || dificuldade == 'F') {
            perguntaEscolhida = randomizar.nextInt(perguntasFaceis.length);
            txtarea.append(perguntasFaceis[perguntaEscolhida]);
        } else if (dificuldade == 'm' || dificuldade == 'M') {
            perguntaEscolhida = randomizar.nextInt(perguntasMedias.length);
            txtarea.append(perguntasMedias[perguntaEscolhida]);
        } else {
            perguntaEscolhida = randomizar.nextInt(perguntasDificeis.length);
            txtarea.append(perguntasDificeis[perguntaEscolhida]);
        }
        //Perguntas.pergunta01();
    }

    public static void criaPergunta() {
        framePergunta = new JFrame();
        framePergunta.setTitle("Enigma");
        framePergunta.setSize(500, 350);
        framePergunta.setResizable(false);
        framePergunta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextPane panelPergunta = new JTextPane();
        panelPergunta.setText("aehasuiehasiehuiashueiasuieas");

        JButton botao1 = new JButton();
        botao1.setBounds(5, 20, 100, 50);
        botao1.setText("zsadas");
        framePergunta.add(botao1);
        framePergunta.add(panelPergunta);

        framePergunta.setVisible(true);
    }

    public static void createJFrame() {
        jframe = new JFrame(); // cria a janela do jogo
        jframe.setSize(1280, 720); // define o tamanho da janela a ser criada
        jframe.setTitle("Beyond the Earth"); // define o nome que aparece no superior da janela
        jframe.setResizable(false); // impede a janela de sofrer altera�ao de tamanho
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permite fechar a janela

        JPanel jpnl1 = new JPanel(); // Panel do texto-jogo
        jpnl1.setBounds(5, 5, 695, 635); // X, Y, width, height
        jpnl1.setBackground(Color.gray);

        JPanel jpnl2 = new JPanel(); // Panel do mapa
        jpnl2.setBounds(705, 5, 350, 670);
        jpnl2.setBackground(Color.gray);

        JPanel jpnl3 = new JPanel(); // Panel da caixa de linha de comando
        jpnl3.setBounds(5, 645, 695, 30);
        jpnl3.setBackground(Color.gray);

        JPanel jpnl4 = new JPanel(); // Panel dos status do personagem
        jpnl4.setBounds(1060, 5, 200, 670);
        jpnl4.setBackground(Color.gray);
        jpnl4.setLayout(new GridLayout(5, 0)); // cria o Layout com um Grid

        JPanel jpnl0 = new JPanel(); // Panel do Background
        jpnl0.setBounds(1, 1, 1280, 720);
        jpnl0.setBackground(Color.black);

        txtarea = new JTextArea(39, 62);
        txtarea.setBounds(7, 7, 693, 633);
        txtarea.setEditable(false);
        txtarea.requestFocus();

        jframe.add(jpnl1); //adicionando os paineis e labels ao devido lugar no JFrame
        jframe.add(jpnl2);
        jframe.add(jpnl3);
        jframe.add(jpnl4);
        jframe.add(jpnl0);
        jpnl3.add(jtxtfd);
        jpnl1.add(txtarea);
        jframe.setVisible(true); // mostra a janela
    }

}

class Perguntas {

    public static void pergunta01() {
        //texto = O conjunto {x (pertence) R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo:
        //button1 = a) [ 10/4 ; 15 ]
        //button2 = b) [ 2,5 ; 15 [
        //button3 = c) ] 10/4 ; 15 ] x
        //button4 = d) ] 2,5 ; 15 [
        
    }
}
