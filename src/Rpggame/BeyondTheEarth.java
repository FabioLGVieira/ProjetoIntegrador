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
        {}, //vetor para guardar coisas escolhidas pelo player
        {"f", "f"}};  //true or false  substitui a necessidade de variaveis globais de decisão

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
        fimDeJogo(escolhasJogo);
    }

    static void fimDeJogo(String[][] v) {
        System.out.println(ambienteAtual("entrada"));
        System.out.println("Gortwog: Já voltou humano? Cade as peças? Vamos logo, temos que buscar o resto de nosso povo!");
        System.out.println(v[0][0] + ": Consegui sim.");
        System.out.println("Gortwog: Muito bem.");
        if (v[2][0].equals("t")) {
            System.out.println("...enquanto meus soldados terminam de reparar a nave podemos conversar.");
            System.out.println("Crug'Oto me disse que você queria viajar conosco até nosso planeta...");
            System.out.println("Por você ter nos ajudado, irei permitir, mas não sei quanto tempo pode levar ou se você voltará para este planeta.");
            if (v[2][1].equals("t")) {
                System.out.println("Aqui está os items que deixou com Crug'Oto:");
                for (int i = 0; i < v[1].length - 1; i++) {
                    System.out.print(v[1][i] + ", ");
                }
                System.out.println(v[1][v[1].length - 1] + ".");
            }
            System.out.println("Gortwog: Agora que está pronta a Nave, podemos partir para nossa jornada.");
            v[0][1] = "fim1";
        } else {
            System.out.println("Gortwog: Seu destino foi cumprido humano, nós vamos deixa-los por enquanto.");
            System.out.println("Mas quando voltarmos, iremos escraviza-los a fazerem Hamburguers para nós por toda a Eternidade");
            v[0][1] = "fim2";
        }
        verificaSituacaoJogo(v);
    }

    static boolean nasa(String[][] v) {
        System.out.println(ambienteAtual("nasa"));  // e ela da a resposta da proxima peça
        String d[] = {"Crug'Oto: Eu sou Crug'Oto! Criei uma I.A. e dei o nome de SAVVY.", "Tenho problema de memória, Ela sempre me diz o devo fazer."};
        imprimirTexto(d);
        switch (v[0][1]) {
            case "0": // peça 1 tanque de combustivel
                System.out.println("Gortwog me disse que viria, vou deixar você usar a SAVVY para cumprir sua missão. Vamos lá, pergunte algo...");
                pulaLinha();
                comandosDisponiveis(2, "O que preciso fazer?", "O que aconteceu com o planeta de vocês?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Seu destino é ir até a caixa d'agua e obter o tanque com combustível.");
                } else {
                    String d2[] = {"Crug'Oto: Nós gostamos tanto de Hamburguer, que comemos todos que o planeta tinha.",
                        "Agora, viajamos por todo o universo atrás de Hamburgueres, e então chegamos aqui.", "SAVVY: Já está na hora de ir pra caixa d'agua."};
                    imprimirTexto(d2);
                }
                comandosDisponiveis(1, "Ir para a Caixa D'agua");
                break;
            case "1": // peça 2 fuselagem
                comandosDisponiveis(2, "Qual o próximo passo?", "Por que Hamburguer?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Vá para o estacionamento.");
                } else {
                    System.out.println("Crug'Oto: Porque nosso Deus, Lugrots, nos criou a partir de Hamburguers.");
                    System.out.println("Hamburguer é a nossa fonte de vida!");
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
                    System.out.println("SAVVY: Vá arrumar o Computador de Bordo");
                } else {
                    v[2][0] = "t";
                    System.out.println("Crug'Oto: Vou pensar no seu caso humano.");
                    System.out.println("Mas de qualquer forma humano, deixe comigo algumas coisas que gostaria de levar com você.");
                    comandosDisponiveis(2, "Deixar coisas", "Não deixar nada.");
                    if (resposta.equals("a")) {
                        v[2][1] = "t";
                        guardarCoisas(v);
                        System.out.println("Crug'Oto: Vou guardar estes items até sua missão terminar, humano.");
                    }
                    System.out.println("SAVVY: Agora vá arrumar o Computador de Bordo");
                }
                comandosDisponiveis(1, "Ir para o Centro de Inovações");
                break;
            case "4": // peça 5 comida
                comandosDisponiveis(2, "Falta muito pra completar a missão?", "Vocês vão ficar aqui para sempre?");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Você deve buscar Hamburguers para a viagem");
                } else {
                    System.out.println("Crug'Oto: Sim, mas nós vamos buscar o resto do nosso povo.");
                    System.out.println("Como posso ajudar voces agor?");
                    System.out.println("SAVVY: Vá buscar Hamburguers para a longa viagem");
                }
                comandosDisponiveis(1, "Ir para a Praça de Alimentação 01");
                break;
        }
        return false;
    }

    static boolean entradaCampus(String[][] v) {
        System.out.println(ambienteAtual("entrada"));
        String[] falas = {"Hanbägä wa piza yori mo sugurete ori, bëkon wa jinseidesu", "Bisuketto ka Borasha?", "Burubasaūru, chāmuanda ka fanshutsu?",
            "Ruuku, watashi wa anata no chichiwue", "è vedere o mangiare"};
        int rnd = randomico.nextInt(falas.length);
        String[] d1 = {"O que eu to fazendo no Senac? Eu estava em casa até agora...", "[...ouve alguem falando alguma coisa longe]",
            falas[rnd], "[...ao se aproximar, se assusta por ser um Alienigena!]", "ET: Saudações terráqueo, como voce se chama?"};
        imprimirTexto(d1);
        v[0][0] = verificaNome();
        String[] d2 = {"Mas o que ta acontecendo?!?!? Por que eu consigo te entender?",
            "ET: Somos muito mais evoluidos que voces, nao precisa mais me dizer seu nome, a Cebola Mágica do meu povo ja me revelou, " + v[0][0],
            v[0][0] + ": Que cebola? por que eu to falando com um ET? E o pior, eu entendo o idioma dele", "ET: Nao temos tempo para ficar respondendo perguntas tolas!",
            "Seu destino é nos ajudar e montar nossa Nave para buscarmos o resto de nosso povo e viver comendo Hamburguers neste planeta inferior.", "Fale com Crug'Oto para descobrir o que precisa fazer",
            "Vá reto neste corredor e vire a direita, ande logo, ele está te esperando!"};
        imprimirTexto(d2);
        return false;
    }

    static boolean cuboSenac(String[][] v) {
        System.out.println(ambienteAtual("cubo"));
        String[] d1 = {v[0][0] + ": Hey ET desculpe atrapalhar sua meditação, mas Crug'Oto falou pra eu vir aqui, como voce se chama?",
            "ET: Meu nome é Sindri, como posso te ajudar?", v[0][0] + ": Não sei, mas estou cumprindo uma missão pra voces.", "[...] Sindri volta a meditar ",
            "Sindri: vizualizei sua tarefa atraves da meditação, mas voce tem de me provar do que é capaz.",
            v[0][0] + ": Aceito o desafio.", "Sindri: responda-me esta pergunta caso acertar, voce ganha um item a mais para sua missão.", "Lá vai:"};
        imprimirTexto(d1);
        chamarPergunta('m', v);//pergunta de Pré-Calculo
        System.out.println("Muito bem, humano. Pegue estas peças de Metal para a nave");
        System.out.println("[...]Usando um poder de Telecinese molda o Cubo do Senac em partes para a Fuselagem");
        return false;
    }

    static boolean caixaDagua(String[][] v) {
        System.out.println(ambienteAtual("caixa"));
        String d[] = {"Oi, me mandaram vir aqui, como se chama?", "ET: Gunnhildur.", "Gunnhildur: O que você quer terráqueo?", v[0][0] + ": Falaram que eu devia vir aqui.",
            "Gunnhildur: Argh, eles querem arrumar nossa nave e voltar para aquele planeta à beira da extinção. Mas...",
            "Gunnhildur: Eu só irei te ajudar se você me mostrar seu valor respondendo uma pergunta.",
            v[0][0] + ": Manda vê.", "Muito confiante para um simples terráqueo, lá vai..."};
        imprimirTexto(d);
        chamarPergunta('a', v);// pergunta de Administração
        String d2[] = {"Gunnhildur: Argh, tudo bem, você provou seu valor, aqui está leve este tanque com combustível.", "Agora vá até Crug'Oto denovo para saber seu destino."};
        imprimirTexto(d2);
        return false;
    }

    static boolean estacionamento(String[][] v) {
        System.out.println(ambienteAtual("estacionamento"));
        String[] d1 = {"[...] Voce chega ao estacionamento e não ve ninguem", "[...]Mas de repente escuta um barulho vindo de um carro parado e"
            + " um et com roupas de mecanico e ferramentas na mão vem em sua direção.", "ET: Acho que é voce mesmo que Crug'Oto enviou, não precisa dizer seu nome que já sei, eu me chamo Brynhildur.", "Brynhildur: E sei como posso te ajudar, "
            + "acabei de conseguir o que voce precisa em uma dessas porcarias de naves espaciais terrestres que aparentemente não voam.",
            "Mas para conseguir este item voce terá de me provar sua inteligencia respondendo uma pergunta.", v[0][0] + ": Sou capaz de tudo, manda a pergunta ai."};
        imprimirTexto(d1);
        chamarPergunta('c', v);//pergunta de conceitos da computação
        System.out.println("Brynhildur: Certo, humano. Pegue estas peças para reparar a Turbina");
        return false;
    }

    static boolean cit(String[][] v) {
        System.out.println(ambienteAtual("cit"));
        String[] d1 = {"[...]Voce chega ao centro de inovação tecnológica e ve um ET com trajes de Nerd usando um dos computadores"};
        imprimirTexto(d1);
        String[] d2 = {"ET: Oh?! Finalmente chegou humano? Alias, meu nome é Garpur", v[0][0] + ": Crug'Oto me falou pra vir até aqui falar com voce",
            "Garpur: Sim, sim. Espere eu terminar de jogar uma partida disso que voces chamam de Jogo", "[...] esperando o ET terminar o jogo",
            "Garpur: terminei a partida aqui, pelo que vi em meu colar de cebola voce foi o escolhido para nos ajudar a montar "
            + "nossa Nave, certo " + v[0][0] + "?", v[0][0] + ": fui eu sim", "Garpur: Eu montei as peças necessárias com restos destas caixas pretas."
            + "Mas me ajude a desvendar esse enigma que te dou o item."};
        imprimirTexto(d2);
        chamarPergunta('p', v); //pergunta de Algoritmos e Programção
        System.out.println("Muito bem, " + v[0][0] + "Aqui está as peças para reparar o Computador de Bordo da Nave Espaical.");
        return false;
    }

    static boolean praca01(String[][] v) {
        System.out.println(ambienteAtual("praca01"));
        String[] d1 = {"[...]Voce vai a praça de alimentação a procura de alguma coisa para comer, chega na cantina e tem um ET no balcão"
            + "e em seu cracha escrito Sunna"};
        imprimirTexto(d1);
        String[] d2 = {"ET: Olá terraqueo, o que vai querer?"};
        System.out.println("Ué?! Agora vocês vão querer trabalhar igual a gente?");
        System.out.println("Sunna: Adorei este lugar, tem tudo que preciso para fazer Hamburguers deliciosos para minha raça.");
        System.out.println("Crug'Oto me disse que viria buscar muitos Hamburguers para a viagem até nosso planeta.");
        System.out.println("Eu preparei eles"); //nao preparou todos e tem q responder algumas perguntas até ficar prontos?
        chamarPergunta('p', v);//pergunta de Algoritmos e Programção
        //chamarPergunta('p', v);   chama varias perguntas?
        return false;
    }

    static String[][] guardarCoisas(String[][] v) {
        System.out.println("Quantas coisas quer levar?");
        int n = sc.nextInt();
        sc.nextLine();  // necessário para nao comer linha
        v[1] = new String[n];
        for (int i = 0; i < v[1].length; i++) {
            System.out.println("Item " + (i + 1) + ":");
            v[1][i] = sc.nextLine();
        }
        return v;
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
                {{"A saída da expressão S = A " + (char) 8857 + " B é"}, {"1001", "1100", "0101", "0001"}, {"a"}},
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
            } else {
                System.out.println(EndGame(2));
                System.exit(0);//se o player desiste de responder uma nova pergunta, o programa termina
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
        if (v[0][1].equals("fim1")) {
            System.out.println(EndGame(1));
            System.exit(1);//termina o programa
        } else if (v[0][1].equals("fim2")) {
            System.out.println(EndGame(2));
        }
        if (v[0][2].equals("10")) {//gameover
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
                fim = "Voce ajudou os Aliens e eles irão te levar para Beyond the Earth!!!";
                break;
            case 2:
                fim = "Voce ajudou os Aliens, e em muitos anos a Humanidade será escravizada!";
                break;
            case 3:
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
