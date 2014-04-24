package thg;

import java.util.concurrent.TimeUnit;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import application.Mang;

public class Vastane {
	int elud;
	int damage;
	Text skoht = Mang.getSkoht();

	public void voitlus(final Mangija a){
		EventHandler<KeyEvent> filter2 = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				skoht.setWrappingWidth(390);
				if (a.getLives() < 1){
					return;
				}

				else if (event.getCode().equals(KeyCode.SPACE)) {
					try {
						
						try {
							TimeUnit.MILLISECONDS.sleep(700);
						} catch (InterruptedException e) {
							System.out.println("");
						}
						// M�ngija annab alati esimese hoobi, siin l�hevad vastasel elud maha
						if (a.getPiirkond() < 9) { // Tugevamad v�itluses
							elud -= (int) (Math.random() * 100 + 1);
						} else { // Tugevamad koriluses
							elud -= (int) (Math.random() * 75 + 1);
						}
						skoht.setText("Vastase elud: " + elud);
						if (elud > 0) {
							// Kui esimese korraga vastane surma ei saanud, l�heb m�ngijalt
							// ka elusid maha
							if(a.muudaElusid(damage) < 1){
								event.consume();
								return;
							}
							skoht.setText("Vastane pole veel surnud, mida teed? [V�itlemiseks vajuta [T�HIK], p�genemiseks [ENTER]]");
							voitlus(a);
						} 
						//Printimine teeb siinse kirjelduse �sna liiaseks
						else {
							skoht.setText("Wohoo! Sinu v�it, vastane sai surma, aga Sina j�id ellu.\n \r"
									+ "Elusid on sul n��d: " + a.getLives());
							event.consume();
							return;
						}
						event.consume();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else if (event.getCode().equals(KeyCode.ENTER)) {
					try {
						skoht.setText("Jooksed elu eest peitu. V�id p��seda terve nahaga, kuid vastane v�ib sind ka selja tagant r�nnata.\n \r"
								+ a.muudaElusid(damage));
						// V�id p��seda terve nahaga, kuid vastane v�ib sind ka j�litada
						//a.muudaElusid(damage);
						event.consume();
						return;
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				/*else{
					skoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
					voitlus(a);
				}*/
			}
		};
		TextField tekstivali = Mang.getTekstivali();
		tekstivali.addEventFilter(KeyEvent.KEY_PRESSED, filter2);
	}

}

