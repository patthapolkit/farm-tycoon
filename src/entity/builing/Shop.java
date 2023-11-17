package entity.builing;

import entity.animal.Animal;
import entity.animal.Cat;
import entity.animal.Chicken;
import entity.animal.Cow;
import entity.seed.Seed;
import entity.seed.WheatSeed;
import logic.Player;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Seed> allSeed;
    private ArrayList<Animal> allAnimal;

    public Shop() {
        allSeed = new ArrayList<>();
        allSeed.add(new WheatSeed());

        allAnimal = new ArrayList<>();
        allAnimal.add(new Chicken());
        allAnimal.add(new Cow());
        allAnimal.add(new Cat());
    }

    public void unlock(Player player, Seed seed) {
        if (player.getBalance() >= seed.getPrice() && !seed.isUnlocked()) {
            seed.setUnlocked(true);
            player.setBalance(player.getBalance() - seed.getPrice());
        }
    }

    public void buy(Player player, Animal animal) {
        if (player.getBalance() >= animal.getPrice() && player.canAddToCage(animal, 5)) {
            player.getCage().add(animal);
            player.setBalance(player.getBalance() - animal.getPrice());
            if (animal.equals(new Cat())) {
                player.getFlowerPlots().add(new FlowerPlot(null));
            }
        }

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
