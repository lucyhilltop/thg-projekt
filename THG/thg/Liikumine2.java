package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.stage.Stage;


public class Liikumine extends Application {
	int v=0;
	int h=0;
	//layout
	BorderPane piir = new BorderPane();
	//gruppi pole vaja, borderpane läheb stseenile
	//Group juur=new Group

	
	//tekstiväli
    
    Text tkoht= new Text(" kirjeldus"
    		+ "tralalalaa"
    		+ "blballbaba \n"
    		+  " veeeel pikkkem");

    
    
    
    
	@Override
	
	public void start(Stage primaryStage) {
		

		
		
		//Nupuvajutamise kuular
		 EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent event) {

		        if(event.getCode() == KeyCode.UP) {
		            try {
		                v++;
		                System.out.println(v);
		            } catch (Exception e) {
		                 e.printStackTrace();
		            }
		            //event.consume();
		        } 
		        else if(event.getCode() == KeyCode.DOWN) {
		            try {
		            	v--;
		                System.out.println("alla");
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		            //pole vaja vist
		            //event.consume();
		        } 
		        
		        else if (event.getCode() == KeyCode.LEFT) {
		        	try {
		        		h--;
		        		//kontroll
		        		System.out.println("vasakule");
		        	}
		        	catch (Exception e) {
		        		e.printStackTrace();
		        		
		        	}
		        }
		        
		        else if (event.getCode()==KeyCode.RIGHT) {
		        	try {
		        		h++;
		        	}   
		        	catch (Exception e) {
		        		e.printStackTrace();
		        	}
		        	
		        }
		    }
		}; //kuulari lõpp
		//stseen, mille küljes kõik muu
	    Scene stseen1 = new Scene(piir, 300, 300, Color.SNOW);
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
