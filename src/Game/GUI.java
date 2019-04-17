package Game;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import java.lang.Math;
import java.awt.geom.Point2D;
import java.util.HashMap;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class GUI {
	
	//Path where all payload sprites are located
	private static final String imgPath_Dir = "../Res/Buttons/";
	private static final String imgPath_Gap 	= imgPath_Dir +
			"Button.Gap.png";
	
	//Buttons
	private static final String imgPath_Close	= imgPath_Dir +
			"Button.Close_Normal.png";
	private static final String imgPath_Go		= imgPath_Dir +
			"Button.Go_Normal.png";
	private static final String imgPath_Restart	= imgPath_Dir +
			"Button.Close_Normal.png";
	
	//Controls
	private static final String imgPath_DirL	= imgPath_Dir +
			"Button.Dir.L_Normal.png";
	private static final String imgPath_DirR	= imgPath_Dir +
			"Button.Dir.R_Normal.png";
	private static final String imgPath_DirFW	= imgPath_Dir +
			"Button.Dir.FW_Normal.png";

    private boolean complete;

    public GUI(TileGrid pane, ControlledConveyor[] controlledConveyors, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom, Stage primaryStage) {
    	


        Button closeButton = new Button("Close");
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        closeButton.setOnAction(e -> Platform.exit());
        controlledConveyors[0].setDir(Dir.FW);
        controlledConveyors[2].setDir(Dir.FW);
        controlledConveyors[5].setDir(Dir.FW);



        Button switch1 = new Button("^");
        switch1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch1.getText()) {

                    case ">": {
                        switch1.setText("^");
                        controlledConveyors[0].setDir(Dir.FW);
                        controlledConveyors[2].setDir(Dir.FW);

                        tileTracker.put(new Point2D.Double(controlledConveyors[0].GetView().getX(), controlledConveyors[0].GetView().getY()), Dir.FW);
                        tileTracker.put(new Point2D.Double(controlledConveyors[2].GetView().getX(), controlledConveyors[2].GetView().getY()), Dir.FW);

                        break;
                    }

                    case "^": {
                        switch1.setText(">");
                        controlledConveyors[0].setDir(Dir.R);
                        controlledConveyors[2].setDir(Dir.R);

                        tileTracker.put(new Point2D.Double(controlledConveyors[0].GetView().getX(), controlledConveyors[0].GetView().getY()), Dir.R);
                        tileTracker.put(new Point2D.Double(controlledConveyors[2].GetView().getX(), controlledConveyors[2].GetView().getY()), Dir.R);

                        break;
                    }

                }
            }
        });

        Button switch2 = new Button();
        switch2.setGraphic(new ImageView(new Image(getClass().getResource
						(imgPath_DirFW).toString(),true)));
        switch2.setPadding(Insets.EMPTY);
        switch2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch2.getText()) {

                    case "<": {
                        switch2.setText("^");
                        controlledConveyors[1].setDir(Dir.FW);

                        tileTracker.put(new Point2D.Double(controlledConveyors[1].GetView().getX(), controlledConveyors[1].GetView().getY()), Dir.FW);

                        break;
                    }

                    case "^": {
                        switch2.setText(">");
                        controlledConveyors[1].setDir(Dir.R);

                        tileTracker.put(new Point2D.Double(controlledConveyors[1].GetView().getX(), controlledConveyors[1].GetView().getY()), Dir.R);

                        break;
                    }

                    case ">": {
                        switch2.setText("<");
                        controlledConveyors[1].setDir(Dir.L);

                        tileTracker.put(new Point2D.Double(controlledConveyors[1].GetView().getX(), controlledConveyors[1].GetView().getY()), Dir.L);

                        break;
                    }
                }
            }
        });

        Button switch3 = new Button("^");
        switch3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch3.getText()) {

                    case "<": {
                        switch3.setText("^");
                        controlledConveyors[3].setDir(Dir.FW);
                        controlledConveyors[4].setDir(Dir.FW);

                        tileTracker.put(new Point2D.Double(controlledConveyors[3].GetView().getX(), controlledConveyors[3].GetView().getY()), Dir.FW);
                        tileTracker.put(new Point2D.Double(controlledConveyors[4].GetView().getX(), controlledConveyors[4].GetView().getY()), Dir.FW);

                        break;
                    }

                    case "^": {
                        switch3.setText(">");
                        controlledConveyors[3].setDir(Dir.R);
                        controlledConveyors[4].setDir(Dir.R);

                        tileTracker.put(new Point2D.Double(controlledConveyors[3].GetView().getX(), controlledConveyors[3].GetView().getY()), Dir.R);
                        tileTracker.put(new Point2D.Double(controlledConveyors[4].GetView().getX(), controlledConveyors[4].GetView().getY()), Dir.R);

                        break;
                    }

                    case ">": {
                        switch3.setText("<");
                        controlledConveyors[3].setDir(Dir.L);
                        controlledConveyors[4].setDir(Dir.L);

                        tileTracker.put(new Point2D.Double(controlledConveyors[3].GetView().getX(), controlledConveyors[3].GetView().getY()), Dir.L);
                        tileTracker.put(new Point2D.Double(controlledConveyors[4].GetView().getX(), controlledConveyors[4].GetView().getY()), Dir.L);

                        break;
                    }
                }
            }
        });

        Button switch4 = new Button("^");
        switch4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch4.getText()) {

                    case "<": {
                        switch4.setText("^");
                        controlledConveyors[5].setDir(Dir.FW);

                        tileTracker.put(new Point2D.Double(controlledConveyors[5].GetView().getX(), controlledConveyors[5].GetView().getY()), Dir.FW);

                        break;
                    }

                    case "^": {
                        switch4.setText("<");
                        controlledConveyors[5].setDir(Dir.L);

                        tileTracker.put(new Point2D.Double(controlledConveyors[5].GetView().getX(), controlledConveyors[5].GetView().getY()), Dir.L);

                        break;
                    }

                    }
                }

        });
        
        // "Restart" Button
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(__ -> {
            System.out.println("Restarting game!");
            primaryStage.close();
            //Quick & dirty fix until an instances arrayList is implemented in Shape.java
			Platform.runLater( () -> (new Main()).start (new Stage()));
			//TODO ^^^ Replace this atrocity with something cleaner asap
        });

        //button to generate next piece
        Button go = new Button("go!");
        go.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {

                //random start point for the next piece
                int shapeNumRange = 3;
                int shapeNum = (int)(Math.random() * (double)shapeNumRange) + 1;
                Shape sh1 = new Shape(ShapeTypes.square, controlledConveyors, pane, tileTracker, startingPointTo, startingPointFrom, primaryStage);


            }
        });
        
        //Add all the buttons to the pane at the end, to ensure all nodes are
		//added in the correct order (otherwise tab functionality will break)
		pane.add(go, 0, 11, 2, 1);
		pane.add(switch1, 1, 11);
		pane.add(restartButton, 2, 11);
		pane.add(switch2, 4, 11);
		pane.add(switch3, 7, 11);
		pane.add(switch4, 10, 11);
		pane.add(closeButton, 11, 11);
		
    }
}
