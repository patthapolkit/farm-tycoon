package entity.product;

import entity.material.Wool;
import logic.Player;

public class Sweater extends Product {
    public Sweater() {
        super("Sweater", 0);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Wool(), 5);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Wool(), 5);
        player.addItem(new Sweater(), 1);
    }
}
