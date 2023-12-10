package component;

import entity.seed.Seed;
import entity.seed.WheatSeed;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import resource.ImageLoader;


import static resource.ImageLoader.*;
import static utility.Utility.seedToProduct;

public class PlotSquare extends StackPane {


    private Boolean locked;
    private ImageView background;

    private ImageView foreground;

    private int currentStage;

    private Seed seed;

    public PlotSquare(){
        locked = false;
        seed = null;
        currentStage = 0;
        background = new ImageView();
        foreground = new ImageView();
        background.setImage(getImage(ImageLoader.PLOT_SQUARE));
        background.setFitHeight(65);
        background.setFitWidth(65);
        getChildren().addAll(background);
        setCursor(Cursor.HAND);
    }



    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        if (!locked){
            this.seed = seed;
            if (seed instanceof WheatSeed){
                foreground = getImageView(ImageLoader.YELLOW_SEED);
            }
            else {
                foreground = getImageView(ImageLoader.GREEN_SEED);
            }
            foreground.setFitHeight(65);
            foreground.setFitWidth(65);
            getChildren().addAll(foreground);
        }
    }

    public void nextStage(){
        if (!locked){
            if (!seed.equals(null)){
                if (seed instanceof WheatSeed){
                    if (currentStage == 0){
                        System.out.println("OK");
                        background.setImage(getImage(ImageLoader.WET_PLOT_SQUARE));
                        currentStage += 1;
                    }
                    else if (currentStage == 1){
                        foreground.setImage(getImage(ImageLoader.YELLOW_SEEDLING));
                        currentStage += 1;
                    }
                    else if (currentStage == 2){
                        background.setImage(getImage(ImageLoader.PLOT_SQUARE));
                        foreground.setImage(getImage(ImageLoader.WHEAT));
                        currentStage += 1;
                    }
                }
                else {
                    if (currentStage == 0){
                        background.setImage(getImage(ImageLoader.WET_PLOT_SQUARE));
                        currentStage += 1;
                    }
                    else if (currentStage == 1){
                        foreground.setImage(getImage(ImageLoader.GREEN_SEEDLING));
                        currentStage += 1;
                    }
                    else if (currentStage == 2){
                        background.setImage(getImage(ImageLoader.PLOT_SQUARE));
                        foreground.setImage(getImage(itemToLoad(seedToProduct(seed))));
                        currentStage += 1;
                    }
                }
            }
        }
    }

    public Boolean isReady(){
        return (currentStage == 3);
    }

    private void clear(){
        currentStage = 0;
        seed = null;
        if (background != null){
            background.setImage(getImage(ImageLoader.PLOT_SQUARE));
        }
        if (getChildren().contains(foreground)){
            getChildren().remove(foreground);
        }
    }

    public void harvest(){
        if (isReady()){
            clear();
        }
    }

    public Boolean getLocked() {
        return locked;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
        clear();
        if (locked){
            foreground.setImage(getImage(ImageLoader.LOCK));
            foreground.setFitHeight(65);
            foreground.setFitWidth(65);
            getChildren().add(foreground);
        }
    }

    public Boolean isPlanted() {
        return !(seed == null);
    }

}

