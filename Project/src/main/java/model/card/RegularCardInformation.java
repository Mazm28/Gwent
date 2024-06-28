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
    FRIGHTENER("Frightener",5,1,"Close",null,false,Faction.MONSTERS,""),
    GARGOYLE("Gargoyle",5,1,"Ranged",null,false,Faction.MONSTERS,""),
    GRAVE_HAG("Grave Hag",5,1,"Ranged",null,false,Faction.MONSTERS,""),
    GRIFFIN("Griffin",5,1,"Close",null,false,Faction.MONSTERS,""),
    HARPY("Harpy",2,1,"Agile",null,false,Faction.MONSTERS,""),
    ICE_GIANT("Ice Giant",5,1,"Siege",null,false,Faction.MONSTERS,""),
    IMLERITH("Imlerith",10,1,"Close",null,true,Faction.MONSTERS,""),
    LESHEN("Leshen",10,1,"Close",null,true,Faction.MONSTERS,""),
    PLAGUE_MAIDEN("Plague Maiden",5,1,"Close",null,false,Faction.MONSTERS,""),
    WEREWOLF("Were Wolf",5,1,"Close",null,false,Faction.MONSTERS,""),
    WYVERN("Wyvern",2,1,"Ranged",null,false,Faction.MONSTERS,""),
    Impera_Brigade_Guard("Impera_Brigade_Guard", 3, 4, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, ""),
    Stefan_Skellen("Stefan_Skellen", 9, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, ""),
    Shilard_Fitz_Oesterlen("Shilard_Fitz_Oesterlen", 7, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, ""),
    Young_Emissary("Young_Emissary", 5, 2, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, ""),
    Cahir_Mawr_Dyffryn_Aep_Ceallach("Cahir_Mawr_Dyffryn_Aep_Ceallach", 6, 1, "Close", null, false, Faction.NILFGAARD, ""),
    Vattier_De_Rideaux("Vattier_De_Rideaux", 4, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, ""),
    Menno_Coehorn("Menno_Coehorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, ""),
    Puttkammer("Puttkammer", 4, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Assire_Var_Anahid("Assire_Var_Anahid", 6, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Black_Infantry_Archer("Black_Infantry_Archer", 10, 2, "Ranged", null, false, Faction.NILFGAARD, ""),
    Tibor_Eggebracht("Tibor_Eggebracht", 10, 1, "Ranged", null, true, Faction.NILFGAARD, ""),
    Renuald_Aep_Matsen("Renuald_Aep_Matsen", 5, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Fringilla_Vigo("Fringilla_Vigo", 6, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Rotten_Mangonel("Rotten_Mangonel", 3, 1, "Siege", null, false, Faction.NILFGAARD, ""),
    Heavy_Zerrikanian_Fire_Scorpion("Heavy_Zerrikanian_Fire_Scorpion", 10, 1, "Siege", null, false, Faction.NILFGAARD, ""),
    Zerrikanian_Fire_Scorpion("Zerrikanian_Fire_Scorpion", 5, 1, "Siege", null, false, Faction.NILFGAARD, ""),
    Siege_Engineer("Siege_Engineer", 6, 1, "Siege", null, false, Faction.NILFGAARD, ""),
    Morvran_Voorhis("Morvran_Voorhis", 10, 1, "Siege", null, true, Faction.NILFGAARD, ""),
    Albrich("Albrich", 2, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Cynthia("Cynthia", 4, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Etolian_Auxiliary_Archers("Etolian_Auxiliary_Archers", 1, 2, "Ranged", ActionController.Medic(), true, Faction.NILFGAARD, ""),
    Letho_Of_Gulet("Letho_Of_Gulet", 10, 1, "Close", null, true, Faction.NILFGAARD, ""),
    Menno_Coehoorn("Menno_Coehoorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, ""),
    Morteisen("Morteisen", 3, 1, "Close", null, false, Faction.NILFGAARD, ""),
    Nausicaa_Cavalry_Rider("Nausicaa_Cavalry_Rider", 2, 3, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, ""),
    Rainfarn("Rainfarn", 4, 1, "Close", null, false, Faction.NILFGAARD, ""),
    Siege_Technician("Siege_Technician", 0, 1, "Siege", ActionController.Medic(), false, Faction.NILFGAARD, ""),
    Sweers("Sweers", 2, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Vanhemar("Vanhemar", 4, 1, "Ranged", null, false, Faction.NILFGAARD, ""),
    Vreemde("Vreemde", 2, 1, "Close", null, false, Faction.NILFGAARD, "");
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
