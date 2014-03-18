package thg;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Ressurss{

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
			Mängija.lives1("-",a.getLives());
			 }
			else{ 
				System.out.printf("Täitsa maitsev mari ju..enesetunne läheb tükk maad paremaks\n");
				Mängija.lives1("+", a.getLives());
			}
			}

		if (sisend.equals("e")) 
		{System.out.println("Liigud edasi");
		}
		
		}

		
	public void langevari(Mängija a) {
		Random randomno=new Random();
		String [] valik = {"energiajook", "pakk tuletikke", "nuga"};
		
		String asi =valik[randomno.nextInt(valik.length)];
		System.out.println("Märkad taevast langevat väikest langevarju, mis maandub sinust veidi eema. Korjad selle üles ja avad pakendi. Sees on: -" + asi);
		Mängija.lives1("+", a.getLives());
	}
}
