package Game;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.lang.Math;
import java.awt.geom.Point2D;
import java.util.HashMap;



public class GUI {

    private boolean complete;

    public GUI(TileGrid pane, ControlledConveyor[] controlledConveyors, HashMap<Point2D.Double, Dir> tileTracker, int startingPointTo, int startingPointFrom) {


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

        Button go = new Button("go!");
        pane.add(go, 0, 11, 2, 1);
        go.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                //System.out.println(pane.getConveyor(1, 11));
                //place rect on first child's tile

                int startPoint = (int)Math.random()*(startingPointTo-startingPointFrom+startingPointTo);

                Rectangle rect = new Rectangle(pane.getChildren().get(startPoint).getLayoutX()+32,
                        pane.getChildren().get(startPoint).getLayoutY()+32, 64, 64);

                pane.add(rect, 2, 7);

                Path p1 = new Path();


                complete = false;

                while (!complete) {
                    switch (tileTracker.get(new Point2D.Double(rect.getX(), rect.getY()))) {
                        case FW:
                            p1.getElements().add(new LineTo(rect.getX() + 32, rect.getY() - 32));
                            break;
                        case L:
                            p1.getElements().add(new LineTo(rect.getX() - 32, rect.getY() + 32));
                            break;
                        case R:
                            p1.getElements().add(new LineTo(rect.getX() + 32, rect.getY() + 32));
                            break;
                    }
                    if (rect.getX() == pane.getChildren().get(12).getLayoutX()
                            && rect.getY() == pane.getChildren().get(12).getLayoutX()){
                        complete = true;
                    }

                }

                p1.getElements().add (new MoveTo(pane.getChildren().get(0).getLayoutX()+64,
                        pane.getChildren().get(0).getLayoutY()+64));



                PathTransition pt1 = new PathTransition();
                pt1.setDuration(Duration.millis(1000));
                pt1.setNode(rect);
                pt1.setPath(p1);
                pt1.play();
            }
        });
    }
}
