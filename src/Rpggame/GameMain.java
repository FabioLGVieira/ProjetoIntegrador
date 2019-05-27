package Rpggame;

import java.util.Random;
import java.util.Scanner;

public class GameMain {

    // VERSAO ANTIGA E DESCONTINUADA
    
    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static int progressoPlayer, progressoAdversários;
    static String resposta;

    public static void main(String[] args) {
        progressoPlayer = 0;
        progressoAdversários = 0;
        menu();
    }

    public static void controlador() {
        String escolhasJogo[][] = {{"zz", "0", "0"}, //nome, progresso do player, progresso adversario
        {"f", "f", "f"}, //escolhas jogo  t = true     f = false
        {"", "", "", "", ""}, //vetor para guardar comidas escolhidas pelo player
        {}, //
        {},
        {},
        {}};// primeiro elemento é o nome

        entradaCampus(escolhasJogo); //tanque combustivel
        salavazia(escolhasJogo);
        if(biblioteca(escolhasJogo)==1){
            pracaAlimentacao1(escolhasJogo);
        }
        voltaParaSala(escolhasJogo);//pergunta prog
        nasa(escolhasJogo);
        labDesign(escolhasJogo);

        System.out.println("[No outro dia...]");
        entradaCampus(escolhasJogo);//combustivel
        nasa(escolhasJogo);
        if (nasa(escolhasJogo) == 1) {
            labDesign(escolhasJogo);
            pracaAlimentacao1(escolhasJogo);
        } else {
            pracaAlimentacao1(escolhasJogo);
            labDesign(escolhasJogo);
        }

        System.out.println("[No outro dia...]");
        //nasa(escolhasJogo);//turbina
        if (nasa(escolhasJogo) == 1) {
            centroEsportivo(escolhasJogo);
            salaA125(escolhasJogo);// pergunta matematica
        } else {
            salaA125(escolhasJogo);
            centroEsportivo(escolhasJogo);
        }
        labDesign(escolhasJogo);//progresso faltando historia

        System.out.println("[No outro dia...]");
        if (nasa(escolhasJogo) == 1);//estabilizadores
        salaA125(escolhasJogo);// pergunta conceitos
        pracaAlimentacao3(escolhasJogo);// pergunta prog  
        salaA125(escolhasJogo);// pergunta adm
        labDesign(escolhasJogo); // ganha 3 peças ?

        System.out.println("[No outro dia...]");
        nasa(escolhasJogo); //pega traje + gravidade 0
        centroEsportivo(escolhasJogo);
        labDesign(escolhasJogo); //monta as peças no foguete

        System.out.println("[No outro dia...]");
        nasa(escolhasJogo); // pega as comidas
        pracaAlimentacao1(escolhasJogo);
        //apresenta
        EndGame(1);

    }

    public static int entradaCampus(String[][] v) {

        System.out.println(ambienteAtual("entrada"));
        switch (progressoPlayer) {
            case 0:
                String[] d = {"Voce esta chegando ao Centro Universitário Senac para mais um dia de aula ...\n", "Ao chegar, um dos alunos da atlética vem falar com você.\n",};
                imprimirTexto(d);
                System.out.println("João: Bom dia, aluno! Como se chama?");
                v[0][0] = verificaNome(v[0][0]);
                String[] d2 = {"Veterano: Está acontecendo no decorrer desta semana Concurso Espacial do Centro Universitario Senac!", v[0][0] + ", siga até a sua sala para o professor te dar melhores informaçoes."};
                imprimirTexto(d2);
                break;
            case 1:
                System.out.println("[... chegando no Senac no outro dia]");
                System.out.println("[um cartaz diz sobre os alunos de gastronomia fazendo um almoço beneficente]");
                System.out.println("[talvez eu devesse passar lá pra ver... Mas agora vou falar com o prof Otávio. Vou pela Nasa");
                break;
        }
        return 0;
    }

    public static int salavazia(String[][] v) {//uma das salas iniciais para mostrar o caminho ao player caso ele nao vá ao lugar certo
        System.out.println(ambienteAtual("lab136"));
        String[] d = {"Você chega na sala e não tem ninguém, só o professor...", v[0][0] + ": Bom dia professor, cadê todo mundo?",
            "Alexandre: Bom dia! Os alunos estão na biblioteca pegando o livro que pedi e vendo informações sobre o concurso que vai ter no Campus.",
            v[0][0] + ": Que legal! E que concurso é esse?", "Alexandre: é o Concurso Espacial do Senac, na biblioteca você terá melhores informaçoes"};
        imprimirTexto(d);
        comandosDisponiveis(2, "Ir agora?", "ficar e falar com o prof?");
        if (resposta.equals("b")) {
            String[] d2 = {v[0][0] + ": Já sei Java, vou ficar aqui até eles chegarem.", "Alexandre: Beleza então, abre o NetBeans ai e me faz um clone do Whatsapp aí.",
                "Alexandre: Se não conseguir, já está reprovado. Ou prefere ir na biblioteca?"};
            imprimirTexto(d2);
            comandosDisponiveis(1, "Biblioteca");
        }
        String[] d3 = {v[0][0] + ": Acho que vou lá mesmo...", "Alexandre: Pode ir! Só não esqueça do livro, o nome do livro é 'Java para Iniciantes'.",
            v[0][0] + ": Pode deixar, obrigado!"};
        imprimirTexto(d3);
        return 0;
    }

    static int biblioteca(String[][] v) {
        System.out.println(ambienteAtual("biblioteca"));
        switch (progressoPlayer) {
            case 0:
                String[] d = {"[...ouve outros alunos conversando sobre projetos para o Concurso...]", v[0][0] + ": O que é esse concurso?",
                    "Balconista: É o Primeiro Concurso Espacial do Centro Universitário Senac!", "Balconista: Quem se inscrever tem que realizar algum projeto sobre atividades fora da Terra, "
                    + "\ncomo viagens espaciais, atividades de pesquisa, ou evolução tecnológica!", "Por exemplo, alguns alunos já pensaram em criar cidades-bolha, casas ou edifícios em outros planetas, "
                    + "\ncarros flutuantes, robôs operários, super próteses, entre outros. E você, vai participar?"
                };
                imprimirTexto(d);
                comandosDisponiveis(2, "Sim", "Não");
                if (resposta.equals("a")) {
                    System.out.print(v[0][0] + ": Gostei muito da ideia, mas nao sei ainda o que fazer, vou pensar mais!");
                    sc.nextLine();
                    v[1][0] = "t";// interesse no concurso = true;
                } else {
                    System.out.println(v[0][0] + ": Por enquanto não tenho interesse, obrigado!");
                }
                String[] d2 = {v[0][0] + ": Agora preciso pegar o livro que o professor pediu!", "[...procurando o livro nas estantes]", v[0][0] + ": O que é esse papel amassado no chão?"};
                imprimirTexto(d2);

                comandosDisponiveis(2, "Pegar o papel", "Ignorar");
                String[] d3 = {v[0][0] + ": Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?", v[0][0] + ": Bom, vou guardar... Quem sabe não seria um bom projeto para o concurso?!",
                    v[0][0] + ": Hmmm... achei o livro! Agora preciso voltar pra sala"};
                if (resposta.equals("a")) {
                    imprimirTexto(d3);
                    if (v[1][0].equals("f")) {  // se o interesse no concurso é false
                        v[1][0] = "t";          //pasa a ser true
                    }
                    v[1][1] = "t"; // pegou o papel = true;

                } else {
                    System.out.println(d3[2]);
                    pulaLinha();
                }
                if (v[1][0].equals("f") && v[1][1].equals("f")) {  // se apertar os dois forem false
                    System.out.println(v[0][0] + ": Mas tô com fome, vou comer antes e ver melhor o projeto, depois volto pra sala.");
                    return 1;
                } else {
                    comandosDisponiveis(2, "Praça alimentação 01", "Voltar para a sala");

                    if (resposta.equals("a")) {
                        System.out.println(v[0][0] + ": Tô com fome, vou comer antes e ver melhor o projeto, depois volto pra sala.");
                        return 1;
                    }
                }
                break;
            case 1:

                String[] d4 = {"[...caminhando até a recepção da biblioteca]", "Balconista: decidiu se inscrever para o concurso?", v[0][0] + ": Decidi sim ",
                    "Balconista: Preencha a ficha.", " [...preenchendo a ficha]", v[0][0] + ": Prontinho!", " Balconista: Obrigado por participar," + v[0][0] + "! Boa sorte!"};
                imprimirTexto(d4);
                break;
        }
        return 0;
    }

    public static void pracaAlimentacao1(String[][] v) {
        System.out.println(ambienteAtual("praca01"));

        switch (progressoPlayer) {
            case 0:
                String[] d = {v[0][0] + ": Hey Paulo, quanto tempo não te vejo! Não lembrava que voce estudava aqui.", "Paulo: E aí," + v[0][0] + "! Eu stou no terceiro semestre de arquitetura",
                    v[0][0] + ": Que legal! Você se inscreveu para o Concurso Espacial?", "Paulo: Me inscrevi sim, estou pensando em algum projeto sobre como seria a arquitetura na lua. E o seu projeto?"};
                String d2[] = {v[0][0] + ": Eu ainda estou pensando se vou participar do concurso", "Paulo: Poxa, se eu fosse você eu participaria. É uma experiência muito legal!",
                    v[0][0] + ": Tá bom, eu vou participar, mas eu ainda tenho que pensar na ideia!", "Paulo: Hoje é seu dia de sorte! Eu achei esse papel jogado no chão, ao que tudo indica é um projeto de um foguete.",
                    "[Paulo te mostra o projeto...]", v[0][0] + ":Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?",
                    "Paulo: Pois é cara, faça bom proveito!", v[0][0] + ": Pode deixar, obrigado!"};
                imprimirTexto(d);

                if (v[1][0].equals("t")) {
                    if (v[1][1].equals("t")) {

                        comandosDisponiveis(2, "Contar sua ideia", "Comprar o lanche e analisar o projeto");
                        if (resposta.equals("a")) {
                            System.out.println(v[0][0] + " : Que idéia interessante! Eu ainda não decidi, mas estou pensando em construir um foguete...");
                            sc.next();
                        }
                    } else {
                        String[] d3 = {v[0][0] + ": Eu tenho interesse em participar do concurso, mas ainda não sei o que fazer...",
                            "Paulo: Hoje é seu dia de sorte! Eu achei esse papel jogado no chão, ao que tudo indica é um projeto de um foguete.",
                            "[Paulo te mostra o projeto...]", v[0][0] + ":Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?",
                            "Paulo: Pois é cara, faça bom proveito!", v[0][0] + "Pode deixar, obrigado!"};

                        imprimirTexto(d3);
                        v[1][1] = "t";
                    }

                } else {
                    imprimirTexto(d2);

                    if (v[1][0].equals("f")) {
                        v[1][0] = "t";
                    }
                }
                String d3[] = {v[0][0] + ": Eu estou um pouco atrasado, vou comprar meu lanche e voltar para a sala."
                    + "Depois conversamos, ok?", "Paulo: Tudo bem! Até mais.", " [...vendo o projeto do foguete] ", "[...relação de peças: tanque de combustivel,"
                    + "combustivel(hidrogenio), fuselagem, comida desidratada, turbina, asas, modulo de comando, traje espacial...]", v[0][0] + ": Agora vou voltar pra sala e ver se o "
                    + "professor Alexandre sabe onde consigo encontrar alguma das peças"};
                imprimirTexto(d3);
                break;
            case 1://entrega comida para recebe-la no case 7
                System.out.println("[Varios veteranos de Gastronomia estão fazendo confraternização com os bichos]");
                System.out.println(v[0][0] + ": Oi, vi o cartaz na entrada, e queria saber se algum de vocês poderia me ajudar no projeto do Concurso.");
                System.out.println("Veterano: Que bacana! O que vai ser? E diga lá, em que voce precisa de ajuda.");
                System.out.println(v[0][0] + ": É um foguete! E para poder ir ao espaço irei precisar de alimento.");
                System.out.println("Sei que preciso tirar 97% da água dos alimentos, mas não sei fazer isso. Por isso vim pedir ajuda...");
                System.out.println("Veterano: De fato, vai ficar muito mais facil de levar com menos peso!");
                System.out.println("Podemos te ajudar sim, mas demora um bom tempo, fala comigo daqui 3 dias que estará tudo pronto!");
                System.out.println("Mas antes de voce correr atrás do restante do projeto, me diga/dê o que pretende levar.");//decidir se ele vai conseguir os alimentos antes
                System.out.println(v[0][0] + ": Beleza, vou levar...");
                for (int i = 0; i < v[2].length; i++) {
                    System.out.println(" Coloque o alimento: ");
                    v[2][i] = strNext();
                }
                System.out.println("Veterano: Bacana, ja vou começar o processo de desidratar, boa sorte no projeto!");
                if (v[1][2].equals("f")) {
                    System.out.println(v[0][0] + ": Obrigado, outro dia venho pegar então. Agora vou pegar uma peça no Lab Design");
                } else {
                    System.out.println(v[0][0] + ": Obrigado, outro dia venho pegar então.");
                }
                break;
            case 7:
                System.out.println(v[0][0] + ": Eai, outro dia eu deixei alguns alimentos para desidratar aqui, já estão prontos?");
                System.out.println("Só falta eles para eu poder apresentar o projeto no Concurso!");
                System.out.println("Veterano: Opa, lembro de você ta tudo pronto sim, vou ali pegar.");
                System.out.println("[...]");
                System.out.println("Aqui está. só pra checar era " + v[2][0] + ", " + v[2][1] + ", " + v[2][2] + ", " + v[2][3] + ", " + v[2][4] + ", certo?");//substituir pelo vetor
                progressoPlayer++;
                System.out.println(v[0][0] + ": Isso aí. Agora já tenho tudo pronto, vou lá Apresentar!");
                break;
        }
    }

    public static int voltaParaSala(String[][] v) {
        System.out.println(ambienteAtual("lab136"));
        System.out.println("Alexandre: Muito bem turma, já que todos voltaram vou fazer algumas perguntas sobre programação. Quem acertar "
                + "terá alguma ajuda para o projeto do Concurso Espacial.");
        System.out.println("E outra coisa, tem um aluno do ultimo semestre de engenharia de computação ajudando nos projetos na Nasa!");
        strNext();
        chamarPergunta('p');
        System.out.println("-----------------------------------\n");
        System.out.println("[... no final da aula]");
        System.out.println(v[0][0] + ": E então professor, eu acertei a pergunta...");
        System.out.println("Alexandre: " + v[0][0] + " como posso te ajudar em seu projeto?");
        System.out.println(v[0][0] + " : Preciso de algumas peças: um tanque de combustivel, fuselagem e asas para um foguete, em que "
                + " parte do campus posso encontrar esses itens? ");
        System.out.println(" Alexandre: procure o professor Otávio no laboratório de design, e informe o código 7446. Mas da uma passada na Nasa antes");
        System.out.println(v[0][0] + ": Beleza, até a próxima aula.");
        return 0;
    }

    public static int labDesign(String[][] v) {
        System.out.println(ambienteAtual("labDesign"));
        switch (progressoPlayer) {
            case 0:
                String[] d1 = {"Professor Otávio: Bom dia aluno, como posso te ajudar? ", v[0][0] + ": O professor Alexandre disse para informar o codigo 7446.",
                    "Professor Otávio: Ah sim, é para eu ajudar o aluno q me dizer esse código no Concurso! O que voce precisa? ", v[0][0] + " : De um tanque de combustível, fuselagem e asas para um foguete",
                    " Professor Otávio: posso preparar esses objetos no nosso Laborátorio do Senac em um material resistente, voce teria o desenho destes itens? ", v[0][0] + " : tenho sim! ", "Professor Otávio: certo, vai demorar 1 dia pra ficar pronto, amanha mesmo voce pode pegar.",
                    v[0][0] + " : Amanhã não tenho aula...", "Professor Otávio: Mas venha ao campus amanhã pegar as peças!", v[0][0] + ": Pode deixar, obrigado!"};

                imprimirTexto(d1);
                progressoPlayer++;
                break;
            case 1:
                System.out.println(v[0][0] + "Bom dia prof Otávio! Vim pegar a peça que você disse ontem.");
                System.out.println("Professor Otávio: Bom dia " + v[0][0] + ", está pronta já!"
                        + " Aliás, alguns ex-alunos disseram que não vão utilizar certo material. Mas como estou te ajudando, vou dar esse material pra você.");
                System.out.println("São alguns barris de combustível para seu projeto, aproveito e libero um espaço aqui no laborátorio.");
                System.out.println(v[0][0] + ": Que ótima notícia! Eu iria precisar procurar isso também. Obrigado professor!");
                progressoPlayer++;
                if (v[1][2].equals("t")) {
                    System.out.println("Agora vou dar uma passada na P1 que tem umas comidas interessantes. Até mais Prof.");
                }
                break;
            case 2:
                //preencher
                break;
        }
        return 0;
    }

    public static int nasa(String[][] v) { //um aluno veterano de computacaox ta fazendo uma AI,
        System.out.println(ambienteAtual("nasa"));  // e ela da a resposta da proxima pecax
        System.out.println("Veterano: Ei! Você ai, Você mesmo! Acabei de melhorar a I.A. que estou desenvolvendo! Dei o nome de SAVVY");
        System.out.println("Tenho problema de memória, criei ela pra me lembrar do que fazer. Então sempre deve me dizer o próximo passo.");
        System.out.println("Tem como me ajudar? Tenta digitar sobre seu projeto, e a resposta deve ser algo relacionado a ele!");
        switch (progressoPlayer) {
            case 0:// tanque de combustivel
                comandosDisponiveis(2, "Digitar 'qual peça eu preciso'", "Ir para o Lab. Design");
                if (resposta.equals("a")) {
                    System.out.println("SAVVY: Você deve procurar por um Tanque de Combustível.");
                }
                break;
            case 1://combustivel    avisa pra saber sobre a comida
                comandosDisponiveis(3, "Digitar 'qual peça eu preciso'", "Ir para o Lab. Design", "Ir para a  Praça de Alimentação 01");
                switch (resposta) {
                    case "a":
                        System.out.println("SAVVY: Você deve conseguir Combustível.");
                        comandosDisponiveis(2, "Ir para o Lab. Design", "Ir para a  Praça de Alimentação 01");
                        if (resposta.equals("a")) {
                            return 1;
                        }
                        break;
                    case "b":
                        v[1][2] = "t";      //escolheu ir para o lab = true;
                        return 1;
                    case "c":
                        return 0;
                }
                break;
            case 2://turbina    avisa pra saber sobre o traje
                comandosDisponiveis(3, "Digitar 'qual peça eu preciso'", "Centro Esportivo", "Aula de Matemática");
                switch (resposta) {
                    case "a":
                        System.out.println("SAVVY: Você tem que conhecer alguem no Centro Esportivo.");
                        comandosDisponiveis(2, "Centro Esportivo", "Aula de Matemática");
                        if (resposta.equals("a")) {
                            return 1;
                        }
                        break;
                    case "b":
                        v[1][2] = "t";      //escolheu ir para o centro esportivo = true;
                        return 1;
                    case "c":
                        return 0;
                }
                break;
            case 3://estabilizador
                comandosDisponiveis(3, "Digitar 'qual peça eu preciso'", "Aula de Conceitos", "alguma coisa");
                switch (resposta) {
                    case "a":
                        System.out.println("SAVVY: Você precisa de Estabilizadores.");
                        comandosDisponiveis(2, "Aula de Conceitos", "alguma coisa");
                        if (resposta.equals("a")) {
                            return 1;
                        }
                        break;
                    case "b":
                        v[1][2] = "t";      //escolheu ir para o aula conceitos = true;
                        return 1;
                    case "c":
                        return 0;
                }
                break;
            case 6:// recebe o traje
                comandosDisponiveis(2, "Digitar 'qual peça eu preciso'", "Centro Esportivo");
                switch (resposta) {
                    case "a":
                        System.out.println("SAVVY: Vai pegar o Traje Espacial.");
                        comandosDisponiveis(1, "Aula de Conceitos");
                        break;
                    case "b":
                        v[1][2] = "t";      //escolheu ir para o aula conceitos = true;
                        return 1;
                }
                break;
            case 7:// recebe a comida
                // nasa > ? > pega a comida > endgame
                break;
        }
        return 0;
    }

    /*    template pra progresso do jogo 
     switch (progressoPlayer) {
     case 0:
     break;
     case 1:
     break;
     case 2:
     break;
     case 3:
     break;
     case 4:
     break;
     case 5:
     break;
     case 6:
     break;
     case 7:
     break;

     }
     passar array pra lista    
     */
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

    static void verificaSituacaoJogo() {
        String funcao;
        System.out.println("Progresso:");
        progressoPlayer = sc.nextInt();
        System.out.println("Função: ");
        funcao = sc.next();
        //System.out.println("Nome do player:");
        //v = sc.next();
        switch (funcao) {
            case "biblioteca":
            //biblioteca();
            case "entrada":
                //entradaCampus();
                break;
            case "labDesign":
                //labDesign();
                break;
            case "praca01":
                //pracaAlimentacao1();
                break;
            case "centroesportivo":
                //centroEsportivo();
                break;
            case "praca03":
                //pracaAlimentacao3();
                break;
            case "lab136":
                //salavazia();
                break;
            case "a125":
                //salaA125();
                break;
            case "nasa":
                //nasa();
                break;
        }

        if (progressoPlayer == 8) {
            System.out.println(EndGame(1));
        }
        if (progressoAdversários == 10) {
            System.out.println(EndGame(3));
        }
        System.exit(1);//termina o programa
    }

    static String ganhaPeca(boolean ganhou) {// troca as peças de vetores, e mostra o avanço do adversario
        String partes[] = {"Tanque de Combustível", "Combustível(hidrogenio)", "Fuselagem", "Comida Desidratada", "Turbina", "Estabilizadores", "Módulo de Comando", "Traje Espacial"},
                inventario[] = new String[8], mensagem;
        if (ganhou == true) {
            inventario[progressoPlayer] = partes[progressoPlayer];
            partes[progressoPlayer] = "";
            progressoPlayer++;
            mensagem = "Voce ganhou " + partes[progressoPlayer] + "!!";
        } else {
            progressoAdversários++;
            mensagem = "Essa nao! Voce errou e o projeto adversário avançou para " + (progressoPlayer * 10) + "%";
        }
        verificaSituacaoJogo();
        return mensagem;
    }

    static void acessoLiberado(String[][] v) {
        System.out.println("== Acesso liberado ==");
        System.out.print("Prof. Gilberto: muito bem " + v[0][0] + " , parece que voce me encontrou, como posso te ajudar ? ");
        strNext();
        comandosDisponiveis(2, "Pedir ajuda", "outra opçao");
        if (resposta.equals("a")) {
            String[] s = {v[0][0] + ": estou precisando de peças para montar meu projeto espacial creio que o senhor poderia me ajudar.",
                "Prof. Gilberto: posso te ajudar sim, " + v[0][0] + ", porém voce terá de me responder uma pergunta.", "Voce está de acordo?"};
            imprimirTexto(s);
            comandosDisponiveis(2, "Sim", "Nao");
            if (resposta.equals("a")) {
                //perguntaFacil();
                System.out.println(ganhaPeca(true));
                //pracaAlimentacao3();
            } else {
                //gameOver();
            }
            System.out.println(" Parabéns " + v[0][0] + " com essa resposta certa voce ganha um item para o seu projeto ");
        } else if (resposta.equals("b")) {
            System.out.println(v[0][0] + "Vai ter prova?");
            System.out.println("Prof. Gilberto: Vai sim, (completar com alguma materia aqui)");
            System.out.println("Você está com dúvida na matéria?");
            System.out.println("Disponíveis: S | N");
            pulaLinha();
            if (resposta.equals("s")) {
                System.out.println("Sim, não entendi nada.");
            } //continuar
            else {
                System.out.println("Que nada, queria mesmo falar desse projeto que achei.");
            }
            //continuar
        }
    }

    static int salaA125(String[][] v) {
        System.out.println(ambienteAtual("a125"));
        switch (progressoPlayer) {
            case 3:
                String[] d = {" [...Aula de conceitos da computação] ", "Stelvio: muito bem turma, tudo bem com voces? Alguma duvida? "
                    + "Algum problema com outra matéria? E como anda o PI de voces?", "Bom, como todos devem saber, estamos na semana do Concurso Espacial"
                    + "E os professores estão ajudando os alunos de alguma forma.", "Vou fazer algumas perguntas a respeito da minha matéria, quem acertar "
                    + "pode falar comigo no final da aula, que dou alguma ajuda."};
                imprimirTexto(d);
                chamarPergunta('c');
                //preencher
                break;
            case 4:
                String[] f = {" [...Aula de fundamento da administração] ", " Keli: Vou passar uma apresentação sobre uma empresa de que desidrata comida"
                    + " para NASA e depois vou fazer um questionario, quem acertar estara liberado ", "[...Parte importante da apresentação] ", " Keli: "
                    + "grande parte dos funcionários desta empresa são formados em gastronomi e eles tem de lidar com o processo de desidratação da comida "
                    + "em que são tirados 97% de liquido do alimento, afim de reduzir o peso da carga dos foguetes ", v[0][0] + " agora já sei onde conseguir "
                    + "um dos itens para o meu projeto "};
                imprimirTexto(f);
                chamarPergunta('a');
                //preencher
                break;
        }
        return 0;
    }

    public static int pracaAlimentacao3(String[][] v) {
        System.out.println(ambienteAtual("praca03"));
        //mudar pro andre(filho do cara do lab) pedir ajuda numa questao de prog faz a pergunta e ganha +1 peça
        String[] s = {"André: fala " + v[0][0] + ", fiquei sabendo que voce está participando do projeto espacial.", "O que voce está fazendo? ",
            v[0][0] + ": não posso contar de jeito nenhum.", "André: o que é isso no seu bolso ? (pega o projeto e sai correndo) ",
            v[0][0] + ": voce pegou meu projeto devolva agora!", "André: Só se você me pagar um lanche."};
        imprimirTexto(s);
        System.out.println("Deseja pagar um lanche para ter seu projeto de volta?");
        comandosDisponiveis(1, "Sim", "Não");
        if (resposta.equals("a")) {
            System.out.println(" Conseguiu seu projeto de volta ");
            //vai ter continuação???
        } else if (resposta.equals("b")) {
            EndGame(2);
        }
        return 0;
    }

    /*
     switch (progressoPlayer) {
     case 0:
     break;
     case 1:
     break;
     case 2:
     break;
     case 3:
     break;
     case 4:
     break;
     case 5:
     break;
     case 6:
     break;
     case 7:
     break;

     }

     }*/
    static void sala2() {
        //boolean ganhou = false;   
        //System.out.println(v + " Olá professor, hoje que voce vai passar um questionario ");
        System.out.println(" Isso mesmo, senta ai que já vou passar a pergunta ");
        //perguntaFacil();
        //return ganhou;  
    }

    // O jogador vai fazer treinamentos de gravidade 0 na piscina
    public static void centroEsportivo(String[][] v) {
        System.out.println(ambienteAtual("centroesportivo"));
        switch (progressoPlayer) {
            case 3:
                System.out.println(v[0][0] + ": Olá onde posso encotrar o Ducival ?");
                System.out.println("Desconhecido: Ducival é o treinador, ele está na quadra ");
                comandosDisponiveis(2, "Procurar treinador", "Ir para outro lugar");
                System.out.println("Vem comigo, vou te mostrar");
                System.out.println("[...procurando o Ducival]");
                System.out.println("Desconhecido: Aquele ali é o Treinador.");
                System.out.println(v[0][0] + ": Treinador... Fulano disse para eu te procurar."); //mudar o nome talvez ou melhorar
                System.out.println("Preciso de ajuda com o meu projeto do Concurso Espacial.");
                System.out.println("Ducival: Muito bem, em que posso te ajudar?");
                System.out.println(v[0][0] + ": Quero desenvolver uma teoria e provar que é possível ter uma noção de gravidade zero na piscina");
                System.out.println("Ducival: Legal, então vamos ter que usar a nossa piscina mais funda!");
                System.out.println("Mas acho que seria interessante já testarmos com a roupa de astronauta.");
                System.out.println("Que tal voce tentar conseguir ela, e depois começamos o treinamento?");
                comandosDisponiveis(2, "Sim", "Não");
                break;
            case 6://vai conseguir a roupa e treinar na piscina
                //dialogo sobre aprender a gravidade 0
                break;
        }// decidir reaproveita ou muda abaixo
        comandosDisponiveis(2, "procurar treinador", "ir para centro gastronômico");
        if (resposta.equals("a")) {
            System.out.println(v[0][0] + ": Oi Ducival tenho um projeto de viagem espacial e precisaria de treinamento de gravidade 0");
            strNext();
            System.out.println("Ducival: O treinamento pode ser feito na piscina, vamos começar ?");
            comandosDisponiveis(2, "começar", "outra hora");
            if (resposta.equals("a")) {
                strNext();
                System.out.println("Treinamento cncluido "
                        + "\nParte do treinamento foi concluido");
                strNext();
                // ir para um outro lugar 
            } else {
                System.out.println(v[0][0] + ": vou para o centro gastronômico começamos depois ");
                strNext();
                pracaAlimentacao1(v);
            }
        }
        if (resposta.equals("a")) {
            pracaAlimentacao1(v);
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

    static void mapa() {
        //mapa do campus
        String s[] = {"|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|", "|                         |¯¯¯¯¯¯¯¯|                      1 - Biblioteca      |",
            "|                         |___3____|  |¯¯¯¯¯¯|            2 - Nasa            |", "|                                     |___9__|            3 - Lab Design      |",
            "|                    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|            4 - Praça           |", "|               |¯¯| |   |¯¯¯¯|     |¯¯¯¯|   |                Alimentação 01  |",
            "|               |  | |   |____|  7  |____|   |   |¯¯¯¯|   5 - A125            |", "|   |¯¯¯¯¯¯¯|   |  | |_______________________|   |8   |   6 - C136            |",
            "|   |_______|   |__|                       |¯¯|  |    |   7 - Corredor        |", "|    |¯¯¯¯¯¯|   |¯¯¯¯¯¯¯¯¯¯¯¯6¯¯¯¯¯¯¯¯¯¯|  |__|  |    |   8 - Centro Esportivo|",
            "|    |___4__|   |  |¯¯|    |¯¯|  |¯¯|   |        |    |   9 - Praça           |", "|               |  |__| 2  |__|  |__|   |        |    |       Alimentação 03  |",
            "|               |_____________________5_|        |____|                       |", "|   |¯¯¯¯1¯¯¯|  |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|                  |",
            "|   |________|  |                                          |                  |", "|               |__________________________________________|                  |",
            " ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯ "};
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
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
