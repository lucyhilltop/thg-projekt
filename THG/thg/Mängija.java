package thg;

public class Mängija {
	
	int lives = 100;
	String nimi;
	int piirkond;
	
	public Mängija(String nimi, int piirkond) {
		this.lives = 100;
		this.nimi = nimi;
		this.piirkond = piirkond;
	}
	
	public int lives1(String a, int lives){
		if (a=="+"){
			lives += (int)(Math.random()*50 +1);
			if(lives > 150){
				lives = 150;
			}
		}
		else{
			lives -= (int)(Math.random()*100 + 1);
			if (lives < 1){
				gameover();
			}
		}
		
		System.out.println("Elusid on Sul nüüd: " + lives);
		return lives;
	}
	
	public int lives1(int lives, int damage){
		lives =- (int)(Math.random()* (damage * 10) + 1);
		if (lives < 1){
			gameover();
		}
		System.out.println("Elusid on Sul nüüd: " + lives);
		return lives;
		
	}
	
	public int päevad(int a){
		System.out.println("Seekord õnnestus sul päev üle elada.. ");
		a += 1;
		if (a== 5){
			gameover(a);
		}
		return a;
	}
	
	public void gameover(){
		System.out.println("Kahjuks kõlas kahuripauk ning sinust ei saanud järgmist Näljamängude võitjat...");
	}
	
	public void gameover(int a){
		System.out.println("JESS!! SINA oledki uusim Näljamängude võitja!");
	}
	
	public void sammude_kirjeldus(int h, int v){
		if (h==1){
			if (v==0){
				System.out.println("VULKAANIJALAM [^] [v] SÜGAV ORG JÕEGA");
				System.out.println("KÜLLUSESARV [<] [>] METS");
			}
			else if (v==-2){
				System.out.println(" METS [^] [v] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println(" ORUPÕHI [<] [>] METS");
			}
			else if (v==-1){
				System.out.println(" METS [^] [v] METS ");
				System.out.println(" ORUNÕLV[<] [>] METS");
			}
			else if (v==2){
				System.out.println(" EI SAA KÄIA, SIIN ON AREENI PIIR[^] [v] VULKAANIJALAM");
				System.out.println(" VULKAANITIPP [<] [>] METS");
			}
			else{
				System.out.println(" VULKAANIJALAM[^] [v] METS");
				System.out.println(" VULKAANIJALAM[<] [>] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				System.out.println(" METS[^] [v] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println(" METS[<] [>] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				System.out.println(" METS [^] [v] METS");
				System.out.println(" SÜGAV ORG JÕEGA[<] [>] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				System.out.println("METS [^] [v] METS");
				System.out.println("METS [<] [>] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				System.out.println("METS [^] [v] METS");
				System.out.println(" VULKAANIJALAM[<] [>] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [^] [v] METS");
				System.out.println("VULKAANIJALAM [<] [>] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){
				System.out.println("ORUNÕLV [^] [v] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [<] [>] METS");
			}
			else if (v==-1){
				System.out.println(" KÜLLUSESARV [^] [v] SÜGAV ORG JÕEGA");
				System.out.println(" VEEKOGU[<] [>]SÜGAV ORG JÕEGA ");
			}
			else if (v==0){
				System.out.println("VULKAANIJALAM [^] [v] ORUNÕLV");
				System.out.println("VEEKOGU [<] [>] METS");
			}
			else if (v==1){
				System.out.println("VULKAANITIPP [^] [v] KÜLLUSESARV");
				System.out.println("VULKAANIJALAM [<] [>] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [^] [v] VULKAANIJALAM");
				System.out.println("VULKAANIJALAM [<] [>] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				System.out.println("VEEKOGU [^] [v] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [<] [>] SÜGAV ORG JÕEGA");
			}
			else if (v==-1){
				System.out.println("VEEKOGU [^] [v] SÜGAV ORG JÕEGA");
				System.out.println("POOLSAAR [<] [>] ORUNÕLV");
			}
			else if (v==0){
				System.out.println("VULKAANINÕLV [^] [v] VEEKOGU");
				System.out.println("POOLSAAR [<] [>] KÜLLUSESARV");
			}
			else if (v==1){
				System.out.println("VULKAANINÕLV [^] [v] VEEKOGU");
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [<] [>] VULKAANINÕLV");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [^] [v] VULKAANINÕLV");
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [<] [>] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				System.out.println("POOLSAAR [^] [v] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [<] [>] SÜGAV ORG JÕEGA");
			}
			else if (v == -1){
				System.out.println("POOLSAAR [^] [v] VEEKOGU");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [<] [>] VEEKOGU");
			}
			else if (v ==0){
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [^] [v] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [<] [>] VEEKOGU");
			}
			else if (v ==1){
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [^] [v] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [<] [>] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [^] [v] TÜHERMAA/KIVISTUNUD LAAVA");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [<] [>] VULKAANINÕLV");
			}
		}
		
	}
	
	public void juhtumid(int päevad){
		int juhtum = (int)(Math.random()*5+1);
		if (juhtum == 1){
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
		else if (juhtum ==4){
			päevad(päevad);
		}
		else{
			Ressurss l = new Ressurss();
			l.langevari(this);
		}
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
