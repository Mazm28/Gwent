package model.card;

import model.Faction;

import java.util.function.Function;

public enum LeaderCardInformation {
    The_Siegemaster("The Siegemaster",Faction.Monsters, null);
    String name;
    Faction faction;
    String ability;

    LeaderCardInformation(String name, Faction faction, String ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }
}
