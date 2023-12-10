package entity.building;

import entity.animal.Animal;
import entity.animal.Cat;
import entity.animal.Chicken;
import entity.animal.Cow;
import entity.seed.CarrotSeed;
import entity.seed.Seed;
import entity.seed.WheatSeed;
import logic.Player;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Seed> allSeed;
    private ArrayList<Seed> unlockedSeed;
    private ArrayList<Animal> allAnimal;

    public Shop() {
        allSeed = new ArrayList<>();
        allSeed.add(new WheatSeed());
        allSeed.add(new CarrotSeed());

        unlockedSeed = new ArrayList<>();
        unlockedSeed.add(new WheatSeed());

        allAnimal = new ArrayList<>();
        allAnimal.add(new Chicken());
        allAnimal.add(new Cow());
        allAnimal.add(new Cat());
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
        }
    }

    public void buy(Player player, Animal animal) {
        if (player.getBalance() >= animal.getPrice() && player.canAddToCage(animal, 5)) {
            player.getCage().add(animal);
            player.chargeMoney(animal.getPrice());
            if (animal.getName().equals("Cat")) {
                player.getFlowerPlots().add(new FlowerPlot());
            }
        }

    }

    public ArrayList<Seed> getUnlockedSeed() {
        return unlockedSeed;
    }

    public void setUnlockedSeed(ArrayList<Seed> unlockedSeed) {
        this.unlockedSeed = unlockedSeed;
    }

    public ArrayList<Seed> getAllSeed() {
        return allSeed;
    }

    public void setAllSeed(ArrayList<Seed> allSeed) {
        this.allSeed = allSeed;
    }

    public ArrayList<Animal> getAllAnimal() {
        return allAnimal;
    }

    public void setAllAnimal(ArrayList<Animal> allAnimal) {
        this.allAnimal = allAnimal;
    }
}
