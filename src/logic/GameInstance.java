package logic;

import entity.building.Factory;
import entity.building.Minimart;
import entity.building.Shop;
import entity.material.Milk;
import entity.material.Pumpkin;
import entity.material.Wheat;
import entity.material.Wool;

public class GameInstance {
    private Minimart minimart;
    private Shop shop;
    private Factory factory;
    private Player player;

    public GameInstance() {
        minimart = new Minimart();
        shop = new Shop();
        factory = new Factory();
        player = new Player();

        player.addItem(new Wheat(), 5);
        player.addItem(new Pumpkin(), 5);
        player.addItem(new Milk(), 5);
        player.addItem(new Wool(), 5);
    }

    public Minimart getMinimart() {
        return minimart;
    }

    public void setMinimart(Minimart minimart) {
        this.minimart = minimart;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}