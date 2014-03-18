package thg;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Vastane {
	int elud;
	int damage;

	public void võitlus(Mängija a) {

		Scanner scan = new Scanner(System.in);
		String sisend = scan.nextLine();

		if (sisend.equals("s")) {
			try {
				TimeUnit.MILLISECONDS.sleep(700);
			} catch (InterruptedException e) {
				System.out.println("");
			}
			// Siin tuleb vastaselt elusid vähendada
			if (a.getPiirkond() < 9) { // Tugevamad võitluses
				elud -= (int) (Math.random() * 100 + 1);
				System.out.println(elud);
			} else { // Tugevamad koriluses
				elud -= (int) (Math.random() * 75 + 1);
				System.out.println(elud);
			}

			if (elud > 0) {
				// Kui esimese korraga vastane surma ei saanud, läheb mängijalt
				// ka elusid maha
				a.muudaElusid(damage);
				System.out.println("Vastane pole veel surnud, mida teed? [Võitlemiseks vajuta [S], põgenemiseks [E]]");
				võitlus(a);
			} else {
				System.out.println("Wohoo! Sinu võit, vastane sai surma, aga Sina jäid ellu.");
				System.out.println("Elusid on sul nüüd: " + a.getLives());

			}
		}

		else if (sisend.equals("e")) {
			System.out
					.println("Jooksed elu eest peitu. Võid pääseda terve nahaga, kuid vastane võib sind ka selja tagant rünnata.");
			// Võid pääseda terve nahaga, kuid vastane võib sind ka jälitada
			a.muudaElusid("-");
		}
	}

}
