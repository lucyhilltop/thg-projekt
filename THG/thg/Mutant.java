package thg;

import application.Mang;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Mutant extends Vastane{
	public Mutant() {
		elud = 120;
		damage = 8;
	}

	public Mutant(int elud, int damage) {
		this.elud = elud;
		this.damage = damage;
	}

	public void voitlus_mutandiga (Mangija a) throws InterruptedException{
		//final Stage kusimus = new Stage();
		skoht.setWrappingWidth(390);
		skoht.setText("Oi-oi, kuuled liikumist ja eikusagilt ilmub välja kole mutant. Mida teed? \n"
				+ "[Võitlemiseks vajuta [TÜHIK], põgenemiseks [ENTER]]");
		/*Button fight = new Button("FIGHT");
		Button run = new Button("RUN");
		run.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	kusimus.hide();
            	tkoht.setText("Jooksed elu eest peitu. Võid pääseda terve nahaga, kuid vastane võib sind ka selja tagant rünnata.");
            	a.muudaElusid(damage);
            	stage.show();
            }
		});*/
		voitlus(a);
	}
}
