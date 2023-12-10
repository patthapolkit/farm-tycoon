package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import resource.ImageLoader;

import static resource.ImageLoader.getImageView;

public class VScroll extends StackPane {

    private VBox buttonContainer;

    private Rectangle background;

    private ScrollPane scrollPane;

    private String selected;

    private Paint clickedColor;

    public VScroll(Paint clickedColor){

        this.clickedColor = clickedColor;

        background = new Rectangle(220,330, Color.rgb(199,211,214));
        background.setArcHeight(40);
        background.setArcWidth(40);


        buttonContainer = new VBox();
        buttonContainer.setSpacing(18);
        buttonContainer.setAlignment(Pos.CENTER);


        scrollPane = new ScrollPane();
        scrollPane.setPadding(new Insets(10,10,10,10));
        scrollPane.setContent(buttonContainer);
        scrollPane.setMaxHeight(280);
        scrollPane.setMinWidth(200);
        scrollPane.setMaxWidth(200);
        scrollPane.setStyle("-fx-background: #C7D3D6; -fx-border-color: #C7D3D6;");

        getChildren().addAll(background, scrollPane);
        setAlignment(Pos.CENTER);
    }


    public VBox getButtonContainer() {
        return buttonContainer;
    }


    public void updateSelected(String selected){
        this.selected = selected;
        for (Node i: buttonContainer.getChildren()){
            if (i instanceof VScrollButton){
                String buttonId = ((VScrollButton) i).getButtonId();
                if (buttonId == selected){
                    ((VScrollButton) i).setColor(clickedColor);
                }
                else {
                    ((VScrollButton) i).setColor(Color.WHITE);
                }
            }
        }
    }

    public void setBackground(Paint paint, String s){
        background.setFill(paint);
        scrollPane.setStyle("-fx-background: "+s+"; -fx-border-color: "+s+";");
    }
}


