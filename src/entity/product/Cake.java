package entity.product;

import entity.material.Berry;
import entity.material.Egg;
import entity.material.Milk;
import logic.Player;

public class Cake extends Product {
    public Cake() {
        super("Cake", 1200);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Berry(), 5) && player.existsInInventory(new Milk(), 5) && player.existsInInventory(new Egg(), 5);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Berry(), 5);
        player.removeItem(new Milk(), 5);
        player.removeItem(new Egg(), 5);
        player.addItem(new Cake(), 1);
    }
}
