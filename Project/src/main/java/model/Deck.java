package model;

import model.card.Card;

import java.util.ArrayList;

public class Deck {
    private String faction;
    private ArrayList<Card> cards = new ArrayList<>();
    private String name = null;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Card card) {
        cards.add(card);
    }
}
