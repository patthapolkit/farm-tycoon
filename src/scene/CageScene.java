package scene;

import component.*;
import entity.animal.*;
import entity.building.Plot;
import entity.material.*;
import entity.product.*;
import entity.seed.*;
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

import static utility.Utility.stringToSeed;

public class CageScene extends StackPane {
    private GameInstance gameInstance;

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;

    private AnimalGrid animalGrid;
    private AnimalControl animalControl;

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
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        loadAnimal();
        animalControl = new AnimalControl();

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, animalGrid, animalControl);
        getChildren().add(container);

        // animalSquare setup
        animalSquareEvents();

    }
    public void animalSquareEvents(){
        for (Node i: animalGrid.getGrid().getChildren()){
            if (i instanceof AnimalSquare){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        if (((AnimalSquare) i).isOccupied()){
                            if (animalControl.getSelectedTool() != null){
                                System.out.println("Applied " + animalControl.getSelectedTool());
                                if (animalControl.getSelectedTool() == "Hand"){
                                    if (((AnimalSquare) i).isReady()){
                                        ((AnimalSquare) i).harvest();
                                        animalCollected(((AnimalSquare) i).getAnimal());
                                    }
                                }
                                else if (animalControl.getSelectedTool() == "Wheat"){
                                    if (!((AnimalSquare) i).isReady() && (((AnimalSquare) i).eatWheat())){
                                        ((AnimalSquare) i).nextStage();
                                        animalFed(((AnimalSquare) i).getAnimal());
                                    }
                                }
                                else if (animalControl.getSelectedTool() == "ChickenFood"){
                                    if (!((AnimalSquare) i).isReady() && !(((AnimalSquare) i).eatWheat())){
                                        ((AnimalSquare) i).nextStage();
                                        animalFed(((AnimalSquare) i).getAnimal());
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

    }

    public void loadAnimal(){


        // Sample ArrayList<Plot>
        // Note: Its size will always be 12 as shown
        ArrayList<Animal> animal = new ArrayList<Animal>();
        animal.add(new Cow());
        animal.add(new Chicken());
        animal.add(new Sheep());
        for (int i=1;i<=9;i++){
            animal.add(new NullAnimal());
        }

        // EDIT HERE

        // Send an ArrayList<Plot> to the PlotGrid constructor
        animalGrid = new AnimalGrid(animal);
    }

    public void animalCollected(Animal animal){

        // This function will be called when the input animal has been harvested
        System.out.println("Animal Collected");
        System.out.println(animal.getName());

        // EDIT HERE

    }

    public void animalFed(Animal animal){

        // This function will be called when the input plot has been fed
        System.out.println("Animal Fed");
        System.out.println(animal.getName());

        // EDIT HERE
    }

}
