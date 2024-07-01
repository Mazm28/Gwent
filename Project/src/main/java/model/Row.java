package model;

import model.card.Card;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {
    private final ArrayList<Card> cards = new ArrayList<>();
    private Card improveCard;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getImproveCard() {
        return improveCard;
    }

    public void addCardToCards(Card card){
        this.cards.add(card);
    }

    public void setImproveCard(Card improveCard) {
        this.improveCard = improveCard;
    }
}
