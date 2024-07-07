package model.card;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public abstract class Card implements Serializable {
    protected String name;
    @JsonIgnore
    protected Runnable ability;
    protected String imageAddress;
    protected String cardType;
    protected int power;

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbility(Runnable ability) {
        this.ability = ability;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setPower(int power) {
        this.power = power;
    }

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
