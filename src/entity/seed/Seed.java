package entity.seed;

import entity.base.Collectable;
import logic.Player;

public abstract class Seed implements Collectable {
    private String name;
    private int price;
    private int humidityLevel;

    public Seed(String name, int price, int humidityLevel) {
        this.name = name;
        setPrice(price);
        setHumidityLevel(humidityLevel);
    }

    public void water(Player player) {
        if (player.getBalance() >= 5 && humidityLevel != 100) {
            increaseHumidity(25);
            player.chargeMoney(5);
        } else {
            System.out.println("Can't water plant. Not enough money.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseHumidity(int amount) {
        humidityLevel += amount;
        if (humidityLevel > 100) {
            humidityLevel = 100;
        }
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
}
