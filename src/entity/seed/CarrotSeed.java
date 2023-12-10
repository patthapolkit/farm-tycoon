package entity.seed;

import entity.material.Carrot;
import logic.Player;

public class CarrotSeed extends Seed {
    public CarrotSeed() {
        super("Carrot Seed", 100, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Carrot(), 1);
        }
    }
}
