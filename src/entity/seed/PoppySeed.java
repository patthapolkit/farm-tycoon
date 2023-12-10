package entity.seed;

import entity.base.FastGrowing;
import entity.flower.Poppy;
import entity.material.Carrot;
import logic.NotEnoughBalanceException;
import logic.Player;

public class PoppySeed extends FlowerSeed {
    public PoppySeed() {
        super("Poppy Seed", 50, 0);
    }

    @Override
    public void collect(Player player) {
        if (isReadyForHarvest()) {
            player.addItem(new Poppy(), 1);
        }
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 10) {
            increaseHumidity(5);
            player.chargeMoney(10);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
}
