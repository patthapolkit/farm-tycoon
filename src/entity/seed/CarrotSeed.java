package entity.seed;

import logic.NotEnoughBalanceException;
import logic.Player;

public class CarrotSeed extends Seed{

    public CarrotSeed(){
            super("Carrot Seed", 0, 0, true);
    }

    @Override
    public void collect(Player player) {
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
    }
}
