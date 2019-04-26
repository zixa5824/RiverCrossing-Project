package RiverCrossing;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        btnMenu.setLayoutX(265);
        btnMenu.setLayoutY(177);
        btnMenu.setPrefHeight(74);
        btnMenu.setPrefWidth(71);
        btnMenu.setTextFill(Paint.valueOf("Red"));
        btnMenu.setOpacity(0.85);
        pane.getChildren().addAll(iv,btnMenu);
        Circle circle = new Circle(600);
        btnMenu.setShape(circle);
        btnMenu.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        btnMenu.setTextFill(Paint.valueOf("White"));
        btnMenu.setFont(new Font(18));
        //ANIMATION OF THE BUTTON
        Circle circle2 = new Circle(150);
        circle2.setLayoutY(177);
        circle2.setLayoutX(265);
        circle2.setCenterX(-200);
        circle2.setCenterY(-150);
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setPath(circle2);
        transition.setCycleCount(2);
        transition.setOrientation(PathTransition.OrientationType.NONE);
        transition.setNode(btnMenu);
        transition.play();
        //------
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
