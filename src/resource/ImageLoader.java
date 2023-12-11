package resource;

import entity.animal.Animal;
import entity.animal.Chicken;
import entity.animal.Cow;
import entity.animal.Sheep;
import entity.base.Item;
import entity.flower.Dandelion;
import entity.flower.Orchid;
import entity.flower.Poppy;
import entity.flower.Tulip;
import entity.material.*;
import entity.product.*;
import entity.seed.*;
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

    BREAD("Bread"),
    YELLOW_GROWN("YellowGrown"),
    GREEN_GROWN("GreenGrown"),
    CHICKEN("Chicken1"),
    CHICKEN1("Chicken1"),
    CHICKEN2("Chicken2"),
    CHICKEN3("Chicken3"),
    CHICKEN4("Chicken4"),
    CHICKEN5("Chicken5"),
    COW("Cow1"),
    COW1("Cow1"),
    COW2("Cow2"),
    COW3("Cow3"),
    COW4("Cow4"),
    COW5("Cow5"),
    SHEEP("Sheep4"),
    SHEEP1("Sheep1"),
    SHEEP2("Sheep2"),
    SHEEP3("Sheep3"),
    SHEEP4("Sheep4"),
    SHEEP5("Sheep5"),

    ANIMAL_SQUARE("AnimalSquare"),


    HAND("Hand"),

    CHICKEN_FOOD("ChickenFood"),

    MAIN_BACKGROUND("MainBackground"),

    BARN("Barn"),

    CAGE("Cage"),

    FACTORY("Factory"),

    PLOT("Plot"),

    SHOP("Shop"),

    MART("Mart");

    private final String name;
    private final Image image;

    ImageLoader(String name) {
        this.name = name;
        this.image = new Image("file:src/resource/image/" + name + ".png");
    }

    public static Image getImage(ImageLoader i) {
        return i.image;
    }

    public static ImageView getImageView(ImageLoader i) {
        return new ImageView(i.image);
    }

    public static ImageLoader itemToLoad(Item item) {
        if (item instanceof Beetroot) {
            return BEETROOT;
        } else if (item instanceof Berry) {
            return BERRY;
        } else if (item instanceof Carrot) {
            return CARROT;
        } else if (item instanceof Egg) {
            return EGG;
        } else if (item instanceof Milk) {
            return MILK;
        } else if (item instanceof Wheat) {
            return WHEAT;
        } else if (item instanceof Dandelion) {
            return DANDELION;
        } else if (item instanceof Orchid) {
            return ORCHID;
        } else if (item instanceof Poppy) {
            return POPPY;
        } else if (item instanceof Tulip) {
            return TULIP;
        } else if (item instanceof Pumpkin) {
            return PUMPKIN;
        } else if (item instanceof Bread) {
            return BREAD;
        } else if (item instanceof Cake) {
            return CAKE;
        } else if (item instanceof PumpkinPie) {
            return PUMPKIN_PIE;
        } else if (item instanceof CarrotPie) {
            return CARROT_PIE;
        } else if (item instanceof Sweater) {
            return SWEATER;
        } else if (item instanceof Wool) {
            return WOOL;
        } else {
            return BERRY;
        }
    }

    public static ImageLoader seedToLoad(Seed seed) {
        if (seed instanceof BeetrootSeed) {
            return BEETROOT_SEED;
        } else if (seed instanceof BerrySeed) {
            return BERRY_SEED;
        } else if (seed instanceof CarrotSeed) {
            return CARROT_SEED;
        } else if (seed instanceof WheatSeed) {
            return WHEAT_SEED;
        } else if (seed instanceof DandelionSeed) {
            return DANDELION_SEED;
        } else if (seed instanceof OrchidSeed) {
            return ORCHID_SEED;
        } else if (seed instanceof PoppySeed) {
            return POPPY_SEED;
        } else if (seed instanceof TulipSeed) {
            return TULIP_SEED;
        } else if (seed instanceof PumpkinSeed) {
            return PUMPKIN_SEED;
        } else {
            return BERRY_SEED;
        }
    }

    public static ImageLoader animalToLoad(Animal animal) {
        if (animal instanceof Cow) {
            return COW;
        } else if (animal instanceof Chicken) {
            return CHICKEN;
        } else if (animal instanceof Sheep) {
            return SHEEP;
        }
        return null;
    }
}
