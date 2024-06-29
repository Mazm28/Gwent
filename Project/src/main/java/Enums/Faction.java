package Enums;

import java.io.Serializable;

public enum Faction implements Serializable {
    MONSTERS("Monsters","/IMAGES/factions/Monsters.jpg"),
    NILFGAARD("Nilfgaard", "/IMAGES/factions/Nilfgaard.jpg"),
    NORTHERN_REALMS("NorthernRealms", "/IMAGES/factions/NorthernRealms.jpg"),
    SCOIATAEL("Scoiatael", "/IMAGES/factions/Scoiatael.jpg"),
    SKELLIGE("Skellige", "/IMAGES/factions/Skellige.jpg"),
    ;

    final String name;
    final String address;

    Faction(String name, String address) {
        this.name = name;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
