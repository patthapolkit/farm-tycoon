package scene;

import component.*;
import entity.building.Plot;
import entity.seed.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.GameInstance;

import java.util.ArrayList;

import static utility.Utility.stringToSeed;

public class PlotScene extends StackPane {
    private final GameInstance gameInstance;

    private final VBox container;

    private final OrbitFontText title;

    private final VBox titleContainer;

    private final StackPane topContainer;

    private PlotGrid plotGrid;
    private PlotControl plotControl;

    private final CashDisplay cashDisplay;

    public PlotScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

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

        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        topContainer.getChildren().addAll(titleContainer, cashDisplay, new ReturnButton());


        loadUnlockedSeed();
        loadPlots();

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, plotGrid, plotControl);
        getChildren().add(container);

        // plotSquare setup
        plotSquareEvents();

    }


    private void plotSquareEvents() {
        for (Node i : plotGrid.getGrid().getChildren()) {
            if (i instanceof PlotSquare) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        if (((PlotSquare) i).isPlanted()) {
                            if (plotControl.getSelectedTool() != null) {
                                System.out.println("Applied " + plotControl.getSelectedTool());
                                if (plotControl.getSelectedTool().equals("Sickle")) {
                                    ((PlotSquare) i).harvest();
                                    plotHarvested(((PlotSquare) i).getPlot());
                                } else if (plotControl.getSelectedTool().equals("WateringPot")) {
                                    if (hasEnoughMoney(5)) {
                                        ((PlotSquare) i).nextStage();
                                        plotWatered(((PlotSquare) i).getPlot());
                                    }
                                }
                            }
                        } else {
                            if (plotControl.getSelectedSeed() != null) {
                                System.out.println("Applied " + plotControl.getSelectedSeed());
                                ((PlotSquare) i).setSeed(stringToSeed(plotControl.getSelectedSeed()));
                                plotPlanted(((PlotSquare) i).getPlot(), stringToSeed(plotControl.getSelectedSeed()));
                            }
                        }
                    }
                });
            }
        }

    }


    private Boolean hasEnoughMoney(int c) {
        return (gameInstance.getPlayer().getBalance() >= c);
    }


    private void updateCashText(int x) {
        cashDisplay.setCashText(x);
        for (Node i : HomeMenuScene.getRoot().getChildren()) {
            if (i instanceof FarmScene) {
                ((FarmScene) i).updateCashText(x);
            }
        }
    }


    private void loadUnlockedSeed() {
        ArrayList<Seed> unlockedSeed = gameInstance.getShop().getUnlockedSeed();
        plotControl = new PlotControl(unlockedSeed);
    }

    private void loadPlots() {
        ArrayList<Plot> plots = gameInstance.getPlayer().getPlots();
        plotGrid = new PlotGrid(plots);
    }

    private void plotHarvested(Plot plot) {
        System.out.println("Plot with seed: " + "Harvested " + plot.getSeed().getName());
        plot.getSeed().collect(gameInstance.getPlayer());
        plot.setSeed(new NullSeed());
    }

    private void plotWatered(Plot plot) {
        System.out.println("Plot with seed " + plot.getSeed().getName() + ": Humidity " + plot.getSeed().getHumidityLevel() + " += 25");
        plot.getSeed().water(gameInstance.getPlayer());
        updateCashText(gameInstance.getPlayer().getBalance());

    }

    private void plotPlanted(Plot plot, Seed seed) {
        System.out.println("Empty plot: " + "Planted" + seed.getName());
        plot.setSeed(seed);
    }

}
