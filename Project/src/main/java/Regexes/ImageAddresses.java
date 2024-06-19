package Regexes;

public enum ImageAddresses {
    ICON("/IMAGES/icon.png"),
    SHOW("/IMAGES/closeEye.png"),
    HIDE("/IMAGES/openEye.png"),

    ;
    String address;
    ImageAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
