package model;


import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Random;

public class App {
    private static Stage stage;
    private static Game game;
    private static final Random random = new Random();
    private static MediaPlayer mediaPlayer;
    private static final double HEIGHT = 700;
    private static final double WIDTH = 1000;

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        App.mediaPlayer = mediaPlayer;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    public static Stage getStage() {
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
