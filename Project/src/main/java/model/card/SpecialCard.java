package model.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecialCard extends Card implements Serializable {
    private String type;
    private int power;
    private int countInGame;
    private boolean hero;

    public SpecialCard(SpecialCardInformation specialCardInformation) {
        this.name = specialCardInformation.name;
        this.type = specialCardInformation.type;
        this.power = specialCardInformation.power;
        this.countInGame = specialCardInformation.countInGame;
        this.ability = specialCardInformation.ability;
        this.imageAddress = specialCardInformation.imageAddress;
        this.hero = specialCardInformation.hero;
        this.cardType = "Special";
    }

    public SpecialCard() {
    }

    public static ArrayList<Card> makeCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        for (SpecialCardInformation specialCardInformation : SpecialCardInformation.values()) {
            for(int i=0;i<specialCardInformation.countInGame;i++) allCards.add(new SpecialCard(specialCardInformation));
        }
        return allCards;
    }

    public boolean isHero() {
        return hero;
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
