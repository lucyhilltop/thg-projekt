package application;

import thg.Mangija;
import thg.Mutant;
import thg.Sissejuhatus;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Mang extends Application {
	int v=0;
	int h=0;

	private final Canvas canvas = new Canvas(400,400);
	BorderPane piir = new BorderPane();

	Group juur= new Group();

	//Et mängu alguses oleks �ige taust taga
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

	Mangija mangija = new Mangija("Katniss", 12);
	//static boolean kas_elus = true;
	//tekstiv�li
	static TextField tekstivali=new TextField("   ");
	//kohe tkoht muutuja alla tegin skoht - syndmuskoht, kus peaksid syndmused jooksma
	static Text tkoht= new Text(10.0, 400.0, "kirjeldus");
	static Text skoht=new Text(10.0, 400.0, "mis siin sünnib?");
	
	//ekraani laius ja k�rgus
	double width = 400;
	double height = 400;



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
		tkoht.setText("LIIGU EDASI");
		tkoht.setWrappingWidth(390);
		if (h==1){
			if (v==0){
				taustauuendus(mets);
				tkoht.setText("VULKAANIJALAM [EDASI] [TAGASI] SÜGAV ORG JÕEGA \n"
						+ "KÜLLUSESARV [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-2){
				taustauuendus(mets);
				tkoht.setText("METS [EDASI] [tagasi] EI SAA KÄIA, SIIN ON AREENI PIIR \n"
						+ "SÜGAV ORG JÕEGA [VASAKULE] [PAREMALE] METS ");
			}
			else if (v==-1){
				taustauuendus(org_p);
				tkoht.setText("METS [EDASI] [TAGASI] METS \n"
						+"ORUNÕLV[VASAKULE] [PAREMALE] METS");
			}
			else if (v==2){
				taustauuendus(jalam);
				tkoht.setText("EI SAA KÄIA, SIIN ON AREENI PIIR[EDASI] [TAGASI] VULKAANIJALAM \n \r"
						+ "VULKAANITIPP [VASAKULE] [PAREMALE] METS");
			}
			else{
				taustauuendus(jalam);
				tkoht.setText(" VULKAANIJALAM[EDASI] [TAGASI] METS \n \r" 
						+	" VULKAANIJALAM[VASAKULE] [PAREMALE] METS");
			}
		}
		else if (h==2){
			if (v==-2){
				taustauuendus(mets);
				tkoht.setText(" METS[EDASI] [TAGASI] EI SAA KÄIA, SIIN ON AREENI PIIR \n \r"
						+" METS[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==-1){
				taustauuendus(mets);
				tkoht.setText(" METS [EDASI] [TAGASI] METS \n"
						+" SÜGAV ORG JÕEGA[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if(v==0){
				taustauuendus(mets);
				tkoht.setText(" METS [ÜLES] [ALLA] METS \n"
						+" METS [VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else if (v==1){
				taustauuendus(mets);
				tkoht.setText(" METS [EDASI] [ALLA] METS \n"
						+" VULKAANIJALAM[VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
			else{
				taustauuendus(mets);
				tkoht.setText(" EI SAA KÄIA, SIIN ON AREENI PIIR [EDASI] [TAGASI] METS \n \r"
						+ " VULKAANIJALAM [VASAKULE] [PAREMALE] EI SAA KÄIA, SIIN ON AREENI PIIR");
			}
		}
		else if (h==0){
			if(v==-2){taustauuendus(org_p);

			tkoht.setText("ORUNÕLV [EDASI] [TAGASI] EI SAA K�IA, SIIN ON AREENI PIIR \n \r"
					+"VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==-1){
				taustauuendus(org_n);

				tkoht.setText(" KÜLLUSESARV [EDASI] [TAGASI] SÜGAV ORG JÕEGA \n"
						+     " VEEKOGU[VASAKULE] [PAREMALE]SÜGAV ORG JÕEGA ");
			}
			else if (v==0){
				taustauuendus(cornucopia);

				tkoht.setText(" VULKAANIJALAM [EDASI] [TAGASI] ORUN�LV \n"
						+     " VEEKOGU [VASAKULE] [PAREMALE] METS");
			}
			else if (v==1){
				taustauuendus(jalam);

				tkoht.setText(" VULKAANITIPP [EDASI] [TAGASI] K�LLUSESARV \n"
						+" VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{taustauuendus(tipp);

			tkoht.setText(" EI SAA K�IA, SIIN ON AREENI PIIR [EDASI] [TAGASI] VULKAANIJALAM \n"
					+" VULKAANIJALAM [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
		}
		else if (h==-1){
			if (v==-2){
				taustauuendus(org_p);

				tkoht.setText(" VEEKOGU [EDASI] [TAGASI] EI SAA KÄIA, SIIN ON AREENI PIIR \n"
						+"VEEKOGU [VASAKULE] [PAREMALE] S�GAV ORG JÕEGA");
			}
			else if (v==-1){
				taustauuendus(veekogu);

				tkoht.setText(" VEEKOGU [EDASI] [TAGASI] S�GAV ORG JÕEGA\n"
						+" POOLSAAR [VASAKULE] [PAREMALE] ORUN�LV");
			}
			else if (v==0){
				taustauuendus(veekogu);

				tkoht.setText(" VULKAANINÕLV [EDASI] [TAGASI] VEEKOGU\n"
						+   " POOLSAAR [VASAKULE] [PAREMALE] KÜLLUSESARV");
			}
			else if (v==1){
				taustauuendus(jalam);

				tkoht.setText(" VULKAANINÕLV [EDASI] [TAGASI] VEEKOGU\n"
						+" TÜHERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANINÕLV");
			}
			else{taustauuendus(jalam);

			tkoht.setText(" EI SAA KÄIA, SIIN ON AREENI PIIR [EDASI] [TAGASI] VULKAANINÕLV\n"
					+"TÜHERMAA/KIVISTUNUD LAAVA [VASAKULE] [PAREMALE] VULKAANITIPP");
			}
		}
		else if(h==-2){
			if (v ==-2){
				taustauuendus(veekogu);

				tkoht.setText(" POOLSAAR [EDASI] [TAGASI] EI SAA KÄIA, SIIN ON AREENI PIIR\n"
						+" EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] SÜGAV ORG JÕEGA");
			}
			else if (v == -1){
				taustauuendus(poolsaar);

				tkoht.setText(" POOLSAAR [EDASI] [TAGASI] VEEKOGU\n"
						+" EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 0){
				taustauuendus(poolsaar);

				tkoht.setText(" TÜHERMAA/KIVISTUNUD LAAVA [EDASI] [TAGASI] POOLSAAR\n"
						+" EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VEEKOGU");
			}
			else if (v == 1){
				taustauuendus(wasteland);

				tkoht.setText(" TÜHERMAA/KIVISTUNUD LAAVA [EDASI] [TAGASI] POOLSAAR\n"
						+" EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANIJALAM");
			}
			else{
				taustauuendus(wasteland);

				tkoht.setText(" EI SAA KÄIA, SIIN ON AREENI PIIR [EDASI] [TAGASI] TÜHERMAA/KIVISTUNUD LAAVA\n"
						+" EI SAA KÄIA, SIIN ON AREENI PIIR [VASAKULE] [PAREMALE] VULKAANINÕLV");
			}

		}

	}

	public void start(Stage primaryStage) {
		width = primaryStage.getWidth();
		height = primaryStage.getHeight();

		//Käikudega vahetab pildi ja ei lase tekstikastil nooleklahve 'ära süüa'
		EventHandler <KeyEvent> filter = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.UP)) {		        
					try {
						if (v<2){
							v++;
						}

						sammude_kirjeldus();
						mangija.juhtumid();
						event.consume();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				else if (event.getCode().equals(KeyCode.DOWN)) {
					try {
						if (v > -2){
							v--;
						}

						sammude_kirjeldus();
						mangija.juhtumid();
						event.consume();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if (event.getCode().equals(KeyCode.LEFT)) {
					try {
						if (h> -2){
							h--;
						}

						sammude_kirjeldus();
						mangija.juhtumid();
						event.consume();

					}
					catch (Exception e) {
						e.printStackTrace();

					}
				}
				else if (event.getCode().equals(KeyCode.RIGHT)) {

					try {
						if (h < 2){
							h++;
						}
						sammude_kirjeldus();
						mangija.juhtumid();
						event.consume();
					}   
					catch (Exception e) {
						e.printStackTrace();
					}


				}

			}
		};


		//Tekstikasikene
		StackPane sp1=new StackPane();
		StackPane sp2 = new StackPane();

		//väljale lisame eventfiltri
		tekstivali.addEventFilter(KeyEvent.KEY_PRESSED, filter);

		sammude_kirjeldus();

		//See kast, kuhu info kuvatakse
		//kõik põhimuutused siin, nimetasin vana kasti ümber ja tegin uue kasti kasts nagu kast syndmus:
		//See kast, kuhu info kuvatakse
		Image image=new Image("application/paber_taust.jpg");
		Rectangle kastl=new Rectangle(0, 400, 550, 125);
		kastl.setFill(new ImagePattern(image, 0, 0, 1,1, true));
		StackPane.setAlignment(tkoht, Pos.CENTER_LEFT);
		StackPane.setAlignment(skoht, Pos.CENTER_LEFT);
		Rectangle kasts=new Rectangle(0, 525, 550, 125);
		kasts.setFill(new ImagePattern(image, 0, 0, 1,1, true));



		Pane panec=new Pane();
		Pane panea=new Pane();
		Pane paneb=new Pane();

		panec.getChildren().add(canvas);
		panea.getChildren().add(sp1);
		paneb.getChildren().add(sp2);
		panea.setLayoutX(0);
		panea.setLayoutY(525);
		paneb.setLayoutX(0);
		paneb.setLayoutY(400);
		piir.setTop(panec);
		sp1.getChildren().addAll(kastl, tkoht);
		sp2.getChildren().addAll(kasts, skoht);


		tekstivali.setLayoutX(10.0);
		tekstivali.setLayoutY(652.0);


		juur.getChildren().addAll(piir, tekstivali, panec, panea, paneb);


		Scene stseen1 = new Scene(juur, 380, 676, Color.WHITE);

		primaryStage.setTitle("Your hunger games");


		primaryStage.setScene(stseen1);
		//Kuna menüü tegime juba resizable, siis päris mängu siiski ei teinud
		primaryStage.setResizable(false);
		primaryStage.show();

		//Siit peaks teoreeriliselt sündmusi genereerima
		Sissejuhatus sj = new Sissejuhatus();
		String [] str = {"Katniss", "12"};
		sj.main(str);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static TextField getTekstivali(){
		return tekstivali;
	}
	public static Text getSkoht() {
		return skoht;
	}

	public void setTkoht(Text skoht) {
		this.skoht = skoht;
	}
}
