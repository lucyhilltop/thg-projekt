package application;
	


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

public class Menu extends Application  {

	public void start(Stage primaryStage) {
		StackPane sp = new StackPane();
		Group textj=new Group();
		Group texti=new Group();
		Group nim=new Group();
		BorderPane borderpane=new BorderPane();
		primaryStage.setTitle("THG");
		
		Image taust = new Image("file:/Users/ami/Documents/OOP_java2014/graphic/img/paber_taust.jpg", 500, 400, false, false);
		ImageView taustView=new ImageView(taust);
		final Text ta = TextBuilder.create().text("Alusta").build();
		final Text tl= TextBuilder.create().text("Välju").build();
		final Text tnim= TextBuilder.create().text("Näljamängud alaku").build();
		ta.setFont(Font.font ("Impact", 29));
		tnim.setFont(Font.font ("Impact",35));
		tl.setFont(Font.font ("Impact", 29));
		ta.setFill(Color.BLACK);
		tl.setFill(Color.BLACK);
	   
	   // t.setY(200.0);
		textj.getChildren().add(ta);
		texti.getChildren().add(tl);
		nim.getChildren().add(tnim);
		sp.setAlignment(tnim,Pos.TOP_CENTER);
		sp.setMargin(tnim, new Insets(100,100,0,0));
		sp.setAlignment(texti,Pos.CENTER);
		sp.setMargin(texti,new Insets (120,0,0,0));
		sp.getChildren().addAll(taustView,tnim, textj, texti);
		 //handlerid erinevatele syndmustele 
		class Kasitleja implements EventHandler<MouseEvent> {
			    public void handle(MouseEvent me) {
			    	DropShadow ds = new DropShadow();
			    	ds.setOffsetY(3.0f);
			    	ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
			        ta.setEffect(ds);
			        ta.setCache(true);
			        ta.setX(10.0);
			        ta.setY(270.0);
			        }      
			}
		class Kasitleja3 implements EventHandler<MouseEvent> {
		    public void handle(MouseEvent me) {
		    	DropShadow ds = new DropShadow();
		    	ds.setOffsetY(3.0f);
		    	ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		        tl.setEffect(ds);
		        tl.setCache(true);
		        tl.setX(10.0);
		        tl.setY(270.0);
		        }      
		}
		
		class Kasitleja_drop implements EventHandler<MouseEvent> {
		    public void handle(MouseEvent ma) {
		    	ta.setEffect(null);
		    	
		    }      
		}
		class Kasitleja_drop2 implements EventHandler<MouseEvent> {
		    public void handle(MouseEvent ma) {
		    	tl.setEffect(null);
		    }      
		}
		  
		  Kasitleja kasitleja1 = new Kasitleja();
		  Kasitleja3 kasitleja3 = new Kasitleja3();
		  Kasitleja_drop kasitleja2 = new Kasitleja_drop();
		  Kasitleja_drop2 kasitleja4 = new Kasitleja_drop2();
		  ta.addEventHandler(MouseEvent.MOUSE_ENTERED, kasitleja1);
		  tl.addEventHandler(MouseEvent.MOUSE_ENTERED, kasitleja3);
		  
		  ta.addEventHandler(MouseEvent.MOUSE_EXITED, kasitleja2);
		  tl.addEventHandler(MouseEvent.MOUSE_EXITED, kasitleja4);
		
		Scene scene=new Scene(sp);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}

