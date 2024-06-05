package model;


import javafx.stage.Stage;

import java.util.Random;

public class App {
    private static Stage stage;
    private static Game game;
    private static final Random random = new Random();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public static void setGame(Game game) {
        App.game = game;
    }

    public static Game getGame() {
        return game;
    }

    public static Random getRandom() {
        return random;
    }
}
