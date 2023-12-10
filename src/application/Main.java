package application;

import entity.animal.Animal;
import entity.animal.Cat;
import entity.animal.Chicken;
import entity.animal.Cow;
import entity.base.FastGrowing;
import entity.builing.*;
import entity.flower.Poppy;
import entity.material.Wheat;
import entity.product.Bread;
import entity.seed.CarrotSeed;
import entity.seed.PoppySeed;
import entity.seed.Seed;
import entity.seed.WheatSeed;
import logic.ItemCounter;
import logic.NotEnoughBalanceException;
import logic.Player;

import java.util.Scanner;

public class Main {
    static Market market;
    static Shop shop;
    static Florist floristStand;
    static Factory factory;
    static Player player;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter player name:");
        String playerName = sc.nextLine();
        setUp(playerName);
        showMainMenu();
    }

    private static void setUp(String playerName) {
        market = new Market();
        shop = new Shop();
        factory = new Factory();
        floristStand = new Florist();
        player = new Player(playerName);

        player.addItem(new Wheat(), 5);
        player.addItem(new Poppy(), 5);
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("========================================");
            System.out.println("       Select an option");
            System.out.println("--------------------------------");
            System.out.println("1. Inventory");
            System.out.println("2. Shop");
            System.out.println("3. Market");
            System.out.println("4. Florist");
            System.out.println("5. Factory");
            System.out.println("6. Plot");
            System.out.println("7. Flower Plot");
            System.out.println("8. Animal Cage");
            System.out.println("--------------------------------");
            System.out.println("0. Exit");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    showInventory();
                    break;
                case "2":
                    showShop();
                    break;
                case "3":
                    showMarket();
                    break;
                case "4":
                    showFlorist();
                    break;
                case "5":
                    showFactory();
                    break;
                case "6":
                    showPlot();
                    break;
                case "7":
                    showFlowerPlot();
                    break;
                case "8":
                    showAnimalCage();
                    break;
                case "0":
                    System.out.println("\n	!! EXIT PROGRAM !!");
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private static void showInventory() {
        while (true) {
            System.out.println("========================================");
            System.out.println("     " + player.getName() + "'s inventory");
            System.out.println("            $" + player.getBalance());
            System.out.println("--------------------------------");
            for (ItemCounter item : player.getInventory()) {
                System.out.println(item.getItem().getName() + " x" + item.getCount());
            }
            System.out.println("--------------------------------");
            System.out.println("0. Exit inventory.");
            System.out.println("========================================");
            String input = (sc.nextLine());
            if (input.equals("0")) {
                return;
            } else {
                System.out.println("UNKNOWN COMMAND");
            }
        }
    }

    private static void showShop() {
        while (true) {
            System.out.println("========================================");
            System.out.println("            Shop");
            System.out.println("--------------------------------");
            System.out.println("Select an option");
            System.out.println("1. Unlock seed");
            System.out.println("2. Buy animal");
            System.out.println("--------------------------------");
            System.out.println("0. Exit Shop");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    showSeedToUnlock();
                    break;
                case "2":
                    showAnimalToBuy();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private static void showMarket() {
        while (true) {
            System.out.println("========================================");
            System.out.println("            Market");
            System.out.println("--------------------------------");
            System.out.println("Select item to sell");
            System.out.println("1. Bread");
            System.out.println("2. Wheat");
            System.out.println("--------------------------------");
            System.out.println("0. Exit Market");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    market.sell(player, new Bread(), 1);
                    break;
                case "2":
                    market.sell(player, new Wheat(), 1);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private static void showFlorist() {
        while (true) {
            System.out.println("========================================");
            System.out.println("            Florist");
            System.out.println("--------------------------------");
            System.out.println("Select bouquet of flowers to sell");
            System.out.println("1. Poppy Bouquet (x5 Poppy)");
            System.out.println("--------------------------------");
            System.out.println("0. Exit Florist");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    floristStand.sell(player, new Poppy(), 1);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private static void showFactory() {
        while (true) {
            System.out.println("========================================");
            System.out.println("            Factory");
            System.out.println("--------------------------------");
            System.out.println("Select what to craft");
            System.out.println("1. Bread");
            System.out.println("--------------------------------");
            System.out.println("0. Exit Factory");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    factory.craft(player, new Bread());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showSeedToUnlock() {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select seed to unlock");
            System.out.println("1. Carrot Seed");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    shop.unlock(player, new CarrotSeed());
                    for (Seed s : shop.getUnlockedSeed()) {
                        System.out.println(s.getName());
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }


    public static void showAnimalToBuy() {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select animal to buy");
            System.out.println("1. Chicken");
            System.out.println("2. Cow");
            System.out.println("3. Cat");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    shop.buy(player, new Chicken());
                    break;
                case "2":
                    shop.buy(player, new Cow());
                    break;
                case "3":
                    shop.buy(player, new Cat());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showPlot() {
        while (true) {
            System.out.println("========================================");
            System.out.println("List of Plot");
            for (Plot plot : player.getPlots()) {
                System.out.println(plot.toString());
            }
            System.out.println("--------------------------------");
            System.out.println("Select plot to plant");
            System.out.println("1. Plot 1");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    if (player.getPlots().get(0).getSeed() == null) {
                        showCropSeedToPlant(0);
                    } else {
                        showWaterCropSeed(0);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showCropSeedToPlant(int index) {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select Crop Seed to plant");
            System.out.println("1. Wheat Seed");
            System.out.println("2. Carrot Seed");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    player.getPlots().get(index).plantSeed(new WheatSeed());
                    break;
                case "2":
                    player.getPlots().get(index).plantSeed(new CarrotSeed());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showWaterCropSeed(int index) {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select option");
            System.out.println("1. Water crop");
            System.out.println("2. Harvest crop");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    try {
                        player.getPlots().get(index).getSeed().water(player);
                    } catch (NotEnoughBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    player.getPlots().get(index).getSeed().collect(player);
                    player.getPlots().get(index).setSeed(null);
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showFlowerPlot() {
        while (true) {
            System.out.println("========================================");
            System.out.println("List of Flower Plot");
            for (FlowerPlot plot : player.getFlowerPlots()) {
                System.out.println(plot.toString());
            }
            System.out.println("--------------------------------");
            System.out.println("Select flower plot to interact with");
            System.out.println("1. Flower Plot 1");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    if (player.getFlowerPlots().get(0).getSeed() == null) {
                        showFlowerSeedToPlant(0);
                    } else {
                        showWaterFlowerSeed(0);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showFlowerSeedToPlant(int index) {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select Flower seed to plant");
            System.out.println("1. Poppy Seed");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    player.getFlowerPlots().get(index).plantFlower(new PoppySeed());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    public static void showWaterFlowerSeed(int index) {
        while (true) {
            System.out.println("========================================");
            System.out.println("Select option");
            System.out.println("1. Water flower");
            System.out.println("2. Collect flower");
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            switch (input) {
                case "1":
                    try {
                        player.getFlowerPlots().get(index).getSeed().water(player);
                    } catch (NotEnoughBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    player.getFlowerPlots().get(index).getSeed().collect(player);
                    player.getFlowerPlots().get(index).setSeed(null);
                case "0":
                    return;
                default:
                    System.out.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private static void showAnimalCage() {
        while (true) {
            System.out.println("========================================");
            System.out.println("Animal Cage");
            for (Animal animal : player.getCage()) {
                System.out.println(animal.getName());
            }
            System.out.println("--------------------------------");
            System.out.println("0. Back");
            System.out.println("========================================");
            String input = (sc.nextLine());
            if (input.equals("0")) {
                return;
            } else {
                System.out.println("UNKNOWN COMMAND");
            }
        }
    }
}
