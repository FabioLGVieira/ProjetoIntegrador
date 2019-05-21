package Rpggame;

import java.util.Random;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static String nome;
    static int progressoPlayer, progressoAdversários;
    static char resposta;
    static boolean pegouPapel = false, interesseConcurso = false;

    public static void main(String[] args) {
        progressoPlayer = 0;
        progressoAdversários = 0;
        menu();
    }

    public static void entradaCampus() {

        System.out.println(ambienteAtual("entrada"));
        if (progressoPlayer == 0) {
            String[] d = {"Voce esta chegando ao Centro Universitário Senac para seu primeiro dia de aula ...\n", "Ao chegar, um dos alunos da atlética vem falar com você.\n",};

            imprimirTexto(d);
            System.out.println("João: Bom dia, novo aluno! Como se chama?");
            System.out.println("[Digite seu nome...]");
            nome = sc.nextLine();
            nome = verificaNome(nome);
            String[] d2 = {"Seja bem-vindo ao Senac, " + nome + "!", "João: Qual o seu curso?", nome + ": Tecnologia em análise e desenvolvimento de sistemas ",
                "João: Sua sala é a C136, vá até lá, o professor vai passar algumas orientações"};
            imprimirTexto(d2);
            salavazia();
        } else if (progressoPlayer == 1) {
            System.out.println(nome + ": Vou me inscrever no concurso antes da aula!");
            strNext();
            biblioteca();
        }
    }

    public static void salavazia() {//uma das salas iniciais para mostrar o caminho ao player caso ele nao vá ao lugar certo
        System.out.println(ambienteAtual("lab136"));
        String[] d = {"Você chega na sala e não tem ninguém, só o professor...", nome + ": Com licença, é aqui a sala de TADS?",
            "Alexandre: É sim! Mas os alunos estão na biblioteca pegando o livro que pedi e vendo informações sobre o concurso que vai ter no Campus.",
            nome + ": Que legal! E que concurso é esse?", "Alexandre: é o Concurso Espacial do Senac, na biblioteca você terá melhores informaçoes"};
        imprimirTexto(d);
        comandosDisponiveis(2, "Ir agora?", "ficar e falar com o prof?");
        if (resposta == 'b') {
            String[] d2 = {nome + ": Já sei Java, vou ficar aqui até eles chegarem.", "Alexandre: Beleza então, abre o NetBeans ai e me faz um clone do Whatsapp aí.",
                "Alexandre: Se não conseguir, já está reprovado. Ou prefere ir na biblioteca?"};
            imprimirTexto(d2);
            comandosDisponiveis(1, "Biblioteca");
        }
        String[] d3 = {nome + ": Acho que vou lá mesmo...", "Alexandre: Pode ir! Só não esqueça do livro, o nome do livro é 'Java para Iniciantes'.",
            nome + ": Pode deixar, obrigado!"};
        imprimirTexto(d3);
        biblioteca();
    }

    static void biblioteca() {
        System.out.println(ambienteAtual("biblioteca"));
        switch (progressoPlayer) {
            case 0:

                String[] d = {"[...ouve outros alunos conversando sobre projetos para o Concurso...]", nome + ": O que é esse concurso?",
                    "Balconista: É o Primeiro Concurso Espacial do Centro Universitário Senac!", "Balconista: Quem se inscrever tem que realizar algum projeto sobre atividades fora da Terra, "
                    + "\ncomo viagens espaciais, atividades de pesquisa, ou evolução tecnológica!", "Por exemplo, alguns alunos já pensaram em criar cidades-bolha, casas ou edifícios em outros planetas, "
                    + "\ncarros flutuantes, robôs operários, super próteses, entre outros. E você, vai participar?"
                };
                imprimirTexto(d);
                comandosDisponiveis(2, "Sim", "Não");
                if (resposta == 'a') {
                    System.out.print(nome + ": Gostei muito da ideia, mas nao sei ainda o que fazer, vou pensar mais!");
                    sc.nextLine();
                    interesseConcurso = true;
                } else {
                    System.out.println(nome + ": Por enquanto não tenho interesse, obrigado!");
                }
                String[] d2 = {nome + ": Agora preciso pegar o livro que o professor pediu!", "[...procurando o livro nas estantes]", nome + ": O que é esse papel amassado no chão?"};
                imprimirTexto(d2);

                comandosDisponiveis(2, "Pegar o papel", "Ignorar");
                String[] d3 = {nome + ": Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?", nome + ": Bom, vou guardar... Quem sabe não seria um bom projeto para o concurso?!",
                    nome + ": Hmmm... achei o livro! Agora preciso voltar pra sala"};
                if (resposta == 'a') {
                    imprimirTexto(d3);
                    if (interesseConcurso == false) {
                        interesseConcurso = true;
                    }
                    pegouPapel = true;

                } else {
                    System.out.println(d3[2]);
                    sc.nextLine();
                }

                comandosDisponiveis(2, "Praça alimentação 01", "Voltar para a sala");

                if (resposta == 'a') {
                    System.out.println(nome + ": Tô com fome, vou comer antes e ver melhor o projeto, depois voltar pra sala.");
                    sc.nextLine();
                    pracaAlimentacao1();
                } else if (resposta == 'b') {
                    voltaParaSala();
                }
                break;
            case 1:

                String[] d4 = {"[...caminhando até a recepção da biblioteca]", "Balconista: decidiu se inscrever para o concurso?", nome + ": Decidi sim ",
                    "Balconista: Preencha a ficha.", " [...preenchendo a ficha]", nome + ": Prontinho!", " Balconista: Obrigado por participar," + nome + "! Boa sorte!"};
                imprimirTexto(d4);
                break;
        }
    }

    public static void pracaAlimentacao1() {
        System.out.println(ambienteAtual("praca01"));

        switch (progressoPlayer) {
            case 0:
                String[] d = {nome + ": Hey Paulo, quanto tempo não te vejo! Não lembrava que voce estudava aqui.", "Paulo: E aí," + nome + "! Eu stou no terceiro semestre de arquitetura",
                    nome + ": Que legal! Você se inscreveu para o Concurso Espacial?", "Paulo: Me inscrevi sim, estou pensando em algum projeto sobre como seria a arquitetura na lua. E o seu projeto?"};
                String d2[] = {nome + ": Eu ainda estou pensando se vou participar do concurso", "Paulo: Poxa, se eu fosse você eu participaria. É uma experiência muito legal!",
                    nome + ": Tá bom, eu vou participar, mas eu ainda tenho que pensar na ideia!", "Paulo: Hoje é seu dia de sorte! Eu achei esse papel jogado no chão, ao que tudo indica é um projeto de um foguete.",
                    "[Paulo te mostra o projeto...]", nome + ":Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?",
                    "Paulo: Pois é cara, faça bom proveito!", nome + "Pode deixar, obrigado!"};
                imprimirTexto(d);

                if (interesseConcurso == true) {
                    if (pegouPapel == true) {

                        comandosDisponiveis(2, "Contar sua ideia", "Comprar o lanche e analisar o projeto");
                        if (resposta == 'a') {
                            System.out.println(nome + " : Que idéia interessante! Eu ainda não decidi, mas estou pensando em construir um foguete...");
                            sc.next();
                        }
                    } else {
                        String[] d3 = {nome + ": Eu tenho interesse em participar do concurso, mas ainda não sei o que fazer...",
                            "Paulo: Hoje é seu dia de sorte! Eu achei esse papel jogado no chão, ao que tudo indica é um projeto de um foguete.",
                            "[Paulo te mostra o projeto...]", nome + ":Wow! É um projeto detalhado de um Foguete Espacial! Quem jogaria isso fora?",
                            "Paulo: Pois é cara, faça bom proveito!", nome + "Pode deixar, obrigado!"};

                        imprimirTexto(d3);
                        pegouPapel = true;
                    }

                } else {
                    imprimirTexto(d2);

                    if (interesseConcurso == false) {
                        interesseConcurso = true;
                    }
                }
                String d3[] = {nome + ": Eu estou um pouco atrasado, vou comprar meu lanche e voltar para a sala."
                    + "Depois conversamos, ok?", "Paulo: Tudo bem! Até mais.", " [...vendo o projeto do foguete] ", "[...relação de peças: tanque de combustivel,"
                    + "combustivel(hidrogenio), fuselagem, comida desidratada, turbina, asas, modulo de comando, traje espacial...]", nome + ": Agora vou voltar pra sala e ver se o "
                    + "professor Alexandre sabe onde consigo encontrar alguma das peças"};
                imprimirTexto(d3);
                voltaParaSala();
            case 1://comida desidratada
                centroGastronomico();
                break;
            case 3:
                
                break;
            case 5:
                centroGastronomico();
                break;
        }
    }

    public static void voltaParaSala() {

        System.out.println(ambienteAtual("lab136"));
        System.out.println("Alexandre: Muito bem turma, já que todos voltaram vou fazer algumas perguntas sobre programação. Quem acertar "
                + "terá alguma ajuda para o projeto do Concurso Espacial.");
        strNext();
        perguntaAlgoritimos();
    }

    public static void perguntaAlgoritimos() {
        int tentativas = 3;// numero de tentativas para acertar a pergunta e conseguir progredir
        String perguntas[] = {" Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é: "},
                respostasFaceis[][] = {{" while ", " if ", " do while ", " for "}};
        char corretaFaceis[] = {'d'}; //vetor de verificação das respostas
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
                System.out.println("Você errou! Tente novamente.");
                tentativas--;
            }
        } while (resposta != corretaFaceis[rnd] && tentativas > 0);
        if (resposta == corretaFaceis[rnd]) { //colocar uma funçao para a resposta CERTA 
            System.out.println("Resposta certa!");
            System.out.println("-----------------------------------\n");
            System.out.println(nome + ": Bom, já que acertei acho que o professor Alexandre vai me ajudar...");
            System.out.println("Alexandre: " + nome + " como posso te ajudar em seu projeto?");
            System.out.println(nome + " : Preciso de algumas peças: um tanque de combustivel, fuselagem e asas para um foguete, em que "
                    + " parte do campus posso encontrar esses itens? ");
            System.out.println(" Alexandre: no laboratório de design voce vai encontrar, procure o professor Otávio ");
            strNext();
            labDesign();
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
            charNext();
            if (resposta == 's') {
                perguntaAlgoritimos();
            }
            if (resposta == 'n' && progressoPlayer == 0) {
                System.out.println(nome + ": Bom, agora que acabou a aula acho que vou no laborátorio de mecânica "
                        + "\ntalvez o professor possa me ajudar");
                strNext();
                labDesign();
            }
        }
    }

    public static void labDesign() {
        System.out.println(ambienteAtual("labDesign"));
        switch (progressoPlayer) {
            case 0:
                String[] d1 = {"Professor Otávio: Bom dia aluno, como posso te ajudar? ", nome + " O professor Alexandre disse que voce poderia me ajudar com o projeto do concurso.",
                    "Professor Otávio: O que voce precisa? ", nome + " :de um tanque de combustivel, fuselagem e asas para um foguete ",
                    " Professor Otávio: posso imprimir estes objetos na nossa super impressora 3D em um material super resistente, voce teria o "
                    + "desenho destes itens? ", nome + " : tenho sim! ", "Professor Otávio: certo, vai demorar 1 dia pra ficar pronto, amanha mesmo voce pode pegar.",
                    nome + " : Amanhã não tenho aula...", "Professor Otávio: Mas venha ao campus amanhã pegar as peças!", nome + ": Pode deixar, obrigado!"};

                imprimirTexto(d1);
                entradaCampus();
                break;
            case 1:
                break;
        }
    }

    public static void nasa() {
        switch (progressoPlayer) {
            case 0:
                System.out.println(ambienteAtual("nasa"));
                break;
            case 1:
                break;
        }

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
                System.out.println("Voce errou! Tente novamente.");
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
        int perguntasFeitas[] = new int[perguntas.length];
        /*  boolean feito = false;        
        int rnd;
        for (int i = 0; i < perguntasFeitas.length; i++) {//preenche o vetor de perguntas feitas com um numero fora do tamanho
            perguntasFeitas[i] = perguntasFeitas.length+2;//assim, depois o elemento alterado se torna um numero para nao se repetir
        }
        do {
            rnd = randomico.nextInt(perguntas.length); // gera um numero para randomizar as perguntas perguntas
            for (int i = 0; i < perguntasFeitas.length; i++) {
                feito = false;
                if(rnd == perguntasFeitas[i])
                    feito = true;
                break;
            }
        } while (feito == true);*/
        int rnd = randomico.nextInt(perguntas.length);//deletar essa linha e descomentar em em cima depois de tirar a duvida

        System.out.println(perguntas[rnd] + ":"); //imprime a pergunta e as respostas possiveis de acordo com o numero randomico gerado
        System.out.println("a)" + respostasFaceis[rnd][0]);
        System.out.println("b)" + respostasFaceis[rnd][1]);
        System.out.println("c)" + respostasFaceis[rnd][2]);
        System.out.println("d)" + respostasFaceis[rnd][3]);
        do {
            System.out.println("Voce tem " + tentativas + " tentativas"); //diminui as tentativas de resposta caso responder errado
            charNext();
            if (resposta != corretaFaceis[rnd]) {
                System.out.println("Voce errou! Tente novamente.");
                tentativas--;
            }
        } while (resposta != corretaFaceis[rnd] && tentativas > 0);
        if (resposta == corretaFaceis[rnd]) {
            System.out.println("resposta certa");
            //perguntasFeitas[rnd] = rnd;//adiciona o numero da pergunta random para nao se repetir caso acerte
            //perguntaFacil();
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

    static String ambienteAtual(String sala) { // vai trocar o nome do ambiente ( e talvez as imagens de cada uma )
        switch (sala) {
            case "entrada":
                sala = "Entrada Principal";
                break;
            case "labDesign":
                sala = "Laboratorio de Design";
                break;
            case "praca01":
                sala = "Praca de Alimentacao 01";
                break;
            case "centroesportivo":
                sala = "Centro Esportivo";
                break;
            case "praca02":
                sala = "Praca de Alimentacao 02";
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
            case "centrogastronomico":
                sala = "Centro Gastronômico";
                break;
            case "nasa":
                sala = "Nasa";
                break;
        }
        return "\n===================================\nAmbiente atual: " + sala + "\n";
    }

    static void verificaSituacaoJogo() {// verifica se o player ou o adversario completou o projeto primeiro, e retorna o tipo de fim do jogo
        if (progressoPlayer == 7) {
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

    static void acessoLiberado() {
        System.out.println("== Acesso liberado ==");
        System.out.print("Prof. Gilberto: muito bem " + nome + " , parece que voce me encontrou, como posso te ajudar ? ");
        strNext();
        comandosDisponiveis(2, "Pedir ajuda", "outra opçao");
        if (resposta == 'a') {
            String[] s = {nome + ": estou precisando de peças para montar meu projeto espacial creio que o senhor poderia me ajudar.",
                "Prof. Gilberto: posso te ajudar sim, " + nome + ", porém voce terá de me responder uma pergunta.", "Voce está de acordo?"};
            imprimirTexto(s);
            comandosDisponiveis(2, "Sim", "Nao");
            if (resposta == 's') {
                perguntaFacil();
                System.out.println(ganhaPeca(true));
                //pracaAlimentacao3();
            } else {
                //gameOver();
            }
            System.out.println(" Parabéns " + nome + " com essa resposta certa voce ganha um item para o seu projeto ");
        } else if (resposta == 'b') {
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

    static void salaA125() {
        System.out.println(ambienteAtual("a125"));
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
    }

    public static void pracaAlimentacao3() {
        System.out.println(ambienteAtual("praca02"));
        switch (progressoPlayer) {
            case 0:
                String[] s = {"André: fala " + nome + ", fiquei sabendo que voce está participando do projeto espacial.", "O que voce está fazendo? ",
                    nome + ": não posso contar de jeito nenhum.", "André: o que é isso no seu bolso ? (pega o projeto e sai correndo) ",
                    nome + ": voce pegou meu projeto devolva agora!", "André: Só se você me pagar um lanche."};
                for (int i = 0; i < s.length; i++) {
                    System.out.print(s[i]);
                    strNext();
                }
                System.out.println("Deseja pagar um lanche para ter seu projeto de volta?");
                comandosDisponiveis(1, "Sim", "Não", "", "");
                if (resposta == 'a') {
                    System.out.println(" Conseguiu seu projeto de volta ");
                    nasa();
                } else if (resposta == 'b') {
                    EndGame(2);
                }
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
        System.out.println(nome + " Olá professor, hoje que voce vai passar um questionario ");
        System.out.println(" Isso mesmo, senta ai que já vou passar a pergunta ");
        perguntaFacil();
        //return ganhou;  
    }

    // O jogador vai fazer treinamentos de gravidade 0 na piscina
    public static void centroEsportivo() {
        System.out.println(ambienteAtual("centroesportivo"));
        if (progressoPlayer == 0) {
            System.out.println(nome + ": Olá onde posso encotrar o Ducival ?");
            strNext();
            System.out.println("Desconhecido: Ducival é o treinador, ele está na quadra ");
            comandosDisponiveis(2, "procurar treinador", "ir para centro gastronômico");
            if (resposta == 'a') {
                System.out.println(nome + ": Oi Ducival tenho um projeto de viagem espacial e precisaria de treinamento de gravidade 0");
                strNext();
                System.out.println("Ducival: O treinamento pode ser feito na piscina, vamos começar ?");
                comandosDisponiveis(2, "começar", "outra hora");
                if (resposta == 'a') {
                    strNext();
                    System.out.println("Treinamento cncluido "
                            + "\nParte do treinamento foi concluido");
                    strNext();
                    // ir para um outro lugar 
                } else {
                    System.out.println(nome + ": vou para o centro gastronômico começamos depois ");
                    strNext();
                    centroGastronomico();
                }
            }
            if (resposta == 'b') {
                centroGastronomico();
            }
        }
    }

    //Aqui é onde o player vai desenvolver comida em tubo
    static void centroGastronomico() {
        System.out.println(ambienteAtual("centrogastronomico"));
        //ainda vou mexer
        switch(progressoPlayer){
            case 1:
        System.out.println("[Varios veteranos de Gastronomia estão fazendo confraternização com os bichos]");
        System.out.println(nome + ": Oi, o prof Leonildo disse para eu pedir ajuda para o pessoal de Gastronomia, sobre meu projeto para o Concurso");
        System.out.println("Veterano: Que bacana! O que vai ser? E diga lá, em que voce precisa de ajuda.");
        System.out.println(nome + ": É um foguete! E para poder ir ao espaço irei precisar de alimento.");
        System.out.println("Sei que preciso tirar 97% da água dos alimentos, mas não sei fazer isso. Por isso vim pedir ajuda...");
        System.out.println("Veterano: De fato, vai ficar muito mais facil de levar com menos peso!");
        System.out.println("Podemos te ajudar sim, mas demora um bom tempo, fala comigo daqui 3 dias que estará tudo pronto!");
        System.out.println("Mas antes de voce correr atrás do restante do projeto, me diga/dê o que pretende levar.");//decidir se ele vai conseguir os alimentos antes
        System.out.println(nome+": Beleza, vou levar...");
        String inventario[] = new String[5];
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(" Coloque o alimento: ");
            inventario[i] = strNext();
        }
        System.out.println("Veterano: Bacana, ja vou começar o processo de desidratar, boa sorte no projeto!");
        System.out.println(nome+": Obrigado, outro dia venho pegar então. Agora vou procura a proxima parte");

        //desenvolver alguma historia que aborde o processo de tirar 97% da agua dos alimentos
        //de preferencia: fazer o player saber sobre isso antes do progresso estiver em 3 ou mais. Entao ele recebe a comida ja desidratada.
        //pode ser na praça de alimentação 1 tbm, por estar perto do predio gastro
                break;
            case 5:
                break;
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

    static char verificaComando(int op) {// 1 para respostas a, b ,c ,d   2 para s, n.  \ para finalizar o programa
        charNext();//le o comando do usuario
        if (resposta == '\\') {//para o comando \ funcionar precisa de duas(\\), \ é um escape character, com 2 eles se cancelam
            System.exit(1);//termina o programa
        }
        switch (op) {// diferencia entre as opçoes de salas ou açoes do usuario, das opçoes de escolhas entre sim ou nao
            case 1://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 1 )
                while (resposta != 'a') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
            case 2://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 2 )
                while (resposta != 'a' && resposta != 'b') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
            case 3://escolhas de opçoes ou salas                         opçao relativo a quantidade de opçoes disponiveis ( 3 )
                while (resposta != 'a' && resposta != 'b' && resposta != 'c') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
            case 4://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 4 )
                while (resposta != 'a' && resposta != 'b' && resposta != 'c' && resposta != 'd') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
        }
        return resposta;//retorna o input do usuario
    }

    static String verificaNome(String nome) {//verifica se o nome contem muitos espaços ou se começa com espaço ou é null
        char[] c = new char[nome.length()];
        int n = 0;
        for (int i = 0; i < c.length; i++) {
            c[i] = nome.charAt(i);
            if (c[i] == ' ') {
                n++;
            }
        }
        while (n >= 2 || nome == null || nome.charAt(0) == ' ') {
            System.out.println("[Digite seu nome...]");
            nome = sc.nextLine();
            n = 0;
        }
        return nome;
    }

    static void imprimirTexto(String v[]) {//recebe o Vetor de Dialogo dos NPCs e imprime na tela
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            strNext();
        }// strNext() serve como pausa entre uma frase e outra
    }

    static char charNext() {//pega o input do usuario em todas as partes do jogo
        resposta = sc.next().toLowerCase().charAt(0);
        sc.nextLine();
        return resposta;
    }

    public static String strNext() {//pega o input do usuario em todas as partes do jogo que nao sejam opçoes e mais de um caractere, e serve de pausa do dialogo
        String pegaComando = sc.nextLine().toLowerCase();
        return pegaComando;
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
        sc.nextLine();
        do {//pequena verificaçao para o usuario estar apto a continuar
            comandosDisponiveis(2, "Jogar", "Voltar ao menu");
            charNext();
            if (resposta == 'a') {
                System.out.println("Vamos começar nossa aventura!");
                entradaCampus();
            } else if (resposta == 'b') {
                menu();
            } else {
                System.out.println("Comando inválido.\n");
            }
        } while (resposta != 'a' && resposta != 'b');
    }

    public static void menu() {//menu inicial responsavel por apresentar opçoes ao usuario
        String[] s = {"      Beyond the earth   ", "\n --------------------------", "\n|       --> Menu <--       |", "\n| 1- Instruções            |",
            "\n| 2- Jogar                 |", "\n| 3- Ir para o fim do jogo |", "\n| 4- Créditos              |", "\n| 5- Sair                  |",
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
                entradaCampus();
                break;
            case 3:
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
