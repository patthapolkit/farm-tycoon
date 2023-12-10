package entity.product;

import logic.Player;

public class Sweater extends Product{
    public Sweater(){
        super("Sweater", 0);
    }
    @Override
    public boolean canCraft(Player player) {return true;}

    @Override
    public void craft(Player player) {}
}
