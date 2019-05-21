/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rpggame;

/**
 *
 * @author fabio.lgvieira
 */
public class Duvidas {//classe destinadas a apresentar duvidas ao professor de forma mais direta e objetiva
    public static void main(String[] args) {
        teste();// chama a funçao
        teste();//chama a mesma funçao depois de alterada
    }
    
    static void teste(){
    int[] t = {1,2,3,4,5,6};//vetor inicial
    
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);//printa vetor
        }
        t[1]= 9;//altera o elemento do vetor
        t[3]= 9;//altera o elemento do vetor
    }
}
