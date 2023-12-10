package entity.product;

import entity.material.Wheat;
import logic.Player;

public class Bread extends Product {
    public Bread() {
        super("Bread", 100);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Wheat(), 3);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Wheat(), 3);
        player.addItem(new Bread(), 1);
    }
}
