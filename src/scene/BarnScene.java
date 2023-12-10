package scene;


import component.InventoryGrid;
import component.NavMenu;
import component.OrbitFontText;
import entity.material.*;
import entity.product.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.ItemCounter;

import java.util.ArrayList;

public class BarnScene extends StackPane {

    private StackPane topContainer;
    private VBox container;
    private VBox titleContainer;

    private InventoryGrid inventoryGrid;

    private OrbitFontText title;


    public BarnScene(){

        // stackPane(this) setup
        setPrefSize(800,450);
        setBackground(new Background(new BackgroundFill(Color.rgb(201,122,117), null, null)));
        
        // title & titleContainer setup
        title = new OrbitFontText("Barn",48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);
        
        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15,30,0,30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());
        
        // inventoryGrid setup
        ArrayList<ItemCounter> inventory = new ArrayList<ItemCounter>();
        inventory.add(new ItemCounter(new Wheat(),10));
        inventory.add(new ItemCounter(new Carrot(),10));
        inventory.add(new ItemCounter(new Beetroot(),53));
        inventory.add(new ItemCounter(new Milk(),79));
        inventory.add(new ItemCounter(new Egg(),3));
        inventory.add(new ItemCounter(new Berry(),1));
        inventory.add(new ItemCounter(new Cake(),1));
        inventory.add(new ItemCounter(new Wool(),1));
        inventory.add(new ItemCounter(new PumpkinPie(),13));
        inventory.add(new ItemCounter(new Sweater(),1));
        inventory.add(new ItemCounter(new CarrotPie(),12));
        inventory.add(new ItemCounter(new Bread(),133));
        inventoryGrid = new InventoryGrid(inventory);
        
        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer, inventoryGrid);
        getChildren().add(container);


    }

}
