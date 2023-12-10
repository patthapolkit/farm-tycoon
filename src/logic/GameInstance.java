package logic;

import entity.building.Factory;
import entity.building.Market;
import entity.building.Shop;
import entity.material.Pumpkin;
import entity.material.Wheat;

public class GameInstance {
    private Market market;
    private Shop shop;
    private Factory factory;
    private Player player;

    public GameInstance() {
        market = new Market();
        shop = new Shop();
        factory = new Factory();
        player = new Player();

        player.addItem(new Wheat(), 5);
        player.addItem(new Pumpkin(), 5);
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
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