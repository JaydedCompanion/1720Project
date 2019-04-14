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
	
	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	//TUTORIAL: https://stackoverflow.com/questions/27089627/javafx-switch-scene-with-slide-effect 
	private int WIDTH = 800;
	private int HEIGHT = 600;
	private Stage primaryScene;
	private Scene scene1, scene2;
	Stage window;
	char gate1 = 'c';
	int gate2 = 1;

    @Override
    public void start(Stage primaryStage) {
    	
    	window = primaryStage;
    	GridPane grid = new GridPane();
		StackPane stack = new StackPane ();
		
    	////////////////////SCENE 1/////////////////////////
		primaryStage.setTitle("Game Project");
		Button button1 = new Button("Click this button for tutorial.");
		grid.add(button1, 10, 10);
		button1.setOnAction(e -> window.setScene(scene2));	
		grid.setAlignment(Pos.TOP_LEFT);
		
		Label label = new Label("Welcome! We need your help!");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		grid.add(label, 0, 2);
		
		Text textFont = new Text("MOVE THE SHAPES");
		textFont.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		textFont.setFill(Color.CORAL);
		grid.add(textFont, 4, 9);
		
		Text developersText = new Text("Developers: Juan, Vlad, Tran");
		developersText.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		developersText.setFill(Color.RED);
		grid.add(developersText, 2, 3);
		
    	Image angry = new Image("Res/angry.png");
		ImageView imgNode2 = new ImageView(angry);
		imgNode2.setPreserveRatio(true);
		imgNode2.setFitWidth(200);
		grid.add(imgNode2, 0, 3);
		
		//Background image
		Image umbrella = new Image("Res/backgroundImage.png");
		double widthBackground = umbrella.getWidth();
		double heightBackground = umbrella.getHeight();
		StackPane stackBackground = new StackPane ();
		Scene sceneBackground = new Scene (stackBackground, widthBackground, heightBackground);

		try {
			ImageView backgroundView = new ImageView ();
			stackBackground.getChildren().add(backgroundView);
			
			primaryStage.setScene(sceneBackground);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//stack.getChildren().addAll(stackBackground, label, textFont,imgNode2, developersText, button1);
		scene1 = new Scene(stack, WIDTH, HEIGHT);
		
        //Button for next tutorial
        Button nextView = new Button("Click this button for tutorial.");
        nextView.setPadding(new Insets(5));
        BorderPane view1 = new BorderPane(imgNode2, developersText, stackBackground, nextView, textFont);
        BorderPane.setAlignment(nextView, Pos.TOP_LEFT);
        
		button1.setOnAction(e -> window.setScene(scene2));	

    	////////////////////SCENE 2/////////////////////////
        Button button2 = new Button("Click the box to play game!");
        button2.setOnAction(e -> window.setScene(scene1));
        
		Text tutorialText = new Text("How to Play:");
		tutorialText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		tutorialText.setFill (Color.BLACK);
		grid.add(tutorialText, 0, 0);
		
		stack.getChildren().addAll(button2, tutorialText);
		
        Group view2 = new Group();
        view2.getChildren().addAll(tutorialText, button2);

        StackPane root = new StackPane(view1);

        // Slide show
		nextView.setOnAction(event -> {
			root.getChildren().add(view2);
			double width = root.getWidth();
			KeyFrame start = new KeyFrame(Duration.ZERO, new KeyValue(view2.translateXProperty(), width),
					new KeyValue(view1.translateXProperty(), 0));
			KeyFrame end = new KeyFrame(Duration.seconds(1), new KeyValue(view2.translateXProperty(), 0),
					new KeyValue(view1.translateXProperty(), -width));
			Timeline slide = new Timeline(start, end);
			slide.setOnFinished(e -> root.getChildren().remove(view1));
			slide.play();
		});
		
        Scene finalScene = new Scene(root, WIDTH, HEIGHT);
        
    	////////////////////SCENE 3: Play "Main" class/////////////////////////
        
		scene3 = ((Main.class));
		// Show scene    
        primaryStage.setScene(finalScene);
        primaryStage.show();
    }
}