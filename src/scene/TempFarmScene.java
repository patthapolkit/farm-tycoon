package scene;


import component.GameButton;
import component.NavMenu;
import component.OrbitFontText;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameInstance;
import logic.ItemCounter;

import java.util.ArrayList;

public class TempFarmScene extends StackPane {

    private GameInstance gameInstance;

    private GameButton barnButton;
    private GameButton plotButton;
    private GameButton factButton;
    private GameButton shopButton;
    private GameButton martButton;

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VBox buttonContainer;

    private StackPane topContainer;


    public TempFarmScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(242, 233, 217), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Temp Farm Scene", 48);
        title.setFill(Color.rgb(86, 76, 54));
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer);

        // buttons setup
        barnButtonSetup();
        plotButtonSetup();
        factButtonSetup();
        shopButtonSetup();
        martButtonSetup();


        // buttonContainer setup
        buttonContainer = new VBox();
        buttonContainer.setPadding(new Insets(20, 0, 0, 0));
        buttonContainer.setSpacing(5);
        buttonContainer.getChildren().addAll(barnButton, plotButton, factButton, shopButton, martButton);

        // container setup
        container.getChildren().add(buttonContainer);
        getChildren().add(container);

    }

    public void barnButtonSetup() {

        barnButton = new GameButton(200, 50, 40, Color.rgb(124, 153, 182));
        barnButton.addText("Barn", 30, Color.WHITE);
        barnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                ArrayList<ItemCounter> playerInventory = gameInstance.getPlayer().getInventory();
                HomeMenuScene.getRoot().getChildren().add(new BarnScene(playerInventory));
            }
        });
    }

    public void plotButtonSetup() {
        plotButton = new GameButton(200, 50, 40, Color.rgb(124, 153, 182));
        plotButton.addText("Plot", 30, Color.WHITE);
        plotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new PlotScene(gameInstance));
            }
        });
    }

    public void factButtonSetup() {
        factButton = new GameButton(200, 50, 40, Color.rgb(124, 153, 182));
        factButton.addText("Factory", 30, Color.WHITE);
        factButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new FactoryScene(gameInstance));
            }
        });
    }

    public void shopButtonSetup() {
        shopButton = new GameButton(200, 50, 40, Color.rgb(124, 153, 182));
        shopButton.addText("Shop", 30, Color.WHITE);
        shopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new ShopScene(gameInstance));
            }
        });
    }

    public void martButtonSetup() {
        martButton = new GameButton(200, 50, 40, Color.rgb(124, 153, 182));
        martButton.addText("Mart", 30, Color.WHITE);
        martButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new MinimartScene(gameInstance));
            }
        });
    }
}


