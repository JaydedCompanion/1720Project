package Game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlidingViewTest extends Application {
	
	/*
	 
	 * Some of the code (specifically the slide show) in this class is from https://stackoverflow.com/questions/27089627/javafx-switch-scene-with-slide-effect
	 *
	 * This code is "vital" to the functionality of the game (so that the game has slide show effect), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.
	 
	 */
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	private int WIDTH = 1000;
	private int HEIGHT = 200;
	private Stage primaryScene;
	private Scene scene1, scene2;
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		GridPane grid = new GridPane();
		StackPane stack = new StackPane();
		
		primaryStage.setTitle("Game Project");
		
		////////////////////SCENE 1/////////////////////////
		Button button1 = new Button("Click this button for tutorial.");
		button1.setOnAction(e -> window.setScene(scene2));
		grid.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(button1, 0, 0);
		
		Label label = new Label("Welcome! We need your help!");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		grid.add(label, 0, 2);
		
		Text textFont = new Text("GUIDE THE SHAPES INTO THE CORRECT HOLE!");
		textFont.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		textFont.setFill(Color.CORAL);
		grid.add(textFont, 2, 3);
		
		Text developersText = new Text("Developers: Juan, Vlad, Tran");
		developersText.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		developersText.setFill(Color.RED);
		grid.add(developersText, 4, 9);
		
		Image angry = new Image("Res/angry.png");
		ImageView imgNode2 = new ImageView(angry);
		imgNode2.setPreserveRatio(true);
		imgNode2.setFitWidth(200);
		grid.add(imgNode2, 0, 3);
		
		//Background image
		StackPane stackBackground = new StackPane();
		Image background = new Image("Res/backgroundImage.png");
		double widthBackground = background.getWidth();
		double heightBackground = background.getHeight();
		Scene sceneBackground = new Scene(stackBackground, widthBackground, heightBackground);
		try {
			ImageView backgroundView = new ImageView();
			backgroundView.setImage(background);
			//stackBackground.getChildren().add(backgroundView);	
			//primaryStage.setScene(sceneBackground);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scene1 = new Scene(stack, WIDTH, HEIGHT);
		
		//Button for next tutorial
		Button nextView = new Button("Click this button for tutorial.");
		nextView.setPadding(new Insets(5));
		BorderPane view1 = new BorderPane(stackBackground, textFont, imgNode2, nextView, developersText);
		BorderPane.setAlignment(nextView, Pos.TOP_LEFT);
		
		////////////////////SCENE 2/////////////////////////
		Text tutorialText = new Text("How to Play:");
		tutorialText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		tutorialText.setFill(Color.BLACK);
		grid.add(tutorialText, 3, 5);
		
		Text conveyorsInstructions = new Text("Click on '<','^', or '>' to change the conveyors' direction.");
		conveyorsInstructions.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		conveyorsInstructions.setFill(Color.BLACK);
		grid.add(conveyorsInstructions, 3, 10);
		
		Text go = new Text("Click 'go!' to start the game. The shapes will start moving on the conveyor.");
		go.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		go.setFill(Color.BLACK);
		grid.add(go, 3, 11);
		
		Text restart = new Text("Click 'restart' to reset the game.");
		restart.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		restart.setFill(Color.BLACK);
		grid.add(restart, 3, 15);
		
		Text close = new Text("Click 'close' to quit the game.");
		close.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		close.setFill(Color.BLACK);
		grid.add(close, 3, 15);
		
		Button button2 = new Button("Click this box to play the game!");
		button2.setOnAction(e -> window.setScene(scene1));
		grid.add(button2, 0, 0);
		
		GridPane grid2 = new GridPane();
		grid2.getChildren().addAll(tutorialText, conveyorsInstructions, restart, go, button2);
		
		StackPane root = new StackPane(view1);
		nextView.setOnAction(event -> {
			root.getChildren().add(grid2);
			double width = root.getWidth();
			KeyFrame start = new KeyFrame(Duration.ZERO, new KeyValue(grid2.translateXProperty(), width),
					new KeyValue(view1.translateXProperty(), 0));
			KeyFrame end = new KeyFrame(Duration.seconds(1), new KeyValue(grid2.translateXProperty(), 0),
					new KeyValue(view1.translateXProperty(), -width));
			Timeline slide = new Timeline(start, end);
			slide.setOnFinished(e -> root.getChildren().remove(view1));
			slide.play();
		});
		
		Scene finalScene = new Scene(root, WIDTH, HEIGHT);
		////////////////////SCENE 3: Play "Main" class/////////////////////////
		
		//scene3 = ((Main.class));
		
		// Show scene    
		primaryStage.setScene(finalScene);
		primaryStage.show();
	}
}