package RiverCrossing;

import LevelOne.PlayGameScene;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class LevelsScene{

    private Scene scene;
    GameEngine gameEngine = GameEngine.getGameEngine();
    public LevelsScene(Stage stage, Scene menuScene)
    {
        Image image = new Image("file:images.jpg");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(497);
        iv.setFitWidth(600);
        iv.setPreserveRatio(false);
        //-------
        Button levelOneBtn = new Button("Level 1");
        Circle circle = new Circle(50);
        levelOneBtn.setPrefHeight(70);
        levelOneBtn.setPrefWidth(98);
        levelOneBtn.setShape(circle);
        levelOneBtn.setTextFill(Paint.valueOf("White"));
        levelOneBtn.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
        levelOneBtn.setOpacity(0.85);
        levelOneBtn.setLayoutX(251);
        levelOneBtn.setLayoutY(138);
        //-------
        Pane pane = new Pane();
        pane.getChildren().addAll(iv, levelOneBtn);
        pane.setPrefSize(600,497);
        scene = new Scene(pane);
        //-------
        levelOneBtn.setOnAction(e->{
            PlayGameScene levelOneScene = new PlayGameScene(stage, scene);
            stage.setScene(levelOneScene.getScene());
        });
    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
