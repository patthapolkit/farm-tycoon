package entity.seed;

import logic.NotEnoughBalanceException;
import logic.Player;

public class TulipSeed extends Seed {

    public TulipSeed(){
        super("Tulip Seed", 0, 0, true);
    }

    @Override
    public void collect(Player player) {
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
    }
}
