package rpggame;

public class Monster {  //classe geradora dos monstros(com seus atributos) enfrentados pelo player

	private int hp, atq, def;
	
	public void wildDog() {
		hp = 15;
		atq = 10;
		def = 8;
	}
	
	public void bear() {
		hp = 20;
		atq = 15;
		def = 16;
	}
	
	public void falcon() {
		hp = 15;
		atq = 14;
		def = 5;
	}
}
