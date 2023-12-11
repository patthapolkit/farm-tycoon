package scene;

import component.CashDisplay;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import logic.GameInstance;
import logic.ItemCounter;
import resource.ImageLoader;

import java.util.ArrayList;

import static resource.ImageLoader.getImage;

public class FarmScene extends Pane {
    private final GameInstance gameInstance;
    private CashDisplay cashDisplay;

    private ImageView barn;
    private ImageView shop;
    private ImageView mart;

    private ImageView plot;

    private ImageView cage;

    private ImageView factory;

    public FarmScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
        setPrefSize(800, 450);
        setBackground(new Background(
                new BackgroundImage(getImage(ImageLoader.MAIN_BACKGROUND), BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(
                        800, 450, false, false, false, false))));
        cashDisplaySetup();
        imageViewSetup();
        getChildren().add(shop);
        getChildren().add(barn);
        getChildren().add(mart);
        getChildren().add(plot);
        getChildren().add(cage);
        getChildren().add(factory);
        relocateImageView();
        cursorSetup();
        eventSetup();
    }


    public void updateCashText(int c) {
        cashDisplay.setCashText(c);
    }

    private void imageViewSetup() {
        barn = new ImageView(getImage(ImageLoader.BARN));
        barn.setFitWidth(getImage(ImageLoader.BARN).getWidth() * 0.17);
        barn.setFitHeight(getImage(ImageLoader.BARN).getHeight() * 0.17);
        shop = new ImageView(getImage(ImageLoader.SHOP));
        shop.setFitWidth(getImage(ImageLoader.SHOP).getWidth() * 0.21);
        shop.setFitHeight(getImage(ImageLoader.SHOP).getHeight() * 0.21);
        mart = new ImageView(getImage(ImageLoader.MART));
        mart.setFitWidth(getImage(ImageLoader.MART).getWidth() * 0.18);
        mart.setFitHeight(getImage(ImageLoader.MART).getHeight() * 0.18);
        plot = new ImageView(getImage(ImageLoader.PLOT));
        plot.setFitWidth(getImage(ImageLoader.PLOT).getWidth() * 0.17);
        plot.setFitHeight(getImage(ImageLoader.PLOT).getHeight() * 0.17);
        cage = new ImageView(getImage(ImageLoader.CAGE));
        cage.setFitWidth(getImage(ImageLoader.CAGE).getWidth() * 0.16);
        cage.setFitHeight(getImage(ImageLoader.CAGE).getHeight() * 0.16);
        factory = new ImageView(getImage(ImageLoader.FACTORY));
        factory.setFitWidth(getImage(ImageLoader.FACTORY).getWidth() * 0.17);
        factory.setFitHeight(getImage(ImageLoader.FACTORY).getHeight() * 0.17);
    }

    private void cursorSetup() {
        barn.setCursor(Cursor.HAND);
        shop.setCursor(Cursor.HAND);
        mart.setCursor(Cursor.HAND);
        plot.setCursor(Cursor.HAND);
        cage.setCursor(Cursor.HAND);
        factory.setCursor(Cursor.HAND);
    }

    private void eventSetup() {
        barn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ArrayList<ItemCounter> playerInventory = gameInstance.getPlayer().getInventory();
            int balance = gameInstance.getPlayer().getBalance();
            HomeMenuScene.getRoot().getChildren().add(new BarnScene(playerInventory, balance));
        });
        shop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new ShopScene(gameInstance));
        });
        mart.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new MinimartScene(gameInstance));
        });
        plot.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new PlotScene(gameInstance));
        });
        cage.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new CageScene(gameInstance));
        });
        factory.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new FactoryScene(gameInstance));
        });
    }

    private void cashDisplaySetup() {
        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        getChildren().addAll(cashDisplay);
        cashDisplay.setLayoutX(670);
        cashDisplay.setLayoutY(20);
        cashDisplay.setCashText(gameInstance.getPlayer().getBalance());
    }

    private void relocateImageView() {
        barn.relocate(0, 250);
        shop.relocate(130, 255);
        mart.relocate(200, 305);
        plot.relocate(415, 350);
        cage.relocate(570, 310);
        factory.relocate(415, 130);
    }


}
