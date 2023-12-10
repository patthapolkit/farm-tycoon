package entity.building;

import entity.product.Bread;
import entity.product.Product;
import logic.Player;

import java.util.ArrayList;
import java.util.Map;

public class Factory {
    private ArrayList<Product> allProduct;

    public Factory() {
        this.allProduct = new ArrayList<>();
        this.allProduct.add(new Bread());
    }

    public void craft(Player player, Product product) {
        if (product.canCraft(player)) {
            product.craft(player);
        }
    }

    public ArrayList<Product> getAllProduct() {
        return allProduct;
    }

    public void setAllProduct(ArrayList<Product> allProduct) {
        this.allProduct = allProduct;
    }
}
