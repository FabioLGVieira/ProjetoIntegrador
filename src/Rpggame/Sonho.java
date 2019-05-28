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
          
    static void imprimirTexto(String vet []){
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet [i]);
        }
    }
    
    
    static void sonho(){
        System.out.println(" ========================================================================= ");
        String d1[] = {" Voce é um aluno de Tecnologia em analise e desnvolvimento de sistemas \n",
        " do Senac e está muito preocupado com a faculdade, não para de pensar \n", 
        " nela nem quando está dormino [...] \n"};
        imprimirTexto(d1);
        System.out.println(" ========================================================================= ");
        String d2 [] = {" [...]Dutante o sonho \n ",
        " Voce esta chegando ao centro universitário senac para mais uma semana de aulas \n",
        " e se depara com uma situação muito estranha [...] \n",
        " Um et, isso mesmo, um et vem falar com voce[...] \n"};
        imprimirTexto(d2);        
        System.out.println(" ========================================================================= ");
        String d3 [] = {" Et: olá terráqueo, meu nome é Billy, venho de muito longe e voce foi o escolhido \n",
        " Primeiramente me confirme seu nome, para ter certeza que é voce mesmo o escolhido \n"};        
        imprimirTexto(d3);
        System.out.println(" ========================================================================= ");
        String d4 [] = {"Voce mesmo! \n", " : pra que fui escolhido ", " Billy: Para uma missão[...] ", 
        " Nos ajudar a construir um foguete movido a base de nosso alimento preferido aqui na Terra ",
        " O foguete tem que ser movido a Cheadar, voce devera nos ajudar porque seu destino depende disso ",
        " Fale com eles para consgui - las "};      
        imprimirTexto(d4);        
        System.out.println(" ========================================================================= ");
        String d5 [] = {" Para conseguir sua primeira peça siga até a Nasa e fale com um de meus amigos "};
        imprimirTexto(d5);
    }
    
    //primeira peça: tanque de cheddar
    static void Nasa(){
    //falar com amigo do et da entrada    
    }
    static void salaAdm(){
    //pergunta adm
    //pegar tanque de cheddar
    }
    
    //segunda peça:fuselagem
    static void Nasa2(){
    //falar de novo com o amigo do et    
    }
    static void estacionamento(){
        
    }
    static void salaPreCalculo(){
    //pergunta pré calculo
    //pegar fuselagem
    }
    //terceira peça: turbina
    static void Nasa3(){
    //falar de novo com o amigo do et    
    }
    static void cubao(){
        
    }
    static void salaConceitos(){
    //pergunta conceitos
    //pegar turbina
    }
    //quarta peça: computador de bordo 
    static  void Nasa4(){
    //falar de novo com o amigo do et    
    }
    static void cit(){
    //centro de inovação tecnologica    
    }
    static void salaAlgoritimos(){
    //pergunta algoritimos
    //pegar computador de bordo
    }
    //quinta peça: comida
    static void Nasa5(){
    //falar de novo com o amigo do et    
    }
    static void p1(){
    //pegar comida    
    }
    static void labMecanica(){
    //montar o foguete
   //entregar o foguete    
    }      
          
    public static void main(String[] args) {
        lerMenu();

    }

}
