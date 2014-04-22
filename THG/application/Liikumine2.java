package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Liikumine2 extends Application {
	int v=0;
	int h=0;
	//layout
	BorderPane piir = new BorderPane();
	//gruppi pole vaja, borderpane läheb stseenile
	Group juur= new Group();

	boolean isgameover = false;
	//tekstiväli
    Text tkoht= new Text(" kirjeldus"
    		+ "tralalalaa"
    		+ "blballbaba \n"
    		+  " veeeel pikkkem");
    //ekraani laius ja kõrgus
    int width = 300;
    int height = 300;
    //Taustapildid
    Image veekogu = new Image("application/veekogu.jpg", width, height, false, false);
    Image cornucopia = new Image("application/küllusesarv.png", width, height, false, false);
    Image jalam = new Image("application/mäejalam.jpg", width, height, false, false);
    Image mets = new Image("application/mets.jpg", width, height, false, false);
    Image org_p = new Image("application/org jõega.jpg", width, height, false, false);
    Image org_n = new Image("application/orunõlv.jpg", width, height, false, false);
    Image poolsaar = new Image("application/poolsaar.jpg", width, height, false, false);
    Image wasteland = new Image("application/tühermaa.jpg", width, height, false, false);
    Image tipp = new Image("application/vulkaanitipp.jpg", width, height, false, false);
    
  //Kirjeldab iga sammu kohal, kuhu sa edasi minna saad
    ImageView kohapilt = new ImageView();
  	public void sammude_kirjeldus(){
  		System.out.println("LIIGU EDASI");
  		if (h==1){
  			if (v==0){
  				kohapilt = new ImageView(mets);
  				System.out.println("VULKAANIJALAM [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
  				System.out.println("  KÜLLUSESARV [j] [l] METS");
  			}
  			else if (v==-2){
  				kohapilt = new ImageView(mets);
  				System.out.println("           METS [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
  				System.out.println("SÜGAV ORG JÕEGA [j] [l] METS");
  			}
  			else if (v==-1){
  				kohapilt = new ImageView(org_p);
  				System.out.println("   METS [ÜLES] [ALLA] METS ");
  				System.out.println(" ORUNÕLV[j] [l] METS");
  			}
  			else if (v==2){
  				kohapilt = new ImageView(jalam);
  				System.out.println(" EI SAA KÄIA, SIIN ON AREENI PIIR[ÜLES] [ALLA] VULKAANIJALAM");
  				System.out.println("                     VULKAANITIPP [j] [l] METS");
  			}
  			else{
  				kohapilt = new ImageView(jalam);
  				System.out.println(" VULKAANIJALAM[ÜLES] [ALLA] METS");
  				System.out.println(" VULKAANIJALAM[j] [l] METS");
  			}
  		}
  		else if (h==2){
  			if (v==-2){
  				kohapilt = new ImageView(mets);
  				System.out.println(" METS[ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
  				System.out.println(" METS[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
  			}
  			else if (v==-1){
  				kohapilt = new ImageView(mets);
  				System.out.println("           METS [ÜLES] [ALLA] METS");
  				System.out.println(" SÜGAV ORG JÕEGA[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
  			}
  			else if(v==0){
  				kohapilt = new ImageView(mets);
  				System.out.println("METS [ÜLES] [ALLA] METS");
  				System.out.println("METS [j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
  			}
  			else if (v==1){
  				kohapilt = new ImageView(mets);
  				System.out.println("         METS [ÜLES] [ALLA] METS");
  				System.out.println(" VULKAANIJALAM[j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
  			}
  			else{
  				kohapilt = new ImageView(mets);
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] METS");
  				System.out.println("                   VULKAANIJALAM [j] [l] EI SAA KÄIA, SIIN ON AREENI PIIR");
  			}
  		}
  		else if (h==0){
  			if(v==-2){
  				kohapilt = new ImageView(org_p);
  				System.out.println("ORUNÕLV [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
  				System.out.println("VEEKOGU [j] [l] METS");
  			}
  			else if (v==-1){
  				kohapilt = new ImageView(org_n);
  				System.out.println(" KÜLLUSESARV [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
  				System.out.println("      VEEKOGU[j] [l]SÜGAV ORG JÕEGA ");
  			}
  			else if (v==0){
  				kohapilt = new ImageView(cornucopia);
  				System.out.println("VULKAANIJALAM [ÜLES] [ALLA] ORUNÕLV");
  				System.out.println("      VEEKOGU [j] [l] METS");
  			}
  			else if (v==1){
  				kohapilt = new ImageView(jalam);
  				System.out.println(" VULKAANITIPP [ÜLES] [ALLA] KÜLLUSESARV");
  				System.out.println("VULKAANIJALAM [j] [l] VULKAANIJALAM");
  			}
  			else{
  				kohapilt = new ImageView(tipp);
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] VULKAANIJALAM");
  				System.out.println("                   VULKAANIJALAM [j] [l] VULKAANIJALAM");
  			}
  		}
  		else if (h==-1){
  			if (v==-2){
  				kohapilt = new ImageView(org_p);
  				System.out.println("VEEKOGU [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
  				System.out.println("VEEKOGU [j] [l] SÜGAV ORG JÕEGA");
  			}
  			else if (v==-1){
  				kohapilt = new ImageView(veekogu);
  				System.out.println(" VEEKOGU [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
  				System.out.println("POOLSAAR [j] [l] ORUNÕLV");
  			}
  			else if (v==0){
  				kohapilt = new ImageView(veekogu);
  				System.out.println("VULKAANINÕLV [ÜLES] [ALLA] VEEKOGU");
  				System.out.println("    POOLSAAR [j] [l] KÜLLUSESARV");
  			}
  			else if (v==1){
  				kohapilt = new ImageView(jalam);
  				System.out.println("             VULKAANINÕLV [ÜLES] [ALLA] VEEKOGU");
  				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANINÕLV");
  			}
  			else{
  				kohapilt = new ImageView(jalam);
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] VULKAANINÕLV");
  				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [j] [l] VULKAANITIPP");
  			}
  		}
  		else if(h==-2){
  			if (v ==-2){
  				kohapilt = new ImageView(veekogu);
  				System.out.println("                        POOLSAAR [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] SÜGAV ORG JÕEGA");
  			}
  			else if (v == -1){
  				kohapilt = new ImageView(poolsaar);
  				System.out.println("                        POOLSAAR [ÜLES] [ALLA] VEEKOGU");
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
  			}
  			else if (v ==0){
  				kohapilt = new ImageView(poolsaar);
  				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [ÜLES] [ALLA] POOLSAAR");
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VEEKOGU");
  			}
  			else if (v ==1){
  				kohapilt = new ImageView(wasteland);
  				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [ÜLES] [ALLA] POOLSAAR");
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VULKAANIJALAM");
  			}
  			else{
  				kohapilt = new ImageView(wasteland);
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] TÜHERMAA/KIVISTUNUD LAAVA");
  				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [j] [l] VULKAANINÕLV");
  			}
  			
  		}
  	}
   
	public void start(Stage primaryStage) {
	
		//Nupuvajutamise kuular
		 EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
		    public void handle(KeyEvent event) {

		        if(event.getCode() == KeyCode.UP) {
		            try {
		            	if (v<2){
		                v++;
		            	}
		                System.out.println(v);
		            } catch (Exception e) {
		                 e.printStackTrace();
		            }
		            //event.consume();
		        } 
		        else if(event.getCode() == KeyCode.DOWN) {
		            try {
		            	if (v > -2){
		            	v--;
		            	}
		                System.out.println("alla");
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		            //pole vaja vist
		            //event.consume();
		        } 
		        
		        else if (event.getCode() == KeyCode.LEFT) {
		        	try {
		        		if (h> -2){
		        			h--;
		        		}
		        		//kontroll
		        		System.out.println("vasakule");
		        	}
		        	catch (Exception e) {
		        		e.printStackTrace();
		        		
		        	}
		        }
		        
		        else if (event.getCode()==KeyCode.RIGHT) {
		        	try {
		        		if (h < 2){
		        		h++;
		        		}
		        	}   
		        	catch (Exception e) {
		        		e.printStackTrace();
		        	}
		        	
		        }
		    }
		}; //kuulari lõpp
		
		
		//stseen, mille küljes kõik muu
		
		sammude_kirjeldus();
		juur.getChildren().addAll(kohapilt, piir);
	    Scene stseen1 = new Scene(juur, 300, 300, Color.WHITE);
	    stseen1.setOnKeyPressed(keyListener);
	    primaryStage.setTitle("Sündmused");
	   
	    
	   
	  
	    piir.setBottom(tkoht); 
	    //tkoht.setHeight(100.
	    
	    primaryStage.setScene(stseen1);
	    primaryStage.show();
	    
	    
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
