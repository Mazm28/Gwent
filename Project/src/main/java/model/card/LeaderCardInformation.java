package model.card;

import Enums.Faction;
import controller.ActionController;

import java.lang.reflect.Method;

public enum LeaderCardInformation {
    The_Siegemaster("The Siegemaster",Faction.MONSTERS, null, null);
    String name;
    Faction faction;
    Runnable ability;
    String imageAddress;

    LeaderCardInformation(String name, Faction faction, Runnable ability, String imageAddress) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }
}
