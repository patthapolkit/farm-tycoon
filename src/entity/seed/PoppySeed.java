package entity.seed;

import logic.NotEnoughBalanceException;
import logic.Player;

public class PoppySeed extends Seed{
    public PoppySeed(){
        super("Poppy Seed", 0, 0, true);
    }
    @Override
    public void collect(Player player) {
    }
    @Override
    public void water(Player player) throws NotEnoughBalanceException {
    }

}
