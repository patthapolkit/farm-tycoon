package component;

import entity.seed.Seed;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

import static resource.ImageLoader.*;
import static utility.Utility.seedToString;

public class PlotControl extends HBox {


    private String selectedSeed;

    private String selectedTool;

    private final HScroll seedBox;

    private final HScroll toolBox;


    public PlotControl(ArrayList<Seed> unlockedSeed) {
        seedBox = new HScroll();
        seedBoxSetup(unlockedSeed);
        toolBox = new HScroll();
        toolBoxSetup();
        getChildren().addAll(seedBox, toolBox);
        setAlignment(Pos.CENTER);
        setSpacing(30);
    }

    public String getSelectedSeed() {
        return selectedSeed;
    }

    public String getSelectedTool() {
        return selectedTool;
    }

    private void seedBoxSetup(ArrayList<Seed> unlockedSeed) {
        for (Seed i : unlockedSeed) {
            HScrollButton hb = new HScrollButton(seedToString(i), getImageView(seedToLoad(i)));
            seedBox.getButtonContainer().getChildren().add(hb);
        }
        for (Node i : seedBox.getButtonContainer().getChildren()) {
            if (i instanceof HScrollButton) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        selectedSeed = ((HScrollButton) i).getButtonId();
                        seedBox.updateSelected(selectedSeed);
                    }
                });
            }
        }
    }

    private void toolBoxSetup() {
        HScrollButton hb1 = new HScrollButton("Sickle", getImageView(SICKLE));
        HScrollButton hb2 = new HScrollButton("WateringPot", getImageView(WATERING_POT));
        toolBox.getButtonContainer().getChildren().addAll(hb1, hb2);
        for (Node i : toolBox.getButtonContainer().getChildren()) {
            if (i instanceof HScrollButton) {
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        selectedTool = ((HScrollButton) i).getButtonId();
                        toolBox.updateSelected(selectedTool);
                    }
                });
            }
        }
    }


}
