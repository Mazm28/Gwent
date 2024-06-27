package model.card;

public abstract class Card {
    protected String name;
    protected Runnable ability;
    protected String imageAddress;

    public String getImageAddress() {
        return this.imageAddress;
    }

    public String getName() {
        return name;
    }

    public Runnable getAbility() {
        return ability;
    }
}
