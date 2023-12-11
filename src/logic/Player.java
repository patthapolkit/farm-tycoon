package logic;

import entity.animal.Animal;
import entity.animal.NullAnimal;
import entity.base.Item;
import entity.building.Plot;
import entity.seed.Seed;

import java.util.ArrayList;

public class Player {
    private int balance;
    private ArrayList<ItemCounter> inventory;
    private ArrayList<Plot> plots;
    private ArrayList<Animal> cage;

    public Player() {
        this.balance = 1000;
        this.inventory = new ArrayList<>();
        this.cage = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            cage.add(new NullAnimal());
        }
        this.plots = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            plots.add(new Plot());
        }
    }

    public boolean existsInInventory(Item item, int amount) {
        for (ItemCounter itemCounter : this.inventory) {
            if (itemCounter.getItem().getName().equals(item.getName())) {
                if (itemCounter.getCount() >= amount) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canAddToCage(Animal animal, int amount) {
        int count = 0;
        for (Animal a : this.cage) {
            if (a.getName().equals(animal.getName())) {
                count += 1;
            }
        }
        return count < amount;
    }

    public void addToCage(Animal animal) {
        cage.remove(11);
        cage.add(0, animal);
    }

    public void addItem(Item newItem, int amount) {
        if (amount > 0) {
            boolean isExist = false;
            for (ItemCounter itemCounter : this.inventory) {
                if (itemCounter.getItem().getName().equals(newItem.getName())) {
                    isExist = true;
                    itemCounter.setCount(itemCounter.getCount() + amount);
                    break;
                }
            }
            if (!isExist) {
                ItemCounter itemCounter = new ItemCounter(newItem, amount);
                this.inventory.add(itemCounter);
            }
        }
    }

    public void removeItem(Item toRemove, int amount) {
        if (amount <= 0)
            return;

        ItemCounter itemRemoved = null;
        for (ItemCounter itemCounter : this.inventory) {
            if (itemCounter.getItem().getName().equals(toRemove.getName())) {
                itemCounter.setCount(itemCounter.getCount() - amount);
                itemRemoved = itemCounter;
                break;
            }
        }
        if (itemRemoved != null) {
            if (itemRemoved.getCount() <= 0) {
                this.inventory.remove(itemRemoved);
            }
        }
    }

    public void chargeMoney(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) balance = 0;
        this.balance = balance;
    }

    public ArrayList<Plot> getPlots() {
        return plots;
    }

    public void setPlots(ArrayList<Plot> plots) {
        this.plots = plots;
    }

    public ArrayList<ItemCounter> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<ItemCounter> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Animal> getCage() {
        return cage;
    }

    public void setCage(ArrayList<Animal> cage) {
        this.cage = cage;
    }
}
