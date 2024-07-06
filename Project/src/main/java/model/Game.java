package model;

import model.card.Card;

import java.util.ArrayList;

public class Game {
    private Player currentPlayer;
    private Player opponent;
    private int turn = 1;
    private int roundNumber = 1;
    private ArrayList<Card> SpecialCards;
    private Round round1;
    private Round round2;
    private Round round3;
    private Round currentRound;
    private final Row[] rows = new Row[6];

    public Round round(int roundNumber){
        return switch (roundNumber) {
            case 1 -> round1;
            case 2 -> round2;
            case 3 -> round3;
            default -> null;
        };
    }

    public Game(Player player_one, Player player_two) {
        this.currentPlayer = player_one;
        this.opponent = player_two;
    }

    public void nextRound(){
        Player temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
        roundNumber++;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void changeTurn() {
        Player temp = currentPlayer;
        this.currentPlayer = this.opponent;
        this.opponent = temp;
        turn++;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public int getTurn() {
        return turn;
    }
}
