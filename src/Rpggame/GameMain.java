package Rpggame;

import java.util.Random;
import java.util.Scanner;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static String nome, pegaComando;
    static int senha, progressoJogo;
    static char resposta;

    public static void main(String[] args) {
        progressoJogo = 0;
        menu();
    }

    public static void inicioGame() {
        //running = true;
        System.out.println("\n\n\n\n======================================================================================================================");
        System.out.println("Voce esta chegando na universidade Senac, e agora sua aventura comeca ...\n\n");
        System.out.println("Ao chegar no Senac, um dos Seguranças quer falar com você.");
        System.out.println("Segurança do Senac - Bom dia jovem estudante seja bem vindo ao Senac, hoje tem inicio"
                + "o Concurso do Senac. Primeiramente, devo te ensinar como jogar."
                + "\nA proposito qual é o seu nome ?");
        sc.nextLine();
        nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        //tutorial pro player aprender alguns comandos
        System.out.println("Muito bem, " + nome + ". Para conseguir jogar, voce deve digitar os COMANDOS DISPONIVEIS "
                + "para interagir com ações ou mudando de salas. Por exemplo, se aparecer:  Pegar item | Biblioteca\n"
                + "Você pode digitar apenas 'pegar' para executar a ação, ou 'biblioteca' para se dirigir até a sala.\n"
                + "Acho que por enquanto é só isso que você precisa, vamos testar se voce entendeu.");
        do {
            System.out.println("Comandos disponíveis: Biblioteca | Sala de Aula | Pegar panfleto");
            strNext();
            if (pegaComando.equals("sala")) {
                System.out.println("Ue cade o professor e todo mundo. Será que estao Biblioteca?");
            } else {
                System.out.println("Acho que vou pegar esse panfleto.\n"
                        + "Esta dizendo sobre um Concurso... Mais informações na Biblioteca.");
            }
        } while (!pegaComando.equals("biblioteca"));
        biblioteca();
    }

    static void biblioteca() {
        System.out.println("\n====================\n" + salaAtual("biblioteca"));
        if (progressoJogo == 0) {
            System.out.println("Logo percebe outros alunos conversando sobre projetos para o Concurso.");
            do {
                System.out.println("Comandos disponiveis: Conversar a Balconista | Sul | Norte");
                strNext();
                if (pegaComando.equals("sul")) {
                    gameOver();
                    //System.out.println("Nao desista do concurso!(Voz interior)");
                } else if (pegaComando.equals("norte")) {
                    System.out.println(nome + "Onde vou achar esse livro de Java?");
                }
            } while (!pegaComando.equals("conversar"));

            System.out.println(nome + ": O que é esse concurso?");
            System.out.println("Julia: Quem se inscrever tem que fazer um projeto de alguma atividade fora da Terra, como "
                    + "viagens espaciais, atividades de pesquisa, ou evolução tecnológica!\n Por exemplo, alguns alunos ja pensaram "
                    + "em criar cidades-bolha, casas ou edifícios em outros planetas, carros flutuantes, robôs operários,"
                    + "\nsuper proteses, entre outros. E voce, vai participar?\n"
                    + "Comandos disponiveis: S | N");
            charNext();
            if (resposta == 's') {
                System.out.println("Gostei muito da ideia, mas nao sei ainda o que fazer, vou pensar mais! "
                        + "Agora preciso pegar um livro pra prova!");
            } else {
                System.out.println("Por enquanto nao");
                gameOver();
            }
            System.out.println("....(procurando o livro nas estantes)");
            System.out.println("O que é esse papel amassado no chao?");
            System.out.println("Comandos disponiveis: Pegar o papel | Ignorar");
            strNext();
            if (pegaComando.equals("pegar")) {
                System.out.println("Wow é um projeto detalhado de um Foguete Espacial, quem deixaria isso aqui?"
                        + "\nBom vou guarda-lo e ir falar com o professor ??? se pode me ajudar.");
            } else {
                System.out.println("To nem ai. Vou pegar esse livro de Java e reprovar na prova mesmo!");
                gameOver();
            }
            //System.out.println("Bom acho que vou la procurar o professor ???.");}
            System.out.println("Comandos disponiveis: Praca01 de alimentacao | Sala de Aula");
            strNext();
            if (pegaComando.equals("praca01")) {
                pracaAlimentacao1();
            } else {
                salaDeAula();
            }
        }
    }

    //template pra progresso do jogo 
    /*if(progrssoJogo == 0){

} else if(progressoJogo == 1){

} else if(progressoJogo == 2){

} else if(progressoJogo == 3){

} else if(progressoJogo == 4){

} else if(progressoJogo == 5){

} else if(progressoJogo == 6){

} else if(progressoJogo == 7){

} else{}*/
    //passar array pra lista 
    static void perguntaMedia() {
        int tentativas = 3;
        String perguntas[] = {"Converta:    xxx101xxx100xxx(base 2) = 7x3x1(base 8)", "Para executar o conteúdo de array:\n char vogais[] = {'a','e','i','o','u'} \no certo seria: "},
                respostasMedias[][] = {{"000 100 010 111 011 = 74321", "111 101 011 100 001 = 75341", "111 110 101 100 011 = 76351", "111 010 011 110 001 = 72361"},
                {"Do { print(vogais[contador]); contador++} while (contador<5);", "for (long letra = 0; letra > vogais.lenght; i--)",
                    "while (contador < 5) {print(vogais[contador]; contador--;", "for (char item : vogais { println(vogais[item]);} "}};
        char corretaMedias[] = {'b', 'd'};
        int rnd = randomico.nextInt(perguntas.length);

        System.out.println(perguntas[rnd] + ":");  //imprime a pergunta e as respostas possiveis de acordo com o numero randomico gerado
        System.out.println("a)" + respostasMedias[rnd][0]);
        System.out.println("b)" + respostasMedias[rnd][1]);
        System.out.println("c)" + respostasMedias[rnd][2]);
        System.out.println("d)" + respostasMedias[rnd][3]);
        do {
            System.out.println("Voce tem " + tentativas + " tentativas"); //diminui as tentativas de resposta caso responder errado
            charNext();
            if (resposta != corretaMedias[rnd]) {
                System.out.println("Voce errou tente denovo!");
                tentativas--;
            }
        } while (resposta != corretaMedias[rnd] && tentativas > 0);
        if (resposta == corretaMedias[rnd]) { //colocar uma funçao para a resposta CERTA 
            System.out.println("resposta certa");
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
            charNext();
            if (resposta == 's') {
                perguntaMedia();
            }
        }
    }

    public static void perguntaFacil() {
        int tentativas = 3;// numero de tentativas para acertar a pergunta e conseguir progredir
        String perguntas[] = {"O conjunto {x " + (char) 8712 + " R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo", //vetor das perguntas
            "O número 255 na base decimal, pode ser representado, respectivamente, nas bases Binária, Octal e Hexadecimal por",
            "Quantos bits há em 2 bytes", "A expressão (a-b)³ pode ser representada por",
            " Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é: "},
                respostasFaceis[][] = {{"[ 10/4 ; 15 ]", "[ 2,5 ; 15 [", "] 10/4 ; 15 ]", "] 2,5 ; 15 ["}, //matriz de respostas das perguntas
                {"01100110, 356 ,EE", "00001111, 380, EF", "11111111, 377, FF", "11110000, 374, FE"},
                {"8", "16", "32", "64"}, {"a³ - 3a³b + 3ab³ - b³", "a³ + 3a³b + 3ab³ + b³", "a³ - 3a³b - 3ab³ - b³", "a³ - 3a³b - 3ab³ + b³"},
                {" while ", " if ", " do while ", " for "}};
        char corretaFaceis[] = {'c', 'c', 'b', 'a', 'd'}; //vetor de verificação das respostas
        int rnd = randomico.nextInt(perguntas.length); // gera um numero para randomizar as perguntas perguntas

        System.out.println(perguntas[rnd] + ":"); //imprime a pergunta e as respostas possiveis de acordo com o numero randomico gerado
        System.out.println("a)" + respostasFaceis[rnd][0]);
        System.out.println("b)" + respostasFaceis[rnd][1]);
        System.out.println("c)" + respostasFaceis[rnd][2]);
        System.out.println("d)" + respostasFaceis[rnd][3]);
        do {
            System.out.println("Voce tem " + tentativas + " tentativas"); //diminui as tentativas de resposta caso responder errado
            charNext();
            if (resposta != corretaFaceis[rnd]) {
                System.out.println("Voce errou tente denovo!");
                tentativas--;
            }
        } while (resposta != corretaFaceis[rnd] && tentativas > 0);
        if (resposta == corretaFaceis[rnd]) { //colocar uma funçao para a resposta CERTA 
            System.out.println("resposta certa");
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
            charNext();
            if (resposta == 's') {
                perguntaFacil();
            }
        }
    }
// talvez nem precise da funcao abaixo

    static void perguntasAcertadas(String perguntas[], String respostas[], char corretas[]) { //tem a finalidade de guardar as perguntas acertadas, para nao se repetirem

    }

    public static void pracaAlimentacao1() {
        System.out.println("\n====================\n" + salaAtual("praca01"));
        if (progressoJogo == 0) {
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
        } else if (progressoJogo == 1) {

        } else if (progressoJogo == 2) {

        } else if (progressoJogo == 3) {

        } else if (progressoJogo == 4) {

        } else if (progressoJogo == 5) {

        } else if (progressoJogo == 6) {

        } else if (progressoJogo == 7) {

        } else {
        }

    }

    static void salaDeAula() {
        if (progressoJogo == 0) {

        } else if (progressoJogo == 1) {

        } else if (progressoJogo == 2) {

        } else if (progressoJogo == 3) {

        } else if (progressoJogo == 4) {

        } else if (progressoJogo == 5) {

        } else if (progressoJogo == 6) {

        } else if (progressoJogo == 7) {

        } else {
        }

    }

    static String salaAtual(String sala) { // vai trocar o nome da sala ( e talvez as imagens de cada uma )
        switch (sala) {
            case "labMec":
                sala = "Laboratorio de Mecanica";
                break;
            case "labDesign":
                sala = "Laboratorio de Design";
                break;
            case "praca01":
                sala = "Praca de Alimentacao 01";
                break;
            case "praca02":
                sala = "Praca de Alimentacao 02";
                break;
            case "biblioteca":
                sala = "Biblioteca Senac";
                break;
            case "sala01":
                sala = "Sala";
                break;

        }
        return "Ambiente atual: " + sala;
    }

    public static void labMecanica() {
        senha = 0;
        System.out.println("\n====================\n" + salaAtual("labMec"));
        if (progressoJogo == 0) {
            System.out.println(nome + " : segunrança, preciso entrar no laboratório pra falar com o ");
            System.out.println(" professor Gilberto, voce poderia me passar a senha de acesso do laboratótio ? ");
            System.out.println(" Não posso te passar a senha, mas posso te dar algumas dicas:\n"
                    + " Ela é um numero de 4 digitos e estah* em binário: ");
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
                System.out.println(" Prof. Gilberto: muito bem " + nome + " , parece que voce me encontrou ");
                System.out.println(" como posso te ajudar ? ");
                System.out.println("disponiveis: pedir ajuda | perguntar se vai ter prova");
                sc.nextLine();
                strNext();
                if (pegaComando.equals("pedir")) {
                    System.out.println(nome + " estou precisando de peças para montar meu projeto espacial ");
                    System.out.println(" creio que o senhor poderia me ajudar ");
                    System.out.println(" Prof. Gilberto: posso te ajudar sim " + nome + " porém voce terá ");
                    System.out.println(" de me responder uma pergunta. Voce está de acordo? ");
                    System.out.println("Comandos Disponiveis: S | N");
                    charNext();
                    if (resposta == 's') {
                        perguntaFacil();
                    } else {
                        gameOver();
                    }
                    System.out.println(" Parabéns " + nome + " com essa resposta certa voce ganha um item para o seu projeto ");

                } else if (pegaComando.equals("perguntar")) {
                    System.out.println(nome + "Vai ter prova?");
                    System.out.println("Prof. Gilberto: Vai sim, (completar com alguma materia aqui)");
                    System.out.println("Você está com dúvida na matéria?");
                    System.out.println("Disponíveis: S | N");
                    charNext();
                    if (resposta == 's') {
                        System.out.println("Sim, não entendi nada.");
                    } //continuar
                    else {
                        System.out.println("Que nada, queria mesmo falar desse projeto que achei.");
                    }
                    //continuar
                }
            }
        } else if (progressoJogo == 1) {

        } else if (progressoJogo == 2) {

        } else if (progressoJogo == 3) {

        } else if (progressoJogo == 4) {

        } else if (progressoJogo == 5) {

        } else if (progressoJogo == 6) {

        } else if (progressoJogo == 7) {

        } else {
        }
    }

    public static void pracaAlimentacao2() {
        System.out.println("\n====================\n" + salaAtual("praca02"));
        if (progressoJogo == 0) {
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
        } else if (progressoJogo == 1) {

        } else if (progressoJogo == 2) {

        } else if (progressoJogo == 3) {

        } else if (progressoJogo == 4) {

        } else if (progressoJogo == 5) {

        } else if (progressoJogo == 6) {

        } else if (progressoJogo == 7) {

        } else {
        }
    }

    public static void labDesign() {
        System.out.println("\n====================\n" + salaAtual("labDesign"));
    }

    static char charNext() {
        resposta = sc.next().toLowerCase().charAt(0);
        sc.nextLine();
        return resposta;
    }

    public static String strNext() {
        pegaComando = sc.nextLine().toLowerCase();
        return pegaComando;
    }

    public static void gameOver() {
        System.out.println("Voce desistiu do projeto, PERDEU");
        System.exit(1);
    }

    //implementar imagem ascii
    public static void salavazia() {

    }

    public static void menu() {
        System.out.println("      Beyond the earth   \n"
                + "\n --------------------------"
                + "\n|       --> Menu <--       |"
                + "\n| 1- Instruções            |"
                + "\n| 2- Jogar                 |"
                + "\n| 3- Ir para o fim do jogo |"
                + "\n| 4- Créditos              |"
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
                    inicioGame();
                } else {
                    menu();
                }
                break;
            case 2:
                inicioGame();
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
