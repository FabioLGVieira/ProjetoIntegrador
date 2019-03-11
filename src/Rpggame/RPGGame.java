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
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author fabio.lgvieira
 */
public class RPGGame {

    static JFrame jframe;
    static JTextField jtxtfd;
    static JTextArea txtarea;
    public static Player obj;  // cria uma instancia do Player
    public static boolean running = false;
    private static String[] commands;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        keyBoardInput();  // chama o metodo de Input
        start(); // chama o metodo start()
    }

    public static void start() {
        createJFrame(); // chama o metodo que ir� criar a janela
        obj = new Player();  // cria uma instancia do Player
        txtarea.setText("Digite seu nome nessa aventura:" + "\n");
    }

    public static void run() {
        running = true;
        while (running) {

            gameOver();

            if (obj.getHp() < 1) {
                txtarea.append("you're dead game is over");
            }
        }
    }

    public static void gameOver() {
        running = false;
        txtarea.append("you're dead the game is over");
    }

    public static void keyBoardInput() {
        commands = new String[]{"w", "s", "a", "d", "meu nome", "comandos", "ir para flroesta", "ir para vila", "ir para caverna",
            "atacar", "ver", "abrir"};
        jtxtfd = new JTextField("Digite o comando aqui", 62);
        jtxtfd.setFocusable(true);
        jtxtfd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String str = jtxtfd.getText().toString();

                if (Arrays.asList(commands).contains(str)) { // verifica se o comando digitado ( str ) está dentro do array de comandos 
                    switch (str) {  // troca para cada caso dependendo do comando digitado
                        case "meu nome":
                            if (obj.getNomePlayer() == null) {
                                txtarea.append("você nao tem nome");
                            } else {
                                txtarea.append("seu nome é " + obj.getNomePlayer());
                            }
                            break;
                        case "w":
                            txtarea.append("voce andou pra cima");
                            break;
                        case "s":
                            txtarea.append("voce andou pra baixo");
                            break;
                        case "a":
                            txtarea.append("voce andou pra esquerda");
                            break;
                        case "d":
                            txtarea.append("voce andou pra direita");
                            break;
                        case "comandos":
                            JOptionPane.showMessageDialog(null, Arrays.asList(commands), "Comandos", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "ir para floresta":
                            txtarea.append("voce foi para a floresta");
                            break;
                        case "ir para vila":
                            txtarea.append("voce para a vila");
                            break;
                        case "ir para caverna":
                            txtarea.append("voce foi para a caverna");
                            break;
                        case "atacar":
                            break;
                        case "ver":
                            break;
                        case "abrir":
                            break;
                    }
                } else if (obj.getNomePlayer() == null) {
                    generatePlayer(str);
                    txtarea.append("Nome salvo com sucesso!");
                } else {
                    txtarea.append("Comando inválido, por favor digita um comando válido");
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

    public static void generatePlayer(String nome) {
        obj.setNomePlayer(nome);
        obj.setHp(50);
        obj.setMp(60);
        obj.setOuro(150);
        obj.setAtq(35);
        obj.setDef(40);
        obj.setPeso(15);
    }

    public static void createJFrame() {
        jframe = new JFrame(); // cria a janela do jogo
        jframe.setSize(1280, 720); // define o tamanho da janela a ser criada
        jframe.setTitle("RPG-MUD"); // define o nome que aparece no superior da janela
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

        JLabel labelhp = new JLabel("HP: "); //criação dos Labels de informações do personagem
        labelhp.setForeground(Color.black); //define a cor dos Labels
        JLabel labelHP = new JLabel("99/99");
        labelhp.setForeground(Color.black);
        JLabel labelgold = new JLabel("Ouro: ");
        labelhp.setForeground(Color.black);
        JLabel labelOuro = new JLabel("999,999");
        labelhp.setForeground(Color.black);
        labelhp.setForeground(Color.black);
        JLabel labelatq = new JLabel("Ataque: ");
        labelhp.setForeground(Color.black);
        JLabel labelATQ = new JLabel("25");
        labelhp.setForeground(Color.black);
        JLabel labeldef = new JLabel("Defesa: ");
        labelhp.setForeground(Color.black);
        JLabel labelDEF = new JLabel("17");
        labelhp.setForeground(Color.black);
        JLabel labelweight = new JLabel("Peso: ");
        labelhp.setForeground(Color.black);
        JLabel labelPeso = new JLabel("5kg");

        jframe.add(jpnl1); //adicionando os paineis e labels ao devido lugar no JFrame
        jframe.add(jpnl2);
        jframe.add(jpnl3);
        jframe.add(jpnl4);
        jframe.add(jpnl0);
        jpnl4.add(labelhp);
        jpnl4.add(labelHP);
        jpnl4.add(labelgold);
        jpnl4.add(labelOuro);
        jpnl4.add(labelatq);
        jpnl4.add(labelATQ);
        jpnl4.add(labeldef);
        jpnl4.add(labelDEF);
        jpnl4.add(labelweight);
        jpnl4.add(labelPeso);
        jpnl3.add(jtxtfd);
        jpnl1.add(txtarea);
        jframe.setVisible(true); // mostra a janela
    }

}
