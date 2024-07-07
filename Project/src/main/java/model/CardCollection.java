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
            if (isSpecial(card)) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static boolean isUnit(Card card) {
        return card.getCardType().equals("Regular") || !isSpecial(card);
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

    public static Card getMostPowered(ArrayList<Card> cards){
        Card card = cards.get(0);
        for(int i=1;i<cards.size();i++){
            if(cards.get(i).getPower() > card.getPower()) card = cards.get(i);
        }
        return card;
    }

    public static ArrayList<Card> getHero(ArrayList<Card> cards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : cards) {
            boolean isHero = false;
            try {
                isHero = ((RegularCard) card).isHero();
            } catch (ClassCastException ignored){

            }
            if (isHero) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static ArrayList<Card> getCardByFaction(Faction faction, ArrayList<Card> allCards) {
        System.out.println(PreGame.getTurn().getFaction().getName());
        ArrayList<Card> cards = new ArrayList<>();
        System.out.println(allCards.size());
        for (Card card : allCards) {
            if (card.getCardType().equals("Regular") && ((RegularCard) card).getFaction().equals(faction)) {
                cards.add(card);
            }
        }
        return cards;
    }
    public static int getCardsTotalStrength(ArrayList<Card> cards){
        int ans = 0;
        for(Card card: cards){
            if(card instanceof RegularCard) {
                ans += ((RegularCard) card).getPower();
            } else if(card instanceof SpecialCard) {
                ans += ((SpecialCard) card).getPower();
            }
        }
        return ans;
    }
    public static ArrayList<Card> getUnitCards(ArrayList<Card> allCards) {
        ArrayList<Card> answer = new ArrayList<>();
        for (Card card : allCards) {
            if (isUnit(card)) {
                answer.add(card);
            }
        }
        return answer;
    }

    public static boolean isSpecial(Card card){
        return card.getCardType().equals("Special") && (((SpecialCard) card).getType().equals("Weather") || ((SpecialCard) card).getType().equals("Spell"));
    }

    public static ArrayList<Card> getNeutralCards(ArrayList<Card> cards){
        ArrayList<Card> neutralCards = new ArrayList<>();
        for(Card card: cards){
            if(card.getCardType().equals("Special")){
                neutralCards.add(card);
            }
        }
        return neutralCards;
    }
}
