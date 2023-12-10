package entity.product;

import entity.material.Carrot;
import entity.material.Egg;
import entity.material.Milk;
import logic.Player;

public class CarrotPie extends Product {

    public CarrotPie() {
        super("Carrot Pie", 1000);
    }

    @Override
    public boolean canCraft(Player player) {
        return player.existsInInventory(new Carrot(), 5) && player.existsInInventory(new Milk(), 5) && player.existsInInventory(new Egg(), 5);
    }

    @Override
    public void craft(Player player) {
        player.removeItem(new Carrot(), 5);
        player.removeItem(new Milk(), 5);
        player.removeItem(new Egg(), 5);
        player.addItem(new CarrotPie(), 1);
    }
}
