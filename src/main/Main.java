package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.HomeMenuScene;

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