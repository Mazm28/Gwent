package model.card;

import Enums.Faction;

import java.util.ArrayList;

public class LeaderCard extends Card{
    private Faction faction;
    private boolean actionUsed;
    private static ArrayList<LeaderCard> allCards = new ArrayList<>();

    public LeaderCard(LeaderCardInformation leaderCardInformation) {
        this.name = leaderCardInformation.name;
        this.faction = leaderCardInformation.faction;
        this.ability = leaderCardInformation.ability;
        this.imageAddress = leaderCardInformation.imageAddress;
        allCards.add(this);
    }

    public static void makeCards(){
        for(LeaderCardInformation leaderCardInformation: LeaderCardInformation.values()){
            LeaderCard leaderCard = new LeaderCard(leaderCardInformation);
        }
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
