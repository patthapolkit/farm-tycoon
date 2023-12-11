package utility;

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

public class Utility {

    public static Item seedToProduct(Seed seed) {
        if (seed instanceof WheatSeed) {
            return new Wheat();
        } else if (seed instanceof BeetrootSeed) {
            return new Beetroot();
        } else if (seed instanceof BerrySeed) {
            return new Berry();
        } else if (seed instanceof CarrotSeed) {
            return new Carrot();
        } else if (seed instanceof DandelionSeed) {
            return new Dandelion();
        } else if (seed instanceof OrchidSeed) {
            return new Orchid();
        } else if (seed instanceof PoppySeed) {
            return new Poppy();
        } else if (seed instanceof PumpkinSeed) {
            return new Pumpkin();
        } else if (seed instanceof TulipSeed) {
            return new Tulip();
        }
        return null;
    }

    public static Seed stringToSeed(String s) {
        if (s.equals("Wheat") || s.equals("Wheat Seed")) {
            return new WheatSeed();
        } else if (s.equals("Beetroot") || s.equals("Beetroot Seed")) {
            return new BeetrootSeed();
        } else if (s.equals("Berry") || s.equals("Berry Seed")) {
            return new BerrySeed();
        } else if (s.equals("Carrot") || s.equals("Carrot Seed")) {
            return new CarrotSeed();
        } else if (s.equals("Dandelion") || s.equals("Dandelion Seed")) {
            return new DandelionSeed();
        } else if (s.equals("Orchid") || s.equals("Orchid Seed")) {
            return new OrchidSeed();
        } else if (s.equals("Poppy") || s.equals("Poppy Seed")) {
            return new PoppySeed();
        } else if (s.equals("Pumpkin") || s.equals("Pumpkin Seed")) {
            return new PumpkinSeed();
        } else if (s.equals("Tulip") || s.equals("Tulip Seed")) {
            return new TulipSeed();
        }
        return null;
    }

    public static String seedToString(Seed s) {
        if (s instanceof WheatSeed) {
            return "Wheat";
        } else if (s instanceof BeetrootSeed) {
            return "Beetroot";
        } else if (s instanceof BerrySeed) {
            return "Berry";
        } else if (s instanceof CarrotSeed) {
            return "Carrot";
        } else if (s instanceof DandelionSeed) {
            return "Dandelion";
        } else if (s instanceof OrchidSeed) {
            return "Orchid";
        } else if (s instanceof PoppySeed) {
            return "Poppy";
        } else if (s instanceof PumpkinSeed) {
            return "Pumpkin";
        } else if (s instanceof TulipSeed) {
            return "Tulip";
        }
        return null;
    }

    public static Product stringToProduct(String s) {
        if (s.equals("Bread")) {
            return new Bread();
        } else if (s.equals("Carrot Pie")) {
            return new CarrotPie();
        } else if (s.equals("Pumpkin Pie")) {
            return new PumpkinPie();
        } else if (s.equals("Sweater")) {
            return new Sweater();
        } else if (s.equals("Cake")) {
            return new Cake();
        }
        return null;
    }

    public static Item stringToItem(String s) {
        if (s.equals("Egg")) {
            return new Egg();
        } else if (s.equals("Milk")) {
            return new Milk();
        } else if (s.equals("Wool")) {
            return new Wool();
        } else if (s.equals("Sweater")) {
            return new Sweater();
        } else if (s.equals("Cake")) {
            return new Cake();
        } else if (s.equals("Wheat")) {
            return new Wheat();
        } else if (s.equals("Beetroot")) {
            return new Beetroot();
        } else if (s.equals("Berry")) {
            return new Berry();
        } else if (s.equals("Carrot")) {
            return new Carrot();
        } else if (s.equals("Dandelion")) {
            return new Dandelion();
        } else if (s.equals("Orchid")) {
            return new Orchid();
        } else if (s.equals("Poppy")) {
            return new Poppy();
        } else if (s.equals("Pumpkin")) {
            return new Pumpkin();
        } else if (s.equals("Tulip")) {
            return new Tulip();
        } else if (s.equals("Bread")) {
            return new Bread();
        } else if (s.equals("Carrot Pie")) {
            return new CarrotPie();
        } else if (s.equals("Pumpkin Pie")) {
            return new PumpkinPie();
        }
        return null;
    }

    public static Animal stringToAnimal(String s) {
        if (s.equals("Chicken")) {
            return new Chicken();
        } else if (s.equals("Cow")) {
            return new Cow();
        } else if (s.equals("Sheep")) {
            return new Sheep();
        }
        return null;
    }

}
