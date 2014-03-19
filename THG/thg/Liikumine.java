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
				System.out.println("VULKAANIJALAM [i] [k] SÜGAV ORG JÕEGA");
				System.out.println("  KÜLLUSESARV [j] [l] METS");
			}
			else if (v==-2){
				System.out.println("    METS [i] [k] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println(" ORUPÕHI [j] [l] METS");
			}
			else if (v==-1){
				System.out.println("   METS [i] [k] METS ");
				System.out.println(" ORUNÕLV[j] [l] METS");
			}
			else if (v==2){
				System.out.println(" EI SAA KÄIA, SIIN ON AREENI PIIR[i] [k] VULKAANIJALAM");
				System.out.println("                     VULKAANITIPP [j] [l] METS");
			}
			else{
				System.out.println(" VULKAANIJALAM[i] [k] METS");
				System.out.println(" VULKAANIJALAM[j] [l] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				System.out.println(" METS[i] [k] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println(" METS[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				System.out.println("           METS [i] [k] METS");
				System.out.println(" SÜGAV ORG JÕEGA[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				System.out.println("METS [i] [k] METS");
				System.out.println("METS [j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				System.out.println("         METS [i] [k] METS");
				System.out.println(" VULKAANIJALAM[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [i] [k] METS");
				System.out.println("                   VULKAANIJALAM [j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){
				System.out.println("ORUNÕLV [i] [k] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [j] [l] METS");
			}
			else if (v==-1){
				System.out.println(" KÜLLUSESARV [i] [k] SÜGAV ORG JÕEGA");
				System.out.println("      VEEKOGU[j] [l]SÜGAV ORG JÕEGA ");
			}
			else if (v==0){
				System.out.println("VULKAANIJALAM [i] [k] ORUNÕLV");
				System.out.println("      VEEKOGU [j] [l] METS");
			}
			else if (v==1){
				System.out.println(" VULKAANITIPP [i] [k] KÜLLUSESARV");
				System.out.println("VULKAANIJALAM [j] [l] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [i] [k] VULKAANIJALAM");
				System.out.println("                   VULKAANIJALAM [j] [l] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				System.out.println("VEEKOGU [i] [k] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [j] [l] SÜGAV ORG JÕEGA");
			}
			else if (v==-1){
				System.out.println(" VEEKOGU [i] [k] SÜGAV ORG JÕEGA");
				System.out.println("POOLSAAR [j] [l] ORUNÕLV");
			}
			else if (v==0){
				System.out.println("VULKAANINÕLV [i] [k] VEEKOGU");
				System.out.println("    POOLSAAR [j] [l] KÜLLUSESARV");
			}
			else if (v==1){
				System.out.println("             VULKAANINÕLV [i] [k] VEEKOGU");
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANINÕLV");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [i] [k] VULKAANINÕLV");
				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				System.out.println("                        POOLSAAR [i] [k] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] SÜGAV ORG JÕEGA");
			}
			else if (v == -1){
				System.out.println("                        POOLSAAR [i] [k] VEEKOGU");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
			}
			else if (v ==0){
				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [i] [k] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
			}
			else if (v ==1){
				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [i] [k] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VULKAANIJALAM");
			}
			else{
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [i] [k] TÜHERMAA/KIVISTUNUD LAAVA");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VULKAANINÕLV");
			}
		}
	}

}
