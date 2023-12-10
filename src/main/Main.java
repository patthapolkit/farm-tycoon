package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.Player;
import scene.HomeMenuScene;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {

        new HomeMenuScene(primaryStage);
        primaryStage.setTitle("Farm Tycoon");
        primaryStage.show();
//        HBox root = new HBox();
//        root.setPadding(new Insets(10));
//        root.setSpacing(10);
//        root.setPrefHeight(600);
//        root.setPrefWidth(800);
//        root.getChildren().add(new MenuButton("Play"));

//        BarnPane barn = new BarnPane();
//        HomePane home = new HomePane();
//        Scene scene = new Scene(home);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Farm Tycoon");
////        primaryStage.setMaximized(true);
//        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}