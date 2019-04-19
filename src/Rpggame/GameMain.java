package Rpggame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameMain {

    static Random randomico = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean running = false;
    static String pegaComando;

    public static void main(String[] args) {
        menu();
    }

    public static void game() {
        //running = true;
    	
    	System.out.println("Voce esta chegando na universidade Senac, e agora sua aventura comeca ..."
    			+ "\n"
    			+ "\n"
    			+ " .-------------------------------------------------------------.\r\n" + 
    			"'------..-------------..----------..----------..----------..--.|\r\n" + 
    			"|       \\\\            ||          ||          ||          ||  ||\r\n" + 
    			"|        \\\\           ||          ||          ||          ||  ||\r\n" + 
    			"|    ..   ||  _    _  ||    _   _ || _    _   ||    _    _||  ||\r\n" + 
    			"|    ||   || //   //  ||   //  // ||//   //   ||   //   //|| /||\r\n" + 
    			"|_.------\"''----------''----------''----------''----------''--'|\r\n" + 
    			".______________________________________________________________|\r\n" + 
    			" |)|      |       |       |       |    |      mga|      ||==|  |\r\n" + 
    			" | |      |  _-_  |       |       |    |  .-.    |      ||==| C|\r\n" + 
    			" | |  __  |.'.-.' |   _   |   _   |    |.'.-.'.  |  __  | \"__=='\r\n" + 
    			" '---------'|( )|'----------------------'|( )|'----------\"\"\r\n" + 
    			"             '-'                          '-'\r\n" + 
    			"\r\n" + 
    			"\r\n" + 
    			" \r\n" + 
    			"");
    	
        System.out.println("Seguran�a do Senac - Bom dia jovem estudante seja bem vindo ao Senac, a confraternizacao dos calouros"
        		+ " esta sendos realizada la na frente, voce pode pegar um atalho pela bilbioteca."
                + "\nA proposito qual � seu nome ?");
        sc.nextLine();
        String nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
        System.out.println("Muito bem, " + nome + ". boa sorte");
        System.out.println("Comandos disponiveis: biblioteca | salas");

        //tutorial pro player aprender alguns comandos
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
        if (pegaComando.equals("pegar")) {
            System.out.println("Wow é um projeto detalhado de um Foguete Espacial, quem deixaria isso aqui?");
        } else {
            System.out.println("Vou pegar esse livro de Java e reprovar na prova mesmo!");
        }
    }

    public static void perguntaFacil() {
        int tentativas = 3;
        int rnd = randomico.nextInt(2); //perguntas
        String perguntas[] = {"O conjunto {x (pertence) R / 2,5 < x <= 15} pode ser representado pelo seguinte intervalo",
            "O número 255 na base decimal, pode ser representado, respectivamente, nas bases Binária, Octal e Hexadecimal por",
            "Quantos bits há em 2 bytes", "A expressão (a-b)³ pode ser representada por",
            " Para executar um mesmo bloco de código por determinadas vezes, o melhor a se fazer é: "},
                respostasFaceis[][] = {{"[ 10/4 ; 15 ]", "[ 2,5 ; 15 [", "] 10/4 ; 15 ]", "] 2,5 ; 15 ["}, //respostas das perguntas
                {"01100110, 356 ,EE", "00001111, 380, EF", "11111111, 377, FF", "11110000, 374, FE"},
                {"8", "16", "32", "64"}, {"a³ - 3a³b + 3ab³ + b³", "a³ + 3a³b + 3ab³ + b³", "a³ - 3a³b - 3ab³ - b³", "a³ - 3a³b - 3ab³ + b³"}
                ,{" while " , " if ", " do while ", " for "}},
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
        if (resposta == corretaFaceis[rnd]) {
            System.out.println("resposta certa");
        } else {
            System.out.println("Gostaria de tentar outra pergunta? S/ N");
        }
        resposta = sc.next().toLowerCase().charAt(0);
        if (resposta == 's') {
            perguntaFacil();
        }
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
    
    //Personagens
    
    public static void Paulo() {
    	System.out.println("                      ;;\\\\/;;;;;;;;\r\n" + 
    			"                   ;;;;;;;;;;;;;;;;;\r\n" + 
    			"                ;;;;;;;;;;;;     ;;;;;\r\n" + 
    			"               ;;;;;    ;;;         \\;;\r\n" + 
    			"              ;;;;;      ;;          |;\r\n" + 
    			"             ;;;;         ;          |\r\n" + 
    			"             ;;;                     |\r\n" + 
    			"              ;;                     )\r\n" + 
    			"               \\    ~~~~ ~~~~~~~    /\r\n" + 
    			"                \\    ~~~~~~~  ~~   /\r\n" + 
    			"              |\\ \\                / /|\r\n" + 
    			"               \\\\| %%%%%    %%%%% |//\r\n" + 
    			"              [[====================]]\r\n" + 
    			"               | |  ^          ^  | |\r\n" + 
    			"               | | :@: |/  \\| :@: | |\r\n" + 
    			"                \\______/\\  /\\______/\r\n" + 
    			"                 |     (@\\/@)     |\r\n" + 
    			"                /                  \\\r\n" + 
    			"               /  ;-----\\  ______;  \\\r\n" + 
    			"               \\         \\/         /\r\n" + 
    			"                )                  (\r\n" + 
    			"               /                    \\\r\n" + 
    			"               \\__                  /\r\n" + 
    			"                \\_                _/\r\n" + 
    			"                 \\______/\\/\\______/\r\n" + 
    			"                  _|    /--\\    |_\r\n" + 
    			"                 /%%\\  /\"'\"'\\  /%%\\\r\n" + 
    			"  ______________/%%%%\\/\\'\"'\"/\\/%%%%\\______________\r\n" + 
    			" / :  :  :  /  .\\%%%%%%%\\\"'/%%%%%%%/.  \\  :  :  : \\\r\n" + 
    			")  :  :  :  \\.  .\\%%%%%%/'\"\\%%%%%%/.  ./  :  :  :  (\r\n" + 
    			"");
    }
    
    public static void Amanda() {
    	System.out.println("               .,,: ,.\r\n" + 
    			"           .-:++++XXXXXX\r\n" + 
    			"         .,:+++XXXXXXXXXXX\r\n" + 
    			"        .++:++XXXXXXXXXX@XX\r\n" + 
    			"       .++:+++XXX+++X+XXXXXXX\r\n" + 
    			"       ,+::+:::.-----++++XXXX\r\n" + 
    			"      .-::+ .-'       .XX@++X@\r\n" + 
    			"      .,:::|      .-.  |+@X+XXM\r\n" + 
    			"       ,:-:| .-'       |+XX+XXM\r\n" + 
    			"       ==-::\\    _.    '.X+XXX@\r\n" + 
    			"       -:+:::\\          |XXX@X@\r\n" + 
    			"       ..:+++:\\  --'   .XXXX@X@M\r\n" + 
    			"         .:+:++'.____.|+XXX@@@@MMM\r\n" + 
    			"           ,-:+:+\\     \\+X++:+++XXM\r\n" + 
    			"       ____=:++++/      |-,,/     :\\\r\n" + 
    			"      . /-.              /,/       ::\r\n" + 
    			"     - |-|              /-/        |;\r\n" + 
    			"    '  |-|             /-:'        |:\r\n" + 
    			"    |  |-|     '      /==/         |:\r\n" + 
    			"   /\"\\ |/     ;     ,,--/         /.\r\n" + 
    			"  /\\  : \\__..'    .-'-:/         /:\r\n" + 
    			" /\\   '.--=-'----'.,-:/         /:.\r\n" + 
    			" |    -,.-==-=----=-=/         /:.\r\n" + 
    			" |-_     '_-====-=--/         /+|\r\n" + 
    			"|   .      \"-,___--'.-       /++.\r\n" + 
    			"|    '.            / /      /:+.\r\n" + 
    			" .     '..       .'  '._--'\\++.\r\n" + 
    			"  '.      '-----'         -/X@|\r\n" + 
    			"    '._   .              -/X@M|\r\n" + 
    			"       '''------._____..-'+MMM|\r\n" + 
    			"        |...,,-,,, '-====:+@MM| mga");
    }
    
    public static void Eduardo() {
    	System.out.println("       ***********\r\n" + 
    			"    ***** ***********\r\n" + 
    			" ** ****** *** ********\r\n" + 
    			"****  ******  ** *******\r\n" + 
    			"***     ******* ** ******\r\n" + 
    			"***       **        *  **\r\n" + 
    			" *|/------  -------\\ ** *\r\n" + 
    			"  |       |=|       :===**\r\n" + 
    			"   |  O  |   | O   |  }|*\r\n" + 
    			"    |---- |   ----  |  |*\r\n" + 
    			"    |    |___       |\\/\r\n" + 
    			"    |              |\r\n" + 
    			"    \\   -----     |\r\n" + 
    			"     \\           |\r\n" + 
    			"       -__ -- -/");
    }
    public static void Wesley() {
    	System.out.println("                   ((   )  (\r\n" + 
    			"               ( (   )(( (   )\r\n" + 
    			"             )    ) ( )) )( (( )\r\n" + 
    			"             ( (((   )  (  )  ) )\r\n" + 
    			"            )) (( ) (          ((\r\n" + 
    			"           (  )) )  ____   ____ )\r\n" + 
    			"            ) ( ) `|<();|-|,()>|\r\n" + 
    			"           ( ))(    `--'  \\`--'\r\n" + 
    			"           )( ( )       (- )   )\r\n" + 
    			"             ))        _____  /\r\n" + 
    			"               )   `     --  /\r\n" + 
    			"                _ ,  `   __,\r\n" + 
    			"     ,  -- ---'//        /\r\n" + 
    			"   /          / \\       /\r\n" + 
    			"  /           \\  \\     /|\r\n" + 
    			"               \\ /|   / /`.\r\n" + 
    			"                  |  / /   `.\r\n" + 
    			"                  | /\\/      `.\r\n" + 
    			" ejm              |/           |\r\n" + 
    			"                  '            |\r\n" + 
    			"                               |\r\n" + 
    			"\r\n" + 
    			"------------------------------------------------\r\n");
    }
    public static void Marina() {
    	System.out.println("                    _\r\n" + 
    			"            ,--,--.;  `__ ,-.\r\n" + 
    			"           /.-'    \\  /  )   \\\r\n" + 
    			"          (        .--.  ,-.  ))\r\n" + 
    			"         (        (     Y   \\ ( )\r\n" + 
    			"        (         /          `.)(\r\n" + 
    			"       ()        /             ( )\r\n" + 
    			"       ((       (   _           )(\r\n" + 
    			"        )    (  ) .' `-.   .-'. ( )\r\n" + 
    			"        (( _  )(    __       _  /)(\r\n" + 
    			"        ( /.`( (   <()>     <O>/( )\r\n" + 
    			"         )||  ))                \\ ))\r\n" + 
    			"        ( \\(- ((           \\     .((\r\n" + 
    			"         ) \\./|)         (  )    .))\r\n" + 
    			"        (     )(                 ;(\r\n" + 
    			"        )     ()       .--.--.   /)\r\n" + 
    			"        (      )).      `--.-'  /(\r\n" + 
    			"        /      (  `.           /  )\r\n" + 
    			"       (        )   `-.      .'   (\r\n" + 
    			"   akg  \\              `-.--'\r\n" + 
    			"\r\n" + 
    			"------------------------------------------------\r\n");
    }
    public static void Lucas() {
    	System.out.println("                         ___   ___\r\n" + 
    			"                     _.-'   '/�_  '-.\r\n" + 
    			"                 _.-'   _ --\\/ _ \\  `'\\\r\n" + 
    			"                / _  -    _--\\/  \\  \\  `\\\r\n" + 
    			"               / /           _L      \\   |\r\n" + 
    			"              | /      .,-'''  \\     \\    \\\r\n" + 
    			"             /    /   /         |         |.\r\n" + 
    			"            /        ,'         '  |   \\   |\r\n" + 
    			"            |    |   |          :   |   |  \\\r\n" + 
    			"           /     |   |          |   |   |   |\r\n" + 
    			"           /  /    | |          \\    \\  \\  `|\r\n" + 
    			"          J  /  /  | |           \\       \\_ |\r\n" + 
    			"          |  |    /  ) _.,,.      \\_  \\     .>\r\n" + 
    			"          \\        .:'`'_```'    /''\\_ _  _->\\\r\n" + 
    			"           \\   __.-` /<808_>|   |<sjw>`\\`'  ,\\\r\n" + 
    			"            |/|\\T        / /     `-_    |/ ||\r\n" + 
    			"            | LJ|               |       || /\r\n" + 
    			"            `\\ *            .   `       /' �\r\n" + 
    			"            > \\_,          (_    |     *J |\r\n" + 
    			"           <'`   \\           `'/�      - |{\r\n" + 
    			"        _<`'   < \\                    /|  |\r\n" + 
    			"        _>   <    \\     `<-':'-':'-   / |  }\r\n" + 
    			"        _/\\ <   < |A       .,___,-   /|  \\/\r\n" + 
    			"       /  <   <   |'M.       ```    /| |\\|\r\n" + 
    			"    _.,    <   <  | ''M.           / -'\\_\r\n" + 
    			" /'` /      |/|  o . '''A.      _-`-/ \\_ `-,\r\n" + 
    			"    /         >'/o   ' ''''''''' |      \\   '.\r\n" + 
    			"   /            \\ o      ' ' ' 'o|           |\r\n" + 
    			"   |         \\_  \\ o   '  '  '. o'  /        |\\-.\r\n" + 
    			"  /            \\__\\_o           o`|/        /    `\\\r\n" + 
    			"  |,._              \\o         o  /       _/        \\\r\n" + 
    			"      \\              |oo       o |`      /           |\r\n" + 
    			"       \\,._           \\ oo    o  /      /            \\\r\n" + 
    			"           `'|_        \\  oo o  /     _/              |\r\n" + 
    			"               \\        \\   o   |    /                |sjw\r\n" + 
    			"\r\n" + 
    			"------------------------------------------------\r\n");
    }
    
    public static void Paulina() {
    	System.out.println("                    ,-------.\r\n" + 
    			"                 __/#########\\\r\n" + 
    			"               _/#############\\\r\n" + 
    			"              /################|\r\n" + 
    			"             /##################\\\r\n" + 
    			"            /####################\\\r\n" + 
    			"           /##########/..'|#######|\r\n" + 
    			"          |##########|..   \\#######|\r\n" + 
    			"          |#########/       |######|\r\n" + 
    			"         |#########|  ..     .\\##~#|\r\n" + 
    			"         |########/  ..   __, .|#:||\r\n" + 
    			"         |#######|-.    ,/ _   |#:|#\\\r\n" + 
    			"         |#######/W>::  .<W/.  |/;'##|\r\n" + 
    			"         |######|  .;;   `     'w'###|\r\n" + 
    			"         |######|  ,;'  . ..   |#####|\r\n" + 
    			"         |######|  ;(   _).    |#####\\\r\n" + 
    			"         |######|  . `-'   `   |######`\r\n" + 
    			"         |######\\ .  _;_       /#######\r\n" + 
    			"        /########\\  <-(,\\`;   /########\r\n" + 
    			"       |#########|\\,--.\\;`.  /|########\r\n" + 
    			"      /##########/;;-.;\\\\.;\\  |########\r\n" + 
    			"     |######/`/~'  ;(\\\\. \\\\.`.|########\r\n" + 
    			"    /######/|/| ;  (\\\\;\\\\  ,' \\######A#\r\n" + 
    			"   /##|\\#| / /  :   \\;\\ `  . .:#####| \\\r\n" + 
    			"   |##\\ ||.__|      :\\ , '     |####/ ;\r\n" + 
    			"   |#| \\//   .\\      :\\.       |###| ;'\r\n" + 
    			"   |#| ||..   .\\      ;;\\.  .  |###|; /\r\n" + 
    			"   |#|  |\\.   ..\\      ;;|     |###| /,\r\n" + 
    			"    \\|   |\\.   ..\\      ;;|   .|\\##||:\r\n" + 
    			"     \\\\  | \\.   ..\\     ;;|.   | \\| |:\r\n" + 
    			"   m1a\\  |  \\.   ..\\    :;|.    |  /;\r\n" + 
    			"\r\n" + 
    			"------------------------------------------------\r\n");
    }
    public static void Maria() {
    	System.out.println("            .;zs.rtbs.\r\n" + 
    			"          ,dNMBPSri$$$b.\r\n" + 
    			"         sNMNBPZSsr'YOJD\r\n" + 
    			"        ;NMNBPZSsP*\"\"iTNS\r\n" + 
    			"        JNBPZP''.      \\S$\r\n" + 
    			"        TNBP' ._'       ;P\r\n" + 
    			"        ,\"f  _,==.    ._:'\r\n" + 
    			"        : `   -.e.` .'_e;\r\n" + 
    			"        `',         \\\r\n" + 
    			"         |:  `     ,-  '\r\n" + 
    			"      .--: \\      __  /\r\n" + 
    			"   .-'    `.`.   `--, -.\r\n" + 
    			"  /  _..    `-`-.___/   `.\r\n" + 
    			" :.-\"   `*.    `.`*-.-.   \\\r\n" + 
    			" /         `.    `-. `-:   ;\r\n" + 
    			":            `.     `-. \\  :\r\n" + 
    			";              \\       ` ;\r\n" + 
    			"     _.         \\        :  ;\r\n" + 
    			" ;     `-.       `.  .   '  :\r\n" + 
    			" :       :fi.      `-._.'.\r\n" + 
    			"         iRKMbs.          \\ ;\r\n" + 
    			"  `     d*BuG*HBAs._        ;\r\n" + 
    			"   `._.dBNMWMBZNMMJHbs.._..'\r\n" + 
    			"     TBNMWMNBPLYOYJSBNY\r\n" + 
    			"      VBNMWMBZSYOJHKNWJ\r\n" + 
    			"       SBNMWMBPSYJSBNMZ\r\n" + 
    			"       IBNWMBRXLJHKNWSi    b'ger\r\n" + 
    			"\r\n" + 
    			"------------------------------------------------\r\n");
    }
    public static void Raul() {
    	System.out.println("             8888888888888\r\n" + 
    			"          88888o8888888o88888\r\n" + 
    			"        888o88888888o8888o88888\r\n" + 
    			"      888888888888o88888888888888\r\n" + 
    			"     8888o88             888888888\r\n" + 
    			"    88888888             88888o888\r\n" + 
    			"    8888888              888888o888\r\n" + 
    			"   888888                 8o8888888\r\n" + 
    			"  88 888 ,*8888o, ,o8888*, 8888 88 8\r\n" + 
    			" 8888888 '`(0))`~ ~`((0)`' 8888888 8\r\n" + 
    			" 8888888l  `'` `; ;` `'`   88888888 8\r\n" + 
    			"  88 8888       ; d;       8888888 88\r\n" + 
    			"  8888888       ( 7,       8888 888  8\r\n" + 
    			" 88888888      @@@@@@      888888888 8\r\n" + 
    			" 8 88888o   ,@@@@@@@@@, , o8888888  88\r\n" + 
    			"88888888`o  @@;~^~^~;@@ 0;`8 8888888\r\n" + 
    			"8888 88 8`v    `@@@`    o`88888 888 8\r\n" + 
    			"88888888  `;,        ,;o`8 88888888 8\r\n" + 
    			" 8 8888     `o,  ,;,;o` 888888 88 8\r\n" + 
    			" 8888 88      ``'''`     88 8888888 8\r\n" + 
    			"88888888                  8 8888 8888\r\n" + 
    			"8888888                    88  888888\r\n" + 
    			"                                888888\r\n" + 
    			"                                888888\r\n" + 
    			"");
    }
    public static void Bruna() {
    	System.out.println("             .g$$$Sbp.                        \r\n" + 
    			"           .d$$$$SSS$$Sp.                     \r\n" + 
    			"          dS$$$$SS$$$$$SSb.                   \r\n" + 
    			"         :S$$$$$SSSS$$$$$SSb                  \r\n" + 
    			"         $S$$$$$$SS$SSSSSS$S;                 \r\n" + 
    			"        :$$$S$$SS^\"^^\"\"^TSSS:                 \r\n" + 
    			"        $$$S$$SP         T$SS;                \r\n" + 
    			"       :$$$S$SP           $$SS                \r\n" + 
    			"       $$$S$$$            :$$S;               \r\n" + 
    			"      :$$$S$$;=-.     ,-=^.T$$Sb              \r\n" + 
    			"      $$$SS$$.__.\\    .__. $S$$$b             \r\n" + 
    			"    .d$$SS$$; \"\"       \"\"  :SSS$$;            \r\n" + 
    			"   d$$SSS$$$               :S$$S$$            \r\n" + 
    			"  :$$SS$$$$;      ._.      $$S$$$$            \r\n" + 
    			"  $$SS$$$$S$b    .___.    d$$$S$$;            \r\n" + 
    			"  :SSS$$S$S$$b   \\.-./   d$$$$S$P`.           \r\n" + 
    			"   `^S$S$$SS$$b.  `-'  .'\\^T$P^'   \\          \r\n" + 
    			"      TS^T$SSSP `.___.'   \\       __\\___      \r\n" + 
    			"            .:             `.   .'.--\\  `.    \r\n" + 
    			"     bug  .' ;               :./ /    \\   \\   \r\n" + 
    			"       .-\" __:__.         .--;\"\\:      ;   ;  \r\n" + 
    			"    .-\"\"\"\"\"   \\     `--'    :   ;      :   :  \r\n" + 
    			"  .'           `.           ;   :       ;   ; \r\n" + 
    			" /               `.        /     ;      :   : \r\n" + 
    			":                  \"-.    /      :       \\   ;\r\n" + 
    			";                     `-.'        ;       \\  :\r\n" + 
    			";        \\             ( )        :        \\  \r\n" + 
    			":         ;             \"          ;        \\ \r\n" + 
    			" ;        : ;            ;   __..mm:         \\\r\n" + 
    			" :        :/         __..NmMMMMMMMMM;         \r\n" + 
    			"  ;       :   _..mmMMMMMMNNMMMMMMMMMM         \r\n" + 
    			"  :        MMMMMMMMMMMMMMNNMMMMMMMMMM;        \r\n" + 
    			"   ;       :NMMMMMMMMMMMMNMMMMMMMMMMMM        \r\n" + 
    			"   :        NNMMMMMMMMMMMMMNNNMMMMMMMM;       \r\n" + 
    			"    ;       :NNNMMMMMMMMNMMMNNNNNNNNNNN       \r\n" + 
    			"    :        MNNNNNNMMNNMMMMMMNNNNNNNMMb");
    }
}
