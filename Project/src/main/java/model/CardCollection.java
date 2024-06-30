package model;

import Enums.Faction;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.util.ArrayList;

public class CardCollection {
    public static ArrayList<Card> getSpecials(ArrayList<Card> cards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : cards) {
            if (card.getCardType().equals("Special") || ((SpecialCard) card).getType().equals("Weather") && ((SpecialCard) card).getType().equals("Spell")) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static boolean isUnit(Card card) {
        return card.getCardType().equals("Regular") || (card.getCardType().equals("Special") && !((SpecialCard) card).getType().equals("Weather") && !((SpecialCard) card).getType().equals("Spell"));
    }


    public static ArrayList<Card> getLeaders(ArrayList<Card> cards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : cards) {
            if (card.getCardType().equals("Leader")) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static ArrayList<Card> getRegulars(ArrayList<Card> cards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : cards) {
            if (card.getCardType().equals("Regular")) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static ArrayList<Card> getHero(ArrayList<Card> cards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : cards) {
            if (card.getCardType().equals("Regular") && ((RegularCard) card).isHero()) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static ArrayList<Card> getCardByFaction(Faction faction, ArrayList<Card> allCards) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : allCards) {
            if (card.getCardType().equals("Regular") && ((RegularCard) card).getFaction().equals(faction)) {
                cards.add(card);
            }
        }
        return cards;
    }

    public static ArrayList<Card> getUnitCards(ArrayList<Card> allCards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : allCards) {
            if (card.getCardType().equals("Regular") || (card.getCardType().equals("Special") && !((SpecialCard) card).getType().equals("Weather") && !((SpecialCard) card).getType().equals("Spell"))) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static boolean isSpecial(Card card){
        return card.getCardType().equals("Special") || ((SpecialCard) card).getType().equals("Weather") && ((SpecialCard) card).getType().equals("Spell");
    }
}
