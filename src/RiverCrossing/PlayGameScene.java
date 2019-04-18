package RiverCrossing;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayGameScene {

    private Scene scene;

    public PlayGameScene(Stage stage, Scene menuScene) {

        // SETTING BACKGROUND IMAGE
        Image backGroundImage = new Image("file:background.jpg");
        ImageView bGIv = new ImageView(backGroundImage);
        bGIv.setPreserveRatio(false);
        bGIv.setFitWidth(1100);
        bGIv.setFitHeight(600);
        bGIv.setFocusTraversable(false);
        //---------------------------
        // SETTING BACKGROUND IMAGE
        Image raftImage = new Image("file:raft-7.png");
        ImageView raftIv = new ImageView(raftImage);
        raftIv.setPreserveRatio(false);
        raftIv.setFitWidth(166);
        raftIv.setFitHeight(92);
        raftIv.setLayoutX(293);
        raftIv.setLayoutY(500);
        raftIv.setFocusTraversable(false);
        Blend blend = new Blend();
        raftIv.setEffect(blend);

        Button sailBtn = new Button("SAIL");
        sailBtn.setLayoutX(490);
        sailBtn.setLayoutY(109);
        sailBtn.setPrefWidth(120);
        sailBtn.setPrefHeight(31);
        Button sailBackBtn = new Button("SAIL Back");
        sailBackBtn.setLayoutX(490);
        sailBackBtn.setLayoutY(140);
        sailBackBtn.setPrefWidth(120);
        //--SETTING ACTION SAIL----
        //--------TRYING CROSSER MOVEMENT----------------
        Path path = new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new LineTo(650,5));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
        pathTransition.setNode(raftIv);
        pathTransition.setDuration(Duration.seconds(3));
        sailBtn.setOnAction(e->{
            pathTransition.play();
        });
        //---------------------------
        sailBackBtn.setOnAction(e->{
            path.getElements().add(new ClosePath());
        });
        //----------------

        Pane pane = new Pane();
        pane.getChildren().addAll(bGIv, raftIv,sailBtn,sailBackBtn);
        pane.setPrefSize(1100,600);
        scene = new Scene(pane);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}

