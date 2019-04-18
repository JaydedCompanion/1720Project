package Game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * Some of the code (specifically the slide show) in this class is from https://stackoverflow.com/questions/27089627/javafx-switch-scene-with-slide-effect
 *
 * This code is "vital" to the functionality of the game (so that the game has slide show effect), but since it is not
 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
 * no credit for it and we will simply use it as a pre-written library by a 3rd party.
 */

public class SlidingViewTest extends Application {
			
	private int WIDTH = 1000;
	private int HEIGHT = 1000;
	private Stage primaryScene;
	private Scene scene1, scene2;
	private Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.show();
		window = primaryStage;
		GridPane grid = new GridPane();
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

		Reflection reflection = new Reflection();
		reflection.setFraction(0.3);
		
		primaryStage.setTitle("Game Project");
		
		
		
		//SCENE 1////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		StackPane speech = new StackPane();       
		Rectangle rect = new Rectangle(200,100);
        rect.setFill(Color.ALICEBLUE);
		Label label = new Label("Welcome! We need your help!");
		label.setFont(Font.font("Impact", FontWeight.BOLD, 30));
        speech.getChildren().addAll(rect, label);
		
		Text textFont = new Text("GUIDE THE ITEMS INTO THE CORRECT HOLE!");
		textFont.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		textFont.setUnderline(true);
		textFont.setFill(Color.CORAL);
		
		Text developersText = new Text("Developers: Juan Callejas, Vladislav Luchnikov, Tran Pham");
		developersText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
		developersText.setFill(Color.RED);
		
		Image angry = new Image("Res/angry.png");
		ImageView imgNode2 = new ImageView(angry);
		imgNode2.setPreserveRatio(true);
		imgNode2.setFitWidth(200);
							
		Button nextView = new Button("Click this button for tutorial.");
		nextView.setEffect(dropShadow);
		nextView.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 window.setScene(scene2);
		        }
		});		
		
		VBox view1 = new VBox (textFont, developersText, label, imgNode2, nextView);
		view1.setAlignment(Pos.TOP_LEFT);
		view1.setSpacing(20);
		view1.setPadding(new Insets(20));
		
		
		
		//SCENE 2////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		Button button2 = new Button("Got it? Good! Let's begin! Click this button to play the game!");
		button2.setPadding(new Insets(10));
		button2.setEffect(dropShadow);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent event) {
				 window.setScene(scene1);
		        }
		});	
	        
		Text tutorialText = new Text("How to Play:");
		tutorialText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		tutorialText.setUnderline(true);
		
		Text go = new Text("Click the 'green arrow icon' to start the game. The given items will start moving on the conveyors.");
		go.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));

		Text close = new Text("Click the 'red cross icon' to quit the game.");
		close.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		
		Text restart = new Text("Click the 'orange restart arrow icon' to reset the game.");
		restart.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
		
		Text directionalText = new Text("Click these three different coloured arrows below to change the direction of the conveyors' panels.");
		directionalText.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));

		Button goButton = new Button("", new ImageView("Res/Buttons/Button.Go_Normal.png"));
		goButton.setEffect(reflection);
		Button closeButton = new Button("", new ImageView("Res/Buttons/Button.Close_Normal.png"));
		closeButton.setEffect(reflection);
		Button restartButton = new Button("", new ImageView("Res/Buttons/Button.Restart_Normal.png"));
		restartButton.setEffect(reflection);
		Button forwardButton = new Button("", new ImageView("Res/Buttons/Button.Dir.FW_Normal.png"));
		Button leftButton = new Button("", new ImageView("Res/Buttons/Button.Dir.L_Normal.png"));
		Button rightButton = new Button("", new ImageView("Res/Buttons/Button.Dir.R_Normal.png"));
		
		// Border line
		StackPane root = new StackPane(view1);
		String border = "-fx-border-color: DARKBLUE;\n" + "-fx-border-insets: 5;\n" 
		+ "-fx-border-width: 6;\n" + "-fx-border-style: dashed;\n";
		root.getChildren().addAll(tutorialText, go, goButton, close, closeButton, 
				restart, restartButton, directionalText, forwardButton, leftButton, rightButton, button2);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPrefSize(WIDTH, HEIGHT);
		root.setStyle(border);
		
		VBox view2 = new VBox(tutorialText, go, goButton, close, closeButton, 
				restart, restartButton, directionalText, forwardButton, leftButton, rightButton, button2);
		view2.setAlignment(Pos.TOP_LEFT);
		view2.setSpacing(10);
		view2.setPadding(new Insets(15, 20, 10, 10));

		// "Slideshow" Effect
		nextView.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				root.getChildren().add(view2);
				double width = root.getWidth();
				
				KeyFrame start = new KeyFrame(Duration.ZERO, new KeyValue(view2.translateXProperty(), width),
						new KeyValue(view1.translateXProperty(), 0));
				
				KeyFrame end = new KeyFrame(Duration.seconds(1), new KeyValue(view2.translateXProperty(), 0),
						new KeyValue(view1.translateXProperty(), -width));
				
				Timeline slide = new Timeline(start, end);
				
				slide.setOnFinished(new EventHandler<ActionEvent>() {
			        public void handle(ActionEvent event) {
			        	root.getChildren().remove(view1);
			        }
			      });
				slide.play();
			}
		});
		
		// Show scene
		scene2 = new Scene(root, WIDTH, HEIGHT, Color.ANTIQUEWHITE);
		primaryStage.setScene(scene2);
		primaryStage.show();
		
		
		
		
		//SCENE 3: Play "Main" class////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	}
	public static void main(String[] args) {
		
		launch(args);
	}
}	
