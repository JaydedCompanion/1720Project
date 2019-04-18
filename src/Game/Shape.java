package Game;

import java.awt.geom.Point2D;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import java.lang.InterruptedException;

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
        
        setAnimPath(paths[Math.round(rand * paths.length - 1)]);

		int range = startingPointTo - startingPointFrom + 1;
		int startPoint = (int)(Math.random() * (double)range) + startingPointFrom;

		switch(startPoint) {
			case 30:
				pane.add(this, 1, 10);
				this.GetView().setX(96.0D);
				this.GetView().setY(672.0D);
				break;
			case 31:
				pane.add(this, 4, 10);
				this.GetView().setX(288.0D);
				this.GetView().setY(672.0D);
				break;
			case 32:
				pane.add(this, 7, 10);
				this.GetView().setX(480.0D);
				this.GetView().setY(672.0D);
				break;
			case 33:
				pane.add(this, 10, 10);
				this.GetView().setX(672.0D);
				this.GetView().setY(672.0D);
		}

		int complete = 0;

		System.out.println("XXXXX" + this.GetView().getX() + "YYYYY" + this.GetView().getY());

		while (complete < 2){
		switch (tileTracker.get(new Point2D.Double(this.GetView().getX(), this.GetView().getY()))) {
                        case FW:
                        	this.GetView().setY(this.GetView().getY() - 64);
                        	TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), this.GetView());
                        	tt1.stop();
                        	tt1.setByY(-64);
							tt1.play();
							complete++;
							System.out.println("XXXXX" + this.GetView().getX() + "YYYYY" + this.GetView().getY());

                            break;
                        case L:
							this.GetView().setX(this.GetView().getX() - 64);
							TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), this.GetView());
							tt2.stop();
							tt2.setByX(-64);
							tt2.play();
							complete++;
							System.out.println("XXXXX" + this.GetView().getX() + "YYYYY" + this.GetView().getY());

                            break;
                        case R:
							this.GetView().setX(this.GetView().getX() + 64);
							TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), this.GetView());
							tt3.stop();
							tt3.setByX(+64);
							tt3.play();
							complete++;
							System.out.println("XXXXX" + this.GetView().getX() + "YYYYY" + this.GetView().getY());

                            break;}


	//	System.out.println("xxxxx" + this.GetView().getX());

		// transition object one

   //             TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), this.GetView());
//				tt1.setOnFinished(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//					@Override
//					public void handle (ActionEvent event) {
//						pane.setRowIndex(shape.GetView(), rowy = rowy - 1);
//					}});
		//		tt1.setCycleCount(5);
//                tt1.setByY(-64);
//				this.GetView().setY(this.GetView().getY()-64);
//				pane.setRowIndex(this.GetView(), rowy--);
//				tt1.setByY(-64);
//				this.GetView().setY(this.GetView().getY()-64);
//
//				boolean complete = false;
//
//				while (!complete){
//				;}
//				while (complete){
//                tt1.stop();}
//
//
//                int complete = 0;
//
//                while (complete < 5) {
//                    switch (tileTracker.get(new Point2D.Double(this.GetView().getX(), this.GetView().getY()))) {
//                        case FW:
//                            tt1.setByY(-128);
//							tt1.play();
//							complete++;
//                            break;
//                        case L:
//                            tt1.setByX(-128);
//							tt1.play();
//							complete++;
//                            break;
//                        case R:
//                            tt1.setByX(+128);
//							tt1.play();
//							complete++;
//                            break;
//
//                    }

                    //96 and 21 are coordinates of the destination square for testing
//                    if (this.GetView().getX() == 96 && this.GetView().getY() == pane.getChildren().get(21).getLayoutX()){
//                        complete = true;
//                    }

                }

	}}
    

