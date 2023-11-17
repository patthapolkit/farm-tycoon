package entity.base;

import logic.NotEnoughBalanceException;
import logic.Player;

public interface FastGrowing {
    void fertilize(Player player) throws NotEnoughBalanceException;
}
