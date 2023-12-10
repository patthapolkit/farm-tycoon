package entity.seed;

import entity.material.Berry;
import logic.Player;

public class BerrySeed extends Seed {
    public BerrySeed() {
        super("Berry Seed", 500, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Berry(), 1);
        } else {
            System.out.println("Can't collect " + getName());
        }
    }
}
