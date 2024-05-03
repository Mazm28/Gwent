package model.card;

import model.Faction;

import java.util.function.Function;

public class LeaderCards extends Card{
    private String name;
    private Faction faction;
    private Function ability;

    public LeaderCards(String name, Faction faction, Function ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }
}
