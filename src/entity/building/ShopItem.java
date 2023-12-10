package entity.building;

import entity.base.Item;
import entity.material.*;
import entity.seed.*;
import javafx.scene.image.Image;
import logic.ItemCounter;
import resource.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

public enum ShopItem {


    CARROT_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Carrot."
    ),
    PUMPKIN_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Pumpkin."
    ),

    BEETROOT_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Beetroot."
    ),
    BERRY_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Berry."
    ),
    DANDELION_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Dandelion."
    ),

    POPPY_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Poppy."
    ),

    ORCHID_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Orchid."
    ),
    TULIP_SEED(10,
            "Make one-time purchase to unlock this. Can be grown into Tulip."
    ),

    CHICKEN(10,
            "Purchase to add one into your cage. You can have this animal up to 4."
    ),

    COW(10,
            "Purchase to add one into your cage. You can have this animal up to 4."
    ),

    SHEEP(10,
            "Purchase to add one into your cage. You can have this animal up to 4."
    );


    private final int price;

    private final String description;

    ShopItem(int price, String description){
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static ShopItem getShopItem(String s) {
        if (s.equals("Beetroot Seed")) {return BEETROOT_SEED;}
        else if (s.equals("Berry Seed")) {return BERRY_SEED;}
        else if (s.equals("Carrot Seed")) {return CARROT_SEED;}
        else if (s.equals("Dandelion Seed")) {return DANDELION_SEED;}
        else if (s.equals("Orchid Seed")) {return ORCHID_SEED;}
        else if (s.equals("Poppy Seed")) {return POPPY_SEED;}
        else if (s.equals("Pumpkin Seed")) {return PUMPKIN_SEED;}
        else if (s.equals("Tulip Seed")) {return TULIP_SEED;}
        else if (s.equals("Cow")) { return COW;}
        else if (s.equals("Chicken")) { return CHICKEN;}
        else if (s.equals("Sheep")) { return SHEEP;}
        return null;
    }
}
