package RiverCrossing;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
    public static void display(String title, String message) {
        Stage errorAlert = new Stage();


        errorAlert.initModality(Modality.APPLICATION_MODAL);
        errorAlert.setTitle(title);
        errorAlert.setMinWidth(500);

        Label error = new Label();
        error.setText(message);
        Button closeButton = new Button("CLOSE");
        closeButton.setOnAction(e -> errorAlert.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(error, closeButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout);
        errorAlert.setScene(scene);
        errorAlert.showAndWait();
    }
    }

