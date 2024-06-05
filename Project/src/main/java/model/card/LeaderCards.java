package model.card;

import java.lang.reflect.Method;

public class LeaderCards extends Card{
    private String name;
    private String faction;
    private Runnable ability;
    private boolean actionUsed;

    public LeaderCards(LeaderCardInformation leaderCardInformation) {
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
