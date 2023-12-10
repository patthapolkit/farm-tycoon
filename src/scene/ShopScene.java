package scene;

import component.*;
import entity.base.Item;
import entity.building.ShopItem;
import entity.product.Recipe;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.ItemCounter;

import java.util.ArrayList;

import static entity.product.Recipe.getRecipe;
import static resource.ImageLoader.*;
import static utility.Utility.*;

public class ShopScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VScroll itemSelector;

    private InfoPane infoPane;

    private StackPane topContainer;

    private String selectedItem;

    private HBox mainContainer;

    public ShopScene(){

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(233, 210, 129), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Shop", 48);
        title.setFill(Color.BLACK);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // infoPane & vScroll setup
        infoPaneSetup();
        vScrollSetup();

        // mainContainer setup
        mainContainer = new HBox();
        mainContainer.getChildren().addAll(itemSelector, infoPane);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setSpacing(15);

        // container setup
        container = new VBox();
        container.setSpacing(15);
        container.getChildren().addAll(topContainer, mainContainer);
        getChildren().add(container);

    }


    private void vScrollSetup(){

        itemSelector = new VScroll(Color.rgb(199,211,214));
        itemSelector.setBackground(Color.rgb(251,240,190),"#FBF0BE");

        VScrollButton vb1 = new VScrollButton(getImageView(CARROT_SEED), "Carrot Seed", "Carrot Seed");
        VScrollButton vb2 = new VScrollButton(getImageView(PUMPKIN_SEED), "Pumpkin Seed", "Pumpkin Seed");
        VScrollButton vb3 = new VScrollButton(getImageView(BEETROOT_SEED), "Beetroot Seed", "Beetroot Seed");
        VScrollButton vb4 = new VScrollButton(getImageView(BERRY_SEED), "Berry Seed", "Berry Seed");
        VScrollButton vb5 = new VScrollButton(getImageView(DANDELION_SEED), "Dandelion Seed", "Dandelion Seed");
        VScrollButton vb6 = new VScrollButton(getImageView(POPPY_SEED), "Poppy Seed", "Poppy Seed");
        VScrollButton vb7 = new VScrollButton(getImageView(ORCHID_SEED), "Orchid Seed", "Orchid Seed");
        VScrollButton vb8 = new VScrollButton(getImageView(TULIP_SEED), "Tulip Seed", "Tulip Seed");
        VScrollButton vb9 = new VScrollButton(getImageView(CHICKEN), "Chicken", "Chicken");
        VScrollButton vb10 = new VScrollButton(getImageView(COW), "Cow", "Cow");
        VScrollButton vb11 = new VScrollButton(getImageView(SHEEP), "Sheep", "Sheep");

        itemSelector.getButtonContainer().getChildren().addAll(vb1,vb2,vb3,vb4,vb5,vb6);
        itemSelector.getButtonContainer().getChildren().addAll(vb7,vb8,vb9,vb10,vb11);

        for (Node i : itemSelector.getButtonContainer().getChildren()){
            if (i instanceof VScrollButton){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        setSelectedItem(i);
                    }
                });
            }
        }
        setSelectedItem(vb1);

    }

    private void infoPaneSetup(){
        infoPane = new InfoPane("Purchase",false);
        infoPane.setBackground(Color.rgb(251,240,190));
        infoPane.getCraftButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                purchase();
            }
        });
    }


    private void setSelectedItem(Node vb){
        selectedItem = ((VScrollButton) vb).getButtonId();
        System.out.println(selectedItem);
        itemSelector.updateSelected(selectedItem);
        infoPane.setItemNameText(selectedItem);
        if ((selectedItem == "Cow") || (selectedItem == "Chicken") || (selectedItem == "Sheep")){
            infoPane.setItemImage(getImage(animalToLoad(stringToAnimal(selectedItem))));
        }
        else {
            infoPane.setItemImage(getImage(seedToLoad(stringToSeed(selectedItem))));
        }

        ShopItem s = ShopItem.getShopItem(selectedItem);
        infoPane.setDescText(s.getDescription() + "\nPrice: " + s.getPrice() + "\n");
    }

    private void purchase(){
        Item craftedItem = stringToProduct(selectedItem);

        // EDIT HERE
        // For seed, if already unlocked please do nothing
        // For animal, if already reached maximum allowed (4) please do nothing

        System.out.println("Bought " + selectedItem);
    }

}
