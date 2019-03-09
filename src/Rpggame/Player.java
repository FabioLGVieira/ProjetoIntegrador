/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

/**
 *
 * @author fabio.lgvieira
 */
public class Player { // encapsulamento dos atributos da cria��o do personagem do Player

	private String nomePlayer;
	private int hp, mp, ouro, atq, def, peso;

	/**
	 * @return the nomePlayer
	 */
	public String getNomePlayer() {
		return nomePlayer;
	}

	/**
	 * @param nomePlayer
	 *            the nomePlayer to set
	 */
	public void setNomePlayer(String nome) {
		this.nomePlayer = nome;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp
	 *            the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}

	/**
	 * @param mp
	 *            the mp to set
	 */
	public void setMp(int mp) {
		this.mp = mp;
	}

	/**
	 * @return the ouro
	 */
	public int getOuro() {
		return ouro;
	}

	/**
	 * @param ouro
	 *            the ouro to set
	 */
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	/**
	 * @return the atq
	 */
	public int getAtq() {
		return atq;
	}

	/**
	 * @param atq
	 *            the atq to set
	 */
	public void setAtq(int atq) {
		this.atq = atq;
	}

	/**
	 * @return the def
	 */
	public int getDef() {
		return def;
	}

	/**
	 * @param def
	 *            the def to set
	 */
	public void setDef(int def) {
		this.def = def;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

}
