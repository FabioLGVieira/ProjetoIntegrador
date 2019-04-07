
package Rpggame;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Segurança do Senac - Bom dia jovem estudante, ja viu sobre o Concurso Espacial? Deixe-me primeiramente"
                + "lhe dizer sobre os comandos. A barra de comando abaixo serve para movimentaçao e açoes. Voce pode digitar "
                + "/comandos para ver todos os comandos validos do jogo. Me diga seu nome:");
        String nome=sc.nextLine();
        System.out.println("Muito bem, " + nome + " Agora se dirija ate a biblioteca para saber sobre o Concurso!");
    }
}
