package scene;


import component.GameButton;
import component.NavMenu;
import component.OrbitFontText;
import entity.material.*;
import entity.product.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.ItemCounter;
import java.util.ArrayList;

public class TempFarmScene extends StackPane {

    private GameButton barnButton;
    private GameButton plotButton;
    private GameButton factButton;

    private GameButton shopButton;

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VBox buttonContainer;

    private StackPane topContainer;


    public TempFarmScene() {

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

        // buttonContainer setup
        buttonContainer = new VBox();
        buttonContainer.setPadding(new Insets(20,0,0,0));
        buttonContainer.setSpacing(5);
        buttonContainer.getChildren().addAll(barnButton,plotButton,factButton,shopButton);

        // container setup
        container.getChildren().add(buttonContainer);
        getChildren().add(container);

    }

    public void barnButtonSetup(){

        barnButton = new GameButton(200,50,40,Color.rgb(124,153,182));
        barnButton.addText("Barn",30,Color.WHITE);
        barnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {

                // EDIT HERE
                ArrayList<ItemCounter> playerInventory = new ArrayList<ItemCounter>();

                // Sample Inventory
                playerInventory.add(new ItemCounter(new Wheat(),10));
                playerInventory.add(new ItemCounter(new Carrot(),10));
                playerInventory.add(new ItemCounter(new Beetroot(),53));
                playerInventory.add(new ItemCounter(new Milk(),79));
                playerInventory.add(new ItemCounter(new Egg(),3));
                playerInventory.add(new ItemCounter(new Berry(),1));
                playerInventory.add(new ItemCounter(new Cake(),1));
                playerInventory.add(new ItemCounter(new Wool(),1));
                playerInventory.add(new ItemCounter(new PumpkinPie(),13));
                playerInventory.add(new ItemCounter(new Sweater(),1));
                playerInventory.add(new ItemCounter(new CarrotPie(),12));
                playerInventory.add(new ItemCounter(new Bread(),133));

                HomeMenuScene.getRoot().getChildren().add(new BarnScene(playerInventory));
            }
        });
    }

    public void plotButtonSetup(){
        plotButton = new GameButton(200,50,40,Color.rgb(124,153,182));
        plotButton.addText("Plot",30,Color.WHITE);
        plotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new PlotScene());
            }
        });
    }

    public void factButtonSetup(){
        factButton = new GameButton(200,50,40,Color.rgb(124,153,182));
        factButton.addText("Factory",30,Color.WHITE);
        factButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new FactoryScene());
            }
        });
    }

    public void shopButtonSetup(){
        shopButton = new GameButton(200,50,40,Color.rgb(124,153,182));
        shopButton.addText("Shop",30,Color.WHITE);
        shopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new ShopScene());
            }
        });
    }
}


