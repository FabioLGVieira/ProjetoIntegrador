package Rpggame;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static String nome;
    static int progressoPlayer, progressoAdversários;
    static char resposta;

    public static void main(String[] args) {
        progressoPlayer = 0;
        progressoAdversários = 0;
        menu();
    }

    public static void inicioGame() {
        String[] d = {"Voce esta chegando ao Centro Universitário Senac para seu primeiro dia de aula ...\n", "Ao chegar, um dos alunos da atlética vem falar com você.\n",};

        System.out.println(ambienteAtual("entrada"));
        imprimirTexto(d);
        System.out.println("João: Bom dia, novo aluno! Como se chama?");
        System.out.println("[Digite seu nome...]");
        nome = sc.nextLine();
        String[] d2 = {"Seja bem-vindo ao Senac, " + nome + "!", "João: Qual o seu curso?", nome + ": Tecnologia em análise e desenvolvimento de sistemas ",
            "João: Sua sala é a C136, vá até lá, o professor vai passar algumas orientações"};
        imprimirTexto(d2);
        salavazia();
    }

    public static void salavazia() {//uma das salas iniciais para mostrar o caminho ao player caso ele nao vá ao lugar certo
        System.out.println(ambienteAtual("lab136"));
        String[] d = {"Você chega na sala e não tem ninguém, só o professor...", nome + ": Com licença, é aqui a sala de TADS?",
            "Alexandre: É sim! Mas os alunos estão na biblioteca pegando o livro que pedi e vendo informações sobre o concurso que vai ter no Campus.",
            nome + ": Que legal que concurso que é esse?", "Alexandre: é o Concurso Espacial do Senac, na bibliote voce terá melhores informaçoes"};
        imprimirTexto(d);
        comandosDisponiveis(2, "Ir agora?", "ficar e falar com o prof?");

        if (resposta == 'a') {
            strNext();
        } else if (resposta == 'b') {
            System.out.print(nome + ": Já sei Java, vou ficar aqui até eles chegarem.");
            sc.nextLine();
            strNext();
            System.out.print("Alexandre: Beleza então, abre o NetBeans ai e me faz um clone do Whatsapp ai.");
            strNext();
            System.out.println("Alexandre: Se não conseguir, já está reprovado. Ou prefere ir na biblioteca?");
            comandosDisponiveis(1, "Biblioteca");
        }
        String[] d2 = {nome + ": Acho que vou lá mesmo...", "Alexandre: Pode ir! Só não esqueça do livro, o nome do livro é 'Java para Iniciantes'.",
            nome + ": Pode deixar, obrigado!"};
        biblioteca();
    }

    static void biblioteca() {
        System.out.println(ambienteAtual("biblioteca"));
        if (progressoPlayer == 0) {
            System.out.println("Você chega na biblioteca e logo percebe outros alunos conversando sobre projetos para o Concurso...");
            comandosDisponiveis(3, "Conversar com a balconista", "Procurar o livro", "Sair da Biblioteca");

            if (resposta == 'b') {
                //gameOver();
            } else if (resposta == 'c') {
                System.out.println(nome + ": Onde vou achar esse livro de Java?");
                System.out.println("Talvez devesse ver sobre o concurso...");
            }
            System.out.print(nome + ": O que é esse concurso?");
            strNext();
            System.out.print(" Balconista: É o Primeiro Concurso Esapacial do Centro Universitário Senac ");
            System.out.println(" Quem se inscrever tem que realizar algum projeto sobre atividades fora da Terra ");
            System.out.println(" Como viagens espaciais, atividades de pesquisa, ou evolução tecnológica!");
            strNext();
            System.out.print("Por exemplo, alguns alunos ja pensaram "
                    + "em criar cidades-bolha, casas ou edifícios em outros planetas, carros flutuantes, robôs operários,"
                    + "\nsuper proteses, entre outros. E voce, vai participar?\n");
            comandosDisponiveis(2, "S", "N", "", "");
            if (resposta == 'n') {
                System.out.println("Por enquanto nao");
                //gameOver();
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
                //gameOver();
            }
        }
        comandosDisponiveis(1, "Praça de alimentação 1", "Sala de Aula", "", "");
        if (resposta == 'a') {
            pracaAlimentacao1();
        } else if (resposta == 'b') {
            intervaloC136();
        } else if (progressoPlayer == 1) {
        }
    }

    public static void intervaloC136() {

        System.out.println("\n======================================================================================================================\n");
        System.out.println(" ...voltando para sala após pegar o livro e voce se depara com a porta fechada e um aviso "
                + " sobre o intervalo e que o professor volta em breve ");
        System.out.println("\n======================================================================================================================\n");

        pracaAlimentacao1();
    }

    public static void pracaAlimentacao1() {
        System.out.println("\n======================================================================================================================\n" + ambienteAtual("praca01"));
        if (progressoPlayer == 0) {
            System.out.println(nome + " : Hey Paulo, quanto tempo não te vejo não lembrava que voce estudava aqui ");
            strNext();
            System.out.println(" Paulo: Sim, estudo aqui, estou no terceiro semestre de arquitetura ");
            strNext();
            System.out.println(nome + " : Que legal, voce tambem se inscreveu para o Concurso Espacial? ");
            strNext();
            System.out.println(" Paulo: Me inscrevi sim, estou pensando em algum projeto sobre como seria a arquitetura na lua e o seu projeto? ");
            strNext();
            System.out.println(nome + " : Que idéia interessante, não posso entrar em detalhes sobre meu projeto, tenho medo que me copíem, a proposito,"
                    + " voce sabe onde é a Nasa, hoje é meu primeiro dia e estou meio perdido ainda, o campus é enorme ");
            strNext();
            System.out.println(" Ah, boa sorte em seu projeto, a Nasa fica logo ali, só seguir por aquele cooredor e entrar por uma porta de vidro ");

            comandosDisponiveis(1, "Voltar para sala", "Nasa", "Biblioteca", "");
            if (resposta == 'a') {
                voltadointervalo();
            } else if (resposta == 'b') {
                nasa();
            } else if (resposta == 'c') {
                //gameOver();
            }

        }

    }

    public static void voltadointervalo() {

        System.out.println("\n======================================================================================================================\n");
        System.out.println(" Alexandre: muito bem turma, já que todos voltaram vou fazer algumas perguntas sobre programação, quem acertar "
                + " terá alguma ajuda para o projeto do Concurso Espacial ");
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
                perguntaAlgoritimos();
            }
        }
    }

    public static void nasa() {

        System.out.println("\n======================================================================================================================\n");
        System.out.println(nome + " Vou pesquisar alguma coisa para meu projeto e assim que terminar volto pra sala ");
        strNext();
        voltadointervalo();
        System.out.println("\n======================================================================================================================\n");

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
                sala = "centroesportivo";
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
        }
        return "\n===================================\nAmbiente atual: " + sala + "\n";
    }

    static void verificaSituacaoJogo() {// verifica se o player ou o adversario completou o projeto primeiro, e retorna o tipo de fim do jogo
        if (progressoPlayer == 7) {
            System.out.println(EndGame(1));
        }
        if (progressoAdversários == 10) {
            System.out.println(EndGame(3));
        };
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
        //System.out.println("disponiveis: pedir ajuda | perguntar se vai ter prova");
        if (resposta == 'a') {
            String[] s = {nome + ": estou precisando de peças para montar meu projeto espacial creio que o senhor poderia me ajudar.",
                "Prof. Gilberto: posso te ajudar sim, " + nome + ", porém voce terá de me responder uma pergunta.", "Voce está de acordo?"};
            imprimirTexto(s);
            comandosDisponiveis(5, "Sim", "Nao");
            System.out.println("Comandos Disponiveis: S | N");
            charNext();
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

    public static void labDesign() {
        int senha = 0;
        System.out.println(ambienteAtual("labDesign")); //mostra q o player foi para outro ambiente
        switch (progressoPlayer) {
            case 0:
                System.out.print(nome + ": Preciso falar com o prof Gilberto, mas o lab ta fechado e está pedindo uma senha.");
                strNext();
                System.out.println("  Teclado da fechadura ");
                System.out.println("  Digite a senha: ");
                senha = sc.nextInt();
                if (senha != 7446) {
                    System.out.print(nome + ": Acho que eu devia falar com o segurança, ele deve ter a chave!");
                    sc.nextLine();
                    strNext();
                } else {
                    acessoLiberado();
                }
                String[] s = {nome + " : segunrança, preciso entrar no laboratório pra falar com o professor Gilberto.", nome + " : Voce poderia abrir o laboratótio para mim?",
                    "Segurança: Não posso te passar a senha, mas posso te dar algumas dicas:", "Ela é um numero de 4 digitos e está em binário: ", " 111 100 100 110‬ "};
                imprimirTexto(s);
                System.out.println("  Teclado da fechadura ");
                System.out.println("  Digite a senha: ");
                senha = sc.nextInt();
                while (senha != 7446) {
                    System.out.println("  Digite a senha: ");
                    senha = sc.nextInt();
                }
                acessoLiberado();
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

    static void corredor() {
        System.out.println(ambienteAtual("corredor"));
        switch (progressoPlayer) {
            //tem q arrumar essa bagaça aqui 
            case 0:
                System.out.println(nome + "Bom, pensando bem ... é um foguete."
                        + "\nAcho que vou conseguir mais informações no laboratório de mecanica\n"
                        + "Olá meu nome é " + nome + " estou procurando o professor de mecanica"
                        + "\nAmanda : Olá eu sou Amanda muito prazer , você esta atras do professor Claudio ele fica naquela sala "
                        + "\nvem comigo ...");
                System.out.println(" O que você tem em mãos ? posso ver ? ");
                System.out.println(" comandos disponiveis  s | n ");
                if (resposta == 's') {
                    System.out.println(" voce mostrou seu projeto, tente não mostrar novamente ");
                    System.out.println(" Amanda é uma boa pessoa, tome cuidado com quem ve seu projeto ");
                    System.out.println(" Amanda : É um projeto completo de um foguete com motor de fusão nuclear ");
                    System.out.println(" Você vai montar isso S|N ? ");
                    if (resposta == 's') {
                        System.out.println(" vou sim ");
                    } else {
                        System.out.println(" calma ai, não nos conhecemos direito ainda ");
                    }
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

    /*public static void nasa() {
     System.out.println(salaAtual("labDesign"));
     if (progressoJogo == 0) {
     String[] s = {nome + ": Preciso usar um dos computadores para fazer uma pesquisa para meu projeto.","Mas parece que não estou conseguindo ligar.",
     "Eduardo: tirei o cabo de enrgia do seu computador. Voce vai ter que me ajudar pra ter de volta.",nome + ": O que voce precisa? ",
     "Eduardo: preciso de uma dica para meu projeto."};
     for (int i = 0; i < s.length; i++) {
     System.out.print(s[i]);
     strNext();
     }
     comandosDisponiveis(1, "Dar a dica", "Não dar dica", "Corredor", "");
     if (resposta == 'a') {
     System.out.println(" Voce conseguiu ligar o computador ");
     System.out.println(nome + ": agora só estudar ");
     sala2();
     } else if(resposta == 'c'){
     corredor();
     }else {
     System.out.println(" Não conseguiu ligar o computador ");
     gameOver();
     }
     } switch (progressoPlayer) {
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
        System.out.println("Você está agora no centro esportivo :"
                + "\nprocure Paula, ela terá uma tarefa para você "
                + "\n\nAções disponiveis  | procurar paula | sair |");
        strNext();
        if (resposta == 'a') {
            System.out.println("Paula - Olá " + nome + " veio fazer o treinamento de gravidade 0 ?"
                    + "\nbom então vamos lá");
            try {
                Thread.sleep(1000);
                System.out.println("Pronto, agora você está preparado para gravidade 0");

            } catch (InterruptedException ex) {
                Logger.getLogger(GameMain.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (resposta == 'a') {
            System.out.println("Onde deseja ir ? "
                    + "\nlugares disponiveis  | lab mecanica");
            strNext();
            if (resposta == 'a') {
                ambienteAtual("labMec");
            }

        }
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

        //desenvolver alguma historia que aborde o processo de tirar 97% da agua dos alimentos
        //de preferencia: fazer o player saber sobre isso antes do progresso estiver em 3 ou mais. Entao ele recebe a comida ja desidratada.
        //pode ser na praça de alimentação 1 tbm, por estar perto do predio gastro
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
            case 1://escolhas de opçoes ou salas                        opçao relativo a quantidade de opçoes disponiveis ( 2 )
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
            case 5://escolhas sim ou nao                        opçao relativo tipo de escolhas disponiveis ( Sim ou Nao )
                while (resposta != 's' && resposta != 'n') {
                    System.out.println("Comando inválido.");
                    charNext();//le o comando do usuario
                }
                break;
        }
        return resposta;//retorna o input do usuario
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
        System.exit(1);//termina o programa
        return fim;
    }

    /*public static void salavazia() {//uma das salas iniciais para mostrar o caminho ao player caso ele nao vá ao lugar certo
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
     }*/
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
                inicioGame();
                break;
            case 3:
                nasa(); // apenas acelerar o teste, tirar futuramente
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
