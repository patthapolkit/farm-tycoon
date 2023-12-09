package utility;

import entity.base.Item;
import entity.flower.Dandelion;
import entity.flower.Orchid;
import entity.flower.Poppy;
import entity.flower.Tulip;
import entity.material.*;
import entity.product.*;
import entity.seed.*;
import resource.ImageLoader;

public class Utility {

    public static Item seedToProduct(Seed seed){
        if (seed instanceof WheatSeed) {return new Wheat();}
        else if (seed instanceof BeetrootSeed) {return new Beetroot();}
        else if (seed instanceof BerrySeed) {return new Berry();}
        else if (seed instanceof CarrotSeed) {return new Carrot();}
        else if (seed instanceof DandelionSeed) {return new Dandelion();}
        else if (seed instanceof OrchidSeed) {return new Orchid();}
        else if (seed instanceof PoppySeed) {return new Poppy();}
        else if (seed instanceof PumpkinSeed) {return new Pumpkin();}
        else if (seed instanceof TulipSeed) {return new Tulip();}
        return null;
    }

    public static Seed stringToSeed(String s){
        if (s.equals("Wheat")) {return new WheatSeed();}
        else if (s.equals("Beetroot")) {return new BeetrootSeed();}
        else if (s.equals("Berry")) {return new BerrySeed();}
        else if (s.equals("Carrot")) {return new CarrotSeed();}
        else if (s.equals("Dandelion")) {return new DandelionSeed();}
        else if (s.equals("Orchid")) {return new OrchidSeed();}
        else if (s.equals("Poppy")) {return new PoppySeed();}
        else if (s.equals("Pumpkin")) {return new PumpkinSeed();}
        else if (s.equals("Tulip")) {return new TulipSeed();}
        return null;
    }

    public static Product stringToProduct(String s){
        if (s.equals("Bread")) {return new Bread();}
        else if (s.equals("Carrot Pie")) {return new CarrotPie();}
        else if (s.equals("Pumpkin Pie")) {return new PumpkinPie();}
        else if (s.equals("Sweater")) {return new Sweater();}
        else if (s.equals("Cake")) {return new Cake();}
        return null;
    }
}
