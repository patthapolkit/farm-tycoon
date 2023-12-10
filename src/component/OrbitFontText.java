package component;

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OrbitFontText extends Text {

    public OrbitFontText(String t, Integer s, Paint paint){
        super(t);
        Font font = Font.loadFont("file:src/resource/font/FCOrbit.ttf",s);
        setFont(font);
        setFill(paint);
    }
    public OrbitFontText(String t, Integer s){
        super(t);
        Font font = Font.loadFont("file:src/resource/font/FCOrbit.ttf",s);
        setFont(font);
    }
    public OrbitFontText(String t){
        super(t);
        Font font = Font.loadFont("file:src/resource/font/FCOrbit.ttf",16);
        setFont(font);
    }
}
