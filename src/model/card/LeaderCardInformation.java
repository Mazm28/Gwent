package model.card;

import model.Faction;

import java.util.function.Function;

public enum LeaderCardInformation {
    The_Siegemaster("The_Siegemaster",Faction.Monsters, null);

    LeaderCardInformation(String name, Faction faction, Function ability) {
    }
}
