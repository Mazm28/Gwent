package model.card;

import Enums.Faction;

public class RegularCard extends Card {
    private int power;
    private int countInGame;
    private int type;
    private boolean hero;
    private Faction faction;

    public RegularCard(RegularCardInformation regularCardInformation) {
        this.name = regularCardInformation.name;
        this.power = regularCardInformation.power;
        this.countInGame = regularCardInformation.countInGame;
        this.type = regularCardInformation.type;
        this.ability = regularCardInformation.ability;
        this.hero = regularCardInformation.hero;
        this.faction = regularCardInformation.faction;
        this.imageAddress = regularCardInformation.imageAddress;
    }
}
