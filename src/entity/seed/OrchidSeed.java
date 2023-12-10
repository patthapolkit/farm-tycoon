package entity.seed;

import entity.flower.Orchid;
import logic.Player;

public class OrchidSeed extends Seed {
    public OrchidSeed() {
        super("Orchid Seed", 2500, 0);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Orchid(), 1);
        } else {
            System.out.println("Can't collect " + getName());
        }
    }
}
