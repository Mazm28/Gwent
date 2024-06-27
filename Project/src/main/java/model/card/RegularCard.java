package model.card;

import Enums.Faction;

import java.util.ArrayList;

public class RegularCard extends Card {
    private int power;
    private int countInGame;
    private int type;
    private boolean hero;
    private Faction faction;
    private static ArrayList<RegularCard> allCards = new ArrayList<>();

    public static ArrayList<RegularCard> getAllCards() {
        return allCards;
    }

    public static void makeCards(){
        for(RegularCardInformation regularCardInformation: RegularCardInformation.values()){
            RegularCard regularCard = new RegularCard(regularCardInformation);
        }
    }

    public static ArrayList<Card> getCardsFromFaction(Faction faction){
        ArrayList<Card> regularCards = new ArrayList<>();
        for(RegularCard regularCard: allCards){
            if(regularCard.faction.equals(faction)){
                regularCards.add(regularCard);
            }
        }
        return regularCards;
    }
    public RegularCard(RegularCardInformation regularCardInformation) {
        this.name = regularCardInformation.name;
        this.power = regularCardInformation.power;
        this.countInGame = regularCardInformation.countInGame;
        this.type = regularCardInformation.type;
        this.ability = regularCardInformation.ability;
        this.hero = regularCardInformation.hero;
        this.faction = regularCardInformation.faction;
        this.imageAddress = regularCardInformation.imageAddress;
        allCards.add(this);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCountInGame() {
        return countInGame;
    }

    public void setCountInGame(int countInGame) {
        this.countInGame = countInGame;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHero() {
        return hero;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }
}
