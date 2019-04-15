package sandboxfx;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BackgroundImage extends Application {
	
	/*

	 * The code in this class is from https://www.youtube.com/watch?v=F8bY18QAj6U
	 *
	 * This code is "vital" to the functionality of the game (so that the game has a background), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

	 */

	public void start(Stage stage) {
		
		StackPane pane = new StackPane();
		
		//Image IMAGE = new Image("https://www.rjob.in/wp-content/uploads/2015/01/background-professionalservices.jpg");
		Image backgroundImage = new Image("Res/backgroundImage.png");
		double height = backgroundImage.getHeight();
		double width = backgroundImage.getWidth();
		
		Scene scene = new Scene(pane, height, width);
		try {
			ImageView  backgroundView = new ImageView ();
			 backgroundView.setImage(backgroundImage);
			pane.getChildren().add(backgroundView);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
