package model.card;

import java.lang.reflect.Method;

public class RegularCards extends Card {
    private String name;
    private int power;
    private int countInGame;
    private int type;
    private Method ability;
    private boolean hero;
    private String faction;

    public RegularCards(RegularCardInformation regularCardInformation) {
        this.name = regularCardInformation.name;
        this.power = regularCardInformation.power;
        this.countInGame = regularCardInformation.countInGame;
        this.type = regularCardInformation.type;
        this.ability = regularCardInformation.ability;
        this.hero = regularCardInformation.hero;
        this.faction = regularCardInformation.faction;
    }
}
