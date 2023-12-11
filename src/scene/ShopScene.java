package scene;

import component.*;
import entity.animal.Animal;
import entity.building.ShopItem;
import entity.seed.Seed;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.GameInstance;

import static resource.ImageLoader.*;
import static utility.Utility.*;

public class ShopScene extends StackPane {
    private final GameInstance gameInstance;

    private final VBox container;

    private final OrbitFontText title;

    private final VBox titleContainer;

    private VScroll itemSelector;

    private InfoPane infoPane;

    private final StackPane topContainer;

    private String selectedItem;

    private final HBox mainContainer;
    private final CashDisplay cashDisplay;


    public ShopScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

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

        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        topContainer.getChildren().addAll(titleContainer, cashDisplay, new ReturnButton());

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


    private void updateCashText(int x) {
        cashDisplay.setCashText(x);
        for (Node i : HomeMenuScene.getRoot().getChildren()) {
            if (i instanceof FarmScene) {
                ((FarmScene) i).updateCashText(x);
            }
        }
    }

    private void vScrollSetup() {
        itemSelector = new VScroll(Color.rgb(199, 211, 214));
        itemSelector.setBackground(Color.rgb(251, 240, 190), "#FBF0BE");
        vButtonSetup();
        for (Node i : itemSelector.getButtonContainer().getChildren()) {
            if (i instanceof VScrollButton) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        setSelectedItem(i);
                    }
                });
            }
        }
    }

    private void vButtonSetup() {
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
        itemSelector.getButtonContainer().getChildren().addAll(vb1, vb2, vb3, vb4, vb5, vb6);
        itemSelector.getButtonContainer().getChildren().addAll(vb7, vb8, vb9, vb10, vb11);
        setSelectedItem(vb1);
    }


    private void infoPaneSetup() {
        infoPane = new InfoPane("Purchase", false);
        infoPane.setBackground(Color.rgb(251, 240, 190));
        infoPane.getActionButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                purchase();
            }
        });
    }


    private void setSelectedItem(Node vb) {
        selectedItem = ((VScrollButton) vb).getButtonId();
        System.out.println(selectedItem);
        itemSelector.updateSelected(selectedItem);
        infoPane.setItemNameText(selectedItem);
        if ((selectedItem.equals("Cow")) || (selectedItem.equals("Chicken")) || (selectedItem.equals("Sheep"))) {
            infoPane.setItemImage(getImage(animalToLoad(stringToAnimal(selectedItem))));
        } else {
            infoPane.setItemImage(getImage(seedToLoad(stringToSeed(selectedItem))));
        }

        ShopItem s = ShopItem.getShopItem(selectedItem);
        infoPane.setDescText(s.getDescription() + "\nPrice: " + s.getPrice() + "\n");
    }

    private void purchase() {
        if ((selectedItem.equals("Cow")) || (selectedItem.equals("Chicken")) || (selectedItem.equals("Sheep"))) {
            Animal purchasedAnimal = stringToAnimal(selectedItem);
            gameInstance.getShop().buy(gameInstance.getPlayer(), purchasedAnimal);
            System.out.println("Bought " + purchasedAnimal.getName());
        } else {
            Seed unlockedSeed = stringToSeed(selectedItem);
            gameInstance.getShop().unlock(gameInstance.getPlayer(), unlockedSeed);
            System.out.println("Unlocked " + unlockedSeed.getName());
        }
        updateCashText(gameInstance.getPlayer().getBalance());
    }

}
