package model.card;

import model.Faction;

import java.util.function.Function;

public class LeaderCards extends Card{
    private String name;
    private Faction faction;
    private String ability;
    private boolean actionUsed;

    public LeaderCards(String name, Faction faction, String ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }

    public boolean isActionUsed() {
        return actionUsed;
    }

    public void setActionUsed(boolean actionUsed) {
        this.actionUsed = actionUsed;
    }
}
