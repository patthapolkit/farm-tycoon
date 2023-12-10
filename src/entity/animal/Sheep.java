package entity.animal;

import entity.material.Milk;
import logic.NotEnoughBalanceException;
import logic.Player;

public class Sheep extends Animal{
    public Sheep() {
        super("Sheep", 1000);
    }
    @Override
    public void feed(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 5) {
            this.setFoodLevel(this.getFoodLevel() + 5);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
    public void collect(Player player) {
        if (getFoodLevel() == 100) {
            player.addItem(new Milk(), 1);
        }
    }
}
