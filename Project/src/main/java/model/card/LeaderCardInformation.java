package model.card;

import controller.ActionController;

import java.lang.reflect.Method;

public enum LeaderCardInformation {
    The_Siegemaster("The Siegemaster","Monsters", null, null);
    String name;
    String faction;
    Runnable ability;
    String imageAddress;

    LeaderCardInformation(String name, String faction, Runnable ability, String imageAddress) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }
}
