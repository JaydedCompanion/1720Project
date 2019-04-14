package sandboxfx;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BackgroundImage extends Application {

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
