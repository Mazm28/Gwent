package Enums;

public enum CheatCodes {
    WIN("win"),
    SUPER_WIN("super win"),
    FUCK_ENEMY("make enemy feel so sad"),
    TRIPLE_POWER("triple power");
    private final String address;
    CheatCodes(String address) {
        this.address = address;
    }

    public String getString() {
        return address;
    }
}
