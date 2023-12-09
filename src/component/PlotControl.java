package component;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import static resource.ImageLoader.*;

public class PlotControl extends HBox {


    private String selectedSeed;

    private String selectedTool;


    private HScroll seedBox;

    private HScroll toolBox;


    public PlotControl(){

        seedBox = new HScroll();

        HScrollButton hb1 = new HScrollButton("Wheat", getImageView(WHEAT_SEED));
        HScrollButton hb2 = new HScrollButton("Carrot", getImageView(CARROT_SEED));
        HScrollButton hb3 = new HScrollButton("Pumpkin", getImageView(PUMPKIN_SEED));
        HScrollButton hb4 = new HScrollButton("Beetroot", getImageView(BEETROOT_SEED));
        HScrollButton hb5 = new HScrollButton("Berry", getImageView(BERRY_SEED));
        HScrollButton hb6 = new HScrollButton("Dandelion", getImageView(DANDELION_SEED));
        HScrollButton hb7 = new HScrollButton("Poppy", getImageView(POPPY_SEED));
        HScrollButton hb8 = new HScrollButton("Orchid", getImageView(ORCHID_SEED));
        HScrollButton hb9 = new HScrollButton("Tulip", getImageView(TULIP_SEED));

        seedBox.getButtonContainer().getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8,hb9);

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
        HScrollButton hb13 = new HScrollButton("Tool3", getImageView(WATERING_POT));
        HScrollButton hb14 = new HScrollButton("Tool4", getImageView(WATERING_POT));
        HScrollButton hb15 = new HScrollButton("Tool5", getImageView(WATERING_POT));
        HScrollButton hb16 = new HScrollButton("Tool6", getImageView(WATERING_POT));

        toolBox.getButtonContainer().getChildren().addAll(hb11,hb12,hb13,hb14,hb15,hb16);


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
