package model.card;

import java.lang.reflect.Method;
import java.util.function.Function;

public enum SpecialCardInformation {
    Biting_Frost("Biting_Frost",0,3,4,null, null);

    String name;
    int power;
    int countInGame;
    int type;
    Runnable ability;
    String imageAddress;
    SpecialCardInformation(String name, int power, int countInGame, int type, Runnable ability, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }
}
