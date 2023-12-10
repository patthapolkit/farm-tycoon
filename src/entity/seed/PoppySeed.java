package entity.seed;

import entity.flower.Poppy;
import logic.Player;

public class PoppySeed extends Seed {
    public PoppySeed() {
        super("Poppy Seed", 1000, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Poppy(), 1);
        }
    }
}
