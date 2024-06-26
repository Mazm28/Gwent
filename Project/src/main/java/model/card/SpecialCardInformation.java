package model.card;

import java.lang.reflect.Method;
import java.util.function.Function;

public enum SpecialCardInformation {
    Biting_Frost("Biting_Frost",0,3,4,null, null);
    final String name;
    final int power;
    final int countInGame;
    int type;
    final Runnable ability;
    final String imageAddress;
    SpecialCardInformation(String name, int power, int countInGame, int type, Runnable ability, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }
}
