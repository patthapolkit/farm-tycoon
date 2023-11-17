package entity.animal;

import entity.base.Collectable;
import entity.material.Egg;
import logic.NotEnoughBalanceException;
import logic.Player;

public class Chicken extends Animal implements Collectable {

    public Chicken() {
        super("Chicken", 300);
    }

    @Override
    public void feed(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 5) {
            this.setFoodLevel(this.getFoodLevel() + 5);
        } else {
            throw new NotEnoughBalanceException();
        }
    }

    @Override
    public void collect(Player player) {
        if (getFoodLevel() == 100) {
            player.addItem(new Egg(), 1);
        }
    }
}
