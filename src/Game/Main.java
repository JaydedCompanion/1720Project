package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.util.HashMap;
import java.util.Map;
import java.awt.geom.Point2D;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		TileGrid layout = new TileGrid(12, 11);

		// to pass to ControlledConveyor constructor
		Dir [] dirArrayLR = {Dir.L, Dir.R};
		Dir [] dirArrayLRF = {Dir.L, Dir.R, Dir.FW};

		final ControlledConveyor[] controlledConveyors = new ControlledConveyor[] {
				new ControlledConveyor(),
				new ControlledConveyor(),
				new ControlledConveyor(),
				new ControlledConveyor(),
				new ControlledConveyor(),
				new ControlledConveyor()};

		final int staticConveyorsFW = 34;
		final int staticConveyorsR = 6;
		final int staticConveyorsL = 6;
		final int startingPointFrom = 30;
		final int startingPointTo = 33;

		//reordered to retrieve children and their locations for the hashmap
		layout.add(new StaticConveyor(Dir.FW), 1, -2); //0
		layout.add(new StaticConveyor(Dir.FW), 1, -3);
		layout.add(new StaticConveyor(Dir.FW), 1, -8);
		layout.add(new StaticConveyor(Dir.FW), 1, -9);
		layout.add(new StaticConveyor(Dir.FW), 1, -10);
		layout.add(new StaticConveyor(Dir.FW), 1, -5);
		layout.add(new StaticConveyor(Dir.FW), 1, -6);
		layout.add(new StaticConveyor(Dir.FW), 4, -5);
		layout.add(new StaticConveyor(Dir.FW), 4, -6);
		layout.add(new StaticConveyor(Dir.FW), 4, -8);
		layout.add(new StaticConveyor(Dir.FW), 4, -9);
		layout.add(new StaticConveyor(Dir.FW), 4, -10);
		layout.add(new StaticConveyor(Dir.FW), 7, -2);
		layout.add(new StaticConveyor(Dir.FW), 7, -3);
		layout.add(new StaticConveyor(Dir.FW), 7, -5);
		layout.add(new StaticConveyor(Dir.FW), 7, -6);
		layout.add(new StaticConveyor(Dir.FW), 4, -2);
		layout.add(new StaticConveyor(Dir.FW), 4, -3);
		layout.add(new StaticConveyor(Dir.FW), 4, -4);
		layout.add(new StaticConveyor(Dir.FW), 7, -8);
		layout.add(new StaticConveyor(Dir.FW), 7, -9);
		layout.add(new StaticConveyor(Dir.FW), 7, -10);
		layout.add(new StaticConveyor(Dir.FW), 10, -2);
		layout.add(new StaticConveyor(Dir.FW), 10, -3);
		layout.add(new StaticConveyor(Dir.FW), 10, -5);
		layout.add(new StaticConveyor(Dir.FW), 10, -6);
		layout.add(new StaticConveyor(Dir.FW), 10, -7);
		layout.add(new StaticConveyor(Dir.FW), 10, -8);
		layout.add(new StaticConveyor(Dir.FW), 10, -9);
		layout.add(new StaticConveyor(Dir.FW), 10, -10);
		layout.add(new StaticConveyor(Dir.FW), 1, -1); //30
		layout.add(new StaticConveyor(Dir.FW), 4, -1); //31
		layout.add(new StaticConveyor(Dir.FW), 7, -1); //32
		layout.add(new StaticConveyor(Dir.FW), 10, -1); //33

		layout.add(new StaticConveyor(Dir.R), 8, -7);
		layout.add(new StaticConveyor(Dir.R), 9, -7);
		layout.add(new StaticConveyor(Dir.R), 2, -4);
		layout.add(new StaticConveyor(Dir.R), 3, -4);
		layout.add(new StaticConveyor(Dir.R), 5, -7);
		layout.add(new StaticConveyor(Dir.R), 6, -7); //39

		layout.add(new StaticConveyor(Dir.L), 2, -7);
		layout.add(new StaticConveyor(Dir.L), 3, -7);
		layout.add(new StaticConveyor(Dir.L), 5, -4);
		layout.add(new StaticConveyor(Dir.L), 6, -4);
		layout.add(new StaticConveyor(Dir.L), 8, -4);
		layout.add(new StaticConveyor(Dir.L), 9, -4); //45


		layout.add(controlledConveyors[0], 1, -7); //46
		layout.add(controlledConveyors[1], 4, -7);
		layout.add(controlledConveyors[2], 1, -4);
		layout.add(controlledConveyors[3], 7, -7);
		layout.add(controlledConveyors[4], 7, -4);
		layout.add(controlledConveyors[5], 10, -4); //51


		HashMap<Point2D.Double, Dir> tileTracker = new HashMap<>();
		
		// destination pieces
		Destination destCircle = new Destination(ShapeTypes.circle);
		layout.add(destCircle, 1, 0);
		
		Destination destSquare = new Destination(ShapeTypes.square);
		layout.add(destSquare, 4,0);
		
		Destination destTriangle = new Destination(ShapeTypes.triangle);
		layout.add(destTriangle, 7, 0);

		layout.fillEmptyTiles(new BlankVariants[]{
				BlankVariants.Padding,
				BlankVariants.Quarters
		});

		layout.setAlignment(Pos.CENTER);

		primaryStage.setTitle("SpriteAnimation Test!");
		primaryStage.setScene(new Scene(
				layout,
				(layout.getCols()+1)*64,
				(layout.getRows()+1)*64
		));
		primaryStage.show();

		// to map directions of static FW conveyors
		int count = 0;
		for (int i = 0; i<staticConveyorsFW; i++) {

			tileTracker.put(new Point2D.Double((layout.getChildren().get(i).getLayoutX()), (layout.getChildren().get(i).getLayoutY())), Dir.FW);
			count++;
		}

		for (int i = count; i<staticConveyorsR+staticConveyorsFW; i++) {

			tileTracker.put(new Point2D.Double((layout.getChildren().get(i).getLayoutX()), (layout.getChildren().get(i).getLayoutY())), Dir.R);
			count++;
		}

		for (int i = count; i<staticConveyorsL+staticConveyorsR+staticConveyorsFW; i++) {

			tileTracker.put(new Point2D.Double((layout.getChildren().get(i).getLayoutX()), (layout.getChildren().get(i).getLayoutY())), Dir.L);
			count++;
		}

		GUI gui = new GUI(layout, controlledConveyors, tileTracker, startingPointTo, startingPointFrom, primaryStage);

	// "Restart" Button
		Button restartButton = new Button("Restart");
		layout.add(restartButton, 2, 11);
		restartButton.setOnAction(__ -> {
			System.out.println("Restarting game!");
			primaryStage.close();
			primaryStage.setScene(new Scene(new StackPane(layout)));
			//primaryStage.setScene(new Scene(new TileGrid(12, 11)));
			primaryStage.show();
		});
	}


	public static void main(String[] args) {
		launch(args);
	}

}
