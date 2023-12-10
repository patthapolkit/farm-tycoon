package component;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import resource.ImageLoader;
import scene.CreditScene;
import scene.HomeMenuScene;

import static resource.ImageLoader.getImage;
import static resource.ImageLoader.getImageView;
import static scene.HomeMenuScene.getRoot;

public class NavMenu extends HBox {

    private GameButton backButton;

    public NavMenu() {

        // backButton setup
        backButton = new GameButton();
        ImageView backImageView = getImageView(ImageLoader.BACK);
        backImageView.setFitHeight(40);
        backImageView.setFitWidth(40);
        backButton.getChildren().add(backImageView);

        // backButton event handler
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                System.out.println("Clicked");
                HomeMenuScene.getRoot().getChildren().remove(getParent().getParent().getParent());
            }
        });

        // HBox(this) setup
        getChildren().addAll(this.backButton);
        setAlignment(Pos.CENTER_LEFT);

    }

}
