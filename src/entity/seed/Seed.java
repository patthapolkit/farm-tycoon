package entity.seed;

import entity.base.Collectable;
import logic.NotEnoughBalanceException;
import logic.Player;

public abstract class Seed implements Collectable {
    private String name;
    private int price;
    private int humidityLevel;
    private boolean isUnlocked;


    public Seed(String name, int price, int humidityLevel, boolean isUnlocked) {
        this.name = name;
        setPrice(price);
        setHumidityLevel(humidityLevel);
        this.isUnlocked = isUnlocked;
    }

    public abstract void water(Player player) throws NotEnoughBalanceException;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHumidityLevel() {
        return humidityLevel;
    }

    public void setHumidityLevel(int humidityLevel) {
        if (humidityLevel < 0) humidityLevel = 0;
        if (humidityLevel > 100) humidityLevel = 100;
        this.humidityLevel = humidityLevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) price = 0;
        this.price = price;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }
}
