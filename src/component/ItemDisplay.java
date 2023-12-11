package component;

import entity.base.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.ItemCounter;

import static resource.ImageLoader.*;

public class ItemDisplay extends StackPane {

    private final Rectangle background;

    private final Item itemDisplayed;

    private final ImageView itemImageView;

    private final VBox countContainer;

    private final VBox imageViewContainer;

    private final OrbitFontText countText;

    private int count;

    public ItemDisplay(ItemCounter itemCounter) {

        count = itemCounter.getCount();
        Item item = itemCounter.getItem();
        itemDisplayed = item;

        // countText & countContainer setup
        countText = new OrbitFontText(Integer.toString(count), 16);
        countContainer = new VBox(countText);
        countContainer.setAlignment(Pos.BOTTOM_RIGHT);
        countContainer.setPadding(new Insets(0, 4, 2, 0));

        // background setup
        background = new Rectangle(80, 80, Color.rgb(185, 206, 214));
        background.setArcHeight(20);
        background.setArcWidth(20);

        // itemImage & itemImageView & imageViewContainer setup
        itemImageView = getImageView(itemToLoad(item));
        itemImageView.setFitHeight(50);
        itemImageView.setFitWidth(35);
        imageViewContainer = new VBox(this.itemImageView);
        imageViewContainer.setAlignment(Pos.TOP_CENTER);
        imageViewContainer.setPadding(new Insets(10, 0, 0, 0));
        getChildren().addAll(background, imageViewContainer, countContainer);
    }

    public Item getItemDisplayed() {
        return itemDisplayed;
    }

    public void addCount(int a) {
        count += a;
        countText.setText(Integer.toString(count));
    }

}
