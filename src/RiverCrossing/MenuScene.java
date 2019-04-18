package RiverCrossing;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuScene{
    private Scene scene;

    public MenuScene(Stage stage) {

        //------
        Label welcomeLabel = new Label("Welcome To MainMenu");
        welcomeLabel.setPrefWidth(256);
        welcomeLabel.setPrefHeight(86);
        welcomeLabel.setLayoutX(173);
        welcomeLabel.setLayoutY(14);
        //------
        Button btnStartGame = new Button("StartGame");
        btnStartGame.setLayoutX(238);
        btnStartGame.setLayoutY(130);
        btnStartGame.setPrefHeight(31);
        btnStartGame.setPrefWidth(125);
        btnStartGame.setTextFill(Paint.valueOf("Green"));
        //------
        //------
        Button btnLevels = new Button("Levels");
        btnLevels.setLayoutX(252);
        btnLevels.setLayoutY(190);
        btnLevels.setPrefHeight(31);
        btnLevels.setPrefWidth(98);
        btnLevels.setTextFill(Paint.valueOf("Green"));
        //------
        Button btnLoadGame = new Button("LoadGame");
        btnLoadGame.setLayoutX(238);
        btnLoadGame.setLayoutY(250);
        btnLoadGame.setPrefHeight(44);
        btnLoadGame.setPrefWidth(125);
        btnLoadGame.setTextFill(Paint.valueOf("Green"));
        //------
        //------
        Button btnExit = new Button("Exit");
        btnExit.setLayoutX(488);
        btnExit.setLayoutY(342);
        btnExit.setPrefHeight(31);
        btnExit.setPrefWidth(98);
        btnExit.setTextFill(Paint.valueOf("Red"));
        //------
        Ellipse ellipse = new Ellipse();
        ellipse.setOpacity(0.5);
        ellipse.setRadiusX(139);
        ellipse.setRadiusY(51);
        ellipse.setLayoutX(300);
        ellipse.setLayoutY(57);
        Stop[] stops = new Stop[] { new Stop(0, Color.DARKRED), new Stop(1, Color.BLACK)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        ellipse.setFill(lg1);
        //------
        //FONT
        Font font = new Font(20);
        btnLevels.setFont(font);
        btnLoadGame.setFont(font);
        btnExit.setFont(font);
        btnStartGame.setFont(font);
        welcomeLabel.setFont(new Font("RockWell Extra Bold",18));
        //------
        //Setting the Image
        Image image = new Image("file:image.jpg");
        ImageView iv = new ImageView(image);
        iv.setPreserveRatio(false);
        iv.setFitHeight(400);
        iv.setFitWidth(617);
        iv.setOpacity(0.7);
        //---------------
        Pane pane = new Pane();
        pane.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.getChildren().addAll(iv,btnStartGame,btnExit,btnLoadGame,btnLevels,welcomeLabel,ellipse);
        pane.setPrefSize(600,400);
        scene = new Scene(pane);

        //----------------------------------

        //START BUTTON

        btnStartGame.setOnAction(e->{
            PlayGameScene playGameScene = new PlayGameScene(stage, scene);
            stage.setScene(playGameScene.getScene());
        });

        //EXIT BUTTON

        btnExit.setOnAction(e->{
            stage.close();
        });

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}

