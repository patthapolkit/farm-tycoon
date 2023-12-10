package entity.seed;

import entity.base.FastGrowing;
import entity.material.Carrot;
import entity.material.Wheat;
import logic.NotEnoughBalanceException;
import logic.Player;

public class CarrotSeed extends CropSeed implements FastGrowing {
    public CarrotSeed() {
        super("Carrot Seed", 10, 0);
    }

    @Override
    public void collect(Player player) {
        if (isReadyForHarvest()) {
            player.addItem(new Carrot(), 1);
        }
    }

    @Override
    public void fertilize(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 20) {
            this.setHumidityLevel((int) (this.getHumidityLevel() * 1.5));
            player.chargeMoney(20);
        } else {
            throw new NotEnoughBalanceException();
        }
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
        if (player.getBalance() >= 5) {
            increaseHumidity(5);
            player.chargeMoney(5);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
}
