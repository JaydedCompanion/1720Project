package sandboxfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.scene.shape.*;

public class MovingCircleAndSquare extends Application {

	final int WIDTH = 800;
	final int HEIGHT = 600;
	char gate1 = 'c';
	int gate2 = 1;

	Pane myPane = new Pane();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button exitButton = new Button("Exit");
		exitButton.setOnAction(new ExitButtonListener());

		Circle circle = new Circle();
		circle.setCenterX(100.0f);
		circle.setCenterY(100.0f);
		circle.setRadius(30.0f);

		Rectangle c1 = new Rectangle();
		c1.setX(380);
		c1.setY(560);
		c1.setWidth(40);
		c1.setHeight(40);

		Path p1 = new Path();
		p1.getElements().add(new MoveTo(380, 560));
		p1.getElements().add(new LineTo(380, 260));

		Path p2 = new Path();
		p2.getElements().add(new MoveTo(380, 260));
		p2.getElements().add(new LineTo(380, 60));

		Path p3 = new Path();
		p3.getElements().add(new MoveTo(380, 260));
		p3.getElements().add(new LineTo(480, 260));
		p3.getElements().add(new LineTo(480, 60));

		Path p4 = new Path();
		p4.getElements().add(new MoveTo(380, 260));
		p4.getElements().add(new LineTo(280, 260));
		p4.getElements().add(new LineTo(280, 60));

		PathTransition pt1 = new PathTransition();
		pt1.setDuration(Duration.millis(5000));
		pt1.setNode(c1);
		pt1.setPath(p1);
		pt1.setOrientation(OrientationType.NONE);
		pt1.setCycleCount(1);
		pt1.setAutoReverse(true);
		pt1.play();

		PathTransition pt2 = new PathTransition();
		pt2.setDuration(Duration.millis(5000));
		pt2.setNode(c1);

		switch (gate1) {

		case 'a':
			pt2.setPath(p2);
			System.out.println("one is " + pt2.getStatus());
			break;
		case 'b':
			pt2.setPath(p3);
			System.out.println("two is " + pt2.getStatus());
			break;
		case 'c':
			pt2.setPath(p4);
			System.out.println("three is " + pt2.getStatus());
			break;
		}

		pt2.setCycleCount(1);

		pt1.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pt2.play();
			}

		});

		// myPane.getChildren().add(c1);
		myPane.getChildren().addAll(c1, circle);

		Scene scene = new Scene(myPane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();

		primaryStage.setOnCloseRequest(e -> Platform.exit());

	}

	public class ExitButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			Platform.exit();
		}
	}
}