package model.card;

import Enums.Faction;

import java.lang.reflect.Method;

public enum RegularCardInformation {
    Ballista("Ballista",6,2,2,null,false,Faction.MONSTERS, null);
    String name;
    int power;
    int countInGame;
    int type;
    Runnable ability;
    boolean hero;
    Faction faction;
    String imageAddress;
    RegularCardInformation(String name, int power, int countInGame, int type, Runnable ability, boolean hero , Faction faction, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.faction = faction;
        this.imageAddress = imageAddress;
    }
}
