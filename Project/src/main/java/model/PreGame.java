package model;

import view.PreGameMenu;

public class PreGame {
    private static Game game;
    private static Player player1;
    private static Player player2;
    private static Player turn = player1;
    public static Player getPlayer1() {
        return player1;
    }

    public static Player getTurn() {
        return turn;
    }

    public static void setTurn(Player turn) {
        PreGame.turn = turn;
    }

    public static void setPlayer1(Player player1) {
        PreGame.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        PreGame.player2 = player2;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        PreGame.game = game;
    }
}
