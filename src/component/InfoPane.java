package component;

import entity.material.Berry;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import logic.ItemCounter;
import resource.ImageLoader;
import javafx.scene.layout.HBox;

import static resource.ImageLoader.getImageView;

public class InfoPane extends StackPane {


    private final Boolean isCrafting;
    private final Rectangle background;
    private final ImageView itemImageView;

    private final OrbitFontText itemNameText;
    private final OrbitFontText descText;

    private OrbitFontText matText;
    private VBox matContainer;
    private HBox itemDisContainer;
    private final HBox descContainer;
    private final VBox container;
    private final HBox topContainer;

    private final GameButton actionButton;

    public InfoPane(String action, Boolean isCrafting) {

        this.isCrafting = isCrafting;

        background = new Rectangle(350, 330, Color.rgb(199, 211, 214));
        container = new VBox();
        topContainer = new HBox();
        descText = new OrbitFontText("", 15);
        itemNameText = new OrbitFontText("", 28);
        itemImageView = getImageView(ImageLoader.BERRY);
        descContainer = new HBox(descText);
        componentSetup();

        if (isCrafting) {
            craftingSetup();
        }
        actionButton = new GameButton(120, 50, 20, Color.WHITE);
        actionButton.getChildren().add(new OrbitFontText(action, 22));
        containerSetup();

    }


    public void setItemNameText(String s) {
        itemNameText.setText(s);
    }

    public void setItemImage(Image i) {
        itemImageView.setImage(i);
    }

    public void setDescText(String s) {
        descText.setText(s);
    }

    public HBox getItemDisContainer() {
        return itemDisContainer;
    }

    public GameButton getActionButton() {
        return actionButton;
    }

    public void setBackground(Paint paint) {
        background.setFill(paint);
    }


    private void craftingSetup() {
        matText = new OrbitFontText("Materials required", 20);
        matContainer = new VBox(matText);
        matContainer.setPadding(new Insets(7, 0, 15, 0));
        matContainer.setAlignment(Pos.TOP_LEFT);
        matContainer.setSpacing(3);

        itemDisContainer = new HBox();
        itemDisContainer.setSpacing(5);
        for (int i = 1; i <= 3; i++) {
            itemDisContainer.getChildren().add(new ItemDisplay(new ItemCounter(new Berry(), 10)));
        }
        matContainer.getChildren().add(itemDisContainer);
    }


    private void containerSetup() {
        if (isCrafting) {
            container.getChildren().addAll(topContainer, descContainer, matContainer, actionButton);
        } else {
            container.getChildren().addAll(topContainer, descContainer, actionButton);
        }
        getChildren().addAll(background, container);
    }

    private void componentSetup() {

        background.setArcHeight(40);
        background.setArcWidth(40);
        itemImageView.setFitWidth(35);
        itemImageView.setFitHeight(50);
        itemNameText.setTextAlignment(TextAlignment.CENTER);
        container.setPadding(new Insets(10, 15, 10, 15));
        topContainer.getChildren().addAll(itemImageView, itemNameText);
        topContainer.setSpacing(10);
        descText.setWrappingWidth(320);
        descText.setTextAlignment(TextAlignment.CENTER);
        descContainer.setAlignment(Pos.CENTER);
        descContainer.setPadding(new Insets(7, 0, 0, 0));
    }

}
