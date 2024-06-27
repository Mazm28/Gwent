package model.card;

import Enums.Faction;
import controller.ActionController;
import model.App;

public enum RegularCardInformation {
    KAYRAN("Kayran",8,1,"Agile", ActionController.MoralBoost(),true,Faction.MONSTERS,""),
    ARACHAS("Arachas",4,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    ARACHAS_BEHEMOTH("Arachas Behemoth",6,1,"Siege",ActionController.Muster(),false,Faction.MONSTERS,""),
    CRONE_BREWESS("Crone: Brewess",6,1,"Close",ActionController.CommanderHorn(),false,Faction.MONSTERS,""),
    CRONE_WEAVESS("Crone: Weavess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    CRONE_WHISPESS("Crone: Whispess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    GHOUL("Ghoul",1,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    NEKKER("Nekker",2,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    VAMPIRE_BRUXA("Vampire: Bruxa",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    VAMPIRE_FLEDER("Vampire: Fleder",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    VAMPIRE_GRAKAIN("Vampire: Grakain",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    VAMPIRE_KATAKAN("Vampire: Katakan",5,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,""),
    TOAD("Toad",7,1,"Ranged",ActionController.Scorch(),false,Faction.MONSTERS,""),
    BOTCHLING("Botchling",4,1,"Close",null,false,Faction.MONSTERS,""),
    CELAENO_HARPY("Celaeno Harpy",2,1,"Agile",null,false,Faction.MONSTERS,""),
    COCKATRICE("Cockatrice",2,1,"Ranged",null,false,Faction.MONSTERS,""),
    DRAUG("DRAUG",10,1,"Close",null,true,Faction.MONSTERS,""),
    EARTH_ELEMENTAL("Earth Elemental",6,1,"Siege",null,false,Faction.MONSTERS,""),
    ENDREGA("Endrega",2,1,"Ranged",null,false,Faction.MONSTERS,""),
    FIEND("Fiend",6,1,"Close",null,false,Faction.MONSTERS,""),
    FIRE_ELEMENTAL("Fire Elemental",6,1,"Siege",null,false,Faction.MONSTERS,""),
    FOGLET("Foglet",2,1,"Close",null,false,Faction.MONSTERS,""),
    FORKTAIL("Forktail",5,1,"Close",null,false,Faction.MONSTERS,""),
    
    Ballista("Ballista", 6, 2, 2, null, false, Faction.MONSTERS, null),
    ;
    final String name;
    final int power;
    final int countInGame;
    final String type;
    final Runnable ability;
    final boolean hero;
    final Faction faction;
    final String imageAddress;

    RegularCardInformation(String name, int power, int countInGame, String type, Runnable ability, boolean hero, Faction faction, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.faction = faction;
        this.imageAddress = imageAddress;
    }
}
