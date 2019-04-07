package Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
	
	    TileGrid layout = new TileGrid(5,8);
	
		layout.add(new StaticConveyor(Dir.Forward), 1, -1);
		layout.add(new StaticConveyor(Dir.Forward), 1, -2);
		layout.add(new StaticConveyor(Dir.Right), 1, -3);
	
		layout.add(new StaticConveyor(Dir.Forward), 2, -3);
		layout.add(new StaticConveyor(Dir.Forward), 2, -4);
		layout.add(new StaticConveyor(Dir.Forward), 2, -5);
		layout.add(new StaticConveyor(Dir.Forward), 2, -6);
		layout.add(new StaticConveyor(Dir.Forward), 2, -7);
		
		layout.add(new StaticConveyor(Dir.Forward), 3, -1);
		layout.add(new StaticConveyor(Dir.Forward), 3, -2);
		layout.add(new StaticConveyor(Dir.Left), 3, -3);
	    
	    System.out.println(layout.getConveyor(0, 1));
	
		layout.fillEmptyTiles();
	    
	    layout.setAlignment(Pos.CENTER);
	    
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
