package RiverCrossing;
import LevelOne.Boat;
import LevelOne.StrategyOne;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
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
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PlayGameScene {

    private Scene scene;

    public PlayGameScene() {}

    public PlayGameScene(Stage stage, Scene menuScene) {

        // SETTING BACKGROUND IMAGE
        Image backGroundImage = new Image("file:background.jpg");
        ImageView bGIv = new ImageView(backGroundImage);
        bGIv.setPreserveRatio(false);
        bGIv.setFitWidth(1269);
        bGIv.setFitHeight(797);
        bGIv.setFocusTraversable(false);
        //---------------------------
        // SETTING BACKGROUND IMAGE
        Image raftImage = new Image("file:raft-7.png");
        ImageView raftIv = new ImageView(raftImage);
        raftIv.setPreserveRatio(false);
        raftIv.setFitWidth(326);
        raftIv.setFitHeight(150);
        raftIv.setLayoutX(332);
        raftIv.setLayoutY(655);
        raftIv.setFocusTraversable(false);
        Blend blend = new Blend();
        raftIv.setEffect(blend);

        Button sailBtn = new Button("SAIL");
        sailBtn.setLayoutX(550);
        sailBtn.setLayoutY(118);
        sailBtn.setPrefWidth(120);
        sailBtn.setPrefHeight(80);
        Circle circle = new Circle(50);
        sailBtn.setShape(circle);
        sailBtn.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        sailBtn.setTextFill(Paint.valueOf("White"));
        sailBtn.setOpacity(0.85);
        //--------------
        //Game ENGINE
        GameEngine gameEngine = GameEngine.getGameEngine();
        gameEngine.newGame(new StrategyOne());
        List<ICrosser> leftCrossers = gameEngine.getCrossersOnLeftBank();
        //GETTING ALL RIDERS OBJECTS
        ICrosser farmer = leftCrossers.get(0);
        ICrosser cabbage = leftCrossers.get(1);
        ICrosser goat = leftCrossers.get(2);
        ICrosser wolf = leftCrossers.get(3);
        //-----------
        //GETTING BUFFERED IMAGES
        Image leftFarmer, rightFarmer, cabbage1, cabbage2, leftGoat, rightGoat, leftWolf, rightWolf;
        BufferedImage[] farmerBI, cabbageBI, goatBI, wolfBI;
        farmerBI = leftCrossers.get(0).getImages();
        cabbageBI = leftCrossers.get(1).getImages();
        goatBI = leftCrossers.get(2).getImages();
        wolfBI = leftCrossers.get(3).getImages();
        //------
        //SETTING IMAGES
        leftFarmer = SwingFXUtils.toFXImage(farmerBI[0],null);
        rightFarmer = SwingFXUtils.toFXImage(farmerBI[1],null);
        cabbage1 = SwingFXUtils.toFXImage(cabbageBI[0],null);
        cabbage2 = SwingFXUtils.toFXImage(cabbageBI[1],null);
        leftGoat = SwingFXUtils.toFXImage(goatBI[0],null);
        rightGoat = SwingFXUtils.toFXImage(goatBI[1],null);
        leftWolf = SwingFXUtils.toFXImage(wolfBI[0],null);
        rightWolf = SwingFXUtils.toFXImage(wolfBI[1],null);
        //--------
        //SETTING IMAGE VIEWS
        ImageView lf, rf, cab, rCab, lg, rg, lw, rw;
        lf = new ImageView(leftFarmer);
        rf = new ImageView(rightFarmer);
        cab = new ImageView(cabbage1);
        rCab = new ImageView(cabbage2);
        lg = new ImageView(leftGoat);
        rg = new ImageView(rightGoat);
        lw = new ImageView(leftWolf);
        rw = new ImageView(rightWolf);
        //---------
        Boat boat = new Boat();
        //FARMER
        lf.setFitWidth(200);
        lf.setFitHeight(150);
        lf.setLayoutX(182);
        lf.setLayoutY(649);
        lf.setPreserveRatio(false);
        //-------
        //Cabbage
        cab.setLayoutX(163);
        cab.setLayoutY(663);
        cab.setFitHeight(55);
        cab.setFitWidth(45);
        //--------
        //Goat
        lg.setLayoutX(53);
        lg.setLayoutY(505);
        lg.setFitHeight(150);
        lg.setFitWidth(158);
        //--------
        //Wolf
        lw.setLayoutX(27);
        lw.setLayoutY(426);
        lw.setFitHeight(99);
        lw.setFitWidth(158);
        //--------

        //right FARMER
        rf.setFitWidth(200);
        rf.setFitHeight(150);
        rf.setLayoutX(653);
        rf.setLayoutY(426);
        rf.setPreserveRatio(false);
        //-------
        //right Cabbage
        rCab.setLayoutX(839);
        rCab.setLayoutY(531);
        rCab.setFitHeight(55);
        rCab.setFitWidth(45);
        //--------
        //right Goat
        rg.setLayoutX(923);
        rg.setLayoutY(466);
        rg.setFitHeight(150);
        rg.setFitWidth(158);
        //--------
        //right Wolf
        rw.setLayoutX(529);
        rw.setLayoutY(460);
        rw.setFitHeight(99);
        rw.setFitWidth(158);
        //--------

        //CHOOSE LEFT BANK RIDERS
        lf.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank())
            {
                if (!boat.checkRiderOnBoat(farmer)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(farmer);
                        lf.setLayoutX(517);
                        lf.setLayoutY(580);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(farmer);
                    lf.setLayoutX(182);
                    lf.setLayoutY(649);
                }
            }
        });
        cab.setOnMouseClicked(e-> {
            if (gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(cabbage)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(cabbage);
                        cab.setLayoutX(360);
                        cab.setLayoutY(685);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(cabbage);
                    cab.setLayoutX(163);
                    cab.setLayoutY(663);
                }
            }
        });
        lg.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(goat)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(goat);
                        lg.setLayoutX(416);
                        lg.setLayoutY(570);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(goat);
                    lg.setLayoutX(53);
                    lg.setLayoutY(505);
                }
            }
        });
        lw.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(wolf)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(wolf);
                        lw.setLayoutX(382);
                        lw.setLayoutY(655);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(wolf);
                    lw.setLayoutX(27);
                    lw.setLayoutY(426);
                }
            }
        });
        //-------------
        //CHOOSE RIGHT BANK FARMER
        /*lf.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank())
            {
                if (!boat.checkRiderOnBoat(farmer)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(farmer);
                        lf.setLayoutX(517);
                        lf.setLayoutY(580);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(farmer);
                    lf.setLayoutX(182);
                    lf.setLayoutY(649);
                }
            }
        });
        cab.setOnMouseClicked(e-> {
            if (!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(cabbage)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(cabbage);
                        cab.setLayoutX(360);
                        cab.setLayoutY(685);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(cabbage);
                    cab.setLayoutX(163);
                    cab.setLayoutY(663);
                }
            }
        });
        lg.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(goat)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(goat);
                        lg.setLayoutX(416);
                        lg.setLayoutY(570);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(goat);
                    lg.setLayoutX(53);
                    lg.setLayoutY(505);
                }
            }
        });
        lw.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(wolf)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(wolf);
                        lw.setLayoutX(382);
                        lw.setLayoutY(655);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                } else {
                    boat.removeBoatRiders(wolf);
                    lw.setLayoutX(27);
                    lw.setLayoutY(426);
                }
            }
        });
        */
        //------------
        //FARMER ACTION
        //--SETTING Farmer ACTION SAIL----
        TranslateTransition lfTransition = new TranslateTransition();
        lfTransition.setByX(621);
        lfTransition.setByY(-25);
        lfTransition.setNode(lf);
        lfTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING Cabbage ACTION SAIL----
        TranslateTransition cTransition = new TranslateTransition();
        cTransition.setByX(621);
        cTransition.setByY(-25);
        cTransition.setNode(cab);
        cTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING goat ACTION SAIL----
        TranslateTransition lgTransition = new TranslateTransition();
        lgTransition.setByX(621);
        lgTransition.setByY(-25);
        lgTransition.setNode(lg);
        lgTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING wolf ACTION SAIL----
        TranslateTransition lwTransition = new TranslateTransition();
        lwTransition.setByX(621);
        lwTransition.setByY(-25);
        lwTransition.setNode(lw);
        lwTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING Left Farmer ACTION SAIL----
        TranslateTransition rfTransition = new TranslateTransition();
        rfTransition.setByX(621);
        rfTransition.setByY(-25);
        rfTransition.setNode(rf);
        rfTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING Left Cabbage ACTION SAIL----
        TranslateTransition rcTransition = new TranslateTransition();
        rcTransition.setByX(621);
        rcTransition.setByY(-25);
        rcTransition.setNode(rCab);
        rcTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING left goat ACTION SAIL----
        TranslateTransition rgTransition = new TranslateTransition();
        rgTransition.setByX(621);
        rgTransition.setByY(-25);
        rgTransition.setNode(rg);
        rgTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING left wolf ACTION SAIL----
        TranslateTransition rwTransition = new TranslateTransition();
        rwTransition.setByX(621);
        rwTransition.setByY(-25);
        rwTransition.setNode(rw);
        rwTransition.setDuration(Duration.seconds(4));
        //-----
        //--SETTING ACTION SAIL----
        TranslateTransition sailTransition = new TranslateTransition();
        sailTransition.setByX(621);
        sailTransition.setByY(-25);
        sailTransition.setNode(raftIv);
        sailTransition.setDuration(Duration.seconds(4));
        //SETTING SAIL BACK
        TranslateTransition sailBack = new TranslateTransition();
        sailBack.setByX(-641);
        sailBack.setByY(25);
        sailBack.setNode(raftIv);
        sailBack.setDuration(Duration.seconds(4));
        //-------------
        sailBtn.setOnAction(e->{
            if(gameEngine.canMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank()) && gameEngine.isBoatOnTheLeftBank())
            {
                if(boat.checkRiderOnBoat(farmer))
                    lfTransition.play();
                if(boat.checkRiderOnBoat(cabbage))
                    cTransition.play();
                if(boat.checkRiderOnBoat(goat))
                    lgTransition.play();
                if(boat.checkRiderOnBoat(wolf))
                    lwTransition.play();
                sailTransition.play();
                gameEngine.doMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank());
                boat.removeAllBoatRiders();
            }
            else {
                if (gameEngine.canMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank()) && !gameEngine.isBoatOnTheLeftBank())
                {
                    if (boat.checkRiderOnBoat(farmer))
                        rfTransition.play();
                    if (boat.checkRiderOnBoat(cabbage))
                        rcTransition.play();
                    if (boat.checkRiderOnBoat(goat))
                        rgTransition.play();
                    if (boat.checkRiderOnBoat(wolf))
                        rwTransition.play();
                    sailBack.play();
                    gameEngine.doMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank());
                }
            }
        });
        //------

        Pane pane = new Pane();
        pane.getChildren().addAll(bGIv, raftIv,sailBtn, lf, cab, lg, lw);
        pane.setPrefSize(1269,797);
        scene = new Scene(pane);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}

