package entity.builing;

import entity.material.Material;
import entity.product.Product;
import logic.Player;

public class Market {
    public Market() {
    }

    public void sell(Player player, Product product, int amount) {
        if (player.existsInInventory(product, amount)) {
            player.removeItem(product, amount);
            player.setBalance(player.getBalance() + (product.getPrice() * amount));
        }
    }

    public void sell(Player player, Material material, int amount) {
        if (player.existsInInventory(material, amount)) {
            player.removeItem(material, amount);
            player.setBalance(player.getBalance() + (material.getPrice() * amount));
        }
    }
}
