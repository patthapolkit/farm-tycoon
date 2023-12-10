package entity.product;

import logic.Player;

public class CarrotPie extends Product {

    public CarrotPie(){
        super("Carrot Pie", 0);
    }
    @Override
    public boolean canCraft(Player player) {return true;}

    @Override
    public void craft(Player player) {}
}
