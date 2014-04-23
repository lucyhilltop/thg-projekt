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

	//Et m�ngu alguses oleks �ige taust taga
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
	//gruppi pole vaja, borderpane l�heb stseenile
	Group juur= new Group();

	boolean isgameover = false;
	//tekstiv�li
	
	Text tkoht= new Text(" kirjeldus"
			+ "tralalalaa"
			+ "blballbaba \n"
			+  " veeeel pikkkem");
	//ekraani laius ja k�rgus
	double width = canvas.getWidth();
	double height = canvas.getHeight();
	
	
	//Taustapildid
	Image veekogu = new Image("application/veekogu.jpg", width, height, false, true);
	Image cornucopia = new Image("application/k�llusesarv.png", width, height, false, false);
	Image jalam = new Image("application/m�ejalam.jpg", width, height, false, false);
	Image mets = new Image("application/mets.jpg", width, height, false, false);
	Image org_p = new Image("application/org j�ega.jpg", width, height, false, false);
	Image org_n = new Image("application/orun�lv.jpg", width, height, false, false);
	Image poolsaar = new Image("application/poolsaar.jpg", width, height, false, false);
	Image wasteland = new Image("application/t�hermaa.jpg", width, height, false, false);
	Image tipp = new Image("application/vulkaanitipp.jpg", width, height, false, false);

	//Kirjeldab iga sammu kohal, kuhu sa edasi minna saad ja tekitab tausta
	ImageView kohapilt = new ImageView();
	public void sammude_kirjeldus(){
		System.out.println("LIIGU EDASI");
		if (h==1){
			if (v==0){
				taustauuendus(mets);
				System.out.println("VULKAANIJALAM [�LES] [ALLA] S�GAV ORG J�EGA");
				System.out.println("  K�LLUSESARV [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-2){
				taustauuendus(mets);
				System.out.println("           METS [�LES] [ALLA] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("S�GAV ORG J�EGA [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-1){
				taustauuendus(org_p);
				System.out.println("   METS [�LES] [ALLA] METS ");
				System.out.println(" ORUN�LV[VASAKULE] [PAREMALE] METS");
			}
			else if (v==2){
				taustauuendus(jalam);
				System.out.println(" EI SAA K�IA, SIIN ON AREENI PIIR[�LES] [ALLA] VULKAANIJALAM");
				System.out.println("                     VULKAANITIPP [VASAKULE] [PAREMALE] METS");
			}
			else{
				taustauuendus(jalam);
				System.out.println(" VULKAANIJALAM[�LES] [ALLA] METS");
				System.out.println(" VULKAANIJALAM[VASAKULE] [PAREMALE] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				taustauuendus(mets);
				System.out.println(" METS[�LES] [ALLA] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println(" METS[VASAKULE] [PAREMALE] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				taustauuendus(mets);
				System.out.println("           METS [�LES] [ALLA] METS");
				System.out.println(" S�GAV ORG J�EGA[VASAKULE] [PAREMALE] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				taustauuendus(mets);
				System.out.println("METS [�LES] [ALLA] METS");
				System.out.println("METS [VASAKULE] [PAREMALE] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				taustauuendus(mets);
				System.out.println("         METS [�LES] [ALLA] METS");
				System.out.println(" VULKAANIJALAM[VASAKULE] [PAREMALE] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
			else{
				taustauuendus(mets);
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [�LES] [ALLA] METS");
				System.out.println("                   VULKAANIJALAM [VASAKULE] [PAREMALE] EI SAA K�IA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){taustauuendus(org_p);
				
				System.out.println("ORUN�LV [�LES] [ALLA] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-1){
				taustauuendus(org_n);

				System.out.println(" K�LLUSESARV [�LES] [ALLA] S�GAV ORG J�EGA");
				System.out.println("      VEEKOGU[VASAKULE] [PAREMALE]S�GAV ORG J�EGA ");
			}
			else if (v==0){
				taustauuendus(cornucopia);
		
				System.out.println("VULKAANIJALAM [�LES] [ALLA] ORUN�LV");
				System.out.println("      VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==1){
				taustauuendus(jalam);
			
				System.out.println(" VULKAANITIPP [�LES] [ALLA] K�LLUSESARV");
				System.out.println("VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{taustauuendus(tipp);
		
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [�LES] [ALLA] VULKAANIJALAM");
				System.out.println("                   VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				taustauuendus(org_p);
		
				System.out.println("VEEKOGU [�LES] [ALLA] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("VEEKOGU [VASAKULE] [PAREMALE] S�GAV ORG J�EGA");
			}
			else if (v==-1){
				taustauuendus(veekogu);

				System.out.println(" VEEKOGU [�LES] [ALLA] S�GAV ORG J�EGA");
				System.out.println("POOLSAAR [VASAKULE] [PAREMALE] ORUN�LV");
			}
			else if (v==0){
				taustauuendus(veekogu);

				System.out.println("VULKAANIN�LV [�LES] [ALLA] VEEKOGU");
				System.out.println("    POOLSAAR [VASAKULE] [PAREMALE] K�LLUSESARV");
			}
			else if (v==1){
				taustauuendus(jalam);
	
				System.out.println("             VULKAANIN�LV [�LES] [ALLA] VEEKOGU");
				System.out.println("T�HERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANIN�LV");
			}
			else{taustauuendus(jalam);
	
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [�LES] [ALLA] VULKAANIN�LV");
				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				taustauuendus(veekogu);
		
				System.out.println("                        POOLSAAR [�LES] [ALLA] EI SAA K�IA, SIIN ON AREENI PIIR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] S�GAV ORG J�EGA");
			}
			else if (v == -1){
				taustauuendus(poolsaar);
	
				System.out.println("                        POOLSAAR [�LES] [ALLA] VEEKOGU");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 0){
				taustauuendus(poolsaar);
	
				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [�LES] [ALLA] POOLSAAR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 1){
				taustauuendus(wasteland);

				System.out.println("       T�HERMAA/KIVISTUNUD LAAVA [�LES] [ALLA] POOLSAAR");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{
				taustauuendus(wasteland);
				
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [�LES] [ALLA] T�HERMAA/KIVISTUNUD LAAVA");
				System.out.println("EI SAA K�IA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANIN�LV");
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
				+ "b��\n"
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
		}; //kuulari l�pp


		//stseen, mille k�ljes k�ik muu

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
