//package application;
//
//import entity.animal.Animal;
//import entity.animal.Cat;
//import entity.animal.Chicken;
//import entity.animal.Cow;
//import entity.builing.Factory;
//import entity.builing.Florist;
//import entity.builing.Market;
//import entity.builing.Shop;
//import entity.seed.Seed;
//import logic.ItemCounter;
//import logic.Player;
//
//import java.util.Scanner;
//
//public class Main {
//    static Market market;
//    static Shop shop;
//    static Florist floristStand;
//    static Factory factory;
//    static Player player;
//    static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        System.out.println("Enter player name:");
//        String playerName = sc.nextLine();
//        setUp(playerName);
//        showMainMenu();
//    }
//
//    private static void setUp(String playerName) {
//        market = new Market();
//        shop = new Shop();
//        factory = new Factory();
//        floristStand = new Florist();
//        player = new Player(playerName);
//    }
//
//    private static void showMainMenu() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("       Select an option");
//            System.out.println("--------------------------------");
//            System.out.println("1. Inventory");
//            System.out.println("2. Shop");
//            System.out.println("3. Market");
//            System.out.println("4. Florist");
//            System.out.println("5. Factory");
//            System.out.println("6. Plot");
//            System.out.println("7. Flower Plot");
//            System.out.println("8. Animal Cage");
//            System.out.println("--------------------------------");
//            System.out.println("0. Exit");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            switch (input) {
//                case "1":
//                    showInventory();
//                    break;
//                case "2":
//                    showShop();
//                    break;
////                case "3":
////                    showMarket();
////                    break;
////                case "4":
////                    showFlorist();
////                    break;
////                case "5":
////                    showFactory();
////                    break;
////                case "6":
////                    showPlot();
////                    break;
////                case "7":
////                    showFlowerPlot();
////                    break;
//                case "8":
//                    showAnimalCage();
//                    break;
//                case "0":
//                    System.out.println("\n	!! EXIT PROGRAM !!");
//                    return;
//                default:
//                    System.out.println("UNKNOWN COMMAND");
//                    break;
//            }
//        }
//    }
//
//    private static void showInventory() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("     " + player.getName() + "'s inventory");
//            System.out.println("            $" + player.getBalance());
//            System.out.println("--------------------------------");
//            for (ItemCounter item : player.getInventory()) {
//                System.out.println(item.getItem().getName());
//            }
//            System.out.println("--------------------------------");
//            System.out.println("0. Exit inventory.");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            if (input.equals("0")) {
//                return;
//            } else {
//                System.out.println("UNKNOWN COMMAND");
//            }
//        }
//    }
//    private static void showShop() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("            Shop");
//            System.out.println("--------------------------------");
//            System.out.println("Select an option");
//            System.out.println("1. Unlock seed");
//            System.out.println("2. Buy animal");
//            System.out.println("--------------------------------");
//            System.out.println("0. Exit Shop");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            switch (input) {
//                case "1":
//                    showSeedToUnlock();
//                    break;
//                case "2":
//                    showAnimalToBuy();
//                    break;
//                case "0":
//                    return;
//                default:
//                    System.out.println("UNKNOWN COMMAND");
//                    break;
//            }
//        }
//    }
//
//    public static void showSeedToUnlock() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("Not unlocked seed");
//            for (Seed seed : shop.getAllSeed()) {
//                if (!seed.isUnlocked()) {
//                    System.out.println(seed);
//                }
//            }
//            System.out.println("--------------------------------");
//            System.out.println("0. Back");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            switch (input) {
////                case "1":
////                    showPlayerBuyingMarket(0);
////                    break;
////                case "2":
////                    showPlayerBuyingMarket(1);
////                    break;
//                case "0":
//                    return;
//                default:
//                    System.out.println("UNKNOWN COMMAND");
//                    break;
//            }
//        }
//    }
//
//    public static void showAnimalToBuy() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("Select animal to buy");
//            System.out.println("1. Chicken");
//            System.out.println("2. Cow");
//            System.out.println("3. Cat");
//            System.out.println("--------------------------------");
//            System.out.println("0. Back");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            switch (input) {
//                case "1":
//                    shop.buy(player, new Chicken());
//                    break;
//                case "2":
//                    shop.buy(player, new Cow());
//                    break;
//                case "3":
//                    shop.buy(player, new Cat());
//                    break;
//                case "0":
//                    return;
//                default:
//                    System.out.println("UNKNOWN COMMAND");
//                    break;
//            }
//        }
//    }
//
//    private static void showAnimalCage() {
//        while (true) {
//            System.out.println("========================================");
//            System.out.println("Animal Cage");
//            for (Animal animal : player.getCage()) {
//                System.out.println(animal.getName());
//            }
//            System.out.println("--------------------------------");
//            System.out.println("0. Back");
//            System.out.println("========================================");
//            String input = (sc.nextLine());
//            if (input.equals("0")) {
//                return;
//            } else {
//                System.out.println("UNKNOWN COMMAND");
//            }
//        }
//    }
//}
