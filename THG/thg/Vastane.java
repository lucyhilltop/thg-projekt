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
			// Mängija annab alati esimese hoobi, siin lähevad vastasel elud maha
			if (a.getPiirkond() < 9) { // Tugevamad võitluses
				elud -= (int) (Math.random() * 100 + 1);
			} else { // Tugevamad koriluses
				elud -= (int) (Math.random() * 75 + 1);
			}
			tkoht.setText("Vastase elud: " + elud);
			if (elud > 0) {
				// Kui esimese korraga vastane surma ei saanud, läheb mängijalt
				// ka elusid maha
				if(a.muudaElusid(damage) < 1){
					return;
				}
				tkoht.setText("Vastane pole veel surnud, mida teed? [Võitlemiseks vajuta [S], põgenemiseks [E]]");
				TimeUnit.MILLISECONDS.sleep(700);
				voitlus(a);
			} 
			//Printimine teeb siinse kirjelduse üsna liiaseks
			else {
				tkoht.setText("Wohoo! Sinu võit, vastane sai surma, aga Sina jäid ellu.");
				TimeUnit.MILLISECONDS.sleep(700);
				tkoht.setText("Elusid on sul nüüd: " + a.getLives());
				return;

			}
		}

		else if (sisend.equals("e")) {
			tkoht.setText("Jooksed elu eest peitu. Võid pääseda terve nahaga, kuid vastane võib sind ka selja tagant rünnata.");
			TimeUnit.MILLISECONDS.sleep(700);
			// Võid pääseda terve nahaga, kuid vastane võib sind ka jälitada
			a.muudaElusid(damage);
			return;
		}

		else{
			tkoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
			voitlus(a);
		}
	}

}
