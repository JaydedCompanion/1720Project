package Game;

import java.awt.geom.Point2D;
import java.util.HashMap;
import javafx.stage.Stage;

enum ShapeTypes {
    circle,
    square,
    triangle,
	trash
}

public class Shape extends GridTileBase {
	
	//Path where all payload sprites are located
	private static final String imgPath_Dir = "../Res/ConveyorPayloads/";
	//Paths for Circle sprites. Stored in array for easy randomization
    private static final String[] imgPath_Circle = new String[] {
    		imgPath_Dir + "Payload.Circle_8Ball.png",
			imgPath_Dir + "Payload.Circle_Donut.png",
			imgPath_Dir + "Payload.Circle_ChocoDonut.png"
	};
	//Paths for Square sprites. Stored in array for easy randomization
	private static final String[] imgPath_Square = new String[] {
			imgPath_Dir + "Payload.Square_Crate.png",
			imgPath_Dir + "Payload.Square_Parcel.png",
			imgPath_Dir + "Payload.Square_ParcelTilted.png"
	};
	//Paths for Triangle sprites. Stored in array for easy randomization
	private static final String[] imgPath_Triangle = new String[] {
			imgPath_Dir + "Payload.Triangle_Cheese.png",
			imgPath_Dir + "Payload.Triangle_Watermelon.png"
	};

    private ShapeTypes shape;
    
    public Shape (ShapeTypes shape, ControlledConveyor[] controlledConveyors, TileGrid pane, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom, Stage primaryStage) {
        
        this.shape = shape;
        
        float rand = (float)Math.random();
        String[] paths;
    
        switch (shape) {
            case circle:
				paths = imgPath_Circle;
                break;
            case square:
				paths = imgPath_Square;
                break;
			default://Set paths var to triangle by default to avoid undefinedArray exceptions
            case triangle:
            	paths = imgPath_Triangle;
                break;
        }
        
        setAnimPath(paths[Math.round(rand * paths.length)]);

		int range = startingPointTo - startingPointFrom + 1;
		int startPoint = (int)(Math.random() * (double)range) + startingPointFrom;

		switch(startPoint) {
			case 30:
				pane.add(this, 1, 10);
//				this.setX(96.0D);
//				this.setY(672.0D);
				break;
			case 31:
				pane.add(this, 4, 10);
//				obj.setX(288.0D);
//				obj.setY(672.0D);
				break;
			case 32:
				pane.add(this, 7, 10);
//				obj.setX(480.0D);
//				obj.setY(672.0D);
				break;
			case 33:
				pane.add(this, 10, 10);
//				obj.setX(672.0D);
//				obj.setY(672.0D);
		}
    
    }
    
}
