package Enums;

import java.io.Serializable;

public enum Faction implements Serializable {
    MONSTERS("Monsters","/IMAGES/Monsters.jpg"),
    NILFGAARD("Nilfgaard", "/IMAGES/Nilfgaard.jpg"),
    NORTHERN_REALMS("NorthernRealms", "/IMAGES/NorthernRealms.jpg"),
    SCOIATAEL("Scoiatael", "/IMAGES/Scoiatael.jpg"),
    SKELLIGE("Skellige", "/IMAGES/Skellige.jpg"),
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
