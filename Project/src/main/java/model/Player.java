package model;

import model.card.Card;

import java.util.ArrayList;

public class Player extends User{
    private boolean passed;
    private String faction;
    private Card leader;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private int totalPoints;
    private int[] points = new int[3];
    private ArrayList<Card> burnedCards;
    private Row[] rows = new Row[3];
    public Player(String username, String password, String email, String nickname) {
        super(username, password, email, nickname);
    }

    public void addToDeck(Card card){
        this.deck.add(card);
    }
    public void setHand(){
        return;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public Card getLeader() {
        return leader;
    }

    public void setLeader(Card leader) {
        this.leader = leader;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int round,int points) {
        this.points[round] = points;
    }

    public int getCountOfCardsInHand(){
        return hand.size();
    }

}
