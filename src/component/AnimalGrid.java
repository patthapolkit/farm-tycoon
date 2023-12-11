package component;

import entity.animal.Animal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class AnimalGrid extends StackPane {

    private final Rectangle background;

    private final GridPane grid;

    public AnimalGrid(ArrayList<Animal> animals) {

        // stackPane(this) setup
        setPadding(new Insets(20, 50, 20, 50));

        // background setup
        background = new Rectangle(600, 180, Color.rgb(197, 148, 119));
        background.setArcHeight(40);
        background.setArcWidth(40);

        // grid setup
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            int foodLevel = a.getFoodLevel();
            int c = numToGridCol(i);
            int r = numToGridRow(i);
            AnimalSquare sq = new AnimalSquare();
            sq.setAnimal(a);
            for (int j = 0; j < foodLevel; j += 25) {
                sq.nextStage();
            }
            grid.add(sq, c, r);
        }
        getChildren().addAll(background, grid);
    }

    private int numToGridCol(int x) {
        return (x % 6);
    }

    private int numToGridRow(int x) {
        return (Math.floorDiv(x, 6));
    }

    public GridPane getGrid() {
        return grid;
    }
}
