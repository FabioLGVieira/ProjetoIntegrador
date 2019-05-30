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
        {"", "", "", "", ""}, //vetor para guardar comidas escolhidas pelo player
        {}};

        entradaCampus(escolhasJogo);
        nasa(escolhasJogo);
        caixaDagua(escolhasJogo);//pergunta adm

        nasa(escolhasJogo);
        estacionamento(escolhasJogo);//pergunta matematica

        nasa(escolhasJogo);
        cuboSenac(escolhasJogo);// pergunta conceitos

        nasa(escolhasJogo);
        cit(escolhasJogo);//pergunta prog/alg

        nasa(escolhasJogo);
        praca01(escolhasJogo);//pergunta prog/alg
        //fim
    }

    static boolean nasa(String[][] v) {
        System.out.println(ambienteAtual("nasa"));  // e ela da a resposta da proxima peça
        System.out.println("Crug'Oto: Ei! Você ai, Você mesmo! A I.A. que eu criei me disse que viria! Dei o nome de SAVVY");
        System.out.println("Tenho problema de memória, criei ela pra me lembrar do que fazer. Então sempre deve me dizer o próximo passo.");
        System.out.println("Pergunte algo pra ela. E a resposta esclarecerá suas duvidas!");
        switch (v[0][1]) {
            case "0": // peça 1 tanque de combustivel
                comandosDisponiveis(2, "O que precisa fazer?", "O que aconteceu com o planeta de vocês?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Seu destino é ir até a caixa d'agua e obter o tanque com combustível.");
                } else {
                    System.out.println("O que aconteceu com o planeta de vocês?");
                    System.out.println("Crug'Oto: Não tem hamburguer. E adoramos Hamburguer.");
                    System.out.println("SAVVY: Já está na hora de ir pra caixa d'agua.");
                }
                comandosDisponiveis(1, "Ir para a Caixa D'agua");
                break;
            case "1": // peça 2 fuselagem
                comandosDisponiveis(2, "Qual o próximo passo?", "Por que Hamburguer?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Vá para o estacionamento.");
                } else {
                    System.out.println("Crug'Oto: Porque não tem nada melhor que Hamburguer no Universo.");
                    System.out.println(/*v[0][0] + ": Concordo plenamente, mas qual o meu próximo passo?"*/);
                    System.out.println("SAVVY: Tudo pronto? Vamos. Recalculando rota...");
                }
                comandosDisponiveis(1, "Ir para o estacionamento");
                break;
            case "2": //peça 3 turbina
                comandosDisponiveis(2, "O que tenho que fazer agora?", "Como vocês se comunicam entre si?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Você deve falar com alguém perto do Objeto Quadrado");
                } else {
                    System.out.println("Crug'Oto: Com esse colar de Onion Rings que usamos.");
                    System.out.println("É parecido com essa coisa que vocês chamam de celular.");
                    System.out.println("SAVVY: Você deve falar com alguém perto do Objeto Quadrado");
                }
                comandosDisponiveis(1, "Ir para o Cubo");
                break;
            case "3": // peça 4 modulo comando
                comandosDisponiveis(2, "Qual a próxima tarefa?", "Quero visitar o planeta de vocês!");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Vá programar o Computador de Bordo");
                } else {
                    System.out.println("Crug'Oto: Vou pensar no seu caso humano.");
                    System.out.println("");
                    System.out.println("SAVVY: Vá programar o Computador de Bordo");
                }
                comandosDisponiveis(1, "Ir para o Centro de Inovações");
                break;
            case "4": // peça 5 comida
                comandosDisponiveis(2, "Falta muito pra completar a missão?", "Vocês vão ficar aqui para sempre?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Você deve fazer Hamburguers para a raça superior");
                } else {
                    System.out.println("Crug'Oto: Sim, mas nós vamos buscar o resto do nosso povo.");
                    System.out.println("Como posso ajudar voces agor?");
                    System.out.println("SAVVY: Você deve fazer Hamburguers para a raça superior");
                }
                comandosDisponiveis(1, "Ir para a Praça de Alimentação 01");
                break;
        }
        return false;
    }

    static boolean entradaCampus(String[][] v) {
        System.out.println(ambienteAtual("entrada"));
        String[] falas = {"Hanbägä wa piza yori mo sugurete ori, bëkon wa jinseidesu", "Bisuketto ka Borasha?", "Burubasaūru, chāmuanda ka fanshutsu?",
            "Ruuku, anata no otōsan im", "è vedere o mangiare"};
        int rnd = randomico.nextInt(falas.length);
        String[] d1 = {"O que eu to fazendo no Senac? Eu estava em casa até agora... ", "[...ouve alguem falando alguma coisa longe] "};
        imprimirTexto(d1);
        System.out.println(falas[rnd]);
        System.out.println("[...ao se aproximar, se assusta por ser um Alienigena!] ");
        System.out.println("ET: Saudações terráqueo, como voce se chama? ");
        v[0][0] = verificaNome();
        String[] d2 = {"Mas o que ta acontecendo?!?!? Por que eu consigo te entender? ",
            "ET: Somos muito mais evoluidos que voces, nao precisa mais me dizer seu nome, a Cebola Mágica do meu povo ja me revelou, " + v[0][0],
            v[0][0] + ": Que cebola? por que eu to falando com um ET? E o pior, ele eu entendo o idioma dele ", "ET: Nao temos tempo para ficar respondendo perguntas tolas! ",
            "Seu destino é nos ajudar e montar nosso foguete para buscarmos o resto de nosso povo e viver comendo Hamburguers neste planeta inferior. ", "Fale com Crug'Oto para descobrir o que precisa fazer ",
            "Vá reto neste corredor e vire a direita, ande logo, ele está te esperando! "};
        imprimirTexto(d2);
        //complementar com algo?
        return false;
    }

    static boolean cuboSenac(String[][] v) {
        System.out.println(ambienteAtual("cubo"));
        String[] d1 = {v[0][0] + ":Hey Et desculpe atrapalhar sua meditação, mas Crug'Oto falou pra eu vir aqui",
            "Como voce se chama?", "Sindri: não estou sabendo disso, mas como posso te ajudar? Meu nome é Sindri e já vi o seu no"
            + " colar de cebola", v[0][0] + " Não sei, mas estou cumprindo uma missão pra voces ", " [...] Sindri volta a meditar ",
            " Sindri: vizualizei sua tarefa atraves da meditação, mas voce tem de me provar do que é capaz ",
            v[0][0] + " sou capaz de tudo ", "Sindri: responda - me uma pergunta em caso de acerto voce "
            + "ganha um item a mais para sua missão "};
        imprimirTexto(d1);
        chamarPergunta('m', v);
        return false;
    }

    static boolean caixaDagua(String[][] v) {
        System.out.println(ambienteAtual("cubo"));
        System.out.println("Gunnhildur: O que você quer terráqueo?");
        System.out.println(v[0][0] + ": Falaram que eu devia vir aqui.");
        //completar com algo rapido
        System.out.println("Gunnhildur: Eu só irei te ajudar se você me mostrar seu valor respondendo uma pergunta.");
        System.out.println(v[0][0] + "Manda vê.");
        System.out.println("Muito confiante para um simples terráqueo, lá vai...");
        chamarPergunta('a', v);
        System.out.println("Gunnhildur: Argh, tudo bem, você provou seu valor, aqui está leve este tanque de [algo] ela será útil para cumprir sua missão");
        System.out.println("Agora vá até Crug'Oto denovo para saber seu destino");
        return false;
    }

    static boolean estacionamento(String[][] v) {
        System.out.println(ambienteAtual("estacionamento"));
        String[] d1 = {"[...] Voce chega ao estacionamento e não ve ninguem, mas de repente escuta um barulho vindo de um carro parado e um et com roupas "
            + " e mecanico e ferramentas na mão se aproximando"};
        imprimirTexto(d1);
        String[] d2 = {"Brynhildur: acho que é voce mesmo que Crug'Oto enviou, não precisa dizer seu nome, que já sei e já sei como posso te ajudar, eu me chamo Brynhildur"
            + "acabei de conseguir o que voce precisa em uma dessas porcarias de naves espaciais terrestres que aparentemente não voam, mas"
            + "para conseguir este item voce terá de me provar sua inteligencia respondendo uma pergunta ", v[0][0] + ": sou capaz de tudo, manda a pergunta ai "};
        imprimirTexto(d2);
        chamarPergunta('c', v);
        return false;
    }

    static boolean cit(String[][] v) {
        System.out.println(ambienteAtual("cit"));
        String[] d1 = {"[...]Voce chega ao centro de inovação tecnologica e ve um Et com trajes de Nerd usando um dos computadores"};
        imprimirTexto(d1);
        String[] d2 = {"Garpur: como posso te ajudar? Alias, meu nome é Garpur", v[0][0] + ": Crug'Oto me falou pra vir até aqui falar com voce",
            "Garpur: Espere eu terminar de jogar uma partida deste jogo que já te atendo", "[...] esperando o Et terminar o jogo",
            "Garpur: terminei a partida aqui, pelo que vi em meu colar de cebola voce foi o escolhido para nos ajudar a montar "
            + "nosso foguete, certo " + v[0][0], v[0][0] + ": fui eu sim", "Garpur: aqui voce vai conseguir seu computador de bordo, "
            + "me ajude a desvendar esse enigma que te dou o item "};
        imprimirTexto(d2);
        chamarPergunta('p', v);
        return false;
    }

    static boolean praca01(String[][] v) {
        System.out.println(ambienteAtual("praca01"));
        String[] d1 = {"[...]Voce vai a praça de alimentação a procura de alguma coisa para comer, chega na cantina e tem um Et no balcão"
            + "e em seu cracha escrito Sunna"};
        imprimirTexto(d1);
        String[] d2 = {"Sunna: olá terraqueo, como posso ajudar? "};
        chamarPergunta('p', v);
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
                {{"Qual destes abaixo é o teorico responsavel pela Teoria da burocracia "}, {"Henry Ford", "Max Weber", "Frederick Taylor", "Elton Mayo"}, {"b"}},
                {{"Qual alternativa indica uma característica que, segundo Fayol, não faz parte da organização Formal."}, {"Divisão do Trabalho", "Hierarquia", "Autoridade", "Motivação"}, {"d"}}},//perguntas adm

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
                {"static String nome(){ return 7; }", "static String nome([]String s){ return s; }", "static String nome(){ return s; }", "static int nome(String[] s){ return s; }"}, {"c"}},
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

    public static void chamarPergunta(char materia, String[][] v) {
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
            int conversor = Integer.parseInt(v[0][1]); //recebe o valor da String como int
            conversor++; // acrescenta o ponto caso o player acerte
            v[0][1] = String.valueOf(conversor); // retorna o novo valor pra String
        } else {
            int conversor = Integer.parseInt(v[0][2]); //recebe o valor da String como int
            conversor++; // acrescenta o ponto na variavel 'inimiga' caso o player erre
            v[0][2] = String.valueOf(conversor); // retorna o novo valor pra String
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
            pulaLinha();
            if (resposta.equals("s")) {
                chamarPergunta(materia, v);
            }
        }
        verificaSituacaoJogo(v);
    }

    static String ambienteAtual(String sala) { // vai trocar o nome do ambiente ( e talvez as imagens de cada uma )
        switch (sala) {
            case "entrada":
                sala = "Entrada Principal";
                break;
            case "cit":
                sala = "Centro de Inovações Tecnológicas";
                break;
            case "praca01":
                sala = "Praca de Alimentação 01";
                break;
            case "estacionamento":
                sala = "Estacionamento";
                break;
            case "cubo":
                sala = "Cubo Senac";
                break;
            case "caixa":
                sala = "Caixa D'agua";
                break;
            case "nasa":
                sala = "Nasa";
                break;
        }
        return "\n===================================\nAmbiente atual: " + sala + "\n";
    }

    static void verificaSituacaoJogo(String[][] v) {
        if (v[0][1].equals("5")) {
            System.out.println(EndGame(1));
            System.exit(1);//termina o programa
        }
        if (v[0][2].equals("10")) {
            System.out.println(EndGame(2));
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

    static String verificaNome() {//verifica se o nome contem muitos espaços ou se começa com espaço ou é null
        String nome;
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
                fim = "Voce ajudou os Aliens a voltar para seu planeta, agora só falta ir para Beyond the Earth!";
                break;
            case 2:
                fim = "Parece que você não é tão inteligente quanto os Aliens pensaram... Você perdeu a oportunidade de viajar ao espaço.";
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
                //chamarPergunta('p');
                //verificaSituacaoJogo(); // apenas acelerar o teste, tirar futuramente
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
