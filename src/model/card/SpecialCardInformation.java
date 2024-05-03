package model.card;

import model.Action;

import java.util.function.Function;

public enum SpecialCardInformation {
    Biting_Frost("Biting_Frost",0,3,4,null);

    String name;
    int power;
    int countInGame;
    int type;
    Function ability;
    SpecialCardInformation(String name, int power, int countInGame, int type, Function ability) {

    }
}
