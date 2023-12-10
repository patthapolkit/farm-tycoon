package entity.building;

import entity.animal.Animal;
import entity.animal.Sheep;
import entity.animal.Chicken;
import entity.animal.Cow;
import entity.seed.CarrotSeed;
import entity.seed.Seed;
import entity.seed.WheatSeed;
import logic.Player;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Seed> unlockedSeed;

    public Shop() {
        unlockedSeed = new ArrayList<>();
        unlockedSeed.add(new WheatSeed());
    }

    public boolean isUnlocked(Seed seed) {
        for (Seed unlockedSeed : unlockedSeed) {
            if (seed.getName().equals(unlockedSeed.getName())) {
                return true;
            }
        }
        return false;
    }

    public void unlock(Player player, Seed seed) {
        if (player.getBalance() >= seed.getPrice() && !isUnlocked(seed)) {
            unlockedSeed.add(seed);
            player.chargeMoney(seed.getPrice());
        } else {
            System.out.println("Can't unlock " + seed.getName());
        }
    }

    public void buy(Player player, Animal animal) {
        if (player.getBalance() >= animal.getPrice() && player.canAddToCage(animal, 5)) {
            player.getCage().add(animal);
            player.chargeMoney(animal.getPrice());
        } else {
            System.out.println("Can't buy " + animal.getName());
        }
    }

    public ArrayList<Seed> getUnlockedSeed() {
        return unlockedSeed;
    }

    public void setUnlockedSeed(ArrayList<Seed> unlockedSeed) {
        this.unlockedSeed = unlockedSeed;
    }
}
