package model;

import model.card.Card;

import java.util.ArrayList;

public class Game {
    private Player currentPlayer;
    private Player opponent;
    private int roundNumber = 0;
    private ArrayList<Card> SpecialCards;

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


}
