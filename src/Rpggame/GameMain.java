package Rpggame;

import static Rpggame.RPGGame.gameOver;
import static Rpggame.RPGGame.menu;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

public class GameMain {

    //Aprendizagem 
    static boolean gravidade0 = false;
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
        System.out.println("\n\n======================================================================================================================\n");
        System.out.println("Voce esta chegando na universidade Senac, e agora sua aventura comeca ...\n\n");
        System.out.println("Ao chegar no Senac, um dos Seguranças quer falar com você.");
        System.out.println("Segurança do Senac: Bom dia, jovem estudante! Como se chama?");
        sc.nextLine();
        nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        //tutorial pro player aprender alguns comandos
        System.out.println("Seja bem-vindo ao Senac, " + nome + "! Ficou sabendo do concurso que irá acontecer aqui no campus? Dirija-se até a biblioteca para saber mais!");
        comandosDisponiveis(1, "vou para a Sala", "bibliotca", "", "");
        if (resposta == 'a') {
            System.out.printf("%s: Obrigado por avisar, mas estou atrasado para a aula. Depois eu vou! \n", nome);
            System.out.println("Segurança do Senac: Tudo bem! Boa aula!");
            strNext();
            salavazia();
        } else if (resposta == 'b') {
            System.out.println("Vou lá dar uma olhada. Aí eu aproveito e pego um livro que o professor recomendou. Obrigado!");
            strNext();
            biblioteca();
        }
    }

    static void comandosDisponiveis(int op, String t1, String t2, String t3, String t4) {//funçao para mostrar ao usuario a quantidade de opçoes diponiveis no momento
        String disponiveis = "";
        if (t2.equals("")) {
            disponiveis = "a) " + t1;
        } else if (t3.equals("")) {
            disponiveis = "a) " + t1 + " | b) " + t2;
        } else if (t4.equals("")) {
            disponiveis = "a) " + t1 + " | b) " + t2 + " | c) " + t3;
        } else {
            disponiveis = "a) " + t1 + " | b) " + t2 + " | c) " + t3 + " | d) " + t4;
        }
        System.out.println("Comandos Disponíveis: " + disponiveis);
        verificaComando(op);
    }

    static char verificaComando(int op) {// 1 para respostas a, b ,c ,d   2 para s, n.  \ para finalizar o programa
        //comandosDisponiveis(t1, t2, t3, t4);
        //char[] comandos = {'a', 'b', 'c', 'd'}, comandosSN = {'s', 'n'};
        charNext();//le o comando do usuario
        if (resposta == '\\') {//para o comando \ funcionar precisa de duas(\\), \ é um escape character, com 2 eles se cancelam
            System.exit(1);//termina o programa
        }
        switch (op) {// diferencia entre as opçoes de salas ou açoes do usuario, das opçoes de escolhas entre sim ou nao
            case 1://escolhas de opçoes ou salas
                while (resposta != 'a' && resposta != 'b' && resposta != 'c' && resposta != 'd') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
            case 2://escolhas sim ou nao
                while (resposta != 's' && resposta != 'n') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
        }
        return resposta;//retorna o input do usuario
    }

    static void biblioteca() {
        System.out.println("\n==============================\n" + salaAtual("biblioteca") + "\n");
        if (progressoJogo == 0) {
            System.out.println("Você chega na biblioteca e logo percebe outros alunos conversando sobre projetos para o Concurso...");
            comandosDisponiveis(1, "Conversar com a balconista", "Sair da Biblioteca", "Procurar o livro", "");
            if (resposta == 'b') {
                gameOver();
            } else if (resposta == 'c') {
                System.out.println(nome + ": Onde vou achar esse livro de Java?");
                System.out.println("Talvez devesse ver sobre o concurso...");
            }
            //sc.nextLine();
            System.out.print(nome + ": O que é esse concurso?");
            strNext();
            System.out.print("Balconista: Quem se inscrever tem que fazer um projeto sobre atividades fora da Terra, como: "
                    + "viagens espaciais, atividades de pesquisa, ou evolução tecnológica!");
            strNext();
            System.out.print("Por exemplo, alguns alunos ja pensaram "
                    + "em criar cidades-bolha, casas ou edifícios em outros planetas, carros flutuantes, robôs operários,"
                    + "\nsuper proteses, entre outros. E voce, vai participar?\n");
            comandosDisponiveis(2, "S", "N", "", "");
            if (resposta == 'n') {
                System.out.println("Por enquanto nao");
                gameOver();
            }
            System.out.print("Gostei muito da ideia, mas nao sei ainda o que fazer, vou pensar mais! "
                    + "Agora preciso pegar o livro que o professor pediu!");
            strNext();
            System.out.print("....(procurando o livro nas estantes)");
            strNext();
            System.out.print("O que é esse papel amassado no chao?");
            comandosDisponiveis(1, "Pegar o papel", "Ignorar", "", "");
            if (resposta == 'a') {
                System.out.print("Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?");
                strNext();
                System.out.print("Bom, vou guardar... Quem sabe não será útil mais tarde?!\n");
            } else {
                System.out.print("To nem ai. Vou pegar esse livro de Java e ir para a prova mesmo!");
                gameOver();
            }
        }
        comandosDisponiveis(1, "Praça de alimentação 1", "Sala de Aula", "", "");
        if (resposta == 'a') {
            pracaAlimentacao1();
        } else if (resposta == 'b') {
            nasa();
        } else if (progressoJogo == 1) {
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
    /**
     *
     */
    public static void perguntaMedia() {
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
                labDesign();
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
            case "labDesign":
                sala = "Laboratorio de Design";
                break;
            case "praca01":
                sala = "Praca de Alimentacao 01";
                break;
            case "centroesportivo":
                sala = "centroesportivo";
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

    public static void labDesign() {
        senha = 0;
        System.out.println("\n====================\n" + salaAtual("labDesign"));
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
                        pracaAlimentacao3();
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

    static void corredor() {
        if (progressoJogo == 0) {
            //tem q arrumar essa bagaça aqui 
        //if (pegaComando.equals("p1") || pegaComando.equals("sala")) {
            System.out.println(nome + "Bom, pensando bem ... é um foguete."
                    + "\nAcho que vou conseguir mais informações no laboratório de mecanica\n"
                    + "Olá meu nome é " + nome + " estou procurando o professor de mecanica"
                    + "\nAmanda : Olá eu sou Amanda muito prazer , você esta atras do professor Claudio ele fica naquela sala "
                    + "\nvem comigo ...");
            System.out.println(" O que você tem em mãos ? posso ver ? ");
            System.out.println(" comandos disponiveis  s | n ");
            if (pegaComando.equals("s")) {
                System.out.println(" voce mostrou seu projeto, tente não mostrar novamente ");
                System.out.println(" Amanda é uma boa pessoa, tome cuidado com quem ve seu projeto ");
                System.out.println(" Amanda : É um projeto completo de um foguete com motor de fusão nuclear ");
                System.out.println(" Você vai montar isso S|N ? ");
                if (pegaComando.equals("s")) {
                    System.out.println(" vou sim ");
                } else {
                    System.out.println(" calma ai, não nos conhecemos direito ainda ");
                }
            }
        //}
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

    public static void pracaAlimentacao3() {
        System.out.println("\n====================\n" + salaAtual("praca02"));
        if (progressoJogo == 0) {
            System.out.println(" André: fala " + nome + " fiquei sabendo que voce está ");
            System.out.println(" participando do projeto espacial, o que voce está fazendo ? ");
            System.out.println(nome + " : não posso contar de jeito nenhum. ");
            System.out.println(" André: o que é isso no seu bolso ? (pega o projeto e sai correndo) ");
            System.out.println(nome + " : voce pegou meu projeto devolva agora ");
            System.out.println(" Só se voce me pagar um lanche ");
            System.out.println(" Deseja pagar um lanche para ter seu projeto de volta ? Sim (S) | Não (N) ");
            charNext();
            if (pegaComando.equals("S")) {
                System.out.println(" Conseguiu seu projeto de volta ");
                nasa();
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

    public static void nasa() {
        System.out.println("\n====================\n" + salaAtual("labDesign"));
        if (progressoJogo == 0) {
            System.out.println(nome + " Preciso usar um dos computadores para  ");
            System.out.println(" fazer uma pesquisa para meu projeto ");
            System.out.println(" parece que não estou conseguindo ligar ");
            System.out.println(" Eduardo: tirei o cabo de enrgia do seu computador ");
            System.out.println(" Voce vai ter que me ajudar pra ter de volta");
            System.out.println(nome + " O que voce precisa? ");
            System.out.println(" Eduardo: preciso de uma dica para meu projeto ");
            System.out.println(" Dar a dica | Não dar a dica ");
            if (pegaComando.equals("Sim")) {
                System.out.println(" Voce conseguiu ligar o computador ");
                System.out.println(nome + " agora só estudar ");
                sala2();
            } else {
                System.out.println(" Não conseguiu ligar o computador ");
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

    static void sala2() {
        //boolean ganhou = false;   
        System.out.println(nome + " Olá professor, hoje que voce vai passar um questionario ");
        System.out.println(" Isso mesmo, senta ai que já vou passar a pergunta ");
        perguntaFacil();
        //return ganhou;  
    }

    // O jogador vai fazer treinamentos de gravidade 0 na piscina
    public static void centroEsportivo() {
        System.out.println("Você está agora no centro esportivo :"
                + "\nprocure Paula, ela terá uma tarefa para você "
                + "\n\nAções disponiveis  | procurar paula | sair |");
        strNext();
        if (pegaComando.equals("procurar paula")) {
            System.out.println("Paula - Olá " + nome + " veio fazer o treinamento de gravidade 0 ?"
                    + "\nbom então vamos lá");
            try {
                Thread.sleep(1000);
                System.out.println("Pronto, agora você está preparado para gravidade 0");
            } catch (InterruptedException ex) {
                Logger.getLogger(GameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pegaComando.equals("sair")) {
            System.out.println("Onde deseja ir ? "
                    + "\nlugares disponiveis  | lab mecanica");
            strNext();
            if (pegaComando.equals("lab mecanica")) {
                salaAtual("labMec");
            }

        }

    }

    //Aqui é onde o player vai desenvolver comida em tubo
    static void centroGastronomico() {

        String inventario[] = new String[5];

        System.out.println("Você chegou no centro gastronomico ");
        System.out.println("Aqui voce ira conseguir comida desidratada para levara para o espaço ");
        System.out.println(" Coloque no cesto 5 alimentos que voce acha fundamental levar ");

        for (int i = 0; i < inventario.length; i++) {

            System.out.println(" Coloque o alimento: ");
            inventario[i] = strNext();

        }

    }

    //Area de lançamento
    static void Teletubbies() {

    }

    static char charNext() {//pega o input do usuario em todas as partes do jogo
        resposta = sc.next().toLowerCase().charAt(0);
        sc.nextLine();
        return resposta;
    }

    public static String strNext() {//pega o input do usuario em todas as partes do jogo que nao sejam opçoes e mais de um caractere, e serve de pausa do dialogo
        pegaComando = sc.nextLine().toLowerCase();
        return pegaComando;
    }

    public static void gameOver() {//mostra q o usuario perdeu
        System.out.println("Voce desistiu do projeto, PERDEU");
        System.exit(1);//termina o programa
    }

    public static void salavazia() {//uma das salas iniciais para mostrar o caminho ao player caso ele nao vá ao lugar certo
        System.out.println("=====================================\n");
        System.out.print("Você chega na sala e não tem ninguém, só o professor...");
        strNext();
        System.out.printf("%s: Com licença, é aqui a sala de TADS?", nome);
        strNext();
        System.out.print("Alexandre: É sim! Mas os alunos estão na biblioteca pegando o livro que pedi e vendo informações sobre o concurso que vai ter no Campus.");
        strNext();
        System.out.printf("%s: O segurança me falou sobre esse concurso, vou lá dar uma olhada!\n", nome);
        comandosDisponiveis(1, "Ir agora?", "ficar e falar com o prof?", "", "");
        if (resposta == 'a') {
            strNext();
        } else if (resposta == 'b') {
            System.out.print(nome + ": Já sei Java, vou ficar aqui até eles chegarem.");
            sc.nextLine();
            strNext();
            System.out.print("Alexandre: Beleza então, abre o NetBeans ai e me faz um clone do Whatsapp ai.");
            strNext();
            System.out.println("Alexandre: Se não conseguir, já está reprovado. Ou prefere ir na biblioteca?");
            comandosDisponiveis(1, "Biblioteca", "", "", "");
        }
        System.out.print(nome + ": Acho que vou lá mesmo...");
        strNext();
        System.out.print("Alexandre: Pode ir! Só não esqueça do livro, o nome do livro é 'Java para Iniciantes'.");
        strNext();
        System.out.printf("%s: Pode deixar, obrigado!", nome);
        strNext();
        biblioteca();
    }

    public static void menu() {//menu inicial responsavel por apresentar opçoes ao usuario
        System.out.println("      Beyond the earth   "
                + "\n --------------------------"
                + "\n|       --> Menu <--       |"
                + "\n| 1- Instruções            |"
                + "\n| 2- Jogar                 |"
                + "\n| 3- Ir para o fim do jogo |"
                + "\n| 4- Créditos              |"
                + "\n| 5- Sair                  |"
                + "\n --------------------------");

        int option = sc.nextInt();
        switch (option) {//decide qual foi o comando do usuario
            case 1:
                instrucoes();
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
                break;
        }
    }

    public static void instrucoes() {//funcao que ensina o basico para o usuario
        System.out.println("================================  Instruções  ================================\n"
                + "Para conseguir jogar, voce deve digitar um dos COMANDOS DISPONÍVEIS "
                + "para interagir com ações ou mudando de salas. \nPor exemplo, se aparecer:  \nComandos Disponíveis: a) Pegar item | b) Biblioteca\n"
                + "Você pode digitar apenas 'a' para executar a ação, ou 'b' para se dirigir até a sala.\n"
                + "E para o desenvolvimento dos diálogos basta apertar ENTER sempre ao final da fala do personagem.\n"
                + "Você pode também digitar '\\' para finalizar o programa.\n"
                + "Vamos testar se você entendeu.");
        sc.nextLine();
        do {//pequena verificaçao para o usuario estar apto a continuar
            comandosDisponiveis(1, "Jogar", "Voltar ao menu", "", "");
            charNext();
            if (resposta == 'a') {
                System.out.println("Vamos começar nossa aventura!");
                inicioGame();
            } else if (resposta == 'b') {
                menu();
            } else {
                System.out.println("Comando inválido.\n");
            }
        } while (resposta != 'a' && resposta != 'b');
    }

}
