package Rpggame;

import java.util.Random;
import java.util.Scanner;

public class BeyondTheEarth {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static String resposta;

    public static void main(String[] args) {
        menu();
    }

    public static void controlador() {
        String escolhasJogo[][] = {{"zz", "0", "0"}, //nome, progresso do player, progresso adversario
        {"f", "f", "f"}, //escolhas jogo  t = true     f = false
        {"", "", "", "", ""}, //vetor para guardar comidas escolhidas pelo player
        {}, //
        {},
        {},
        {}};
        
        entradaCampus(escolhasJogo);
        nasa(escolhasJogo);
        caixaDagua(escolhasJogo);
        
        nasa(escolhasJogo);
        estacionamento(escolhasJogo);
        
        nasa(escolhasJogo);
        cuboSenac(escolhasJogo);
        
        nasa(escolhasJogo);
        cit(escolhasJogo);
        
        nasa(escolhasJogo);
        praca01(escolhasJogo);
        //fim

    }

    static boolean nasa(String[][] v) {
        return false;
    }

    static boolean entradaCampus(String[][] v) {
        System.out.println("Hanbāgā wa jinseidesu");
        return false;
    }

    static boolean cuboSenac(String[][] v) {
        return false;
    }

    static boolean caixaDagua(String[][] v) {
        return false;
    }

    static boolean estacionamento(String[][] v) {
        return false;
    }

    static boolean cit(String[][] v) {
        return false;
    }

    static boolean praca01(String[][] v) {
        return false;
    }

    //static boolean nasa(String[][] v){ return false;}
    static String[][][] perguntas(char materia, String[][][] escolhida) {
        String[][][] matematica = {{{"O conjunto {x " + (char) 8712 + " R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo"}, //pergunta 1
        {"[ 10/4 ; 15 ]", "[ 2,5 ; 15 [", "] 10/4 ; 15 ]", "] 2,5 ; 15 ["}, {"c"}}, // resposta e resposta certa da 1
        {{"A expressão (a-b)³ pode ser representada por"},//pergunta 2
        {"a³ - 3a²b + 3ab² - b³", "a³ + 3a³b + 3ab³ + b³", "a³ - 3a³b - 3ab³ - b³", "a³ - 3a³b - 3ab³ + b³"}, {"a"}}, // resposta e resposta certa da 2
        {{"Uma Função do segundo grau, tem como elemento"},//pergunta 3
        {"Ondas senoidais", "Uma parábola que que passa 2 vezes no eixo Y", "Uma reta que nunca encosta no eixo X", "Até 2 raízes"}, {"d"}}, // resposta e resposta certa da 3
        {{"qual o valor de x que satisfaz a equação:\n  log1.000.000 = x   na base 10"},//pergunta 4
        {"10", "6", "5", "8"}, {"b"}},// resposta e resposta certa da 4
        {{"qual o resultado de   -|-(" + (char) 8730 + "64)|³"},//pergunta 5
        {"8", "-512", "64", "-256"}, {"b"}}},// resposta e resposta certa da 5   perguntas matematica

                adm = {{{"Quais os conceitos corretos da pirâmide de Maslow"},
                {"Salário e cargos elevados", "Higiênicos e Motivacionais", "Poder; Afiliação; Realização", "Fisiológicos; Segurança; Afetivo; Estima; Auto Realização"}, {"d"}},
                {{"O salário, os benefícios e as condições físicas e ambientais do trabalho são denominados fatores"},
                {"Intrínsecos", "Higiênicos", "Fisiológicos", "Igualdade"}, {"b"}},
                {{"Um bom líder é reconhecido por"}, {"Saber de tudo e ser melhor que os outros", "Dar ordens e não fazer nada", "Influenciar, motivar uma equipe e viver pelo exemplo", "Ter salário alto e automóveis caros"}, {"c"}},
                {{"1"}, {"a1", "b1", "c1", "d1"}, {"correta"}},
                {{"1"}, {"a1", "b1", "c1", "d1"}, {"correta"}}},//perguntas adm

                conceitos = {{{"o número 255 na base decimal, pode ser representado, respectivamente, nas bases Binária, Octal e Hexadecimal por"},
                {"01100110, 356 ,EE", "00001111, 380, EF", "11111111, 377, FF", "11110000, 374,FE"}, {"c"}},
                {{"Converta:    xxx101xxx100xxx(base 2) = 7x3x1(base 8)"},
                {"000 100 010 111 011 = 74321", "111 101 011 100 001 = 75341", "111 110 101 100 011 = 76351", "111 010 011 110 001 = 72361"}, {"b"}},
                {{"A expressão S = A . B . 'C . D + 'A . 'B . C . D + 'A . B . C .'D tem as seguintes entradas"},
                {"0 1 0 1   |   1 0 1 0   |   1 0 0 1", "1 1 1 0   |   0 1 0 1   |   1 1 0 0", "0 0 1 1   |   1 0 0 0   |   0 0 0 1", "1 1 0 1   |   0 0 1 1   |   0 1 1 0"}, {"d"}},
                {{"A saída da expressão S = A " + (char) 8857 + " B é"}, {"a1", "b1", "c1", "d1"}, {"a"}},
                {{"o número 15 na base decimal, convertido para base Hexadecimal é"},
                {"10", "F", "9", "B"}, {"b"}}}, // perguntas conceitos de computaçao

                prog = {{{"quantos bits há em 2 bytes"}, {"8", "16", "32", "64"}, {"b"}},
                {{"Sobre matriz, é correto dizer que"},
                {"a diagonal principal é uma / e não \\", "é uma variável primitiva", "é um vetor de vetores", "serve somente para valores int"}, {"c"}},
                {{"Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é"},
                {"while", "if", "do while", "for"}, {"d"}},
                {{"Qual das estruturas abaixo é mais adequada, para descobrir os elementos de uma matriz"},
                {"for", "do while", "while", "if"}, {"a"}},
                {{"Qual função está correta"}, {"static int nome(String s){ return s; }", "static String nome(String s){ return s; }", "static String nome(int n){ return true; }", "static boolean nome(char c){ return c; }"}, {"b"}},
                {{"Qual das alternativas abaixo representa a sintaxe correta"},
                {"static String nome(){ return \"S\"; }", "static String nome([]String s){ return s; }", "static String nome(){ return “s”; }", "static int nome(String[] s){ return s; }"}, {"c"}},
                {{"Em uma estrutura de repetição, o comando break tem a função de"},
                {"condicionar a execução de um comando de atribuição a um operador lógico", "segmentar a execução de um loop em duas ou mais partes aninhadas", "estabelecer um intervalo de depuração durante a execução de um loop", "interromper a execução do laço"}, {"d"}},
                {{"Na linguagem Java, os tipos primitivos são"},
                {"char, boolean, byte, short, int, long, float e double", "char, bool, int, byte, short, uint, long, float e double", "char, integer, double e float", "char, int, longint, float e double"}, {"a"}},
                {{"A memória heap"},
                {"É utilizada quando um objeto é criado no meio da execução", "guarda todos os dados do programa, independente de quais sejam", "é toda a memória RAM do dispositivo", "é uma pilha de funções"}, {"a"}},
                {{"Para executar o conteúdo de array: \n char vogais[] = {'a', 'e', 'i', 'o', 'u'}   o certo seria"},
                {"Do { print( vogais[contador] ); contador++ }while( contador<5 );", "for( long letra = 0; letra > vogais.length; i-- )", "while(contador < 5) { print(vogais[contador]; contador--; }", "for( chat item : vogais { print(vogais[item]); }"}, {"d"}}};
        //perguntas de algoritmos e programaçao
        int random;// inicia a varivavel randomica

        switch (materia) {
            case 'm':
                random = randomico.nextInt(matematica.length);//gera um numero numero random até a quantidade de perguntas do vetor
                escolhida[0][0][0] = matematica[random][0][0];//coloca a a pergunta no vetor
                escolhida[0][1] = matematica[random][1];      //coloca as respotas no vetor de respostas
                escolhida[0][2][0] = matematica[random][2][0];//coloca a resposta certa no vetor de verificação
                break;
            case 'a':
                random = randomico.nextInt(adm.length);//gera um numero numero random até a quantidade de perguntas do vetor
                escolhida[0][0][0] = adm[random][0][0];//coloca a a pergunta no vetor
                escolhida[0][1] = adm[random][1];      //coloca as respotas no vetor de respostas
                escolhida[0][2][0] = adm[random][2][0];//coloca a resposta certa no vetor de verificação
                break;
            case 'c':
                random = randomico.nextInt(conceitos.length);//gera um numero numero random até a quantidade de perguntas do vetor
                escolhida[0][0][0] = conceitos[random][0][0];//coloca a a pergunta no vetor
                escolhida[0][1] = conceitos[random][1];      //coloca as respotas no vetor de respostas
                escolhida[0][2][0] = conceitos[random][2][0];//coloca a resposta certa no vetor de verificação
                break;
            case 'p':
                random = randomico.nextInt(prog.length);//gera um numero numero random até a quantidade de perguntas do vetor
                escolhida[0][0][0] = prog[random][0][0];//coloca a a pergunta no vetor
                escolhida[0][1] = prog[random][1];      //coloca as respotas no vetor de respostas
                escolhida[0][2][0] = prog[random][2][0];//coloca a resposta certa no vetor de verificação
                break;
        }
        return escolhida;
    }

    public static void chamarPergunta(char materia) {
        String[][][] perguntaResposta = {{{""}, {"", "", "", ""}, {""}}};
        int tentativas = 3;// numero de tentativas para acertar a pergunta e conseguir progredir
        perguntas(materia, perguntaResposta);

        System.out.println(perguntaResposta[0][0][0] + ":"); //imprime a pergunta e as respostas possiveis de acordo com o numero randomico gerado
        System.out.println("a) " + perguntaResposta[0][1][0]);
        System.out.println("b) " + perguntaResposta[0][1][1]);
        System.out.println("c) " + perguntaResposta[0][1][2]);
        System.out.println("d) " + perguntaResposta[0][1][3]);
        do {
            System.out.println("Voce tem " + tentativas + " tentativas"); //diminui as tentativas de resposta caso responder errado
            strNext();
            if (!resposta.equals(perguntaResposta[0][2][0])) {
                System.out.println("Voce errou! Tente novamente.");
                tentativas--;
            }
        } while (!resposta.equals(perguntaResposta[0][2][0]) && tentativas > 0);
        if (resposta.equals(perguntaResposta[0][2][0])) {
            System.out.println("Resposta certa!");
            progressoPlayer++;
        } else {
            progressoAdversários++;
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
            pulaLinha();
            if (resposta.equals("s")) {
                chamarPergunta(materia);
            }
        }
        verificaSituacaoJogo();
    }

    static String ambienteAtual(String sala) { // vai trocar o nome do ambiente ( e talvez as imagens de cada uma )
        switch (sala) {
            case "entrada":
                sala = "Entrada Principal";
                break;
            case "labDesign":
                sala = "Laboratorio de Design";
                break;
            case "praca01":
                sala = "Praca de Alimentação 01";
                break;
            case "centroesportivo":
                sala = "Centro Esportivo";
                break;
            case "praca03":
                sala = "Praca de Alimentação 03";
                break;
            case "biblioteca":
                sala = "Biblioteca Senac";
                break;
            case "lab136":
                sala = "Lab. C136";
                break;
            case "corredor":
                sala = "Corredor";
                break;
            case "a125":
                sala = "Sala A125";
                break;
            case "labmecanica":
                sala = "Laborátorio de mecânica";
                break;
            case "nasa":
                sala = "Nasa";
                break;
        }
        return "\n===================================\nAmbiente atual: " + sala + "\n";
    }

    static void verificaSituacaoJogo(String[][] v) {
        if (progressoPlayer == 8) {
            System.out.println(EndGame(1));
            System.exit(1);//termina o programa
        }
        if (progressoAdversários == 10) {
            System.out.println(EndGame(3));
            System.exit(1);//termina o programa
        }
    }

    static void comandosDisponiveis(int op, String t1) {
        String disponiveis = "";
        disponiveis = "a) " + t1;
        System.out.println("Comando Disponível: " + disponiveis);
        verificaComando(op);
    }

    static void comandosDisponiveis(int op, String t1, String t2) {
        String disponiveis = "";
        disponiveis = "a) " + t1 + " | b) " + t2;
        System.out.println("Comandos Disponíveis: " + disponiveis);
        verificaComando(op);
    }

    static void comandosDisponiveis(int op, String t1, String t2, String t3) {
        String disponiveis = "";
        disponiveis = "a) " + t1 + " | b) " + t2 + " | c) " + t3;
        System.out.println("Comandos Disponíveis: " + disponiveis);
        verificaComando(op);
    }

    static void comandosDisponiveis(int op, String t1, String t2, String t3, String t4) {//funçao para mostrar ao usuario a quantidade de opçoes diponiveis no momento
        String disponiveis = "";
        disponiveis = "a) " + t1 + " | b) " + t2 + " | c) " + t3 + " | d) " + t4;
        System.out.println("Comandos Disponíveis: " + disponiveis);
        verificaComando(op);
    }

    static String verificaComando(int op) {// 1 para respostas a, b ,c ,d   2 para s, n.  \ para finalizar o programa
        strNext();//le o comando do usuario
        switch (op) {// diferencia entre as opçoes de salas ou açoes do usuario, das opçoes de escolhas entre sim ou nao
            case 1://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 1 )
                while (!resposta.equals("a")) {
                    System.out.println("Comando inválido.");
                    strNext();//le o comando do usuario
                }
                break;
            case 2://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 2 )
                while (!resposta.equals("a") && !resposta.equals("b")) {
                    System.out.println("Comando inválido.");
                    strNext();//le o comando do usuario
                }
                break;
            case 3://escolhas de opçoes ou salas                         opçao relativo a quantidade de opçoes disponiveis ( 3 )
                while (!resposta.equals("a") && !resposta.equals("b") && !resposta.equals("c")) {
                    System.out.println("Comando inválido.");
                    strNext();//le o comando do usuario
                }
                break;
            case 4://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 4 )
                while (!resposta.equals("a") && !resposta.equals("b") && !resposta.equals("b") && !resposta.equals("d")) {
                    System.out.println("Comando inválido.");
                    strNext();//le o comando do usuario
                }
                break;
        }
        return resposta;//retorna o input do usuario
    }

    static String verificaNome(String nome) {//verifica se o nome contem muitos espaços ou se começa com espaço ou é null
        do {
            System.out.println("[Digite seu nome...]");
            nome = sc.nextLine();
        } while (nome.isEmpty() || nome.equals("") || nome.charAt(0) == ' ');
        return nome;
    }

    static void imprimirTexto(String v[]) {//recebe o Vetor de Dialogo dos NPCs e imprime na tela
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            pulaLinha();
        }// strNext() serve como pausa entre uma frase e outra
    }

    static String pulaLinha() {
        String pula = sc.nextLine();
        if (pula.equals("\\"))//para o comando \ funcionar precisa de duas(\\), \ é um escape character, com 2 eles se cancelam
        {
            System.exit(1);//termina o programa
        }
        return pula;
    }

    public static String strNext() {//pega o input do usuario em todas as partes do jogo
        resposta = sc.nextLine().toLowerCase();
        if (resposta.equals("\\"))//para o comando \ funcionar precisa de duas(\\), \ é um escape character, com 2 eles se cancelam
        {
            System.exit(1);//termina o programa
        }
        return resposta;
    }

    static String EndGame(int op) {// casos de fim de jogo
        String fim = "";
        switch (op) {
            case 1:
                fim = "Voce apresentou o Projeto no Centro de Convençoes e ganhou o Concurso Espacial!! Agora, só falta ir para Beyond the Earth!";
                break;
            case 2:
                fim = "Voce desistiu do projeto, PERDEU";
                break;
            case 3:
                fim = "Parece que você demorou demais, seus colegas já apresentaram o projeto ganhador do Concurso Espacial.";
                break;
        }
        return fim;
    }

    public static void instrucoes() {//funcao que ensina o basico para o usuario
        System.out.println("================================  Instruções  ================================\n"
                + "Para conseguir jogar, voce deve digitar um dos COMANDOS DISPONÍVEIS "
                + "para interagir com ações ou mudando de salas. \nPor exemplo, se aparecer:  \nComandos Disponíveis: a) Pegar item | b) Biblioteca\n"
                + "Você pode digitar apenas 'a' para executar a ação, ou 'b' para se dirigir até a sala.\n"
                + "E para o desenvolvimento dos diálogos basta apertar ENTER sempre ao final da fala do personagem.\n"
                + "Você pode também digitar '\\' para finalizar o programa.\n"
                + "Vamos testar se você entendeu.");
        comandosDisponiveis(2, "Jogar", "Voltar ao menu");        //sc.nextLine();
        switch (resposta) {
            case "a":
                System.out.println("Vamos começar nossa aventura!");
                controlador();
                break;
            case "b":
                menu();
                break;
            //System.out.println("Comando inválido.\n");
            default:
                break;
        }
    }

    public static void menu() {//menu inicial responsavel por apresentar opçoes ao usuario
        String[] s = {"      Beyond the earth   ", "\n --------------------------", "\n|       --> Menu <--       |", "\n| 1- Instruções            |",
            "\n| 2- Jogar                 |", "\n| 3- Executar função       |\n| específica               |",
            "\n| 4- Créditos              |", "\n| 5- Sair                  |",
            "\n --------------------------\n"};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        int option = sc.nextInt();
        sc.nextLine();//IMPORTANTE: alguns .next come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        switch (option) {//decide qual foi o comando do usuario
            case 1:
                instrucoes();
                break;
            case 2:
                controlador();
                break;
            case 3:
                chamarPergunta('p');
                verificaSituacaoJogo(); // apenas acelerar o teste, tirar futuramente
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

}
