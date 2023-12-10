package scene;

import component.*;
import entity.product.Recipe;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.ItemCounter;
import resource.ImageLoader;

import static resource.ImageLoader.*;
import static utility.Utility.stringToProduct;

public class FactoryScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private VScroll recipeSelector;

    private CraftingPane craftingPane;

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


        craftingPane = new CraftingPane();
        craftingPane.getCraftButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                craftPressed();
            }
        });

        recipeSelector = new VScroll();

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



        // mainContainer setup
        mainContainer = new HBox();
        mainContainer.getChildren().addAll(recipeSelector, craftingPane);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setSpacing(15);

        // container setup
        container = new VBox();
        container.setSpacing(15);
        container.getChildren().addAll(topContainer, mainContainer);
        getChildren().add(container);

        setSelectedRecipe(vb1);

    }
    private void setSelectedRecipe(Node vb){
        selectedRecipe = ((VScrollButton) vb).getButtonId();
        System.out.println(selectedRecipe);
        recipeSelector.updateSelected(selectedRecipe);
        craftingPane.setItemNameText(selectedRecipe);
        craftingPane.setItemImage(getImage(itemToLoad(stringToProduct(selectedRecipe))));
        Recipe r = Recipe.getRecipe(selectedRecipe);
        craftingPane.getItemDisContainer().getChildren().clear();
        for (ItemCounter i: r.getIngredient()){
            ItemDisplay j = new ItemDisplay(i);
            craftingPane.getItemDisContainer().getChildren().add(j);
        }
    }

    private void craftPressed(){
        System.out.println("Crafted " + selectedRecipe);
    }

}
