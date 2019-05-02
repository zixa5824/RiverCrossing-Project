package RiverCrossing;
import LevelOne.Boat;
import LevelOne.StrategyOne;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PlayGameScene {

    AnimationTimer time;
    double velocityX;
    double velocityY;
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
        Rectangle rectangle = new Rectangle(326,138);
        rectangle.setLayoutX(32);
        rectangle.setLayoutY(31);
        rectangle.setOpacity(0.43);
        rectangle.setFill(Color.web("dce9f5"));

        GameEngine gameEngine = GameEngine.getGameEngine();

        Button instructions = new Button("Instructions");
        instructions.setLayoutX(575);
        instructions.setLayoutY(31);
        instructions.setOnAction(e->{
            AlertBox.display("Instructions",gameEngine.getInstructions()[0]);
        });

        Label label = new Label("Number of Moves");
        label.setLayoutX(32);
        label.setLayoutY(148);
        label.setText("Number of Moves: " + gameEngine.getNumberOfSails());

        Button resetBtn = new Button("Reset");
        resetBtn.setLayoutX(134);
        resetBtn.setLayoutY(71);
        resetBtn.setPrefWidth(123);
        resetBtn.setPrefHeight(31);
        resetBtn.setOnAction(e->{
            gameEngine.resetGame();
        });
        //Game ENGINE
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
        //SUBSTITUTE IMAGES
        ImageView slf, srf, scab, srCab, slg, srg, slw, srw;
        slf = new ImageView(leftFarmer);
        srf = new ImageView(rightFarmer);
        scab = new ImageView(cabbage1);
        srCab = new ImageView(cabbage2);
        slg = new ImageView(leftGoat);
        srg = new ImageView(rightGoat);
        slw = new ImageView(leftWolf);
        srw = new ImageView(rightWolf);
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
        //SUBSTITUTE IMAGES SETTING

        //FARMER
        slf.setFitWidth(200);
        slf.setFitHeight(150);
        slf.setLayoutX(517);
        slf.setLayoutY(580);
        slf.setPreserveRatio(false);
        //-------
        //Cabbage
        scab.setLayoutX(360);
        scab.setLayoutY(685);
        scab.setFitHeight(55);
        scab.setFitWidth(45);
        //--------
        //Goat
        slg.setLayoutX(416);
        slg.setLayoutY(570);
        slg.setFitHeight(150);
        slg.setFitWidth(158);
        //--------
        //Wolf
        slw.setLayoutX(382);
        slw.setLayoutY(655);
        slw.setFitHeight(99);
        slw.setFitWidth(158);
        //--------

        //right FARMER
        srf.setFitWidth(200);
        srf.setFitHeight(150);
        srf.setLayoutX(1036);
        srf.setLayoutY(521);
        srf.setPreserveRatio(false);
        //-------
        //right Cabbage
        srCab.setLayoutX(1045);
        srCab.setLayoutY(708);
        srCab.setFitHeight(55);
        srCab.setFitWidth(45);
        //--------
        //right Goat
        srg.setLayoutX(953);
        srg.setLayoutY(569);
        srg.setFitHeight(150);
        srg.setFitWidth(158);
        //--------
        //right Wolf
        srw.setLayoutX(1090);
        srw.setLayoutY(614);
        srw.setFitHeight(99);
        srw.setFitWidth(158);
        //--------
        slf.setVisible(false);
        scab.setVisible(false);
        slg.setVisible(false);
        slw.setVisible(false);
        srf.setVisible(false);
        srCab.setVisible(false);
        srg.setVisible(false);
        srw.setVisible(false);
        rf.setVisible(false);
        rCab.setVisible(false);
        rg.setVisible(false);
        rw.setVisible(false);
        //CHOOSE LEFT BANK RIDERS
        lf.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank())
            {
                if (!boat.checkRiderOnBoat(farmer)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(farmer);
                        lf.setVisible(false);
                        slf.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        slf.setOnMouseClicked(e->{
            boat.removeBoatRiders(farmer);
            lf.setVisible(true);
            slf.setVisible(false);
        });
        cab.setOnMouseClicked(e-> {
            if (gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(cabbage)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(cabbage);
                        cab.setVisible(false);
                        scab.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        scab.setOnMouseClicked(e->{
            boat.removeBoatRiders(cabbage);
            cab.setVisible(true);
            scab.setVisible(false);
        });
        lg.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(goat)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(goat);
                        lg.setVisible(false);
                        slg.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        slg.setOnMouseClicked(e->{
            boat.removeBoatRiders(goat);
            lg.setVisible(true);
            slg.setVisible(false);
        });
        lw.setOnMouseClicked(e->{
            if(gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(wolf)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(wolf);
                        lw.setVisible(false);
                        slw.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        slw.setOnMouseClicked(e->{
            boat.removeBoatRiders(wolf);
            lw.setVisible(true);
            slw.setVisible(false);
        });
        //-------------
        //CHOOSE RIGHT BANK FARMER
        rf.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank())
            {
                if (!boat.checkRiderOnBoat(farmer)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(farmer);
                        rf.setVisible(false);
                        srf.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        srf.setOnMouseClicked(e->{
            boat.removeBoatRiders(farmer);
            rf.setVisible(true);
            srf.setVisible(false);
        });
        rCab.setOnMouseClicked(e-> {
            if (!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(cabbage)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(cabbage);
                        rCab.setVisible(false);
                        srCab.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        srCab.setOnMouseClicked(e->{
            boat.removeBoatRiders(cabbage);
            rCab.setVisible(true);
            srCab.setVisible(false);
        });
        rg.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(goat)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(goat);
                        rg.setVisible(false);
                        srg.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        srg.setOnMouseClicked(e->{
            boat.removeBoatRiders(goat);
            rg.setVisible(true);
            srg.setVisible(false);
        });
        rw.setOnMouseClicked(e->{
            if(!gameEngine.isBoatOnTheLeftBank()) {
                if (!boat.checkRiderOnBoat(wolf)) {
                    if (!boat.isBoatFull()) {
                        boat.addBoatRiders(wolf);
                        rw.setVisible(false);
                        srw.setVisible(true);
                    } else {
                        AlertBox.display("Boat Size Exceeded", "You can't place more than two riders on the boat");
                    }
                }
            }
        });
        srw.setOnMouseClicked(e->{
            boat.removeBoatRiders(wolf);
            lw.setVisible(true);
            slw.setVisible(false);
        });
        //------------
        time = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(raftIv.getLayoutX() > 964 && velocityX > 0)
                {
                    for (int i = 0; i < boat.getBoatRiders().size() ; i++)
                    {
                        String cmp = boat.getBoatRiders().get(i).getLabelToBeShown();
                        if (cmp.equalsIgnoreCase(farmer.getLabelToBeShown())) {
                            rf.setVisible(true);
                            slf.setVisible(false);
                            slf.setLayoutX(517);
                            slf.setLayoutY(580);
                        }
                        else if (cmp.equalsIgnoreCase(cabbage.getLabelToBeShown())) {
                            rCab.setVisible(true);
                            scab.setVisible(false);
                            scab.setLayoutX(360);
                            scab.setLayoutY(685);
                        }
                        else if (cmp.equalsIgnoreCase(goat.getLabelToBeShown())) {
                            rg.setVisible(true);
                            slg.setVisible(false);
                            slg.setLayoutX(416);
                            slg.setLayoutY(570);
                        }
                        else if (cmp.equalsIgnoreCase(wolf.getLabelToBeShown())) {
                            rw.setVisible(true);
                            slw.setVisible(false);
                            slw.setLayoutX(382);
                            slw.setLayoutY(655);
                        }
                    }
                    boat.removeAllBoatRiders();
                    time.stop();
                }
                else if(velocityX < 0 && raftIv.getLayoutX() < 321){

                    for (int i = 0; i < boat.getBoatRiders().size() ; i++)
                    {
                        String cmp = boat.getBoatRiders().get(i).getLabelToBeShown();
                        if (cmp.equalsIgnoreCase(farmer.getLabelToBeShown())) {
                            lf.setVisible(true);
                            srf.setVisible(false);
                            srf.setLayoutX(1036);
                            srf.setLayoutY(521);
                        }
                        else if (cmp.equalsIgnoreCase(cabbage.getLabelToBeShown())) {
                            cab.setVisible(true);
                            srCab.setVisible(false);
                            srCab.setLayoutX(1045);
                            srCab.setLayoutY(708);
                        }
                        else if (cmp.equalsIgnoreCase(goat.getLabelToBeShown())) {
                            lg.setVisible(true);
                            srg.setVisible(false);
                            srg.setLayoutX(953);
                            srg.setLayoutY(569);
                        }
                        else if (cmp.equalsIgnoreCase(wolf.getLabelToBeShown())) {
                            lw.setVisible(true);
                            srw.setVisible(false);
                            srw.setLayoutX(1090);
                            srw.setLayoutY(614);
                        }
                    }
                        boat.removeAllBoatRiders();
                        time.stop();
                }

                raftIv.setLayoutX(raftIv.getLayoutX() + velocityX);
                raftIv.setLayoutY(raftIv.getLayoutY() - velocityY);
                if(velocityX > 0)
                {
                    for (int i = 0; i < boat.getBoatRiders().size() ; i++) {
                        String cmp = boat.getBoatRiders().get(i).getLabelToBeShown();
                        if (cmp.equalsIgnoreCase(farmer.getLabelToBeShown())) {
                            slf.setLayoutX(slf.getLayoutX() + velocityX);
                            slf.setLayoutY(slf.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(cabbage.getLabelToBeShown())) {
                            scab.setLayoutX(scab.getLayoutX() + velocityX);
                            scab.setLayoutY(scab.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(goat.getLabelToBeShown())) {
                            slg.setLayoutX(slg.getLayoutX() + velocityX);
                            slg.setLayoutY(slg.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(wolf.getLabelToBeShown())) {
                            slw.setLayoutX(slw.getLayoutX() + velocityX);
                            slw.setLayoutY(slw.getLayoutY() - velocityY);
                        }
                    }
                    System.out.println(boat.getBoatRiders().size());
                }
                else if (velocityX < 0)
                {
                    for (int i = 0; i < boat.getBoatRiders().size() ; i++)
                    {
                        String cmp = boat.getBoatRiders().get(i).getLabelToBeShown();
                        if (cmp.equalsIgnoreCase(farmer.getLabelToBeShown())) {
                            srf.setLayoutX(srf.getLayoutX() + velocityX);
                            srf.setLayoutY(srf.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(cabbage.getLabelToBeShown())) {
                            srCab.setLayoutX(srCab.getLayoutX() + velocityX);
                            srCab.setLayoutY(srCab.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(goat.getLabelToBeShown())) {
                            srg.setLayoutX(srg.getLayoutX() + velocityX);
                            srg.setLayoutY(srg.getLayoutY() - velocityY);
                        }
                        else if (cmp.equalsIgnoreCase(wolf.getLabelToBeShown())) {
                            srw.setLayoutX(srw.getLayoutX() + velocityX);
                            srw.setLayoutY(srw.getLayoutY() - velocityY);
                        }
                    }
                }

            }
        };

        sailBtn.setOnAction(e->{
            if(gameEngine.canMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank()) && gameEngine.isBoatOnTheLeftBank())
            {
                velocityX = 4;
                velocityY = 0.125;
                time.start();
                gameEngine.doMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank());
                label.setText("Number of Moves: " + gameEngine.getNumberOfSails());
            }
            else {
                if (gameEngine.canMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank()) && !gameEngine.isBoatOnTheLeftBank())
                {
                    velocityX = -4;
                    velocityY = -0.125;
                    time.start();
                    gameEngine.doMove(boat.getBoatRiders(), gameEngine.isBoatOnTheLeftBank());
                    label.setText("Number of Moves: " + gameEngine.getNumberOfSails());
                }
            }
        });

        //------
        Pane pane = new Pane();
        pane.getChildren().addAll(bGIv, raftIv,sailBtn, lf, cab, lg, lw, rf, rCab, rg, rw, slf, scab, slg, slw, srf, srCab, srg, srw, rectangle, instructions, label, resetBtn);
        pane.setPrefSize(1269,797);
        /*Pane pane = new Pane();
        pane.getChildren().addAll(bGIv, raftIv,sailBtn, lf, cab, lg, lw, rf, rCab, rg, rw);
        pane.setPrefSize(1269,797);
        */
        scene = new Scene(pane);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}

