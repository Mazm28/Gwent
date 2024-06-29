package model.card;

import Enums.Faction;
import controller.ActionController;

import java.io.Serializable;
import java.lang.reflect.Method;

public enum LeaderCardInformation implements Serializable {
    The_Siegemaster("The Siegemaster",Faction.MONSTERS, null, null);
    final String name;
    final Faction faction;
    final Runnable ability;
    final String imageAddress;

    LeaderCardInformation(String name, Faction faction, Runnable ability, String imageAddress) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }

    public String getImageAddress() {
        return imageAddress;
    }
}
