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

public class TempFarmScene extends StackPane {

    private GameButton barnButton;
    private GameButton plotButton;
    private GameButton cageButton;

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
        barnButton = new GameButton(330,80,40,Color.rgb(124,153,182));
        barnButton.addText("Barn",30,Color.WHITE);
        plotButton = new GameButton(330,80,40,Color.rgb(124,153,182));
        plotButton.addText("Plot",30,Color.WHITE);
        cageButton = new GameButton(330,80,40,Color.rgb(124,153,182));
        cageButton.addText("Factory",30,Color.WHITE);
        // buttons event handler
        barnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new BarnScene());
            }
        });

        plotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new PlotScene());
            }
        });
        cageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                HomeMenuScene.getRoot().getChildren().add(new FactoryScene());
            }
        });

        // buttonContainer setup
        buttonContainer = new VBox();
        buttonContainer.setPadding(new Insets(20,0,0,0));
        buttonContainer.setSpacing(20);
        buttonContainer.getChildren().addAll(barnButton,plotButton,cageButton);

        // container setup
        container.getChildren().add(buttonContainer);
        getChildren().add(container);

    }
}


