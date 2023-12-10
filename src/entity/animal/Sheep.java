package entity.animal;


import entity.base.Collectable;
import entity.material.Wheat;
import entity.material.Wool;
import logic.Player;

public class Sheep extends Animal implements Collectable {
    public Sheep() {
        super("Sheep", 3000);
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
            player.addItem(new Wool(), 1);
            setFoodLevel(0);
        }
    }

}


