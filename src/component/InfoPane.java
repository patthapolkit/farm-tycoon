package component;

import entity.material.Berry;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import logic.ItemCounter;
import resource.ImageLoader;
import javafx.scene.layout.HBox;

import static resource.ImageLoader.getImageView;

public class CraftingPane extends StackPane {

    private Rectangle background;

    private ImageView itemImageView;

    private OrbitFontText itemNameText;
    private OrbitFontText descText;

    private OrbitFontText matText;
    private VBox matContainer;
    private HBox itemDisContainer;

    private HBox descContainer;

    private VBox container;

    private HBox topContainer;

    private GameButton craftButton;

    public CraftingPane(){

        background = new Rectangle(350,330,Color.rgb(199,211,214));
        background.setArcHeight(40);
        background.setArcWidth(40);

        itemImageView = getImageView(ImageLoader.BERRY);
        itemImageView.setFitWidth(35);
        itemImageView.setFitHeight(50);
        itemNameText = new OrbitFontText("Berry",28);
        itemNameText.setTextAlignment(TextAlignment.CENTER);

        container = new VBox();
        container.setPadding(new Insets(10,15,10,15));

        topContainer = new HBox();
        topContainer.getChildren().addAll(itemImageView,itemNameText);
        topContainer.setSpacing(10);

        descText = new OrbitFontText("Description DescriptionDescri ptionDescriptionDescripti onDescrip tionDescription");
        descText.setWrappingWidth(320);
        descText.setTextAlignment(TextAlignment.CENTER);
        descContainer = new HBox(descText);
        descContainer.setAlignment(Pos.CENTER);
        descContainer.setPadding(new Insets(7 ,0,0,0));

        matText = new OrbitFontText("Materials required",20);
        matContainer = new VBox(matText);
        matContainer.setPadding(new Insets(7,0,15,0));
        matContainer.setAlignment(Pos.TOP_LEFT);
        matContainer.setSpacing(3);

        itemDisContainer = new HBox();
        itemDisContainer.setSpacing(5);
        for (int i=1;i<=3;i++){
            itemDisContainer.getChildren().add(new ItemDisplay(new ItemCounter(new Berry(),10)));
        }
        matContainer.getChildren().add(itemDisContainer);

        craftButton = new GameButton(120,50,20, Color.WHITE);
        craftButton.getChildren().add(new OrbitFontText("Craft",22));


        container.getChildren().addAll(topContainer, descContainer,matContainer,craftButton);

        getChildren().addAll(background, container);
    }


    public void setItemNameText(String s) {
        itemNameText.setText(s);
    }

    public void setItemImage(Image i){
        itemImageView.setImage(i);
    }

    public void setDescText(String s){
        descText.setText(s);
    }

    public HBox getItemDisContainer(){
        return itemDisContainer;
    }

    public GameButton getCraftButton() {
        return craftButton;
    }
}
