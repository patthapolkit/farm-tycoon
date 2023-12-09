package scene;

import component.InventoryGrid;
import component.NavMenu;
import component.OrbitFontText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class OptionScene extends StackPane {

    private VBox container;

    private OrbitFontText title;

    private VBox titleContainer;

    private StackPane topContainer;

    public OptionScene(){

        // StackPane(this) setup
        setPrefSize(800,450);
        setBackground(new Background(new BackgroundFill(Color.rgb(242,233,217), null, null)));

        // title & titleContainer setup
        title = new OrbitFontText("Options",48);
        title.setFill(Color.rgb(86,76,54));
        titleContainer = new VBox(title);
        titleContainer.setAlignment(Pos.CENTER);

        // topContainer setup
        topContainer = new StackPane();
        topContainer.setAlignment(Pos.CENTER_LEFT);
        topContainer.setPadding(new Insets(15,30,0,30));
        topContainer.getChildren().addAll(titleContainer, new NavMenu());

        // container setup
        container = new VBox();
        container.getChildren().addAll(topContainer);
        getChildren().add(container);

    }


}
