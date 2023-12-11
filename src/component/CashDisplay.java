package component;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CashDisplay extends HBox {
    private final GameButton cashBox;

    private final OrbitFontText cashText;

    public CashDisplay(int cash) {
        // backButton setup
        cashBox = new GameButton(110, 60, 20, Color.WHITE);
        cashText = new OrbitFontText("$" + cash, 20);
        cashText.setFill(Color.rgb(184, 160, 89));
        cashBox.getChildren().add(cashText);
        // HBox(this) setup
        getChildren().addAll(cashBox);
        setAlignment(Pos.CENTER_RIGHT);

    }

    public void setCashText(int cash) {
        String cashSting = Integer.toString(cash);
        cashText.setText("$" + cashSting);
    }

}
