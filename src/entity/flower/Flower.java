package entity.flower;

import entity.base.Item;

public abstract class Flower extends Item {
    private int minSale;
    public Flower(String name, int price, int minSale) {
        super(name, price);
        this.minSale = minSale;
    }

    public int getMinSale() {
        return minSale;
    }

    public void setMinSale(int minSale) {
        this.minSale = minSale;
    }
}
