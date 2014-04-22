package thg;

public class Kaastribuut extends Vastane{

	public Kaastribuut(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}
	
	public Kaastribuut() {
		this.elud = 80;
		this.damage = 6;
	}

	public void võitlus_tribuudiga (Mangija a){
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja Sinu kaasvõistleja. Mida teed? \n"
				+ "[Võitlemiseks vajuta [S], põgenemiseks [E]]");
		voitlus(a);
	}
}

