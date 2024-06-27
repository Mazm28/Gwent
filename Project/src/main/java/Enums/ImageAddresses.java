package Enums;

public enum ImageAddresses {
    ICON("/IMAGES/icon.png"),
    SHOW("/IMAGES/show.png"),
    HIDE("/IMAGES/hide.png"),
    ;
    private final String address;
    ImageAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
