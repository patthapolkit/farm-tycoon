package logic;

import entity.base.Item;

public class ItemCounter {
    private Item item;
    private int count;

    public ItemCounter(Item item) {
        setItem(item);
        this.count = 1;
    }

    public ItemCounter(Item item, int count) {
        setItem(item);
        if (count < 1) {
            count = 1;
        }
        setCount(count);
    }

    public String toString() {
        return this.getItem() + " x" + this.getCount();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0) {
            count = 0;
        }
        this.count = count;
    }
}