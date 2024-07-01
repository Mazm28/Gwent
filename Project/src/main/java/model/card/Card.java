package model.card;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public abstract class Card implements Serializable {
    protected String name;
    @JsonIgnore
    protected Runnable ability;
    protected String imageAddress;
    protected String cardType;

    public Card() {
    }

    public String getCardType() {
        return cardType;
    }

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
