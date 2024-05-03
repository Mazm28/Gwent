package model.card;

import model.Faction;

import java.util.function.Function;

public enum RegularCardInformation {
    Ballista("Ballista",6,2,2,null,false,Faction.Monsters);

    RegularCardInformation(String ballista, int power, int countInGame, int type, Function ability, boolean isHero , Faction faction) {
    }
}
