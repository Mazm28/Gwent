package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.PreGame;
import Enums.Factions;

import java.io.IOException;

public class FactionsMenu {
    public Label notify;
    public Button back;

    public void monsters(MouseEvent mouseEvent) {
        notify.setText("You chose \"Monsters\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.MONSTERS.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.MONSTERS.getName());
    }

    public void scoiatael(MouseEvent mouseEvent) {
        notify.setText("You chose \"Scoia'tael\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.SCOIATAEL.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.SCOIATAEL.getName());

    }

    public void skellige(MouseEvent mouseEvent) {
        notify.setText("You chose \"Skellige\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.SKELLIGE.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.SKELLIGE.getName());
    }

    public void syndicate(MouseEvent mouseEvent) {
        notify.setText("You chose \"Syndicate\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.SYNDICATE.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.SYNDICATE.getName());
    }

    public void norhernRealms(MouseEvent mouseEvent) {
        notify.setText("You chose \"Northern Realms\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.NORTHERN_REALMS.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.NORTHERN_REALMS.getName());
    }

    public void nilfgaard(MouseEvent mouseEvent) {
        notify.setText("You chose \"Nilfgaard\" as your faction");
        if(PreGame.getTurn().equals(PreGame.getPlayer1()))
            PreGame.getPlayer1().setFaction(Factions.NILFGAARD.getName());
        else
            PreGame.getPlayer2().setFaction(Factions.NILFGAARD.getName());
    }

    public void back(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene("/FXML/PreGameMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}