package thg;

public class Mutant extends Vastane{

    public Mutant() {
    	elud = 120;
    	damage = 8;
    }
    
	public Mutant(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}
    
	public void v�itlus_mutandiga (Mangija a){
		
		System.out.println("Oi-oi, kuuled liikumist ja eikusagilt ilmub v�lja kole mutant. Mida teed? \n"
				+ "[V�itlemiseks vajuta [S], p�genemiseks [E]]");
		voitlus(a);
	}
}
