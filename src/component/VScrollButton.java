package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class VScrollButton extends GameButton {

    private String buttonId;

    private HBox container;

    private ImageView itemImgView;

    private OrbitFontText itemNameText;

    public VScrollButton(ImageView imageView, String text, String buttonId){
        super(160,50,20, Color.WHITE);
        this.buttonId = buttonId;
        container = new HBox();
        container.setAlignment(Pos.CENTER_LEFT);
        container.setSpacing(10);
        container.setPadding(new Insets(0,0,0,12));
        itemImgView = imageView;
        itemImgView.setFitHeight(43);
        itemImgView.setFitWidth(30);
        itemNameText = new OrbitFontText(text);
        container.getChildren().addAll(itemImgView, itemNameText);
        getChildren().add(container);
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }
}
