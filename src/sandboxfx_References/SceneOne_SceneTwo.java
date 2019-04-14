package sandboxfx;

import java.util.Stack;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SceneOne_SceneTwo extends Application {
	
	private int WIDTH = 800;
	private int HEIGHT = 600;
	private Stage primaryScene;
	private Scene scene1, scene2;
	Scene scene3;
	Stage window;
	char gate1 = 'c';
	int gate2 = 1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("Game Project");
		window = primaryStage;
        
		GridPane grid = new GridPane();
		StackPane stack = new StackPane ();

		// SCENE 1
		VBox layout1 = new VBox (20);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Button button1 = new Button("Click this button for tutorial.");
		grid.add(button1, 3, 0);
		
		Label label = new Label("Welcome! We need your help!");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		grid.add(label, 0, 2);
		
		
		Text textFont = new Text("MOVE THE SHAPES");
		textFont.setId("MOVE THE SHAPES");
		//textFont.setFontSmoothingType(FontSmoothingType.LCD);
		grid.add(textFont, 0, 2);

		Image angry = new Image("Res/angry.png");
		ImageView imgNode2 = new ImageView(angry);
		imgNode2.setPreserveRatio(true);
		imgNode2.setFitWidth(200);
		grid.add(imgNode2, 0, 3);	
		
		Image umbrella = new Image ("Res/angry.png");
		ImageView backgroundImage = new ImageView (umbrella);
		Group root = new Group ();
		root.getChildren().addAll(backgroundImage);
		Scene sceneBackground = new Scene (root, 500, 300);
		primaryScene.setScene (sceneBackground);
		primaryScene.setResizable (false);
		
		layout1.getChildren().addAll(label, textFont,imgNode2, button1);
		button1.setOnAction(e -> window.setScene(scene2));	
		scene1 = new Scene(layout1, WIDTH, HEIGHT);
		
		// SCENE 2
		VBox layout2 = new VBox (20);
		
		primaryStage.setTitle("Game Project");
		grid.setPadding(new Insets(25, 25, 25, 25));
		Button button2 = new Button("Click the box to play game!");
		grid.add(button2, 5, 5);
		
		Text tutorialText = new Text("Here are your tutorials.");
		tutorialText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		tutorialText.setFill (Color.BLACK);
		grid.add(tutorialText, 5, 5);
		
		layout2.getChildren().addAll(tutorialText, button2);
        //button2.setOnAction(e -> window.setScene(scene1)); //go back to Scene 1
		button2.setOnAction(e -> window.setScene(scene3));
		scene2 = new Scene(layout2, WIDTH, HEIGHT);
		
		// SCENE 3: "Main" class
		//scene3 = ((Main.class));
		
		// Show scene
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
}
