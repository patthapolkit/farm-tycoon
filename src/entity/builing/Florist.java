package entity.builing;

import entity.flower.Flower;
import logic.Player;

public class Florist {
    public Florist() {
    }

    public void sell(Player player, Flower flower, int amount) {
        if (player.existsInInventory(flower, flower.getMinSale() * amount)) {
            player.removeItem(flower, flower.getMinSale() * amount);
            player.setBalance(player.getBalance() + (flower.getPrice() * flower.getMinSale() * amount));
        }
    }
}
