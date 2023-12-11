package component;

import entity.building.Plot;
import entity.seed.Seed;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PlotGrid extends StackPane {

    private final Rectangle background;

    private final GridPane grid;


    public PlotGrid(ArrayList<Plot> plots) {

        // stackPane(this) setup
        setPadding(new Insets(20, 50, 20, 50));

        // background setup
        background = new Rectangle(600, 180, Color.rgb(197, 148, 119));
        background.setArcHeight(40);
        background.setArcWidth(40);

        // grid setup
        grid = new GridPane();
        gridSetup(plots);
    }

    private int numToGridCol(int x) {
        return (x % 7);
    }

    private int numToGridRow(int x) {
        return (Math.floorDiv(x, 7));
    }

    public GridPane getGrid() {
        return grid;
    }

    private void gridSetup(ArrayList<Plot> plots) {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        for (int i = 0; i < plots.size(); i++) {
            Seed seed = plots.get(i).getSeed();
            int humid = seed.getHumidityLevel();
            int c = numToGridCol(i);
            int r = numToGridRow(i);

            PlotSquare sq = new PlotSquare();
            sq.setSeed(seed);
            sq.setPlot(plots.get(i));
            for (int j = 0; j < humid; j += 25) {
                sq.nextStage();
            }
            grid.add(sq, c, r);
        }
        getChildren().addAll(background, grid);
    }

}
