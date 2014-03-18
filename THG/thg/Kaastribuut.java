package thg;

public class Kaastribuut extends Vastane{
	int elud;
	int damage;
	public Kaastribuut(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}
	
	public Kaastribuut() {
		this.elud = 80;
		this.damage = 6;
	}

	public void võitlus_tribuudiga (Mängija a){
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja Sinu kaasvõistleja. Mida teed? \n"
				+ "[Võitlemiseks vajuta [S], põgenemiseks [E]]");
		võitlus(a);
	}
}

