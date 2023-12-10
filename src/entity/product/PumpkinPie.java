package entity.product;

import entity.material.Egg;
import entity.material.Milk;
import entity.material.Pumpkin;
import logic.Player;

public class PumpkinPie extends Product {

    public PumpkinPie() {
        super("Pumpkin Pie", 0);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Pumpkin(), 5) && player.existsInInventory(new Milk(), 5) && player.existsInInventory(new Egg(), 5);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Pumpkin(), 5);
        player.removeItem(new Milk(), 5);
        player.removeItem(new Egg(), 5);
        player.addItem(new PumpkinPie(), 1);
    }
}
