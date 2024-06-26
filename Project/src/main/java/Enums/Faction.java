package Enums;

public enum Faction {
    MONSTERS("Monsters"),
    NILFGAARD("Nilfgaard"),
    NORTHERN_REALMS("NorthernRealms"),
    SCOIATAEL("Scoiatael"),
    SKELLIGE("Skellige"),
    SYNDICATE("Syndicate");

    String name;

    Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
