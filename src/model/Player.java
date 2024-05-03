package model;

import java.util.ArrayList;

public class Player extends User{
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private int totalPoints;
    private int[] points = new int[3];
    private ArrayList<Card> playedCards;
    public Player(String username, String password, String email, String nickname) {
        super(username, password, email, nickname);
    }
}
