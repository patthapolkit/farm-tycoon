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


    private HScroll seedBox;

    private HScroll toolBox;


    public PlotControl(ArrayList<Seed> unlockedSeed){

        seedBox = new HScroll();

        for (Seed i : unlockedSeed){
            HScrollButton hb = new HScrollButton(seedToString(i), getImageView(seedToLoad(i)));
            seedBox.getButtonContainer().getChildren().add(hb);
        }

        for (Node i : seedBox.getButtonContainer().getChildren()){
            if (i instanceof HScrollButton){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        selectedSeed = ((HScrollButton) i).getButtonId();
                        seedBox.updateSelected(selectedSeed);
                    }
                });
            }
        }

        toolBox = new HScroll();
        HScrollButton hb11 = new HScrollButton("Sickle", getImageView(SICKLE));
        HScrollButton hb12 = new HScrollButton("WateringPot", getImageView(WATERING_POT));

        toolBox.getButtonContainer().getChildren().addAll(hb11,hb12);


        for (Node i : toolBox.getButtonContainer().getChildren()){
            if (i instanceof HScrollButton){
                i.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        selectedTool = ((HScrollButton) i).getButtonId();
                        toolBox.updateSelected(selectedTool);
                    }
                });
            }
        }


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
}
