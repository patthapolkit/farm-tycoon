package component;

import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class GameButton extends StackPane {

    private final Rectangle background;
    private OrbitFontText text;

    public GameButton(int w, int h, int corner_r, Paint paint) {
        background = new Rectangle(w, h, paint);
        background.setArcHeight(corner_r);
        background.setArcWidth(corner_r);
        getChildren().add(background);
        setCursor(Cursor.HAND);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        setEffect(dropShadow);
    }

    public GameButton() {

        background = new Rectangle(60, 60, Color.WHITE);
        background.setArcHeight(20);
        background.setArcWidth(20);
        getChildren().add(background);
        setCursor(Cursor.HAND);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        setEffect(dropShadow);
    }

    public void addText(String s, int size, Paint paint) {
        text = new OrbitFontText(s, size);
        text.setFill(paint);
        getChildren().add(text);
    }

    public void setColor(Paint paint) {
        background.setFill(paint);
    }
}
