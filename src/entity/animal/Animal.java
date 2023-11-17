package entity.animal;

import logic.NotEnoughBalanceException;
import logic.Player;

public abstract class Animal {
    private String name;
    private int foodLevel;
    private int price;

    public Animal(String name, int price) {
        this.name = name;
        this.foodLevel = 0;
        this.price = price;
    }

    public abstract void feed(Player player) throws NotEnoughBalanceException;

    public boolean canBuy(Player player) {
        return player.getBalance() >= this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        if (foodLevel < 0) foodLevel = 0;
        if (foodLevel > 100) foodLevel = 100;
        this.foodLevel = foodLevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
