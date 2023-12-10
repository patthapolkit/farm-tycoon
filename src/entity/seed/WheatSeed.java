package entity.seed;

import entity.base.FastGrowing;
import entity.material.Wheat;
import logic.NotEnoughBalanceException;
import logic.Player;

public class WheatSeed extends Seed implements FastGrowing {
    public WheatSeed() {
        super("Wheat Seed", 0, 0, true);
    }

    @Override
    public void collect(Player player) {
        if (getHumidityLevel() == 100) {
            player.addItem(new Wheat(), 1);
        }
    }

    @Override
    public void fertilize(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 20) {
            this.setHumidityLevel((int) (this.getHumidityLevel() * 1.5));
        } else {
            throw new NotEnoughBalanceException();
        }
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 5) {
            this.setHumidityLevel(this.getHumidityLevel() + 25);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
}
