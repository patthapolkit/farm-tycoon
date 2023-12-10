package entity.animal;

import entity.base.Collectable;
import entity.material.Milk;
import logic.NotEnoughBalanceException;
import logic.Player;

public class Cow extends Animal implements Collectable {

    public Cow() {
        super("Cow", 500);
    }

    @Override
    public void feed(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 20) {
            increaseFoodLevel(5);
            player.chargeMoney(20);
        } else {
            throw new NotEnoughBalanceException();
        }
    }

    @Override
    public void collect(Player player) {
        if (getFoodLevel() == 100) {
            player.addItem(new Milk(), 1);
            setFoodLevel(0);
        }
    }
}
