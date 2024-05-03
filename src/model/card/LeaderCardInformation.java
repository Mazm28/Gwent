package model.card;

import java.lang.reflect.Method;

public enum LeaderCardInformation {
    The_Siegemaster("The Siegemaster","Monsters", null);
    String name;
    String faction;
    Method ability;

    LeaderCardInformation(String name, String faction, Method ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }
}
