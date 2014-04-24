package thg;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javafx.animation.Timeline;
import javafx.scene.text.Text;
import application.Mang;

public class Vastane {
	int elud;
	int damage;
	Text tkoht = Mang.getTkoht();
	public void voitlus(Mangija a) throws InterruptedException {

		Scanner scan = new Scanner(System.in);
		String sisend = scan.nextLine();
		if (a.getLives() < 1){
			return;
		}

		else if (sisend.equals("s")) {
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
			tkoht.setText("Vastase elud: " + elud);
			if (elud > 0) {
				// Kui esimese korraga vastane surma ei saanud, l�heb m�ngijalt
				// ka elusid maha
				if(a.muudaElusid(damage) < 1){
					return;
				}
				tkoht.setText("Vastane pole veel surnud, mida teed? [V�itlemiseks vajuta [S], p�genemiseks [E]]");
				TimeUnit.MILLISECONDS.sleep(700);
				voitlus(a);
			} 
			//Printimine teeb siinse kirjelduse �sna liiaseks
			else {
				tkoht.setText("Wohoo! Sinu v�it, vastane sai surma, aga Sina j�id ellu.");
				TimeUnit.MILLISECONDS.sleep(700);
				tkoht.setText("Elusid on sul n��d: " + a.getLives());
				return;

			}
		}

		else if (sisend.equals("e")) {
			tkoht.setText("Jooksed elu eest peitu. V�id p��seda terve nahaga, kuid vastane v�ib sind ka selja tagant r�nnata.");
			TimeUnit.MILLISECONDS.sleep(700);
			// V�id p��seda terve nahaga, kuid vastane v�ib sind ka j�litada
			a.muudaElusid(damage);
			return;
		}

		else{
			tkoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
			voitlus(a);
		}
	}

}
