package application;

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
	AnchorPane ankur=new AnchorPane();
	//private Canvas nood = new Canvas(400,325);

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

	
	boolean isgameover = false;
	//tekstiv�li
	
	static Text tkoht= new Text(10.0, 400.0, "kirjeldus");
	//ekraani laius ja k�rgus
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

		EventHandler <KeyEvent> filter = new EventHandler<KeyEvent>() {
		    public void handle(KeyEvent event) {
		    	if (event.getCode().equals(KeyCode.UP)) {		        
		        try {
					if (v<2){
						v++;
					}
					sammude_kirjeldus();
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
								event.consume();
							}   
							catch (Exception e) {
								e.printStackTrace();
							}
						
						
					}
		    		
		    	}
		    };
		    
		//piir.setTop(nood);
		//BorderPane piir2 = new BorderPane();
		StackPane sp1=new StackPane();
		TextField tekstivali=new TextField("hylgemola");
		//väljale lisame eventfiltri
		tekstivali.addEventFilter(KeyEvent.KEY_PRESSED, filter);
//		TextArea kirjeldusekast = new TextArea();
//		kirjeldusekast.setText(" Kalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \n"
//				+ "b��\n"
//				+ "lol\n"
//				+ "alkjg\n"
//				+ "dlkjhj\n");
//		kirjeldusekast.setPrefRowCount(4);
//		kirjeldusekast.setPrefColumnCount(30);
//		kirjeldusekast.setWrapText(true);
//		piir2.setCenter(kirjeldusekast);
		
		//piir2.setBottom(nood);
		//piir.setBottom(piir2);
		//Nupuvajutamise kuular



		//stseen, mille k�ljes k�ik muu

		sammude_kirjeldus();
		
		Image image=new Image("application/paber_taust.jpg");
		Rectangle kast=new Rectangle(0, 400, 550, 125);
		kast.setFill(new ImagePattern(image, 0, 0, 1,1, true));
		StackPane.setAlignment(tkoht, Pos.CENTER_LEFT);
		
		sp1.getChildren().addAll(kast, tkoht);
		
		Pane panec=new Pane();
		panec.getChildren().add(canvas);
		piir.setTop(panec);
		piir.setBottom(sp1);

		tekstivali.setLayoutX(10.0);
		tekstivali.setLayoutY(527.0);
		
		
		
		juur.getChildren().addAll(piir, panec, tekstivali);
		

		
		//piir.setBottom(tekstivali);

		
		Scene stseen1 = new Scene(juur, 400, 550, Color.WHITE);
		
		primaryStage.setTitle("Your hunger games");

		
		//tkoht.prefHeight(100);

		primaryStage.setScene(stseen1);
		primaryStage.show();
		
		
		Sissejuhatus sj = new Sissejuhatus();
		String [] str = {"Katniss", "12"};
		sj.main(str);


	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Text getTkoht() {
		return tkoht;
	}

	public void setTkoht(Text tkoht) {
		this.tkoht = tkoht;
	}
}
