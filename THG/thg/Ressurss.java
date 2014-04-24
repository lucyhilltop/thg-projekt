package thg;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import application.Mang;


public class Ressurss{
	Text skoht = Mang.getSkoht();
	//Puudub veel see, et piirkondadest 9-12 mängijatel rohkem veaks, aga mul tuli see nüüd viimasel hetkel alles meelde
	public void metsamari(final Mangija a) throws InterruptedException {
		final double juh=Math.random()*10+1;
		skoht.setWrappingWidth(390);
		skoht.setText("Ühel põõsal kasvavad isuäratavad valged marjad. Sa pole selliseid varem näinud ja see ei tundu olevat nende loomulik kasvukoht.\n "
				+ "Proovid marju -vajuta [TÜHIK].\n Lähed edasi - vajuta [ENTER].\n ");
		EventHandler<KeyEvent> filter3 = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (event.getCode().equals(KeyCode.SPACE)){
					try{
						try{
							TimeUnit.MILLISECONDS.sleep(700);
						}
						catch (InterruptedException e){
							System.out.println("");;
						}
						if (juh<=5){

							skoht.setText("Enesetunne läheb kehvaks...\n\r"
									+ "Elusid on Sul nüüd: "+a.muudaElusid("-"));
						}
						else{ 
							skoht.setText("Täitsa maitsev mari ju..enesetunne läheb tükk maad paremaks\n\r"
									+ "Elusid on Sul nüüd: "+a.muudaElusid("+"));
						}
						event.consume();
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else if (event.getCode().equals(KeyCode.ENTER)) {
					try{
						skoht.setText("Liigud edasi");
						event.consume();
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			};
			TextField tekstivali = Mang.getTekstivali();
			tekstivali.addEventFilter(KeyEvent.KEY_PRESSED, filter3);
		}
			//Valele nupule vajutamise juhtum
			/*else{
			skoht.setText("Oioi, vajutasid midagi valesti, proovi uuesti");
			metsamari(a);
		}*/

		
		//Väiksed langevarjukesed, mida sponsorid enda lemmikutele saadavad, et neid mängudes aidata
		public void langevari(Mangija a) throws InterruptedException {
			Random randomno=new Random();
			skoht.setWrappingWidth(390);
			String [] valik = {"energiajook", "pakk tuletikke", "nuga"};

			String asi =valik[randomno.nextInt(valik.length)];
			skoht.setText("Märkad taevast langevat väikest langevarju, mis maandub sinust veidi eema. Korjad selle üles ja avad pakendi. Sees on: -" + asi + "\n\r"
					+ "Elusid on Sul nüüd: " + a.muudaElusid("+"));
		}
		//Huvitav meetod, kuna vulkaan on mängukirjelduses iseenesest olemas, peab olema ka võimalus selle purskamiseks 
		public void vulkaan(){
			skoht.setWrappingWidth(390);
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
