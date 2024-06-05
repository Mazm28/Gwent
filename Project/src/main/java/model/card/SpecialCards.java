package model.card;

import model.Game;

import java.lang.reflect.Method;
import java.util.function.Function;

public class SpecialCards extends Card{
    private String name;
    private int type;
    private int power;
    private int countInGame;
    private Runnable ability;


    public SpecialCards(SpecialCardInformation specialCardInformation) {
        this.name = specialCardInformation.name;
        this.type = specialCardInformation.type;
        this.power = specialCardInformation.power;
        this.countInGame = specialCardInformation.countInGame;
        this.ability = specialCardInformation.ability;
    }
}
