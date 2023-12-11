package entity.building;

import entity.product.Bread;
import entity.product.Product;
import logic.Player;

import java.util.ArrayList;
import java.util.Map;

public class Factory {
    public Factory() {
    }

    public void craft(Player player, Product product) {
        if (product.canCraft(player)) {
            product.craft(player);
        } else {
            System.out.println("Can't craft " + product.getName());
        }
    }
}
