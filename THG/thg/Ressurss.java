package thg;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javafx.scene.text.Text;
import application.Mang;


public class Ressurss{
	Text skoht = Mang.getSkoht();
	//Puudub veel see, et piirkondadest 9-12 mängijatel rohkem veaks, aga mul tuli see nüüd viimasel hetkel alles meelde
	public void metsamari(Mangija a) throws InterruptedException {
		double juh=Math.random()*10+1;
		skoht.setText("Ühel põõsal kasvavad isuäratavad valged marjad. Sa pole selliseid varem näinud ja see ei tundu olevat nende loomulik kasvukoht.\n "
				+ "Proovid marju -vajuta [TÜHIK].\n Lähed edasi - vajuta [ENTER].\n ");

		/*		Scanner scan=new Scanner(System.in);
		String sisend=scan.nextLine();

		if (sisend.equals("s")){
			try{
				TimeUnit.MILLISECONDS.sleep(700);
			}
			catch (InterruptedException e){
				System.out.println("");;
			}
			if (juh<=5){

				skoht.setText("Enesetunne läheb kehvaks...");
				TimeUnit.MILLISECONDS.sleep(700);
				a.muudaElusid("-");
			}
			else{ 
				skoht.setText("Täitsa maitsev mari ju..enesetunne läheb tükk maad paremaks\n");
				TimeUnit.MILLISECONDS.sleep(700);
				a.muudaElusid("+");
			}
		}

		else if (sisend.equals("e")) {
			skoht.setText("Liigud edasi");
		}
		//Valele nupule vajutamise juhtum
		else{
			skoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
			metsamari(a);
		}*/

	}
	//Väiksed langevarjukesed, mida sponsorid enda lemmikutele saadavad, et neid mängudes aidata
	public void langevari(Mangija a) throws InterruptedException {
		Random randomno=new Random();
		String [] valik = {"energiajook", "pakk tuletikke", "nuga"};

		String asi =valik[randomno.nextInt(valik.length)];
		skoht.setText("Märkad taevast langevat väikest langevarju, mis maandub sinust veidi eema. Korjad selle üles ja avad pakendi. Sees on: -" + asi);
		TimeUnit.MILLISECONDS.sleep(700);
		a.muudaElusid("+");
	}
	//Huvitav meetod, kuna vulkaan on mängukirjelduses iseenesest olemas, peab olema ka võimalus selle purskamiseks 
	public void vulkaan(){
		skoht.setText("Sa kuuled selja tagant tohutult valju plahvatust.");
		try{
			TimeUnit.MILLISECONDS.sleep(1300);
		}
		catch (InterruptedException e){
			System.out.println("");;
		}
		skoht.setText("ümber pöörates saad aru, et vulkaan on hakanud purskama.\n Viie sekundi jooksul kattud kuuma tuhaga.\n "
				+ "Mängumeistritel sai sust kõrini.\n Game Over.");
	}
}
