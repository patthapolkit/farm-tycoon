package scene;

import component.NavMenu;
import component.OrbitFontText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CageScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;


    public CageScene() {

        // stackPane(this) setup
        setPrefSize(800, 450);
        setBackground(new Background(new BackgroundFill(Color.rgb(207, 154, 122), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Cage", 48);
        title.setFill(Color.WHITE);
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15, 30, 0, 30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer);
        getChildren().add(container);

    }
}

