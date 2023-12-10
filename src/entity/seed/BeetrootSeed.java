package entity.seed;

import entity.material.Beetroot;
import logic.Player;

public class BeetrootSeed extends Seed {

    public BeetrootSeed() {
        super("Beetroot Seed", 500, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Beetroot(), 1);
        }
    }
}
