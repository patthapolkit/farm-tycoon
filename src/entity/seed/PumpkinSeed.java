package entity.seed;

import logic.NotEnoughBalanceException;
import logic.Player;

public class PumpkinSeed extends Seed{

    public PumpkinSeed(){
        super("Pumpkin Seed", 0, 0, true);
    }

    @Override
    public void collect(Player player) {
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
    }
}
