package model.card;

import Enums.Faction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegularCard extends Card {
    private int countInGame;
    private String type;
    private boolean hero;
    private Faction faction;
    private RegularCardInformation regularCardInformation;

    public RegularCardInformation getRegularCardInformation() {
        return regularCardInformation;
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
        this.regularCardInformation = regularCardInformation;
        this.cardType = "Regular";
    }

    public RegularCard() {
    }

    public static ArrayList<Card> makeCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        for (RegularCardInformation regularCardInformation : RegularCardInformation.values()) {
            for (int i = 0; i < regularCardInformation.countInGame; i++)
                allCards.add(new RegularCard(regularCardInformation));
        }
        return allCards;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
