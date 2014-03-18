package thg;

public class Kaastribuut extends Vastane{
	int elud = 80;
	int damage = 6;
	public Kaastribuut(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}
	
	public void võitlus_tribuudiga (Mängija a){
	
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja Sinu kaasvõistleja. Mida teed? \n"
				+ "[Võitlemiseks vajuta [S], põgenemiseks [E]]");
		võitlus(a);
	}
		
public static void main(String[] args) {
		Mängija katniss = new Mängija("Katniss", 10);
		võitlus_tribuudiga(katniss);	
	}	
}

