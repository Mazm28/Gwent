package model.card;

import model.Faction;

import java.util.function.Function;

public class RegularCards extends Card {
    private String name;
    private int power;
    private int countInGame;
    private int type;
    private Function ability;
    private boolean hero;
    private Faction faction;

    public RegularCards(String name, int power, int countInGame, int type, Function ability, boolean hero, Faction faction) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.faction = faction;
    }
}
