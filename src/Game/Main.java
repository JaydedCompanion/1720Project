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
	
	    TileGrid layout = new TileGrid(5,8);
	    
	    final ControlledConveyor[] controlledConveyors = new ControlledConveyor[] {
			new ControlledConveyor(),
			new ControlledConveyor(),
			new ControlledConveyor(),
			new ControlledConveyor(),
			new ControlledConveyor()
		};
	
		layout.add(new StaticConveyor(Dir.FW), 1, -1);
		layout.add(new StaticConveyor(Dir.FW), 1, -2);
		layout.add(controlledConveyors[0], 1, -3);
	
		layout.add(controlledConveyors[1], 2, -1);
		layout.add(new StaticConveyor(Dir.FW), 2, -3);
		layout.add(new StaticConveyor(Dir.FW), 2, -4);
		layout.add(new StaticConveyor(Dir.FW), 2, -5);
		layout.add(new StaticConveyor(Dir.FW), 2, -6);
		layout.add(new StaticConveyor(Dir.FW), 2, -7);
		
		layout.add(new StaticConveyor(Dir.FW), 3, -1);
		layout.add(new StaticConveyor(Dir.FW), 3, -2);
		layout.add(new StaticConveyor(Dir.L), 3, -3);
	    
	    System.out.println(layout.getConveyor(0, 1));
	
		layout.fillEmptyTiles();
	    
	    layout.setAlignment(Pos.CENTER);
	
		Button cycle = new Button(">");
		layout.add(cycle, 0, 0);
		cycle.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				ControlledConveyor.cycleAllDir();
			}
		});
	    
        primaryStage.setTitle("SpriteAnimation Test!");
        primaryStage.setScene(new Scene(
        		layout,
				(layout.getCols()+1)*32,
				(layout.getRows()+1)*32
		));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
