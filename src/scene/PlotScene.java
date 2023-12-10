package scene;

import component.*;
import entity.seed.WheatSeed;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static utility.Utility.stringToSeed;

public class PlotScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;


    private PlotGrid plotGrid;

    private PlotControl plotControl;

    private HBox bottomContainer;


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

        plotGrid = new PlotGrid();
        plotControl = new PlotControl();

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, plotGrid, plotControl);
        getChildren().add(container);

        for (Node i: plotGrid.getGrid().getChildren()){
            if (i instanceof PlotSquare){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {

                        if (((PlotSquare) i).isPlanted()){
                            if (plotControl.getSelectedTool() != null){
                                System.out.println("Applied " + plotControl.getSelectedTool());
                                if (plotControl.getSelectedTool() == "Sickle"){
                                    ((PlotSquare) i).harvest();
                                }
                                else if (plotControl.getSelectedTool() == "WateringPot"){
                                    ((PlotSquare) i).nextStage();
                                }
                            }
                        }
                        else {
                            if (plotControl.getSelectedSeed() != null) {
                                System.out.println("Applied " + plotControl.getSelectedSeed());
                                ((PlotSquare) i).setSeed(stringToSeed(plotControl.getSelectedSeed()));
                            }

                        }

                    }
                });
            }
        }

    }
}
