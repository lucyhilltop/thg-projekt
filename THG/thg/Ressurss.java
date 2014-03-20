package thg;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Ressurss{

	//Puudub veel see, et piirkondadest 9-12 mängijatel rohkem veaks, aga mul tuli see nüüd viimasel hetkel alles meelde
	public void metsamari(Mängija a) {
		double juh=Math.random()*10+1;
		System.out.printf("Ühel põõsal kasvavad isuäratavad valged marjad. Sa pole selliseid varem näinud ja see ei tundu olevat nende loomulik kasvukoht.\n "
				+ "Proovid marju -vajuta [S].\n Lähed edasi - vajuta [E].\n ");

		Scanner scan=new Scanner(System.in);
		String sisend=scan.nextLine();

		if (sisend.equals("s")){
			try{
				TimeUnit.MILLISECONDS.sleep(700);
			}
			catch (InterruptedException e){
				System.out.println("");;
			}
			if (juh<=5){

				System.out.println("Enesetunne läheb kehvaks...");
				a.muudaElusid("-");
			}
			else{ 
				System.out.printf("Täitsa maitsev mari ju..enesetunne läheb tükk maad paremaks\n");
				a.muudaElusid("+");
			}
		}

		else if (sisend.equals("e")) {
			System.out.println("Liigud edasi");
		}
		//Valele nupule vajutamise juhtum
		else{
			System.out.println("Oioi, vajutasid midagi valesti, proovi uuesti");
			metsamari(a);
		}

	}
//Väiksed langevarjukesed, mida sponsorid enda lemmikutele saadavad, et neid mängudes aidata
	public void langevari(Mängija a) {
		Random randomno=new Random();
		String [] valik = {"energiajook", "pakk tuletikke", "nuga"};

		String asi =valik[randomno.nextInt(valik.length)];
		System.out.println("Märkad taevast langevat väikest langevarju, mis maandub sinust veidi eema. Korjad selle üles ja avad pakendi. Sees on: -" + asi);
		a.muudaElusid("+");
	}
//Huvitav meetod, kuna vulkaan on mängukirjelduses iseenesest olemas, peab olema ka võimalus selle purskamiseks 
	public void vulkaan(){
		System.out.println("Sa kuuled selja tagant tohutult valju plahvatust.");
		try{
			TimeUnit.MILLISECONDS.sleep(1300);
		}
		catch (InterruptedException e){
			System.out.println("");;
		}
		System.out.println("ümber pöörates saad aru, et vulkaan on hakanud purskama.\n Viie sekundi jooksul kattud kuuma tuhaga.\n "
				+ "Mängumeistritel sai sust kõrini.\n Game Over.");
	}
}
