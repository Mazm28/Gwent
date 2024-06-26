package model.card;

import Enums.Faction;

public class LeaderCard extends Card{
    private Faction faction;
    private boolean actionUsed;

    public LeaderCard(LeaderCardInformation leaderCardInformation) {
        this.name = leaderCardInformation.name;
        this.faction = leaderCardInformation.faction;
        this.ability = leaderCardInformation.ability;
    }

    public boolean isActionUsed() {
        return actionUsed;
    }

    public void setActionUsed(boolean actionUsed) {
        this.actionUsed = actionUsed;
    }
}
