package model.card;

import Enums.Faction;
import controller.ActionController;
import model.App;

public enum RegularCardInformation {
    KAYRAN("Kayran",8,1,"Agile", ActionController.MoralBoost(),true,Faction.MONSTERS,"/IMAGES/sm/monsters_kayran.png"),
    ARACHAS("Arachas",4,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_arachas_2.png"),
    ARACHAS_BEHEMOTH("Arachas Behemoth",6,1,"Siege",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_arachas_behemoth.png"),
    CRONE_BREWESS("Crone: Brewess",6,1,"Close",ActionController.CommanderHorn(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_witch_velen.png"),
    CRONE_WEAVESS("Crone: Weavess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_witch_velen_1.png"),
    CRONE_WHISPESS("Crone: Whispess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_witch_velen_2.png"),
    GHOUL("Ghoul",1,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_ghoul.png"),
    NEKKER("Nekker",2,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_nekker.png"),
    VAMPIRE_BRUXA("Vampire: Bruxa",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_bruxa.png"),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_ekkima.png"),
    VAMPIRE_FLEDER("Vampire: Fleder",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_fleder.png"),
    VAMPIRE_GRAKAIN("Vampire: Grakain",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_garkain.png"),
    VAMPIRE_KATAKAN("Vampire: Katakan",5,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_katakan.png"),
    TOAD("Toad",7,1,"Ranged",ActionController.Scorch(),false,Faction.MONSTERS,"/IMAGES/sm/monsters_toad.png"),
    BOTCHLING("Botchling",4,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_ghoul_1.png"),
    CELAENO_HARPY("Celaeno Harpy",2,1,"Agile",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_celaeno_harpy.png"),
    COCKATRICE("Cockatrice",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_cockatrice.png"),
    DRAUG("DRAUG",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/sm/monsters_draug.png"),
    EARTH_ELEMENTAL("Earth Elemental",6,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_earth_elemental.png"),
    ENDREGA("Endrega",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_endrega.png"),
    FIEND("Fiend",6,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_fiend.png"),
    FIRE_ELEMENTAL("Fire Elemental",6,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_fire_elemental.png"),
    FOGLET("Foglet",2,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_fogling.png"),
    FORKTAIL("Forktail",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_forktail.png"),
    FRIGHTENER("Frightener",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_frightener.png"),
    GARGOYLE("Gargoyle",5,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_gargoyle.png"),
    GRAVE_HAG("Grave Hag",5,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_gravehag.png"),
    GRIFFIN("Griffin",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_gryffin.png"),
    HARPY("Harpy",2,1,"Agile",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_harpy.png"),
    ICE_GIANT("Ice Giant",5,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_frost_giant.png"),
    IMLERITH("Imlerith",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/sm/monsters_imlerith.png"),
    LESHEN("Leshen",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/sm/monsters_leshen.png"),
    PLAGUE_MAIDEN("Plague Maiden",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_mighty_maiden.png"),
    WEREWOLF("Were Wolf",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_werewolf.png"),
    WYVERN("Wyvern",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/sm/monsters_wyvern.png"),
    Impera_Brigade_Guard("Impera_Brigade_Guard", 3, 4, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_imperal_brigade.png"),
    Stefan_Skellen("Stefan_Skellen", 9, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_stefan.png"),
    Shilard_Fitz_Oesterlen("Shilard_Fitz_Oesterlen", 7, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_shilard.png"),
    Young_Emissary("Young_Emissary", 5, 2, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_young_emissary.png"),
    Cahir_Mawr_Dyffryn_Aep_Ceallach("Cahir_Mawr_Dyffryn_Aep_Ceallach", 6, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Vattier_De_Rideaux("Vattier_De_Rideaux", 4, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Menno_Coehorn("Menno_Coehorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Puttkammer("Puttkammer", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Assire_Var_Anahid("Assire_Var_Anahid", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Black_Infantry_Archer("Black_Infantry_Archer", 10, 2, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Tibor_Eggebracht("Tibor_Eggebracht", 10, 1, "Ranged", null, true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Renuald_Aep_Matsen("Renuald_Aep_Matsen", 5, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Fringilla_Vigo("Fringilla_Vigo", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Rotten_Mangonel("Rotten_Mangonel", 3, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Heavy_Zerrikanian_Fire_Scorpion("Heavy_Zerrikanian_Fire_Scorpion", 10, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Zerrikanian_Fire_Scorpion("Zerrikanian_Fire_Scorpion", 5, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Siege_Engineer("Siege_Engineer", 6, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Morvran_Voorhis("Morvran_Voorhis", 10, 1, "Siege", null, true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Albrich("Albrich", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Cynthia("Cynthia", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Etolian_Auxiliary_Archers("Etolian_Auxiliary_Archers", 1, 2, "Ranged", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Letho_Of_Gulet("Letho_Of_Gulet", 10, 1, "Close", null, true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Menno_Coehoorn("Menno_Coehoorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/"),
    Morteisen("Morteisen", 3, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Nausicaa_Cavalry_Rider("Nausicaa_Cavalry_Rider", 2, 3, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Rainfarn("Rainfarn", 4, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Siege_Technician("Siege_Technician", 0, 1, "Siege", ActionController.Medic(), false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Sweers("Sweers", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Vanhemar("Vanhemar", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Vreemde("Vreemde", 2, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/"),
    Ballista("Ballista", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Blue_Stripes_Commando("Blue_Stripes_Commando", 4, 3, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Catapult("Catapult", 8, 2, "Siege", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Dragon_Hunter("Dragon_Hunter", 5, 2, "Ranged", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Dethmold("Dethmold", 6, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Dun_Banner_Medic("Dun_Banner_Medic", 5, 1, "Siege", ActionController.Medic(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Esterad_Thyssen("Esterad_Thyssen", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    John_Natalis("John_Natalis", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Kaedweni_Siege_Expert("Kaedweni_Siege_Expert", 1, 3, "Siege", ActionController.MoralBoost(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Keira_Metz("Keira_Metz", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Philippa_Eilhart("Philippa_Eilhart", 10, 1, "Ranged", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Poor_Infantry("Poor_Infantry", 1, 4, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Prince_Stennis("Prince_Stennis", 5, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Redanian_Foot_Soldier("Redanian_Foot_Soldier", 1, 2, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Sabrina_Glevissing("Sabrina_Glevissing", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Sheldon_Skaggs("Sheldon_Skaggs", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Siege_Tower("Siege_Tower", 6, 1, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Siegfried_Of_Denesle("Siegfried_Of_Denesle", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Sigismund_Dijkstra("Sigismund_Dijkstra", 4, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Sile_De_Tansarville("Síle_De_Tansarville", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Thaler("Thaler", 1, 1, "Siege", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Trebuchet("Trebuchet", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Vernon_Roche("Vernon_Roche", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Ves("Ves", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Yarpen_Zirgrin("Yarpen_Zirgrin", 2, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    Mardoeme("Mardoeme", 0, 3, "Spell", ActionController.Mardroeme(), false, Faction.SKELLIGE, "/IMAGES/sm/"),
    Berserker("Berserker", 4, 1, "Close", ActionController.Berserker(), false, Faction.SKELLIGE, "/IMAGES/sm/"),
    Vidkaarl("Vidkaarl", 14, 1, "Close", ActionController.MoralBoost(), false, Faction.SKELLIGE, "/IMAGES/sm/"),
    Svanrige("Svanrige", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/sm/"),
    Udalryk("Udalryk", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/sm/"),
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
