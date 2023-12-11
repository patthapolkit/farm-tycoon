package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HScroll extends StackPane {

    private final HBox buttonContainer;

    private final Rectangle background;

    private final ScrollPane scrollPane;

    public HScroll() {

        background = new Rectangle(270, 110, Color.rgb(242, 233, 217));
        background.setArcHeight(40);
        background.setArcWidth(40);


        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.TOP_CENTER);

        scrollPane = new ScrollPane();
        scrollPane.setPadding(new Insets(10, 10, 10, 10));
        scrollPane.setContent(buttonContainer);
        scrollPane.setMaxHeight(90);
        scrollPane.setMinWidth(250);
        scrollPane.setMaxWidth(250);
        scrollPane.setStyle("-fx-background: #f2e9d9; -fx-border-color: #f2e9d9;");

        getChildren().addAll(background, scrollPane);
        setAlignment(Pos.CENTER);
    }

    public void updateSelected(String selected) {
        for (Node i : buttonContainer.getChildren()) {
            if (i instanceof HScrollButton) {
                String buttonId = ((HScrollButton) i).getButtonId();
                if (buttonId.equals(selected)) {
                    ((HScrollButton) i).setColor(Color.rgb(238, 209, 116));
                } else {
                    ((HScrollButton) i).setColor(Color.WHITE);
                }
            }
        }
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }
}
