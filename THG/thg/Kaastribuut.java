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

	public void v�itlus_tribuudiga (Mangija a){
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub v�lja Sinu kaasv�istleja. Mida teed? \n"
				+ "[V�itlemiseks vajuta [S], p�genemiseks [E]]");
		voitlus(a);
	}
}

