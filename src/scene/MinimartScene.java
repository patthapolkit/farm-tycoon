package scene;

import component.*;
import entity.base.Item;
import entity.building.MartItem;
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

public class MinimartScene extends StackPane {
    private GameInstance gameInstance;

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VScroll itemSelector;

    private InfoPane infoPane;

    private StackPane topContainer;

    private String selectedItem;

    private HBox mainContainer;
    private CashDisplay cashDisplay;


    public MinimartScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(233, 210, 129), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Your Minimart", 48);
        title.setFill(Color.BLACK);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));

        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        topContainer.getChildren().addAll(titleContainer, cashDisplay, new NavMenu());

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
    }

    private void vScrollSetup() {

        itemSelector = new VScroll(Color.rgb(199, 211, 214));
        itemSelector.setBackground(Color.rgb(251, 240, 190), "#FBF0BE");

        VScrollButton vb1 = new VScrollButton(getImageView(EGG), "Egg", "Egg");
        VScrollButton vb2 = new VScrollButton(getImageView(MILK), "Milk", "Milk");
        VScrollButton vb3 = new VScrollButton(getImageView(WOOL), "Wool", "Wool");
        VScrollButton vb4 = new VScrollButton(getImageView(WHEAT), "Wheat", "Wheat");
        VScrollButton vb5 = new VScrollButton(getImageView(CARROT), "Carrot", "Carrot");
        VScrollButton vb6 = new VScrollButton(getImageView(PUMPKIN), "Pumpkin", "Pumpkin");
        VScrollButton vb7 = new VScrollButton(getImageView(BEETROOT), "Beetroot", "Beetroot");
        VScrollButton vb8 = new VScrollButton(getImageView(BERRY), "Berry", "Berry");
        VScrollButton vb9 = new VScrollButton(getImageView(SWEATER), "Sweater", "Sweater");
        VScrollButton vb10 = new VScrollButton(getImageView(CAKE), "Cake", "Cake");
        VScrollButton vb11 = new VScrollButton(getImageView(PUMPKIN_PIE), "Pumpkin Pie", "Pumpkin Pie");
        VScrollButton vb12 = new VScrollButton(getImageView(CARROT_PIE), "Carrot Pie", "Carrot Pie");
        VScrollButton vb13 = new VScrollButton(getImageView(BREAD), "Bread", "Bread");
        VScrollButton vb14 = new VScrollButton(getImageView(DANDELION), "Dandelion", "Dandelion");
        VScrollButton vb15 = new VScrollButton(getImageView(POPPY), "Poppy", "Poppy");
        VScrollButton vb16 = new VScrollButton(getImageView(ORCHID), "Orchid", "Orchid");
        VScrollButton vb17 = new VScrollButton(getImageView(TULIP), "Tulip", "Tulip");
        itemSelector.getButtonContainer().getChildren().addAll(vb1, vb2, vb3, vb4, vb5, vb6, vb7, vb8, vb9);
        itemSelector.getButtonContainer().getChildren().addAll(vb10, vb11, vb12, vb13, vb14, vb15, vb16, vb17);

        for (Node i : itemSelector.getButtonContainer().getChildren()) {
            if (i instanceof VScrollButton) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        setSelectedItem(i);
                    }
                });
            }
        }
        setSelectedItem(vb1);

    }

    private void infoPaneSetup() {
        infoPane = new InfoPane("Sell", false);
        infoPane.setBackground(Color.rgb(251, 240, 190));
        infoPane.getCraftButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                sell();
            }
        });
    }


    private void setSelectedItem(Node vb) {
        selectedItem = ((VScrollButton) vb).getButtonId();
        System.out.println(selectedItem);
        itemSelector.updateSelected(selectedItem);
        infoPane.setItemNameText(selectedItem);
        infoPane.setItemImage(getImage(itemToLoad(stringToItem(selectedItem))));

        MartItem s = MartItem.getMartItem(selectedItem);
        infoPane.setDescText(s.getDescription() + "\nCan be sold for " + s.getSellPrice() + "\n");
    }

    private void sell() {
        Item soldItem;
        if ((selectedItem == "Bread") || (selectedItem == "Cake") || (selectedItem == "Pumpkin Pie")
                || (selectedItem == "Carrot Pie") || (selectedItem == "Sweater")) {
            soldItem = stringToProduct(selectedItem);
        } else {
            soldItem = stringToItem(selectedItem);
        }
        gameInstance.getMinimart().sell(gameInstance.getPlayer(), soldItem, 1);
        updateCashText(gameInstance.getPlayer().getBalance());
        System.out.println("Sold " + soldItem.getName());
    }
}