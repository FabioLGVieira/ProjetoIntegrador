
package Rpggame;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ------------------");
        System.out.println("|  --> Menu <--    |\n"
                + "| 1- Instruções    | \n| 2- Jogar         | \n| 3- Pontos ganhos |\n"
                + "| 4- Créditos      |\n| 5- Sair          |");
        System.out.println(" ------------------");
        System.out.println("Digite uma opção:");
        int option = sc.nextInt();

        switch (option) {

            case 1:
                System.out.println("Instruções: \n"
                        + "Você entrou em instruções.");
                break;

            case 2:
                System.out.println("Segurança do Senac - Bom dia jovem estudante, ja viu sobre o Concurso Espacial? Deixe-me primeiramente"
                        + "lhe dizer sobre os comandos. \n A barra de comando abaixo serve para movimentaçao e açoes. Voce pode digitar "
                        + "/comandos para ver todos os comandos validos do jogo. Me diga seu nome:");
                sc.nextLine(); 
                String nome = sc.nextLine();//IMPORTANTE: o nextLine come a quebra de linha do scanner anterior, por isso, é necessário fazer o comando acima para que funcione corretamente.
                System.out.println("Muito bem, " + nome + " Agora se dirija ate a biblioteca para saber sobre o Concurso!");
                break;

            case 3:
                System.out.println("Pontos ganhos: ");
                break;

            case 4:
                System.out.printf("=== Developed by: === %n=> Fabio Vieira %n=> Leonardo Barbosa"
                        + "%n=> Pedro Arantes %n=> Vagner %n");
                break;

            case 5:
                System.out.println("Você escolheu sair.");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
