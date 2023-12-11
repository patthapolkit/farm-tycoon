package scene;


import component.GameButton;
import component.LuckyFontText;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameInstance;
import resource.ImageLoader;

import java.awt.*;
import java.net.URI;

import static resource.ImageLoader.getImage;


public class HomeMenuScene {

    private Stage stage;
    private static Scene scene;
    private VBox buttonContainer;
    private LuckyFontText title;
    private GameButton playButton;
    private GameButton tutorialButton;
    private GameButton creditButton;
    private static StackPane root;

    public HomeMenuScene(Stage stage) {
        // stage setup
        this.stage = stage;

        // buttonContainer setup
        buttonContainer = new VBox();
        buttonContainer.setSpacing(15);
        buttonContainer.setAlignment(Pos.CENTER);
        setup();

        // root node setup
        root = new StackPane();
        root.setPrefSize(800, 450);
        root.setBackground(new Background(new BackgroundImage(getImage(ImageLoader.BACKGROUND_HOME), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(800, 450, false, false, false, false))));

        // scene & stage setup
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Farm Tycoon");
        stage.setResizable(false);
        root.getChildren().add(buttonContainer);

    }

    private void setup() {
        // create game instance
        GameInstance gameInstance = new GameInstance();

        // title setup
        title = new LuckyFontText("Farm Tycoon", 72);
        title.setFill(Color.rgb(172, 77, 73));

        // buttons setup
        playButton = new GameButton(330, 80, 40, Color.rgb(124, 153, 182));
        playButton.addText("Play", 30, Color.WHITE);
        tutorialButton = new GameButton(330, 80, 40, Color.rgb(124, 153, 182));
        tutorialButton.addText("Tutorial", 30, Color.WHITE);
        creditButton = new GameButton(330, 80, 40, Color.rgb(124, 153, 182));
        creditButton.addText("Credits", 30, Color.WHITE);

        // buttons event handling
        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                root.getChildren().add(new FarmScene(gameInstance));
            }
        });

        tutorialButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.progmeth.ttontoey.com"));
                }
                catch (Exception err){
                    err.printStackTrace();
                }
            }
        });
        creditButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                root.getChildren().add(new CreditScene());
            }
        });

        buttonContainer.getChildren().addAll(title, playButton, tutorialButton, creditButton);

    }

    public static StackPane getRoot() {
        return root;
    }

    public static Scene getScene() {
        return scene;
    }
}
