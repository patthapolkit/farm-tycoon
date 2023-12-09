package entity.seed;

import logic.NotEnoughBalanceException;
import logic.Player;

public class BerrySeed extends Seed {
    public BerrySeed(){
        super("Berry Seed", 0, 0, true);
    }

    @Override
    public void collect(Player player) {
    }

    @Override
    public void water(Player player) throws NotEnoughBalanceException {
    }
}
