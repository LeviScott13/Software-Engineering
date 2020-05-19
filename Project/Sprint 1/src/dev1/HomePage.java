package dev1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class HomePage extends Application{
	protected Text text = new Text(50, 50, "JavaFX Programming");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		// Create a scene and place it in the stage
	    Scene scene = new Scene(getPane(), 450, 200);
	    primaryStage.setTitle("Home"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  
		
	}
	protected BorderPane getPane() {
	    
		BorderPane layout = new BorderPane();
		
		HBox paneForButtons = new HBox(20);
	    Button btSearch = new Button("Search");
	    Button btSignin = new Button("Profile");  
	    paneForButtons.getChildren().addAll(btSearch, btSignin);
	    paneForButtons.setAlignment(Pos.CENTER);
	    paneForButtons.setStyle("-fx-border-color: green");

	    
	    layout.setBottom(paneForButtons);
	    
	    Pane paneForText = new Pane();
	    paneForText.getChildren().add(text);
	    layout.setCenter(paneForText);
	    
//		btLeft.setOnAction(e -> text.setX(text.getX() - 10));
//		btRight.setOnAction(e -> text.setX(text.getX() + 10));

	    
	    return layout;
	  }
}
