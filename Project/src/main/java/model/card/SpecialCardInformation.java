package model.card;

import java.lang.reflect.Method;
import java.util.function.Function;

public enum SpecialCardInformation {
    Biting_Frost("Biting_Frost",0,3,4,null);

    String name;
    int power;
    int countInGame;
    int type;
    Runnable ability;
    SpecialCardInformation(String name, int power, int countInGame, int type, Runnable ability) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.ability = ability;
    }
}
