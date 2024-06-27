package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.PreGame;
import Enums.Faction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FactionsMenu implements Initializable {
    @FXML
    private Label hoverLabel;
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
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Faction.MONSTERS);
        else
            PreGame.getPlayer2().setFaction(Faction.MONSTERS);
    }

    public void scoiatael(MouseEvent mouseEvent) {
        notify.setText("You chose \"Scoia'tael\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Faction.SCOIATAEL);
        else
            PreGame.getPlayer2().setFaction(Faction.SCOIATAEL);

    }

    public void skellige(MouseEvent mouseEvent) {
        notify.setText("You chose \"Skellige\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Faction.SKELLIGE);
        else
            PreGame.getPlayer2().setFaction(Faction.SKELLIGE);
    }

    public void norhernRealms(MouseEvent mouseEvent) {
        notify.setText("You chose \"Northern Realms\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Faction.NORTHERN_REALMS);
        else
            PreGame.getPlayer2().setFaction(Faction.NORTHERN_REALMS);
    }

    public void nilfgaard(MouseEvent mouseEvent) {
        notify.setText("You chose \"Nilfgaard\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Faction.NILFGAARD);
        else
            PreGame.getPlayer2().setFaction(Faction.NILFGAARD);
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