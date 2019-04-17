package RiverCrossing;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class StartUpScene {

    private Scene scene;

    public StartUpScene(Stage stage)
    {
        //Setting the Welcome window
        Image image = new Image("file:images1.png");
        ImageView iv = new ImageView(image);
        iv.setPreserveRatio(false);
        iv.setFitHeight(440);
        iv.setFitWidth(617);
        //---------------

        Pane pane = new Pane();
        pane.setPrefSize(600,427);
        scene = new Scene(pane);
        //---------------

        Button btnMenu = new Button("Menu");
        btnMenu.setLayoutX(241);
        btnMenu.setLayoutY(367);
        btnMenu.setPrefHeight(46);
        btnMenu.setPrefWidth(119);
        btnMenu.setTextFill(Paint.valueOf("Red"));
        btnMenu.setOpacity(0.75);
        pane.getChildren().addAll(iv,btnMenu);

        //MENU BUTTON ACTION

        btnMenu.setOnAction(e-> {
            MenuScene menuScene = new MenuScene(stage);
            stage.setScene(menuScene.getScene());
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
