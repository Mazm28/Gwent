package Enums;

public enum ImageAddresses {
    ICON("/IMAGES/icon.png"),
    SHOW("/IMAGES/show.png"),
    HIDE("/IMAGES/hide.png"),
    UNIT("/IMAGES/icons/deck_stats_unit.png"),
    STRENGTH("/IMAGES/icons/deck_stats_strength.png"),
    HERO("/IMAGES/icons/deck_stats_hero.png"),
    SPECIAL("/IMAGES/icons/deck_stats_special.png"),
    COUNT("/IMAGES/icons/deck_stats_count.png"),
    WIN("/IMAGES/icons/end_win.png"),
    LOSE("/IMAGES/icons/end_lose.png"),
    DRAW("/IMAGES/icons/end_draw.png"),
    ;
    private final String address;
    ImageAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
