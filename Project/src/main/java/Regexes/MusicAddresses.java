package Regexes;

public enum MusicAddresses {
    TOSS_A_COIN_TO_YOUR_WITCHER("/MUSIC/TossACoinToYourWitcher.wav");
    String address;
    MusicAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
