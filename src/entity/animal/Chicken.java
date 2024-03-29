package entity.animal;

import entity.base.Collectable;
import entity.material.Egg;
import logic.Player;

public class Chicken extends Animal {

    public Chicken() {
        super("Chicken", 1000);
    }

    @Override
    public void feed(Player player) {
        increaseFoodLevel(25);
    }

    @Override
    public void collect(Player player) {
        if (getFoodLevel() == 100) {
            player.addItem(new Egg(), 1);
            setFoodLevel(0);
        }
    }
}
