package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Connect4GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button col1 = new Button("1");
        Button col2 = new Button("2");
        Button col3 = new Button("3");
        Button col4 = new Button("4");
        Button col5 = new Button("5");
        Button col6 = new Button("6");
        Button col7 = new Button("7");

        /*HBox ColButtons = new HBox();
        primaryStage.setTitle("Connect4"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

         */
    }
}
