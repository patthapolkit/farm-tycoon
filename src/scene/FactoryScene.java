package scene;

import component.*;
import entity.base.Item;
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
import static utility.Utility.stringToProduct;

public class FactoryScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VScroll recipeSelector;

    private InfoPane infoPane;

    private StackPane topContainer;

    private String selectedRecipe;

    private HBox mainContainer;

    public FactoryScene(){

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(127, 127, 127), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Factory", 48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // infoPane & vScroll setup
        craftPaneSetup();
        vScrollSetup();

        // mainContainer setup
        mainContainer = new HBox();
        mainContainer.getChildren().addAll(recipeSelector, infoPane);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setSpacing(15);

        // container setup
        container = new VBox();
        container.setSpacing(15);
        container.getChildren().addAll(topContainer, mainContainer);
        getChildren().add(container);

    }


    private void vScrollSetup(){

        recipeSelector = new VScroll(Color.rgb(238,209,116));

        VScrollButton vb1 = new VScrollButton(getImageView(BREAD), "Bread", "Bread");
        VScrollButton vb2 = new VScrollButton(getImageView(SWEATER), "Sweater", "Sweater");
        VScrollButton vb3 = new VScrollButton(getImageView(CAKE), "Cake", "Cake");
        VScrollButton vb4 = new VScrollButton(getImageView(PUMPKIN_PIE), "Pumpkin Pie", "Pumpkin Pie");
        VScrollButton vb5 = new VScrollButton(getImageView(CARROT_PIE), "Carrot Pie", "Carrot Pie");

        recipeSelector.getButtonContainer().getChildren().addAll(vb1,vb2,vb3,vb4,vb5);

        for (Node i : recipeSelector.getButtonContainer().getChildren()){
            if (i instanceof VScrollButton){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        setSelectedRecipe(i);
                    }
                });
            }
        }

        setSelectedRecipe(vb1);

    }

    private void craftPaneSetup(){
        infoPane = new InfoPane("Craft",true);
        infoPane.getCraftButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                craftPressed();
            }
        });
    }


    private void setSelectedRecipe(Node vb){
        selectedRecipe = ((VScrollButton) vb).getButtonId();
        System.out.println(selectedRecipe);
        recipeSelector.updateSelected(selectedRecipe);
        infoPane.setItemNameText(selectedRecipe);
        infoPane.setItemImage(getImage(itemToLoad(stringToProduct(selectedRecipe))));
        Recipe r = getRecipe(selectedRecipe);
        infoPane.getItemDisContainer().getChildren().clear();
        for (ItemCounter i: r.getIngredient()){
            ItemDisplay j = new ItemDisplay(i);
            infoPane.getItemDisContainer().getChildren().add(j);
        }
    }

    private void craftPressed(){

        Item craftedItem = stringToProduct(selectedRecipe);
        ArrayList<ItemCounter> ingredient = getRecipe(selectedRecipe).getIngredient();

        // EDIT HERE

        System.out.println("Crafted " + selectedRecipe);

    }

}
