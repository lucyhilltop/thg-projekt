package thg;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Vastane {
	int elud;
	int damage;

	public void v�itlus(M�ngija a) {

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
			System.out.println("Vastase elud: " + elud);
			if (elud > 0) {
				// Kui esimese korraga vastane surma ei saanud, l�heb m�ngijalt
				// ka elusid maha
				if(a.muudaElusid(damage) < 1){
					return;
				}
				System.out.println("Vastane pole veel surnud, mida teed? [V�itlemiseks vajuta [S], p�genemiseks [E]]");
				v�itlus(a);
			} 
			//Printimine teeb siinse kirjelduse �sna liiaseks
			else {
				System.out.println("Wohoo! Sinu v�it, vastane sai surma, aga Sina j�id ellu.");
				System.out.println("Elusid on sul n��d: " + a.getLives());
				return;

			}
		}

		else if (sisend.equals("e")) {
			System.out.println("Jooksed elu eest peitu. V�id p��seda terve nahaga, kuid vastane v�ib sind ka selja tagant r�nnata.");
			// V�id p��seda terve nahaga, kuid vastane v�ib sind ka j�litada
			a.muudaElusid(damage);
			return;
		}
		
		else{
			System.out.println("Oioi, vajutasid midagi valesti, proovi uuesti");
			v�itlus(a);
		}
	}

}
