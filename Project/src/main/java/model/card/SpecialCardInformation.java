package model.card;

import controller.ActionController;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.function.Function;

public enum SpecialCardInformation implements Serializable {
    Biting_Frost("Biting_Frost",0,3,"Weather", ActionController.BitingFrost(), false, "/IMAGES/lg/weather_frost.jpg"),
    Impenetrable_Fog("Impenetrable_Fog", 0, 3, "Weather", ActionController.ImpenetrableFog(), false, "/IMAGES/lg/weather_fog.jpg"),
    Torrential_Rain("Torrential_Rain", 0, 3, "Weather", ActionController.TorrentialRain(), false, "/IMAGES/lg/weather_rain.jpg"),
    Skellige_Storm("Skellige_Storm", 0, 3, "Weather", ActionController.SkelligeStorm(), false, "/IMAGES/lg/weather_storm.jpg"),
    Clear_Weather("Clear_Weather", 0, 3, "Weather", ActionController.ClearWeather(), false, "/IMAGES/lg/weather_clear.jpg"),
    Scorch("Scorch", 0, 3, "Spell", ActionController.Scorch(), false, "/IMAGES/lg/special_scorch.jpg"),
    Commander_Horn("Commander_Horn", 0, 3, "Spell", ActionController.CommanderHorn(), false, "/IMAGES/lg/special_horn.jpg"),
    Decoy("Decoy", 0, 3, "Spell", null, false, "/IMAGES/lg/special_decoy.jpg"),
    Dandelion("Dandelion", 2, 1, "Close", ActionController.CommanderHorn(), false, "/IMAGES/lg/neutral_dandelion.jpg"),
    Cow("Cow", 0, 1, "Ranged", null, false, "/IMAGES/lg/neutral_cow.jpg"),
    Emiel_Regis("Emiel_Regis", 5, 1, "Close", null, false, "/IMAGES/lg/neutral_emiel.jpg"),
    Gaunter_ODimm("Gaunter_ODimm", 2, 1, "Siege", ActionController.Muster(), false, "/IMAGES/lg/neutral_gaunter_odimm.jpg"),
    Gaunter_ODImm_Darkness("Gaunter_ODImm_Darkness", 4, 3, "Ranged", ActionController.Muster(), false, "/IMAGES/lg/neutral_gaunter_odimm_darkness.jpg"),
    Geralt_Of_Rivia("Geralt_Of_Rivia", 15, 1, "Close", null, true, "/IMAGES/lg/neutral_geralt.jpg"),
    Mysterious_Elf("Mysterious_Elf", 0, 1, "Close", ActionController.Spy(), true, "/IMAGES/lg/neutral_mysterious_elf.jpg"),
    Olgierd_Von_Everc("Olgierd_Von_Everc", 6, 1, "Agile", ActionController.MoralBoost(), false, "/IMAGES/lg/neutral_olgierd.jpg"),
    Triss_Merigold("Triss_Merigold", 7, 1, "Close", null, true, "/IMAGES/lg/neutral_triss.jpg"),
    Vesemir("Vesemir", 6, 1, "Close", null, false, "/IMAGES/lg/neutral_vesemir.jpg"),
    Villentretenmerth("Villentretenmerth", 7, 1, "Close", ActionController.Scorch(), false, "/IMAGES/lg/neutral_villen.jpg"),
    Yennefer_Of_Vengerberg("Yennefer_Of_Vengerberg", 7, 1, "Ranged", ActionController.Medic(), true, "/IMAGES/lg/neutral_yennefer.jpg"),
    Zoltan_Chivay("Zoltan_Chivay", 5, 1, "Close", null, false, "/IMAGES/lg/neutral_zoltan.jpg");
    final String name;
    final int power;
    final int countInGame;
    final String type;
    final Runnable ability;
    final boolean hero;
    final String imageAddress;

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    SpecialCardInformation(String name, int power, int countInGame, String type, Runnable ability, boolean hero, String imageAddress) {
        this.name = name;
        this.power = power;
        this.countInGame = countInGame;
        this.type = type;
        this.ability = ability;
        this.hero = hero;
        this.imageAddress = imageAddress;
    }

    public Runnable getAbility() {
        return ability;
    }
}
