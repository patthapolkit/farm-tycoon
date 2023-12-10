package entity.product;

import entity.material.Wheat;
import logic.Player;

public class Bread extends Product{
    public Bread() {
        super("Bread", 50);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Wheat(), 5);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Wheat(), 5);
        player.addItem(new Bread(), 1);
    }
}
