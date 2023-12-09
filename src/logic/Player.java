package logic;

import entity.animal.Animal;
import entity.base.Item;
import entity.building.FlowerPlot;
import entity.building.Plot;

import java.util.ArrayList;

public class Player {
    private String name;
    private int balance;
    private ArrayList<ItemCounter> inventory;
    private ArrayList<Plot> plots;
    private ArrayList<FlowerPlot> flowerPlots;
    private ArrayList<Animal> cage;

    public Player(String name) {
        this.name = name;
        this.balance = 100000;
        this.inventory = new ArrayList<>();
        this.cage = new ArrayList<>();
        this.plots = new ArrayList<>();
        this.flowerPlots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            plots.add(new Plot(null));
        }
    }

    public boolean existsInInventory(Item item, int amount) {
        for (ItemCounter itemCounter : this.inventory) {
            if (itemCounter.getItem().equals(item)) {
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

    public void addItem(Item newItem, int count) {
        if (count > 0) {
            boolean isExist = false;
            for (ItemCounter itemCounter : this.inventory) {
                if (itemCounter.getItem().equals(newItem)) {
                    isExist = true;
                    itemCounter.setCount(itemCounter.getCount() + count);
                    break;
                }
            }
            if (!isExist) {
                ItemCounter itemCounter = new ItemCounter(newItem, count);
                this.inventory.add(itemCounter);
            }
        }
    }

    public void removeItem(Item toRemove, int count) {
        if (count <= 0)
            return;

        ItemCounter itemRemoved = null;
        for (ItemCounter itemCounter : this.inventory) {
            if (itemCounter.getItem().equals(toRemove)) {
                itemCounter.setCount(itemCounter.getCount() - count);
                itemRemoved = itemCounter;
            }
        }
        if (itemRemoved != null) {
            if (itemRemoved.getCount() <= 0) {
                this.inventory.remove(itemRemoved);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<FlowerPlot> getFlowerPlots() {
        return flowerPlots;
    }

    public void setFlowerPlots(ArrayList<FlowerPlot> flowerPlots) {
        this.flowerPlots = flowerPlots;
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
