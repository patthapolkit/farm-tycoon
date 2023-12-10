package entity.seed;

import entity.material.Wheat;
import logic.Player;

public class WheatSeed extends Seed {
    public WheatSeed() {
        super("Wheat Seed", 0, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Wheat(), 1);
        }
    }
}
