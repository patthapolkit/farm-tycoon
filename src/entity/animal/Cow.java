package entity.animal;

import entity.base.Collectable;
import entity.material.Milk;
import logic.NotEnoughBalanceException;
import logic.Player;

public class Cow extends Animal implements Collectable {

    public Cow() {
        super("Cow", 1000);
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
            player.addItem(new Milk(), 1);
        }
    }
}
