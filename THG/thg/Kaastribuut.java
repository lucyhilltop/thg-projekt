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

	public void v�itlus_tribuudiga (Mangija a) throws InterruptedException{
		skoht.setWrappingWidth(390);
		skoht.setText("Oi-oi, kuuled liikumist ja eikusagilt ilmub v�lja Sinu kaasv�istleja. Mida teed? \n"
				+ "[V�itlemiseks vajuta [T�HIK], p�genemiseks [ENTER]]");
		voitlus(a);
	}
}

