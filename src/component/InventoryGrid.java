package component;

import entity.base.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import logic.ItemCounter;

import java.util.ArrayList;


public class InventoryGrid extends StackPane {

    private final GridPane grid;
    private final ScrollPane scrollPane;

    private int uniqueItemCount;

    private final ArrayList<ItemCounter> inventory;

    public InventoryGrid(ArrayList<ItemCounter> inv) {

        // inventory init
        inventory = new ArrayList<ItemCounter>();

        // uniqueItemCount init
        uniqueItemCount = 0;

        // stackPane(this) setup
        setPadding(new Insets(20, 100, 20, 100));

        // grid setup
        grid = new GridPane();
        grid.setPadding(new Insets(10, 35, 10, 35));
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        // scrollPane setup
        ScrollPane sp = new ScrollPane();
        scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setMinHeight(300);
        scrollPane.setMaxHeight(300);
        scrollPane.setStyle("-fx-background: #DEC2C0; -fx-border-color: #DEC2C0;");

        getChildren().addAll(scrollPane);
        for (ItemCounter i : inv) {
            addItem(i);
        }
    }

    public void addItem(ItemCounter itemCounter) {
        int count = itemCounter.getCount();
        Item item = itemCounter.getItem();
        String itemType = item.getName();

        for (ItemCounter i : inventory) {
            if (i.getItem().getName().equals(itemType)) {
                i.setCount(i.getCount() + count);
                for (Node j : grid.getChildren()) {
                    if ((j instanceof ItemDisplay)) {
                        if (((ItemDisplay) j).getItemDisplayed().getName().equals(itemType)) {
                            System.out.println(i.getCount());
                            ((ItemDisplay) j).addCount(count);
                        }
                    }
                }
                return;
            }
        }
        inventory.add(itemCounter);
        gridPush(new ItemDisplay(itemCounter));
    }


    private int numToGridCol(int x) {
        return (x % 6);
    }

    private int numToGridRow(int x) {
        return (Math.floorDiv(x, 6));
    }


    private void gridPush(ItemDisplay itemDisplay) {
        int c = numToGridCol(getUniqueItemCount());
        int r = numToGridRow(getUniqueItemCount());
        grid.add(itemDisplay, c, r);
        uniqueItemCount += 1;
    }

    private int getUniqueItemCount() {
        return uniqueItemCount;
    }


}
