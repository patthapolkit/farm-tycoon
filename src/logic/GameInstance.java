package logic;

import entity.building.Factory;
import entity.building.Market;
import entity.building.Shop;

public class GameLogic {
    static Market market;
    static Shop shop;
    static Factory factory;
    static Player player;

    public GameLogic() {
        market = new Market();
        shop = new Shop();
        factory = new Factory();
        player = new Player("playerName");
    }

    public static Market getMarket() {
        return market;
    }

    public static void setMarket(Market market) {
        GameLogic.market = market;
    }

    public static Shop getShop() {
        return shop;
    }

    public static void setShop(Shop shop) {
        GameLogic.shop = shop;
    }

    public static Factory getFactory() {
        return factory;
    }

    public static void setFactory(Factory factory) {
        GameLogic.factory = factory;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        GameLogic.player = player;
    }
}