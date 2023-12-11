package entity.animal;

import entity.base.Collectable;
import entity.material.Milk;
import entity.material.Wheat;
import logic.Player;

public class Cow extends Animal {

    public Cow() {
        super("Cow", 3000);
    }

    @Override
    public void feed(Player player) {
        if (player.existsInInventory(new Wheat(), 1)) {
            increaseFoodLevel(25);
            player.removeItem(new Wheat(), 1);
        }
    }

    @Override
    public void collect(Player player) {
        if (getFoodLevel() == 100) {
            player.addItem(new Milk(), 1);
            setFoodLevel(0);
        }
    }
}
