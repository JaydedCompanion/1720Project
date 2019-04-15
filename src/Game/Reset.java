package Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Reset extends Application {
	
	/*

	 * The code in this class is from https://gist.github.com/bugabinga/ce9e0ae2328ba34133bd
	 *
	 * This code is "vital" to the functionality of the game (so that the game has a reset button), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

	 */

	@Override
	public void start(final Stage primaryStage) {
		final Button restartButton = new Button("Restart");
		restartButton.setOnAction(__ -> {
			primaryStage.close();
			Platform.runLater(() -> new Reset().start(new Stage()));
		});
		primaryStage.setScene(new Scene(new StackPane(restartButton)));
		primaryStage.show();
	}
	
	public static void main(final String[] args) {
		launch(args);
	}
}