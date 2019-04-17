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

    private boolean complete;

    public GUI(TileGrid pane, ControlledConveyor[] controlledConveyors, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom, Stage primaryStage) {
    	


        // "Close" Button    
	    Button closeButton = new Button("Close");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	          Platform.exit();
	        }
	      });


	
		Button switch1 = new DirectionalButton(
				new ControlledConveyor[] {
						controlledConveyors[0],
						controlledConveyors[2]
				},
				new Dir[] {
						Dir.R,
						Dir.FW
				}
		);

        Button switch2 = new DirectionalButton(
			new ControlledConveyor[] {
				controlledConveyors[1]
			}
		);
	
		Button switch3 = new DirectionalButton(
				new ControlledConveyor[] {
						controlledConveyors[3],
						controlledConveyors[4]
				}
		);
	
		Button switch4 = new DirectionalButton(
				new ControlledConveyor[] {
						controlledConveyors[5]
				},
				new Dir[] {
						Dir.L,
						Dir.FW
				}
		);
        
        // "Restart" Button
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	        	System.out.println("Restarting game!");
	            primaryStage.close();
	            //Quick & dirty fix until an instances arrayList is implemented in Shape.java
				Platform.runLater( () -> (new Main()).start (new Stage()));
				//TODO ^^^ Replace this atrocity with something cleaner asap
	        }
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
