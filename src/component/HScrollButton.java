package component;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class HScrollButton extends GameButton {

    private final String buttonId;

    public HScrollButton(String buttonId, ImageView imgv) {
        super(50, 50, 20, Color.WHITE);
        this.buttonId = buttonId;
        imgv.setFitWidth(40);
        imgv.setFitHeight(40);
        getChildren().add(imgv);
    }

    public String getButtonId() {
        return buttonId;
    }

}
