package thg;

public class Mängija {
	
	int lives;
	String nimi;
	int piirkond;
	int päev;
	
	public Mängija(String nimi, int piirkond) {
		this.lives = 100;
		this.nimi = nimi;
		this.piirkond = piirkond;
		päev = 0;
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
		
		System.out.println("Elusid on Sul nüüd: " + lives);
		return lives;
	}
	
	public int muudaElusid(int damage){
		lives -= (int)(Math.random()* (damage * 10) + 1);
		System.out.println("Elusid on Sul nüüd: " + lives);
		return lives;
		
	}
	
	//Mängu lõpu kirjeldused
	public void gameover(){
		if (lives < 1)
			System.out.println("Kahjuks kõlas kahuripauk ning sinust ei saanud järgmist Näljamängude võitjat...");
		else
			System.out.println("JESS!! SINA oledki uusim Näljamängude võitja!");
	}
		
	//boolean, et teaks, kas mäng on läbi või mitte. Aga see meetod genereerib siis randomly erinevaid juhtumeid, mida mängija läbida saab.
	public boolean juhtumid(){
		int juhtum = (int)(Math.random()*6+1);
		int ebaõnn = (int)(Math.random()*100 +1);
		
		if (ebaõnn == 13){
			Ressurss v = new Ressurss();
			v.vulkaan();
			lives = 0;
		}
		else if (juhtum == 1){
			Mutant m = new Mutant();
			m.võitlus_mutandiga(this);
		}
		else if (juhtum == 2){
			Ressurss r = new Ressurss();
			r.metsamari(this);
		}
		else if (juhtum == 3){
			Kaastribuut k = new Kaastribuut(80,6);
			k.võitlus_tribuudiga(this);
		}
		else if (juhtum == 4){
			System.out.println("Sul õnnestus end hoolikalt varjates päev üle elada..");
			päev ++;
		}
		else{
			Ressurss l = new Ressurss();
			l.langevari(this);
		}
		return lives > 0 && päev != 5;
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
