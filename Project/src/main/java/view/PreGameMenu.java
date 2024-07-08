package view;

import Enums.FXMLAddresses;
import Enums.Faction;
import controller.ActionController;
import controller.MainMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.App;
import model.CardCollection;
import model.Game;
import model.PreGame;

import java.io.IOException;
import java.util.Optional;

public class PreGameMenu {
    @FXML
    private Button readyButton;
    @FXML
    private Button showFactionsButton;
    @FXML
    private Button showCardsButton;
    @FXML
    private Button showDeckButton;
    @FXML
    private Button showLeadersButton;
    @FXML
    private Label turnText = new Label();
    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        if (PreGame.getTurn().equals(PreGame.getPlayer1()))
            turnText.setText(PreGame.getPlayer1().getUsername() + "'s turn\n\n" + PreGame.getPlayer1().getUsername() + " is not ready\n" + PreGame.getPlayer2().getUsername() + " is not ready");
        else
            turnText.setText(PreGame.getPlayer2().getUsername() + "'s turn\n\n" + PreGame.getPlayer1().getUsername() + " is ready\n" + PreGame.getPlayer2().getUsername() + " is not ready");
        if(PreGame.getTurn().getFaction() != null) showLeadersButton.setDisable(false);
        if(PreGame.getTurn().getLeader() != null) showCardsButton.setDisable(false);
        if(CardCollection.getUnitCards(PreGame.getTurn().getDeck().getCards()).size() >= 22) readyButton.setDisable(false);
    }

    public void ready(MouseEvent mouseEvent) {
        if (PreGame.getTurn().equals(PreGame.getPlayer2())) {
                try {
                    if(PreGame.getPlayer1().getFaction().equals(Faction.SCOIATAEL) && PreGame.getPlayer2().getFaction().equals(Faction.SCOIATAEL)){
                        App.setGame(new Game(PreGame.getPlayer1(), PreGame.getPlayer2()));
                        Launcher.changeScene(FXMLAddresses.STARTING_GAME_MENU.getAddress());
                    }
                    else if(PreGame.getPlayer1().getFaction().equals(Faction.SCOIATAEL) || PreGame.getPlayer2().getFaction().equals(Faction.SCOIATAEL)){
                        Launcher.changeScene(FXMLAddresses.CHOOSE_FIRST_PLAYER.getAddress());
                    } else {
                        App.setGame(new Game(PreGame.getPlayer1(), PreGame.getPlayer2()));
                        Launcher.changeScene(FXMLAddresses.STARTING_GAME_MENU.getAddress());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } else {
            PreGame.setUserTurn(PreGame.getUser2());
            PreGame.setTurn(PreGame.getPlayer2());
            try {
                Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showFactions() {
        try {
            Launcher.changeScene(FXMLAddresses.FACTION_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCards(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.CARDS_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDeck(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.DECK_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLeaders(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.LEADER_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mainMenu(MouseEvent mouseEvent) {
        MainMenuController.lunchMainMenu();
    }
}