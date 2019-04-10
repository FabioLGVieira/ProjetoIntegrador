package Rpggame;

import java.util.Scanner;

public class GameMain {

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
        if(pegaComando.equals("pegar")){
            System.out.println("Wow é um projeto detalhado de um Foguete Espacial, quem deixaria isso aqui?");
        } else {
            System.out.println("Vou pegar esse livro de Java e reprovar na prova mesmo!");
        }
    }
    
    public static void strNext(){
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
