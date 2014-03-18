package thg;

public class Mutant extends Vastane{
	int elud = 120;
    int damage = 8;
    
	public Mutant(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}
    
	public void võitlus_mutandiga (Mängija a){
		
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja kole mutant. Mida teed? \n"
				+ "[Võitlemiseks vajuta [S], põgenemiseks [E]]");
		võitlus(a);
	}
}
