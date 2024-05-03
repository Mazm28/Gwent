package model;

import java.util.function.Function;

public enum Faction {
    Monsters("Monsters", null);
    String name;
    String ability;
    Faction(String name, Function ability) {
    }
}
