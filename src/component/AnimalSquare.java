package component;

import entity.animal.*;
import entity.building.Plot;
import entity.seed.NullSeed;
import entity.seed.Seed;
import entity.seed.WheatSeed;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import resource.ImageLoader;


import static resource.ImageLoader.*;
import static utility.Utility.seedToProduct;

public class AnimalSquare extends StackPane {

    private ImageView background;

    private ImageView foreground;

    private int currentStage;

    private Animal animal;


    public AnimalSquare(){
        animal = null;
        currentStage = 0;
        background = new ImageView();
        foreground = new ImageView();
        background.setImage(getImage(ANIMAL_SQUARE));
        background.setFitHeight(65);
        background.setFitWidth(65);
        getChildren().addAll(background);
        setCursor(Cursor.HAND);
    }


    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {

        if (animal instanceof NullAnimal){
            return;
        }
        this.animal = animal;
        if (animal instanceof Chicken){
            foreground = getImageView(CHICKEN1);
        }
        else if (animal instanceof Cow){
            foreground = getImageView(COW1);
        }
        else if (animal instanceof Sheep){
            foreground = getImageView(SHEEP1);
        }
        foreground.setFitHeight(65);
        foreground.setFitWidth(65);
        getChildren().addAll(foreground);

    }


    private void cowNextStage(){
        if (currentStage == 0){
            foreground.setImage(getImage(COW2));
        }
        else if (currentStage == 1){
            foreground.setImage(getImage(COW3));
        }
        else if (currentStage == 2){
            foreground.setImage(getImage(COW4));
        }
        else if (currentStage == 3){
            foreground.setImage(getImage(COW5));
        }
    }

    private void chickenNextStage(){
        if (currentStage == 0){
            foreground.setImage(getImage(CHICKEN2));
        }
        else if (currentStage == 1){
            foreground.setImage(getImage(CHICKEN3));
        }
        else if (currentStage == 2){
            foreground.setImage(getImage(CHICKEN4));
        }
        else if (currentStage == 3){
            foreground.setImage(getImage(CHICKEN5));
        }
    }

    public void sheepNextStage(){
        if (currentStage == 0){
            foreground.setImage(getImage(SHEEP2));
        }
        else if (currentStage == 1){
            foreground.setImage(getImage(SHEEP3));
        }
        else if (currentStage == 2){
            foreground.setImage(getImage(SHEEP4));
        }
        else if (currentStage == 3){
            foreground.setImage(getImage(SHEEP5));
        }

    }

    public void nextStage(){
        if (!animal.equals(null)){
            if (animal instanceof Cow){
                cowNextStage();
            }
            else if (animal instanceof Chicken) {
                chickenNextStage();
            }
            else if (animal instanceof Sheep) {
                sheepNextStage();
            }
            currentStage += 1;
        }
    }

    public Boolean isReady(){
        return (currentStage == 4);
    }

    private void clear(){
        currentStage = 0;
        if (animal instanceof Cow){
            foreground.setImage(getImage(COW1));
        }
        else if (animal instanceof Chicken) {
            foreground.setImage(getImage(CHICKEN1));
        }
        else if (animal instanceof Sheep) {
            foreground.setImage(getImage(SHEEP1));
        }
    }
    public Boolean harvest(){
        if (isReady()){
            clear();
            return true;
        }
        return false;
    }
    public Boolean isOccupied() {
        return !(animal == null);
    }

    public Boolean eatWheat() {
        return (animal instanceof Cow) || (animal instanceof Sheep);
    }
}

