package main;

import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.HomeMenuScene;

import java.awt.*;
import java.net.URI;

public class Main extends Application {

    public void start(Stage primaryStage) {

        new HomeMenuScene(primaryStage);
        primaryStage.setTitle("Farm Tycoon");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}