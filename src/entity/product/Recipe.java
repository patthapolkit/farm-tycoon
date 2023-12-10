package entity.product;

import entity.base.Item;
import entity.material.*;
import javafx.scene.image.Image;
import logic.ItemCounter;
import resource.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

public enum Recipe {


    BREAD(new ArrayList<>(Arrays.asList(new ItemCounter(new Wheat(),3))),
            "Oui! Yum!"
    ),

    SWEATER(new ArrayList<>(Arrays.asList(new ItemCounter(new Wool(),5))),
            "A good friend of you, especially in winter!"
            ),

    CAKE(new ArrayList<>(Arrays.asList(new ItemCounter(new Berry(),5),
            new ItemCounter(new Milk(),5),new ItemCounter(new Egg(),5))),
            "A lovely cake topped with sour berry! It was believed to boost your Java " +
                    "programming speed. "
    ),
    PUMPKIN_PIE(new ArrayList<>(Arrays.asList(new ItemCounter(new Pumpkin(),5),
            new ItemCounter(new Milk(),5),new ItemCounter(new Egg(),5))),
            "A mouth-watering carrot pie. "
    ),
    CARROT_PIE(new ArrayList<>(Arrays.asList(new ItemCounter(new Carrot(),5),
            new ItemCounter(new Milk(),5),new ItemCounter(new Egg(),5))),
            "A delicious carrot pie a day keeps bad luck away!"
    );

    private final ArrayList<ItemCounter> ingredient;

    private final String description;


    Recipe(ArrayList<ItemCounter> ingredient, String description){
        this.ingredient = ingredient;
        this.description = description;
    }

    public ArrayList<ItemCounter> getIngredient() {
        return ingredient;
    }

    public String getDescription() {
        return description;
    }

    public static Recipe getRecipe(String s) {
        if (s.equals("Bread")) {return BREAD;}
        else if (s.equals("Carrot Pie")) {return CARROT_PIE;}
        else if (s.equals("Pumpkin Pie")) {return PUMPKIN_PIE;}
        else if (s.equals("Sweater")) {return SWEATER;}
        else if (s.equals("Cake")) {return CAKE;}
        return null;
    }
}
