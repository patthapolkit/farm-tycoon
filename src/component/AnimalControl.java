package component;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import static resource.ImageLoader.*;

public class AnimalControl extends HBox {

    private String selectedTool;
    private final HScroll toolBox;


    public AnimalControl() {

        toolBox = new HScroll();
        HScrollButton hb1 = new HScrollButton("Hand", getImageView(HAND));
        HScrollButton hb2 = new HScrollButton("ChickenFood", getImageView(CHICKEN_FOOD));
        HScrollButton hb3 = new HScrollButton("Wheat", getImageView(WHEAT));
        toolBox.getButtonContainer().getChildren().addAll(hb1, hb2, hb3);
        for (Node i : toolBox.getButtonContainer().getChildren()) {
            if (i instanceof HScrollButton) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        selectedTool = ((HScrollButton) i).getButtonId();
                        toolBox.updateSelected(selectedTool);
                    }
                });
            }
        }
        getChildren().addAll(toolBox);
        setAlignment(Pos.CENTER);
    }

    public String getSelectedTool() {
        return selectedTool;
    }
}
