package RiverCrossing.LevelTwo;

import RiverCrossing.GameEngine;
import RiverCrossing.ICrosser;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameGUI {

    private int boatRidersNum = 0;

    public void game(Stage stage) throws IOException {
        List<ICrosser> leftCrossers = new ArrayList<>();
        List<ICrosser> rightcrossers = new ArrayList<>();
        List<ICrosser> boatRiders = new ArrayList<>();
        List<ICrosser> crossers = new ArrayList<>();

        List<String> index = new ArrayList<String>();

        StrategyTwo strategyTwo = new StrategyTwo();

        GameEngine gameEngine = GameEngine.getGameEngine();
        gameEngine.newGame(strategyTwo);

        leftCrossers = gameEngine.getCrossersOnLeftBank();


        Farmer farmer90kg = (Farmer) leftCrossers.get(0);
        Farmer farmer80kg = (Farmer) leftCrossers.get(1);
        Farmer farmer60kg = (Farmer) leftCrossers.get(2);
        Farmer farmer40kg = (Farmer) leftCrossers.get(3);
        Animal animal = (Animal) leftCrossers.get(4);


        List<ImageView> ivBoatRiders = new ArrayList<>();

        Boat boat = Boat.getInstance();




        stage.setTitle("Story 2");

        //background layout
        Image backgroundImage = new Image("file:src//river_crossing_background.png");
        ImageView ivBackground = new ImageView(backgroundImage);
        ivBackground.setFitHeight(720);
        ivBackground.setFitWidth(1080);

        //boat image layout and start position
        Image boatImage = new Image("file:src//boat.png");
        ImageView ivBoat = new ImageView(boatImage);
        ivBoat.setFitHeight(90);
        ivBoat.setFitWidth(300);
        ivBoat.setX(260);
        ivBoat.setY(650);


        BufferedImage[] farmerImage,animalImage;

        farmerImage = leftCrossers.get(0).getImages();
        animalImage = leftCrossers.get(4).getImages();

        Image f90left,f80left,f60left,f40left;
        Image f90right,f80right,f60right,f40right;
        Image aleft,aright;


        f90left = SwingFXUtils.toFXImage(farmerImage[0],null);
        f90right = SwingFXUtils.toFXImage(farmerImage[1],null);

        f80left = SwingFXUtils.toFXImage(farmerImage[0],null);
        f80right = SwingFXUtils.toFXImage(farmerImage[1],null);

        f60left = SwingFXUtils.toFXImage(farmerImage[0],null);
        f60right = SwingFXUtils.toFXImage(farmerImage[1],null);

        f40left = SwingFXUtils.toFXImage(farmerImage[0],null);
        f40right = SwingFXUtils.toFXImage(farmerImage[1],null);

        aleft = SwingFXUtils.toFXImage(animalImage[0],null);
        aright = SwingFXUtils.toFXImage(animalImage[1],null);

        ImageView ivf90left = new ImageView(f90left);
        ImageView ivf90right = new ImageView(f90right);

        ImageView ivf80left = new ImageView(f80left);
        ImageView ivf80right = new ImageView(f80right);

        ImageView ivf60left = new ImageView(f60left);
        ImageView ivf60right = new ImageView(f60right);

        ImageView ivf40left = new ImageView(f40left);
        ImageView ivf40right = new ImageView(f40right);

        ImageView ivaleft = new ImageView(aleft);
        ImageView ivaright = new ImageView(aright);


        ImageView ivf90leftBoat = new ImageView(f90left);
        ImageView ivf90rightBoat = new ImageView(f90right);

        ImageView ivf80leftBoat = new ImageView(f80left);
        ImageView ivf80rightBoat = new ImageView(f80right);

        ImageView ivf60leftBoat = new ImageView(f60left);
        ImageView ivf60rightBoat = new ImageView(f60right);

        ImageView ivf40leftBoat = new ImageView(f40left);
        ImageView ivf40rightBoat = new ImageView(f40right);

        ImageView ivaleftBoat = new ImageView(aleft);
        ImageView ivarightBoat = new ImageView(aright);

        TranslateTransition transition = new TranslateTransition();

        ivaleftBoat.setVisible(false);
        ivarightBoat.setVisible(false);
        ivf90rightBoat.setVisible(false);
        ivf90leftBoat.setVisible(false);
        ivf80rightBoat.setVisible(false);
        ivf80leftBoat.setVisible(false);
        ivf60rightBoat.setVisible(false);
        ivf60leftBoat.setVisible(false);
        ivf40rightBoat.setVisible(false);
        ivf40leftBoat.setVisible(false);


        ivf90right.setVisible(false);
        ivf80right.setVisible(false);
        ivf60right.setVisible(false);
        ivf40right.setVisible(false);
        ivaright.setVisible(false);

        //---------------------------------//
        //ImageView of left farmers

        //90kg farmer
        ivf90left.setFitHeight(190);
        ivf90left.setFitWidth(95);

        ivf90left.setX(300);
        ivf90left.setY(300);

        if (boat.getSide()) {
            ivf90left.setOnMousePressed(e-> {
                double weight = farmer90kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                System.out.println(boatRiders.size());
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf90left.setVisible(false);
                    ivf90leftBoat.setVisible(true);
                    boatRiders.add(farmer90kg);
                    crossers.add(farmer90kg);
                    index.add("90");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf90leftBoat);
                }
            });
        }



        //80kg farmer left
        ivf80left.setFitHeight(160);
        ivf80left.setFitWidth(80);

        ivf80left.setX(220);
        ivf80left.setY(220);

        if (boat.getSide()) {
            ivf80left.setOnMousePressed(e-> {
                double weight = farmer80kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                System.out.println(weight);
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf80left.setVisible(false);
                    ivf80leftBoat.setVisible(true);
                    boatRiders.add(farmer80kg);
                    crossers.add(farmer80kg);
                    index.add("80");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf80leftBoat);
                }
            });
        }


        //60kg farmer left
        ivf60left.setFitHeight(150);
        ivf60left.setFitWidth(75);

        ivf60left.setX(120);
        ivf60left.setY(400);

        if (boat.getSide()) {
            ivf60left.setOnMousePressed(e-> {
                double weight = farmer60kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf60left.setVisible(false);
                    ivf60leftBoat.setVisible(true);
                    boatRiders.add(farmer60kg);
                    crossers.add(farmer60kg);
                    index.add("60");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf60leftBoat);
                }
            });
        }


        //40kg farmer left
        ivf40left.setFitHeight(100);
        ivf40left.setFitWidth(50);

        ivf40left.setX(150);
        ivf40left.setY(200);

        if (boat.getSide()) {
            System.out.println(boat.getSide());
            ivf40left.setOnMousePressed(e-> {
                double weight = farmer40kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) {
                    System.out.println(boatRiders.get(i).getWeight());
                    weight += boatRiders.get(i).getWeight();
                }
                System.out.println(weight);
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf40left.setVisible(false);
                    ivf40leftBoat.setVisible(true);
                    boatRiders.add(farmer40kg);
                    crossers.add(farmer40kg);
                    index.add("40");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf40leftBoat);
                }
            });
        }

        //animal left
        ivaleft.setFitHeight(80);
        ivaleft.setFitWidth(80);

        ivaleft.setX(50);
        ivaleft.setY(300);

        if (boat.getSide()) {
            ivaleft.setOnMousePressed(e-> {
                System.out.println("boat position for the cat: " + boat.getSide());
                double weight = animal.getWeight();
                System.out.println("animal weight: " + weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                System.out.println(weight);
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivaleft.setVisible(false);
                    ivaleftBoat.setVisible(true);
                    boatRiders.add(animal);
                    crossers.add(animal);
                    index.add("20");
                    System.out.println(crossers.size());
                    System.out.println(weight);
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivaleftBoat);
                }
            });
        }



        //---------------------------------//
        //ImageView of right Farmers


        //90kg farmer right
        ivf90right.setFitHeight(190);
        ivf90right.setFitWidth(95);

        ivf90right.setX(950);
        ivf90right.setY(300);

        if (boat.getSide()) {
            ivf90right.setOnMouseClicked(e-> {
                double weight = farmer90kg.getWeight();
                System.out.println("weight fo right 90kg farmer on clicked: " + weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                System.out.println("weight of boat on right side: " + weight);
                System.out.println(boat.getSide());
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf90right.setVisible(false);
                    ivf90rightBoat.setVisible(true);
                    boatRiders.add(farmer90kg);
                    crossers.add(farmer90kg);
                    index.add("90");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf90rightBoat);
                }
            });
        }




        //80kg farmer right
        ivf80right.setFitHeight(160);
        ivf80right.setFitWidth(80);

        ivf80right.setX(870);
        ivf80right.setY(220);

        if (boat.getSide()) {
            ivf80right.setOnMousePressed(e-> {
                double weight = farmer80kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf80right.setVisible(false);
                    ivf80rightBoat.setVisible(true);
                    boatRiders.add(farmer80kg);
                    crossers.add(farmer80kg);
                    index.add("80");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf80rightBoat);
                }
            });
        }





        //60kg farmer right
        ivf60right.setFitHeight(150);
        ivf60right.setFitWidth(75);

        ivf60right.setX(770);
        ivf60right.setY(400);

        if (!boat.getSide()) {
            ivf60right.setOnMousePressed(e-> {
                double weight = farmer60kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf60right.setVisible(false);
                    ivf60rightBoat.setVisible(true);
                    boatRiders.add(farmer60kg);
                    crossers.add(farmer60kg);
                    index.add("60");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf60rightBoat);
                }
            });
        }





        //40kg farmer right
        ivf40right.setFitHeight(100);
        ivf40right.setFitWidth(50);

        ivf40right.setX(800);
        ivf40right.setY(200);

        if (!boat.getSide()) {
            ivf40right.setOnMousePressed(e-> {
                double weight = farmer40kg.getWeight();
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivf40right.setVisible(false);
                    ivf40rightBoat.setVisible(true);
                    boatRiders.add(farmer40kg);
                    crossers.add(farmer40kg);
                    index.add("40");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivf40rightBoat);
                }
            });
        }




        //animal right
        ivaright.setFitHeight(80);
        ivaright.setFitWidth(80);

        ivaright.setX(800);
        ivaright.setY(300);

        if (!boat.getSide()) {
            ivaright.setOnMousePressed(e-> {
                double weight = animal.getWeight();
                System.out.println(boat.getSide());
                System.out.println(weight);
                for (int i = 0; i < boatRiders.size(); i++) weight += boatRiders.get(i).getWeight();
                if (boatRiders.size() < 2 && weight <= 100) {
                    ivaright.setVisible(false);
                    ivarightBoat.setVisible(true);
                    boatRiders.add(animal);
                    crossers.add(animal);
                    index.add("20");
                    System.out.println(crossers.size());
                    //leftCrossers.remove(farmer90kg);
                    ivBoatRiders.add(ivarightBoat);
                }
            });
        }




        //-------------------------------------------//
        //  ImageView of left boat farmers

        ivf90leftBoat.setFitHeight(190);
        ivf90leftBoat.setFitWidth(95);

        ivf90leftBoat.setX(250);
        ivf90leftBoat.setY(500);

        if (boat.getSide()) {
            ivf90leftBoat.setOnMousePressed(e-> {
                ivf90leftBoat.setVisible(false);
                ivf90left.setVisible(true);
                index.remove("90");
                crossers.remove(farmer90kg);
                boatRiders.remove(farmer90kg);
                ivBoatRiders.remove(ivf90leftBoat);
                System.out.println(crossers.size());
            });
        }



        ivf80leftBoat.setFitHeight(160);
        ivf80leftBoat.setFitWidth(80);

        ivf80leftBoat.setX(330);
        ivf80leftBoat.setY(540);

        if (boat.getSide()) {
            ivf80leftBoat.setOnMousePressed(e-> {
                ivf80leftBoat.setVisible(false);
                ivf80left.setVisible(true);
                index.remove("80");
                crossers.remove(farmer80kg);
                boatRiders.remove(farmer80kg);
                ivBoatRiders.remove(ivf80leftBoat);
                System.out.println(crossers.size());
            });
        }



        ivf60leftBoat.setFitHeight(150);
        ivf60leftBoat.setFitWidth(75);

        ivf60leftBoat.setX(400);
        ivf60leftBoat.setY(550);

        if (boat.getSide()) {
            ivf60leftBoat.setOnMousePressed(e-> {
                ivf60leftBoat.setVisible(false);
                ivf60left.setVisible(true);
                index.remove("60");
                crossers.remove(farmer60kg);
                boatRiders.remove(farmer60kg);
                ivBoatRiders.remove(ivf60leftBoat);
                System.out.println(crossers.size());
            });
        }





        ivf40leftBoat.setFitHeight(100);
        ivf40leftBoat.setFitWidth(50);

        ivf40leftBoat.setX(460);
        ivf40leftBoat.setY(590);

        if (boat.getSide()) {
            ivf40leftBoat.setOnMousePressed(e-> {
                ivf40leftBoat.setVisible(false);
                ivf40left.setVisible(true);
                index.remove("40");
                crossers.remove(farmer40kg);
                boatRiders.remove(farmer40kg);
                ivBoatRiders.remove(ivf40leftBoat);
                System.out.println(crossers.size());
            });
        }



        ivaleftBoat.setFitHeight(80);
        ivaleftBoat.setFitWidth(80);

        ivaleftBoat.setX(500);
        ivaleftBoat.setY(610);

        if (boat.getSide()) {
            ivaleftBoat.setOnMousePressed(e-> {
                ivaleftBoat.setVisible(false);
                ivaleft.setVisible(true);
                index.remove("20");
                crossers.remove(animal);
                boatRiders.remove(animal);
                ivBoatRiders.remove(ivaleftBoat);
                System.out.println(crossers.size());
            });
        } else {
            System.out.println("error");
        }




        //-------------------------------------------//
        //  ImageView of right boat farmers

        ivf90rightBoat.setFitHeight(190);
        ivf90rightBoat.setFitWidth(95);

        ivf90rightBoat.setX(500);
        ivf90rightBoat.setY(500);


        ivf80rightBoat.setFitHeight(160);
        ivf80rightBoat.setFitWidth(80);

        ivf80rightBoat.setX(580);
        ivf80rightBoat.setY(540);


        ivf60rightBoat.setFitHeight(150);
        ivf60rightBoat.setFitWidth(75);

        ivf60rightBoat.setX(900);
        ivf60rightBoat.setY(550);


        ivf40rightBoat.setFitHeight(100);
        ivf40rightBoat.setFitWidth(50);

        ivf40rightBoat.setX(960);
        ivf40rightBoat.setY(590);


        ivarightBoat.setFitHeight(80);
        ivarightBoat.setFitWidth(80);

        ivarightBoat.setX(1000);
        ivarightBoat.setY(610);

        //-------------------------------------------//


        //button <<Sail>>
        Button sailButton = new Button();
        sailButton.setText("sail");
        sailButton.setOnAction(e-> {
            boolean side = boat.getSide();
            if (gameEngine.canMove(crossers,side)) {
                gameEngine.doMove(crossers,side);
                boat.changeSide();
                System.out.println(boat.getSide());
                moveBoat(ivBoat,side,ivBoatRiders,transition);
                for (int i = 0; i < crossers.size(); i++) crossers.remove(i);
                boat.changeSide();
            }

            System.out.println("boat now on " + boat.getSide());
            for (int i = 0; i < crossers.size(); i++) crossers.remove(i);
            boatRiders.clear();

            if (ivBoatRiders.size() == 2) {
                if (side) {
                    if ("90".equals(index.get(0))) ivf90right.setVisible(true);
                    else if ("80".equals(index.get(0))) ivf80right.setVisible(true);
                    else if ("60".equals(index.get(0))) ivf60right.setVisible(true);
                    else if ("40".equals(index.get(0))) ivf40right.setVisible(true);
                    else if ("20".equals(index.get(0))) {
                        ivaright.setVisible(true);
                        System.out.printf("iam here animal yeeeee");
                    }

                    if ("90".equals(index.get(1))) ivf90right.setVisible(true);
                    else if ("80".equals(index.get(1))) ivf80right.setVisible(true);
                    else if ("60".equals(index.get(1))) ivf60right.setVisible(true);
                    else if ("40".equals(index.get(1))) ivf40right.setVisible(true);
                    else if ("20".equals(index.get(1))) ivaright.setVisible(true);
                }

            } else if (ivBoatRiders.size() == 1) {
                if ("90".equals(index.get(0))) ivf90right.setVisible(true);
                else if ("80".equals(index.get(0))) ivf80right.setVisible(true);
                else if ("60".equals(index.get(0))) ivf60right.setVisible(true);
                else if ("40".equals(index.get(0))) ivf40right.setVisible(true);
                else if ("20".equals(index.get(0))) ivaright.setVisible(true);
                    //TODO error is here
                index.clear();
            }

            ivBoatRiders.clear();


        });




        //story 2 scene layout.
        Pane root = new Pane();
        root.getChildren().addAll(ivBackground,ivBoat,sailButton,ivf90left,ivf80left,ivf40left,ivf60left,ivaleft,ivf90right,ivf80right,ivf60right,ivf40right,ivf90leftBoat,ivf90rightBoat,ivf80leftBoat,ivf80rightBoat,ivf60leftBoat,ivf60rightBoat,ivf40leftBoat,ivf40rightBoat,ivaright,ivaleftBoat,ivarightBoat);
        Scene scene = new Scene(root,1080,720);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }

    public void moveBoat(ImageView ivBoat,boolean side,List<ImageView> ivBoatRiders,TranslateTransition transition) {
        TranslateTransition transition1 = new TranslateTransition();
        TranslateTransition transition2 = new TranslateTransition();

        System.out.println(ivBoat.getX());
        System.out.println(side);
        if (side == true) {
            transition.setToY(0);
            transition.setToX(250);

        } else {
            transition.setToY(0);
            transition.setToX(0);

        }

        if (ivBoatRiders.size() == 1) {
            if (side == true) {
                transition1.setToY(0);
                transition1.setToX(250);

            } else {
                transition1.setToY(0);
                transition1.setToX(0);

            }
        } else if (ivBoatRiders.size() == 2) {
            if (side == true) {
                transition1.setToX(250);
                transition1.setToY(0);

                transition2.setToX(250);
                transition2.setToY(0);

            } else {
                transition1.setToY(0);
                transition1.setToX(0);

                transition2.setToY(0);
                transition2.setToX(0);

            }
        }

        transition.setAutoReverse(true);
        transition.setDuration(Duration.seconds(3.5));
        transition1.setDuration(Duration.seconds(3.5));
        transition2.setDuration(Duration.seconds(3.5));


        if (ivBoatRiders.size() == 1)  {
            transition1.setNode(ivBoatRiders.get(0));
            transition1.play();
        }
        else if (ivBoatRiders.size() == 2) {
            transition1.setNode(ivBoatRiders.get(0));
            transition2.setNode(ivBoatRiders.get(1));
            transition1.play();
            transition2.play();
        }


        transition.setNode(ivBoat);
        transition.play();




        transition.setOnFinished(t-> {
            System.out.println("before removing the elements "+ivBoatRiders.size());
            if (ivBoatRiders.size() == 2) {

                ivBoatRiders.get(0).setVisible(false);
                ivBoatRiders.get(1).setVisible(false);


            } else {
                ivBoatRiders.get(0).setVisible(false);
            }
            ivBoatRiders.clear();
            System.out.println("after removing the elements: " + ivBoatRiders.size());
        });




    }
}


















