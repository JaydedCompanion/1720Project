package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
	
	    TileGrid layout = new TileGrid(12, 10);
	    
	    final ControlledConveyor[] controlledConveyors = new ControlledConveyor[] { new ControlledConveyor(),
				new ControlledConveyor(), new ControlledConveyor(), new ControlledConveyor(),
				new ControlledConveyor(), new ControlledConveyor() };
	
		//////////////////////////////////////////////
		 // LEFT CONVEYOR
		layout.add(new StaticConveyor(Dir.FW), 1, -1);
		layout.add(new StaticConveyor(Dir.FW), 1, -2);
		layout.add(new StaticConveyor(Dir.R), 1, -3);
		layout.add(new StaticConveyor(Dir.R), 2, -3);
		layout.add(new StaticConveyor(Dir.R), 3, -3);
		
		layout.add(new StaticConveyor(Dir.FW), 1, -4);
		layout.add(new StaticConveyor(Dir.FW), 1, -5);
		layout.add(controlledConveyors[0], 1, -6);
		layout.add(new StaticConveyor(Dir.L), 2, -6);
		layout.add(new StaticConveyor(Dir.L), 3, -6);
		layout.add(new StaticConveyor(Dir.FW), 1, -7);
		layout.add(new StaticConveyor(Dir.FW), 1, -8);
		layout.add(new StaticConveyor(Dir.FW), 1, -9);
		
		// MIDDLE-LEFT CONVEYOR
		layout.add(new StaticConveyor(Dir.FW), 4, -1);
		layout.add(new StaticConveyor(Dir.FW), 4, -2);
		layout.add(new StaticConveyor(Dir.FW), 4, -3);
		layout.add(new StaticConveyor(Dir.L), 5, -3);
		layout.add(new StaticConveyor(Dir.L), 6, -3);
		
		layout.add(new StaticConveyor(Dir.FW), 4, -4);
		layout.add(new StaticConveyor(Dir.FW), 4, -5);
		layout.add(controlledConveyors[1], 4, -6);
		layout.add(new StaticConveyor(Dir.R), 5, -6);
		layout.add(new StaticConveyor(Dir.R), 6, -6);
		layout.add(new StaticConveyor(Dir.FW), 4, -7);
		layout.add(new StaticConveyor(Dir.FW), 4, -8);
		layout.add(controlledConveyors[2], 4, -9);
		
		// MIDDLE-RIGHT CONVEYOR
		layout.add(new StaticConveyor(Dir.FW), 7, -1);
		layout.add(new StaticConveyor(Dir.FW), 7, -2);
		layout.add(new StaticConveyor(Dir.L), 7, -3);
		
		layout.add(new StaticConveyor(Dir.R), 8, -3);
		layout.add(new StaticConveyor(Dir.R), 9, -3);
		layout.add(new StaticConveyor(Dir.FW), 7, -4);
		layout.add(new StaticConveyor(Dir.FW), 7, -5);
		layout.add(controlledConveyors[3], 7, -6);
		layout.add(new StaticConveyor(Dir.R), 8, -6);
		layout.add(new StaticConveyor(Dir.R), 9, -6);
		layout.add(new StaticConveyor(Dir.FW), 7, -7);
		layout.add(new StaticConveyor(Dir.FW), 7, -8);
		layout.add(controlledConveyors[4], 7, -9);
		
		// RIGHT CONVEYOR
		layout.add(new StaticConveyor(Dir.FW), 10, -1);
		layout.add(new StaticConveyor(Dir.FW), 10, -2);
		layout.add(new StaticConveyor(Dir.FW), 10, -3);
		layout.add(new StaticConveyor(Dir.FW), 10, -4);
		layout.add(new StaticConveyor(Dir.FW), 10, -5);
		layout.add(new StaticConveyor(Dir.FW), 10, -6);
		layout.add(new StaticConveyor(Dir.FW), 10, -7);
		layout.add(new StaticConveyor(Dir.FW), 10, -8);
		layout.add(controlledConveyors[5], 10, -9);
		
		// FILL-IN HOLES REPLACEMENT
		layout.add(new StaticConveyor(Dir.R), 1, -10);
		layout.add(new StaticConveyor(Dir.R), 2, -10);
		layout.add(new StaticConveyor(Dir.R), 3, -10);
		layout.add(new StaticConveyor(Dir.R), 4, -10);
		layout.add(new StaticConveyor(Dir.R), 5, -10);
		layout.add(new StaticConveyor(Dir.R), 6, -10);
		layout.add(new StaticConveyor(Dir.R), 7, -10);
		layout.add(new StaticConveyor(Dir.R), 8, -10);
		layout.add(new StaticConveyor(Dir.R), 9, -10);
		layout.add(new StaticConveyor(Dir.R), 10, -10);
                //////////////////////////////////////////////
	    
	    System.out.println(layout.getConveyor(0, 1));
	
		layout.fillEmptyTiles(new BlankVariants[]{
				BlankVariants.Padding,
				BlankVariants.Quarters
		});
	    
	    layout.setAlignment(Pos.CENTER);
	
		Button cycle = new Button("Click");
		layout.add(cycle, 0, 0);
		cycle.setPrefSize(64,64);
		cycle.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				ControlledConveyor.cycleAllDir();
			}
		});
	    
        primaryStage.setTitle("SpriteAnimation Test!");
        primaryStage.setScene(new Scene(
        		layout,
				(layout.getCols()+1)*64,
				(layout.getRows()+1)*64
		));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
