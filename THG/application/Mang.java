package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Mang extends Application {
	int v=0;
	int h=0;

	private final Canvas canvas = new Canvas(400,400);
	private Canvas nood = new Canvas(400,325);

	//Et mängu alguses oleks õige taust taga
	public Mang(){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(cornucopia, 0.0, 0.0, canvas.getHeight(),
				canvas.getWidth());
	}
	
	//seda kasutan hiljem erinevates kohtades taustade muutmiseks. Ala et metsas metsa taust oleks jne.
	private void taustauuendus(Image img){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(img, 0.0, 0.0, canvas.getHeight(),
				canvas.getWidth());
	}

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
	double width = canvas.getWidth();
	double height = canvas.getHeight();
	
	
	//Taustapildid
	Image veekogu = new Image("application/veekogu.jpg", width, height, false, true);
	Image cornucopia = new Image("application/küllusesarv.png", width, height, false, false);
	Image jalam = new Image("application/mäejalam.jpg", width, height, false, false);
	Image mets = new Image("application/mets.jpg", width, height, false, false);
	Image org_p = new Image("application/org jõega.jpg", width, height, false, false);
	Image org_n = new Image("application/orunõlv.jpg", width, height, false, false);
	Image poolsaar = new Image("application/poolsaar.jpg", width, height, false, false);
	Image wasteland = new Image("application/tühermaa.jpg", width, height, false, false);
	Image tipp = new Image("application/vulkaanitipp.jpg", width, height, false, false);

	//Kirjeldab iga sammu kohal, kuhu sa edasi minna saad ja tekitab tausta
	ImageView kohapilt = new ImageView();
	public void sammude_kirjeldus(){
		System.out.println("LIIGU EDASI");
		if (h==1){
			if (v==0){
				taustauuendus(mets);
				System.out.println("VULKAANIJALAM [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
				System.out.println("  KÜLLUSESARV [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-2){
				taustauuendus(mets);
				System.out.println("           METS [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("SÜGAV ORG JÕEGA [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-1){
				taustauuendus(org_p);
				System.out.println("   METS [ÜLES] [ALLA] METS ");
				System.out.println(" ORUNÕLV[VASAKULE] [PAREMALE] METS");
			}
			else if (v==2){
				taustauuendus(jalam);
				System.out.println(" EI SAA KÄIA, SIIN ON AREENI PIIR[ÜLES] [ALLA] VULKAANIJALAM");
				System.out.println("                     VULKAANITIPP [VASAKULE] [PAREMALE] METS");
			}
			else{
				taustauuendus(jalam);
				System.out.println(" VULKAANIJALAM[ÜLES] [ALLA] METS");
				System.out.println(" VULKAANIJALAM[VASAKULE] [PAREMALE] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				taustauuendus(mets);
				System.out.println(" METS[ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println(" METS[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				taustauuendus(mets);
				System.out.println("           METS [ÜLES] [ALLA] METS");
				System.out.println(" SÜGAV ORG JÕEGA[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				taustauuendus(mets);
				System.out.println("METS [ÜLES] [ALLA] METS");
				System.out.println("METS [VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				taustauuendus(mets);
				System.out.println("         METS [ÜLES] [ALLA] METS");
				System.out.println(" VULKAANIJALAM[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else{
				taustauuendus(mets);
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] METS");
				System.out.println("                   VULKAANIJALAM [VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){taustauuendus(org_p);
				
				System.out.println("ORUNÕLV [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-1){
				taustauuendus(org_n);

				System.out.println(" KÜLLUSESARV [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
				System.out.println("      VEEKOGU[VASAKULE] [PAREMALE]SÜGAV ORG JÕEGA ");
			}
			else if (v==0){
				taustauuendus(cornucopia);
		
				System.out.println("VULKAANIJALAM [ÜLES] [ALLA] ORUNÕLV");
				System.out.println("      VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==1){
				taustauuendus(jalam);
			
				System.out.println(" VULKAANITIPP [ÜLES] [ALLA] KÜLLUSESARV");
				System.out.println("VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{taustauuendus(tipp);
		
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] VULKAANIJALAM");
				System.out.println("                   VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				taustauuendus(org_p);
		
				System.out.println("VEEKOGU [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [VASAKULE] [PAREMALE] SÜGAV ORG JÕEGA");
			}
			else if (v==-1){
				taustauuendus(veekogu);

				System.out.println(" VEEKOGU [ÜLES] [ALLA] SÜGAV ORG JÕEGA");
				System.out.println("POOLSAAR [VASAKULE] [PAREMALE] ORUNÕLV");
			}
			else if (v==0){
				taustauuendus(veekogu);

				System.out.println("VULKAANINÕLV [ÜLES] [ALLA] VEEKOGU");
				System.out.println("    POOLSAAR [VASAKULE] [PAREMALE] KÜLLUSESARV");
			}
			else if (v==1){
				taustauuendus(jalam);
	
				System.out.println("             VULKAANINÕLV [ÜLES] [ALLA] VEEKOGU");
				System.out.println("TÜHERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANINÕLV");
			}
			else{taustauuendus(jalam);
	
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] VULKAANINÕLV");
				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				taustauuendus(veekogu);
		
				System.out.println("                        POOLSAAR [ÜLES] [ALLA] EI SAA KÄIA, SIIN ON AREENI PIIR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] SÜGAV ORG JÕEGA");
			}
			else if (v == -1){
				taustauuendus(poolsaar);
	
				System.out.println("                        POOLSAAR [ÜLES] [ALLA] VEEKOGU");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 0){
				taustauuendus(poolsaar);
	
				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [ÜLES] [ALLA] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 1){
				taustauuendus(wasteland);

				System.out.println("       TÜHERMAA/KIVISTUNUD LAAVA [ÜLES] [ALLA] POOLSAAR");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{
				taustauuendus(wasteland);
				
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [ÜLES] [ALLA] TÜHERMAA/KIVISTUNUD LAAVA");
				System.out.println("EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANINÕLV");
			}

		}
		
	}

	public void start(Stage primaryStage) {
		width = primaryStage.getWidth();
		height = primaryStage.getHeight();
		piir.setTop(nood);
		BorderPane piir2 = new BorderPane();
		TextArea kirjeldusekast = new TextArea();
		kirjeldusekast.setText(" Kalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \n"
				+ "böö\n"
				+ "lol\n"
				+ "alkjg\n"
				+ "dlkjhj\n");
		kirjeldusekast.setPrefRowCount(4);
		kirjeldusekast.setPrefColumnCount(30);
		kirjeldusekast.setWrapText(true);
		piir2.setCenter(kirjeldusekast);
		piir2.setBottom(nood);
		piir.setBottom(piir2);
		//Nupuvajutamise kuular
		EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {

				if(event.getCode() == KeyCode.UP) {
					try {
						if (v<2){
							v++;
						}
						sammude_kirjeldus();
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
						sammude_kirjeldus();
				
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
						sammude_kirjeldus();
	
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
						sammude_kirjeldus();
					}   
					catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}; //kuulari lõpp


		//stseen, mille küljes kõik muu

		sammude_kirjeldus();
		juur.getChildren().addAll(canvas, piir);
		Scene stseen1 = new Scene(juur, 400, 400, Color.WHITE);
		stseen1.setOnKeyPressed(keyListener);
		primaryStage.setTitle("Your hunger games");

		//piir.setBottom(tkoht); 
		//tkoht.prefHeight(100);

		primaryStage.setScene(stseen1);
		primaryStage.show();



	}

	public static void main(String[] args) {
		launch(args);
	}
}
