package entity.product;

import entity.material.Wheat;
import logic.Player;

public class PumpkinPie extends Product{

    public PumpkinPie(){
            super("Pumpkin Pie", 0);
    }
    @Override
    public boolean canCraft(Player player) {return true;}

    @Override
    public void craft(Player player) {}
}
