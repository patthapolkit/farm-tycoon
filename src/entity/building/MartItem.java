package entity.building;

public enum MartItem {


    BREAD(100,"Can be obtained from crafting."),
    SWEATER(600,"Can be obtained from crafting."),
    PUMPKIN_PIE(1000,"Can be obtained from crafting."),
    CARROT_PIE(1000,"Can be obtained from crafting."),
    CAKE(1200,"Can be obtained from crafting"),
    EGG(25,"Can be obtained from Chicken"),
    MILK(100,"Can be obtained from Cow"),
    WOOL(100,"Can be obtained from Sheep"),
    WHEAT(25,"Can be obtained from growing Wheat seed."),
    CARROT(25,"Can be obtained from growing Carrot seed."),
    PUMPKIN(25,"Can be obtained from growing Pumpkin seed."),
    BEETROOT(50,"Can be obtained from growing Beetroot seed."),
    BERRY(50,"Can be obtained from growing Berry seed."),
    DANDELION(200,"Can be obtained from growing Dandelion seed."),
    POPPY(100,"Can be obtained from growing Poppy seed."),
    ORCHID(250,"Can be obtained from growing Orchid seed."),
    TULIP(100,"Can be obtained from growing Tulip seed.");

    private final int sellPrice;
    private final String description;


     MartItem (int sellPrice, String description){
        this.description = description;
        this.sellPrice = sellPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public String getDescription() {
        return description;
    }

    public static MartItem getMartItem(String s) {
        if (s.equals("Bread")) {return BREAD;}
        else if (s.equals("Sweater")) {return SWEATER;}
        else if (s.equals("Pumpkin Pie")) {return PUMPKIN_PIE;}
        else if (s.equals("Carrot Pie")) {return CARROT_PIE;}
        else if (s.equals("Cake")) {return CAKE;}
        else if (s.equals("Egg")) {return EGG;}
        else if (s.equals("Milk")) {return MILK;}
        else if (s.equals("Wool")) {return WOOL;}
        else if (s.equals("Wheat")) {return WHEAT;}
        else if (s.equals("Carrot")) {return CARROT;}
        else if (s.equals("Pumpkin")) {return PUMPKIN;}
        else if (s.equals("Beetroot")) {return BEETROOT;}
        else if (s.equals("Berry")) {return BERRY;}
        else if (s.equals("Dandelion")) {return DANDELION;}
        else if (s.equals("Poppy")) {return POPPY;}
        else if (s.equals("Orchid")) {return ORCHID;}
        else if (s.equals("Tulip")) {return TULIP;}
        return null;
    }
}
