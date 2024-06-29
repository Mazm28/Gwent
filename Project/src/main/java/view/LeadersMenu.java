package view;

import Enums.FXMLAddresses;
import Enums.Faction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Game;
import model.Player;
import model.PreGame;
import model.card.LeaderCard;
import model.card.LeaderCardInformation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeadersMenu implements Initializable {
    @FXML
    private ImageView crachAnCraite;
    @FXML
    private ImageView kingBran;
    @FXML
    private ImageView theBeautiful;
    @FXML
    private ImageView daisyOfTheValley;
    @FXML
    private ImageView hopeOfTheAenSeidhe;
    @FXML
    private ImageView queenOfDolBlathanna;
    @FXML
    private ImageView pureBloodElf;
    @FXML
    private ImageView kingOfTemeria;
    @FXML
    private ImageView lordCommanderOfTheNorth;
    @FXML
    private ImageView theSteelForged;
    @FXML
    private ImageView theSiegmaster;
    @FXML
    private ImageView sonOfMedell;
    @FXML
    private ImageView hisImperialMajesty;
    @FXML
    private ImageView emperorOfNilfgaard;
    @FXML
    private ImageView invaderOfTheNorth;
    @FXML
    private ImageView theWhiteFlame;
    @FXML
    private ImageView theRelentless;
    @FXML
    private ImageView theTracherous;
    @FXML
    private ImageView commanderOfTheRedRiders;
    @FXML
    private ImageView destroyerOfWorlds;
    @FXML
    private ImageView kingOfTheWildHunt;
    @FXML
    private ImageView bringerOfDeath;
    @FXML
    private Label notify;
    private Player player;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player = PreGame.getTurn();
        if (PreGame.getTurn().getFaction().getName().equals(Faction.MONSTERS.getName())) {
            disableNilfgaard();
            disableScoiatael();
            disableSkellige();
            disableNorthernRealms();
            Tooltip theTracherousTooltip = new Tooltip("The Tracherous");
            Tooltip commanderOfTheRedRidersTooltip = new Tooltip("Commander Of The Red Riders");
            Tooltip destroyerOfWorldsTooltip = new Tooltip("Destroyer Of Worlds");
            Tooltip kingOfTheWildHuntTooltip = new Tooltip("King Of The Wild Hunt");
            Tooltip bringerOfDeathTooltip = new Tooltip("Bringer Of Death");
            Tooltip.install(theTracherous, theTracherousTooltip);
            Tooltip.install(commanderOfTheRedRiders, commanderOfTheRedRidersTooltip);
            Tooltip.install(destroyerOfWorlds, destroyerOfWorldsTooltip);
            Tooltip.install(kingOfTheWildHunt, kingOfTheWildHuntTooltip);
            Tooltip.install(bringerOfDeath, bringerOfDeathTooltip);
        }
        if (PreGame.getTurn().getFaction().getName().equals(Faction.NILFGAARD.getName())) {
            disableSkellige();
            disableNorthernRealms();
            disableMonsters();
            disableScoiatael();
            Tooltip theRelentlessTooltip = new Tooltip("The Relentless");
            Tooltip theWhiteFlameTooltip = new Tooltip("The White Flame");
            Tooltip invaderOfTheNorthTooltip = new Tooltip("Invader Of The North");
            Tooltip hisImperialMajestyTooltip = new Tooltip("His Imperial Majesty");
            Tooltip emperorOfNilfgaardTooltip = new Tooltip("Emperor Of Nilfgaard");
            Tooltip.install(theRelentless, theRelentlessTooltip);
            Tooltip.install(theWhiteFlame, theWhiteFlameTooltip);
            Tooltip.install(invaderOfTheNorth, invaderOfTheNorthTooltip);
            Tooltip.install(hisImperialMajesty, hisImperialMajestyTooltip);
            Tooltip.install(emperorOfNilfgaard, emperorOfNilfgaardTooltip);
        }
        if (PreGame.getTurn().getFaction().getName().equals(Faction.NORTHERN_REALMS.getName())) {
            disableMonsters();
            disableScoiatael();
            disableNilfgaard();
            disableSkellige();
            Tooltip sonOfMedellTooltip = new Tooltip("Son Of Medell");
            Tooltip theSiegmasterTooltip = new Tooltip("The Siegmaster");
            Tooltip theSteelForgedTooltip = new Tooltip("The Steel-Forged");
            Tooltip lordCommanderOfTheNorthTooltip = new Tooltip("Lord Commander Of The North");
            Tooltip kingOfTemeriaTooltip = new Tooltip("King Of Temeria");
            Tooltip.install(kingOfTemeria, kingOfTemeriaTooltip);
            Tooltip.install(lordCommanderOfTheNorth, lordCommanderOfTheNorthTooltip);
            Tooltip.install(theSteelForged, theSteelForgedTooltip);
            Tooltip.install(theSiegmaster, theSiegmasterTooltip);
            Tooltip.install(sonOfMedell, sonOfMedellTooltip);
        }
        if (PreGame.getTurn().getFaction().getName().equals(Faction.SCOIATAEL.getName())) {
            disableNilfgaard();
            disableSkellige();
            disableMonsters();
            disableNorthernRealms();
            Tooltip theBeautifulTooltip = new Tooltip("The Beautiful");
            Tooltip purebloodElfTooltip = new Tooltip("Pureblood Elf");
            Tooltip daisyOfTheValleyTooltip = new Tooltip("Daisy Of The Valley");
            Tooltip queenOfDolBlathannaTooltip = new Tooltip("Queen Of Dol Blathanna");
            Tooltip hopeOfTheAenSeidheTooltip = new Tooltip("Hope Of The Aen Seidhe");
            Tooltip.install(theBeautiful, theBeautifulTooltip);
            Tooltip.install(pureBloodElf, purebloodElfTooltip);
            Tooltip.install(daisyOfTheValley, daisyOfTheValleyTooltip);
            Tooltip.install(queenOfDolBlathanna, queenOfDolBlathannaTooltip);
            Tooltip.install(hopeOfTheAenSeidhe, hopeOfTheAenSeidheTooltip);
        }
        if (PreGame.getTurn().getFaction().getName().equals(Faction.SKELLIGE.getName())) {
            disableMonsters();
            disableNorthernRealms();
            disableNilfgaard();
            disableScoiatael();
            Tooltip crachAnCraiteTooltip = new Tooltip("Crach An Craite");
            Tooltip kingBranTooltip = new Tooltip("King Bran");
            Tooltip.install(crachAnCraite, crachAnCraiteTooltip);
            Tooltip.install(kingBran, kingBranTooltip);
        }
    }

    public void bringerOfDeath(MouseEvent mouseEvent) {
        notify.setText("You chose \"Bringer Of Death\" as your leader");
        //player.setLeader();
    }

    public void kingOfTheWildHunt(MouseEvent mouseEvent) {
        notify.setText("You chose \"King Of The Wild Hunt\" as your leader");
        //player.setLeader();
    }

    public void destroyerOfWorlds(MouseEvent mouseEvent) {
        notify.setText("You chose \"Destroyer Of Worlds\" as your leader");
        //player.setLeader();
    }

    public void commanderOfTheRedRiders(MouseEvent mouseEvent) {
        notify.setText("You chose \"Commander Of The Red Riders\" as your leader");
        //player.setLeader();
    }

    public void theTracherous(MouseEvent mouseEvent) {
        notify.setText("You chose \"The Tracherous\" as your leader");
        //player.setLeader();
    }

    public void theRelentless(MouseEvent mouseEvent) {
        notify.setText("You chose \"The Relentless\" as your leader");
        //player.setLeader();
    }

    public void theWhiteFlame(MouseEvent mouseEvent) {
        notify.setText("You chose \"The White Flame\" as your leader");
        //player.setLeader();
    }

    public void invaderOfTheNorth(MouseEvent mouseEvent) {
        notify.setText("You chose \"Invader Of The North\" as your leader");
        //player.setLeader();
    }

    public void hisImperialMajesty(MouseEvent mouseEvent) {
        notify.setText("You chose \"His Imperial Majesty\" as your leader");
        //player.setLeader();
    }

    public void emperorOfNilfgaard(MouseEvent mouseEvent) {
        notify.setText("You chose \"Emperor Of Nilfgaard\" as your leader");
        //player.setLeader();
    }

    public void lordCommanderOfTheNorth(MouseEvent mouseEvent) {
        notify.setText("You chose \"Lord Of The North\" as your leader");
        //player.setLeader();
    }

    public void theSteelForged(MouseEvent mouseEvent) {
        notify.setText("You chose \"The Steel-Forged\" as your leader");
        //player.setLeader();
    }

    public void theSiegmaster(MouseEvent mouseEvent) {
        notify.setText("You chose \"The Siegmaster\" as your leader");
        //player.setLeader();
    }

    public void sonOfMedell(MouseEvent mouseEvent) {
        notify.setText("You chose \"Son Of Medell\" as your leader");
        //player.setLeader();
    }

    public void kingOfTemeria(MouseEvent mouseEvent) {
        notify.setText("You chose \"King Of Temeria\" as your leader");
        //player.setLeader();
    }

    public void pureBloodElf(MouseEvent mouseEvent) {
        notify.setText("You chose \"Pureblood Elf\" as your leader");
        //player.setLeader();
    }

    public void queenOfDolBlathanna(MouseEvent mouseEvent) {
        notify.setText("You chose \"Queen Of Dol Blathanna\" as your leader");
        //player.setLeader();
    }

    public void hopeOfTheAenSeidhe(MouseEvent mouseEvent) {
        notify.setText("You chose \"Hope Of The Aen Seidhe\" as your leader");
        //player.setLeader();
    }

    public void daisyOfTheValley(MouseEvent mouseEvent) {
        notify.setText("You chose \"Daisy Of The Valley\" as your leader");
        //player.setLeader();
    }

    public void theBeautiful(MouseEvent mouseEvent) {
        notify.setText("You chose \"The Beautiful\" as your leader");
        //player.setLeader();
    }

    public void crachAnCraite(MouseEvent mouseEvent) {
        notify.setText("You chose \"Crach An Craite\" as your leader");
        //player.setLeader();
    }

    public void kingBran(MouseEvent mouseEvent) {
        notify.setText("You chose \"King Bran\" as your leader");
        //player.setLeader();
    }

    private void disableMonsters(){
        theTracherous.setVisible(false);
        commanderOfTheRedRiders.setVisible(false);
        destroyerOfWorlds.setVisible(false);
        kingOfTheWildHunt.setVisible(false);
        bringerOfDeath.setVisible(false);
    }

    private void disableNorthernRealms(){
        kingOfTemeria.setVisible(false);
        lordCommanderOfTheNorth.setVisible(false);
        theSteelForged.setVisible(false);
        theSiegmaster.setVisible(false);
        sonOfMedell.setVisible(false);
    }

    private void disableNilfgaard(){
        theRelentless.setVisible(false);
        theWhiteFlame.setVisible(false);
        invaderOfTheNorth.setVisible(false);
        hisImperialMajesty.setVisible(false);
        emperorOfNilfgaard.setVisible(false);
    }

    private void disableScoiatael(){
        theBeautiful.setVisible(false);
        pureBloodElf.setVisible(false);
        daisyOfTheValley.setVisible(false);
        queenOfDolBlathanna.setVisible(false);
        hopeOfTheAenSeidhe.setVisible(false);
    }

    public void disableSkellige(){
        crachAnCraite.setVisible(false);
        kingBran.setVisible(false);
    }

    public void back(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
