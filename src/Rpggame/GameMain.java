package Rpggame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean running = false;
    static String pegaComando;

    public static void main(String[] args) {
        menu();
    }

    public static void game() {
        //running = true;
        System.out.println("Segurança do Senac - Bom dia jovem estudante, ja viu sobre o Concurso Espacial? Deixe-me primeiramente"
                + "lhe dizer sobre os comandos. \n A barra de comando abaixo serve para movimentaçao e açoes. Voce pode digitar "
                + "/comandos para ver todos os comandos validos do jogo.\n Me diga seu nome:");
        sc.nextLine();
        String nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        System.out.println("Muito bem, " + nome + ". Agora se dirija ate a biblioteca para saber mais sobre o Concurso!");
        System.out.println("Comandos disponiveis: Leste | Oeste");

        //tutorial pro player aprender alguns comandos
        strNext();
        while (!pegaComando.equals("oeste")) {
            System.out.println("A biblioteca é para o outro lado!");
            strNext();
        }
        System.out.println("Você chegou na biblioteca! Logo percebe outros alunos conversando sobre projetos para o Concurso.");
        System.out.println("Comandos disponiveis: Conversar | Sul | Norte");
        strNext();
        if (pegaComando.equals("conversar")) {
            System.out.println(nome + ": O que é esse concurso?");
            System.out.println("Julia: Quem se inscrever tem que fazer um projeto de alguma atividade fora da Terra, como "
                    + "viagens espaciais, atividades de pesquisa, ou evolução tecnológica!\n Por exemplo, alguns alunos ja pensaram "
                    + "em criar cidades-bolha, casas ou edifícios em outros planetas, carros flutuantes, robôs operários,"
                    + "super proteses, entre outros. E voce, vai ficar de fora?"
                    + "Comandos disponiveis: S | N");
            strNext();
            if (pegaComando.equals("s")) {
                System.out.println("Gostei muito da ideia, mas nao sei ainda o que fazer, vou pensar mais!");
            }
            if (pegaComando.equals("n")) {
                System.out.println("Por enquanto nao");
            }
        } else if (pegaComando.equals("sul")) {
            gameOver();
            //System.out.println("Nao desista do concurso!(Voz interior)");
        } else if (pegaComando.equals("norte")) {
            System.out.println(nome + "Onde vou achar esse livro de Java?");
        }
        System.out.println("O que é esse papel amassado no chao?");
        System.out.println("Comandos disponiveis: Pegar | Ignorar");
        if (pegaComando.equals("pegar")) {
            System.out.println("Wow é um projeto detalhado de um Foguete Espacial, quem deixaria isso aqui?");
        } else {
            System.out.println("Vou pegar esse livro de Java e reprovar na prova mesmo!");
        }
    }

    public static void perguntaFacil() {
        int tentativas = 3;
        int rnd = randomico.nextInt(2); //perguntas
        String perguntas[] = {"O conjunto {x (pertence) R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo",
            "O número 255 na base decimal, pode ser representado, respectivamente, nas bases Binária, Octal e Hexadecimal por",
            "Quantos bits há em 2 bytes", "A expressão (a-b)³ pode ser representada por",
            " Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é: "},
                respostasFaceis[][] = {{"[ 10/4 ; 15 ]", "[ 2,5 ; 15 [", "] 10/4 ; 15 ]", "] 2,5 ; 15 ["}, //respostas das perguntas
                {"01100110, 356 ,EE", "00001111, 380, EF", "11111111, 377, FF", "11110000, 374, FE"},
                {"8", "16", "32", "64"}, {"a³ - 3a³b + 3ab³ + b³", "a³ + 3a³b + 3ab³ + b³", "a³ - 3a³b - 3ab³ - b³", "a³ - 3a³b - 3ab³ + b³"}
                ,{" while " , " if ", " do while ", " for "}},
                alternativaA, alternativaB, alternativaC, alternativaD;
        char resposta, corretaFaceis[] = {'c', 'c', 'b', 'a', 'd'}; //verificação das respostas
        alternativaA = respostasFaceis[rnd][0]; //recebe a resposta da pergunta
        alternativaB = respostasFaceis[rnd][1];
        alternativaC = respostasFaceis[rnd][2];
        alternativaD = respostasFaceis[rnd][3];

        System.out.println(perguntas[rnd] + ":"); //imprime a pergunta e as respostas
        System.out.println("a)" + alternativaA);
        System.out.println("b)" + alternativaB);
        System.out.println("c)" + alternativaC);
        System.out.println("d)" + alternativaD);
        do {
            System.out.println("Voce tem " + tentativas + "tentativas"); //tentativas de resposta
            resposta = sc.next().toLowerCase().charAt(0);
            if (resposta != corretaFaceis[rnd]) {
                System.out.println("Voce errou tente denovo");
                tentativas--;
            }
        } while (resposta != corretaFaceis[rnd] && tentativas > 0);
        if (resposta == corretaFaceis[rnd]) {
            System.out.println("resposta certa");
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
        }
        resposta = sc.next().toLowerCase().charAt(0);
        if (resposta == 's') {
            perguntaFacil();
        }
    }

    public static void strNext() {
        pegaComando = sc.nextLine().toLowerCase();
    }

    public static void gameOver() {
        System.out.println("Voce desistiu do projeto, PERDEU");
    }

    public static void menu() {
        System.out.println(" --------------------------");
        System.out.println("|       --> Menu <--       |\n"
                + "| 1- Instruções            | \n| 2- Jogar                 | \n| 3- Ir para o fim do jogo |\n"
                + "| 4- Créditos              |\n| 5- Sair                  |");
        System.out.println(" --------------------------");
        System.out.println("Digite uma opção:");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Instruções: \n"
                        + "Você pode jogar digitando comandos especificados em cada sala e assim progredir no Jogo."
                        + "Para terminar o jogo é necessario juntar todas as partes do projeto.");
                System.out.println("Gostaria de começar o jogo? S/N");
                pegaComando = sc.next();
                if (pegaComando.equals("s")) {
                    game();
                } else {
                    menu();
                }
                break;
            case 2:
                game();
                break;
            case 3:
                perguntaFacil(); // apenas acelerar o teste, tirar futuramente
                System.out.println("Pegadinha haha");
                break;
            case 4:
                System.out.printf("=== Developed by: === %n=> Fabio Vieira %n=> Leonardo Barbosa"
                        + "%n=> Pedro Arantes %n=> Vagner Matos%n");
                menu();
                break;
            case 5:
                System.out.println("Ate a proxima!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
