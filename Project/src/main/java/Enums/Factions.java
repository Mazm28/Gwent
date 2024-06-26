package Enums;

public enum Factions {
    MONSTERS("Monsters"),
    NILFGAARD("Nilfgaard"),
    NORTHERN_REALMS("NorthernRealms"),
    SCOIATAEL("Scoiatael"),
    SKELLIGE("Skellige"),
    SYNDICATE("Syndicate");

    String name;

    Factions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
