package model.card;

import controller.ActionController;

import java.lang.reflect.Method;

public enum LeaderCardInformation {
    The_Siegemaster("The Siegemaster","Monsters", null);
    String name;
    String faction;
    Runnable ability;

    LeaderCardInformation(String name, String faction, Runnable ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }
}
