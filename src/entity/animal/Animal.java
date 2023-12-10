package entity.animal;

import entity.base.Collectable;
import logic.Player;

public abstract class Animal implements Collectable {
    private String name;
    private int foodLevel;
    private int price;

    public Animal(String name, int price) {
        this.name = name;
        this.foodLevel = 0;
        this.price = price;
    }

    public abstract void feed(Player player);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void increaseFoodLevel(int amount) {
        foodLevel += amount;
        if (foodLevel > 100) {
            foodLevel = 100;
        }
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
