package model.card;

public abstract class Card {
    protected String name;
    protected Runnable ability;
    protected String imageAddress;

    public String getImageAddress() {
        return imageAddress;
    }
}
