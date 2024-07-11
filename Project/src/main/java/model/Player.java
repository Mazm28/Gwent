package model;

import server.User;
import Enums.Faction;
import model.card.Card;
import model.card.LeaderCard;

import java.util.ArrayList;

public class Player extends User {
    private final int[] points = new int[3];
    private final ArrayList<Card> burnedCards = new ArrayList<>();
    private final Row[] rows = new Row[3];
    private boolean passed;
    private Faction faction;
    private LeaderCard leader;
    private Deck deck = new Deck();
    private ArrayList<Card> inGameHand = new ArrayList<>();
    private ArrayList<Card> remainCard = new ArrayList<>();
    private ArrayList<Card> buriedCards = new ArrayList<>();
    private int totalPoints;
    private boolean choosedHand;
    private boolean passedTheTurn = false;
    private Card selectedCard;
    private boolean ready = false;
    private final ArrayList<Card> muster = new ArrayList<>();

    public ArrayList<Card> getMuster() {
        return muster;
    }

    public Player(User user) {
        super(user);
        this.faction = Faction.MONSTERS;
        this.remainCard = this.deck.getCards();
        this.choosedHand = false;
        for(int i=0;i<3;i++){
            rows[i] = new Row();
        }
    }

    public Player(){

    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void removeCardFromDeck(Card card) {
        deck.getCards().remove(deck.getCards().indexOf(card));
    }

    public ArrayList<Card> getBurnedCards() {
        return burnedCards;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setReady() {
        ready = true;
    }

    public boolean isReady() {
        return ready;
    }

    public void addToDeck(Card card) {
        this.deck.addToCards(card);
    }

    public void setHand() {
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

    public void setPoints(int round, int points) {
        this.points[round - 1] = points;
    }

    public ArrayList<Card> getInGameHand() {
        return inGameHand;
    }

    public void setInGameHand(ArrayList<Card> inGameHand) {
        this.inGameHand = inGameHand;
    }

    public ArrayList<Card> getRemainCard() {
        return remainCard;
    }

    public void setRemainCard(ArrayList<Card> remainCard) {
        this.remainCard = remainCard;
    }

    public void addToRemainCard(Card card) {
        remainCard.add(card);
    }

    public void removeFromRemainCard(Card card) {
        remainCard.remove(card);
    }

    public void removeFromInGameHand(Card card) {
        inGameHand.remove(card);
    }

    public void addToInGameHand(Card card) {
        inGameHand.add(card);
    }

    public boolean isChoosedHand() {
        return choosedHand;
    }

    public void setChoosedHand(boolean choosedHand) {
        this.choosedHand = choosedHand;
    }

    public boolean isPassedTheTurn() {
        return passedTheTurn;
    }

    public void setBuriedCards(ArrayList<Card> buriedCards) {
        this.buriedCards = buriedCards;
    }

    public void setPassedTheTurn(boolean passedTheTurn) {
        this.passedTheTurn = passedTheTurn;
    }
}
