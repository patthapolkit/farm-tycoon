package component;

import entity.seed.PoppySeed;
import entity.seed.WheatSeed;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlotGrid extends StackPane {

    private Rectangle background;

    private GridPane grid;

    private VBox gridContainer;

    public PlotGrid(){

        // stackPane(this) setup
        setPadding(new Insets(20,50,20,50));

        // background setup
        background = new Rectangle(600,180, Color.rgb(197,148,119));
        background.setArcHeight(40);
        background.setArcWidth(40);

        // grid setup
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int i=1;i<=7;i++){
            for (int j=1;j<=2;j++){
                grid.add(new PlotSquare(),i-1,j-1);
            }
        }
        PlotSquare x = new PlotSquare();
        PlotSquare y = new PlotSquare();
        x.setLocked(true);
        y.setLocked(true);
        grid.add(x,7,0);
        grid.add(y,7,1);


        getChildren().addAll(background, grid);

    }

    public GridPane getGrid() {
        return grid;
    }
}
