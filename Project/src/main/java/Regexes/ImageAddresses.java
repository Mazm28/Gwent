package Regexes;

public enum ImageAddresses {
    ICON("/IMAGES/icon.png");
    String address;
    ImageAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
