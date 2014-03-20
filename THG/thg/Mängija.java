package thg;

public class M�ngija {
	
	int lives;
	String nimi;
	int piirkond;
	int p�ev;
	
	public M�ngija(String nimi, int piirkond) {
		this.lives = 100;
		this.nimi = nimi;
		this.piirkond = piirkond;
		p�ev = 0;
	}
	
//Elude maha (ja juurdelisamise) meetodid
	public int muudaElusid(String a){
		if (a=="+"){
			lives += (int)(Math.random()*50 +1);
			if(lives > 150){
				lives = 150;
			}
		}
		else{
			lives -= (int)(Math.random()*100 + 1);
		}
		
		System.out.println("Elusid on Sul n��d: " + lives);
		return lives;
	}
	
	public int muudaElusid(int damage){
		lives -= (int)(Math.random()* (damage * 10) + 1);
		System.out.println("Elusid on Sul n��d: " + lives);
		return lives;
		
	}
	
	//M�ngu l�pu kirjeldused
	public void gameover(){
		if (lives < 1)
			System.out.println("Kahjuks k�las kahuripauk ning sinust ei saanud j�rgmist N�ljam�ngude v�itjat...");
		else
			System.out.println("JESS!! SINA oledki uusim N�ljam�ngude v�itja!");
	}
		
	//boolean, et teaks, kas m�ng on l�bi v�i mitte. Aga see meetod genereerib siis randomly erinevaid juhtumeid, mida m�ngija l�bida saab.
	public boolean juhtumid(){
		int juhtum = (int)(Math.random()*6+1);
		int eba�nn = (int)(Math.random()*100 +1);
		
		if (eba�nn == 13){
			Ressurss v = new Ressurss();
			v.vulkaan();
			lives = 0;
		}
		else if (juhtum == 1){
			Mutant m = new Mutant();
			m.v�itlus_mutandiga(this);
		}
		else if (juhtum == 2){
			Ressurss r = new Ressurss();
			r.metsamari(this);
		}
		else if (juhtum == 3){
			Kaastribuut k = new Kaastribuut(80,6);
			k.v�itlus_tribuudiga(this);
		}
		else if (juhtum == 4){
			System.out.println("Sul �nnestus end hoolikalt varjates p�ev �le elada..");
			p�ev ++;
		}
		else{
			Ressurss l = new Ressurss();
			l.langevari(this);
		}
		return lives > 0 && p�ev != 5;
	}
	
		
	
	int getLives() {
		return lives;
	}
	void setLives(int lives) {
		this.lives = lives;
	}
	String getNimi() {
		return nimi;
	}
	void setNimi(String nimi) {
		this.nimi = nimi;
	}
	int getPiirkond() {
		return piirkond;
	}
	void setPiirkond(int piirkond) {
		this.piirkond = piirkond;
	}
}
