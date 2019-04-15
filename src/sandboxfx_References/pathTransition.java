package sandboxfx;

import javafx.animation.PathTransition; 
import javafx.application.Application; 
import static javafx.application.Application.launch; 

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage; 
import javafx.util.Duration;  

public class pathTransition extends Application{
	
	/*

	 * The code in this class is from https://www.tutorialspoint.com/javafx/javafx_path_transition.htm
	 *
	 * This code is "vital" to the functionality of the game (so that the game has PathTransition animations), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

	 */
	
	@Override 
	   public void start(Stage primaryStage) { 
		
	      Rectangle rect = new Rectangle();
	      Circle circle = new Circle(); 
	      Path path = new Path(); 
	      
	      //Setting the position of the circle 
	      circle.setCenterX(300.0f); 
	      circle.setCenterY(135.0f); 
	      circle.setRadius(60.0f); 
	      circle.setFill(Color.RED); 
	      circle.setStrokeWidth(20);     
	       
	      //Creating a Path 
	      MoveTo moveTo = new MoveTo(108, 71); 
	      path.getElements().add(moveTo); 
	      
	      LineTo line1 = new LineTo(321, 161);        
	      LineTo line2 = new LineTo(126,232); 
	      LineTo line3 = new LineTo(232,52);        
	      LineTo line4 = new LineTo(269, 250);        
	      LineTo line5 = new LineTo(108, 71);       
	      path.getElements().addAll(line1, line2, line3, line4, line5);     
	      
	      //Creating the path transition 
	      PathTransition pathTransition = new PathTransition(); 
	      pathTransition.setDuration(Duration.millis(1000));       
	      pathTransition.setNode(circle); 
	      pathTransition.setPath(path); 
	      pathTransition.setCycleCount(50); 
	      pathTransition.play(); 
	             
	      Group root = new Group(circle); 
	      Scene scene = new Scene(root, 800, 600);  
	      primaryStage.setTitle("Path transition example"); 
	      primaryStage.setScene(scene); 
	      primaryStage.show(); 
	   }
	   public static void main(String args[]){ 
	      launch(args); 
	   } 

}
