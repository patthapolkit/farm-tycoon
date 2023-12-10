package component;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import resource.ImageLoader;
import scene.CreditScene;
import scene.HomeMenuScene;

import static resource.ImageLoader.getImage;
import static resource.ImageLoader.getImageView;
import static scene.HomeMenuScene.getRoot;

public class CashDisplay extends HBox {
    private GameButton cashBox;

    private OrbitFontText cashText;

    public CashDisplay(int cash) {
        // backButton setup
        cashBox = new GameButton(110, 60, 20, Color.WHITE);
        cashText = new OrbitFontText("$" + cash,20);
        cashText.setFill(Color.rgb(184,160,89));
        cashBox.getChildren().add(cashText);
        // HBox(this) setup
        getChildren().addAll(cashBox);
        setAlignment(Pos.CENTER_RIGHT);

    }
    public void setCashText(int cash){
        cashText.setText(Integer.toString(cash));
    }

}
