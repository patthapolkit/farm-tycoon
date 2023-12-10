package entity.seed;

import entity.flower.Tulip;
import logic.Player;

public class TulipSeed extends Seed {

    public TulipSeed() {
        super("Tulip Seed", 1000, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Tulip(), 1);
        } else {
            System.out.println("Can't collect " + getName());
        }
    }
}
