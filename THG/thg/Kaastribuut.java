package thg;

import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;

public class Kaastribuut extends Vastane{

	public Kaastribuut(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}

	public Kaastribuut() {
		this.elud = 80;
		this.damage = 6;
	}

	public void võitlus_tribuudiga (Mangija a) throws InterruptedException{
		skoht.setWrappingWidth(390);
		skoht.setText("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja Sinu kaasvõistleja. Mida teed? \n"
				+ "[Võitlemiseks vajuta [TÜHIK], põgenemiseks [ENTER]]");
		voitlus(a);
	}
}

