package thg;
import java.util.Random;
	public class Langevari {
		
		public static void langevari() {
			Random randomno=new Random();
			String [] valik = {"energiajook", "pakk tuletikke", "nuga"};
			
			String asi =valik[randomno.nextInt(valik.length)];
			System.out.println("Märkad taevast langevat väikest langevarju, mis maandub sinust veidi eema. Korjad selle üles ja avad pakendi. Sees on: -" + asi);
			 
		}
	}
