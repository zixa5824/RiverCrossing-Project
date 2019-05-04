package RiverCrossing;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        StartUpScene startUpScene = new StartUpScene(primaryStage);
        primaryStage.setScene(startUpScene.getScene());
        primaryStage.setTitle("River Crossing Game");
        primaryStage.show();
        primaryStage.setResizable(false);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
