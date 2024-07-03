package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Deck;
import model.PreGame;
import Enums.Faction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FactionsMenu implements Initializable {
    @FXML
    private Label notify;
    @FXML
    private Button back;
    @FXML
    private ImageView monsters;
    @FXML
    private ImageView scoiatael;
    @FXML
    private ImageView skellige;
    @FXML
    private ImageView northernRealms;
    @FXML
    private ImageView nilfgaard;

    public void monsters(MouseEvent mouseEvent) {
        notify.setText("You chose \"Monsters\" as your faction");
        PreGame.getTurn().setFaction(Faction.MONSTERS);
        PreGame.getTurn().setDeck(new Deck());
        PreGame.getTurn().getDeck().setFaction(Faction.MONSTERS);
        PreGame.getTurn().getDeck().setLeaderCard(null);
        PreGame.getTurn().setLeader(null);
        PreGame.getTurn().getDeck().setCards(new ArrayList<>());
    }

    public void scoiatael(MouseEvent mouseEvent) {
        notify.setText("You chose \"Scoia'tael\" as your faction");
        PreGame.getTurn().setFaction(Faction.SCOIATAEL);
        PreGame.getTurn().setDeck(new Deck());
        PreGame.getTurn().getDeck().setFaction(Faction.SCOIATAEL);
        PreGame.getTurn().getDeck().setLeaderCard(null);
        PreGame.getTurn().setLeader(null);
        PreGame.getTurn().getDeck().setCards(new ArrayList<>());

    }

    public void skellige(MouseEvent mouseEvent) {
        notify.setText("You chose \"Skellige\" as your faction");
        PreGame.getTurn().setFaction(Faction.SKELLIGE);
        PreGame.getTurn().setDeck(new Deck());
        PreGame.getTurn().getDeck().setFaction(Faction.SKELLIGE);
        PreGame.getTurn().getDeck().setLeaderCard(null);
        PreGame.getTurn().setLeader(null);
        PreGame.getTurn().getDeck().setCards(new ArrayList<>());
    }

    public void norhernRealms(MouseEvent mouseEvent) {
        notify.setText("You chose \"Northern Realms\" as your faction");
        PreGame.getTurn().setFaction(Faction.NORTHERN_REALMS);
        PreGame.getTurn().setDeck(new Deck());
        PreGame.getTurn().getDeck().setFaction(Faction.NORTHERN_REALMS);
        PreGame.getTurn().getDeck().setLeaderCard(null);
        PreGame.getTurn().setLeader(null);
        PreGame.getTurn().getDeck().setCards(new ArrayList<>());
    }

    public void nilfgaard(MouseEvent mouseEvent) {
        notify.setText("You chose \"Nilfgaard\" as your faction");
        PreGame.getTurn().setFaction(Faction.NILFGAARD);
        PreGame.getTurn().setDeck(new Deck());
        PreGame.getTurn().getDeck().setFaction(Faction.NILFGAARD);
        PreGame.getTurn().getDeck().setLeaderCard(null);
        PreGame.getTurn().setLeader(null);
        PreGame.getTurn().getDeck().setCards(new ArrayList<>());
    }

    public void back(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip monstersTooltip = new Tooltip("Monsters");
        Tooltip scoiataelTooltip = new Tooltip("Scoia'tael");
        Tooltip skelligeTooltip = new Tooltip("Skellige");
        Tooltip northernRealmsTooltip = new Tooltip("Northern Realms");
        Tooltip nilfgaardTooltip = new Tooltip("Nilfgaard");
        Tooltip.install(monsters, monstersTooltip);
        Tooltip.install(scoiatael, scoiataelTooltip);
        Tooltip.install(skellige, skelligeTooltip);
        Tooltip.install(northernRealms, northernRealmsTooltip);
        Tooltip.install(nilfgaard, nilfgaardTooltip);
    }
}