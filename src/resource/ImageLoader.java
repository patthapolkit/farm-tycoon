package resource;

import entity.base.Item;
import entity.flower.Dandelion;
import entity.flower.Orchid;
import entity.flower.Poppy;
import entity.flower.Tulip;
import entity.material.*;
import entity.product.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum ImageLoader {
    BACKGROUND_HOME("HomeBg"),
    BEETROOT("Beetroot"),
    BERRY("Berry"),
    CARROT("Carrot"),
    DANDELION("Dandelion"),
    EGG("Egg"),
    MILK("Milk"),
    ORCHID("Orchid"),
    POPPY("Poppy"),
    TULIP("Tulip"),
    WHEAT("Wheat"),
    WOOL("Wool"),

    PUMPKIN("Pumpkin"),

    BACK("Icon_Back"),

    PLOT_SQUARE("PlotSquare"),

    WET_PLOT_SQUARE("WetPlotSquare"),
    GREEN_SEED("GreenSeed"),

    GREEN_SEEDLING("GreenSeedling"),

    YELLOW_SEED("YellowSeed"),

    YELLOW_SEEDLING("YellowSeedling"),

    LOCK("Lock"),

    WHEAT_SEED("WheatSeed"),


    BEETROOT_SEED("BeetrootSeed"),

    BERRY_SEED("BerrySeed"),

    CARROT_SEED("CarrotSeed"),
    DANDELION_SEED("DandelionSeed"),

    ORCHID_SEED("OrchidSeed"),

    POPPY_SEED("PoppySeed"),

    TULIP_SEED("TulipSeed"),

    PUMPKIN_SEED("PumpkinSeed"),

    WATERING_POT("WateringPot"),

    SICKLE("Sickle"),

    PUMPKIN_PIE("PumpkinPie"),

    CAKE("Cake"),

    CARROT_PIE("CarrotPie"),

    SWEATER("Sweater"),

    BREAD("Bread")

    ;

    private final String name;
    private final Image image;

    ImageLoader(String name){
        this.name = name;
        this.image = new Image("file:src/resource/image/" + name + ".png");
    }

    public static Image getImage(ImageLoader i){
        return i.image;
    }

    public static ImageView getImageView(ImageLoader i){
        return new ImageView(i.image);
    }

    public static ImageLoader itemToLoad(Item item){
        if (item instanceof Beetroot) {return BEETROOT;}
        else if (item instanceof Berry) {return BERRY;}
        else if (item instanceof Carrot) {return CARROT;}
        else if (item instanceof Egg) {return EGG;}
        else if (item instanceof Milk) {return MILK;}
        else if (item instanceof Wheat) {return WHEAT;}
        else if (item instanceof Dandelion) {return DANDELION;}
        else if (item instanceof Orchid) {return ORCHID;}
        else if (item instanceof Poppy) {return POPPY;}
        else if (item instanceof Tulip) {return TULIP;}
        else if (item instanceof Pumpkin) {return PUMPKIN;}
        else if (item instanceof Bread) {return BREAD;}
        else if (item instanceof Cake) {return CAKE;}
        else if (item instanceof PumpkinPie) {return PUMPKIN_PIE;}
        else if (item instanceof CarrotPie) {return CARROT_PIE;}
        else if (item instanceof Sweater) {return SWEATER;}
        else if (item instanceof Wool) {return WOOL;}
        else {return BERRY;}
    }
}
