package scene;

import component.*;
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
import logic.ItemCounter;

import java.util.ArrayList;

import static utility.Utility.stringToSeed;

public class PlotScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;

    private PlotGrid plotGrid;
    private PlotControl plotControl;

    public PlotScene() {

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(157, 117, 91), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Plot", 48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());



        loadUnlockedSeed();

        loadPlots();

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, plotGrid, plotControl);
        getChildren().add(container);

        // plotSquare setup
        plotSquareEvents();

    }


    public void plotSquareEvents(){
        for (Node i: plotGrid.getGrid().getChildren()){
            if (i instanceof PlotSquare){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        if (((PlotSquare) i).isPlanted()){
                            if (plotControl.getSelectedTool() != null){
                                System.out.println("Applied " + plotControl.getSelectedTool());
                                if (plotControl.getSelectedTool() == "Sickle"){
                                    ((PlotSquare) i).harvest();
                                    plotHarvested(((PlotSquare) i).getPlot());
                                }
                                else if (plotControl.getSelectedTool() == "WateringPot"){
                                    ((PlotSquare) i).nextStage();
                                    plotWatered(((PlotSquare) i).getPlot());
                                }
                            }
                        }
                        else {
                            if (plotControl.getSelectedSeed() != null) {
                                System.out.println("Applied " + plotControl.getSelectedSeed());
                                ((PlotSquare) i).setSeed(stringToSeed(plotControl.getSelectedSeed()));
                                plotPlanted(((PlotSquare) i).getPlot(),stringToSeed(plotControl.getSelectedSeed()));
                            }
                        }
                    }
                });
            }
        }

    }

    public void loadUnlockedSeed(){

        // Sample ArrayList<Seed>
        ArrayList<Seed> unlockedSeed = new ArrayList<Seed>();
        unlockedSeed.add(new WheatSeed());
        unlockedSeed.add(new BerrySeed());
        unlockedSeed.add(new CarrotSeed());

        // EDIT HERE

        // Send an ArrayList<Seed> to the PlotControl constructor
        plotControl = new PlotControl(unlockedSeed);
    }

    public void loadPlots(){


        // Sample ArrayList<Plot>
        // Note 1: Its size will always be 14
        ArrayList<Plot> plots = new ArrayList<Plot>();
        for (int i=1;i<=8;i++){
            plots.add(new Plot(new WheatSeed()));
        }
        for (int i=9;i<=14;i++){
            plots.add(new Plot());
            // Note 2: This constructor will create an empty plot (See NullSeed)
        }


        // EDIT HERE


        // Send an ArrayList<Plot> to the PlotGrid constructor
        plotGrid = new PlotGrid(plots);
    }

    public void plotHarvested(Plot plot){
        // This function will be called when the input plot has been harvested
        System.out.println("Plot with seed: " + "Harvested " + plot.getSeed().getName());

        // EDIT HERE
    }

    public void plotWatered(Plot plot){
        // This function will be called when the input plot has been watered
        System.out.println("Plot with seed " + plot.getSeed().getName() +": Humidity " + plot.getSeed().getHumidityLevel() + " += 25");

        // EDIT HERE
    }

    public void plotPlanted(Plot plot, Seed seed){
        // This function will be called when the input empty plot has been planted
        System.out.println("Empty plot: " + "Planted" + seed.getName());

        // EDIT HERE
    }

}
