package model.card;

import java.util.ArrayList;

public class SpecialCard extends Card{
    private String type;
    private int power;
    private int countInGame;
    private static ArrayList<Card> allCards = new ArrayList<>();
    public SpecialCard(SpecialCardInformation specialCardInformation) {
        this.name = specialCardInformation.name;
        this.type = specialCardInformation.type;
        this.power = specialCardInformation.power;
        this.countInGame = specialCardInformation.countInGame;
        this.ability = specialCardInformation.ability;
        this.imageAddress = specialCardInformation.imageAddress;
        allCards.add(this);
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }

    public static void makeCards(){
        for(SpecialCardInformation specialCardInformation: SpecialCardInformation.values()){
            SpecialCard specialCard = new SpecialCard(specialCardInformation);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
