package entity.animal;

import logic.Player;

public class NullAnimal extends Animal {

    public NullAnimal() {
        super("", 0);
    }

    @Override
    public void feed(Player player) {
    }

    @Override
    public void collect(Player player) {

    }
}
