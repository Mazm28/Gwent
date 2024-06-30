package model.card;

import Enums.Faction;
import controller.ActionController;

import java.io.Serializable;
import java.lang.reflect.Method;

public enum LeaderCardInformation implements Serializable {
    THE_SIEGMASTER("The Siegemaster",Faction.NORTHERN_REALMS, ActionController.Siegemaster(), "/IMAGES/leaders/northernRealms/TheSiegemaster.jpg"),
    CRACH_AN_CRAITE("Crach An Craite",Faction.SKELLIGE, ActionController.CrachanCraite(), "/IMAGES/leaders/skellige/CrachAnCraite.jpg"),
    KING_BRAN("King Bran",Faction.SKELLIGE, ActionController.KingBran(), "/IMAGES/leaders/skellige/KingBran.jpg"),
    THE_BEAUTIFUL("The Beautiful",Faction.SCOIATAEL, ActionController.Beautiful(), "/IMAGES/leaders/scoiatael/TheBeautiful.jpg"),
    DAISY_OF_THE_VALLEY("Daisy Of The Valley",Faction.SCOIATAEL, ActionController.DaisyOfTheValley(), "/IMAGES/leaders/scoiatael/DaisyOfTheValley.jpg"),
    HOPE_OF_THE_AEN_SEIDHE("Hope Of The Aen Seidhe",Faction.SCOIATAEL, ActionController.HopeOfTheAenSeidhe(), "/IMAGES/leaders/scoiatael/HopeOfTheAenSeidhe.jpg"),
    QUEEN_OF_DOL_BLATHANNA("Queen Of Dol Blathanna",Faction.SCOIATAEL, ActionController.QueenOfDolBlathanna(), "/IMAGES/leaders/scoiatael/QueenOfDolBlathanna.jpg"),
    PUREBLOOD_ELF("Pureblood Elf",Faction.SCOIATAEL, ActionController.PurebloodElf(), "/IMAGES/leaders/scoiatael/PurebloodElf.jpg"),
    KING_OF_TEMERIA("King Of Temeria",Faction.NORTHERN_REALMS, ActionController.KingofTemeria(), "/IMAGES/leaders/northernRealms/KingOfTemeria.jpg"),
    LORD_COMMANDER_OF_THE_NORTH("Lord Commander Of The North",Faction.NORTHERN_REALMS, ActionController.LordCommanderoftheNorth(), "/IMAGES/leaders/northernRealms/LordCommanderOfTheNorth.jpg"),
    THE_STEEL_FORGED("The Steel-Forged",Faction.NORTHERN_REALMS, ActionController.SteelForged(), "/IMAGES/leaders/northernRealms/TheSteelForged.jpg"),
    SON_OF_MEDELL("Son Of Medell",Faction.NORTHERN_REALMS, ActionController.SonOfMedell(), "/IMAGES/leaders/northernRealms/SonOfMedell.jpg"),
    HIS_IMPERIAL_MAJESTY("His Imperial Majesty",Faction.NILFGAARD, ActionController.HisImperialMajesty(), "/IMAGES/leaders/nilfgaard/HisImperialMajesty.jpg"),
    EMPEROR_OF_NILFGAARD("Emperor Of Nilfgaard",Faction.NILFGAARD, ActionController.EmperorOfNilfgaard(), "/IMAGES/leaders/nilfgaard/EmperorOfNilfgaard.jpg"),
    INVADOR_OF_THE_NORTH("Invader Of The North",Faction.NILFGAARD, ActionController.InvaderoftheNorth(), "/IMAGES/leaders/nilfgaard/InvaderOfTheNorth.jpg"),
    THE_WHITE_FLAME("The White Flame",Faction.NILFGAARD, ActionController.WhiteFlame(), "/IMAGES/leaders/nilfgaard/TheWhiteFlame.jpg"),
    THE_RELENTLESS("The Relentless",Faction.NILFGAARD, ActionController.Relentless(), "/IMAGES/leaders/nilfgaard/TheRelentless.jpg"),
    THE_TRACHEROUS("The Tracherous",Faction.MONSTERS, ActionController.Treacherous(), "/IMAGES/leaders/monsters/TheTracherous.jpg"),
    COMMANDER_OF_THE_RED_RIDERS("Commander Of The Red Riders",Faction.MONSTERS, ActionController.CommanderOfTheRedRiders(), "/IMAGES/leaders/monsters/CommanderOfTheRedRiders.jpg"),
    DESTROYER_OF_WORLDS("Destroyer Of Worlds",Faction.MONSTERS, ActionController.DestroyerOfWorlds(), "/IMAGES/leaders/monsters/DestroyerOfWorlds.jpg"),
    KING_OF_THE_WILD_HUNT("King Of The Wild Hunt",Faction.MONSTERS, ActionController.KingOfthewildHunt(), "/IMAGES/leaders/monsters/KingOfTheWildHunt.jpg"),
    BRINGER_OF_DEATH("Bringer Of Death",Faction.MONSTERS, ActionController.BringerOfDeath(), "/IMAGES/leaders/monsters/BringerOfDeath.jpg");
    final String name;
    final Faction faction;
    final Runnable ability;
    final String imageAddress;

    LeaderCardInformation(String name, Faction faction, Runnable ability, String imageAddress) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.imageAddress = imageAddress;
    }

    public String getName() {
        return name;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public Faction getFaction() {
        return faction;
    }

    public Runnable getAbility() {
        return ability;
    }
}
