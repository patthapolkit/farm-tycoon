package scene;


import component.CashDisplay;
import component.InventoryGrid;
import component.ReturnButton;
import component.OrbitFontText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.ItemCounter;

import java.util.ArrayList;

public class BarnScene extends StackPane {

    private final StackPane topContainer;
    private final VBox container;
    private final VBox titleContainer;

    private final InventoryGrid inventoryGrid;

    private final OrbitFontText title;

    private final CashDisplay cashDisplay;


    public BarnScene(ArrayList<ItemCounter> inventory, int balance) {

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(201, 122, 117), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Barn", 48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);
        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);

        topContainer.setPadding(new Insets(15, 30, 0, 30));

        cashDisplay = new CashDisplay(balance);

        topContainer.getChildren().addAll(titleContainer, cashDisplay, new ReturnButton());

        // inventoryGrid setup
        inventoryGrid = new InventoryGrid(inventory);
        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, inventoryGrid);
        getChildren().add(container);

    }

}
