package sandboxfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CloseProgram extends Application{
	
	 public static void main(String[] args) {
	        launch(args);
	    }
		
	 @Override
	 public void start (Stage primaryStage) {
		 primaryStage.setTitle("Close Program");
		 
		 primaryStage.setOnCloseRequest(e -> Platform.exit());
		 
		 Button button = new Button ("Close Program");
		 button.setOnAction(e -> Platform.exit());
		 
		 StackPane layout = new StackPane ();
		 layout.getChildren().add(button);
		 Scene scene = new Scene (layout, 300, 250);
		 primaryStage.setScene(scene);
		 primaryStage.show();
	 }
}
