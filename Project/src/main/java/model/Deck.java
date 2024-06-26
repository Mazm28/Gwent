package model;

import Enums.Faction;
import model.card.Card;
import model.card.LeaderCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Deck implements Serializable {
    private ArrayList<Card> cards = new ArrayList<>();
    private String name = null;
    private Faction Faction;
    private LeaderCard leaderCard;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addToCards(Card card){
        cards.add(card);
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faction getFaction() {
        return Faction;
    }

    public void setFaction(Faction faction) {
        Faction = faction;
    }

    public LeaderCard getLeaderCard() {
        return leaderCard;
    }

    public void setLeaderCard(LeaderCard leaderCard) {
        this.leaderCard = leaderCard;
    }
}
