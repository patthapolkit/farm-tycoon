package scene;

import component.NavMenu;
import component.OrbitFontText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreditScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;

    private VBox textContainer;


    public CreditScene() {

        // StackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(242, 233, 217), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Credits", 48);
        title.setFill(Color.rgb(86, 76, 54));
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // textContainer setup
        textContainer = new VBox();
        textContainer.setSpacing(2);
        textContainer.setAlignment(Pos.CENTER);
        textContainer.setPadding(new Insets(25, 0, 0, 0));
        textContainer.getChildren().add(new OrbitFontText("Developed by"));
        textContainer.getChildren().add(new OrbitFontText("Nutthapong Dissanont & Patthapol Kittikun", 24));
        textContainer.getChildren().add(new OrbitFontText("Audio from"));
        textContainer.getChildren().add(new OrbitFontText("TBA", 24));
        textContainer.getChildren().add(new OrbitFontText("Images from"));
        textContainer.getChildren().add(new OrbitFontText("HeroIcon", 24));
        textContainer.getChildren().add(new OrbitFontText("as a part of 2110215 Programming Methodology I (Class of 1/2023)"));
        textContainer.getChildren().add(new OrbitFontText("Department of Computer Engineering, Faculty of Engineering,"));
        textContainer.getChildren().add(new OrbitFontText("Chulalongkorn University"));

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer);
        container.getChildren().add(textContainer);
        getChildren().add(container);
    }

}
