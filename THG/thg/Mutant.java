package thg;

import application.Mang;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		final Stage kusimus = new Stage();
		Label label = new Label("Oi-oi, kuuled liikumist ja eikusagilt ilmub v�lja kole mutant. Mida teed? \n"
				+ "[V�itlemiseks vajuta [FIGHT], p�genemiseks [RUN]]");
		/*Button fight = new Button("FIGHT");
		Button run = new Button("RUN");
		run.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	kusimus.hide();
            	tkoht.setText("Jooksed elu eest peitu. V�id p��seda terve nahaga, kuid vastane v�ib sind ka selja tagant r�nnata.");
            	a.muudaElusid(damage);
            	stage.show();
            }
		});*/
		voitlus(a);
	}
}
