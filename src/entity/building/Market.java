package entity.building;

import entity.material.Material;
import entity.product.Product;
import logic.Player;

public class Market {
    public Market() {
    }

    public void sell(Player player, Product product, int amount) {
        player.removeItem(product, amount);
        player.setBalance(player.getBalance() + (product.getPrice() * amount));
    }

    public void sell(Player player, Material material, int amount) {
        player.removeItem(material, amount);
        player.setBalance(player.getBalance() + (material.getPrice() * amount));
    }
}