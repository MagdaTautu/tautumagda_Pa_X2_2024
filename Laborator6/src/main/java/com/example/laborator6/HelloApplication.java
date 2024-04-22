package com.example.laborator6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override

    public void start(Stage primaryStage) {

        PositionalGameGUI gameGUI = new PositionalGameGUI();


        Scene scene = new Scene(gameGUI.getRoot(), 600, 600);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Positional Game");
        primaryStage.show();

        gameGUI.drawRandomSticks();
    }

    public static void main(String[] args) {
        launch(args);
    }
}