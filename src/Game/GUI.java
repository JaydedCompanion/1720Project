package Game;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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

    private boolean complete;

    public GUI(TileGrid pane, ControlledConveyor[] controlledConveyors, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom, Stage primaryStage) {




        Button closeButton = new Button("Close");
        pane.add(closeButton, 11, 11);
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        closeButton.setOnAction(e -> Platform.exit());
        controlledConveyors[0].setDir(Dir.FW);
        controlledConveyors[2].setDir(Dir.FW);
        controlledConveyors[5].setDir(Dir.FW);



        Button switch1 = new Button("^");
        pane.add(switch1, 1, 11);
        switch1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch1.getText()) {

                    case ">": {
                        switch1.setText("^");
                        controlledConveyors[0].setDir(Dir.FW);
                        controlledConveyors[2].setDir(Dir.FW);
                        break;
                    }

                    case "^": {
                        switch1.setText(">");
                        controlledConveyors[0].setDir(Dir.R);
                        controlledConveyors[2].setDir(Dir.R);
                        break;
                    }

                }
            }
        });

        Button switch2 = new Button("^");
        pane.add(switch2, 4, 11);
        switch2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch2.getText()) {

                    case "<": {
                        switch2.setText("^");
                        controlledConveyors[1].setDir(Dir.FW);
                        break;
                    }

                    case "^": {
                        switch2.setText(">");
                        controlledConveyors[1].setDir(Dir.R);
                        break;
                    }

                    case ">": {
                        switch2.setText("<");
                        controlledConveyors[1].setDir(Dir.L);
                        break;
                    }
                }
            }
        });

        Button switch3 = new Button("^");
        pane.add(switch3, 7, 11);
        switch3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch3.getText()) {

                    case "<": {
                        switch3.setText("^");
                        controlledConveyors[3].setDir(Dir.FW);
                        controlledConveyors[4].setDir(Dir.FW);
                        break;
                    }

                    case "^": {
                        switch3.setText(">");
                        controlledConveyors[3].setDir(Dir.R);
                        controlledConveyors[4].setDir(Dir.R);
                        break;
                    }

                    case ">": {
                        switch3.setText("<");
                        controlledConveyors[3].setDir(Dir.L);
                        controlledConveyors[4].setDir(Dir.L);
                        break;
                    }
                }
            }
        });

        Button switch4 = new Button("^");
        pane.add(switch4, 10, 11);
        switch4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                switch (switch4.getText()) {

                    case "<": {
                        switch4.setText("^");
                        controlledConveyors[5].setDir(Dir.FW);
                        break;
                    }

                    case "^": {
                        switch4.setText("<");
                        controlledConveyors[5].setDir(Dir.L);
                        break;
                    }

                    }
                }

        });

        //button to generate next piece
        Button go = new Button("go!");
        pane.add(go, 0, 11, 2, 1);
        go.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {

                //random start point for the next piece
                int shapeNumRange = 3;
                int shapeNum = (int)(Math.random() * (double)shapeNumRange) + 1;
                Shape sh1 = new Shape(ShapeTypes.square, controlledConveyors, pane, tileTracker, startingPointTo, startingPointFrom, primaryStage);


                // transition object one
//                TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), obj);
//                tt1.setByY(-64);
//                tt1.play();


//                complete = false;
//
//                while (!complete) {
//                    switch (tileTracker.get(new Point2D.Double(obj.getX(), obj.getY()))) {
//                        case FW:
//                            tt1.setByY(-64);
//                            break;
//                        case L:
//                            tt1.setByX(-64);
//                            break;
//                        case R:
//                            tt1.setByX(+64);
//                            break;
//                    }
//
//                    //96 and 21 are coordinates of the destination square for testing
//                    if (obj.getX() == 96 && obj.getY() == pane.getChildren().get(21).getLayoutX()){
//                        complete = true;
//                    }
//
//                }

            }
        });
    }
}
