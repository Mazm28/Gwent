package model.card;

import java.lang.reflect.Method;

public enum RegularCardInformation {
    Ballista("Ballista",6,2,2,null,false,"Monsters");
    String name;
    int power;
    int countInGame;
    int type;
    Method ability;
    boolean hero;
    String faction;
    RegularCardInformation(String name, int power, int countInGame, int type, Method ability, boolean hero , String faction) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.faction = faction;
    }
}
