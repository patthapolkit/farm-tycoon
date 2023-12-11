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
    private GameInstance gameInstance;
    private CashDisplay cashDisplay;

    public FarmScene(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        setPrefSize(800, 450);
        setBackground(new Background(
                new BackgroundImage(getImage(ImageLoader.MAIN_BACKGROUND), BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(
                        800, 450, false, false, false, false))));

        cashDisplay = new CashDisplay(gameInstance.getPlayer().getBalance());
        getChildren().addAll(cashDisplay);
        cashDisplay.setLayoutX(670);
        cashDisplay.setLayoutY(20);
        cashDisplay.setCashText(gameInstance.getPlayer().getBalance());

        ImageView barn = new ImageView(getImage(ImageLoader.BARN));
        barn.setFitWidth(getImage(ImageLoader.BARN).getWidth() * 0.17);
        barn.setFitHeight(getImage(ImageLoader.BARN).getHeight() * 0.17);


        ImageView shop = new ImageView(getImage(ImageLoader.SHOP));
        shop.setFitWidth(getImage(ImageLoader.SHOP).getWidth() * 0.21);
        shop.setFitHeight(getImage(ImageLoader.SHOP).getHeight() * 0.21);

        ImageView mart = new ImageView(getImage(ImageLoader.MART));
        mart.setFitWidth(getImage(ImageLoader.MART).getWidth() * 0.18);
        mart.setFitHeight(getImage(ImageLoader.MART).getHeight() * 0.18);

        ImageView plot = new ImageView(getImage(ImageLoader.PLOT));
        plot.setFitWidth(getImage(ImageLoader.PLOT).getWidth() * 0.17);
        plot.setFitHeight(getImage(ImageLoader.PLOT).getHeight() * 0.17);

        ImageView cage = new ImageView(getImage(ImageLoader.CAGE));
        cage.setFitWidth(getImage(ImageLoader.CAGE).getWidth() * 0.16);
        cage.setFitHeight(getImage(ImageLoader.CAGE).getHeight() * 0.16);

        ImageView fact = new ImageView(getImage(ImageLoader.FACTORY));
        fact.setFitWidth(getImage(ImageLoader.FACTORY).getWidth() * 0.17);
        fact.setFitHeight(getImage(ImageLoader.FACTORY).getHeight() * 0.17);

        getChildren().add(shop);
        getChildren().add(barn);
        getChildren().add(mart);
        getChildren().add(plot);
        getChildren().add(cage);
        getChildren().add(fact);

        barn.setCursor(Cursor.HAND);
        shop.setCursor(Cursor.HAND);
        mart.setCursor(Cursor.HAND);
        plot.setCursor(Cursor.HAND);
        cage.setCursor(Cursor.HAND);
        fact.setCursor(Cursor.HAND);

        barn.relocate(0, 250);
        shop.relocate(130, 255);
        mart.relocate(200, 305);
        plot.relocate(415, 350);
        cage.relocate(570, 310);
        fact.relocate(415, 130);

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
        fact.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            HomeMenuScene.getRoot().getChildren().add(new FactoryScene(gameInstance));
        });
    }

    public void updateCashText(int c){
        cashDisplay.setCashText(c);
    }


}
