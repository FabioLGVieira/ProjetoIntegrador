/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author fabio.lgvieira
 */
public class StartMenu {
	private String nome;
	private Player obj = new Player();
	private Scanner ler = new Scanner(System.in);
	
	public void menuBehav() {
		System.out.println("Preparado para iniciar sua jornada em (um nome aqui)?");
		System.out.println("Digite seu nome:");
		generatePlayer();
	}

	public void generatePlayer() {
		nome = ler.nextLine();
		obj.setNomePlayer(nome);
		obj.setHp(50);
		obj.setMp(60);
		obj.setOuro(150);
		obj.setAtq(35);
		obj.setDef(40);
		obj.setPeso(15);
		ler.close();

	}
	
}
