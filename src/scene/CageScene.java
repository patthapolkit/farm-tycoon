package scene;

import component.*;
import entity.animal.*;
import entity.material.Wheat;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.GameInstance;
import logic.ItemCounter;

import java.util.ArrayList;

public class CageScene extends StackPane {
    private final GameInstance gameInstance;

    private final VBox container;

    private final OrbitFontText title;

    private final VBox titleContainer;

    private final StackPane topContainer;

    private AnimalGrid animalGrid;
    private final AnimalControl animalControl;

    private final CashDisplay cashDisplay;

    public CageScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(157, 117, 91), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Cage", 48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));

        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        topContainer.getChildren().addAll(titleContainer, cashDisplay, new ReturnButton());

        loadAnimal();
        animalControl = new AnimalControl();

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, animalGrid, animalControl);
        getChildren().add(container);

        // animalSquare setup
        animalSquareEvents();
    }

    private void animalSquareEvents() {
        for (Node i : animalGrid.getGrid().getChildren()) {
            if (i instanceof AnimalSquare) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        if (((AnimalSquare) i).isOccupied()) {
                            animalSquareHarvest(((AnimalSquare) i));
                        }
                    }
                });
            }
        }
    }

    private void animalSquareHarvest(AnimalSquare i) {
        if (animalControl.getSelectedTool() != null) {
            if (animalControl.getSelectedTool().equals("Hand")) {
                if (i.isReady()) {
                    i.harvest();
                    animalCollected(i.getAnimal());
                }
            } else if (animalControl.getSelectedTool().equals("Wheat")) {
                if (!i.isReady() && i.eatWheat() && haveWheat()) {
                    i.nextStage();
                    animalFed(i.getAnimal());
                }
            } else if (animalControl.getSelectedTool().equals("ChickenFood")) {
                if (!i.isReady() && !(i.eatWheat())) {
                    i.nextStage();
                    animalFed(i.getAnimal());
                }
            }
        }
    }


    private Boolean haveWheat() {
        for (ItemCounter i : gameInstance.getPlayer().getInventory()) {
            if (i.getItem() instanceof Wheat) {
                return true;
            }
        }
        return false;
    }

    private void loadAnimal() {
        ArrayList<Animal> animal = gameInstance.getPlayer().getCage();
        animalGrid = new AnimalGrid(animal);
    }

    private void animalCollected(Animal animal) {
        System.out.println("Animal Collected");
        System.out.println(animal.getName());
        animal.collect(gameInstance.getPlayer());
    }

    private void animalFed(Animal animal) {
        System.out.println("Animal Fed");
        System.out.println(animal.getName());
        animal.feed(gameInstance.getPlayer());
    }

}
