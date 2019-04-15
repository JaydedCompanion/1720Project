package sandboxfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CloseProgram extends Application{
	
	/*

	 * The code in this class is from https://www.youtube.com/watch?v=ZuHcl5MmRck&t=107s
	 *
	 * This code is "vital" to the functionality of the game (so that it has 1 close button to properly close the game), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

	 */
	
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
