package component;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LuckyFontText extends Text {
    public LuckyFontText(String t, Integer s) {
        super(t);
        Font font = Font.loadFont("file:src/resource/font/LuckiestGuy-Regular.ttf", s);
        this.setFont(font);
    }
}
