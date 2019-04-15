package sandboxfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Reset extends Application {
 
        /*

	 * The code in this class is from https://pastebin.com/CjEqRQcc
	 *
	 * This code is "vital" to the functionality of the game (so that the game has one reset/restart button), but since it is not
	 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
	 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

	 */
	
    @Override
    public void start(Stage primaryStage) {
 
        Group root = new Group();
        Scene scene = new Scene(root, 300, 240);
        String num4;
        int num1 = (int) (Math.random() * 100);
        int num2 = (int) (Math.random() * 100);
        int num3 = num1 + num2;
        num4 = String.valueOf(num3);
 
        Text text1 = new Text();
        text1.setText("Time for addition");
        text1.setLayoutX(50);
        text1.setLayoutY(20);
        root.getChildren().add(text1);
 
        Text text2 = new Text();
        text2.setLayoutX(50);
        text2.setLayoutY(40);
        text2.setText("    " + num1);
        root.getChildren().add(text2);
 
        Text text3 = new Text();
        text3.setLayoutX(50);
        text3.setLayoutY(60);
        text3.setText("+  " + num2);
        root.getChildren().add(text3);
 
        TextField answer = new TextField();
        answer.setPrefColumnCount(9);
        answer.setLayoutX(50);
        answer.setLayoutY(70);
        answer.getText();
        root.getChildren().add(answer);
 
        Button submit = new Button("Submit");
        submit.setLayoutX(200);
        submit.setLayoutY(70);
        root.getChildren().add(submit);
 
        //Adding a Label
        Label label = new Label();
        root.getChildren().add(label);
 
        //Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                if ((answer.getText().equals(num4))) {
                    label.setLayoutX(60);
                    label.setLayoutY(100);
                    label.setText("Correct!");
                } else {
                    label.setLayoutX(60);
                    label.setLayoutY(100);
                    label.setText("Incorrect, please try again");
                }
            }
        });
 
        Button reset = new Button("Start a new Problem");
        reset.setLayoutX(50);
        reset.setLayoutY(130);
        root.getChildren().add(reset);
 
        reset.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                final int num1 = (int) (Math.random() * 100);
                final int num2 = (int) (Math.random() * 100);
                final int num3 = num1 + num2;
                String num4 = String.valueOf(num3);
                Group root1 = new Group();
                Scene scene1 = new Scene(root1, 300, 240);
                text2.setText("    " + num1);
                text3.setText("+  " + num2);
                root1.getChildren().addAll(text1, text2, text3, answer, submit, label, reset);
               
                submit.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                if ((answer.getText().equals(num4))) {
                    label.setLayoutX(60);
                    label.setLayoutY(100);
                    label.setText("Correct!");
                } else {
                    label.setLayoutX(60);
                    label.setLayoutY(100);
                    label.setText("Incorrect, please try again");
                }
            }
        });
               
                primaryStage.setTitle("Simple Addition");
                primaryStage.setScene(scene1);
                primaryStage.show();
            }
        });
 
        primaryStage.setTitle("Simple Addition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
 
}
