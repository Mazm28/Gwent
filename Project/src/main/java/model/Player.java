package model;

import Enums.Faction;
import model.card.Card;
import model.card.LeaderCard;

import java.util.ArrayList;

public class Player extends User{
    private boolean passed;
    private Faction faction;
    private LeaderCard leader;
    private Deck deck;
    private ArrayList<Card> inGameHand = new ArrayList<>();
    private int totalPoints;
    private int[] points = new int[3];
    private ArrayList<Card> burnedCards;
    private Row[] rows = new Row[3];
    private boolean ready = false;

    public Deck getDeck() {
        if (deck == null) {
            deck = new Deck();
        }
        return deck;
    }

    public ArrayList<Card> getBurnedCards() {
        return burnedCards;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setReady(){
        ready = true;
    }

    public boolean isReady() {
        return ready;
    }

    public Player(User user) {
        super(user);
    }

    public void addToDeck(Card card){
        this.deck.addToCards(card);
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

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public Card getLeader() {
        return leader;
    }

    public void setLeader(LeaderCard leader) {
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

    public ArrayList<Card> getInGameHand() {
        return inGameHand;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
