package thg;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javafx.scene.text.Text;
import application.Mang;


public class Ressurss{
	Text tkoht = Mang.getTkoht();
	//Puudub veel see, et piirkondadest 9-12 m�ngijatel rohkem veaks, aga mul tuli see n��d viimasel hetkel alles meelde
	public void metsamari(Mangija a) throws InterruptedException {
		double juh=Math.random()*10+1;
		tkoht.setText("�hel p��sal kasvavad isu�ratavad valged marjad. Sa pole selliseid varem n�inud ja see ei tundu olevat nende loomulik kasvukoht.\n "
				+ "Proovid marju -vajuta [S].\n L�hed edasi - vajuta [E].\n ");

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

				tkoht.setText("Enesetunne l�heb kehvaks...");
				TimeUnit.MILLISECONDS.sleep(700);
				a.muudaElusid("-");
			}
			else{ 
				tkoht.setText("T�itsa maitsev mari ju..enesetunne l�heb t�kk maad paremaks\n");
				TimeUnit.MILLISECONDS.sleep(700);
				a.muudaElusid("+");
			}
		}

		else if (sisend.equals("e")) {
			tkoht.setText("Liigud edasi");
		}
		//Valele nupule vajutamise juhtum
		else{
			tkoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
			metsamari(a);
		}*/

	}
	//V�iksed langevarjukesed, mida sponsorid enda lemmikutele saadavad, et neid m�ngudes aidata
	public void langevari(Mangija a) throws InterruptedException {
		Random randomno=new Random();
		String [] valik = {"energiajook", "pakk tuletikke", "nuga"};

		String asi =valik[randomno.nextInt(valik.length)];
		tkoht.setText("M�rkad taevast langevat v�ikest langevarju, mis maandub sinust veidi eema. Korjad selle �les ja avad pakendi. Sees on: -" + asi);
		TimeUnit.MILLISECONDS.sleep(700);
		a.muudaElusid("+");
	}
	//Huvitav meetod, kuna vulkaan on m�ngukirjelduses iseenesest olemas, peab olema ka v�imalus selle purskamiseks 
	public void vulkaan(){
		tkoht.setText("Sa kuuled selja tagant tohutult valju plahvatust.");
		try{
			TimeUnit.MILLISECONDS.sleep(1300);
		}
		catch (InterruptedException e){
			System.out.println("");;
		}
		tkoht.setText("�mber p��rates saad aru, et vulkaan on hakanud purskama.\n Viie sekundi jooksul kattud kuuma tuhaga.\n "
				+ "M�ngumeistritel sai sust k�rini.\n Game Over.");
	}
}
