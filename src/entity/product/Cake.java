package entity.product;

import logic.Player;

public class Cake extends Product {
    public Cake(){
        super("Cake", 0);
    }
    @Override
    public boolean canCraft(Player player) {return true;}

    @Override
    public void craft(Player player) {}
}
