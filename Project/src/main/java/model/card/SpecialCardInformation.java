package model.card;

import controller.ActionController;

import java.lang.reflect.Method;
import java.util.function.Function;

public enum SpecialCardInformation {
    Biting_Frost("Biting_Frost",0,3,"Weather", ActionController.BitingFrost(), false, "/IMAGES/sm/weather_frost.png"),
    Impenetrable_Fog("Impenetrable_Fog", 0, 3, "Weather", ActionController.Impenetrablefog(), false, "/IMAGES/sm/weather_fog.png"),
    Torrential_Rain("Torrential_Rain", 0, 3, "Weather", ActionController.TorrentialRain(), false, "/IMAGES/sm/weather_rain.png"),
    Skellige_Storm("Skellige_Storm", 0, 3, "Weather", ActionController.SkelligeStorm(), false, "/IMAGES/sm/weather_storm.png"),
    Clear_Weather("Clear_Weather", 0, 3, "Weather", ActionController.ClearWeather(), false, "/IMAGES/sm/weather_clear.png"),
    Scorch("Scorch", 0, 3, "Spell", ActionController.Scorch(), false, "/IMAGES/sm/special_scorch.png"),
    Commander_Horn("Commander_Horn", 0, 3, "Spell", ActionController.CommanderHorn(), false, "/IMAGES/sm/special_horn.png"),
    Decoy("Decoy", 0, 3, "Spell", ActionController.Decoy(), false, "/IMAGES/sm/special_decoy.png"),
    Dandelion("Dandelion", 2, 1, "Close", ActionController.CommanderHorn(), false, "/IMAGES/sm/neutral_dandelion.png"),
    Cow("Cow", 0, 1, "Ranged", ActionController.Transformers(), false, "/IMAGES/sm/neutral_cow.png"),
    Emiel_Regis("Emiel_Regis", 5, 1, "Close", null, false, "/IMAGES/sm/neutral_emiel.png"),
    Gaunter_ODimm("Gaunter_ODimm", 2, 1, "Siege", ActionController.Muster(), false, "/IMAGES/sm/neutral_gaunter_odimm.png"),
    Gaunter_ODImm_Darkness("Gaunter_ODImm_Darkness", 4, 3, "Ranged", ActionController.Muster(), false, "IMAGES/sm/neutral_gaunter_odimm_darkness.png"),
    Geralt_Of_Rivia("Geralt_Of_Rivia", 15, 1, "Close", null, true, "/IMAGES/sm/neutral_geralt.png"),
    Mysterious_Elf("Mysterious_Elf", 0, 1, "Close", ActionController.Spy(), true, "/IMAGES/sm/neutral_mysterious_elf.png"),
    Olgierd_Von_Everc("Olgierd_Von_Everc", 6, 1, "Agile", ActionController.MoralBoost(), false, "/IMAGES/sm/neutral_olgierd.png"),
    Triss_Merigold("Triss_Merigold", 7, 1, "Close", null, true, "/IMAGES/sm/neutral_triss.png"),
    Vesemir("Vesemir", 6, 1, "Close", null, false, "/IMAGES/sm/neutral_vesemir.png"),
    Villentretenmerth("Villentretenmerth", 7, 1, "Close", ActionController.Scorch(), false, "/IMAGES/sm/neutral_villen.png"),
    Yennefer_Of_Vengerberg("Yennefer_Of_Vengerberg", 7, 1, "Ranged", ActionController.Medic(), true, "/IMAGES/sm/neutral_yennefer.png"),
    Zoltan_Chivay("Zoltan_Chivay", 5, 1, "Close", null, false, "/IMAGES/sm/neutral_zoltan.png");
    final String name;
    final int power;
    final int countInGame;
    final String type;
    final Runnable ability;
    final boolean hero;
    final String imageAddress;
    SpecialCardInformation(String name, int power, int countInGame, String type, Runnable ability, boolean hero, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.imageAddress = imageAddress;
    }
}
