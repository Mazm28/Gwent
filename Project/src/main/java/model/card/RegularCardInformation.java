package model.card;

import Enums.Faction;
import controller.ActionController;
import model.App;

import java.io.Serializable;

public enum RegularCardInformation implements Serializable {
    KAYRAN("Kayran",8,1,"Agile", ActionController.MoralBoost(),true,Faction.MONSTERS,"/IMAGES/lg/monsters_kayran.jpg"),
    ARACHAS("Arachas",4,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_arachas_2.jpg"),
    ARACHAS_BEHEMOTH("Arachas Behemoth",6,1,"Siege",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_arachas_behemoth.jpg"),
    CRONE_BREWESS("Crone: Brewess",6,1,"Close",ActionController.CommanderHorn(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_witch_velen.jpg"),
    CRONE_WEAVESS("Crone: Weavess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_witch_velen_1.jpg"),
    CRONE_WHISPESS("Crone: Whispess",6,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_witch_velen_2.jpg"),
    GHOUL("Ghoul",1,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_ghoul.jpg"),
    NEKKER("Nekker",2,3,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_nekker.jpg"),
    VAMPIRE_BRUXA("Vampire: Bruxa",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_bruxa.jpg"),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_ekkima.jpg"),
    VAMPIRE_FLEDER("Vampire: Fleder",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_fleder.jpg"),
    VAMPIRE_GRAKAIN("Vampire: Grakain",4,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_garkain.jpg"),
    VAMPIRE_KATAKAN("Vampire: Katakan",5,1,"Close",ActionController.Muster(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_katakan.jpg"),
    TOAD("Toad",7,1,"Ranged",ActionController.Scorch(),false,Faction.MONSTERS,"/IMAGES/lg/monsters_toad.jpg"),
    BOTCHLING("Botchling",4,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_ghoul_1.jpg"),
    CELAENO_HARPY("Celaeno Harpy",2,1,"Agile",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_celaeno_harpy.jpg"),
    COCKATRICE("Cockatrice",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_cockatrice.jpg"),
    DRAUG("DRAUG",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/lg/monsters_draug.jpg"),
    EARTH_ELEMENTAL("Earth Elemental",6,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_earth_elemental.jpg"),
    ENDREGA("Endrega",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_endrega.jpg"),
    FIEND("Fiend",6,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_fiend.jpg"),
    FIRE_ELEMENTAL("Fire Elemental",6,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_fire_elemental.jpg"),
    FOGLET("Foglet",2,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_fogling.jpg"),
    FORKTAIL("Forktail",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_forktail.jpg"),
    FRIGHTENER("Frightener",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_frightener.jpg"),
    GARGOYLE("Gargoyle",5,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_gargoyle.jpg"),
    GRAVE_HAG("Grave Hag",5,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_gravehag.jpg"),
    GRIFFIN("Griffin",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_gryffin.jpg"),
    HARPY("Harpy",2,1,"Agile",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_harpy.jpg"),
    ICE_GIANT("Ice Giant",5,1,"Siege",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_frost_giant.jpg"),
    IMLERITH("Imlerith",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/lg/monsters_imlerith.jpg"),
    LESHEN("Leshen",10,1,"Close",null,true,Faction.MONSTERS,"/IMAGES/lg/monsters_leshen.jpg"),
    PLAGUE_MAIDEN("Plague Maiden",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_mighty_maiden.jpg"),
    WEREWOLF("Were Wolf",5,1,"Close",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_werewolf.jpg"),
    WYVERN("Wyvern",2,1,"Ranged",null,false,Faction.MONSTERS,"/IMAGES/lg/monsters_wyvern.jpg"),
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard", 3, 4, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_imperal_brigade.jpg"),
    STEFAN_SKELLEN("Stefan Skellen", 9, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_stefan.jpg"),
    SHILARD_FITZ_OESTERLEN("Shilard Fitz Oesterlen", 7, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_shilard.jpg"),
    YOUNG_EMISSARY("Young Emissary", 5, 2, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_young_emissary.jpg"),
    CAHIR_MAWR_DYFFRYN_AEP_CEALLACH("Cahir Mawr Dyffryn Aep Ceallach", 6, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_cahir.jpg"),
    VATTIER_DE_RIDEAUX("Vattier De Rideaux", 4, 1, "Close", ActionController.Spy(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_vattier.jpg"),
    MENNO_COEHORN("Menno Coehorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_menno.jpg"),
    PUTTKAMMER("Puttkammer", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_puttkammer.jpg"),
    ASSIRE_VAR_ANAHID("Assire Var Anahid", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_assire.jpg"),
    BLACK_INFANTRY_ARCHOR("Black Infantry Archer", 10, 2, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_black_archer.jpg"),
    TIBOR_EGGEBRACHT("Tibor Eggebracht", 10, 1, "Ranged", null, true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_tibor.jpg"),
    RENUALD_AEP_MATSEN("Renuald Aep Matsen", 5, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_renuald.jpg"),
    FRINGILLA_VIGO("Fringilla Vigo", 6, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_fringilla.jpg"),
    ROTTEN_MANGONEL("Rotten Mangonel", 3, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_rotten.jpg"),
    HEAVY_ZERRIKANIAN_FIRE_SCORPION("Heavy Zerrikanian Fire_Scorpion", 10, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_heavy_zerri.jpg"),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion", 5, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_heavy_zerri.jpg"),
    SIEGE_ENGINEER("Siege Engineer", 6, 1, "Siege", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_siege_engineer.jpg"),
    MORVRAN_VOORHIS("Morvran Voorhis", 10, 1, "Siege", null, true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_moorvran.jpg"),
    ALBRICH("Albrich", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_albrich.jpg"),
    CYNTHIA("Cynthia", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_cynthia.jpg"),
    ETOLIAN_AUXILIARY_ARCHERS("Etolian Auxiliary Archers", 1, 2, "Ranged", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_archer_support_1.jpg"),
    LETHO_OF_GULET("Letho Of Gulet", 10, 1, "Close", null, true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_letho.jpg"),
    MENNO_COEHOORN("Menno Coehoorn", 10, 1, "Close", ActionController.Medic(), true, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_menno.jpg"),
    MORTEISEN("Morteisen", 3, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_morteisen.jpg"),
    NAUSICAA_CAVALRY_RIDER("Nausicaa Cavalry Rider", 2, 3, "Close", ActionController.TightBond(), false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_nauzicaa_2.jpg"),
    RAINFARN("Rainfarn", 4, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_rainfarn.jpg"),
    SIEGE_TECHNICIAN("Siege Technician", 0, 1, "Siege", ActionController.Medic(), false, Faction.NILFGAARD, "/IMAGES/lg/realms_kaedwen_siege_1.jpg"),
    SWEERS("Sweers", 2, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_sweers.jpg"),
    VANHEMAR("Vanhemar", 4, 1, "Ranged", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_vanhemar.jpg"),
    VREEMDE("Vreemde", 2, 1, "Close", null, false, Faction.NILFGAARD, "/IMAGES/lg/nilfgaard_vreemde.jpg"),
    BALLISTA("Ballista", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_ballista.jpg"),
    BLUE_STRIPES_COMMANDO("Blue Stripes Commando", 4, 3, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_blue_stripes.jpg"),
    CATAPULT("Catapult", 8, 2, "Siege", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_catapult_1.jpg"),
    DRAGON_HUNTER("Dragon Hunter", 5, 2, "Ranged", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_crinfrid.jpg"),
    DETHMOLD("Dethmold", 6, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_dethmold.jpg"),
    DUN_BANNER_MEDIC("Dun Banner Medic", 5, 1, "Siege", ActionController.Medic(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_banner_nurse.jpg"),
    ESTERAD_THYSSEN("Esterad Thyssen", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_esterad.jpg"),
    JOHN_NATALIS("John Natalis", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_natalis.jpg"),
    KAEDWENI_SIEGE_EXPERT("Kaedweni Siege Expert", 1, 3, "Siege", ActionController.MoralBoost(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_siege_tower.jpg"),
    KEIRA_METZ("Keira Metz", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_keira.jpg"),
    PHILIPPA_EILHART("Philippa Eilhart", 10, 1, "Ranged", null, true, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_philippa.jpg"),
    POOR_INFANTRY("Poor Infantry", 1, 4, "Close", ActionController.TightBond(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_poor_infantry.jpg"),
    PRINCE_STENNIS("Prince Stennis", 5, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_stennis.jpg"),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier", 1, 2, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_redania.jpg"),
    SABRINA_GLEVISSING("Sabrina Glevissing", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_sabrina.jpg"),
    SHELDON_SKAGGS("Sheldon Skaggs", 4, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_sheldon.jpg"),
    SIEGE_TOWER("Siege Tower", 6, 1, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_siege_tower.jpg"),
    SIEGFRIED_OF_DENESLE("Siegfried Of Denesle", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_siegfried.jpg"),
    SIGISMUND_DIJKSTRA("Sigismund Dijkstra", 4, 1, "Close", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_dijkstra.jpg"),
    SILE_DE_TANSARVILLE("Síle De Tansarville", 5, 1, "Ranged", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_sabrina.jpg"),
    THALER("Thaler", 1, 1, "Siege", ActionController.Spy(), false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_thaler.jpg"),
    TREBUCHET("Trebuchet", 6, 2, "Siege", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_trebuchet_1.jpg"),
    VERNON_ROCHE("Vernon_Roche", 10, 1, "Close", null, true, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_vernon.jpg"),
    VES("Ves", 5, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/"),
    YARPEN_ZIRGRIN("Yarpen_Zirgrin", 2, 1, "Close", null, false, Faction.NORTHERN_REALMS, "/IMAGES/lg/realms_yarpen.jpg"),
    MARDOEME("Mardoeme", 0, 3, "Spell", ActionController.Mardroeme(), false, Faction.SKELLIGE, "/IMAGES/lg/special_mardroeme.jpg"),
    BERSERKER("Berserker", 4, 1, "Close", ActionController.Berserker(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_berserker.jpg"),
    VIDKAARL("Vidkaarl", 14, 1, "Close", ActionController.MoralBoost(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_vildkaarl.jpg"),
    SVANRIGE("Svanrige", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_svanrige.jpg"),
    UDALRYK("Udalryk", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_udalryk.jpg"),
    DONAR_AN_HINDAR("Donar an Hindar", 4, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_donar.jpg"),
    CLAN_AN_CRAITE("Clan An Craite", 6,3, "Close", ActionController.TightBond(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_crach_an_craite.jpg"),
    BLUEBOY_LUGOS("Blueboy Lugos", 6, 1, "Close", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_blueboy.jpg"),
    MADMAN_LUGOS("Madman Lugos", 6,1,"Close", null, false,Faction.SKELLIGE, "/IMAGES/lg/skellige_madmad_lugos.jpg"),
    CERYS("Cerys", 10,1,"Close", ActionController.Muster(), true, Faction.SKELLIGE, "/IMAGES/lg/skellige_cerys.jpg"),
    KAMBI("Kambi", 11,1,"Close", ActionController.Transformers(), true, Faction.SKELLIGE, "/IMAGES/lg/skellige_kambi.jpg"),
    BIRNA_BRAN("Birna Bran", 2,1,"Close", ActionController.Medic(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_birna.jpg"),
    CLAN_DRUMMOND_SHIELDMAINDEN("Clan Drummond Shieldmaiden", 4,3,"Close", ActionController.TightBond(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_shield_maiden.jpg"),
    CLAN_TORDARROCH_ARMORSMITH("Clan Tordarroch Armorsmith", 4,1,"Close", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_shield_maiden_1.jpg"),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 6,1,"Ranged", ActionController.Scorch(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_dimun_pirate.jpg"),
    CLAN_BROKVAR_ARCHER("Clan Brokvar Archer", 6,3, "Ranged", null , false, Faction.SKELLIGE, "/IMAGES/lg/nilfgaard_black_archer_1.jpg"),
    ERMION("Ermion", 8,1,"Ranged", ActionController.Mardroeme(), true, Faction.SKELLIGE, "/IMAGES/lg/skellige_ermion.jpg"),
    HJALMAR("Hjalmar", 10,1,"Ranged", null, true, Faction.SKELLIGE, "/IMAGES/lg/skellige_hjalmar.jpg"),
    YOUNG_BERSERKER("Young Berserker", 2,3, "Ranged", ActionController.Berserker(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_young_berserker.jpg"),
    YOUNG_VIDKAARL("Young Vidkaarl", 8, 1,"Ranged", ActionController.TightBond(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_young_vildkaarl.jpg"),
    LIGHT_LONGSHIP("Light Longship", 4,3,"Ranged", ActionController.Muster(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_light_longship.jpg"),
    HOLGER_BLACKHAND("Holger Blackhand", 4,1,"Siege", null, false, Faction.SKELLIGE, "/IMAGES/lg/skellige_holger.jpg"),
    WAR_LONGSHIP("War Longship", 6,3, "Siege", ActionController.TightBond(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_war_longship.jpg"),
    DRAIG_BON_DHU("Draig Bon-Dhu", 2,1,"Siege", ActionController.CommanderHorn(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_draig.jpg"),
    OLAF("Olaf", 12,1,"Agile", ActionController.MoralBoost(), false, Faction.SKELLIGE, "/IMAGES/lg/skellige_olaf.jpg")
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
