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
    IMPERA_BRIGADE_GUARD("Impera_Brigade_Guard", 3, 4, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_imperal_brigade.png"),
    STEFAN_SKELLEN("Stefan_Skellen", 9, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_stefan.png"),
    SHILARD_FITZ_OESTERLEN("Shilard_Fitz_Oesterlen", 7, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_shilard.png"),
    YOUNG_EMISSARY("Young_Emissary", 5, 2, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_young_emissary.png"),
    CAHIR_MAWR_DYFFRYN_AEP_CEALLACH("Cahir_Mawr_Dyffryn_Aep_Ceallach", 6, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_cahir.png"),
    VATTIER_DE_RIDEAUX("Vattier_De_Rideaux", 4, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_vattier.png"),
    MENNO_COEHORN("Menno_Coehorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_menno.png"),
    PUTTKAMMER("Puttkammer", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_puttkammer.png"),
    ASSIRE_VAR_ANAHID("Assire_Var_Anahid", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_assire.png"),
    BLACK_INFANTRY_ARCHOR("Black_Infantry_Archer", 10, 2, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_black_archer.png"),
    TIBOR_EGGEBRACHT("Tibor_Eggebracht", 10, 1, "Ranged", null, true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_tibor.png"),
    RENUALD_AEP_MATSEN("Renuald_Aep_Matsen", 5, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_renuald.png"),
    FRINGILLA_VIGO("Fringilla_Vigo", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_fringilla.png"),
    ROTTEN_MANGONEL("Rotten_Mangonel", 3, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_rotten.png"),
    HEAVY_ZERRIKANIAN_FIRE_SCORPION("Heavy_Zerrikanian_Fire_Scorpion", 10, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_heavy_zerri.png"),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian_Fire_Scorpion", 5, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_heavy_zerri.png"),
    SIEGE_ENGINEER("Siege_Engineer", 6, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_siege_engineer.png"),
    MORVRAN_VOORHIS("Morvran_Voorhis", 10, 1, "Siege", null, true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_moorvran.png"),
    ALBRICH("Albrich", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_albrich.png"),
    CYNTHIA("Cynthia", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_cynthia.png"),
    ETOLIAN_AUXILIARY_ARCHERS("Etolian_Auxiliary_Archers", 1, 2, "Ranged", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_archer_support_1.png"),
    LETHO_OF_GULET("Letho_Of_Gulet", 10, 1, "Close", null, true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_letho.png"),
    MENNO_COEHOORN("Menno_Coehoorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_menno.png"),
    MORTEISEN("Morteisen", 3, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_morteisen.png"),
    NAUSICAA_CAVALRY_RIDER("Nausicaa_Cavalry_Rider", 2, 3, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_nauzicaa_2.png"),
    RAINFARN("Rainfarn", 4, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_rainfarn.png"),
    SIEGE_TECHNICIAN("Siege_Technician", 0, 1, "Siege", ActionController.Medic(), false, Faction.NILFGAARD, "/IMAGES/sm/realms_kaedwen_siege_1.png"),
    SWEERS("Sweers", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_sweers.png"),
    VANHEMAR("Vanhemar", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_vanhemar.png"),
    VREEMDE("Vreemde", 2, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/sm/nilfgaard_vreemde.png"),
    BALLISTA("Ballista", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_ballista.png"),
    BLUE_STRIPES_COMMANDO("Blue_Stripes_Commando", 4, 3, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_blue_stripes.png"),
    CATAPULT("Catapult", 8, 2, "Siege", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_catapult_1.png"),
    DRAGON_HUNTER("Dragon_Hunter", 5, 2, "Ranged", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_crinfrid.png"),
    DETHMOLD("Dethmold", 6, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_dethmold.png"),
    DUN_BANNER_MEDIC("Dun_Banner_Medic", 5, 1, "Siege", ActionController.Medic(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_banner_nurse.png"),
    ESTERAD_THYSSEN("Esterad_Thyssen", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_esterad.png"),
    JOHN_NATALIS("John_Natalis", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_natalis.png"),
    KAEDWENI_SIEGE_EXPERT("Kaedweni_Siege_Expert", 1, 3, "Siege", ActionController.MoralBoost(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_siege_tower.png"),
    KEIRA_METZ("Keira_Metz", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_keira.png"),
    PHILIPPA_EILHART("Philippa_Eilhart", 10, 1, "Ranged", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_philippa.png"),
    POOR_INFANTRY("Poor_Infantry", 1, 4, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_poor_infantry.png"),
    PRINCE_STENNIS("Prince_Stennis", 5, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_stennis.png"),
    REDANIAN_FOOT_SOLDIER("Redanian_Foot_Soldier", 1, 2, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_redania.png"),
    SABRINA_GLEVISSING("Sabrina_Glevissing", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_sabrina.png"),
    SHELDON_SKAGGS("Sheldon_Skaggs", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_sheldon.png"),
    SIEGE_TOWER("Siege_Tower", 6, 1, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_siege_tower.png"),
    SIEGFRIED_OF_DENESLE("Siegfried_Of_Denesle", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_siegfried.png"),
    SIGISMUND_DIJKSTRA("Sigismund_Dijkstra", 4, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_dijkstra.png"),
    SILE_DE_TANSARVILLE("Síle_De_Tansarville", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_sabrina.png"),
    THALER("Thaler", 1, 1, "Siege", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_thaler.png"),
    TREBUCHET("Trebuchet", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_trebuchet_1.png"),
    VERNON_ROCHE("Vernon_Roche", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_vernon.png"),
    VES("Ves", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/"),
    YARPEN_ZIRGRIN("Yarpen_Zirgrin", 2, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/sm/realms_yarpen.png"),
    MARDOEME("Mardoeme", 0, 3, "Spell", ActionController.Mardroeme(), false, Faction.SKELLIGE, "/IMAGES/sm/special_mardroeme.png"),
    BERSERKER("Berserker", 4, 1, "Close", ActionController.Berserker(), false, Faction.SKELLIGE, "/IMAGES/sm/skellige_berserker.png"),
    VIDKAARL("Vidkaarl", 14, 1, "Close", ActionController.MoralBoost(), false, Faction.SKELLIGE, "/IMAGES/sm/skellige_vildkaarl.png"),
    SVANRIGE("Svanrige", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/sm/skellige_svanrige.png"),
    UDALRYK("Udalryk", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/sm/skellige_udalryk.png"),
    DONAR_AN_HINDAR("Donar an Hindar", 4, 1, "Close", null, false, Faction.SKELLIGE, ""),
    CLAN_AN_CRAITE("Clan An Craite", 6,3, "Close", ActionController.TightBond(), false, Faction.SKELLIGE, ""),
    BLUEBOY_LUGOS("Blueboy Lugos", 6, 1, "Close", null, false, Faction.SKELLIGE, ""),
    MADMAN_LUGOS("Madman Lugos", 6,1,"Close", null, false,Faction.SKELLIGE, ""),
    CERYS("Cerys", 10,1,"Close", ActionController.Muster(), true, Faction.SKELLIGE, ""),
    KAMBI("Kambi", 11,1,"Close", ActionController.Transformers(), true, Faction.SKELLIGE, ""),
    BIRNA_BRAN("Birna Bran", 2,1,"Close", ActionController.Medic(), false, Faction.SKELLIGE, ""),
    CLAN_Drummond_Shieldmaiden("Clan Drummond Shieldmaiden", 4,3,"Close", ActionController.TightBond(), false, Faction.SKELLIGE, ""),
    CLAN_TORDARROCH_ARMORSMITH("Clan Tordarroch Armorsmith", 4,1,"Close", null, false, Faction.SKELLIGE, ""),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 6,1,"Ranged", ActionController.Scorch(), false, Faction.SKELLIGE, ""),
    CLAN_BROKVAR_ARCHER("Clan Brokvar Archer", 6,3, "Ranged", null , false, Faction.SKELLIGE, ""),
    ERMION("Ermion", 8,1,"Ranged", ActionController.Mardroeme(), true, Faction.SKELLIGE, ""),
    HJALMAR("Hjalmar", 10,1,"Ranged", null, true, Faction.SKELLIGE, ""),
    YOUNG_BERSERKER("Young Berserker", 2,3, "Ranged", ActionController.Berserker(), false, Faction.SKELLIGE, ""),
    YOUNG_VIDKAARL("Young Vidkaarl", 8, 1,"Ranged", ActionController.TightBond(), false, Faction.SKELLIGE, ""),
    LIGHT_LONGSHIP("Light Longship", 4,3,"Ranged", ActionController.Muster(), false, Faction.SKELLIGE, ""),
    HOLGER_BLACKHAND("Holger Blackhand", 4,1,"Siege", null, false, Faction.SKELLIGE, ""),
    WAR_LONGSHIP("War Longship", 6,3, "Siege", ActionController.TightBond(), false, Faction.SKELLIGE, ""),
    DRAIG_BON_DHU("Draig Bon-Dhu", 2,1,"Siege", ActionController.CommanderHorn(), false, Faction.SKELLIGE, ""),
    OLAF("Olaf", 12,1,"Agile", ActionController.MoralBoost(), false, Faction.SKELLIGE, "")

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
