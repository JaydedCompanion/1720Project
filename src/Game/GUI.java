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
			"Button.Restart_Normal.png";
	
	private static final int BUTTON_ROW_INDEX = 11; //Stores index of row that
	// holds buttons

    private boolean complete;

    public GUI(TileGrid pane, ControlledConveyor[] controlledConveyors, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom, Stage primaryStage) {
	
    
	
		ImageView gap = new ImageView(new Image(
				getClass().getResource(imgPath_Gap).toString(),
				true
		));
		gap.setPreserveRatio(false);//Allow stretching
		gap.setFitWidth(GridTileBase.SIZE*pane.getCols());
		pane.add(gap,0, BUTTON_ROW_INDEX, pane.getCols(), 1);
	
		ImageView iconClose = new ImageView(new Image(
				getClass().getResource(imgPath_Close).toString(),
				true
		));
		ImageView iconGo = new ImageView(new Image(
				getClass().getResource(imgPath_Go).toString(),
				true
		));
		ImageView iconRestart = new ImageView(new Image(
				getClass().getResource(imgPath_Restart).toString(),
				true
		));

        // "Close" Button    
	    Button closeButton = new Button();
		closeButton.setPadding(Insets.EMPTY);
		closeButton.setGraphic(iconClose);
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
        Button restartButton = new Button();
		restartButton.setPadding(Insets.EMPTY);
		restartButton.setGraphic(iconRestart);
        restartButton.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
				System.out.println("Restarting game!");
				primaryStage.close();
				Main game = new Main();
				game.start(primaryStage);
			}
        });

        //button to generate next piece
        Button go = new Button();
		go.setPadding(Insets.EMPTY);
		go.setGraphic(iconGo);
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
		pane.add(go, 0, BUTTON_ROW_INDEX, 2, 1);
		pane.add(switch1, 1, BUTTON_ROW_INDEX);
		pane.add(restartButton, 2, BUTTON_ROW_INDEX);
		pane.add(switch2, 4, BUTTON_ROW_INDEX);
		pane.add(switch3, 7, BUTTON_ROW_INDEX);
		pane.add(switch4, 10, BUTTON_ROW_INDEX);
		pane.add(closeButton, 11, BUTTON_ROW_INDEX);
		
    }
}
