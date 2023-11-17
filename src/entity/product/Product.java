package entity.product;

import entity.base.Item;
import logic.Player;

public abstract class Product extends Item {
    public Product(String name, int price) {
        super(name, price);
    }

    public abstract boolean canCraft(Player player);

    public abstract void craft(Player player);
}
