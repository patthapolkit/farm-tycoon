package entity.animal;

import logic.NotEnoughBalanceException;
import logic.Player;

public class Cat extends Animal {
    public Cat() {
        super("Cat", 2000);
    }

    @Override
    public void feed(Player player) throws NotEnoughBalanceException {
        return;
    }
}
