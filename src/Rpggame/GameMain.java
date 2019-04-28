package Rpggame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean running = false;
    static String nome, pegaComando;
    static int senha, progrssoJogo = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void game() {
        //running = true;

        System.out.println("Voce esta chegando na universidade Senac, e agora sua aventura comeca ...");

        System.out.println("Seguran�a do Senac - Bom dia jovem estudante seja bem vindo ao Senac, a confraternizacao dos calouros"
                + " esta sendos realizada la na frente, voce pode pegar um atalho pela bilbioteca."
                + "\nA proposito qual é o seu nome ?");
        sc.nextLine();
        nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        System.out.println("Muito bem, " + nome + ". boa sorte");
        System.out.println("Comandos disponiveis: biblioteca | salas");

        //tutorial pro player aprender alguns comandos
        //dizer tbm que se o comando disponivel for masi de uma palavra, o player pode digitar apenas a primeira
        strNext();
        while (!pegaComando.equals("biblioteca")) {
            System.out.println("as salas estao vazias");
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
                    + "\nsuper proteses, entre outros. E voce, vai ficar de fora?"
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
        strNext();
        if (pegaComando.equals("pegar")) {
            System.out.println("Wow é um projeto detalhado de um Foguete Espacial, quem deixaria isso aqui?"
                    + "\n Bom vou guarda-lo e ir falar com o professor ??? se pode me ajudar");
        } else {
            System.out.println("Vou pegar esse livro de Java e reprovar na prova mesmo!");
            gameOver();
        }
        System.out.println("Bom acho que vou la procurar o professor ???.");
        pracaAlimentacao1();
    }

    //template pra progresso do jogo 
    /*if(progrssoJogo == 0){

} else if(progrssoJogo == 1){

} else if(progrssoJogo == 2){

} else if(progrssoJogo == 3){

} else if(progrssoJogo == 4){

} else if(progrssoJogo == 5){

} else if(progrssoJogo == 6){

} else if(progrssoJogo == 7){

} else{}*/
    public static void perguntaFacil() {
        int tentativas = 3;
        int rnd = randomico.nextInt(2); //perguntas
        String perguntas[] = {"O conjunto {x " + (char) 8712 + " R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo",
            "O número 255 na base decimal, pode ser representado, respectivamente, nas bases Binária, Octal e Hexadecimal por",
            "Quantos bits há em 2 bytes", "A expressão (a-b)³ pode ser representada por",
            " Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é: "},
                respostasFaceis[][] = {{"[ 10/4 ; 15 ]", "[ 2,5 ; 15 [", "] 10/4 ; 15 ]", "] 2,5 ; 15 ["}, //respostas das perguntas
                {"01100110, 356 ,EE", "00001111, 380, EF", "11111111, 377, FF", "11110000, 374, FE"},
                {"8", "16", "32", "64"}, {"a³ - 3a³b + 3ab³ + b³", "a³ + 3a³b + 3ab³ + b³", "a³ - 3a³b - 3ab³ - b³", "a³ - 3a³b - 3ab³ + b³"},
                {" while ", " if ", " do while ", " for "}},
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
        if (resposta == corretaFaceis[rnd]) { //colocar uma funçao para a resposta CERTA 
            System.out.println("resposta certa");
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");

            resposta = sc.next().toLowerCase().charAt(0);
            if (resposta == 's') {
                perguntaFacil();
            }
        }
    }

    public static void pracaAlimentacao1() {
        if (progrssoJogo == 0) {
            System.out.println(nome + " : Hey Paulo, voce também está participando do  ");
            System.out.println(" projeto espacial ? ");
            System.out.println(" Paulo: estou sim, " + nome + " , qual que é o seu projeto ? ");
            System.out.println(nome + " : não posso contar, caso alguém fique sabendo podem copiar minha idéia. ");
            System.out.println(" Aliás, voce viu o professor Gilberto ? ");
            System.out.println(" Paulo: ele fica no laboratório de mecanica normalmete ");
            System.out.println(nome + " : obrigado paulo vou procura - lo ");
            System.out.println("Para onde deseja ir?");
            System.out.println("Disponiveis: Laboratorio | Sala | Biblioteca");
            strNext();
            if (pegaComando.equals("laboratorio")) {
                labMecanica();
            } else if (pegaComando.equals("sala")) {
                salaDeAula();
            } else if (pegaComando.equals("biblioteca")) {
                biblioteca();
            }
        } else if (progrssoJogo == 1) {

        } else if (progrssoJogo == 2) {

        } else if (progrssoJogo == 3) {

        } else if (progrssoJogo == 4) {

        } else if (progrssoJogo == 5) {

        } else if (progrssoJogo == 6) {

        } else if (progrssoJogo == 7) {

        } else {
        }

    }

    static void salaDeAula() {
        if (progrssoJogo == 0) {

        } else if (progrssoJogo == 1) {

        } else if (progrssoJogo == 2) {

        } else if (progrssoJogo == 3) {

        } else if (progrssoJogo == 4) {

        } else if (progrssoJogo == 5) {

        } else if (progrssoJogo == 6) {

        } else if (progrssoJogo == 7) {

        } else {
        }

    }

    public static void labMecanica() {
        if (progrssoJogo == 0) {
            System.out.println(nome + " : segunrança, preciso entrar no laboratório pra falar com o ");
            System.out.println(" professor Gilberto, voce poderia me passar a senha de acesso do laboratótio ? ");
            System.out.println(" Não posso te passar a senha, mas posso te dar algumas dicas:\n"
                    + "Ela é um numero de 4 digitos e estah* em binário: ");
            System.out.println(" 111 100 100 110‬ ");

            System.out.println(" Teclado da fechadura ");
            System.out.println(" Digite a senha: ");
            senha = sc.nextInt();
            while (senha != 7446) {
                System.out.println(" Digite a senha: ");
                senha = sc.nextInt();
            }
            if (senha == 7446) {
                System.out.println(" Acesso liberado ");
                System.out.println(" Professor Gilberto: muito bem " + nome + " , parece que voce me encontrou ");
                System.out.println(" como posso te ajudar ? ");
                System.out.println("disponiveis: pedir ajuda | perguntar se vai ter prova");
                strNext();
                if(pegaComando.equals("pedir")){
                System.out.println(nome + " estou precisando de peças para montar meu projeto espacial ");
                System.out.println(" creio que o senhor poderia me ajudar ");
                System.out.println(" Professor Gilberto: posso te ajudar sim " + nome + " porém voce terá ");
                System.out.println(" de me responder uma pergunta. Voce esta* de acordo? ");
                    System.out.println("Disponiveis S | N");
                    if(pegaComando.equals("s")){
                perguntaFacil();}
                    else{
                        gameOver();
                    }
                System.out.println(" Parabéns " + nome + " com essa resposta certa voce ganha um item para o seu projeto ");}
            
            }
        } else if (progrssoJogo == 1) {

        } else if (progrssoJogo == 2) {

        } else if (progrssoJogo == 3) {

        } else if (progrssoJogo == 4) {

        } else if (progrssoJogo == 5) {

        } else if (progrssoJogo == 6) {

        } else if (progrssoJogo == 7) {

        } else {
        }
    }

    public static void pracaAlimentacao2() {
if(progrssoJogo == 0){
        System.out.println(" André: fala " + nome + " fiquei sabendo que voce está ");
        System.out.println(" participando do projeto espacial, o que voce está fazendo ? ");
        System.out.println(nome + " : não posso contar de jeito nenhum. ");
        System.out.println(" André: o que é isso no seu bolso ? (pega o projeto e sai correndo) ");
        System.out.println(nome + " : voce pegou meu projeto devolva agora ");
        System.out.println(" Só se voce me pagar um lanche ");
        System.out.println(" Deseja pagar um lanche para ter seu projeto de volta ? Sim (S) | Não (N) ");
        if (pegaComando.equals("S")) {
            System.out.println(" Conseguiu seu projeto de volta ");
        } else if (pegaComando.equals("N")) {
            gameOver();

        }
    } else if(progrssoJogo == 1){

} else if(progrssoJogo == 2){

} else if(progrssoJogo == 3){

} else if(progrssoJogo == 4){

} else if(progrssoJogo == 5){

} else if(progrssoJogo == 6){

} else if(progrssoJogo == 7){

} else{}   
    }

    public static void labDesign() {

    }

    public static void strNext() {
        pegaComando = sc.nextLine().toLowerCase();
    }

    public static void gameOver() {
        System.out.println("Voce desistiu do projeto, PERDEU");
    }

    //implementar imagem ascii
    public static void salavazia() {

    }

    public static void biblioteca() {

    }

    public static void menu() {
        System.out.println("      Beyond the earth   \n"
                + "\n --------------------------"
                + "\n|       --> Menu <--       |"
                + "\n| 1- Instru��es            |"
                + "\n| 2- Jogar                 |"
                + "\n| 3- Ir para o fim do jogo |"
                + "\n| 4- Creditos              |"
                + "\n| 5- Sair                  |"
                + "\n --------------------------");

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
