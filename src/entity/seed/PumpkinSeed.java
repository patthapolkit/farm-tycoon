package entity.seed;

import entity.material.Pumpkin;
import logic.Player;

public class PumpkinSeed extends Seed {

    public PumpkinSeed() {
        super("Pumpkin Seed", 100, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Pumpkin(), 1);
        } else {
            System.out.println("Can't collect " + getName());
        }
    }
}
