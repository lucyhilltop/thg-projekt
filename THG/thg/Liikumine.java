package thg;
import java.util.Scanner;

public class Liikumine {
	int v;
	int h;


	public Liikumine(int h, int v) {
		this.v = v;
		this.h = h;
	}
	public Liikumine (){

	}

	public void liikumine (){
		sammude_kirjeldus();

		Scanner sisend = new  Scanner(System.in);
		String myline=sisend.nextLine();

		if (myline.equals("i")) {
			v++;
		}

		else if (myline.equals("k")){	
			v--;

		}

		else if (myline.equals("j")){	
			h--;
		}

		else if (myline.equals("l")) {
			h = h+1;	
		}
	}

	public void sammude_kirjeldus(){
		System.out.println("LIIGU EDASI");
		if (h==1){
			if (v==0){
				System.out.println("VULKAANIJALAM [i] [k] S�GAV ORG J�EGA");
				System.out.println("  K�LLUSESARV [j] [l] METS");
			}
			else if (v==-2){
				System.out.println("    METS [i] [k] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println(" ORUP�HI [j] [l] METS");
			}
			else if (v==-1){
				System.out.println("   METS [i] [k] METS ");
				System.out.println(" ORUN�LV[j] [l] METS");
			}
			else if (v==2){
				System.out.println(" EI SAA K�IA, SIIN ON AREENI PIIR[i] [k] VULKAANIJALAM");
				System.out.println("                     VULKAANITIPP [j] [l] METS");
			}
			else{
				System.out.println(" VULKAANIJALAM[i] [k] METS");
				System.out.println(" VULKAANIJALAM[j] [l] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				System.out.println(" METS[i] [k] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println(" METS[j] [l] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				System.out.println("           METS [i] [k] METS");
				System.out.println(" S�GAV ORG J�EGA[j] [l] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				System.out.println("METS [i] [k] METS");
				System.out.println("METS [j] [l] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				System.out.println("         METS [i] [k] METS");
				System.out.println(" VULKAANIJALAM[j] [l] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else{
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [i] [k] METS");
				System.out.println("                   VULKAANIJALAM [j] [l] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){
				System.out.println("ORUN�LV [i] [k] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [j] [l] METS");
			}
			else if (v==-1){
				System.out.println(" K�LLUSESARV [i] [k] S�GAV ORG J�EGA");
				System.out.println("      VEEKOGU[j] [l]S�GAV ORG J�EGA ");
			}
			else if (v==0){
				System.out.println("VULKAANIJALAM [i] [k] ORUN�LV");
				System.out.println("      VEEKOGU [j] [l] METS");
			}
			else if (v==1){
				System.out.println(" VULKAANITIPP [i] [k] K�LLUSESARV");
				System.out.println("VULKAANIJALAM [j] [l] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [i] [k] VULKAANIJALAM");
				System.out.println("                   VULKAANIJALAM [j] [l] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				System.out.println("VEEKOGU [i] [k] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [j] [l] S�GAV ORG J�EGA");
			}
			else if (v==-1){
				System.out.println(" VEEKOGU [i] [k] S�GAV ORG J�EGA");
				System.out.println("POOLSAAR [j] [l] ORUN�LV");
			}
			else if (v==0){
				System.out.println("VULKAANIN�LV [i] [k] VEEKOGU");
				System.out.println("    POOLSAAR [j] [l] K�LLUSESARV");
			}
			else if (v==1){
				System.out.println("             VULKAANIN�LV [i] [k] VEEKOGU");
				System.out.println("T�HERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANIN�LV");
			}
			else{
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [i] [k] VULKAANIN�LV");
				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				System.out.println("                        POOLSAAR [i] [k] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [j] [l] S�GAV ORG J�EGA");
			}
			else if (v == -1){
				System.out.println("                        POOLSAAR [i] [k] VEEKOGU");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
			}
			else if (v ==0){
				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [i] [k] POOLSAAR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
			}
			else if (v ==1){
				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [i] [k] POOLSAAR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [j] [l] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [i] [k] T�HERMAA/KIVISTUNUD LAAVA");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [j] [l] VULKAANIN�LV");
			}
		}
	}

}
