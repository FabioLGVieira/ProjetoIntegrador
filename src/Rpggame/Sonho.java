package Rpggame;

import java.util.Scanner;

public class Sonho {

    static void montarMenu() {
        System.out.println("        ====== Beyond the earth ===== ");
        System.out.println("      ===== Digite a opção desejada ===== ");
        System.out.println("             1 - Instruções ");
        System.out.println("                2 - Jogar ");
        System.out.println("                    3 - Créditos ");
        System.out.println("                        4 - Sair  ");
    }

    static void lerMenu() {
        montarMenu();
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                instrucoes();
                lerMenu();
                break;                
            case 2:
                jogar();                
                break;
            case 3:
                creditos();
                lerMenu();
                break;
            case 4:
                sair();                
                break;
        }
    }

    static void instrucoes() {
        System.out.println(" 1 ");
    }

    static void jogar() {
        sonho();
    }

    static void creditos() {
        System.out.println(" ********** Desenvolvido por ********** ");
        System.out.println("    ********** Fabio **********  ");
        System.out.println("        ********** Leonardo ********** ");
        System.out.println("            ********** Pedro ********** ");
        System.out.println(" ********** Projeto Integrador 1 ********** ");
        System.out.println(" Tecnologia em analise e desnvolvimento de sistemas ");
        System.out.println("          ********** Senac **********  ");
    }

    static void sair() {
        System.exit(0); 
    }
    static String verificaNome(String nome){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("[Digite seu nome...]");
            nome = sc.nextLine();
        } while (nome.isEmpty() || nome.equals("") || nome.charAt(0) == ' ');
        return nome;
    }
    
    static void sonho(String [][] v){
        System.out.println(" ========================================================================= ");
        System.out.println(" Voce é um aluno de Tecnologia em analise e desnvolvimento de sistemas ");
        System.out.println(" do Senac e está muito preocupado com a faculdade, não para de pensar ");
        System.out.println(" nela nem quando está dormino [...] ");
        System.out.println(" ========================================================================= ");
        System.out.println(" [...]Dutante o sonho ");
        System.out.println(" Voce esta chegando ao centro universitário senac para mais uma semana de aulas ");
        System.out.println(" e se depara com uma situação muito estranha [...] ");
        System.out.println(" Um et, isso mesmo, um et vem falar com voce[...] ");
        System.out.println(" ========================================================================= ");
        System.out.println(" Et: olá terráqueo, meu nome é Billy, venho de muito longe e voce foi o escolhido ");
        System.out.println(" Primeiramente me confirme seu nome, para ter certeza que é voce mesmo ");
        v[0][0] = verificaNome(v[0][0]);
        System.out.println("Voce mesmo! " + v[0][0]);
        System.out.println(v[0][0] + " : pra que fui escolhido ");
        System.out.println(" Billy: Para uma missão[...] ");
        System.out.println(" Nos ajudar a construir um foguete movido a base de nosso alimento preferido aqui na Terra ");
        System.out.println(" O foguete tem que ser movido a Cheadar, voce devera nos ajudar porque seu destino depende disso ");
        System.out.println(" Seus professores estão cientes de nossa invasão e eles o ajudaram a coletar peças para o nosso foguete " );
        System.out.println(" Fale com eles para consgui - las ");
        System.out.println(" ========================================================================= ");
    }

    public static void main(String[] args) {
        lerMenu();

    }

}
