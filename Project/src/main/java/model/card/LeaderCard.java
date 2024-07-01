package model.card;

import Enums.Faction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaderCard extends Card {
    private Faction faction;
    private boolean actionUsed;

    public LeaderCard(LeaderCardInformation leaderCardInformation) {
        this.name = leaderCardInformation.name;
        this.faction = leaderCardInformation.faction;
        this.ability = leaderCardInformation.ability;
        this.imageAddress = leaderCardInformation.imageAddress;
        this.cardType = "Leader";
    }

    public LeaderCard() {
    }

    public static LeaderCard findCardByName(String name){
        for(Card card: makeCards()) {
            if(card.name.equals(name)) {
                return (LeaderCard) card;
            }
        }
        System.out.println("KOON");
        return null;
    }


    public static ArrayList<Card> makeCards(){
        ArrayList<Card> allCards = new ArrayList<>();
        for(LeaderCardInformation leaderCardInformation: LeaderCardInformation.values()){
            allCards.add(new LeaderCard(leaderCardInformation));
        }
        return allCards;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public boolean isActionUsed() {
        return actionUsed;
    }

    public void setActionUsed(boolean actionUsed) {
        this.actionUsed = actionUsed;
    }
}
