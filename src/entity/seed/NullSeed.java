package entity.seed;

import logic.Player;

public class NullSeed extends Seed{

    public NullSeed(){
        super("", 0, 0);
    }

    @Override
    public void collect(Player player) {
    }
}
