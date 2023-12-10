package entity.building;

import entity.base.Item;
import logic.Player;

public class Minimart {
    public Minimart() {
    }

    public void sell(Player player, Item item, int amount) {
        if (player.existsInInventory(item, amount)) {
            player.removeItem(item, amount);
            player.setBalance(player.getBalance() + (item.getPrice() * amount));
        } else {
            System.out.println(item.getName() + " doesn't exists");
        }
    }
}
