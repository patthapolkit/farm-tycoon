package entity.seed;

import entity.flower.Dandelion;
import logic.Player;

public class DandelionSeed extends Seed {

    public DandelionSeed() {
        super("Dandelion Seed", 2000, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Dandelion(), 1);
        } else {
            System.out.println("Can't collect " + getName());
        }
    }
}
