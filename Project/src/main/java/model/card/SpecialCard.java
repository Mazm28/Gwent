package model.card;

public class SpecialCard extends Card{
    private int type;
    private int power;
    private int countInGame;


    public SpecialCard(SpecialCardInformation specialCardInformation) {
        this.name = specialCardInformation.name;
        this.type = specialCardInformation.type;
        this.power = specialCardInformation.power;
        this.countInGame = specialCardInformation.countInGame;
        this.ability = specialCardInformation.ability;
        this.imageAddress = specialCardInformation.imageAddress;
    }
}
